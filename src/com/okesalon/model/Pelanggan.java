package com.okesalon.model;
import java.util.Date;

public class Pelanggan {
    private String kodePelanggan;
    private String namaLengkap;
    private String noTelepon;
    private String email;
    private Date tanggalLahir;
    private String jenisKelamin;
    private String alamat;
    private Date tanggalRegistrasi;
    private String membershipType;
    private String discountMember;
    private String status;
    private double totalSpending;
    private String catatanKhusus;
    private Date deletedAt;
    private String deletedBy;
    
    public Pelanggan() {}
    
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
        this.status = "Aktif";
    }
    
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

    public boolean isDeleted() {
        return "Deleted".equals(this.status);
    }

    public boolean isActive() {
        return "Aktif".equals(this.status);
    }

    public boolean isNonActive() {
        return "Non-Aktif".equals(this.status);
    }

    public int getDiscountValue() {
        if (discountMember == null || discountMember.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(discountMember.replace("%", ""));
    }

    public String getFormattedTotalSpending() {
        return String.format("Rp %,.0f", totalSpending);
    }

    public int getAge() {
        if (tanggalLahir == null) {
            return -1;
        }
        
        java.util.Calendar birthCalendar = java.util.Calendar.getInstance();
        birthCalendar.setTime(tanggalLahir);
        
        java.util.Calendar today = java.util.Calendar.getInstance();
        
        int age = today.get(java.util.Calendar.YEAR) - birthCalendar.get(java.util.Calendar.YEAR);
        
        if (today.get(java.util.Calendar.DAY_OF_YEAR) < birthCalendar.get(java.util.Calendar.DAY_OF_YEAR)) {
            age--;
        }
        
        return age;
    }

    public boolean hasValidEmail() {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public boolean hasValidPhoneNumber() {
        if (noTelepon == null || noTelepon.isEmpty()) {
            return false;
        }
        return noTelepon.matches("^(\\+62|62|0)[0-9]{9,12}$");
    }

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