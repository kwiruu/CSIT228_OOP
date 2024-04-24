package com.example.csit228_f1_v2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createuserTable() {
        try (Connection c = MySQLConnection.getConnection()) {
            String query = "CREATE TABLE IF NOT EXISTS tblaccounts (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) NOT NULL," +
                    "address VARCHAR(100) NOT NULL)";
            try {
                Statement statement = c.createStatement();
                statement.execute(query);
                System.out.println("Accounts table created successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createUserTable() {
        try (Connection c = MySQLConnection.getConnection()) {
            String query = "CREATE TABLE IF NOT EXISTS tblusers (" +
                    "user_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "id_fk INT NOT NULL," +
                    "FOREIGN KEY (id_fk) REFERENCES tblaccounts(id))";
            try {
                Statement statement = c.createStatement();
                statement.execute(query);
                System.out.println("Users table created successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

