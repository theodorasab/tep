/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TEPDB.Drug;
import TEPDB.Examinations;
import TEPDB.Patient;
import TEPDB.PatientDB;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
@WebServlet(name = "addDiagnose", urlPatterns = {"/addDiagnose"})
public class addDiagnose extends HttpServlet {

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
        boolean flag = true;
        Examinations exam = new Examinations();
        int amka = Integer.parseInt(request.getParameter("amka"));
        exam.setAMKA(amka);
        Random rand = new Random();
        exam.setNum(rand.nextInt(7000));
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        exam.setDate(strDate);
        exam.setExam_order(request.getParameter("exam_order"));
        Drug drug = new Drug();
        if (request.getParameter("doseph") != "") {
        drug.setAMKA(amka);
        drug.setDate(strDate);
        drug.setDose(request.getParameter("doseph"));
        drug.setIllness(request.getParameter("illnessph"));
        drug.setName(request.getParameter("nameph"));
        drug.setType(request.getParameter("typeph"));
            Random rand1 = new Random();
            drug.setNum(rand1.nextInt(2000));
            PatientDB.insertDrug(drug);
        }
        if (request.getParameter("diagnose") == "") {
            exam.setDiagnose("");
        } else {
            exam.setDiagnose(request.getParameter("diagnose"));
            PatientDB.setDiagnose(exam, request.getParameter("diagnose"));

        }
        if (request.getParameter("prescription") == "") {
            exam.setPrescription("");
        } else {

                exam.setPrescription(request.getParameter("prescription"));
            PatientDB.setPrescription(exam, request.getParameter("prescription"));
        }
        if (request.getParameter("report") == "") {
            exam.setReport("");
        } else {
            exam.setReport(request.getParameter("report"));
        }
        if (request.getParameter("therapy") == "") {
            exam.setTherapy("");
        } else {
            exam.setTherapy(request.getParameter("therapy"));
                PatientDB.setTherapy(exam, request.getParameter("therapy"));
        }

        Patient patient = PatientDB.getPatientWithAmka(amka);
        if (request.getParameter("diagnose") == "" && request.getParameter("exam_order") != "") { // paei gia epaneksetash
            PatientDB.setDone(patient, "no");
            PatientDB.insertExaminations(exam);
        } else if (request.getParameter("diagnose") != "" && request.getParameter("exam_order") != "") { // egine h epaneksetash
            PatientDB.setDone(patient, "yes");
            exam.setDiagnose(request.getParameter("diagnose"));
            PatientDB.setDiagnose(exam, request.getParameter("diagnose"));
        } else if (request.getParameter("diagnose") != "" && request.getParameter("exam_order") == "") { //diagnwsh kai teleiwse
            PatientDB.setDone(patient, "yes");
            PatientDB.insertExaminations(exam);
        }

        response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        response.setStatus(200);
        String res = new Gson().toJson(exam);
        response.getWriter().write(res);
        response.getWriter().flush();
        response.getWriter().close();
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
            Logger.getLogger(addDiagnose.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addDiagnose.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addDiagnose.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addDiagnose.class.getName()).log(Level.SEVERE, null, ex);
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
