/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.dao;
import com.okesalon.model.TransaksiLayanan;
import koneksi.koneksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
/**
 *
 * @author T480
 */
public class TransaksiLayananDAO {
    // ==================== CREATE ====================
    
    /**
     * Insert transaksi layanan baru
     */
    public boolean insertTransaksi(TransaksiLayanan transaksi) {
        String sql = "INSERT INTO transaksi_layanan " +
                     "(kode_transaksi, kode_pelanggan, nama_lengkap, no_telepon, " +
                     "kode_karyawan, nama_karyawan, tanggal_transaksi, kode_layanan, " +
                     "nama_layanan, harga_layanan, subtotal_layanan, diskon, " +
                     "total_pembayaran, metode_pembayaran, status_pembayaran) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, transaksi.getKodeTransaksi());
            pstmt.setString(2, transaksi.getKodePelanggan());
            pstmt.setString(3, transaksi.getNamaLengkap());
            pstmt.setString(4, transaksi.getNoTelepon());
            pstmt.setString(5, transaksi.getKodeKaryawan());
            pstmt.setString(6, transaksi.getNamaKaryawan());
            pstmt.setDate(7, new java.sql.Date(transaksi.getTanggalTransaksi().getTime()));
            pstmt.setString(8, transaksi.getKodeLayanan());
            pstmt.setString(9, transaksi.getNamaLayanan());
            pstmt.setDouble(10, transaksi.getHargaLayanan());
            pstmt.setDouble(11, transaksi.getSubtotalLayanan());
            pstmt.setString(12, transaksi.getDiskon());
            pstmt.setDouble(13, transaksi.getTotalPembayaran());
            pstmt.setString(14, transaksi.getMetodePembayaran());
            pstmt.setString(15, transaksi.getStatusPembayaran());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error inserting transaksi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // ==================== READ ====================
    
    /**
     * Get all transaksi layanan
     */
    public List<TransaksiLayanan> getAllTransaksi() {
        List<TransaksiLayanan> transaksiList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan ORDER BY tanggal_transaksi DESC, created_at DESC";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                TransaksiLayanan transaksi = extractTransaksiFromResultSet(rs);
                transaksiList.add(transaksi);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getting all transaksi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transaksiList;
    }
    
    /**
     * Get transaksi by Kode Transaksi
     */
    public TransaksiLayanan getTransaksiByNo(String kodeTransaksi) {
        TransaksiLayanan transaksi = null;
        String sql = "SELECT * FROM transaksi_layanan WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeTransaksi);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                transaksi = extractTransaksiFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getting transaksi by kode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transaksi;
    }
    
    /**
     * Search transaksi
     */
    public List<TransaksiLayanan> searchTransaksi(String keyword) {
        List<TransaksiLayanan> transaksiList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan " +
                     "WHERE kode_transaksi LIKE ? " +
                     "OR nama_lengkap LIKE ? " +
                     "OR nama_karyawan LIKE ? " +
                     "OR nama_layanan LIKE ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);
            pstmt.setString(4, searchPattern);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                TransaksiLayanan transaksi = extractTransaksiFromResultSet(rs);
                transaksiList.add(transaksi);
            }
            
        } catch (SQLException e) {
            System.err.println("Error searching transaksi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transaksiList;
    }
    
    // ==================== UPDATE ====================
    
    /**
     * Update transaksi layanan
     */
    public boolean updateTransaksi(TransaksiLayanan transaksi) {
        String sql = "UPDATE transaksi_layanan SET " +
                     "kode_pelanggan = ?, nama_lengkap = ?, no_telepon = ?, " +
                     "kode_karyawan = ?, nama_karyawan = ?, tanggal_transaksi = ?, " +
                     "kode_layanan = ?, nama_layanan = ?, harga_layanan = ?, " +
                     "subtotal_layanan = ?, diskon = ?, total_pembayaran = ?, " +
                     "metode_pembayaran = ?, status_pembayaran = ? " +
                     "WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, transaksi.getKodePelanggan());
            pstmt.setString(2, transaksi.getNamaLengkap());
            pstmt.setString(3, transaksi.getNoTelepon());
            pstmt.setString(4, transaksi.getKodeKaryawan());
            pstmt.setString(5, transaksi.getNamaKaryawan());
            pstmt.setDate(6, new java.sql.Date(transaksi.getTanggalTransaksi().getTime()));
            pstmt.setString(7, transaksi.getKodeLayanan());
            pstmt.setString(8, transaksi.getNamaLayanan());
            pstmt.setDouble(9, transaksi.getHargaLayanan());
            pstmt.setDouble(10, transaksi.getSubtotalLayanan());
            pstmt.setString(11, transaksi.getDiskon());
            pstmt.setDouble(12, transaksi.getTotalPembayaran());
            pstmt.setString(13, transaksi.getMetodePembayaran());
            pstmt.setString(14, transaksi.getStatusPembayaran());
            pstmt.setString(15, transaksi.getKodeTransaksi());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating transaksi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // ==================== DELETE ====================
    
    /**
     * Delete transaksi
     */
    public boolean deleteTransaksi(String kodeTransaksi) {
        String sql = "DELETE FROM transaksi_layanan WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeTransaksi);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting transaksi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Extract TransaksiLayanan from ResultSet
     */
    private TransaksiLayanan extractTransaksiFromResultSet(ResultSet rs) throws SQLException {
        TransaksiLayanan transaksi = new TransaksiLayanan();
        transaksi.setKodeTransaksi(rs.getString("kode_transaksi"));
        transaksi.setKodePelanggan(rs.getString("kode_pelanggan"));
        transaksi.setNamaLengkap(rs.getString("nama_lengkap"));
        transaksi.setNoTelepon(rs.getString("no_telepon"));
        transaksi.setKodeKaryawan(rs.getString("kode_karyawan"));
        transaksi.setNamaKaryawan(rs.getString("nama_karyawan"));
        transaksi.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
        transaksi.setKodeLayanan(rs.getString("kode_layanan"));
        transaksi.setNamaLayanan(rs.getString("nama_layanan"));
        transaksi.setHargaLayanan(rs.getDouble("harga_layanan"));
        transaksi.setSubtotalLayanan(rs.getDouble("subtotal_layanan"));
        transaksi.setDiskon(rs.getString("diskon"));
        transaksi.setTotalPembayaran(rs.getDouble("total_pembayaran"));
        transaksi.setMetodePembayaran(rs.getString("metode_pembayaran"));
        transaksi.setStatusPembayaran(rs.getString("status_pembayaran"));
        transaksi.setCreatedAt(rs.getTimestamp("created_at"));
        transaksi.setUpdatedAt(rs.getTimestamp("updated_at"));
        return transaksi;
    }
    
    /**
     * Generate Kode Transaksi (TRX-YYYYMMDD-XXX)
     */
    public String generateNoTransaksi() {
        String kodeTransaksi = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(new java.util.Date());
        String prefix = "TRX-" + today + "-";
        
        String sql = "SELECT kode_transaksi FROM transaksi_layanan " +
                     "WHERE kode_transaksi LIKE ? " +
                     "ORDER BY kode_transaksi DESC LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, prefix + "%");
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String lastNo = rs.getString("kode_transaksi");
                String lastSeq = lastNo.substring(lastNo.lastIndexOf("-") + 1);
                int nextSeq = Integer.parseInt(lastSeq) + 1;
                kodeTransaksi = prefix + String.format("%03d", nextSeq);
            } else {
                kodeTransaksi = prefix + "001";
            }
            
        } catch (SQLException e) {
            System.err.println("Error generating kode transaksi: " + e.getMessage());
            e.printStackTrace();
            kodeTransaksi = prefix + "001";
        }
        
        return kodeTransaksi;
    }
    
    /**
     * Check if Kode Transaksi exists
     */
    public boolean isNoTransaksiExists(String kodeTransaksi) {
        String sql = "SELECT COUNT(*) FROM transaksi_layanan WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeTransaksi);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("Error checking kode transaksi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
}
