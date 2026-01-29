package com.revconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String URL =
<<<<<<< HEAD
<<<<<<< HEAD
            "jdbc:oracle:thin:@//127.0.0.1:1521/ORCLPDB";
=======
            "jdbc:oracle:thin:@localhost:1521/XEPDB1";
>>>>>>> dev
=======
            "jdbc:oracle:thin:@localhost:1521/XEPDB1";
>>>>>>> 788343f9b12e257db22e3d4dda189bd77f0904e8
    private static final String USERNAME = "revconnect";
    private static final String PASSWORD = "revconnect123";

    public static Connection getConnection() {
<<<<<<< HEAD
<<<<<<< HEAD
=======

        Connection con = null;
>>>>>>> 788343f9b12e257db22e3d4dda189bd77f0904e8
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
<<<<<<< HEAD
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
=======
>>>>>>> 788343f9b12e257db22e3d4dda189bd77f0904e8
