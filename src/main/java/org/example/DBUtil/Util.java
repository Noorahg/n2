package org.example.DBUtil;

import java.sql.*;
public class Util {

        private static final String DB_DRIVER = "org.postgresql.Driver";
        private static final String DB_URL = "jdbc:postgresql://localhost:5433/mydonut_data";
        private static final String DB_USERNAME = "postgres";
        private static final String DB_PASSWORD = "gulnur";

        public Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                System.out.println("Connection OK");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Connection ERROR");
            }
            return connection;
        }

    }
