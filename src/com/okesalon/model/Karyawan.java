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
public class Karyawan {
   private String kodeKaryawan;          // Primary key (auto-generate: KRY-001)
    private String nik;                   // Field biasa, input manual
    private String namaLengkap;
    private String jabatan;
    private String spesialisasi;
    private String noTelpon;
    private String email;
    private String alamatLengkap;
    private Date tanggalBergabung;
    private String statusKepegawaian;     // "Aktif" atau "Resign"
    private double gajiPokok;
    private double komisi;
    private String fotoKaryawan;          // Path file foto (nullable)
    
    // Constructor kosong
    public Karyawan() {}
    
    // Constructor lengkap
    public Karyawan(String kodeKaryawan, String nik, String namaLengkap, 
                    String jabatan, String spesialisasi, String noTelpon, 
                    String email, String alamatLengkap, Date tanggalBergabung, 
                    String statusKepegawaian, double gajiPokok, double komisi, 
                    String fotoKaryawan) {
        this.kodeKaryawan = kodeKaryawan;
        this.nik = nik;
        this.namaLengkap = namaLengkap;
        this.jabatan = jabatan;
        this.spesialisasi = spesialisasi;
        this.noTelpon = noTelpon;
        this.email = email;
        this.alamatLengkap = alamatLengkap;
        this.tanggalBergabung = tanggalBergabung;
        this.statusKepegawaian = statusKepegawaian;
        this.gajiPokok = gajiPokok;
        this.komisi = komisi;
        this.fotoKaryawan = fotoKaryawan;
    }
    
    // Getter & Setter
    public String getKodeKaryawan() { return kodeKaryawan; }
    public void setKodeKaryawan(String kodeKaryawan) { this.kodeKaryawan = kodeKaryawan; }
    
    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    
    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }
    
    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
    
    public String getSpesialisasi() { return spesialisasi; }
    public void setSpesialisasi(String spesialisasi) { this.spesialisasi = spesialisasi; }
    
    public String getNoTelpon() { return noTelpon; }
    public void setNoTelpon(String noTelpon) { this.noTelpon = noTelpon; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAlamatLengkap() { return alamatLengkap; }
    public void setAlamatLengkap(String alamatLengkap) { this.alamatLengkap = alamatLengkap; }
    
    public Date getTanggalBergabung() { return tanggalBergabung; }
    public void setTanggalBergabung(Date tanggalBergabung) { this.tanggalBergabung = tanggalBergabung; }
    
    public String getStatusKepegawaian() { return statusKepegawaian; }
    public void setStatusKepegawaian(String statusKepegawaian) { this.statusKepegawaian = statusKepegawaian; }
    
    public double getGajiPokok() { return gajiPokok; }
    public void setGajiPokok(double gajiPokok) { this.gajiPokok = gajiPokok; }
    
    public double getKomisi() { return komisi; }
    public void setKomisi(double komisi) { this.komisi = komisi; }
    
    public String getFotoKaryawan() { return fotoKaryawan; }
    public void setFotoKaryawan(String fotoKaryawan) { this.fotoKaryawan = fotoKaryawan; }
    
    @Override
    public String toString() {
        return "Karyawan{" +
                "kodeKaryawan='" + kodeKaryawan + '\'' +
                ", nik='" + nik + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", statusKepegawaian='" + statusKepegawaian + '\'' +
                '}';
    }
}
