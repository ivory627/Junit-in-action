package com.study.junit.ch14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static Connection openConnection() {

        try {
            Class.forName("org.h2.Driver"); // H2 드라이버
            connection = DriverManager.getConnection("jdbc:h2:~/passenger",
                    "sa", // 아이디
                    "" // 비밀번호
            );
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}