package com.okesalon.dao;
import java.sql.*;
import java.util.*;
import java.util.Date;
import com.okesalon.util.koneksi;

public class LaporanPelangganBaruDAO {
    
    public static class RowPelangganBaru {
        public String kodePelanggan;
        public String namaLengkap;
        public String noTelepon;
        public String email;
        public String jenisKelamin;
        public String alamat;
        public String membershipType;
        public Date tanggalRegistrasi;
        public double totalSpending;
        public int usia;
    }
    
    public static class SummaryPelangganBaru {
        public int regular = 0;
        public int silver = 0;
        public int gold = 0;
        public int platinum = 0;
        public int total = 0;
    }
    
    public List<RowPelangganBaru> getData(Date tglMulai, Date tglSampai, 
                                           String membership, String gender, 
                                           String keyword) throws Exception {
        List<RowPelangganBaru> list = new ArrayList<>();
        
        String sql = "SELECT " +
                     "  kode_pelanggan, " +
                     "  nama_lengkap, " +
                     "  no_telepon, " +
                     "  email, " +
                     "  jenis_kelamin, " +
                     "  alamat, " +
                     "  membership_type, " +
                     "  tanggal_registrasi, " +
                     "  total_spending, " +
                     "  TIMESTAMPDIFF(YEAR, tanggal_lahir, CURDATE()) AS usia " +
                     "FROM master_pelanggan " +
                     "WHERE tanggal_registrasi BETWEEN ? AND ? " +
                     "AND (? = 'Semua' OR membership_type = ?) " +
                     "AND (? = 'Semua Jenis Kelamin' OR jenis_kelamin = ?) " +
                     "AND status = 'Aktif' " +
                     "AND (? = '' OR nama_lengkap LIKE ? OR no_telepon LIKE ?) " +
                     "ORDER BY tanggal_registrasi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setDate(1, new java.sql.Date(tglMulai.getTime()));
            ps.setDate(2, new java.sql.Date(tglSampai.getTime()));
            ps.setString(3, membership);
            ps.setString(4, membership);
            ps.setString(5, gender);
            ps.setString(6, gender);
            ps.setString(7, keyword);
            ps.setString(8, "%" + keyword + "%");
            ps.setString(9, "%" + keyword + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                RowPelangganBaru row = new RowPelangganBaru();
                row.kodePelanggan = rs.getString("kode_pelanggan");
                row.namaLengkap = rs.getString("nama_lengkap");
                row.noTelepon = rs.getString("no_telepon");
                row.email = rs.getString("email");
                row.jenisKelamin = rs.getString("jenis_kelamin");
                row.alamat = rs.getString("alamat");
                row.membershipType = rs.getString("membership_type");
                row.tanggalRegistrasi = rs.getDate("tanggal_registrasi");
                row.totalSpending = rs.getDouble("total_spending");
                row.usia = rs.getInt("usia");
                list.add(row);
            }
        }
        
        return list;
    }
    
    public SummaryPelangganBaru getSummary(Date tglMulai, Date tglSampai, 
                                            String membership, String gender) throws Exception {
        SummaryPelangganBaru summary = new SummaryPelangganBaru();
        
        String sql = "SELECT membership_type, COUNT(*) AS jumlah " +
                     "FROM master_pelanggan " +
                     "WHERE tanggal_registrasi BETWEEN ? AND ? " +
                     "AND (? = 'Semua' OR membership_type = ?) " +
                     "AND (? = 'Semua Jenis Kelamin' OR jenis_kelamin = ?) " +
                     "AND status = 'Aktif' " +
                     "GROUP BY membership_type";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setDate(1, new java.sql.Date(tglMulai.getTime()));
            ps.setDate(2, new java.sql.Date(tglSampai.getTime()));
            ps.setString(3, membership);
            ps.setString(4, membership);
            ps.setString(5, gender);
            ps.setString(6, gender);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String type = rs.getString("membership_type");
                int jumlah = rs.getInt("jumlah");
                
                if (type != null) {
                    switch (type) {
                        case "Regular":
                            summary.regular = jumlah;
                            break;
                        case "Silver":
                            summary.silver = jumlah;
                            break;
                        case "Gold":
                            summary.gold = jumlah;
                            break;
                        case "Platinum":
                            summary.platinum = jumlah;
                            break;
                    }
                    summary.total += jumlah;
                }
            }
        }
        
        return summary;
    }
}