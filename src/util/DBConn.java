package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static Connection dbConn;

    public static Connection getConnection() {
        try {
            if (dbConn == null) {
                String url = "jdbc:oracle:thin:@hb-database.cl6k8mkm2m29.us-east-1.rds.amazonaws.com:1521:ORCL";
                String user = "admin";
                String pwd = "admin1234";

                Class.forName("oracle.jdbc.driver.OracleDriver");
                dbConn = DriverManager.getConnection(url, user, pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbConn;
    }

    public static void close() {
        try {
            if (dbConn != null) {
                if (!dbConn.isClosed()) {
                    dbConn.close();
                }
            }
            dbConn = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
