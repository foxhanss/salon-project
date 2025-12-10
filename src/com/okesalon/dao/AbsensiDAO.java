/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.dao;
import koneksi.koneksi;
import com.okesalon.model.Absensi;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 *
 * @author T480
 */
public class AbsensiDAO {
    private Connection connection;
    
    public AbsensiDAO() {
        this.connection = koneksi.getConnection();
    }
    
    /**
     * 1. CREATE - Tambah absensi baru
     */
    public boolean insert(Absensi absensi) {
        String sql = "INSERT INTO absensi " +
                     "(kode_absensi, kode_karyawan, nama_karyawan, tanggal_absensi, " +
                     "jam_masuk, jam_keluar, total_jam_kerja, status_kehadiran, " +
                     "lokasi_checkin, foto_selfie, keterangan) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, absensi.getKodeAbsensi());
            ps.setString(2, absensi.getKodeKaryawan());
            ps.setString(3, absensi.getNamaKaryawan());
            ps.setDate(4, new java.sql.Date(absensi.getTanggalAbsensi().getTime()));
            ps.setTime(5, new java.sql.Time(absensi.getJamMasuk().getTime()));
            ps.setTime(6, new java.sql.Time(absensi.getJamKeluar().getTime()));
            ps.setString(7, absensi.getTotalJamKerja());
            ps.setString(8, absensi.getStatusKehadiran());
            ps.setString(9, absensi.getLokasiCheckIn());
            ps.setString(10, absensi.getFotoSelfie());
            ps.setString(11, absensi.getKeterangan());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("❌ Error: Karyawan sudah absen pada tanggal ini!");
            return false;
        } catch (SQLException e) {
            System.err.println("❌ Error insert absensi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 2. READ - Ambil semua data absensi
     */
    public List<Absensi> getAll() {
        List<Absensi> list = new ArrayList<>();
        String sql = "SELECT * FROM absensi ORDER BY tanggal_absensi DESC, jam_masuk DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Absensi a = new Absensi();
                a.setIdAbsensi(rs.getInt("id_absensi"));
                a.setKodeAbsensi(rs.getString("kode_absensi"));
                a.setKodeKaryawan(rs.getString("kode_karyawan"));
                a.setNamaKaryawan(rs.getString("nama_karyawan"));
                a.setTanggalAbsensi(rs.getDate("tanggal_absensi"));
                a.setJamMasuk(rs.getTime("jam_masuk"));
                a.setJamKeluar(rs.getTime("jam_keluar"));
                a.setTotalJamKerja(rs.getString("total_jam_kerja"));
                a.setStatusKehadiran(rs.getString("status_kehadiran"));
                a.setLokasiCheckIn(rs.getString("lokasi_checkin"));
                a.setFotoSelfie(rs.getString("foto_selfie"));
                a.setKeterangan(rs.getString("keterangan"));
                a.setCreatedAt(rs.getTimestamp("created_at"));
                a.setUpdatedAt(rs.getTimestamp("updated_at"));
                
                list.add(a);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getAll absensi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 3. READ - Ambil data absensi berdasarkan Kode Absensi
     */
    public Absensi getByKode(String kodeAbsensi) {
        String sql = "SELECT * FROM absensi WHERE kode_absensi = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeAbsensi);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Absensi a = new Absensi();
                a.setIdAbsensi(rs.getInt("id_absensi"));
                a.setKodeAbsensi(rs.getString("kode_absensi"));
                a.setKodeKaryawan(rs.getString("kode_karyawan"));
                a.setNamaKaryawan(rs.getString("nama_karyawan"));
                a.setTanggalAbsensi(rs.getDate("tanggal_absensi"));
                a.setJamMasuk(rs.getTime("jam_masuk"));
                a.setJamKeluar(rs.getTime("jam_keluar"));
                a.setTotalJamKerja(rs.getString("total_jam_kerja"));
                a.setStatusKehadiran(rs.getString("status_kehadiran"));
                a.setLokasiCheckIn(rs.getString("lokasi_checkin"));
                a.setFotoSelfie(rs.getString("foto_selfie"));
                a.setKeterangan(rs.getString("keterangan"));
                a.setCreatedAt(rs.getTimestamp("created_at"));
                a.setUpdatedAt(rs.getTimestamp("updated_at"));
                
                return a;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByKode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 4. UPDATE - Ubah data absensi
     */
    public boolean update(Absensi absensi) {
        String sql = "UPDATE absensi SET " +
                     "tanggal_absensi = ?, jam_masuk = ?, jam_keluar = ?, " +
                     "total_jam_kerja = ?, status_kehadiran = ?, lokasi_checkin = ?, " +
                     "foto_selfie = ?, keterangan = ? " +
                     "WHERE kode_absensi = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(absensi.getTanggalAbsensi().getTime()));
            ps.setTime(2, new java.sql.Time(absensi.getJamMasuk().getTime()));
            ps.setTime(3, new java.sql.Time(absensi.getJamKeluar().getTime()));
            ps.setString(4, absensi.getTotalJamKerja());
            ps.setString(5, absensi.getStatusKehadiran());
            ps.setString(6, absensi.getLokasiCheckIn());
            ps.setString(7, absensi.getFotoSelfie());
            ps.setString(8, absensi.getKeterangan());
            ps.setString(9, absensi.getKodeAbsensi());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error update absensi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 5. DELETE - Hapus data absensi
     */
    public boolean delete(String kodeAbsensi) {
        String sql = "DELETE FROM absensi WHERE kode_absensi = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeAbsensi);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("❌ Error delete absensi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 6. SEARCH - Cari absensi berdasarkan keyword
     */
    public List<Absensi> search(String keyword) {
        List<Absensi> list = new ArrayList<>();
        String sql = "SELECT * FROM absensi " +
                     "WHERE kode_absensi LIKE ? " +
                     "OR kode_karyawan LIKE ? " +
                     "OR nama_karyawan LIKE ? " +
                     "OR status_kehadiran LIKE ? " +
                     "ORDER BY tanggal_absensi DESC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            ps.setString(4, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Absensi a = new Absensi();
                a.setIdAbsensi(rs.getInt("id_absensi"));
                a.setKodeAbsensi(rs.getString("kode_absensi"));
                a.setKodeKaryawan(rs.getString("kode_karyawan"));
                a.setNamaKaryawan(rs.getString("nama_karyawan"));
                a.setTanggalAbsensi(rs.getDate("tanggal_absensi"));
                a.setJamMasuk(rs.getTime("jam_masuk"));
                a.setJamKeluar(rs.getTime("jam_keluar"));
                a.setTotalJamKerja(rs.getString("total_jam_kerja"));
                a.setStatusKehadiran(rs.getString("status_kehadiran"));
                a.setLokasiCheckIn(rs.getString("lokasi_checkin"));
                a.setFotoSelfie(rs.getString("foto_selfie"));
                a.setKeterangan(rs.getString("keterangan"));
                
                list.add(a);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error search absensi: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 7. GENERATE KODE - Generate kode absensi: ABS-YYYYMMDD-XXX
     */
    public String generateKodeAbsensi() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String tanggalStr = dateFormat.format(new Date());
        String prefix = "ABS-" + tanggalStr + "-";
        
        String sql = "SELECT kode_absensi FROM absensi " +
                     "WHERE kode_absensi LIKE ? " +
                     "ORDER BY kode_absensi DESC LIMIT 1";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, prefix + "%");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_absensi"); // ABS-20251204-001
                String lastNumber = lastKode.substring(lastKode.lastIndexOf("-") + 1); // "001"
                int nextNumber = Integer.parseInt(lastNumber) + 1;
                return prefix + String.format("%03d", nextNumber); // ABS-20251204-002
            } else {
                return prefix + "001"; // ABS-20251204-001
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error generate kode: " + e.getMessage());
            e.printStackTrace();
            return prefix + System.currentTimeMillis();
        }
    }
    
    /**
     * 8. VALIDASI - Cek apakah karyawan sudah absen hari ini
     */
    public boolean isAlreadyCheckedIn(String kodeKaryawan, Date tanggal) {
        String sql = "SELECT COUNT(*) FROM absensi " +
                     "WHERE kode_karyawan = ? AND DATE(tanggal_absensi) = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kodeKaryawan);
            ps.setDate(2, new java.sql.Date(tanggal.getTime()));
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error check attendance: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * 9. GET BY DATE RANGE - Ambil absensi berdasarkan range tanggal
     */
    public List<Absensi> getByDateRange(Date startDate, Date endDate) {
        List<Absensi> list = new ArrayList<>();
        String sql = "SELECT * FROM absensi " +
                     "WHERE tanggal_absensi BETWEEN ? AND ? " +
                     "ORDER BY tanggal_absensi DESC, jam_masuk DESC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Absensi a = new Absensi();
                a.setIdAbsensi(rs.getInt("id_absensi"));
                a.setKodeAbsensi(rs.getString("kode_absensi"));
                a.setKodeKaryawan(rs.getString("kode_karyawan"));
                a.setNamaKaryawan(rs.getString("nama_karyawan"));
                a.setTanggalAbsensi(rs.getDate("tanggal_absensi"));
                a.setJamMasuk(rs.getTime("jam_masuk"));
                a.setJamKeluar(rs.getTime("jam_keluar"));
                a.setTotalJamKerja(rs.getString("total_jam_kerja"));
                a.setStatusKehadiran(rs.getString("status_kehadiran"));
                a.setLokasiCheckIn(rs.getString("lokasi_checkin"));
                a.setFotoSelfie(rs.getString("foto_selfie"));
                a.setKeterangan(rs.getString("keterangan"));
                
                list.add(a);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByDateRange: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 10. GET TODAY - Ambil absensi hari ini
     */
    public List<Absensi> getTodayAttendance() {
        List<Absensi> list = new ArrayList<>();
        String sql = "SELECT * FROM absensi " +
                     "WHERE DATE(tanggal_absensi) = CURDATE() " +
                     "ORDER BY jam_masuk DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Absensi a = new Absensi();
                a.setIdAbsensi(rs.getInt("id_absensi"));
                a.setKodeAbsensi(rs.getString("kode_absensi"));
                a.setKodeKaryawan(rs.getString("kode_karyawan"));
                a.setNamaKaryawan(rs.getString("nama_karyawan"));
                a.setTanggalAbsensi(rs.getDate("tanggal_absensi"));
                a.setJamMasuk(rs.getTime("jam_masuk"));
                a.setJamKeluar(rs.getTime("jam_keluar"));
                a.setTotalJamKerja(rs.getString("total_jam_kerja"));
                a.setStatusKehadiran(rs.getString("status_kehadiran"));
                a.setLokasiCheckIn(rs.getString("lokasi_checkin"));
                a.setFotoSelfie(rs.getString("foto_selfie"));
                a.setKeterangan(rs.getString("keterangan"));
                
                list.add(a);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getTodayAttendance: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
}
