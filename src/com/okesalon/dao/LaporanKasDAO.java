package com.okesalon.dao;
import com.okesalon.util.koneksi;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaporanKasDAO {
    public static class RowKas {
        public Date tanggal;
        public String jenisKas;
        public String kategori;
        public String kode;
        public String deskripsi;
        public BigDecimal jumlah;
    }
    
    public List<RowKas> getData(Date tglMulai, Date tglSampai, String jenisKas, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM (");
        sql.append("  SELECT t.tanggal_transaksi AS tanggal, 'Kas Masuk' AS jenis_kas, ");
        sql.append("    'Layanan' AS kategori, t.kode_transaksi AS kode, ");
        sql.append("    t.nama_layanan AS deskripsi, t.total_pembayaran AS jumlah ");
        sql.append("  FROM transaksi_layanan t ");
        sql.append("  WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        sql.append("    AND t.status_pembayaran = 'Lunas' ");
        
        sql.append("  UNION ALL ");

        sql.append("  SELECT t.tanggal_transaksi AS tanggal, 'Kas Masuk' AS jenis_kas, ");
        sql.append("    'Penjualan Produk' AS kategori, t.kode_transaksi AS kode, ");
        sql.append("    t.nama_produk AS deskripsi, t.total_harga AS jumlah ");
        sql.append("  FROM transaksi_penjualan_produk t ");
        sql.append("  WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        
        sql.append("  UNION ALL ");
        
        sql.append("  SELECT t.tanggal_transaksi AS tanggal, 'Kas Keluar' AS jenis_kas, ");
        sql.append("    'Pembelian Produk' AS kategori, t.kode_transaksi AS kode, ");
        sql.append("    t.nama_produk AS deskripsi, t.total_harga AS jumlah ");
        sql.append("  FROM transaksi_pembelian_produk t ");
        sql.append("  WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        
        sql.append(") x WHERE 1=1 ");

        if (jenisKas != null && !jenisKas.equalsIgnoreCase("Semua")) {
            sql.append(" AND jenis_kas = ? ");
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND (kode LIKE ? OR deskripsi LIKE ? OR kategori LIKE ?) ");
        }
        
        sql.append(" ORDER BY tanggal DESC, jenis_kas, kategori ");
        
        List<RowKas> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);

            if (jenisKas != null && !jenisKas.equalsIgnoreCase("Semua")) {
                ps.setString(i++, jenisKas);
            }

            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowKas row = new RowKas();
                    row.tanggal = rs.getDate("tanggal");
                    row.jenisKas = rs.getString("jenis_kas");
                    row.kategori = rs.getString("kategori");
                    row.kode = rs.getString("kode");
                    row.deskripsi = rs.getString("deskripsi");
                    row.jumlah = rs.getBigDecimal("jumlah");
                    list.add(row);
                }
            }
        }
        
        return list;
    }
}