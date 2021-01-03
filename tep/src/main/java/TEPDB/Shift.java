/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

public class Shift {

    private String AT;    // (unique)
    private String full_name;    // (could be encrypted in md5)
    private String profession;
    private String date;    // (could be encrypted in md5)
    private String hours;

    public Shift() {
        this.profession = "";
        this.date = "";
        this.full_name = "";
        this.hours = "";
        this.AT = "";
    }

    public Shift(String profession,
            String date,
            String full_name, String AT, String hours) {
        this.profession = profession;
        this.date = date;
        this.full_name = full_name;
        this.hours = hours;
        this.AT = AT;

    }

    public String getAT() {
        return AT;
    }

    public void setAT(String AT) {
        this.AT = AT;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
