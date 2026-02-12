package com.okesalon.dao;
import com.okesalon.util.koneksi;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaporanLabaRugiDAO {
    public static class RowLabaRugi {
        public Date tanggal;
        public String jenisLR;
        public String kategori;
        public String kode;
        public String deskripsi;
        public BigDecimal total;
    }
    
    public List<RowLabaRugi> getData(Date tglMulai, Date tglSampai, String jenisLR, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM (");
        sql.append("  SELECT t.tanggal_transaksi AS tanggal, 'Laba' AS jenis_lr, ");
        sql.append("    'Layanan' AS kategori, t.kode_transaksi AS kode, ");
        sql.append("    t.nama_layanan AS deskripsi, t.total_pembayaran AS total ");
        sql.append("  FROM transaksi_layanan t ");
        sql.append("  WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        sql.append("    AND t.status_pembayaran = 'Lunas' ");
        
        sql.append("  UNION ALL ");
        
        sql.append("  SELECT t.tanggal_transaksi AS tanggal, 'Laba' AS jenis_lr, ");
        sql.append("    'Penjualan Produk' AS kategori, t.kode_transaksi AS kode, ");
        sql.append("    t.nama_produk AS deskripsi, t.total_harga AS total ");
        sql.append("  FROM transaksi_penjualan_produk t ");
        sql.append("  WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        
        sql.append("  UNION ALL ");

        sql.append("  SELECT t.tanggal_transaksi AS tanggal, 'Rugi' AS jenis_lr, ");
        sql.append("    'Pembelian Produk' AS kategori, t.kode_transaksi AS kode, ");
        sql.append("    t.nama_produk AS deskripsi, t.total_harga AS total ");
        sql.append("  FROM transaksi_pembelian_produk t ");
        sql.append("  WHERE t.tanggal_transaksi BETWEEN ? AND ? ");
        
        sql.append(") x WHERE 1=1 ");

        if (jenisLR != null && !jenisLR.equalsIgnoreCase("Semua")) {
            sql.append(" AND jenis_lr = ? ");
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND (kode LIKE ? OR deskripsi LIKE ? OR kategori LIKE ?) ");
        }
        
        sql.append(" ORDER BY tanggal DESC, jenis_lr, kategori ");
        
        List<RowLabaRugi> list = new ArrayList<>();
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            
            int i = 1;
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            ps.setDate(i++, tglMulai);
            ps.setDate(i++, tglSampai);
            
            if (jenisLR != null && !jenisLR.equalsIgnoreCase("Semua")) {
                ps.setString(i++, jenisLR);
            }
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RowLabaRugi row = new RowLabaRugi();
                    row.tanggal = rs.getDate("tanggal");
                    row.jenisLR = rs.getString("jenis_lr");
                    row.kategori = rs.getString("kategori");
                    row.kode = rs.getString("kode");
                    row.deskripsi = rs.getString("deskripsi");
                    row.total = rs.getBigDecimal("total");
                    list.add(row);
                }
            }
        }
        
        return list;
    }
}