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
public class TransaksiPembelianProduk {
    // Primary Fields
    private String kodeTransaksi;
    private Date tanggalTransaksi;
    
    // Produk Fields
    private String kodeProduk;
    private String namaProduk;
    private int jumlahBeli;
    private double hargaSatuan;
    
    // Supplier Fields
    private String namaSupplier;
    private String teleponSupplier;
    private String metodePembayaran;
    
    // Additional Fields
    private String keterangan;
    private int stokSebelum;
    private int jumlahBeliCopy;
    private int stokSesudah;
    private double totalHarga;
    
    // Audit Fields
    private Date createdAt;
    private Date updatedAt;
    
    // ==================== CONSTRUCTORS ====================
    
    public TransaksiPembelianProduk() {
    }
    
    public TransaksiPembelianProduk(String kodeTransaksi, Date tanggalTransaksi, 
                                     String kodeProduk, String namaProduk,
                                     int jumlahBeli, double hargaSatuan,
                                     String namaSupplier, String teleponSupplier,
                                     String metodePembayaran, String keterangan,
                                     int stokSebelum, int stokSesudah, double totalHarga) {
        this.kodeTransaksi = kodeTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.jumlahBeli = jumlahBeli;
        this.hargaSatuan = hargaSatuan;
        this.namaSupplier = namaSupplier;
        this.teleponSupplier = teleponSupplier;
        this.metodePembayaran = metodePembayaran;
        this.keterangan = keterangan;
        this.stokSebelum = stokSebelum;
        this.jumlahBeliCopy = jumlahBeli;
        this.stokSesudah = stokSesudah;
        this.totalHarga = totalHarga;
    }
    
    // ==================== GETTERS & SETTERS ====================
    
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
    
    public int getJumlahBeli() {
        return jumlahBeli;
    }
    
    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
        this.jumlahBeliCopy = jumlahBeli;
    }
    
    public double getHargaSatuan() {
        return hargaSatuan;
    }
    
    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    
    public String getNamaSupplier() {
        return namaSupplier;
    }
    
    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }
    
    public String getTeleponSupplier() {
        return teleponSupplier;
    }
    
    public void setTeleponSupplier(String teleponSupplier) {
        this.teleponSupplier = teleponSupplier;
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
    
    public int getStokSebelum() {
        return stokSebelum;
    }
    
    public void setStokSebelum(int stokSebelum) {
        this.stokSebelum = stokSebelum;
    }
    
    public int getJumlahBeliCopy() {
        return jumlahBeliCopy;
    }
    
    public void setJumlahBeliCopy(int jumlahBeliCopy) {
        this.jumlahBeliCopy = jumlahBeliCopy;
    }
    
    public int getStokSesudah() {
        return stokSesudah;
    }
    
    public void setStokSesudah(int stokSesudah) {
        this.stokSesudah = stokSesudah;
    }
    
    public double getTotalHarga() {
        return totalHarga;
    }
    
    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
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
        return "TransaksiPembelianProduk{" +
                "kodeTransaksi='" + kodeTransaksi + '\'' +
                ", namaProduk='" + namaProduk + '\'' +
                ", jumlahBeli=" + jumlahBeli +
                ", namaSupplier='" + namaSupplier + '\'' +
                ", totalHarga=" + totalHarga +
                '}';
    }
}
