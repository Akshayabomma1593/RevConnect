package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
            "jdbc:oracle:thin:@db.freesql.com:1521/23ai_34ui2";
    private static final String USERNAME = "GOWTHAMREDDY20201_SCHEMA_AG8XG";
    private static final String PASSWORD = "17MUGKJHCB7NX5FF4OBTAKDz4T7X!T";

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
