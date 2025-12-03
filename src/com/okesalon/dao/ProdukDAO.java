/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.dao;
import koneksi.koneksi;
import com.okesalon.model.Produk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author T480
 */
public class ProdukDAO {
    private Connection connection;
    
    public ProdukDAO() {
        this.connection = koneksi.getConnection();
    }
    
    /**
     * 1. CREATE - Tambah produk baru
     */
    public boolean insert(Produk produk) {
        String sql = "INSERT INTO master_produk " +
                     "(kode_produk, nama_produk, kategori_produk, jenis, " +
                     "nama_supplier, telepon_supplier, harga_beli, harga_jual, " +
                     "stok_saat_ini, stok_minimum, satuan, tanggal_expired, " +
                     "status, deskripsi, foto_produk) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, produk.getKodeProduk());
            ps.setString(2, produk.getNamaProduk());
            ps.setString(3, produk.getKategoriProduk());
            ps.setString(4, produk.getJenis());
            ps.setString(5, produk.getNamaSupplier());
            ps.setString(6, produk.getTeleponSupplier());
            ps.setDouble(7, produk.getHargaBeli());
            ps.setDouble(8, produk.getHargaJual());
            ps.setInt(9, produk.getStokSaatIni());
            ps.setInt(10, produk.getStokMinimum());
            ps.setString(11, produk.getSatuan());
            
            if (produk.getTanggalExpired() != null) {
                ps.setDate(12, new java.sql.Date(produk.getTanggalExpired().getTime()));
            } else {
                ps.setNull(12, Types.DATE);
            }
            
            ps.setString(13, produk.getStatus());
            ps.setString(14, produk.getDeskripsi());
            ps.setString(15, produk.getFotoProduk());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error insert produk: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 2. READ - Ambil semua data produk
     */
    public List<Produk> getAll() {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM master_produk ORDER BY kode_produk ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Produk p = extractProdukFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getAll produk: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 3. READ - Ambil produk berdasarkan kode
     */
    public Produk getByKode(String kodeProduk) {
        String sql = "SELECT * FROM master_produk WHERE kode_produk = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeProduk);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractProdukFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByKode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 4. UPDATE - Ubah data produk
     */
    public boolean update(Produk produk) {
        String sql = "UPDATE master_produk SET " +
                     "nama_produk = ?, kategori_produk = ?, jenis = ?, " +
                     "nama_supplier = ?, telepon_supplier = ?, harga_beli = ?, " +
                     "harga_jual = ?, stok_saat_ini = ?, stok_minimum = ?, " +
                     "satuan = ?, tanggal_expired = ?, status = ?, " +
                     "deskripsi = ?, foto_produk = ? " +
                     "WHERE kode_produk = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, produk.getNamaProduk());
            ps.setString(2, produk.getKategoriProduk());
            ps.setString(3, produk.getJenis());
            ps.setString(4, produk.getNamaSupplier());
            ps.setString(5, produk.getTeleponSupplier());
            ps.setDouble(6, produk.getHargaBeli());
            ps.setDouble(7, produk.getHargaJual());
            ps.setInt(8, produk.getStokSaatIni());
            ps.setInt(9, produk.getStokMinimum());
            ps.setString(10, produk.getSatuan());
            
            if (produk.getTanggalExpired() != null) {
                ps.setDate(11, new java.sql.Date(produk.getTanggalExpired().getTime()));
            } else {
                ps.setNull(11, Types.DATE);
            }
            
            ps.setString(12, produk.getStatus());
            ps.setString(13, produk.getDeskripsi());
            ps.setString(14, produk.getFotoProduk());
            ps.setString(15, produk.getKodeProduk());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error update produk: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 5. DELETE - Hapus data produk
     */
    public boolean delete(String kodeProduk) {
        String sql = "DELETE FROM master_produk WHERE kode_produk = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeProduk);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error delete produk: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 6. SEARCH - Cari produk berdasarkan keyword
     */
    public List<Produk> search(String keyword) {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM master_produk " +
                     "WHERE nama_produk LIKE ? " +
                     "OR kode_produk LIKE ? " +
                     "OR kategori_produk LIKE ? " +
                     "ORDER BY kode_produk ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produk p = extractProdukFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error search produk: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 7. GENERATE KODE - Generate kode produk berikutnya
     */
    public String generateKodeProduk() {
        String sql = "SELECT kode_produk FROM master_produk " +
                     "ORDER BY kode_produk DESC LIMIT 1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_produk"); // PRD-005
                int lastNumber = Integer.parseInt(lastKode.substring(4));
                int nextNumber = lastNumber + 1;
                return String.format("PRD-%03d", nextNumber); // PRD-006
            } else {
                return "PRD-001";
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error generate kode: " + e.getMessage());
            e.printStackTrace();
            return "PRD-001";
        }
    }
    
    /**
     * 8. GET PRODUK STOK MENIPIS
     */
    public List<Produk> getProdukStokMenipis() {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM master_produk " +
                     "WHERE stok_saat_ini <= stok_minimum " +
                     "AND status = 'Aktif' " +
                     "ORDER BY stok_saat_ini ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Produk p = extractProdukFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error get stok menipis: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 9. UPDATE STOK - Kurangi/tambah stok produk
     */
    public boolean updateStok(String kodeProduk, int jumlah) {
        String sql = "UPDATE master_produk SET stok_saat_ini = stok_saat_ini + ? " +
                     "WHERE kode_produk = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, jumlah);  // Positif untuk tambah, negatif untuk kurang
            ps.setString(2, kodeProduk);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error update stok: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
        /**
     * Get riwayat transaksi produk (dummy data untuk sementara)
     * Nanti akan diambil dari tabel transaksi setelah Form Transaksi dibuat
     */
    public List<Object[]> getRiwayatTransaksi() {
        List<Object[]> list = new ArrayList<>();

        // Query untuk join dengan tabel transaksi (jika sudah ada)
        // Untuk sementara, return semua produk dengan total terjual = 0
        String sql = "SELECT kode_produk, nama_produk, kategori_produk, " +
                     "stok_saat_ini, satuan, harga_jual " +
                     "FROM master_produk " +
                     "WHERE status = 'Aktif' " +
                     "ORDER BY nama_produk ASC";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getString("kode_produk");
                row[1] = rs.getString("nama_produk");
                row[2] = rs.getString("kategori_produk");
                row[3] = 0;  // Total terjual (dummy, nanti dari tabel transaksi)
                row[4] = rs.getString("satuan");
                row[5] = rs.getDouble("harga_jual");

                list.add(row);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error getRiwayatTransaksi: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }
    
    /**
     * Helper method: Extract Produk dari ResultSet
     */
    private Produk extractProdukFromResultSet(ResultSet rs) throws SQLException {
        Produk p = new Produk();
        p.setKodeProduk(rs.getString("kode_produk"));
        p.setNamaProduk(rs.getString("nama_produk"));
        p.setKategoriProduk(rs.getString("kategori_produk"));
        p.setJenis(rs.getString("jenis"));
        p.setNamaSupplier(rs.getString("nama_supplier"));
        p.setTeleponSupplier(rs.getString("telepon_supplier"));
        p.setHargaBeli(rs.getDouble("harga_beli"));
        p.setHargaJual(rs.getDouble("harga_jual"));
        p.setStokSaatIni(rs.getInt("stok_saat_ini"));
        p.setStokMinimum(rs.getInt("stok_minimum"));
        p.setSatuan(rs.getString("satuan"));
        p.setTanggalExpired(rs.getDate("tanggal_expired"));
        p.setStatus(rs.getString("status"));
        p.setDeskripsi(rs.getString("deskripsi"));
        p.setFotoProduk(rs.getString("foto_produk"));
        
        return p;
    }
}
