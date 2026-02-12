package com.okesalon.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/db_oke_salon";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi database berhasil!");
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver tidak ditemukan!");
            System.err.println("Pastikan library mysql-connector-java sudah ditambahkan ke project.");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Koneksi database gagal!");
            System.err.println("Periksa URL, username, dan password database.");
            e.printStackTrace();
        }
        
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menutup koneksi database.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = koneksi.getConnection();
        if (conn != null) {
            System.out.println("Koneksi berhasil diuji!");
            closeConnection();
        } else {
            System.out.println("Koneksi gagal!");
        }
    }
}