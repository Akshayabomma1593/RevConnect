package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521/XEPDB1";

    private static final String USERNAME = "revconnect";
    private static final String PASSWORD = "revconnect123";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
