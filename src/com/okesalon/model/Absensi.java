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
public class Absensi {
    // Primary Key
    // Primary Key
    private int idAbsensi;
    private String kodeAbsensi;  // ⭐ TAMBAHAN: ABS-20251204-001
    
    // Foreign Key
    private String kodeKaryawan;
    
    // Data Karyawan
    private String namaKaryawan;
    
    // Waktu Absensi
    private Date tanggalAbsensi;
    private Date jamMasuk;
    private Date jamKeluar;
    private String totalJamKerja;
    
    // Status & Detail
    private String statusKehadiran;  // Hadir, Izin, Sakit, Alfa, Cuti
    private String lokasiCheckIn;
    private String fotoSelfie;
    private String keterangan;
    
    // Metadata
    private Date createdAt;
    private Date updatedAt;
    
    // ==================== CONSTRUCTORS ====================
    
    public Absensi() {
    }
    
    // ==================== GETTERS & SETTERS ====================
    
    public int getIdAbsensi() {
        return idAbsensi;
    }
    
    public void setIdAbsensi(int idAbsensi) {
        this.idAbsensi = idAbsensi;
    }
    
    // ⭐ GETTER & SETTER untuk kodeAbsensi
    public String getKodeAbsensi() {
        return kodeAbsensi;
    }
    
    public void setKodeAbsensi(String kodeAbsensi) {
        this.kodeAbsensi = kodeAbsensi;
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
    
    public Date getTanggalAbsensi() {
        return tanggalAbsensi;
    }
    
    public void setTanggalAbsensi(Date tanggalAbsensi) {
        this.tanggalAbsensi = tanggalAbsensi;
    }
    
    public Date getJamMasuk() {
        return jamMasuk;
    }
    
    public void setJamMasuk(Date jamMasuk) {
        this.jamMasuk = jamMasuk;
    }
    
    public Date getJamKeluar() {
        return jamKeluar;
    }
    
    public void setJamKeluar(Date jamKeluar) {
        this.jamKeluar = jamKeluar;
    }
    
    public String getTotalJamKerja() {
        return totalJamKerja;
    }
    
    public void setTotalJamKerja(String totalJamKerja) {
        this.totalJamKerja = totalJamKerja;
    }
    
    public String getStatusKehadiran() {
        return statusKehadiran;
    }
    
    public void setStatusKehadiran(String statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }
    
    public String getLokasiCheckIn() {
        return lokasiCheckIn;
    }
    
    public void setLokasiCheckIn(String lokasiCheckIn) {
        this.lokasiCheckIn = lokasiCheckIn;
    }
    
    public String getFotoSelfie() {
        return fotoSelfie;
    }
    
    public void setFotoSelfie(String fotoSelfie) {
        this.fotoSelfie = fotoSelfie;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
    
    @Override
    public String toString() {
        return "Absensi{" +
                "kodeAbsensi='" + kodeAbsensi + '\'' +
                ", namaKaryawan='" + namaKaryawan + '\'' +
                ", tanggalAbsensi=" + tanggalAbsensi +
                ", statusKehadiran='" + statusKehadiran + '\'' +
                '}';
    }
}
