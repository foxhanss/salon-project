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
public class Produk {
    private String kodeProduk;          // Primary Key (auto-generate: PRD-001)
    private String namaProduk;
    private String kategoriProduk;      // "Hair Care", "Hair Coloring", "Nail Care", "Skin Care"
    private String jenis;               // "Dijual", "Layanan", "Dijual & Layanan"
    private String namaSupplier;
    private String teleponSupplier;
    private double hargaBeli;
    private double hargaJual;
    private int stokSaatIni;
    private int stokMinimum;
    private String satuan;              // "Botol", "Tube", "Sachet", "Box"
    private Date tanggalExpired;
    private String status;              // "Aktif", "Non-Aktif"
    private String deskripsi;
    private String fotoProduk;          // Path file foto
    
    // Constructor kosong
    public Produk() {}
    
    // Constructor lengkap
    public Produk(String kodeProduk, String namaProduk, String kategoriProduk, 
                  String jenis, String namaSupplier, String teleponSupplier, 
                  double hargaBeli, double hargaJual, int stokSaatIni, 
                  int stokMinimum, String satuan, Date tanggalExpired, 
                  String status, String deskripsi, String fotoProduk) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.jenis = jenis;
        this.namaSupplier = namaSupplier;
        this.teleponSupplier = teleponSupplier;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stokSaatIni = stokSaatIni;
        this.stokMinimum = stokMinimum;
        this.satuan = satuan;
        this.tanggalExpired = tanggalExpired;
        this.status = status;
        this.deskripsi = deskripsi;
        this.fotoProduk = fotoProduk;
    }
    
    // Getter & Setter
    public String getKodeProduk() { return kodeProduk; }
    public void setKodeProduk(String kodeProduk) { this.kodeProduk = kodeProduk; }
    
    public String getNamaProduk() { return namaProduk; }
    public void setNamaProduk(String namaProduk) { this.namaProduk = namaProduk; }
    
    public String getKategoriProduk() { return kategoriProduk; }
    public void setKategoriProduk(String kategoriProduk) { this.kategoriProduk = kategoriProduk; }
    
    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
    
    public String getNamaSupplier() { return namaSupplier; }
    public void setNamaSupplier(String namaSupplier) { this.namaSupplier = namaSupplier; }
    
    public String getTeleponSupplier() { return teleponSupplier; }
    public void setTeleponSupplier(String teleponSupplier) { this.teleponSupplier = teleponSupplier; }
    
    public double getHargaBeli() { return hargaBeli; }
    public void setHargaBeli(double hargaBeli) { this.hargaBeli = hargaBeli; }
    
    public double getHargaJual() { return hargaJual; }
    public void setHargaJual(double hargaJual) { this.hargaJual = hargaJual; }
    
    public int getStokSaatIni() { return stokSaatIni; }
    public void setStokSaatIni(int stokSaatIni) { this.stokSaatIni = stokSaatIni; }
    
    public int getStokMinimum() { return stokMinimum; }
    public void setStokMinimum(int stokMinimum) { this.stokMinimum = stokMinimum; }
    
    public String getSatuan() { return satuan; }
    public void setSatuan(String satuan) { this.satuan = satuan; }
    
    public Date getTanggalExpired() { return tanggalExpired; }
    public void setTanggalExpired(Date tanggalExpired) { this.tanggalExpired = tanggalExpired; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    
    public String getFotoProduk() { return fotoProduk; }
    public void setFotoProduk(String fotoProduk) { this.fotoProduk = fotoProduk; }
    
    // Helper method: Cek apakah stok hampir habis
    public boolean isStokMenipis() {
        return stokSaatIni <= stokMinimum;
    }
    
    // Helper method: Hitung margin keuntungan
    public double getMargin() {
        return hargaJual - hargaBeli;
    }
    
    // Helper method: Hitung persentase margin
    public double getPersentaseMargin() {
        if (hargaBeli == 0) return 0;
        return ((hargaJual - hargaBeli) / hargaBeli) * 100;
    }
    
    @Override
    public String toString() {
        return "Produk{" +
                "kodeProduk='" + kodeProduk + '\'' +
                ", namaProduk='" + namaProduk + '\'' +
                ", kategori='" + kategoriProduk + '\'' +
                ", jenis='" + jenis + '\'' +
                ", stok=" + stokSaatIni +
                '}';
    }
}
