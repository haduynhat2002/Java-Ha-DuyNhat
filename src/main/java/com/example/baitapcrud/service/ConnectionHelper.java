package com.example.baitapcrud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Làm nhiệm đảm bảo duy nhất một kết nối đến database.
 */
public class ConnectionHelper {

    private static Connection connection;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/t2009m1";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    public static Connection getConnection() {
        try {
            if (connection ==  null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                System.out.println("Connection success!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection fail!");
            throw new RuntimeException(e);
        }
        return connection;
    }
}
