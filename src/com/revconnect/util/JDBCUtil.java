package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
            "jdbc:oracle:thin:@//127.0.0.1:1521/ORCLPDB";
    private static final String USERNAME = "revconnect";
    private static final String PASSWORD = "revconnect123";

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("❌ Database connection failed", e);
        }
    }
}
