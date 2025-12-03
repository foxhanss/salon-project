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
public class Pelanggan {
    private String kodePelanggan;           // Primary Key (auto-generate: PLG-001)
    private String namaLengkap;
    private String noTelepon;
    private String email;
    private Date tanggalLahir;
    private String jenisKelamin;            // "Laki-Laki" atau "Perempuan"
    private String alamat;
    private Date tanggalRegistrasi;         // Auto-fill saat insert
    private String membershipType;          // "Regular", "Silver", "Gold", "Platinum"
    private String discountMember;          // "0%", "5%", "10%", "15%"
    private double totalSpending;           // Lifetime value
    private String catatanKhusus;           // Alergi, preferensi, dll
    
    // Constructor kosong
    public Pelanggan() {}
    
    // Constructor lengkap
    public Pelanggan(String kodePelanggan, String namaLengkap, String noTelepon, 
                     String email, Date tanggalLahir, String jenisKelamin, 
                     String alamat, Date tanggalRegistrasi, String membershipType, 
                     String discountMember, int poinLoyalitas, double totalSpending, 
                     String catatanKhusus) {
        this.kodePelanggan = kodePelanggan;
        this.namaLengkap = namaLengkap;
        this.noTelepon = noTelepon;
        this.email = email;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.tanggalRegistrasi = tanggalRegistrasi;
        this.membershipType = membershipType;
        this.discountMember = discountMember;
        this.totalSpending = totalSpending;
        this.catatanKhusus = catatanKhusus;
    }
    
    // Getter & Setter
    public String getKodePelanggan() { return kodePelanggan; }
    public void setKodePelanggan(String kodePelanggan) { this.kodePelanggan = kodePelanggan; }
    
    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
    
    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Date getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(Date tanggalLahir) { this.tanggalLahir = tanggalLahir; }
    
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    
    public Date getTanggalRegistrasi() { return tanggalRegistrasi; }
    public void setTanggalRegistrasi(Date tanggalRegistrasi) { this.tanggalRegistrasi = tanggalRegistrasi; }
    
    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }
    
    public String getDiscountMember() { return discountMember; }
    public void setDiscountMember(String discountMember) { this.discountMember = discountMember; }
    
    public double getTotalSpending() { return totalSpending; }
    public void setTotalSpending(double totalSpending) { this.totalSpending = totalSpending; }
    
    public String getCatatanKhusus() { return catatanKhusus; }
    public void setCatatanKhusus(String catatanKhusus) { this.catatanKhusus = catatanKhusus; }
    
    @Override
    public String toString() {
        return "Pelanggan{" +
                "kodePelanggan='" + kodePelanggan + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", totalSpending=" + totalSpending +
                '}';
    }
}
