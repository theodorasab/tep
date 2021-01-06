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
public class Drug {
    private int num;    // (unique)
    private int amka;
    private String name;
    private String type;
    private String dose;
    private String illness;
    private String date;

    /**
     * Default Constructor
     *
     */
    public Drug() {
        this.amka = 0;
        this.name = "";
        this.type = "";
        this.dose = "";
        this.illness = "";
        this.num = 0;
        this.date = "";

    }

    public Drug(int amka,
            String name,
            String type, String dose, int num, String illness, String date) {
        this.amka = amka;
        this.name = name;
        this.type = type;
        this.dose = dose;
        this.illness = illness;
        this.num = num;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTyoe() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getAMKA() {
        return amka;
    }

    public void setAMKA(int amka) {
        this.amka = amka;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
