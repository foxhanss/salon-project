package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.okesalon.util.koneksi;

public class LaporanStokProdukDAO {
   public static class RowProduk {
        public String kodeProduk;
        public String namaProduk;
        public String kategoriProduk;
        public int stokSaatIni;
        public int stokMinimum;
        public String statusStok;
        public BigDecimal hargaJual;
        public BigDecimal nilaiInventori;
        
        public RowProduk() {
            this.hargaJual = BigDecimal.ZERO;
            this.nilaiInventori = BigDecimal.ZERO;
        }
    }
    
    public static class SummaryStok {
        public int totalProduk;
        public int totalAman;
        public int totalMenipis;
        public int totalHabis;
        public BigDecimal totalNilaiInventori;
        
        public SummaryStok() {
            this.totalNilaiInventori = BigDecimal.ZERO;
        }
    }
    
    public List<RowProduk> getData(String kategori, String statusStok, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  p.kode_produk, ");
        sql.append("  p.nama_produk, ");
        sql.append("  p.kategori_produk, ");
        sql.append("  p.stok_saat_ini, ");
        sql.append("  p.stok_minimum, ");
        sql.append("  CASE ");
        sql.append("    WHEN p.stok_saat_ini = 0 THEN 'Habis' ");
        sql.append("    WHEN p.stok_saat_ini <= p.stok_minimum THEN 'Menipis' ");
        sql.append("    ELSE 'Aman' ");
        sql.append("  END as status_stok, ");
        sql.append("  p.harga_jual, ");
        sql.append("  (p.stok_saat_ini * p.harga_jual) as nilai_inventori ");
        sql.append("FROM master_produk p ");
        sql.append("WHERE p.status = 'Aktif' ");
        
        if (kategori != null && !kategori.equals("Semua Kategori")) {
            sql.append("  AND p.kategori_produk = ? ");
        }
        
        if (statusStok != null && !statusStok.equals("Semua Status")) {
            if (statusStok.equals("Habis")) {
                sql.append("  AND p.stok_saat_ini = 0 ");
            } else if (statusStok.equals("Menipis")) {
                sql.append("  AND p.stok_saat_ini > 0 AND p.stok_saat_ini <= p.stok_minimum ");
            } else if (statusStok.equals("Aman")) {
                sql.append("  AND p.stok_saat_ini > p.stok_minimum ");
            }
        }
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND (p.nama_produk LIKE ? ");
            sql.append("   OR p.kode_produk LIKE ? ");
            sql.append("   OR p.kategori_produk LIKE ?) ");
        }
        
        sql.append("ORDER BY ");
        sql.append("  CASE ");
        sql.append("    WHEN p.stok_saat_ini = 0 THEN 1 ");
        sql.append("    WHEN p.stok_saat_ini <= p.stok_minimum THEN 2 ");
        sql.append("    ELSE 3 ");
        sql.append("  END, ");
        sql.append("  p.nama_produk ASC");
        
        List<RowProduk> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            
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
                    RowProduk row = new RowProduk();
                    row.kodeProduk = rs.getString("kode_produk");
                    row.namaProduk = rs.getString("nama_produk");
                    row.kategoriProduk = rs.getString("kategori_produk");
                    row.stokSaatIni = rs.getInt("stok_saat_ini");
                    row.stokMinimum = rs.getInt("stok_minimum");
                    row.statusStok = rs.getString("status_stok");
                    row.hargaJual = rs.getBigDecimal("harga_jual");
                    row.nilaiInventori = rs.getBigDecimal("nilai_inventori");
                    list.add(row);
                }
            }
        }
        
        return list;
    }
    
    public SummaryStok getSummary(String kategori, String statusStok) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  COUNT(*) as total_produk, ");
        sql.append("  SUM(CASE WHEN p.stok_saat_ini > p.stok_minimum THEN 1 ELSE 0 END) as total_aman, ");
        sql.append("  SUM(CASE WHEN p.stok_saat_ini > 0 AND p.stok_saat_ini <= p.stok_minimum THEN 1 ELSE 0 END) as total_menipis, ");
        sql.append("  SUM(CASE WHEN p.stok_saat_ini = 0 THEN 1 ELSE 0 END) as total_habis, ");
        sql.append("  COALESCE(SUM(p.stok_saat_ini * p.harga_jual), 0) as total_nilai_inventori ");
        sql.append("FROM master_produk p ");
        sql.append("WHERE p.status = 'Aktif' ");
        
        if (kategori != null && !kategori.equals("Semua Kategori")) {
            sql.append("  AND p.kategori_produk = ? ");
        }
        
        if (statusStok != null && !statusStok.equals("Semua Status")) {
            if (statusStok.equals("Habis")) {
                sql.append("  AND p.stok_saat_ini = 0 ");
            } else if (statusStok.equals("Menipis")) {
                sql.append("  AND p.stok_saat_ini > 0 AND p.stok_saat_ini <= p.stok_minimum ");
            } else if (statusStok.equals("Aman")) {
                sql.append("  AND p.stok_saat_ini > p.stok_minimum ");
            }
        }
        
        SummaryStok summary = new SummaryStok();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            if (kategori != null && !kategori.equals("Semua Kategori")) {
                ps.setString(1, kategori);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    summary.totalProduk = rs.getInt("total_produk");
                    summary.totalAman = rs.getInt("total_aman");
                    summary.totalMenipis = rs.getInt("total_menipis");
                    summary.totalHabis = rs.getInt("total_habis");
                    summary.totalNilaiInventori = rs.getBigDecimal("total_nilai_inventori");
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
    
    public List<String> getStatusStok() {
        List<String> list = new ArrayList<>();
        list.add("Semua Status");
        list.add("Aman");
        list.add("Menipis");
        list.add("Habis");
        return list;
    }
}