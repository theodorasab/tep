/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

import java.io.Serializable;

/**
 *
 * @author theodora
 */
public class User implements Serializable {

    private String username;    // (unique)
    private String password;    // (could be encrypted in md5)
    private String medicine;

    /**
     * Default Constructor
     *
     */
    public User() {
        this.username = "";
        this.password = "";
        this.medicine = "";
    }

    /**
     * Constructor
     *
     * @param username
     * @param password
     * @param medicine
     */
    public User(String username,
            String password,
            String medicine) {
        this.username = username;
        this.password = password;
        this.medicine = medicine;
    }

    /**
     * Get the user name
     *
     * @return
     */
    public String getUserName() {
        return username;
    }

    /**
     * Set the username
     *
     * @param userName
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * Get the password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of this user
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the first name of the user
     *
     * @return
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * Sets the first name
     *
     * @param firstName
     */
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

//        /**
//         * Returns string representation of value
//         *
//         * @return
//         */
//        @Override
//        public String toString() {
//            return this.value;
//        }
//    }
    /**
     * Returns a string representation of this object
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User Name: ").append(username).append("\n")
                .append("password: ").append(password).append("\n")
                .append("Medicine: ").append(medicine).append("\n");

        return sb.toString();

    }

}
