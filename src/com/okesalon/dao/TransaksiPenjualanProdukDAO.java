package com.okesalon.dao;

import com.okesalon.model.TransaksiPenjualanProduk;
import com.okesalon.model.Produk;
import koneksi.koneksi;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO untuk Transaksi Penjualan Produk
 * @author T480
 */
public class TransaksiPenjualanProdukDAO {
    
    // ==================== INNER CLASS: CUSTOMER SUMMARY ====================
    public static class CustomerSummary {
        private String namaPelanggan;
        private String teleponPelanggan;
        private int totalTransaksi;
        private BigDecimal totalPembelian;
        private String produkFavorit;
        private Date terakhirBelanja;
        
        public CustomerSummary(String namaPelanggan, String teleponPelanggan, 
                              int totalTransaksi, BigDecimal totalPembelian,
                              String produkFavorit, Date terakhirBelanja) {
            this.namaPelanggan = namaPelanggan;
            this.teleponPelanggan = teleponPelanggan;
            this.totalTransaksi = totalTransaksi;
            this.totalPembelian = totalPembelian;
            this.produkFavorit = produkFavorit;
            this.terakhirBelanja = terakhirBelanja;
        }
        
        // Getters
        public String getNamaPelanggan() { return namaPelanggan; }
        public String getTeleponPelanggan() { return teleponPelanggan; }
        public int getTotalTransaksi() { return totalTransaksi; }
        public BigDecimal getTotalPembelian() { return totalPembelian; }
        public String getProdukFavorit() { return produkFavorit; }
        public Date getTerakhirBelanja() { return terakhirBelanja; }
    }
    
