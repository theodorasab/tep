/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

import java.sql.Connection;

/**
 *
 * @author evach
 */
import java.sql.PreparedStatement;
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
public class ShiftDB {

    public static List<Shift> getShiftByDate(String date) throws ClassNotFoundException, SQLException {
        List<Shift> shifts = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM shift ")
                    .append(" WHERE ")
                    .append(" date = ").append("'").append(date).append("';");

            stmt.execute(insQuery.toString());
            ResultSet res = stmt.getResultSet();
            while (res.next() == true) {
                Shift shift = new Shift();
                shift.setFull_name(res.getString("full_name"));
                shift.setAT(res.getString("AT"));
                shift.setDate(date);
                shift.setHours(res.getString("hours"));
                shift.setProfession(res.getString("proffession"));
                shifts.add(shift);

            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return shifts;
    }

    public static void insertShift(Shift shift) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {
//            Date date = new Date();
//            Timestamp timestamp = new Timestamp(date.getTime());

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" shift (AT, full_name, proffession, date, "
                            + "hours) ")
                    .append(" VALUES (")
                    .append("'").append(shift.getAT()).append("',")
                    .append("'").append(shift.getFull_name()).append("',")
                    .append("'").append(shift.getProfession()).append("',")
                    .append("'").append(shift.getDate()).append("',")
                    .append("'").append(shift.getHours()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            // Get information magically completed from database
            System.out.println("#DB: The member " + shift.getFull_name() + "  was successfully added in the database.");

        } catch (SQLException ex) {
            System.out.println("sql ex");
            // Log exception
            Logger.getLogger(TEPDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

    }

    public static void createShift() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {

            String sql = "CREATE TABLE SHIFT "
                    + "(AT VARCHAR(255), "
                    + " full_name VARCHAR(255), "
                    + " profession VARCHAR(255), "
                    + " proffession VARCHAR(255), "
                    + " date VARCHAR(255), "
                    + " hours VARCHAR(255), "
                    + " PRIMARY KEY ( AT ))";

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
