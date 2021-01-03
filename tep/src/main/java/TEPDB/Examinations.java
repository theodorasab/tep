/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

/**
 *
 * @author theodora
 */
public class Examinations {

    private int amka;    // (unique)
    private String diagnose;
    private String exam_order;
    private String prescription;
    private String report;
    private String therapy;
    private String date;

    /**
     * Default Constructor
     *
     */
    public Examinations() {
        this.diagnose = "";
        this.exam_order = "";
        this.prescription = "";
        this.report = "";
        this.therapy = "";
        this.amka = 0;
        this.date = "";

    }

    public Examinations(String diagnose,
            String exam_order,
            String prescription, String report, int amka, String therapy, String date) {
        this.diagnose = diagnose;
        this.exam_order = exam_order;
        this.prescription = prescription;
        this.report = report;
        this.therapy = therapy;
        this.amka = amka;
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getExam_order() {
        return exam_order;
    }

    public void setExam_order(String exam_order) {
        this.exam_order = exam_order;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public int getAMKA() {
        return amka;
    }

    public void setAMKA(int amka) {
        this.amka = amka;
    }

}