    // ==================== 1. GENERATE KODE TRANSAKSI ====================
    public String generateKodeTransaksi() {
        String kode = "TRX-0001";
        String sql = "SELECT kode_transaksi FROM transaksi_penjualan_produk " +
                     "ORDER BY kode_transaksi DESC LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_transaksi");
                int num = Integer.parseInt(lastKode.substring(4)) + 1;
                kode = String.format("TRX-%04d", num);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return kode;
    }
    
    // ✅ FIX: GET NAMA PRODUK LIST (untuk ComboBox)
    public List<String> getNamaProdukList() {
        List<String> list = new ArrayList<>();
        
        String sql = "SELECT nama_produk FROM master_produk ORDER BY nama_produk ASC";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("✅ Executing SQL: " + sql);
            
            while (rs.next()) {
                String namaProduk = rs.getString("nama_produk");
                list.add(namaProduk);
                System.out.println("  ✅ Found: " + namaProduk);
            }
            
            System.out.println("✅ Total produk found: " + list.size());
            
        } catch (SQLException e) {
            System.err.println("❌ SQL Error in getNamaProdukList(): " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    // ✅ FIX: GET KODE PRODUK BY NAMA
    public String getKodeProdukByNama(String namaProduk) {
        String sql = "SELECT kode_produk FROM master_produk WHERE nama_produk = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, namaProduk);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("kode_produk");
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error in getKodeProdukByNama(): " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public Map<String, Object> getProdukData(String kodeProduk) {
        Map<String, Object> data = new HashMap<>();
        
        // ✅ GANTI 'produk' → 'master_produk'
        String sql = "SELECT harga_jual, stok FROM master_produk WHERE kode_produk = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeProduk);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                data.put("harga_jual", rs.getBigDecimal("harga_jual"));
                data.put("stok_saat_ini", rs.getInt("stok"));
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error in getProdukData(): " + e.getMessage());
            e.printStackTrace();
        }
        
        return data;
    }
    
    // ✅ FIX: GET PELANGGAN DATA (telepon_pelanggan)
    public Map<String, Object> getPelangganData(String namaPelanggan) {
        Map<String, Object> data = new HashMap<>();
        
        // Query dari transaksi terakhir pelanggan ini
        String sql = "SELECT telepon_pelanggan FROM transaksi_penjualan_produk " +
                     "WHERE nama_pelanggan = ? " +
                     "ORDER BY tanggal_transaksi DESC LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, namaPelanggan);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                data.put("telepon_pelanggan", rs.getString("telepon_pelanggan"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    // ==================== 2. TAMBAH TRANSAKSI ====================
    public boolean tambahTransaksi(TransaksiPenjualanProduk transaksi) {
        String sqlTransaksi = "INSERT INTO transaksi_penjualan_produk " +
                             "(kode_transaksi, tanggal_transaksi, kode_produk, nama_produk, " +
                             "jumlah_jual, harga_satuan, nama_pelanggan, telepon_pelanggan, " +
                             "metode_pembayaran, keterangan, stok_sebelum, jumlah_jual_copy, " +
                             "stok_sesudah, total_harga) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // ✅ GANTI 'produk' → 'master_produk'
        String sqlUpdateStok = "UPDATE master_produk SET stok = stok - ? WHERE kode_produk = ?";
        
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        
        try {
            conn = koneksi.getConnection();
            conn.setAutoCommit(false);
            
            // Insert transaksi
            pstmt1 = conn.prepareStatement(sqlTransaksi);
            pstmt1.setString(1, transaksi.getKodeTransaksi());
            pstmt1.setDate(2, transaksi.getTanggalTransaksi());
            pstmt1.setString(3, transaksi.getKodeProduk());
            pstmt1.setString(4, transaksi.getNamaProduk());
            pstmt1.setInt(5, transaksi.getJumlahJual());
            pstmt1.setBigDecimal(6, transaksi.getHargaSatuan());
            pstmt1.setString(7, transaksi.getNamaPelanggan());
            pstmt1.setString(8, transaksi.getTeleponPelanggan());
            pstmt1.setString(9, transaksi.getMetodePembayaran());
            pstmt1.setString(10, transaksi.getKeterangan());
            pstmt1.setInt(11, transaksi.getStokSebelum());
            pstmt1.setInt(12, transaksi.getJumlahJualCopy());
            pstmt1.setInt(13, transaksi.getStokSesudah());
            pstmt1.setBigDecimal(14, transaksi.getTotalHarga());
            pstmt1.executeUpdate();
            
            // Update stok produk
            pstmt2 = conn.prepareStatement(sqlUpdateStok);
            pstmt2.setInt(1, transaksi.getJumlahJual());
            pstmt2.setString(2, transaksi.getKodeProduk());
            pstmt2.executeUpdate();
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (pstmt2 != null) pstmt2.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // ==================== 3. UPDATE TRANSAKSI ====================
    public boolean updateTransaksi(TransaksiPenjualanProduk transaksi, int jumlahJualLama) {
        String sqlUpdate = "UPDATE transaksi_penjualan_produk SET " +
                          "tanggal_transaksi = ?, kode_produk = ?, nama_produk = ?, " +
                          "jumlah_jual = ?, harga_satuan = ?, nama_pelanggan = ?, " +
                          "telepon_pelanggan = ?, metode_pembayaran = ?, keterangan = ?, " +
                          "stok_sebelum = ?, jumlah_jual_copy = ?, stok_sesudah = ?, " +
                          "total_harga = ? WHERE kode_transaksi = ?";
        
        // ✅ GANTI 'produk' → 'master_produk'
        String sqlAdjustStok = "UPDATE master_produk SET stok = stok + ? - ? WHERE kode_produk = ?";
        
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        
        try {
            conn = koneksi.getConnection();
            conn.setAutoCommit(false);
            
            // Update transaksi
            pstmt1 = conn.prepareStatement(sqlUpdate);
            pstmt1.setDate(1, transaksi.getTanggalTransaksi());
            pstmt1.setString(2, transaksi.getKodeProduk());
            pstmt1.setString(3, transaksi.getNamaProduk());
            pstmt1.setInt(4, transaksi.getJumlahJual());
            pstmt1.setBigDecimal(5, transaksi.getHargaSatuan());
            pstmt1.setString(6, transaksi.getNamaPelanggan());
            pstmt1.setString(7, transaksi.getTeleponPelanggan());
            pstmt1.setString(8, transaksi.getMetodePembayaran());
            pstmt1.setString(9, transaksi.getKeterangan());
            pstmt1.setInt(10, transaksi.getStokSebelum());
            pstmt1.setInt(11, transaksi.getJumlahJualCopy());
            pstmt1.setInt(12, transaksi.getStokSesudah());
            pstmt1.setBigDecimal(13, transaksi.getTotalHarga());
            pstmt1.setString(14, transaksi.getKodeTransaksi());
            pstmt1.executeUpdate();
            
            // Adjust stok
            pstmt2 = conn.prepareStatement(sqlAdjustStok);
            pstmt2.setInt(1, jumlahJualLama);
            pstmt2.setInt(2, transaksi.getJumlahJual());
            pstmt2.setString(3, transaksi.getKodeProduk());
            pstmt2.executeUpdate();
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (pstmt2 != null) pstmt2.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // ==================== 4. HAPUS TRANSAKSI ====================
    public boolean hapusTransaksi(String kodeTransaksi) {
        TransaksiPenjualanProduk transaksi = getTransaksiByKode(kodeTransaksi);
        if (transaksi == null) return false;
        
        String sqlDelete = "DELETE FROM transaksi_penjualan_produk WHERE kode_transaksi = ?";
        
        // ✅ GANTI 'produk' → 'master_produk'
        String sqlKembalikanStok = "UPDATE master_produk SET stok = stok + ? WHERE kode_produk = ?";
        
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        
        try {
            conn = koneksi.getConnection();
            conn.setAutoCommit(false);
            
            // Kembalikan stok
            pstmt1 = conn.prepareStatement(sqlKembalikanStok);
            pstmt1.setInt(1, transaksi.getJumlahJual());
            pstmt1.setString(2, transaksi.getKodeProduk());
            pstmt1.executeUpdate();
            
            // Delete transaksi
            pstmt2 = conn.prepareStatement(sqlDelete);
            pstmt2.setString(1, kodeTransaksi);
            pstmt2.executeUpdate();
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (pstmt2 != null) pstmt2.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // ==================== 5. GET ALL TRANSAKSI ====================
    public List<TransaksiPenjualanProduk> getAllTransaksi() {
        List<TransaksiPenjualanProduk> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_penjualan_produk ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(extractFromResultSet(rs));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    // ==================== 6. GET TRANSAKSI BY KODE ====================
    public TransaksiPenjualanProduk getTransaksiByKode(String kodeTransaksi) {
        String sql = "SELECT * FROM transaksi_penjualan_produk WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeTransaksi);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // ==================== 7. SEARCH TRANSAKSI ====================
    public List<TransaksiPenjualanProduk> searchTransaksi(String keyword) {
        List<TransaksiPenjualanProduk> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_penjualan_produk WHERE " +
                     "kode_transaksi LIKE ? OR " +
                     "nama_produk LIKE ? OR " +
                     "nama_pelanggan LIKE ? OR " +
                     "telepon_pelanggan LIKE ? " +
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
                list.add(extractFromResultSet(rs));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    // ==================== 8. GET ALL NAMA PELANGGAN ====================
    public List<String> getAllNamaPelanggan() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT nama_pelanggan FROM transaksi_penjualan_produk " +
                     "ORDER BY nama_pelanggan";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(rs.getString("nama_pelanggan"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    // ==================== 9. GET CUSTOMER SUMMARY ====================
    public List<CustomerSummary> getCustomerSummary() {
        List<CustomerSummary> list = new ArrayList<>();
        
        String sql = "SELECT " +
                     "nama_pelanggan, " +
                     "telepon_pelanggan, " +
                     "COUNT(*) as total_transaksi, " +
                     "SUM(total_harga) as total_pembelian, " +
                     "MAX(tanggal_transaksi) as terakhir_belanja " +
                     "FROM transaksi_penjualan_produk " +
                     "GROUP BY nama_pelanggan, telepon_pelanggan " +
                     "ORDER BY total_pembelian DESC";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String namaPelanggan = rs.getString("nama_pelanggan");
                String telepon = rs.getString("telepon_pelanggan");
                int totalTransaksi = rs.getInt("total_transaksi");
                BigDecimal totalPembelian = rs.getBigDecimal("total_pembelian");
                Date terakhirBelanja = rs.getDate("terakhir_belanja");
                
                String produkFavorit = getProdukFavoritByCustomer(namaPelanggan);
                
                CustomerSummary summary = new CustomerSummary(
                    namaPelanggan, telepon, totalTransaksi, 
                    totalPembelian, produkFavorit, terakhirBelanja
                );
                
                list.add(summary);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    // ==================== 10. GET PRODUK FAVORIT BY CUSTOMER ====================
    private String getProdukFavoritByCustomer(String namaPelanggan) {
        String sql = "SELECT nama_produk, COUNT(*) as jumlah " +
                     "FROM transaksi_penjualan_produk " +
                     "WHERE nama_pelanggan = ? " +
                     "GROUP BY nama_produk " +
                     "ORDER BY jumlah DESC " +
                     "LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, namaPelanggan);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String produk = rs.getString("nama_produk");
                int jumlah = rs.getInt("jumlah");
                return produk + " (" + jumlah + "x)";
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "-";
    }
    
    // ==================== 11. GET TRANSAKSI BY CUSTOMER ====================
    public List<TransaksiPenjualanProduk> getTransaksiByCustomer(String namaPelanggan) {
        List<TransaksiPenjualanProduk> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_penjualan_produk WHERE nama_pelanggan = ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, namaPelanggan);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                list.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // ==================== 12. GET CUSTOMER STATISTICS ====================
    public Map<String, Object> getCustomerStatistics(String namaPelanggan) {
        Map<String, Object> stats = new HashMap<>();
        
        String sql = "SELECT " +
                     "COUNT(*) as total_transaksi, " +
                     "SUM(total_harga) as total_pembelian, " +
                     "AVG(total_harga) as rata_rata_belanja, " +
                     "MIN(tanggal_transaksi) as pertama_belanja, " +
                     "MAX(tanggal_transaksi) as terakhir_belanja " +
                     "FROM transaksi_penjualan_produk " +
                     "WHERE nama_pelanggan = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, namaPelanggan);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                stats.put("totalTransaksi", rs.getInt("total_transaksi"));
                stats.put("totalPembelian", rs.getBigDecimal("total_pembelian"));
                stats.put("rataRataBelanja", rs.getBigDecimal("rata_rata_belanja"));
                stats.put("pertamaBelanja", rs.getDate("pertama_belanja"));
                stats.put("terakhirBelanja", rs.getDate("terakhir_belanja"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return stats;
    }
    
    // ==================== HELPER: EXTRACT FROM RESULTSET ====================
    private TransaksiPenjualanProduk extractFromResultSet(ResultSet rs) throws SQLException {
        TransaksiPenjualanProduk t = new TransaksiPenjualanProduk();
        t.setKodeTransaksi(rs.getString("kode_transaksi"));
        t.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
        t.setKodeProduk(rs.getString("kode_produk"));
        t.setNamaProduk(rs.getString("nama_produk"));
        t.setJumlahJual(rs.getInt("jumlah_jual"));
        t.setHargaSatuan(rs.getBigDecimal("harga_satuan"));
        t.setNamaPelanggan(rs.getString("nama_pelanggan"));
        t.setTeleponPelanggan(rs.getString("telepon_pelanggan"));
        t.setMetodePembayaran(rs.getString("metode_pembayaran"));
        t.setKeterangan(rs.getString("keterangan"));
        t.setStokSebelum(rs.getInt("stok_sebelum"));
        t.setJumlahJualCopy(rs.getInt("jumlah_jual_copy"));
        t.setStokSesudah(rs.getInt("stok_sesudah"));
        t.setTotalHarga(rs.getBigDecimal("total_harga"));
        return t;
    }
}
