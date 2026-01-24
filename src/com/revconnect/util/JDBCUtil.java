package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
            "jdbc:mysql://localhost:3306/revconnect";
    private static final String USER = "root";
    private static final String PASSWORD = "Hema@123";


    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
