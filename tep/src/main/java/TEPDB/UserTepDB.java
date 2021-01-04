/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author theodora
 */
public class UserTepDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //create a table for users that login
        ShiftDB.createShift();
        //PatientDB.createPatientTable();
//        PatientDB.createExaminationTable();
        //        createUserTable();
//        insertUser();
    }

    public static List<User> getUsers() throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM users;");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                User user = new User();
                user.setUserName(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setMedicine(res.getString("medicine"));
                users.add(user);
            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

        return users;
    }

    public static void insertUser() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();

        try {
            String sql = "INSERT INTO Users "
                    + "VALUES (201, 'theo', 'nurse')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Users "
                    + "VALUES (202, 'eva', 'employee')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Users "
                    + "VALUES (203, 'emma', 'pediatrician')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Users "
                    + "VALUES(204, 'ellie', 'patient')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Users "
                    + "VALUES (205, 'niki', 'surgeon')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Users "
                    + "VALUES (206, 'maria', 'cardiologist')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Users "
                    + "VALUES(207, 'eleni', 'ophthalmologist')";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Users "
                    + "VALUES(208, 'lala', 'pathologist')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }

    public static void createUserTable() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {

            String sql = "CREATE TABLE USERS "
                    + "(password INTEGER not NULL, "
                    + " username VARCHAR(255), "
                    + " medicine VARCHAR(255), "
                    + " PRIMARY KEY ( password ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        System.out.println(
                "Goodbye!");
    }

}
