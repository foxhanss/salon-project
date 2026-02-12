package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.okesalon.util.koneksi;

public class LaporanKunjunganDAO {
    public static class RowKunjungan {
        public String kodePelanggan;
        public String namaLengkap;
        public String noTelepon;
        public String membershipType;
        public int totalKunjungan;
        public BigDecimal totalPengeluaran;
        public Date kunjunganTerakhir;
        
        public RowKunjungan() {
            this.totalPengeluaran = BigDecimal.ZERO;
        }
    }
    
    public static class SummaryKunjungan {
        public int totalPelanggan;
        public int totalKunjungan;
        public BigDecimal totalPengeluaran;
        public BigDecimal rataPengeluaran;
        
        public SummaryKunjungan() {
            this.totalPengeluaran = BigDecimal.ZERO;
            this.rataPengeluaran = BigDecimal.ZERO;
        }
    }
    
    public List<RowKunjungan> getData(Date tglMulai, Date tglSampai, String membership, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.kode_pelanggan, ");
        sql.append("  t.nama_lengkap, ");
        sql.append("  t.no_telepon, ");
        sql.append("  COALESCE(p.membership_type, 'Regular') as membership_type, ");
        sql.append("  COUNT(DISTINCT t.kode_transaksi) as total_kunjungan, ");
        sql.append("  SUM(t.total_pembayaran) as total_pengeluaran, ");
        sql.append("  MAX(t.tanggal_transaksi) as kunjungan_terakhir ");
        sql.append("FROM transaksi_layanan t ");
        sql.append("LEFT JOIN master_pelanggan p ON t.kode_pelanggan = p.kode_pelanggan ");
        sql.append("WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        sql.append("  AND t.status_pembayaran = 'Lunas' ");
        
        if (membership != null && !membership.equals("Semua")) {
            sql.append("  AND COALESCE(p.membership_type, 'Regular') = ? ");
        }
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND (t.nama_lengkap LIKE ? ");
            sql.append("   OR t.kode_pelanggan LIKE ? ");
            sql.append("   OR t.no_telepon LIKE ?) ");
        }
        
        sql.append("GROUP BY t.kode_pelanggan, t.nama_lengkap, t.no_telepon, COALESCE(p.membership_type, 'Regular') ");
        sql.append("ORDER BY t.nama_lengkap ASC");
        
        List<RowKunjungan> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            
            if (membership != null && !membership.equals("Semua")) {
                ps.setString(i++, membership);
            }
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowKunjungan row = new RowKunjungan();
                    row.kodePelanggan = rs.getString("kode_pelanggan");
                    row.namaLengkap = rs.getString("nama_lengkap");
                    row.noTelepon = rs.getString("no_telepon");
                    row.membershipType = rs.getString("membership_type");
                    row.totalKunjungan = rs.getInt("total_kunjungan");
                    row.totalPengeluaran = rs.getBigDecimal("total_pengeluaran");
                    row.kunjunganTerakhir = rs.getDate("kunjungan_terakhir");
                    list.add(row);
                }
            }
        }
        
        return list;
    }
    
    public SummaryKunjungan getSummary(Date tglMulai, Date tglSampai, String membership) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  COUNT(DISTINCT t.kode_pelanggan) as total_pelanggan, ");
        sql.append("  COUNT(DISTINCT t.kode_transaksi) as total_kunjungan, ");
        sql.append("  COALESCE(SUM(t.total_pembayaran), 0) as total_pengeluaran, ");
        sql.append("  COALESCE(AVG(t.total_pembayaran), 0) as rata_pengeluaran ");
        sql.append("FROM transaksi_layanan t ");
        sql.append("LEFT JOIN master_pelanggan p ON t.kode_pelanggan = p.kode_pelanggan ");
        sql.append("WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        sql.append("  AND t.status_pembayaran = 'Lunas' ");
        
        if (membership != null && !membership.equals("Semua")) {
            sql.append("  AND COALESCE(p.membership_type, 'Regular') = ? ");
        }
        
        SummaryKunjungan summary = new SummaryKunjungan();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            
            if (membership != null && !membership.equals("Semua")) {
                ps.setString(i++, membership);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    summary.totalPelanggan = rs.getInt("total_pelanggan");
                    summary.totalKunjungan = rs.getInt("total_kunjungan");
                    summary.totalPengeluaran = rs.getBigDecimal("total_pengeluaran");
                    summary.rataPengeluaran = rs.getBigDecimal("rata_pengeluaran");
                }
            }
        }
        
        return summary;
    }
    
    public List<String> getMembership() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Semua");
        list.add("Regular");
        list.add("Silver");
        list.add("Gold");
        list.add("Platinum");
        return list;
    }
    
    public boolean validatePeriode(java.util.Date tglMulai, java.util.Date tglSampai) {
        if (tglMulai == null || tglSampai == null) return false;
        return !tglMulai.after(tglSampai);
    }
    
    public Date toSqlDate(java.util.Date date) {
        if (date == null) return null;
        return new Date(date.getTime());
    }
}