/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.dao;
import koneksi.koneksi;
import com.okesalon.model.ArsipDokumen;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author T480
 */
public class ArsipDokumenDAO {
    private Connection connection;
    
    public ArsipDokumenDAO() {
        this.connection = koneksi.getConnection();
    }
    
    /**
     * 1. CREATE - Tambah dokumen baru
     */
    public boolean insert(ArsipDokumen dokumen) {
        String sql = "INSERT INTO arsip_dokumen " +
                     "(id_dokumen, kategori_dokumen, judul_dokumen, tanggal_dokumen, " +
                     "tanggal_expired, status, deskripsi, file_path) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dokumen.getIdDokumen());
            ps.setString(2, dokumen.getKategoriDokumen());
            ps.setString(3, dokumen.getJudulDokumen());
            ps.setDate(4, new java.sql.Date(dokumen.getTanggalDokumen().getTime()));
            
            if (dokumen.getTanggalExpired() != null) {
                ps.setDate(5, new java.sql.Date(dokumen.getTanggalExpired().getTime()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            
            ps.setString(6, dokumen.getStatus());
            ps.setString(7, dokumen.getDeskripsi());
            ps.setString(8, dokumen.getFilePath());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error insert dokumen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 2. READ - Ambil semua data dokumen
     */
    public List<ArsipDokumen> getAll() {
        List<ArsipDokumen> list = new ArrayList<>();
        String sql = "SELECT * FROM arsip_dokumen ORDER BY tanggal_dokumen DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getAll dokumen: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 3. READ - Ambil dokumen berdasarkan ID
     */
    public ArsipDokumen getById(String idDokumen) {
        String sql = "SELECT * FROM arsip_dokumen WHERE id_dokumen = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, idDokumen);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractDokumenFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getById: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 4. UPDATE - Ubah data dokumen
     */
    public boolean update(ArsipDokumen dokumen) {
        String sql = "UPDATE arsip_dokumen SET " +
                     "kategori_dokumen = ?, judul_dokumen = ?, tanggal_dokumen = ?, " +
                     "tanggal_expired = ?, status = ?, deskripsi = ?, file_path = ? " +
                     "WHERE id_dokumen = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dokumen.getKategoriDokumen());
            ps.setString(2, dokumen.getJudulDokumen());
            ps.setDate(3, new java.sql.Date(dokumen.getTanggalDokumen().getTime()));
            
            if (dokumen.getTanggalExpired() != null) {
                ps.setDate(4, new java.sql.Date(dokumen.getTanggalExpired().getTime()));
            } else {
                ps.setNull(4, Types.DATE);
            }
            
            ps.setString(5, dokumen.getStatus());
            ps.setString(6, dokumen.getDeskripsi());
            ps.setString(7, dokumen.getFilePath());
            ps.setString(8, dokumen.getIdDokumen());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error update dokumen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 5. DELETE - Hapus data dokumen
     */
    public boolean delete(String idDokumen) {
        String sql = "DELETE FROM arsip_dokumen WHERE id_dokumen = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, idDokumen);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error delete dokumen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 6. SEARCH - Cari dokumen berdasarkan keyword
     */
    public List<ArsipDokumen> search(String keyword) {
        List<ArsipDokumen> list = new ArrayList<>();
        String sql = "SELECT * FROM arsip_dokumen " +
                     "WHERE judul_dokumen LIKE ? " +
                     "OR id_dokumen LIKE ? " +
                     "OR kategori_dokumen LIKE ? " +
                     "ORDER BY tanggal_dokumen DESC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error search dokumen: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 7. GENERATE ID - Generate ID dokumen berikutnya
     */
    public String generateIdDokumen() {
        String sql = "SELECT id_dokumen FROM arsip_dokumen " +
                     "ORDER BY id_dokumen DESC LIMIT 1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastId = rs.getString("id_dokumen"); // DOC-005
                int lastNumber = Integer.parseInt(lastId.substring(4));
                int nextNumber = lastNumber + 1;
                return String.format("DOC-%03d", nextNumber); // DOC-006
            } else {
                return "DOC-001";
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error generate ID: " + e.getMessage());
            e.printStackTrace();
            return "DOC-001";
        }
    }
    
    /**
     * 8. GET EXPIRED DOCUMENTS - Ambil dokumen yang expired atau akan expired
     */
    public List<ArsipDokumen> getDokumenExpired(int hariSebelumExpired) {
        List<ArsipDokumen> list = new ArrayList<>();
        
        // Hitung tanggal batas (hari ini + X hari)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, hariSebelumExpired);
        java.sql.Date tanggalBatas = new java.sql.Date(cal.getTimeInMillis());
        
        String sql = "SELECT * FROM arsip_dokumen " +
                     "WHERE tanggal_expired IS NOT NULL " +
                     "AND tanggal_expired <= ? " +
                     "AND status = 'Aktif' " +
                     "ORDER BY tanggal_expired ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, tanggalBatas);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getDokumenExpired: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 9. AUTO UPDATE STATUS - Update status dokumen yang sudah expired
     */
    public int autoUpdateStatusExpired() {
        String sql = "UPDATE arsip_dokumen SET status = 'Expired' " +
                     "WHERE tanggal_expired < CURDATE() " +
                     "AND status = 'Aktif'";
        
        try (Statement stmt = connection.createStatement()) {
            return stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.err.println("❌ Error autoUpdateStatus: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Helper method: Extract ArsipDokumen dari ResultSet
     */
    private ArsipDokumen extractDokumenFromResultSet(ResultSet rs) throws SQLException {
        ArsipDokumen d = new ArsipDokumen();
        d.setIdDokumen(rs.getString("id_dokumen"));
        d.setKategoriDokumen(rs.getString("kategori_dokumen"));
        d.setJudulDokumen(rs.getString("judul_dokumen"));
        d.setTanggalDokumen(rs.getDate("tanggal_dokumen"));
        d.setTanggalExpired(rs.getDate("tanggal_expired"));
        d.setStatus(rs.getString("status"));
        d.setDeskripsi(rs.getString("deskripsi"));
        d.setFilePath(rs.getString("file_path"));
        
        return d;
    }
}
