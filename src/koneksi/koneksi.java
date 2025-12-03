/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author T480
 */
public class koneksi {

    // Konfigurasi database
    private static final String URL = "jdbc:mysql://localhost:3306/db_oke_salon";
    private static final String USER = "root";        // Sesuaikan dengan user MySQL Anda
    private static final String PASSWORD = "";        // Sesuaikan dengan password MySQL Anda
    
    // Connection object
    private static Connection connection = null;
    
    /**
     * Method untuk mendapatkan koneksi database
     */
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Buat koneksi baru jika belum ada atau sudah ditutup
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
    
    /**
     * Method untuk menutup koneksi database
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Gagal menutup koneksi database.");
            e.printStackTrace();
        }
    }
    
    /**
     * Method untuk testing koneksi
     */
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
