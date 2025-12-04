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
    private String namaLengkap;             // Nama lengkap pelanggan
    private String noTelepon;               // No telepon (unique)
    private String email;                   // Email (unique, nullable)
    private Date tanggalLahir;              // Tanggal lahir (nullable)
    private String jenisKelamin;            // "Laki-Laki" atau "Perempuan"
    private String alamat;                  // Alamat lengkap (nullable)
    private Date tanggalRegistrasi;         // Auto-fill saat insert
    private String membershipType;          // "Regular", "Silver", "Gold", "Platinum"
    private String discountMember;          // "0%", "5%", "10%", "15%"
    private String status;                  // "Aktif", "Non-Aktif", "Deleted"
    private double totalSpending;           // Lifetime value (total belanja)
    private String catatanKhusus;           // Alergi, preferensi, dll (nullable)
    
    // ⭐ Field untuk soft delete tracking
    private Date deletedAt;                 // Waktu dihapus
    private String deletedBy;               // User yang menghapus
    
    // ==================== CONSTRUCTORS ====================
    
    /**
     * Constructor kosong (default)
     */
    public Pelanggan() {}
    
    /**
     * Constructor lengkap (TANPA status, deletedAt, deletedBy - untuk insert baru)
     */
    public Pelanggan(String kodePelanggan, String namaLengkap, String noTelepon, 
                     String email, Date tanggalLahir, String jenisKelamin, 
                     String alamat, Date tanggalRegistrasi, String membershipType, 
                     String discountMember, double totalSpending, String catatanKhusus) {
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
        this.status = "Aktif";  // ⭐ Default status
    }
    
    /**
     * Constructor super lengkap (termasuk status dan soft delete fields)
     */
    public Pelanggan(String kodePelanggan, String namaLengkap, String noTelepon, 
                     String email, Date tanggalLahir, String jenisKelamin, 
                     String alamat, Date tanggalRegistrasi, String membershipType, 
                     String discountMember, String status, double totalSpending, 
                     String catatanKhusus, Date deletedAt, String deletedBy) {
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
        this.status = status;
        this.totalSpending = totalSpending;
        this.catatanKhusus = catatanKhusus;
        this.deletedAt = deletedAt;
        this.deletedBy = deletedBy;
    }
    
    // ==================== GETTER & SETTER ====================
    
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
    
    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public Date getTanggalLahir() { 
        return tanggalLahir; 
    }
    
    public void setTanggalLahir(Date tanggalLahir) { 
        this.tanggalLahir = tanggalLahir; 
    }
    
    public String getJenisKelamin() { 
        return jenisKelamin; 
    }
    
    public void setJenisKelamin(String jenisKelamin) { 
        this.jenisKelamin = jenisKelamin; 
    }
    
    public String getAlamat() { 
        return alamat; 
    }
    
    public void setAlamat(String alamat) { 
        this.alamat = alamat; 
    }
    
    public Date getTanggalRegistrasi() { 
        return tanggalRegistrasi; 
    }
    
    public void setTanggalRegistrasi(Date tanggalRegistrasi) { 
        this.tanggalRegistrasi = tanggalRegistrasi; 
    }
    
    public String getMembershipType() { 
        return membershipType; 
    }
    
    public void setMembershipType(String membershipType) { 
        this.membershipType = membershipType; 
    }
    
    public String getDiscountMember() { 
        return discountMember; 
    }
    
    public void setDiscountMember(String discountMember) { 
        this.discountMember = discountMember; 
    }
    
    public String getStatus() { 
        return status; 
    }
    
    public void setStatus(String status) { 
        this.status = status; 
    }
    
    public double getTotalSpending() { 
        return totalSpending; 
    }
    
    public void setTotalSpending(double totalSpending) { 
        this.totalSpending = totalSpending; 
    }
    
    public String getCatatanKhusus() { 
        return catatanKhusus; 
    }
    
    public void setCatatanKhusus(String catatanKhusus) { 
        this.catatanKhusus = catatanKhusus; 
    }
    
    // ⭐ Getter & Setter untuk soft delete
    public Date getDeletedAt() { 
        return deletedAt; 
    }
    
    public void setDeletedAt(Date deletedAt) { 
        this.deletedAt = deletedAt; 
    }
    
    public String getDeletedBy() { 
        return deletedBy; 
    }
    
    public void setDeletedBy(String deletedBy) { 
        this.deletedBy = deletedBy; 
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Cek apakah pelanggan sudah dihapus (soft delete)
     * @return true jika status = "Deleted"
     */
    public boolean isDeleted() {
        return "Deleted".equals(this.status);
    }
    
    /**
     * Cek apakah pelanggan masih aktif
     * @return true jika status = "Aktif"
     */
    public boolean isActive() {
        return "Aktif".equals(this.status);
    }
    
    /**
     * Cek apakah pelanggan non-aktif
     * @return true jika status = "Non-Aktif"
     */
    public boolean isNonActive() {
        return "Non-Aktif".equals(this.status);
    }
    
    /**
     * Get discount value as integer (untuk perhitungan)
     * Contoh: "15%" → 15
     * @return discount value
     */
    public int getDiscountValue() {
        if (discountMember == null || discountMember.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(discountMember.replace("%", ""));
    }
    
    /**
     * Format total spending as currency
     * @return formatted string (Rp xxx.xxx)
     */
    public String getFormattedTotalSpending() {
        return String.format("Rp %,.0f", totalSpending);
    }
    
    /**
     * Get age from tanggalLahir
     * @return age in years, or -1 if tanggalLahir is null
     */
    public int getAge() {
        if (tanggalLahir == null) {
            return -1;
        }
        
        java.util.Calendar birthCalendar = java.util.Calendar.getInstance();
        birthCalendar.setTime(tanggalLahir);
        
        java.util.Calendar today = java.util.Calendar.getInstance();
        
        int age = today.get(java.util.Calendar.YEAR) - birthCalendar.get(java.util.Calendar.YEAR);
        
        // Adjust if birthday hasn't occurred this year
        if (today.get(java.util.Calendar.DAY_OF_YEAR) < birthCalendar.get(java.util.Calendar.DAY_OF_YEAR)) {
            age--;
        }
        
        return age;
    }
    
    /**
     * Validate email format
     * @return true if email is valid
     */
    public boolean hasValidEmail() {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    /**
     * Validate phone number (Indonesian format)
     * @return true if phone number is valid
     */
    public boolean hasValidPhoneNumber() {
        if (noTelepon == null || noTelepon.isEmpty()) {
            return false;
        }
        // Indonesian phone: 08xxx or +628xxx, 10-13 digits
        return noTelepon.matches("^(\\+62|62|0)[0-9]{9,12}$");
    }
    
    // ==================== OVERRIDE METHODS ====================
    
    @Override
    public String toString() {
        return "Pelanggan{" +
                "kodePelanggan='" + kodePelanggan + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", discountMember='" + discountMember + '\'' +
                ", status='" + status + '\'' +
                ", totalSpending=" + totalSpending +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Pelanggan pelanggan = (Pelanggan) obj;
        return kodePelanggan != null ? kodePelanggan.equals(pelanggan.kodePelanggan) : pelanggan.kodePelanggan == null;
    }
    
    @Override
    public int hashCode() {
        return kodePelanggan != null ? kodePelanggan.hashCode() : 0;
    }
}
