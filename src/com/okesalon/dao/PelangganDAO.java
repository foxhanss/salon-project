/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.dao;
import koneksi.koneksi;
import com.okesalon.model.Pelanggan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author T480
 */
public class PelangganDAO {
    private Connection connection;
    
    public PelangganDAO() {
        this.connection = koneksi.getConnection();
    }
    
    /**
     * 1. CREATE - Tambah pelanggan baru
     */
    public boolean insert(Pelanggan pelanggan) {
        String sql = "INSERT INTO master_pelanggan " +
                     "(kode_pelanggan, nama_lengkap, no_telepon, email, tanggal_lahir, " +
                     "jenis_kelamin, alamat, tanggal_registrasi, membership_type, " +
                     "discount_member, total_spending, catatan_khusus) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, pelanggan.getKodePelanggan());
            ps.setString(2, pelanggan.getNamaLengkap());
            ps.setString(3, pelanggan.getNoTelepon());
            ps.setString(4, pelanggan.getEmail());
            ps.setDate(5, new java.sql.Date(pelanggan.getTanggalLahir().getTime()));
            ps.setString(6, pelanggan.getJenisKelamin());
            ps.setString(7, pelanggan.getAlamat());
            ps.setDate(8, new java.sql.Date(pelanggan.getTanggalRegistrasi().getTime()));
            ps.setString(9, pelanggan.getMembershipType());
            ps.setString(10, pelanggan.getDiscountMember());
            ps.setDouble(11, pelanggan.getTotalSpending());
            ps.setString(12, pelanggan.getCatatanKhusus());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error insert pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 2. READ - Ambil semua data pelanggan
     */
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan ORDER BY kode_pelanggan ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setKodePelanggan(rs.getString("kode_pelanggan"));
                p.setNamaLengkap(rs.getString("nama_lengkap"));
                p.setNoTelepon(rs.getString("no_telepon"));
                p.setEmail(rs.getString("email"));
                p.setTanggalLahir(rs.getDate("tanggal_lahir"));
                p.setJenisKelamin(rs.getString("jenis_kelamin"));
                p.setAlamat(rs.getString("alamat"));
                p.setTanggalRegistrasi(rs.getDate("tanggal_registrasi"));
                p.setMembershipType(rs.getString("membership_type"));
                p.setDiscountMember(rs.getString("discount_member"));
                p.setTotalSpending(rs.getDouble("total_spending"));
                p.setCatatanKhusus(rs.getString("catatan_khusus"));
                
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getAll pelanggan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 3. READ - Ambil data pelanggan berdasarkan kode
     */
    public Pelanggan getByKode(String kodePelanggan) {
        String sql = "SELECT * FROM master_pelanggan WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodePelanggan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setKodePelanggan(rs.getString("kode_pelanggan"));
                p.setNamaLengkap(rs.getString("nama_lengkap"));
                p.setNoTelepon(rs.getString("no_telepon"));
                p.setEmail(rs.getString("email"));
                p.setTanggalLahir(rs.getDate("tanggal_lahir"));
                p.setJenisKelamin(rs.getString("jenis_kelamin"));
                p.setAlamat(rs.getString("alamat"));
                p.setTanggalRegistrasi(rs.getDate("tanggal_registrasi"));
                p.setMembershipType(rs.getString("membership_type"));
                p.setDiscountMember(rs.getString("discount_member"));
                p.setTotalSpending(rs.getDouble("total_spending"));
                p.setCatatanKhusus(rs.getString("catatan_khusus"));
                
                return p;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByKode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 4. UPDATE - Ubah data pelanggan
     */
    public boolean update(Pelanggan pelanggan) {
        String sql = "UPDATE master_pelanggan SET " +
                     "nama_lengkap = ?, no_telepon = ?, email = ?, tanggal_lahir = ?, " +
                     "jenis_kelamin = ?, alamat = ?, tanggal_registrasi = ?, " +
                     "membership_type = ?, discount_member = ?," +
                     "total_spending = ?, catatan_khusus = ? " +
                     "WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, pelanggan.getNamaLengkap());
            ps.setString(2, pelanggan.getNoTelepon());
            ps.setString(3, pelanggan.getEmail());
            ps.setDate(4, new java.sql.Date(pelanggan.getTanggalLahir().getTime()));
            ps.setString(5, pelanggan.getJenisKelamin());
            ps.setString(6, pelanggan.getAlamat());
            ps.setDate(7, new java.sql.Date(pelanggan.getTanggalRegistrasi().getTime()));
            ps.setString(8, pelanggan.getMembershipType());
            ps.setString(9, pelanggan.getDiscountMember());
            ps.setDouble(10, pelanggan.getTotalSpending());
            ps.setString(11, pelanggan.getCatatanKhusus());
            ps.setString(12, pelanggan.getKodePelanggan());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error update pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 5. DELETE - Hapus data pelanggan
     */
    public boolean delete(String kodePelanggan) {
        String sql = "DELETE FROM master_pelanggan WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodePelanggan);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error delete pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 6. SEARCH - Cari pelanggan berdasarkan keyword
     */
    public List<Pelanggan> search(String keyword) {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE nama_lengkap LIKE ? " +
                     "OR kode_pelanggan LIKE ? " +
                     "OR no_telepon LIKE ? " +
                     "ORDER BY kode_pelanggan ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setKodePelanggan(rs.getString("kode_pelanggan"));
                p.setNamaLengkap(rs.getString("nama_lengkap"));
                p.setNoTelepon(rs.getString("no_telepon"));
                p.setEmail(rs.getString("email"));
                p.setTanggalLahir(rs.getDate("tanggal_lahir"));
                p.setJenisKelamin(rs.getString("jenis_kelamin"));
                p.setAlamat(rs.getString("alamat"));
                p.setTanggalRegistrasi(rs.getDate("tanggal_registrasi"));
                p.setMembershipType(rs.getString("membership_type"));
                p.setDiscountMember(rs.getString("discount_member"));
                p.setTotalSpending(rs.getDouble("total_spending"));
                p.setCatatanKhusus(rs.getString("catatan_khusus"));
                
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error search pelanggan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 7. GENERATE KODE - Generate kode pelanggan berikutnya (PLG-001, PLG-002, ...)
     */
    public String generateKodePelanggan() {
        String sql = "SELECT kode_pelanggan FROM master_pelanggan " +
                     "ORDER BY kode_pelanggan DESC LIMIT 1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_pelanggan"); // misal: PLG-005
                int lastNumber = Integer.parseInt(lastKode.substring(4)); // ambil "005" → 5
                int nextNumber = lastNumber + 1;
                return String.format("PLG-%03d", nextNumber); // PLG-006
            } else {
                return "PLG-001"; // Jika belum ada data
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error generate kode: " + e.getMessage());
            e.printStackTrace();
            return "PLG-001";
        }
    }
}
