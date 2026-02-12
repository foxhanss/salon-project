package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.okesalon.util.koneksi;

public class LaporanPenjualanProdukDAO {
    public static class RowPenjualan {
        public String kodeProduk;
        public String namaProduk;
        public String kategoriProduk;
        public int jumlahTerjual;
        public BigDecimal totalPendapatan;
        public BigDecimal profit;
        public RowPenjualan() {
            this.totalPendapatan = BigDecimal.ZERO;
            this.profit = BigDecimal.ZERO;
        }
    }
    
    public static class SummaryPenjualan {
        public int totalProduk;
        public int totalKuantitas;
        public BigDecimal totalPendapatan;
        public BigDecimal totalProfit;
        
        public SummaryPenjualan() {
            this.totalPendapatan = BigDecimal.ZERO;
            this.totalProfit = BigDecimal.ZERO;
        }
    }
    
    public List<RowPenjualan> getData(Date tanggalMulai, Date tanggalSampai, String kategori, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  p.kode_produk, ");
        sql.append("  p.nama_produk, ");
        sql.append("  p.kategori_produk, ");
        sql.append("  COALESCE(SUM(tp.jumlah_jual), 0) as jumlah_terjual, ");
        sql.append("  COALESCE(SUM(tp.total_harga), 0) as total_pendapatan, ");
        sql.append("  COALESCE(SUM(tp.jumlah_jual * (tp.harga_satuan - COALESCE(p.harga_beli, 0))), 0) as profit ");
        sql.append("FROM master_produk p ");
        sql.append("LEFT JOIN transaksi_penjualan_produk tp ON p.kode_produk = tp.kode_produk ");
        sql.append("  AND DATE(tp.tanggal_transaksi) >= ? ");
        sql.append("  AND DATE(tp.tanggal_transaksi) <= ? ");
        sql.append("WHERE p.status = 'Aktif' ");
        
        if (kategori != null && !kategori.equals("Semua Kategori")) {
            sql.append("  AND p.kategori_produk = ? ");
        }
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append("  AND (p.nama_produk LIKE ? ");
            sql.append("    OR p.kode_produk LIKE ? ");
            sql.append("    OR p.kategori_produk LIKE ?) ");
        }
        
        sql.append("GROUP BY p.kode_produk, p.nama_produk, p.kategori_produk ");
        sql.append("HAVING jumlah_terjual > 0 ");
        sql.append("ORDER BY jumlah_terjual DESC, total_pendapatan DESC");
        
        List<RowPenjualan> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, new java.sql.Date(tanggalMulai.getTime()));
            ps.setDate(i++, new java.sql.Date(tanggalSampai.getTime()));
            
            if (kategori != null && !kategori.equals("Semua Kategori")) {
                ps.setString(i++, kategori);
            }
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowPenjualan row = new RowPenjualan();
                    row.kodeProduk = rs.getString("kode_produk");
                    row.namaProduk = rs.getString("nama_produk");
                    row.kategoriProduk = rs.getString("kategori_produk");
                    row.jumlahTerjual = rs.getInt("jumlah_terjual");
                    
                    BigDecimal pendapatan = rs.getBigDecimal("total_pendapatan");
                    row.totalPendapatan = (pendapatan != null) ? pendapatan : BigDecimal.ZERO;
                    
                    BigDecimal profitValue = rs.getBigDecimal("profit");
                    row.profit = (profitValue != null) ? profitValue : BigDecimal.ZERO;
                    
                    list.add(row);
                }
            }
        }
        
        return list;
    }
    
    public SummaryPenjualan getSummary(Date tanggalMulai, Date tanggalSampai, String kategori) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  COUNT(DISTINCT CASE WHEN tp.kode_produk IS NOT NULL THEN p.kode_produk END) as total_produk, ");
        sql.append("  COALESCE(SUM(tp.jumlah_jual), 0) as total_kuantitas, ");
        sql.append("  COALESCE(SUM(tp.total_harga), 0) as total_pendapatan, ");
        sql.append("  COALESCE(SUM(tp.jumlah_jual * (tp.harga_satuan - COALESCE(p.harga_beli, 0))), 0) as total_profit ");
        sql.append("FROM master_produk p ");
        sql.append("LEFT JOIN transaksi_penjualan_produk tp ON p.kode_produk = tp.kode_produk ");
        sql.append("  AND DATE(tp.tanggal_transaksi) >= ? ");
        sql.append("  AND DATE(tp.tanggal_transaksi) <= ? ");
        sql.append("WHERE p.status = 'Aktif' ");
        
        if (kategori != null && !kategori.equals("Semua Kategori")) {
            sql.append("  AND p.kategori_produk = ? ");
        }
        
        SummaryPenjualan summary = new SummaryPenjualan();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, new java.sql.Date(tanggalMulai.getTime()));
            ps.setDate(i++, new java.sql.Date(tanggalSampai.getTime()));
            
            if (kategori != null && !kategori.equals("Semua Kategori")) {
                ps.setString(i++, kategori);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    summary.totalProduk = rs.getInt("total_produk");
                    summary.totalKuantitas = rs.getInt("total_kuantitas");
                    
                    BigDecimal pendapatan = rs.getBigDecimal("total_pendapatan");
                    summary.totalPendapatan = (pendapatan != null) ? pendapatan : BigDecimal.ZERO;
                    
                    BigDecimal profit = rs.getBigDecimal("total_profit");
                    summary.totalProfit = (profit != null) ? profit : BigDecimal.ZERO;
                }
            }
        }
        
        return summary;
    }
    
    public List<String> getKategori() throws Exception {
        String sql = "SELECT DISTINCT kategori_produk FROM master_produk WHERE status = 'Aktif' ORDER BY kategori_produk";
        
        List<String> list = new ArrayList<>();
        list.add("Semua Kategori");
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                String kategori = rs.getString("kategori_produk");
                if (kategori != null && !kategori.trim().isEmpty()) {
                    list.add(kategori);
                }
            }
        }
        
        return list;
    }
}