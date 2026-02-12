package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.okesalon.util.koneksi;

public class LaporanProdukAlertDAO {
    public static class RowProdukAlert {
        public String kodeProduk;
        public String namaProduk;
        public String kategoriProduk;
        public int stokSaatIni;
        public int stokMinimal;
        public String status;
        public int jumlahRestock;
        public String namaSupplier;
        public String teleponSupplier;
        
        public RowProdukAlert() {
        }
    }
    
    public static class AlertLevel {
        public static final String KRITIS = "Kritis";
        public static final String WARNING = "Warning";
        public static final String AMAN = "Aman";
    }
    
    public List<RowProdukAlert> getData(String kategori, String alertLevel, String supplier, String urutBerdasar, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  p.kode_produk, ");
        sql.append("  p.nama_produk, ");
        sql.append("  p.kategori_produk, ");
        sql.append("  p.stok_saat_ini, ");
        sql.append("  p.stok_minimum, ");
        sql.append("  CASE ");
        sql.append("    WHEN p.stok_saat_ini = 0 THEN 'Habis' ");
        sql.append("    WHEN p.stok_saat_ini < p.stok_minimum THEN 'Kritis' ");
        sql.append("    WHEN p.stok_saat_ini = p.stok_minimum THEN 'Warning' ");
        sql.append("    ELSE 'Aman' ");
        sql.append("  END as status, ");
        sql.append("  GREATEST(0, p.stok_minimum - p.stok_saat_ini) as jumlah_restock, ");
        sql.append("  COALESCE(p.nama_supplier, '-') as nama_supplier, ");
        sql.append("  COALESCE(p.telepon_supplier, '-') as telepon_supplier ");
        sql.append("FROM master_produk p ");
        sql.append("WHERE p.status = 'Aktif' ");

        if (kategori != null && !kategori.equals("Semua Kategori")) {
            sql.append("  AND p.kategori_produk = ? ");
        }

        if (alertLevel != null && !alertLevel.isEmpty()) {
            if (alertLevel.equals("Kritis")) {
                sql.append("  AND (p.stok_saat_ini = 0 OR p.stok_saat_ini < p.stok_minimum) ");
            } else if (alertLevel.equals("Warning")) {
                sql.append("  AND p.stok_saat_ini = p.stok_minimum ");
            } else if (alertLevel.equals("Aman")) {
                sql.append("  AND p.stok_saat_ini > p.stok_minimum ");
            }
        }

        if (supplier != null && !supplier.equals("Semua Supplier")) {
            sql.append("  AND p.nama_supplier = ? ");
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append("  AND (p.nama_produk LIKE ? ");
            sql.append("    OR p.kode_produk LIKE ? ");
            sql.append("    OR p.kategori_produk LIKE ?) ");
        }

        sql.append("ORDER BY ");
        if (urutBerdasar != null) {
            if (urutBerdasar.equals("Kritis → Aman")) {
                sql.append("CASE WHEN p.stok_saat_ini = 0 THEN 1 ");
                sql.append("     WHEN p.stok_saat_ini < p.stok_minimum THEN 2 ");
                sql.append("     WHEN p.stok_saat_ini = p.stok_minimum THEN 3 ");
                sql.append("     ELSE 4 END ASC, p.nama_produk ASC");
            } else if (urutBerdasar.equals("Nama")) {
                sql.append("p.nama_produk ASC");
            } else if (urutBerdasar.equals("Stok")) {
                sql.append("p.stok_saat_ini ASC, p.nama_produk ASC");
            }
        } else {
            sql.append("p.nama_produk ASC");
        }
        
        List<RowProdukAlert> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            
            if (kategori != null && !kategori.equals("Semua Kategori")) {
                ps.setString(i++, kategori);
            }
            
            if (supplier != null && !supplier.equals("Semua Supplier")) {
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
                    RowProdukAlert row = new RowProdukAlert();
                    row.kodeProduk = rs.getString("kode_produk");
                    row.namaProduk = rs.getString("nama_produk");
                    row.kategoriProduk = rs.getString("kategori_produk");
                    row.stokSaatIni = rs.getInt("stok_saat_ini");
                    row.stokMinimal = rs.getInt("stok_minimum");
                    row.status = rs.getString("status");
                    row.jumlahRestock = rs.getInt("jumlah_restock");
                    row.namaSupplier = rs.getString("nama_supplier");
                    row.teleponSupplier = rs.getString("telepon_supplier");
                    
                    list.add(row);
                }
            }
        }
        
        return list;
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
    
    public List<String> getSupplier() throws Exception {
        String sql = "SELECT DISTINCT nama_supplier FROM master_produk " +
                    "WHERE status = 'Aktif' AND nama_supplier IS NOT NULL " +
                    "ORDER BY nama_supplier ASC";
        
        List<String> list = new ArrayList<>();
        list.add("Semua Supplier");
        
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