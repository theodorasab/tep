/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TEPDB.Patient;
import TEPDB.PatientDB;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author theodora
 */
@WebServlet(urlPatterns = {"/addPatient"})
public class addPatient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Patient patient = new Patient();
        int amka = Integer.parseInt(request.getParameter("amka"));
        patient.setAMKA(amka);
        patient.setAddress(request.getParameter("address"));
        patient.setDiseases(request.getParameter("diseases"));
        patient.setFull_name(request.getParameter("full_name"));
        patient.setInsurance(request.getParameter("insurance"));
        patient.setSelectedSymptoms(request.getParameter("selected_symptoms"));
        patient.setSymptoms(request.getParameter("symptoms"));
        patient.setDoctor("");
        patient.setReport("");


        try {
            if (PatientDB.getPatientWithAmka(amka).getAMKA() == 0) {

                PatientDB.insertPatient(patient);

                response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_OK);
                String res = new Gson().toJson(patient);
                response.getWriter().write(res);
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                PatientDB.updatePatient(patient);

                response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
                response.setStatus(400);
                String res = new Gson().toJson(patient);
//                System.out.println(PatientDB.getPatientWithAmka(Integer.parseInt(request.getParameter("amka"))));
                response.getWriter().write(res);
                response.getWriter().flush();
                response.getWriter().close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {

            Logger.getLogger(addPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
