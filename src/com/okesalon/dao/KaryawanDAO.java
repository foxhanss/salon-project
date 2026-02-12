package com.okesalon.dao;
import com.okesalon.util.koneksi;
import com.okesalon.model.Karyawan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KaryawanDAO {
    private Connection connection;
    
    public KaryawanDAO() {
        this.connection = koneksi.getConnection();
    }

    public boolean insert(Karyawan karyawan) {
        String sql = "INSERT INTO master_karyawan " +
                     "(kode_karyawan, nik, nama_lengkap, jabatan, spesialisasi, no_telpon, " +
                     "email, alamat_lengkap, tanggal_bergabung, status_kepegawaian, " +
                     "gaji_pokok, komisi, foto_karyawan) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, karyawan.getKodeKaryawan());
            ps.setString(2, karyawan.getNik());
            ps.setString(3, karyawan.getNamaLengkap());
            ps.setString(4, karyawan.getJabatan());
            ps.setString(5, karyawan.getSpesialisasi());
            ps.setString(6, karyawan.getNoTelpon());
            ps.setString(7, karyawan.getEmail());
            ps.setString(8, karyawan.getAlamatLengkap());
            ps.setDate(9, new java.sql.Date(karyawan.getTanggalBergabung().getTime()));
            ps.setString(10, karyawan.getStatusKepegawaian());
            ps.setDouble(11, karyawan.getGajiPokok());
            ps.setDouble(12, karyawan.getKomisi());
            ps.setString(13, karyawan.getFotoKaryawan());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error insert karyawan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Karyawan> getAll() {
        List<Karyawan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_karyawan ORDER BY kode_karyawan ASC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Karyawan k = new Karyawan();
                k.setKodeKaryawan(rs.getString("kode_karyawan"));
                k.setNik(rs.getString("nik"));
                k.setNamaLengkap(rs.getString("nama_lengkap"));
                k.setJabatan(rs.getString("jabatan"));
                k.setSpesialisasi(rs.getString("spesialisasi"));
                k.setNoTelpon(rs.getString("no_telpon"));
                k.setEmail(rs.getString("email"));
                k.setAlamatLengkap(rs.getString("alamat_lengkap"));
                k.setTanggalBergabung(rs.getDate("tanggal_bergabung"));
                k.setStatusKepegawaian(rs.getString("status_kepegawaian"));
                k.setGajiPokok(rs.getDouble("gaji_pokok"));
                k.setKomisi(rs.getDouble("komisi"));
                k.setFotoKaryawan(rs.getString("foto_karyawan"));
                
                list.add(k);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getAll karyawan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    

    public Karyawan getByKode(String kodeKaryawan) {
        String sql = "SELECT * FROM master_karyawan WHERE kode_karyawan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeKaryawan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Karyawan k = new Karyawan();
                k.setKodeKaryawan(rs.getString("kode_karyawan"));
                k.setNik(rs.getString("nik"));
                k.setNamaLengkap(rs.getString("nama_lengkap"));
                k.setJabatan(rs.getString("jabatan"));
                k.setSpesialisasi(rs.getString("spesialisasi"));
                k.setNoTelpon(rs.getString("no_telpon"));
                k.setEmail(rs.getString("email"));
                k.setAlamatLengkap(rs.getString("alamat_lengkap"));
                k.setTanggalBergabung(rs.getDate("tanggal_bergabung"));
                k.setStatusKepegawaian(rs.getString("status_kepegawaian"));
                k.setGajiPokok(rs.getDouble("gaji_pokok"));
                k.setKomisi(rs.getDouble("komisi"));
                k.setFotoKaryawan(rs.getString("foto_karyawan"));
                
                return k;
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByKode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    public boolean update(Karyawan karyawan) {
        String sql = "UPDATE master_karyawan SET " +
                     "nik = ?, nama_lengkap = ?, jabatan = ?, spesialisasi = ?, no_telpon = ?, " +
                     "email = ?, alamat_lengkap = ?, tanggal_bergabung = ?, " +
                     "status_kepegawaian = ?, gaji_pokok = ?, komisi = ?, foto_karyawan = ? " +
                     "WHERE kode_karyawan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, karyawan.getNik());
            ps.setString(2, karyawan.getNamaLengkap());
            ps.setString(3, karyawan.getJabatan());
            ps.setString(4, karyawan.getSpesialisasi());
            ps.setString(5, karyawan.getNoTelpon());
            ps.setString(6, karyawan.getEmail());
            ps.setString(7, karyawan.getAlamatLengkap());
            ps.setDate(8, new java.sql.Date(karyawan.getTanggalBergabung().getTime()));
            ps.setString(9, karyawan.getStatusKepegawaian());
            ps.setDouble(10, karyawan.getGajiPokok());
            ps.setDouble(11, karyawan.getKomisi());
            ps.setString(12, karyawan.getFotoKaryawan());
            ps.setString(13, karyawan.getKodeKaryawan());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error update karyawan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String kodeKaryawan) {
        String sql = "DELETE FROM master_karyawan WHERE kode_karyawan = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeKaryawan);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error delete karyawan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Karyawan> search(String keyword) {
        List<Karyawan> list = new ArrayList<>();
        String sql = "SELECT * FROM master_karyawan " +
                     "WHERE nama_lengkap LIKE ? " +
                     "OR kode_karyawan LIKE ? " +
                     "OR nik LIKE ? " +
                     "OR jabatan LIKE ? " +
                     "ORDER BY kode_karyawan ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            ps.setString(4, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Karyawan k = new Karyawan();
                k.setKodeKaryawan(rs.getString("kode_karyawan"));
                k.setNik(rs.getString("nik"));
                k.setNamaLengkap(rs.getString("nama_lengkap"));
                k.setJabatan(rs.getString("jabatan"));
                k.setSpesialisasi(rs.getString("spesialisasi"));
                k.setNoTelpon(rs.getString("no_telpon"));
                k.setEmail(rs.getString("email"));
                k.setAlamatLengkap(rs.getString("alamat_lengkap"));
                k.setTanggalBergabung(rs.getDate("tanggal_bergabung"));
                k.setStatusKepegawaian(rs.getString("status_kepegawaian"));
                k.setGajiPokok(rs.getDouble("gaji_pokok"));
                k.setKomisi(rs.getDouble("komisi"));
                k.setFotoKaryawan(rs.getString("foto_karyawan"));
                
                list.add(k);
            }
            
        } catch (SQLException e) {
            System.err.println("Error search karyawan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public String generateKodeKaryawan() {
        String sql = "SELECT kode_karyawan FROM master_karyawan " +
                     "ORDER BY kode_karyawan DESC LIMIT 1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_karyawan");
                int lastNumber = Integer.parseInt(lastKode.substring(4));
                int nextNumber = lastNumber + 1;
                return String.format("KRY-%03d", nextNumber);
            } else {
                return "KRY-001";
            }
            
        } catch (SQLException e) {
            System.err.println("Error generate kode: " + e.getMessage());
            e.printStackTrace();
            return "KRY-001";
        }
    }

    public boolean isNIKExists(String nik, String excludeKode) {
        String sql = "SELECT COUNT(*) FROM master_karyawan WHERE nik = ? AND kode_karyawan != ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nik);
            ps.setString(2, excludeKode == null ? "" : excludeKode);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("Error check NIK: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
}