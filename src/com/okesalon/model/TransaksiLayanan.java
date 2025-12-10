/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.model;
import java.util.Date;
/**
 *
 * @author T480
 */
public class TransaksiLayanan {
    private String kodeTransaksi;        // PRIMARY KEY (database: kode_transaksi)
    private String kodePelanggan;        // FK (database: kode_pelanggan)
    private String namaLengkap;          // Nama pelanggan (database: nama_lengkap)
    private String noTelepon;            // No telepon (database: no_telepon)
    private String kodeKaryawan;         // FK (database: kode_karyawan)
    private String namaKaryawan;         // Nama karyawan (database: nama_karyawan)
    private Date tanggalTransaksi;       // Tanggal transaksi (database: tanggal_transaksi)
    private String kodeLayanan;          // FK (database: kode_layanan)
    private String namaLayanan;          // Nama layanan (database: nama_layanan)
    private double hargaLayanan;         // Harga layanan (database: harga_layanan)
    private double subtotalLayanan;      // Subtotal (database: subtotal_layanan)
    private String diskon;               // Diskon (database: diskon)
    private double totalPembayaran;      // Total (database: total_pembayaran)
    private String metodePembayaran;     // Metode (database: metode_pembayaran)
    private String statusPembayaran;     // Status (database: status_pembayaran)
    private String catatanKhusus;        // Catatan (database: catatan_khusus)
    private Date createdAt;              // Created at (database: created_at)
    private Date updatedAt;              // Updated at (database: updated_at)
    
    // ==================== CONSTRUCTORS ====================
    
    public TransaksiLayanan() {
    }
    
    public TransaksiLayanan(String kodeTransaksi, String kodePelanggan, String namaLengkap,
                            String noTelepon, String kodeKaryawan, String namaKaryawan,
                            Date tanggalTransaksi, String kodeLayanan, String namaLayanan,
                            double hargaLayanan, double subtotalLayanan, String diskon,
                            double totalPembayaran, String metodePembayaran, 
                            String statusPembayaran) {
        this.kodeTransaksi = kodeTransaksi;
        this.kodePelanggan = kodePelanggan;
        this.namaLengkap = namaLengkap;
        this.noTelepon = noTelepon;
        this.kodeKaryawan = kodeKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.tanggalTransaksi = tanggalTransaksi;
        this.kodeLayanan = kodeLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaLayanan = hargaLayanan;
        this.subtotalLayanan = subtotalLayanan;
        this.diskon = diskon;
        this.totalPembayaran = totalPembayaran;
        this.metodePembayaran = metodePembayaran;
        this.statusPembayaran = statusPembayaran;
    }
    
    // ==================== GETTERS & SETTERS ====================
    
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }
    
    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }
    
    public String getKodePelanggan() {
        return kodePelanggan;
    }
    
    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }
    
    public String getNamaLengkap() {
        return namaLengkap;
    }
    
    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }
    
    public String getNoTelepon() {
        return noTelepon;
    }
    
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    
    public String getKodeKaryawan() {
        return kodeKaryawan;
    }
    
    public void setKodeKaryawan(String kodeKaryawan) {
        this.kodeKaryawan = kodeKaryawan;
    }
    
    public String getNamaKaryawan() {
        return namaKaryawan;
    }
    
    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }
    
    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }
    
    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
    
    public String getKodeLayanan() {
        return kodeLayanan;
    }
    
    public void setKodeLayanan(String kodeLayanan) {
        this.kodeLayanan = kodeLayanan;
    }
    
    public String getNamaLayanan() {
        return namaLayanan;
    }
    
    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }
    
    public double getHargaLayanan() {
        return hargaLayanan;
    }
    
    public void setHargaLayanan(double hargaLayanan) {
        this.hargaLayanan = hargaLayanan;
    }
    
    public double getSubtotalLayanan() {
        return subtotalLayanan;
    }
    
    public void setSubtotalLayanan(double subtotalLayanan) {
        this.subtotalLayanan = subtotalLayanan;
    }
    
    public String getDiskon() {
        return diskon;
    }
    
    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }
    
    public double getTotalPembayaran() {
        return totalPembayaran;
    }
    
    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }
    
    public String getMetodePembayaran() {
        return metodePembayaran;
    }
    
    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
    
    public String getStatusPembayaran() {
        return statusPembayaran;
    }
    
    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
    
    public String getCatatanKhusus() {
        return catatanKhusus;
    }
    
    public void setCatatanKhusus(String catatanKhusus) {
        this.catatanKhusus = catatanKhusus;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // ==================== TO STRING ====================
    
    @Override
    public String toString() {
        return "TransaksiLayanan{" +
                "kodeTransaksi='" + kodeTransaksi + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", namaKaryawan='" + namaKaryawan + '\'' +
                ", namaLayanan='" + namaLayanan + '\'' +
                ", totalPembayaran=" + totalPembayaran +
                ", statusPembayaran='" + statusPembayaran + '\'' +
                '}';
    }
}
