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
public class ArsipDokumen {
    private String idDokumen;           // Primary Key (auto-generate: DOC-001)
    private String kategoriDokumen;     // "Surat Izin Usaha", "Kontrak Karyawan", dll
    private String judulDokumen;
    private Date tanggalDokumen;
    private Date tanggalExpired;
    private String status;              // "Aktif", "Non-Aktif", "Expired"
    private String deskripsi;
    private String filePath;            // Path file dokumen (PDF, Word, dll)
    
    // Constructor kosong
    public ArsipDokumen() {}
    
    // Constructor lengkap
    public ArsipDokumen(String idDokumen, String kategoriDokumen, String judulDokumen,
                        Date tanggalDokumen, Date tanggalExpired, String status,
                        String deskripsi, String filePath) {
        this.idDokumen = idDokumen;
        this.kategoriDokumen = kategoriDokumen;
        this.judulDokumen = judulDokumen;
        this.tanggalDokumen = tanggalDokumen;
        this.tanggalExpired = tanggalExpired;
        this.status = status;
        this.deskripsi = deskripsi;
        this.filePath = filePath;
    }
    
    // Getter & Setter
    public String getIdDokumen() { return idDokumen; }
    public void setIdDokumen(String idDokumen) { this.idDokumen = idDokumen; }
    
    public String getKategoriDokumen() { return kategoriDokumen; }
    public void setKategoriDokumen(String kategoriDokumen) { this.kategoriDokumen = kategoriDokumen; }
    
    public String getJudulDokumen() { return judulDokumen; }
    public void setJudulDokumen(String judulDokumen) { this.judulDokumen = judulDokumen; }
    
    public Date getTanggalDokumen() { return tanggalDokumen; }
    public void setTanggalDokumen(Date tanggalDokumen) { this.tanggalDokumen = tanggalDokumen; }
    
    public Date getTanggalExpired() { return tanggalExpired; }
    public void setTanggalExpired(Date tanggalExpired) { this.tanggalExpired = tanggalExpired; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    
    // Helper method: Cek apakah dokumen sudah expired
    public boolean isExpired() {
        if (tanggalExpired == null) return false;
        return tanggalExpired.before(new Date());
    }
    
    // Helper method: Hitung hari tersisa sebelum expired
    public long getHariTersisa() {
        if (tanggalExpired == null) return -1;
        long diff = tanggalExpired.getTime() - new Date().getTime();
        return diff / (1000 * 60 * 60 * 24);
    }
    
    @Override
    public String toString() {
        return "ArsipDokumen{" +
                "idDokumen='" + idDokumen + '\'' +
                ", judulDokumen='" + judulDokumen + '\'' +
                ", kategori='" + kategoriDokumen + '\'' +
                '}';
    }
}
