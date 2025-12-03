/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.dao;
import koneksi.koneksi;
import com.okesalon.model.Layanan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author T480
 */
public class LayananDAO {
    private Connection connection;
    
    public LayananDAO() {
        this.connection = koneksi.getConnection();
    }
    
    /**
     * 1. CREATE - Tambah layanan baru
     */
    public boolean insert(Layanan layanan) {
        String sql = "INSERT INTO master_layanan " +
                     "(kode_layanan, nama_layanan, kategori_layanan, harga_layanan, " +
                     "durasi_estimasi, deskripsi_layanan, status, foto_layanan) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
            System.err.println("❌ Error saat insert layanan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 2. READ - Ambil semua data layanan
     */
    public List<Layanan> getAll() {
        List<Layanan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_layanan ORDER BY kode_layanan ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
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
            System.err.println("❌ Error saat mengambil data layanan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 3. READ - Ambil data layanan berdasarkan kode
     */
    public Layanan getByKode(String kodeLayanan) {
        String sql = "SELECT * FROM master_layanan WHERE kode_layanan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
            System.err.println("❌ Error saat mengambil data layanan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 4. UPDATE - Ubah data layanan
     */
    public boolean update(Layanan layanan) {
        String sql = "UPDATE master_layanan SET " +
                     "nama_layanan = ?, kategori_layanan = ?, harga_layanan = ?, " +
                     "durasi_estimasi = ?, deskripsi_layanan = ?, status = ?, foto_layanan = ? " +
                     "WHERE kode_layanan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
            System.err.println("❌ Error saat update layanan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 5. DELETE - Hapus data layanan
     */
    public boolean delete(String kodeLayanan) {
        String sql = "DELETE FROM master_layanan WHERE kode_layanan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeLayanan);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error saat delete layanan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 6. SEARCH - Cari layanan berdasarkan keyword
     */
    public List<Layanan> search(String keyword) {
        List<Layanan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_layanan " +
                     "WHERE nama_layanan LIKE ? " +
                     "OR kategori_layanan LIKE ? " +
                     "OR kode_layanan LIKE ? " +
                     "ORDER BY kode_layanan ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
            System.err.println("❌ Error saat search layanan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 7. GENERATE KODE - Generate kode layanan berikutnya
     */
    public String generateKodeLayanan() {
        String sql = "SELECT kode_layanan FROM master_layanan " +
                     "ORDER BY kode_layanan DESC LIMIT 1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_layanan"); // misal: LYN-005
                int lastNumber = Integer.parseInt(lastKode.substring(4)); // ambil "005" → 5
                int nextNumber = lastNumber + 1;
                return String.format("LYN-%03d", nextNumber); // LYN-006
            } else {
                return "LYN-001"; // Jika belum ada data
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error saat generate kode layanan: " + e.getMessage());
            e.printStackTrace();
            return "LYN-001";
        }
    }
}
