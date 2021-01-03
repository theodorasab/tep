/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TEPDB.Examinations;
import TEPDB.PatientDB;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        exam.setAMKA(amka);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        exam.setDate(strDate);
        exam.setDiagnose(request.getParameter("diagnose"));
        exam.setExam_order(request.getParameter("exam_order"));
        if (request.getParameter("prescription") == "") {
            exam.setPrescription("");
        } else {
            exam.setPrescription(request.getParameter("prescription"));
            PatientDB.setPrescription(exam, request.getParameter("prescription"));

        }
        if (request.getParameter("repost") == "") {
            exam.setReport("");
        } else {
            exam.setReport(request.getParameter("report"));
        }
        if (request.getParameter("therapy") == "") {
            exam.setTherapy("");
        } else {
            flag = false;
            exam.setTherapy(request.getParameter("therapy"));
        }
        if (flag == true) {
            PatientDB.insertExaminations(exam);
        } else {
            PatientDB.setTherapy(exam, request.getParameter("therapy"));
            System.out.println(exam.getTherapy());

        }
        response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        response.setStatus(200);
        String res = new Gson().toJson(exam);
        System.out.println(PatientDB.getPatientWithAmka(Integer.parseInt(request.getParameter("amka"))));
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
