package com.okesalon.dao;
import com.okesalon.model.TransaksiPembelianProduk;
import com.okesalon.util.koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;

public class TransaksiPembelianProdukDAO {

    public boolean insertTransaksi(TransaksiPembelianProduk transaksi) {
        Connection conn = null;
        PreparedStatement pstmtTransaksi = null;
        PreparedStatement pstmtUpdateStok = null;
        
        String sqlTransaksi = "INSERT INTO transaksi_pembelian_produk " +
                              "(kode_transaksi, tanggal_transaksi, kode_produk, nama_produk, " +
                              "jumlah_beli, harga_satuan, nama_supplier, telepon_supplier, " +
                              "metode_pembayaran, keterangan, stok_sebelum, " +
                              "jumlah_beli_copy, stok_sesudah, total_harga) " +
                              "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        String sqlUpdateStok = "UPDATE master_produk SET stok_saat_ini = stok_saat_ini + ? " +
                               "WHERE kode_produk = ?";
        
        try {
            conn = koneksi.getConnection();
            conn.setAutoCommit(false);
            
            pstmtTransaksi = conn.prepareStatement(sqlTransaksi);
            pstmtTransaksi.setString(1, transaksi.getKodeTransaksi());
            pstmtTransaksi.setDate(2, new java.sql.Date(transaksi.getTanggalTransaksi().getTime()));
            pstmtTransaksi.setString(3, transaksi.getKodeProduk());
            pstmtTransaksi.setString(4, transaksi.getNamaProduk());
            pstmtTransaksi.setInt(5, transaksi.getJumlahBeli());
            pstmtTransaksi.setDouble(6, transaksi.getHargaSatuan());
            pstmtTransaksi.setString(7, transaksi.getNamaSupplier());
            pstmtTransaksi.setString(8, transaksi.getTeleponSupplier());
            pstmtTransaksi.setString(9, transaksi.getMetodePembayaran());
            pstmtTransaksi.setString(10, transaksi.getKeterangan());
            pstmtTransaksi.setInt(11, transaksi.getStokSebelum());
            pstmtTransaksi.setInt(12, transaksi.getJumlahBeli());
            pstmtTransaksi.setInt(13, transaksi.getStokSesudah());
            pstmtTransaksi.setDouble(14, transaksi.getTotalHarga());
            
            int rowsInserted = pstmtTransaksi.executeUpdate();

            pstmtUpdateStok = conn.prepareStatement(sqlUpdateStok);
            pstmtUpdateStok.setInt(1, transaksi.getJumlahBeli());
            pstmtUpdateStok.setString(2, transaksi.getKodeProduk());
            
            int rowsUpdated = pstmtUpdateStok.executeUpdate();
            
            if (rowsInserted > 0 && rowsUpdated > 0) {
                conn.commit();
                System.out.println("Transaksi berhasil disimpan!");
                return true;
            } else {
                conn.rollback();
                System.err.println("Gagal menyimpan transaksi!");
                return false;
            }
            
        } catch (SQLException e) {
            System.err.println("Error inserting transaksi: " + e.getMessage());
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (pstmtTransaksi != null) pstmtTransaksi.close();
                if (pstmtUpdateStok != null) pstmtUpdateStok.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<TransaksiPembelianProduk> getAllTransaksi() {
        List<TransaksiPembelianProduk> transaksiList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_pembelian_produk " +
                     "ORDER BY tanggal_transaksi DESC, kode_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                TransaksiPembelianProduk transaksi = extractTransaksiFromResultSet(rs);
                transaksiList.add(transaksi);
            }
            
            System.out.println("Loaded " + transaksiList.size() + " transaksi");
            
        } catch (SQLException e) {
            System.err.println("Error getting all transaksi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transaksiList;
    }

    public TransaksiPembelianProduk getTransaksiByKode(String kodeTransaksi) {
        TransaksiPembelianProduk transaksi = null;
        String sql = "SELECT * FROM transaksi_pembelian_produk WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeTransaksi);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                transaksi = extractTransaksiFromResultSet(rs);
                System.out.println("Found transaksi: " + kodeTransaksi);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getting transaksi by kode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transaksi;
    }

    public List<TransaksiPembelianProduk> searchTransaksi(String keyword) {
        List<TransaksiPembelianProduk> transaksiList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_pembelian_produk " +
                     "WHERE kode_transaksi LIKE ? " +
                     "OR nama_produk LIKE ? " +
                     "OR nama_supplier LIKE ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                TransaksiPembelianProduk transaksi = extractTransaksiFromResultSet(rs);
                transaksiList.add(transaksi);
            }
            
            System.out.println("Found " + transaksiList.size() + " results for: " + keyword);
            
        } catch (SQLException e) {
            System.err.println("Error searching transaksi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return transaksiList;
    }
    
    public boolean deleteTransaksi(String kodeTransaksi) {
        Connection conn = null;
        PreparedStatement pstmtGetData = null;
        PreparedStatement pstmtDelete = null;
        PreparedStatement pstmtUpdateStok = null;
        
        String sqlGetData = "SELECT kode_produk, jumlah_beli FROM transaksi_pembelian_produk WHERE kode_transaksi = ?";
        String sqlDelete = "DELETE FROM transaksi_pembelian_produk WHERE kode_transaksi = ?";
        String sqlUpdateStok = "UPDATE master_produk SET stok_saat_ini = stok_saat_ini - ? WHERE kode_produk = ?";
        
        try {
            conn = koneksi.getConnection();
            conn.setAutoCommit(false);
            
            pstmtGetData = conn.prepareStatement(sqlGetData);
            pstmtGetData.setString(1, kodeTransaksi);
            ResultSet rs = pstmtGetData.executeQuery();
            
            if (rs.next()) {
                String kodeProduk = rs.getString("kode_produk");
                int jumlahBeli = rs.getInt("jumlah_beli");
                
                pstmtDelete = conn.prepareStatement(sqlDelete);
                pstmtDelete.setString(1, kodeTransaksi);
                int rowsDeleted = pstmtDelete.executeUpdate();
                
                pstmtUpdateStok = conn.prepareStatement(sqlUpdateStok);
                pstmtUpdateStok.setInt(1, jumlahBeli);
                pstmtUpdateStok.setString(2, kodeProduk);
                int rowsUpdated = pstmtUpdateStok.executeUpdate();
                
                if (rowsDeleted > 0 && rowsUpdated > 0) {
                    conn.commit();
                    System.out.println("Transaksi berhasil dihapus: " + kodeTransaksi);
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            }
            
            conn.rollback();
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error deleting transaksi: " + e.getMessage());
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (pstmtGetData != null) pstmtGetData.close();
                if (pstmtDelete != null) pstmtDelete.close();
                if (pstmtUpdateStok != null) pstmtUpdateStok.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private TransaksiPembelianProduk extractTransaksiFromResultSet(ResultSet rs) throws SQLException {
        TransaksiPembelianProduk transaksi = new TransaksiPembelianProduk();
        transaksi.setKodeTransaksi(rs.getString("kode_transaksi"));
        transaksi.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
        transaksi.setKodeProduk(rs.getString("kode_produk"));
        transaksi.setNamaProduk(rs.getString("nama_produk"));
        transaksi.setJumlahBeli(rs.getInt("jumlah_beli"));
        transaksi.setHargaSatuan(rs.getDouble("harga_satuan"));
        transaksi.setNamaSupplier(rs.getString("nama_supplier"));
        transaksi.setTeleponSupplier(rs.getString("telepon_supplier"));
        transaksi.setMetodePembayaran(rs.getString("metode_pembayaran"));
        transaksi.setKeterangan(rs.getString("keterangan"));
        transaksi.setStokSebelum(rs.getInt("stok_sebelum"));
        transaksi.setJumlahBeliCopy(rs.getInt("jumlah_beli_copy"));
        transaksi.setStokSesudah(rs.getInt("stok_sesudah"));
        transaksi.setTotalHarga(rs.getDouble("total_harga"));
        transaksi.setCreatedAt(rs.getTimestamp("created_at"));
        transaksi.setUpdatedAt(rs.getTimestamp("updated_at"));
        return transaksi;
    }
    
    public String generateKodeTransaksi() {
        String kodeTransaksi = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(new java.util.Date());
        String prefix = "PB-" + today + "-";
        
        String sql = "SELECT kode_transaksi FROM transaksi_pembelian_produk " +
                     "WHERE kode_transaksi LIKE ? " +
                     "ORDER BY kode_transaksi DESC LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, prefix + "%");
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_transaksi");
                String lastSeq = lastKode.substring(lastKode.lastIndexOf("-") + 1);
                int nextSeq = Integer.parseInt(lastSeq) + 1;
                kodeTransaksi = prefix + String.format("%03d", nextSeq);
            } else {
                kodeTransaksi = prefix + "001";
            }
            
            System.out.println("Generated kode: " + kodeTransaksi);
            
        } catch (SQLException e) {
            System.err.println("Error generating kode transaksi: " + e.getMessage());
            e.printStackTrace();
            kodeTransaksi = prefix + "001";
        }
        
        return kodeTransaksi;
    }
    
    public int getStokProduk(String kodeProduk) {
        String sql = "SELECT stok_saat_ini FROM master_produk WHERE kode_produk = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeProduk);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("stok_saat_ini");
            }
            
        } catch (SQLException e) {
            System.err.println("Error getting stok produk: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }

    public Map<String, Object> getProdukData(String kodeProduk) {
        Map<String, Object> data = new HashMap<>();
        String sql = "SELECT nama_produk, harga_beli, stok_saat_ini, nama_supplier, telepon_supplier " +
                     "FROM master_produk WHERE kode_produk = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kodeProduk);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                data.put("nama_produk", rs.getString("nama_produk"));
                data.put("harga_beli", rs.getDouble("harga_beli"));
                data.put("stok_saat_ini", rs.getInt("stok_saat_ini"));
                data.put("nama_supplier", rs.getString("nama_supplier"));
                data.put("telepon_supplier", rs.getString("telepon_supplier"));
                
                System.out.println("Loaded produk data: " + kodeProduk);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getting produk data: " + e.getMessage());
            e.printStackTrace();
        }
        
        return data;
    }

    public List<String> getNamaProdukList() {
        List<String> namaProdukList = new ArrayList<>();
        String sql = "SELECT nama_produk FROM master_produk WHERE status = 'Aktif' ORDER BY nama_produk";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                namaProdukList.add(rs.getString("nama_produk"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error getting nama produk list: " + e.getMessage());
            e.printStackTrace();
        }
        
        return namaProdukList;
    }

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
            System.err.println("Error getting kode produk: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<String> getUniqueSupplierList() {
        List<String> supplierList = new ArrayList<>();
        String sql = "SELECT DISTINCT nama_supplier FROM master_produk " +
                     "WHERE nama_supplier IS NOT NULL AND nama_supplier != '' " +
                     "AND status = 'Aktif' " +
                     "ORDER BY nama_supplier";

        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                supplierList.add(rs.getString("nama_supplier"));
            }

        } catch (SQLException e) {
            System.err.println("Error getting supplier list: " + e.getMessage());
            e.printStackTrace();
        }

        return supplierList;
    }

    public Map<String, Object> getSupplierData(String namaSupplier) {
        Map<String, Object> data = new HashMap<>();
        String sql = "SELECT telepon_supplier FROM master_produk " +
                     "WHERE nama_supplier = ? LIMIT 1";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, namaSupplier);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                data.put("telepon_supplier", rs.getString("telepon_supplier"));
            }

        } catch (SQLException e) {
            System.err.println("Error getting supplier data: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }
    
    public List<TransaksiPembelianProduk> getTransaksiBySupplier(String namaSupplier) {
        List<TransaksiPembelianProduk> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_pembelian_produk " +
                     "WHERE nama_supplier = ? " +
                     "ORDER BY tanggal_transaksi DESC";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, namaSupplier);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                TransaksiPembelianProduk t = new TransaksiPembelianProduk();
                t.setKodeTransaksi(rs.getString("kode_transaksi"));
                t.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
                t.setKodeProduk(rs.getString("kode_produk"));
                t.setNamaProduk(rs.getString("nama_produk"));
                t.setJumlahBeli(rs.getInt("jumlah_beli"));
                t.setHargaSatuan(rs.getDouble("harga_satuan"));
                t.setNamaSupplier(rs.getString("nama_supplier"));
                t.setTeleponSupplier(rs.getString("telepon_supplier"));
                t.setMetodePembayaran(rs.getString("metode_pembayaran"));
                t.setKeterangan(rs.getString("keterangan"));
                t.setStokSebelum(rs.getInt("stok_sebelum"));
                t.setStokSesudah(rs.getInt("stok_sesudah"));
                t.setTotalHarga(rs.getDouble("total_harga"));

                list.add(t);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public List<Map<String, Object>> getSupplierSummary() {
        List<Map<String, Object>> list = new ArrayList<>();

        String sql = "SELECT " +
                     "    t.nama_supplier, " +
                     "    t.telepon_supplier, " +
                     "    COUNT(*) as total_transaksi, " +
                     "    SUM(t.total_harga) as total_pembelian, " +
                     "    MAX(t.nama_produk) as produk_terakhir, " +
                     "    MAX(t.tanggal_transaksi) as tanggal_terakhir " +
                     "FROM transaksi_pembelian_produk t " +
                     "GROUP BY t.nama_supplier, t.telepon_supplier " +
                     "ORDER BY total_pembelian DESC";

        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("nama_supplier", rs.getString("nama_supplier"));
                map.put("telepon_supplier", rs.getString("telepon_supplier"));
                map.put("total_transaksi", rs.getInt("total_transaksi"));
                map.put("total_pembelian", rs.getDouble("total_pembelian"));
                map.put("produk_terakhir", rs.getString("produk_terakhir"));
                map.put("tanggal_terakhir", rs.getDate("tanggal_terakhir"));

                list.add(map);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

   public boolean updateTransaksi(TransaksiPembelianProduk transaksi) {
       Connection conn = null;
       PreparedStatement pstmtGet = null;
       PreparedStatement pstmtUpdate = null;
       PreparedStatement pstmtUpdateStok = null;

       String sqlGet = "SELECT kode_produk, jumlah_beli FROM transaksi_pembelian_produk " +
                       "WHERE kode_transaksi = ?";

       String sqlUpdate = "UPDATE transaksi_pembelian_produk SET " +
                          "tanggal_transaksi = ?, " +
                          "kode_produk = ?, " +
                          "nama_produk = ?, " +
                          "jumlah_beli = ?, " +
                          "harga_satuan = ?, " +
                          "nama_supplier = ?, " +
                          "telepon_supplier = ?, " +
                          "metode_pembayaran = ?, " +
                          "keterangan = ?, " +
                          "stok_sebelum = ?, " +
                          "jumlah_beli_copy = ?, " +
                          "stok_sesudah = ?, " +
                          "total_harga = ? " +
                          "WHERE kode_transaksi = ?";

       String sqlUpdateStok = "UPDATE master_produk SET stok_saat_ini = stok_saat_ini - ? + ? " +
                              "WHERE kode_produk = ?";

       try {
           conn = koneksi.getConnection();
           conn.setAutoCommit(false);

           pstmtGet = conn.prepareStatement(sqlGet);
           pstmtGet.setString(1, transaksi.getKodeTransaksi());
           ResultSet rs = pstmtGet.executeQuery();

           if (!rs.next()) {
               System.err.println("Transaksi tidak ditemukan: " + transaksi.getKodeTransaksi());
               conn.rollback();
               return false;
           }

           String oldKodeProduk = rs.getString("kode_produk");
           int oldJumlah = rs.getInt("jumlah_beli");

           pstmtUpdate = conn.prepareStatement(sqlUpdate);
           pstmtUpdate.setDate(1, new java.sql.Date(transaksi.getTanggalTransaksi().getTime()));
           pstmtUpdate.setString(2, transaksi.getKodeProduk());
           pstmtUpdate.setString(3, transaksi.getNamaProduk());
           pstmtUpdate.setInt(4, transaksi.getJumlahBeli());
           pstmtUpdate.setDouble(5, transaksi.getHargaSatuan());
           pstmtUpdate.setString(6, transaksi.getNamaSupplier());
           pstmtUpdate.setString(7, transaksi.getTeleponSupplier());
           pstmtUpdate.setString(8, transaksi.getMetodePembayaran());
           pstmtUpdate.setString(9, transaksi.getKeterangan());
           pstmtUpdate.setInt(10, transaksi.getStokSebelum());
           pstmtUpdate.setInt(11, transaksi.getJumlahBeli());
           pstmtUpdate.setInt(12, transaksi.getStokSesudah());
           pstmtUpdate.setDouble(13, transaksi.getTotalHarga());
           pstmtUpdate.setString(14, transaksi.getKodeTransaksi());

           int rowsUpdated = pstmtUpdate.executeUpdate();

           pstmtUpdateStok = conn.prepareStatement(sqlUpdateStok);
           pstmtUpdateStok.setInt(1, oldJumlah);
           pstmtUpdateStok.setInt(2, transaksi.getJumlahBeli());
           pstmtUpdateStok.setString(3, oldKodeProduk);

           int rowsStokUpdated = pstmtUpdateStok.executeUpdate();

           if (rowsUpdated > 0 && rowsStokUpdated > 0) {
               conn.commit();
               System.out.println("Transaksi berhasil diupdate!");
               return true;
           } else {
               conn.rollback();
               System.err.println("Gagal update transaksi!");
               return false;
           }

       } catch (SQLException e) {
           System.err.println("Error updating transaksi: " + e.getMessage());
           e.printStackTrace();
           try {
               if (conn != null) conn.rollback();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
           return false;
       } finally {
           try {
               if (pstmtGet != null) pstmtGet.close();
               if (pstmtUpdate != null) pstmtUpdate.close();
               if (pstmtUpdateStok != null) pstmtUpdateStok.close();
               if (conn != null) {
                   conn.setAutoCommit(true);
                   conn.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
}