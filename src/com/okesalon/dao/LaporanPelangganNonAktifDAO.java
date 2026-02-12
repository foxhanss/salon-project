package com.okesalon.dao;
import com.okesalon.util.koneksi;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class LaporanPelangganNonAktifDAO {
    public static class RowPelangganNonAktif {
        public String kodePelanggan;
        public String namaLengkap;
        public String noTelepon;
        public String email;
        public String jenisKelamin;
        public String membershipType;
        public Date tanggalRegistrasi;
        public Date deletedAt;
        public String deletedBy;
        public String catatanKhusus;
        public String status;
    }
    
    public List<RowPelangganNonAktif> getData(java.util.Date tglMulai, java.util.Date tglSampai, 
                                               String keyword) throws Exception {
        List<RowPelangganNonAktif> list = new ArrayList<>();
        
        String sql = "SELECT " +
                     "  kode_pelanggan, " +
                     "  nama_lengkap, " +
                     "  no_telepon, " +
                     "  email, " +
                     "  jenis_kelamin, " +
                     "  membership_type, " +
                     "  tanggal_registrasi, " +
                     "  deleted_at, " +
                     "  deleted_by, " +
                     "  catatan_khusus, " +
                     "  status " +
                     "FROM master_pelanggan " +
                     "WHERE deleted_at BETWEEN ? AND ? " +
                     "AND status IN ('Non-Aktif', 'Deleted') " +
                     "AND (? = '' OR nama_lengkap LIKE ? OR no_telepon LIKE ?) " +
                     "ORDER BY deleted_at DESC";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setDate(1, new java.sql.Date(tglMulai.getTime()));
            ps.setDate(2, new java.sql.Date(tglSampai.getTime()));
            ps.setString(3, keyword);
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                RowPelangganNonAktif row = new RowPelangganNonAktif();
                row.kodePelanggan = rs.getString("kode_pelanggan");
                row.namaLengkap = rs.getString("nama_lengkap");
                row.noTelepon = rs.getString("no_telepon");
                row.email = rs.getString("email");
                row.jenisKelamin = rs.getString("jenis_kelamin");
                row.membershipType = rs.getString("membership_type");
                row.tanggalRegistrasi = rs.getDate("tanggal_registrasi");
                row.deletedAt = rs.getTimestamp("deleted_at");
                row.deletedBy = rs.getString("deleted_by");
                row.catatanKhusus = rs.getString("catatan_khusus");
                row.status = rs.getString("status");
                list.add(row);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        
        return list;
    }
    
    public int getTotalCount(java.util.Date tglMulai, java.util.Date tglSampai) throws Exception {
        String sql = "SELECT COUNT(*) AS total " +
                     "FROM master_pelanggan " +
                     "WHERE deleted_at BETWEEN ? AND ? " +
                     "AND status IN ('Non-Aktif', 'Deleted')";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setDate(1, new java.sql.Date(tglMulai.getTime()));
            ps.setDate(2, new java.sql.Date(tglSampai.getTime()));
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        
        return 0;
    }
}