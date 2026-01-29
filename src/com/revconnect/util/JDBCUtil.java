package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
<<<<<<< HEAD
            "jdbc:oracle:thin:@//127.0.0.1:1521/ORCLPDB";
=======
            "jdbc:oracle:thin:@localhost:1521/XEPDB1";
>>>>>>> dev
    private static final String USERNAME = "revconnect";
    private static final String PASSWORD = "revconnect123";

    public static Connection getConnection() {
<<<<<<< HEAD
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("❌ Database connection failed", e);
        }
    }
}
=======

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
>>>>>>> dev
