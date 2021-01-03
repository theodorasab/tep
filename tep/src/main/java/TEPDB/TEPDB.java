package TEPDB;

import java.sql.*;

/**
 *
 * @author theodora
 */
public class TEPDB {

    private static final String URL = "jdbc:mysql://localhost:3306/tep";
    private static final String DATABASE = "tep";
    private static final int PORT = 3306;
    private static final String UNAME = "root";
    private static final String PASSWD = "";

    /**
     * Attempts to establish a database connection Using mariadb
     *
     * @return a connection to the database
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tep", "root", "");
        return con;
    }

    public static String getUserName() {
        return UNAME;
    }

}
