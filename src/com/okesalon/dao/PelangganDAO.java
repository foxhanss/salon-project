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
    
    // ==================== CRUD OPERATIONS ====================
    
    /**
     * 1. CREATE - Tambah pelanggan baru
     */
    public boolean insert(Pelanggan pelanggan) {
        String sql = "INSERT INTO master_pelanggan " +
                     "(kode_pelanggan, nama_lengkap, no_telepon, email, tanggal_lahir, " +
                     "jenis_kelamin, alamat, tanggal_registrasi, membership_type, " +
                     "discount_member, status, total_spending, catatan_khusus) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, pelanggan.getKodePelanggan());
            ps.setString(2, pelanggan.getNamaLengkap());
            ps.setString(3, pelanggan.getNoTelepon());
            ps.setString(4, pelanggan.getEmail());
            
            // ⭐ Handle null tanggal_lahir
            if (pelanggan.getTanggalLahir() != null) {
                ps.setDate(5, new java.sql.Date(pelanggan.getTanggalLahir().getTime()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            
            ps.setString(6, pelanggan.getJenisKelamin());
            ps.setString(7, pelanggan.getAlamat());
            ps.setDate(8, new java.sql.Date(pelanggan.getTanggalRegistrasi().getTime()));
            ps.setString(9, pelanggan.getMembershipType());
            ps.setString(10, pelanggan.getDiscountMember());
            ps.setString(11, pelanggan.getStatus());
            ps.setDouble(12, pelanggan.getTotalSpending());
            ps.setString(13, pelanggan.getCatatanKhusus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error insert pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 2. READ - Ambil semua data pelanggan AKTIF (exclude yang deleted)
     */
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        // ⭐ Tambahkan WHERE status != 'Deleted' untuk soft delete
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status != 'Deleted' " +
                     "ORDER BY kode_pelanggan ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);  // ⭐ Gunakan helper method
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
                return extractPelangganFromResultSet(rs);  // ⭐ Gunakan helper method
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
                     "membership_type = ?, discount_member = ?, status = ?, " +  // ⭐ Tambah status
                     "total_spending = ?, catatan_khusus = ? " +
                     "WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, pelanggan.getNamaLengkap());
            ps.setString(2, pelanggan.getNoTelepon());
            ps.setString(3, pelanggan.getEmail());
            
            // ⭐ Handle null tanggal_lahir
            if (pelanggan.getTanggalLahir() != null) {
                ps.setDate(4, new java.sql.Date(pelanggan.getTanggalLahir().getTime()));
            } else {
                ps.setNull(4, Types.DATE);
            }
            
            ps.setString(5, pelanggan.getJenisKelamin());
            ps.setString(6, pelanggan.getAlamat());
            ps.setDate(7, new java.sql.Date(pelanggan.getTanggalRegistrasi().getTime()));
            ps.setString(8, pelanggan.getMembershipType());
            ps.setString(9, pelanggan.getDiscountMember());
            ps.setString(10, pelanggan.getStatus());  // ⭐ Status
            ps.setDouble(11, pelanggan.getTotalSpending());
            ps.setString(12, pelanggan.getCatatanKhusus());
            ps.setString(13, pelanggan.getKodePelanggan());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error update pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 5. DELETE - HARD DELETE (hapus permanen) - TIDAK DIGUNAKAN
     * Method ini disimpan untuk backward compatibility tapi TIDAK digunakan
     * Gunakan softDelete() sebagai gantinya
     */
    @Deprecated
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
    
    // ==================== SOFT DELETE OPERATIONS ====================
    
    /**
     * 6. SOFT DELETE - Tandai pelanggan sebagai deleted (TIDAK hapus dari DB)
     */
    public boolean softDelete(String kodePelanggan, String deletedBy) {
        String sql = "UPDATE master_pelanggan " +
                     "SET status = 'Deleted', " +
                     "    deleted_at = NOW(), " +
                     "    deleted_by = ? " +
                     "WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, deletedBy);
            ps.setString(2, kodePelanggan);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("✅ Pelanggan " + kodePelanggan + " berhasil di-soft delete oleh " + deletedBy);
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error soft delete: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * 7. RESTORE - Kembalikan pelanggan yang sudah dihapus
     */
    public boolean restore(String kodePelanggan) {
        String sql = "UPDATE master_pelanggan " +
                     "SET status = 'Aktif', " +
                     "    deleted_at = NULL, " +
                     "    deleted_by = NULL " +
                     "WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodePelanggan);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("✅ Pelanggan " + kodePelanggan + " berhasil di-restore");
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error restore: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * 8. GET ALL INCLUDING DELETED - Untuk admin/report (include yang deleted)
     */
    public List<Pelanggan> getAllIncludingDeleted() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan ORDER BY kode_pelanggan ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getAllIncludingDeleted: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 9. GET DELETED ONLY - Ambil hanya pelanggan yang sudah dihapus
     */
    public List<Pelanggan> getDeletedOnly() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status = 'Deleted' " +
                     "ORDER BY deleted_at DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getDeletedOnly: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 10. COUNT DELETED - Hitung jumlah pelanggan yang dihapus
     */
    public int countDeleted() {
        String sql = "SELECT COUNT(*) as total FROM master_pelanggan WHERE status = 'Deleted'";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error countDeleted: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }
    
    // ==================== SEARCH & FILTER ====================
    
    /**
     * 11. SEARCH - Cari pelanggan berdasarkan keyword (exclude deleted)
     */
    public List<Pelanggan> search(String keyword) {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status != 'Deleted' AND (" +  // ⭐ Exclude deleted
                     "nama_lengkap LIKE ? " +
                     "OR kode_pelanggan LIKE ? " +
                     "OR no_telepon LIKE ? " +
                     "OR email LIKE ?) " +  // ⭐ Tambah email di search
                     "ORDER BY kode_pelanggan ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            ps.setString(4, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error search pelanggan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 12. GET BY MEMBERSHIP TYPE - Filter pelanggan berdasarkan tipe member
     */
    public List<Pelanggan> getByMembershipType(String membershipType) {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE membership_type = ? AND status != 'Deleted' " +
                     "ORDER BY kode_pelanggan ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, membershipType);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByMembershipType: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    // ==================== VALIDATION ====================
    
    /**
     * 13. GET BY NO TELEPON - Cari pelanggan berdasarkan no telepon (untuk validasi duplikat)
     */
    public Pelanggan getByNoTelepon(String noTelepon) {
        String sql = "SELECT * FROM master_pelanggan WHERE no_telepon = ? AND status != 'Deleted'";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, noTelepon);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractPelangganFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByNoTelepon: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 14. GET BY EMAIL - Cari pelanggan berdasarkan email (untuk validasi duplikat)
     */
    public Pelanggan getByEmail(String email) {
        String sql = "SELECT * FROM master_pelanggan WHERE email = ? AND status != 'Deleted'";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractPelangganFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByEmail: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 15. IS DUPLICATE - Cek apakah no telepon atau email sudah digunakan
     */
    public boolean isDuplicate(String noTelepon, String email, String excludeKode) {
        String sql = "SELECT COUNT(*) as total FROM master_pelanggan " +
                     "WHERE (no_telepon = ? OR email = ?) " +
                     "AND kode_pelanggan != ? " +
                     "AND status != 'Deleted'";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, noTelepon);
            ps.setString(2, email);
            ps.setString(3, excludeKode);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total") > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error isDuplicate: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * 16. GENERATE KODE - Generate kode pelanggan berikutnya (PLG-001, PLG-002, ...)
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
    
    /**
     * 17. UPDATE TOTAL SPENDING - Update total belanja pelanggan
     */
    public boolean updateTotalSpending(String kodePelanggan, double amount) {
        String sql = "UPDATE master_pelanggan " +
                     "SET total_spending = total_spending + ? " +
                     "WHERE kode_pelanggan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setString(2, kodePelanggan);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error updateTotalSpending: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 18. COUNT ACTIVE - Hitung jumlah pelanggan aktif
     */
    public int countActive() {
        String sql = "SELECT COUNT(*) as total FROM master_pelanggan WHERE status = 'Aktif'";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error countActive: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }
    
    /**
     * 19. COUNT BY MEMBERSHIP - Hitung jumlah pelanggan per tipe membership
     */
    public int countByMembership(String membershipType) {
        String sql = "SELECT COUNT(*) as total FROM master_pelanggan " +
                     "WHERE membership_type = ? AND status != 'Deleted'";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, membershipType);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error countByMembership: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }
    
    /**
     * 20. EXTRACT PELANGGAN FROM RESULTSET - Helper method untuk menghindari code duplication
     */
    private Pelanggan extractPelangganFromResultSet(ResultSet rs) throws SQLException {
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
        p.setStatus(rs.getString("status"));
        p.setTotalSpending(rs.getDouble("total_spending"));
        p.setCatatanKhusus(rs.getString("catatan_khusus"));
        
        // ⭐ Field soft delete
        p.setDeletedAt(rs.getTimestamp("deleted_at"));
        p.setDeletedBy(rs.getString("deleted_by"));
        
        return p;
    }
}
