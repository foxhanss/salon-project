package com.okesalon.dao;
import com.okesalon.util.koneksi;
import java.sql.*;

public class LoginDAO {
    public static class UserData {
        public Integer userId;
        public String username;
        public String namaLengkap;
        public String role;
        public String status;
        
        public UserData() {}
    }

    public UserData authenticate(String username, String password, String role) throws Exception {
        String sql = "SELECT id_user, username, password, nama_lengkap, role, status " +
                     "FROM user_login " +
                     "WHERE username = ? AND password = ? AND role = ? AND status = 'Aktif'";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserData user = new UserData();
                    user.userId = rs.getInt("id_user");
                    user.username = rs.getString("username");
                    user.namaLengkap = rs.getString("nama_lengkap");
                    user.role = rs.getString("role");
                    user.status = rs.getString("status");
                    
                    return user;
                }
            }
        }
        
        return null;
    }

    public void updateLastLogin(Integer userId) throws Exception {
        String sql = "UPDATE user_login SET updated_at = NOW() WHERE id_user = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }
}
