package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.okesalon.util.koneksi;

public class LaporanPembelianProdukDAO {
    public static class RowPembelian {
        public String kodeTransaksi;
        public Date tanggalTransaksi;
        public String namaSupplier;
        public String namaProduk;
        public int jumlahBeli;
        public BigDecimal totalHarga;
        
        public RowPembelian() {
            this.totalHarga = BigDecimal.ZERO;
        }
    }
    
    public static class SummaryPembelian {
        public int totalTransaksi;
        public int totalItem;
        public BigDecimal totalPembelian;
        
        public SummaryPembelian() {
            this.totalPembelian = BigDecimal.ZERO;
        }
    }
    
    public List<RowPembelian> getData(Date tanggalMulai, Date tanggalSampai, String supplier, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  tp.kode_transaksi, ");
        sql.append("  tp.tanggal_transaksi, ");
        sql.append("  tp.nama_supplier, ");
        sql.append("  tp.nama_produk, ");
        sql.append("  tp.jumlah_beli, ");
        sql.append("  tp.total_harga ");
        sql.append("FROM transaksi_pembelian_produk tp ");
        sql.append("WHERE DATE(tp.tanggal_transaksi) >= ? ");
        sql.append("  AND DATE(tp.tanggal_transaksi) <= ? ");

        if (supplier != null && !supplier.equals("Semua")) {
            sql.append("  AND tp.nama_supplier = ? ");
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append("  AND (tp.nama_produk LIKE ? ");
            sql.append("    OR tp.kode_transaksi LIKE ? ");
            sql.append("    OR tp.nama_supplier LIKE ?) ");
        }
        
        sql.append("ORDER BY tp.tanggal_transaksi DESC, tp.kode_transaksi DESC");
        
        List<RowPembelian> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, new java.sql.Date(tanggalMulai.getTime()));
            ps.setDate(i++, new java.sql.Date(tanggalSampai.getTime()));
            
            if (supplier != null && !supplier.equals("Semua")) {
                ps.setString(i++, supplier);
            }
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowPembelian row = new RowPembelian();
                    row.kodeTransaksi = rs.getString("kode_transaksi");
                    row.tanggalTransaksi = rs.getDate("tanggal_transaksi");
                    row.namaSupplier = rs.getString("nama_supplier");
                    row.namaProduk = rs.getString("nama_produk");
                    row.jumlahBeli = rs.getInt("jumlah_beli");
                    
                    BigDecimal harga = rs.getBigDecimal("total_harga");
                    row.totalHarga = (harga != null) ? harga : BigDecimal.ZERO;
                    
                    list.add(row);
                }
            }
        }
        
        return list;
    }
    
    public SummaryPembelian getSummary(Date tanggalMulai, Date tanggalSampai, String supplier) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  COUNT(DISTINCT tp.kode_transaksi) as total_transaksi, ");
        sql.append("  COALESCE(SUM(tp.jumlah_beli), 0) as total_item, ");
        sql.append("  COALESCE(SUM(tp.total_harga), 0) as total_pembelian ");
        sql.append("FROM transaksi_pembelian_produk tp ");
        sql.append("WHERE DATE(tp.tanggal_transaksi) >= ? ");
        sql.append("  AND DATE(tp.tanggal_transaksi) <= ? ");
        
        if (supplier != null && !supplier.equals("Semua")) {
            sql.append("  AND tp.nama_supplier = ? ");
        }
        
        SummaryPembelian summary = new SummaryPembelian();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, new java.sql.Date(tanggalMulai.getTime()));
            ps.setDate(i++, new java.sql.Date(tanggalSampai.getTime()));
            
            if (supplier != null && !supplier.equals("Semua")) {
                ps.setString(i++, supplier);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    summary.totalTransaksi = rs.getInt("total_transaksi");
                    summary.totalItem = rs.getInt("total_item");
                    
                    BigDecimal pembelian = rs.getBigDecimal("total_pembelian");
                    summary.totalPembelian = (pembelian != null) ? pembelian : BigDecimal.ZERO;
                }
            }
        }
        
        return summary;
    }
    
    public List<String> getSupplier() throws Exception {
        String sql = "SELECT DISTINCT nama_supplier FROM transaksi_pembelian_produk " +
                    "WHERE nama_supplier IS NOT NULL " +
                    "ORDER BY nama_supplier ASC";
        
        List<String> list = new ArrayList<>();
        list.add("Semua");
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                String supplier = rs.getString("nama_supplier");
                if (supplier != null && !supplier.trim().isEmpty()) {
                    list.add(supplier);
                }
            }
        }
        
        return list;
    }
}