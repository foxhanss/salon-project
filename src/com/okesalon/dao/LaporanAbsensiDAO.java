package com.okesalon.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.okesalon.util.koneksi;

public class LaporanAbsensiDAO {
    public static class RowAbsensi {
        public int idAbsensi;
        public String kodeAbsensi;
        public Date tanggalAbsensi;
        public String namaKaryawan;
        public String jabatan;
        public Time jamMasuk;
        public Time jamKeluar;
        public String totalJamKerja;
        public String statusKehadiran;
        public String keterangan;
    }

    public List<RowAbsensi> getData(Date tglMulai, Date tglSampai, String jabatan, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT a.id_absensi, a.kode_absensi, a.tanggal_absensi, ");
        sql.append("  a.nama_karyawan, k.jabatan, a.jam_masuk, a.jam_keluar, ");
        sql.append("  a.total_jam_kerja, a.status_kehadiran, a.keterangan ");
        sql.append("FROM absensi a ");
        sql.append("INNER JOIN master_karyawan k ON a.kode_karyawan = k.kode_karyawan ");
        sql.append("WHERE a.tanggal_absensi BETWEEN ? AND ? ");
        
        if (jabatan != null && !jabatan.equals("Seluruh Karyawan")) {
            sql.append("  AND k.jabatan = ? ");
        }
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND (a.nama_karyawan LIKE ? OR a.kode_absensi LIKE ? ");
            sql.append(" OR a.status_kehadiran LIKE ? OR a.keterangan LIKE ?) ");
        }
        
        sql.append("ORDER BY a.tanggal_absensi DESC, a.nama_karyawan ASC");
        
        List<RowAbsensi> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            
            if (jabatan != null && !jabatan.equals("Seluruh Karyawan")) {
                ps.setString(i++, jabatan);
            }
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowAbsensi row = new RowAbsensi();
                    row.idAbsensi = rs.getInt("id_absensi");
                    row.kodeAbsensi = rs.getString("kode_absensi");
                    row.tanggalAbsensi = rs.getDate("tanggal_absensi");
                    row.namaKaryawan = rs.getString("nama_karyawan");
                    row.jabatan = rs.getString("jabatan");
                    row.jamMasuk = rs.getTime("jam_masuk");
                    row.jamKeluar = rs.getTime("jam_keluar");
                    row.totalJamKerja = rs.getString("total_jam_kerja");
                    row.statusKehadiran = rs.getString("status_kehadiran");
                    row.keterangan = rs.getString("keterangan");
                    list.add(row);
                }
            }
        }
        
        return list;
    }

    public List<String> getJabatan() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Seluruh Karyawan");
        
        String sql = "SELECT DISTINCT jabatan FROM master_karyawan " +
                    "WHERE status_kepegawaian = 'Aktif' ORDER BY jabatan";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                list.add(rs.getString("jabatan"));
            }
        }
        
        return list;
    }
}