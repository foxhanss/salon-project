package com.okesalon.dao;
import com.okesalon.util.koneksi;
import com.okesalon.model.Pelanggan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PelangganDAO {
    
    public PelangganDAO() {}

    public boolean insert(Pelanggan pelanggan) {
        String sql = "INSERT INTO master_pelanggan " +
                     "(kode_pelanggan, nama_lengkap, no_telepon, email, tanggal_lahir, " +
                     "jenis_kelamin, alamat, tanggal_registrasi, membership_type, " +
                     "discount_member, status, total_spending, catatan_khusus) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, pelanggan.getKodePelanggan());
            ps.setString(2, pelanggan.getNamaLengkap());
            ps.setString(3, pelanggan.getNoTelepon());
            ps.setString(4, pelanggan.getEmail());
            
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

            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Pelanggan " + pelanggan.getKodePelanggan() + " berhasil ditambahkan");
                return true;
            }
            
            return false;

        } catch (SQLException e) {
            System.err.println("Error insert pelanggan: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error insert pelanggan:\n" + e.getMessage(),
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status = 'Aktif' " +
                     "ORDER BY kode_pelanggan ASC";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            int count = 0;
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
                count++;
            }
            
            System.out.println("getAll() loaded " + count + " active pelanggan");
            
        } catch (SQLException e) {
            System.err.println("Error getAll pelanggan: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }
        
        return list;
    }
    
    public List<Pelanggan> getAllIncludingInactive() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status != 'Deleted' " +
                     "ORDER BY kode_pelanggan ASC";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            int count = 0;
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
                count++;
            }
            
            System.out.println("getAllIncludingInactive() loaded " + count + " pelanggan");
            
        } catch (SQLException e) {
            System.err.println("Error getAllIncludingInactive: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }
        
        return list;
    }

    public Pelanggan getByKode(String kodePelanggan) {
        String sql = "SELECT * FROM master_pelanggan WHERE kode_pelanggan = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, kodePelanggan);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractPelangganFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByKode: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        
        return null;
    }
    
    public boolean update(Pelanggan pelanggan) {
        String sql = "UPDATE master_pelanggan SET " +
                     "nama_lengkap = ?, no_telepon = ?, email = ?, tanggal_lahir = ?, " +
                     "jenis_kelamin = ?, alamat = ?, tanggal_registrasi = ?, " +
                     "membership_type = ?, discount_member = ?, status = ?, " +
                     "total_spending = ?, catatan_khusus = ?, " +
                     "updated_at = CURRENT_TIMESTAMP " +
                     "WHERE kode_pelanggan = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, pelanggan.getNamaLengkap());
            ps.setString(2, pelanggan.getNoTelepon());
            ps.setString(3, pelanggan.getEmail());
            
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
            ps.setString(10, pelanggan.getStatus());
            ps.setDouble(11, pelanggan.getTotalSpending());
            ps.setString(12, pelanggan.getCatatanKhusus());
            ps.setString(13, pelanggan.getKodePelanggan());
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Pelanggan " + pelanggan.getKodePelanggan() + " berhasil diupdate");
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error update pelanggan: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error update pelanggan:\n" + e.getMessage(),
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            closeResources(null, ps, conn);
        }
    }
    
    public boolean softDelete(String kodePelanggan, String deletedBy) {
        String sql = "UPDATE master_pelanggan " +
                     "SET status = 'Non-Aktif', " +
                     "    deleted_at = CURRENT_TIMESTAMP, " +
                     "    deleted_by = ?, " +
                     "    updated_at = CURRENT_TIMESTAMP " +
                     "WHERE kode_pelanggan = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, deletedBy);
            ps.setString(2, kodePelanggan);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Pelanggan " + kodePelanggan + " dinonaktifkan oleh " + deletedBy);
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println("❌ Error soft delete: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error menonaktifkan pelanggan:\n" + e.getMessage(),
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            closeResources(null, ps, conn);
        }
    }
    
    @Deprecated
    public boolean hardDelete(String kodePelanggan, String deletedBy) {
        String sql = "UPDATE master_pelanggan " +
                     "SET status = 'Deleted', " +
                     "    deleted_at = CURRENT_TIMESTAMP, " +
                     "    deleted_by = ? " +
                     "WHERE kode_pelanggan = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, deletedBy);
            ps.setString(2, kodePelanggan);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Pelanggan " + kodePelanggan + " dihapus permanen oleh " + deletedBy);
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error hard delete: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(null, ps, conn);
        }
    }
    
    public boolean restore(String kodePelanggan, String restoredBy) {
        String sql = "UPDATE master_pelanggan " +
                     "SET status = 'Aktif', " +
                     "    deleted_at = NULL, " +
                     "    deleted_by = NULL, " +
                     "    updated_at = CURRENT_TIMESTAMP " +
                     "WHERE kode_pelanggan = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, kodePelanggan);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Pelanggan " + kodePelanggan + " diaktifkan kembali oleh " + restoredBy);
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error restore: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error mengaktifkan kembali pelanggan:\n" + e.getMessage(),
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            closeResources(null, ps, conn);
        }
    }
    
    public List<Pelanggan> search(String keyword) {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status != 'Deleted' AND (" +
                     "nama_lengkap LIKE ? " +
                     "OR kode_pelanggan LIKE ? " +
                     "OR no_telepon LIKE ? " +
                     "OR email LIKE ?) " +
                     "ORDER BY kode_pelanggan ASC";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            ps.setString(4, pattern);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("Error search pelanggan: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        
        return list;
    }
    
    public Pelanggan getPelangganByNama(String namaLengkap) {
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE nama_lengkap = ? AND status = 'Aktif'";
        
        System.out.println("getPelangganByNama() called: '" + namaLengkap + "'");
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return null;
            }
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, namaLengkap);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                System.out.println("FOUND: " + p.getKodePelanggan() + " | " + p.getNamaLengkap());
                return p;
            } else {
                System.out.println("NOT FOUND atau status bukan Aktif: '" + namaLengkap + "'");
            }
            
        } catch (SQLException e) {
            System.err.println("Error getPelangganByNama: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        
        return null;
    }
    
    public List<Pelanggan> getInactiveOnly() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status = 'Non-Aktif' " +
                     "ORDER BY deleted_at DESC";
        
        System.out.println("getInactiveOnly() called");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            int count = 0;
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
                count++;
            }
            
            System.out.println("Found " + count + " inactive pelanggan");
            
        } catch (SQLException e) {
            System.err.println("Error getInactiveOnly: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }
        
        return list;
    }
    
    public List<Pelanggan> getDeletedOnly() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE status = 'Deleted' " +
                     "ORDER BY deleted_at DESC";
        
        System.out.println("getDeletedOnly() called");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            int count = 0;
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
                count++;
            }
            
            System.out.println("Found " + count + " deleted pelanggan");
            
        } catch (SQLException e) {
            System.err.println("Error getDeletedOnly: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }
        
        return list;
    }
    
    public List<Pelanggan> getAllIncludingDeleted() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_pelanggan ORDER BY kode_pelanggan ASC";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Pelanggan p = extractPelangganFromResultSet(rs);
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getAllIncludingDeleted: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }
        
        return list;
    }
    
    public Pelanggan getByNoTelepon(String noTelepon) {
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE no_telepon = ? AND status != 'Deleted'";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, noTelepon);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractPelangganFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByNoTelepon: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        
        return null;
    }
    
    public Pelanggan getByEmail(String email) {
        String sql = "SELECT * FROM master_pelanggan " +
                     "WHERE email = ? AND status != 'Deleted'";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractPelangganFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByEmail: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        
        return null;
    }
    
    public String generateKodePelanggan() {
        String sql = "SELECT kode_pelanggan FROM master_pelanggan " +
                     "ORDER BY kode_pelanggan DESC LIMIT 1";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_pelanggan");
                int lastNumber = Integer.parseInt(lastKode.substring(4));
                int nextNumber = lastNumber + 1;
                String newKode = String.format("PLG-%03d", nextNumber);
                System.out.println("Generate kode: " + newKode);
                return newKode;
            } else {
                System.out.println("Generate kode: PLG-001 (first)");
                return "PLG-001";
            }
            
        } catch (SQLException e) {
            System.err.println("Error generate kode: " + e.getMessage());
            e.printStackTrace();
            return "PLG-001";
        } finally {
            closeResources(rs, stmt, conn);
        }
    }
    
    public boolean updateTotalSpending(String kodePelanggan, double amount) {
        String sql = "UPDATE master_pelanggan " +
                     "SET total_spending = total_spending + ?, " +
                     "    updated_at = CURRENT_TIMESTAMP " +
                     "WHERE kode_pelanggan = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setDouble(1, amount);
            ps.setString(2, kodePelanggan);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updateTotalSpending: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources(null, ps, conn);
        }
    }
    
    public int countByStatus(String status) {
        String sql = "SELECT COUNT(*) as total FROM master_pelanggan WHERE status = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("Error countByStatus: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, conn);
        }
        
        return 0;
    }
    
    public int countDeleted() {
        return countByStatus("Deleted");
    }
    
    public int countInactive() {
        return countByStatus("Non-Aktif");
    }
    
    public int countActive() {
        return countByStatus("Aktif");
    }
    
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
        
        try {
            p.setDeletedAt(rs.getTimestamp("deleted_at"));
            p.setDeletedBy(rs.getString("deleted_by"));
        } catch (SQLException e) {
        }
        
        return p;
    }

    private void closeResources(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
}