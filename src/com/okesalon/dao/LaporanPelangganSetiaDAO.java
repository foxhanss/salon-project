package com.okesalon.dao;
import com.okesalon.util.koneksi;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class LaporanPelangganSetiaDAO {
    public static class RowPelangganSetia {
        public String kodePelanggan;
        public String namaLengkap;
        public String noTelepon;
        public String email;
        public String jenisKelamin;
        public String membershipType;
        public Date tanggalRegistrasi;
        public double totalSpending;
        public int ranking;
    }
    
    public static class SummaryPelangganSetia {
        public int totalPelanggan = 0;
        public double totalBelanja = 0.00;
    }
    
    public List<RowPelangganSetia> getData(java.util.Date tglMulai, java.util.Date tglSampai, 
                                            String keyword) throws Exception {
        List<RowPelangganSetia> list = new ArrayList<>();
        
        String sql = "SELECT " +
                     "  kode_pelanggan, " +
                     "  nama_lengkap, " +
                     "  no_telepon, " +
                     "  email, " +
                     "  jenis_kelamin, " +
                     "  membership_type, " +
                     "  tanggal_registrasi, " +
                     "  total_spending " +
                     "FROM master_pelanggan " +
                     "WHERE tanggal_registrasi <= ? " +
                     "AND status = 'Aktif' " +
                     "AND total_spending >= 500000 " +
                     "AND (? = '' OR nama_lengkap LIKE ? OR no_telepon LIKE ?) " +
                     "ORDER BY total_spending DESC, tanggal_registrasi ASC " +
                     "LIMIT 50";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setDate(1, new java.sql.Date(tglSampai.getTime()));
            ps.setString(2, keyword);
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            
            rs = ps.executeQuery();
            
            int ranking = 1;
            while (rs.next()) {
                RowPelangganSetia row = new RowPelangganSetia();
                row.kodePelanggan = rs.getString("kode_pelanggan");
                row.namaLengkap = rs.getString("nama_lengkap");
                row.noTelepon = rs.getString("no_telepon");
                row.email = rs.getString("email");
                row.jenisKelamin = rs.getString("jenis_kelamin");
                row.membershipType = rs.getString("membership_type");
                row.tanggalRegistrasi = rs.getDate("tanggal_registrasi");
                row.totalSpending = rs.getDouble("total_spending");
                row.ranking = ranking++;
                list.add(row);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        
        return list;
    }
    
    public SummaryPelangganSetia getSummary(java.util.Date tglMulai, java.util.Date tglSampai) throws Exception {
        SummaryPelangganSetia summary = new SummaryPelangganSetia();
        
        String sql = "SELECT " +
                     "  COUNT(*) AS total_pelanggan, " +
                     "  SUM(total_spending) AS total_belanja " +
                     "FROM master_pelanggan " +
                     "WHERE tanggal_registrasi <= ? " +
                     "AND status = 'Aktif' " +
                     "AND total_spending >= 500000";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setDate(1, new java.sql.Date(tglSampai.getTime()));
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                summary.totalPelanggan = rs.getInt("total_pelanggan");
                summary.totalBelanja = rs.getDouble("total_belanja");
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        
        return summary;
    }
}