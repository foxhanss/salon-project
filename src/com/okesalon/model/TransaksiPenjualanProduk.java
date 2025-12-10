package com.okesalon.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Model untuk Transaksi Penjualan Produk
 * @author T480
 */
public class TransaksiPenjualanProduk {
    
    // ==================== FIELDS ====================
    private String kodeTransaksi;
    private Date tanggalTransaksi;
    private String kodeProduk;
    private String namaProduk;
    private int jumlahJual;
    private BigDecimal hargaSatuan;
    private String namaPelanggan;
    private String teleponPelanggan;
    private String metodePembayaran;
    private String keterangan;
    private Integer stokSebelum;
    private Integer jumlahJualCopy;
    private Integer stokSesudah;
    private BigDecimal totalHarga;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // ==================== CONSTRUCTORS ====================
    
    /**
     * Constructor kosong
     */
    public TransaksiPenjualanProduk() {
    }

    /**
     * Constructor lengkap
     */
    public TransaksiPenjualanProduk(String kodeTransaksi, Date tanggalTransaksi, 
                                    String kodeProduk, String namaProduk, 
                                    int jumlahJual, BigDecimal hargaSatuan, 
                                    String namaPelanggan, String teleponPelanggan,
                                    String metodePembayaran, String keterangan,
                                    Integer stokSebelum, Integer jumlahJualCopy,
                                    Integer stokSesudah, BigDecimal totalHarga) {
        this.kodeTransaksi = kodeTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.jumlahJual = jumlahJual;
        this.hargaSatuan = hargaSatuan;
        this.namaPelanggan = namaPelanggan;
        this.teleponPelanggan = teleponPelanggan;
        this.metodePembayaran = metodePembayaran;
        this.keterangan = keterangan;
        this.stokSebelum = stokSebelum;
        this.jumlahJualCopy = jumlahJualCopy;
        this.stokSesudah = stokSesudah;
        this.totalHarga = totalHarga;
    }

    // ==================== GETTERS AND SETTERS ====================
    
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
    
    // ✅ OVERLOAD: Accept java.util.Date (dari JDateChooser)
    public void setTanggalTransaksi(java.util.Date tanggalTransaksi) {
        if (tanggalTransaksi != null) {
            this.tanggalTransaksi = new Date(tanggalTransaksi.getTime());
        }
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getJumlahJual() {
        return jumlahJual;
    }

    public void setJumlahJual(int jumlahJual) {
        this.jumlahJual = jumlahJual;
    }

    public BigDecimal getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(BigDecimal hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    
    // ✅ OVERLOAD: Accept double (lebih mudah untuk calculation)
    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = BigDecimal.valueOf(hargaSatuan);
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getTeleponPelanggan() {
        return teleponPelanggan;
    }

    public void setTeleponPelanggan(String teleponPelanggan) {
        this.teleponPelanggan = teleponPelanggan;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getStokSebelum() {
        return stokSebelum;
    }

    public void setStokSebelum(Integer stokSebelum) {
        this.stokSebelum = stokSebelum;
    }

    public Integer getJumlahJualCopy() {
        return jumlahJualCopy;
    }

    public void setJumlahJualCopy(Integer jumlahJualCopy) {
        this.jumlahJualCopy = jumlahJualCopy;
    }

    public Integer getStokSesudah() {
        return stokSesudah;
    }

    public void setStokSesudah(Integer stokSesudah) {
        this.stokSesudah = stokSesudah;
    }

    public BigDecimal getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigDecimal totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    // ✅ OVERLOAD: Accept double (untuk kompatibilitas dengan calculation)
    public void setTotalHarga(double totalHarga) {
        this.totalHarga = BigDecimal.valueOf(totalHarga);
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Get total harga as double (untuk display & calculation)
     */
    public double getTotalHargaAsDouble() {
        return totalHarga != null ? totalHarga.doubleValue() : 0.0;
    }
    
    /**
     * Get harga satuan as double (untuk calculation)
     */
    public double getHargaSatuanAsDouble() {
        return hargaSatuan != null ? hargaSatuan.doubleValue() : 0.0;
    }
    
    /**
     * Calculate total harga otomatis
     */
    public void calculateTotalHarga() {
        if (hargaSatuan != null && jumlahJual > 0) {
            this.totalHarga = hargaSatuan.multiply(BigDecimal.valueOf(jumlahJual));
        }
    }
    
    /**
     * Validate transaksi (untuk cek sebelum save)
     */
    public boolean isValid() {
        return kodeTransaksi != null && !kodeTransaksi.isEmpty()
            && tanggalTransaksi != null
            && kodeProduk != null && !kodeProduk.isEmpty()
            && namaProduk != null && !namaProduk.isEmpty()
            && jumlahJual > 0
            && hargaSatuan != null && hargaSatuan.compareTo(BigDecimal.ZERO) > 0
            && namaPelanggan != null && !namaPelanggan.isEmpty()
            && teleponPelanggan != null && !teleponPelanggan.isEmpty()
            && metodePembayaran != null && !metodePembayaran.isEmpty()
            && totalHarga != null && totalHarga.compareTo(BigDecimal.ZERO) > 0;
    }
    
    /**
     * Get formatted display (untuk debugging)
     */
    @Override
    public String toString() {
        return "TransaksiPenjualanProduk{" +
                "kodeTransaksi='" + kodeTransaksi + '\'' +
                ", tanggalTransaksi=" + tanggalTransaksi +
                ", namaProduk='" + namaProduk + '\'' +
                ", namaPelanggan='" + namaPelanggan + '\'' +
                ", jumlahJual=" + jumlahJual +
                ", totalHarga=" + totalHarga +
                ", metodePembayaran='" + metodePembayaran + '\'' +
                '}';
    }
}
