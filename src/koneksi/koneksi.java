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

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/salon";
        String user = "root";
        String password = ""; // kosongkan jika tidak pakai password

        return DriverManager.getConnection(url, user, password);
    }
    private Connection koneksi;

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver baru
            String url = "jdbc:mysql://localhost:3306/salon?serverTimezone=UTC";
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil Koneksi Database");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver tidak ditemukan: " + ex);
        } catch (SQLException ex) {
            System.out.println("Gagal koneksi ke database: " + ex);
        }
        return koneksi;
    }

    // METHOD MAIN UNTUK TESTING
    public static void main(String[] args) {
        koneksi db = new koneksi();
        Connection conn = db.connect();
        if (conn != null) {
            System.out.println("Koneksi ke database berhasil dijalankan di main method.");
        } else {
            System.out.println("Koneksi ke database gagal dijalankan di main method.");
        }
    }
}
