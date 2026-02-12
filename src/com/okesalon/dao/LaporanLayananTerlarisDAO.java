package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.okesalon.util.koneksi;

public class LaporanLayananTerlarisDAO {
    public static class RowLayanan {
        public String kodeLayanan;
        public String namaLayanan;
        public String kategoriLayanan;
        public int totalPembelian;
        public BigDecimal totalPendapatan;
        public BigDecimal rataHarga;
        
        public RowLayanan() {
            this.totalPendapatan = BigDecimal.ZERO;
            this.rataHarga = BigDecimal.ZERO;
        }
    }

    public static class SummaryLayanan {
        public int totalLayanan;
        public int totalTransaksi;
        public BigDecimal totalPendapatan;
        
        public SummaryLayanan() {
            this.totalPendapatan = BigDecimal.ZERO;
        }
    }

    public List<RowLayanan> getData(String ranking, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.kode_layanan, ");
        sql.append("  t.nama_layanan, ");
        sql.append("  l.kategori_layanan, ");
        sql.append("  COUNT(t.kode_transaksi) as total_pembelian, ");
        sql.append("  SUM(t.total_pembayaran) as total_pendapatan, ");
        sql.append("  AVG(t.harga_layanan) as rata_harga ");
        sql.append("FROM transaksi_layanan t ");
        sql.append("LEFT JOIN master_layanan l ON t.kode_layanan = l.kode_layanan ");
        sql.append("WHERE t.status_pembayaran = 'Lunas' ");
        
        if (ranking != null && !ranking.equals("Semua")) {
            if (ranking.equals("Hari Ini")) {
                sql.append("  AND DATE(t.tanggal_transaksi) = CURDATE() ");
            } else if (ranking.equals("Minggu Ini")) {
                sql.append("  AND YEARWEEK(t.tanggal_transaksi, 1) = YEARWEEK(CURDATE(), 1) ");
            } else if (ranking.equals("Bulan Ini")) {
                sql.append("  AND MONTH(t.tanggal_transaksi) = MONTH(CURDATE()) ");
                sql.append("  AND YEAR(t.tanggal_transaksi) = YEAR(CURDATE()) ");
            } else if (ranking.equals("Tahun Ini")) {
                sql.append("  AND YEAR(t.tanggal_transaksi) = YEAR(CURDATE()) ");
            }
        }
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND (t.nama_layanan LIKE ? ");
            sql.append("   OR t.kode_layanan LIKE ? ");
            sql.append("   OR l.kategori_layanan LIKE ?) ");
        }
        
        sql.append("GROUP BY t.kode_layanan, t.nama_layanan, l.kategori_layanan ");
        sql.append("ORDER BY total_pembelian DESC, total_pendapatan DESC");
        
        List<RowLayanan> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowLayanan row = new RowLayanan();
                    row.kodeLayanan = rs.getString("kode_layanan");
                    row.namaLayanan = rs.getString("nama_layanan");
                    row.kategoriLayanan = rs.getString("kategori_layanan");
                    row.totalPembelian = rs.getInt("total_pembelian");
                    row.totalPendapatan = rs.getBigDecimal("total_pendapatan");
                    row.rataHarga = rs.getBigDecimal("rata_harga");
                    list.add(row);
                }
            }
        }
        
        return list;
    }

    public SummaryLayanan getSummary(String ranking) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  COUNT(DISTINCT t.kode_layanan) as total_layanan, ");
        sql.append("  COUNT(t.kode_transaksi) as total_transaksi, ");
        sql.append("  COALESCE(SUM(t.total_pembayaran), 0) as total_pendapatan ");
        sql.append("FROM transaksi_layanan t ");
        sql.append("WHERE t.status_pembayaran = 'Lunas' ");
        
        if (ranking != null && !ranking.equals("Semua")) {
            if (ranking.equals("Hari Ini")) {
                sql.append("  AND DATE(t.tanggal_transaksi) = CURDATE() ");
            } else if (ranking.equals("Minggu Ini")) {
                sql.append("  AND YEARWEEK(t.tanggal_transaksi, 1) = YEARWEEK(CURDATE(), 1) ");
            } else if (ranking.equals("Bulan Ini")) {
                sql.append("  AND MONTH(t.tanggal_transaksi) = MONTH(CURDATE()) ");
                sql.append("  AND YEAR(t.tanggal_transaksi) = YEAR(CURDATE()) ");
            } else if (ranking.equals("Tahun Ini")) {
                sql.append("  AND YEAR(t.tanggal_transaksi) = YEAR(CURDATE()) ");
            }
        }
        
        SummaryLayanan summary = new SummaryLayanan();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString());
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                summary.totalLayanan = rs.getInt("total_layanan");
                summary.totalTransaksi = rs.getInt("total_transaksi");
                summary.totalPendapatan = rs.getBigDecimal("total_pendapatan");
            }
        }
        
        return summary;
    }

    public List<String> getRanking() {
        List<String> list = new ArrayList<>();
        list.add("Hari Ini");
        list.add("Minggu Ini");
        list.add("Bulan Ini");
        list.add("Tahun Ini");
        list.add("Semua");
        return list;
    }
}