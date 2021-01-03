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
public class Patient {

    private int amka;    // (unique)
    private String full_name;    // (could be encrypted in md5)
    private String address;
    private String diseases;    // (could be encrypted in md5)
    private String insurance;
    private String selected_symptoms;
    private String symptoms;
    private String doctor;
    private String report;

    /**
     * Default Constructor
     *
     */
    public Patient() {
        this.address = "";
        this.diseases = "";
        this.full_name = "";
        this.insurance = "";
        this.selected_symptoms = "";
        this.symptoms = "";
        this.amka = 0;
        this.doctor = "";
        this.report = "";
    }

    public Patient(String address,
            String diseases,
            String full_name, String insurance, int amka, String selected_symptoms, String symptoms, String doctor, String report) {
        this.address = address;
        this.diseases = diseases;
        this.full_name = full_name;
        this.insurance = insurance;
        this.selected_symptoms = selected_symptoms;
        this.symptoms = symptoms;
        this.amka = amka;
        this.doctor = doctor;
        this.report = report;

    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    /**
     * Get the password
     *
     * @return
     */
    public String getDiseases() {
        return diseases;
    }

    /**
     * Set the password of this user
     *
     * @param password
     */
    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    /**
     * Returns the first name of the user
     *
     * @return
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * Sets the first name
     *
     * @param firstName
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getInsurance() {
        return insurance;
    }

    /**
     * Sets the first name
     *
     * @param firstName
     */
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getAMKA() {
        return amka;
    }

    public void setAMKA(int amka) {
        this.amka = amka;
    }


    public String getSelectedSymptoms() {
        return selected_symptoms;
    }

    public void setSelectedSymptoms(String selected_symptoms) {
        this.selected_symptoms = selected_symptoms;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
