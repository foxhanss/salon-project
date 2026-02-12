package com.okesalon.dao;
import com.okesalon.util.koneksi;
import com.okesalon.model.Layanan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LayananDAO {

    public LayananDAO() {}
    
    public boolean insert(Layanan layanan) {
        String sql = "INSERT INTO master_layanan " +
                     "(kode_layanan, nama_layanan, kategori_layanan, harga_layanan, " +
                     "durasi_estimasi, deskripsi_layanan, status, foto_layanan) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, layanan.getKodeLayanan());
            ps.setString(2, layanan.getNamaLayanan());
            ps.setString(3, layanan.getKategoriLayanan());
            ps.setDouble(4, layanan.getHargaLayanan());
            ps.setInt(5, layanan.getDurasiEstimasi());
            ps.setString(6, layanan.getDeskripsiLayanan());
            ps.setString(7, layanan.getStatus());
            ps.setString(8, layanan.getFotoLayanan());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error insert layanan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Layanan> getAll() {
        List<Layanan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_layanan ORDER BY kode_layanan ASC";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Layanan layanan = new Layanan();
                layanan.setKodeLayanan(rs.getString("kode_layanan"));
                layanan.setNamaLayanan(rs.getString("nama_layanan"));
                layanan.setKategoriLayanan(rs.getString("kategori_layanan"));
                layanan.setHargaLayanan(rs.getDouble("harga_layanan"));
                layanan.setDurasiEstimasi(rs.getInt("durasi_estimasi"));
                layanan.setDeskripsiLayanan(rs.getString("deskripsi_layanan"));
                layanan.setStatus(rs.getString("status"));
                layanan.setFotoLayanan(rs.getString("foto_layanan"));
                
                list.add(layanan);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getAll layanan: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        
        return list;
    }

    public Layanan getByKode(String kodeLayanan) {
        String sql = "SELECT * FROM master_layanan WHERE kode_layanan = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeLayanan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Layanan layanan = new Layanan();
                layanan.setKodeLayanan(rs.getString("kode_layanan"));
                layanan.setNamaLayanan(rs.getString("nama_layanan"));
                layanan.setKategoriLayanan(rs.getString("kategori_layanan"));
                layanan.setHargaLayanan(rs.getDouble("harga_layanan"));
                layanan.setDurasiEstimasi(rs.getInt("durasi_estimasi"));
                layanan.setDeskripsiLayanan(rs.getString("deskripsi_layanan"));
                layanan.setStatus(rs.getString("status"));
                layanan.setFotoLayanan(rs.getString("foto_layanan"));
                
                return layanan;
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByKode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    public boolean update(Layanan layanan) {
        String sql = "UPDATE master_layanan SET " +
                     "nama_layanan = ?, kategori_layanan = ?, harga_layanan = ?, " +
                     "durasi_estimasi = ?, deskripsi_layanan = ?, status = ?, foto_layanan = ? " +
                     "WHERE kode_layanan = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, layanan.getNamaLayanan());
            ps.setString(2, layanan.getKategoriLayanan());
            ps.setDouble(3, layanan.getHargaLayanan());
            ps.setInt(4, layanan.getDurasiEstimasi());
            ps.setString(5, layanan.getDeskripsiLayanan());
            ps.setString(6, layanan.getStatus());
            ps.setString(7, layanan.getFotoLayanan());
            ps.setString(8, layanan.getKodeLayanan());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error update layanan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String kodeLayanan) {
        String sql = "DELETE FROM master_layanan WHERE kode_layanan = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeLayanan);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error delete layanan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Layanan> search(String keyword) {
        List<Layanan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_layanan " +
                     "WHERE nama_layanan LIKE ? " +
                     "OR kategori_layanan LIKE ? " +
                     "OR kode_layanan LIKE ? " +
                     "ORDER BY kode_layanan ASC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Layanan layanan = new Layanan();
                layanan.setKodeLayanan(rs.getString("kode_layanan"));
                layanan.setNamaLayanan(rs.getString("nama_layanan"));
                layanan.setKategoriLayanan(rs.getString("kategori_layanan"));
                layanan.setHargaLayanan(rs.getDouble("harga_layanan"));
                layanan.setDurasiEstimasi(rs.getInt("durasi_estimasi"));
                layanan.setDeskripsiLayanan(rs.getString("deskripsi_layanan"));
                layanan.setStatus(rs.getString("status"));
                layanan.setFotoLayanan(rs.getString("foto_layanan"));
                
                list.add(layanan);
            }
            
        } catch (SQLException e) {
            System.err.println("Error search layanan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public String generateKodeLayanan() {
        String sql = "SELECT kode_layanan FROM master_layanan " +
                     "ORDER BY kode_layanan DESC LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_layanan");
                int lastNumber = Integer.parseInt(lastKode.substring(4));
                int nextNumber = lastNumber + 1;
                return String.format("LYN-%03d", nextNumber);
            } else {
                return "LYN-001";
            }
            
        } catch (SQLException e) {
            System.err.println("Error generate kode: " + e.getMessage());
            e.printStackTrace();
            return "LYN-001";
        }
    }
    
    public Layanan getLayananByNama(String namaLayanan) {
        Layanan layanan = null;
        String sql = "SELECT * FROM master_layanan WHERE nama_layanan = ?";
        
        System.out.println("getLayananByNama() called: '" + namaLayanan + "'");
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return null;
            }
            
            ps.setString(1, namaLayanan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                layanan = new Layanan();
                layanan.setKodeLayanan(rs.getString("kode_layanan"));
                layanan.setNamaLayanan(rs.getString("nama_layanan"));
                layanan.setKategoriLayanan(rs.getString("kategori_layanan"));
                layanan.setHargaLayanan(rs.getDouble("harga_layanan"));
                layanan.setDurasiEstimasi(rs.getInt("durasi_estimasi"));
                layanan.setDeskripsiLayanan(rs.getString("deskripsi_layanan"));
                layanan.setStatus(rs.getString("status"));
                layanan.setFotoLayanan(rs.getString("foto_layanan"));
                
                System.out.println("FOUND: " + layanan.getKodeLayanan() + " | " + layanan.getNamaLayanan() + " | Rp " + layanan.getHargaLayanan());
            } else {
                System.out.println("NOT FOUND: '" + namaLayanan + "'");
            }
            
        } catch (SQLException e) {
            System.err.println("Error getLayananByNama: " + e.getMessage());
            e.printStackTrace();
        }
        
        return layanan;
    }
}
