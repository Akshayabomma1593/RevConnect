package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
            "jdbc:mysql://localhost:3306/revconnect?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";        // your MySQL username
    private static final String PASSWORD = "Hema@123"; // your MySQL password

    public static Connection getConnection() {

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Return connection
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Database connection failed");
        }
    }
}
