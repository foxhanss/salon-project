/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okesalon.model;

/**
 *
 * @author T480
 */
public class Layanan {
    private String kodeLayanan;  // primary key, auto-generate
    private String namaLayanan;
    private String kategoriLayanan;
    private double hargaLayanan;
    private int durasiEstimasi;  // menit
    private String deskripsiLayanan;
    private String status;       // "Aktif" atau "Non-Aktif"
    private String fotoLayanan;  // path file, boleh null

    // Constructor kosong
    public Layanan() {}

    // Constructor lengkap
    public Layanan(String kodeLayanan, String namaLayanan, String kategoriLayanan, 
                   double hargaLayanan, int durasiEstimasi, String deskripsiLayanan, 
                   String status, String fotoLayanan) {
        this.kodeLayanan = kodeLayanan;
        this.namaLayanan = namaLayanan;
        this.kategoriLayanan = kategoriLayanan;
        this.hargaLayanan = hargaLayanan;
        this.durasiEstimasi = durasiEstimasi;
        this.deskripsiLayanan = deskripsiLayanan;
        this.status = status;
        this.fotoLayanan = fotoLayanan;
    }

    // Getter & Setter
    public String getKodeLayanan() { return kodeLayanan; }
    public void setKodeLayanan(String kodeLayanan) { this.kodeLayanan = kodeLayanan; }

    public String getNamaLayanan() { return namaLayanan; }
    public void setNamaLayanan(String namaLayanan) { this.namaLayanan = namaLayanan; }

    public String getKategoriLayanan() { return kategoriLayanan; }
    public void setKategoriLayanan(String kategoriLayanan) { this.kategoriLayanan = kategoriLayanan; }

    public double getHargaLayanan() { return hargaLayanan; }
    public void setHargaLayanan(double hargaLayanan) { this.hargaLayanan = hargaLayanan; }

    public int getDurasiEstimasi() { return durasiEstimasi; }
    public void setDurasiEstimasi(int durasiEstimasi) { this.durasiEstimasi = durasiEstimasi; }

    public String getDeskripsiLayanan() { return deskripsiLayanan; }
    public void setDeskripsiLayanan(String deskripsiLayanan) { this.deskripsiLayanan = deskripsiLayanan; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFotoLayanan() { return fotoLayanan; }
    public void setFotoLayanan(String fotoLayanan) { this.fotoLayanan = fotoLayanan; }
}
