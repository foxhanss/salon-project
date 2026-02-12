package com.okesalon.dao;
import com.okesalon.util.koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LaporanPendapatanDAO {

    public static class Row {
        public Date tanggal;
        public String jenis;
        public String kode;
        public String deskripsi;
        public int qty;
        public java.math.BigDecimal harga;
        public java.math.BigDecimal total;
        public String pihak;
        public String metode;
    }

    private static final String SQL_BASE =
        "SELECT tanggal, jenis_transaksi, kode_transaksi, deskripsi, qty, harga_satuan, total, pihak, metode_pembayaran " +
        "FROM ( " +
        "   SELECT t.tanggal_transaksi AS tanggal, 'Layanan' AS jenis_transaksi, t.kode_transaksi AS kode_transaksi, " +
        "          t.nama_layanan AS deskripsi, 1 AS qty, t.harga_layanan AS harga_satuan, t.total_pembayaran AS total, " +
        "          t.nama_lengkap AS pihak, t.metode_pembayaran AS metode_pembayaran " +
        "   FROM transaksi_layanan t " +
        "   WHERE t.tanggal_transaksi BETWEEN ? AND ? " +

        "   UNION ALL " +

        "   SELECT t.tanggal_transaksi AS tanggal, 'Penjualan Produk' AS jenis_transaksi, t.kode_transaksi AS kode_transaksi, " +
        "          t.nama_produk AS deskripsi, t.jumlah_jual AS qty, t.harga_satuan AS harga_satuan, t.total_harga AS total, " +
        "          t.nama_pelanggan AS pihak, t.metode_pembayaran AS metode_pembayaran " +
        "   FROM transaksi_penjualan_produk t " +
        "   WHERE t.tanggal_transaksi BETWEEN ? AND ? " +

        "   UNION ALL " +

        "   SELECT t.tanggal_transaksi AS tanggal, 'Pembelian Produk' AS jenis_transaksi, t.kode_transaksi AS kode_transaksi, " +
        "          t.nama_produk AS deskripsi, t.jumlah_beli AS qty, t.harga_satuan AS harga_satuan, t.total_harga AS total, " +
        "          t.nama_supplier AS pihak, t.metode_pembayaran AS metode_pembayaran " +
        "   FROM transaksi_pembelian_produk t " +
        "   WHERE t.tanggal_transaksi BETWEEN ? AND ? " +
        ") x ";

    public List<Row> getData(Date mulai, Date sampai, String jenis, String keyword) throws Exception {
        StringBuilder sql = new StringBuilder(SQL_BASE);
        sql.append(" WHERE 1=1 ");

        boolean pakaiParamJenis = false;
        String nilaiJenisParam = null;

        if (jenis != null && !jenis.equalsIgnoreCase("Semua")) {
            if (jenis.equalsIgnoreCase("Layanan")) {
                sql.append(" AND jenis_transaksi = ? ");
                pakaiParamJenis = true;
                nilaiJenisParam = "Layanan";
            } else if (jenis.equalsIgnoreCase("Produk")) {
                sql.append(" AND jenis_transaksi IN ('Penjualan Produk', 'Pembelian Produk') ");
            } else {
                sql.append(" AND jenis_transaksi = ? ");
                pakaiParamJenis = true;
                nilaiJenisParam = jenis;
            }
        }
        
        boolean pakaiKeyword = (keyword != null && !keyword.trim().isEmpty());
        if (pakaiKeyword) {
            sql.append(" AND (kode_transaksi LIKE ? OR deskripsi LIKE ? OR pihak LIKE ?) ");
        }

        sql.append(" ORDER BY tanggal, jenis_transaksi, kode_transaksi ");

        List<Row> list = new ArrayList<>();

        try (Connection c = koneksi.getConnection();
             PreparedStatement ps = c.prepareStatement(sql.toString())) {

            int i = 1;
            ps.setDate(i++, mulai);
            ps.setDate(i++, sampai);
            ps.setDate(i++, mulai);
            ps.setDate(i++, sampai);
            ps.setDate(i++, mulai);
            ps.setDate(i++, sampai);

            if (pakaiParamJenis) {
                ps.setString(i++, nilaiJenisParam);
            }

            if (pakaiKeyword) {
                String k = "%" + keyword.trim() + "%";
                ps.setString(i++, k);
                ps.setString(i++, k);
                ps.setString(i++, k);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Row r = new Row();
                    r.tanggal = rs.getDate("tanggal");
                    r.jenis = rs.getString("jenis_transaksi");
                    r.kode = rs.getString("kode_transaksi");
                    r.deskripsi = rs.getString("deskripsi");
                    r.qty = rs.getInt("qty");
                    r.harga = rs.getBigDecimal("harga_satuan");
                    r.total = rs.getBigDecimal("total");
                    r.pihak = rs.getString("pihak");
                    r.metode = rs.getString("metode_pembayaran");
                    list.add(r);
                }
            }
        }

        return list;
    }
}