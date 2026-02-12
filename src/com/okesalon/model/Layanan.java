package com.okesalon.model;

public class Layanan {
    private String kodeLayanan;
    private String namaLayanan;
    private String kategoriLayanan;
    private double hargaLayanan;
    private int durasiEstimasi;
    private String deskripsiLayanan;
    private String status;
    private String fotoLayanan;

    public Layanan() {}

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
