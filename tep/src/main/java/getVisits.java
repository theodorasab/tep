/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TEPDB.Examinations;
import TEPDB.Patient;
import TEPDB.TEPDB;
import TEPDB.UserTepDB;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author theodora
 */
@WebServlet(urlPatterns = {"/getVisits"})
public class getVisits extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        List<Patient> patients = new ArrayList();
        Statement stmt = null;
        Connection con = null;
        List<Examinations> exams = new ArrayList();
        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append(request.getParameter("visits"));

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next()) {
                Examinations exam = new Examinations();
                Patient patient = new Patient();
                exam.setDiagnose(res.getString("diagnose"));
                exam.setPrescription(res.getString("prescription"));
                exam.setTherapy(res.getString("therapy"));
                patient.setFull_name(res.getString("full_name"));
                patient.setAMKA(Integer.parseInt(res.getString("amka")));
                patient.setDoctor(res.getString("doctor"));
                exams.add(exam);
                patients.add(patient);

            }
            JSONArray patientsv = new JSONArray();
            JSONArray examsv = new JSONArray();
            for (int i = 0; i < patients.size(); i++) {
                patientsv.put(patients.get(i));
            }
            for (int i = 0; i < exams.size(); i++) {
                examsv.put(exams.get(i));
            }

            JSONObject visits = new JSONObject();
            try {
                visits.put("patients", patientsv);
                visits.put("exams", examsv);
                response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
                response.setStatus(200);
                String res1 = new Gson().toJson(visits);
                response.getWriter().write(res1);
                response.getWriter().flush();
                response.getWriter().close();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getVisits.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getVisits.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getVisits.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getVisits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
