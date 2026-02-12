package com.okesalon.model;
import java.util.Date;

public class LogAktivitas {
    
    private String idDokumen;
    private Date tanggal;
    private String judulDokumen;
    private String kategoriDokumen;
    private String status;
    private String keterangan;
    
    public LogAktivitas() {}
    
    public LogAktivitas(String idDokumen, Date tanggal, String judulDokumen, 
                       String kategoriDokumen, String status, String keterangan) {
        this.idDokumen = idDokumen;
        this.tanggal = tanggal;
        this.judulDokumen = judulDokumen;
        this.kategoriDokumen = kategoriDokumen;
        this.status = status;
        this.keterangan = keterangan;
    }

    public String getIdDokumen() {
        return idDokumen;
    }

    public void setIdDokumen(String idDokumen) {
        this.idDokumen = idDokumen;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudulDokumen() {
        return judulDokumen;
    }

    public void setJudulDokumen(String judulDokumen) {
        this.judulDokumen = judulDokumen;
    }

    public String getKategoriDokumen() {
        return kategoriDokumen;
    }

    public void setKategoriDokumen(String kategoriDokumen) {
        this.kategoriDokumen = kategoriDokumen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}