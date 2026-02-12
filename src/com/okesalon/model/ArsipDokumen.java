package com.okesalon.model;
import java.util.Date;

public class ArsipDokumen {
    private String idDokumen;
    private String kategoriDokumen;
    private String judulDokumen;
    private Date tanggalDokumen;
    private Date tanggalExpired;
    private String status;
    private String deskripsi;
    private String filePath;
    private String logAktivitas;
    private String logUser;
    private Date logTimestamp;

    public ArsipDokumen() {}

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
    
    public ArsipDokumen(String idDokumen, String kategoriDokumen, String judulDokumen,
                        Date tanggalDokumen, Date tanggalExpired, String status,
                        String deskripsi, String filePath,
                        String logAktivitas, String logUser, Date logTimestamp) {
        this.idDokumen = idDokumen;
        this.kategoriDokumen = kategoriDokumen;
        this.judulDokumen = judulDokumen;
        this.tanggalDokumen = tanggalDokumen;
        this.tanggalExpired = tanggalExpired;
        this.status = status;
        this.deskripsi = deskripsi;
        this.filePath = filePath;
        this.logAktivitas = logAktivitas;
        this.logUser = logUser;
        this.logTimestamp = logTimestamp;
    }
    
    public String getIdDokumen() { 
        return idDokumen; 
    }
    
    public void setIdDokumen(String idDokumen) { 
        this.idDokumen = idDokumen; 
    }
    
    public String getKategoriDokumen() { 
        return kategoriDokumen; 
    }
    
    public void setKategoriDokumen(String kategoriDokumen) { 
        this.kategoriDokumen = kategoriDokumen; 
    }
    
    public String getJudulDokumen() { 
        return judulDokumen; 
    }
    
    public void setJudulDokumen(String judulDokumen) { 
        this.judulDokumen = judulDokumen; 
    }
    
    public Date getTanggalDokumen() { 
        return tanggalDokumen; 
    }
    
    public void setTanggalDokumen(Date tanggalDokumen) { 
        this.tanggalDokumen = tanggalDokumen; 
    }
    
    public Date getTanggalExpired() { 
        return tanggalExpired; 
    }
    
    public void setTanggalExpired(Date tanggalExpired) { 
        this.tanggalExpired = tanggalExpired; 
    }
    
    public String getStatus() { 
        return status; 
    }
    
    public void setStatus(String status) { 
        this.status = status; 
    }
    
    public String getDeskripsi() { 
        return deskripsi; 
    }
    
    public void setDeskripsi(String deskripsi) { 
        this.deskripsi = deskripsi; 
    }
    
    public String getFilePath() { 
        return filePath; 
    }
    
    public void setFilePath(String filePath) { 
        this.filePath = filePath; 
    }
    
    public String getLogAktivitas() { 
        return logAktivitas; 
    }
    
    public void setLogAktivitas(String logAktivitas) { 
        this.logAktivitas = logAktivitas; 
    }
    
    public String getLogUser() { 
        return logUser; 
    }
    
    public void setLogUser(String logUser) { 
        this.logUser = logUser; 
    }
    
    public Date getLogTimestamp() { 
        return logTimestamp; 
    }
    
    public void setLogTimestamp(Date logTimestamp) { 
        this.logTimestamp = logTimestamp; 
    }

    public boolean isExpired() {
        if (tanggalExpired == null) return false;
        return tanggalExpired.before(new Date());
    }

    public long getHariTersisa() {
        if (tanggalExpired == null) return -1;
        long diff = tanggalExpired.getTime() - new Date().getTime();
        return diff / (1000 * 60 * 60 * 24);
    }

    public String getStatusBadge() {
        if (isExpired()) {
            return "EXPIRED";
        }
        
        long hari = getHariTersisa();
        if (hari <= 7 && hari >= 0) {
            return "⚠️ SEGERA EXPIRED (" + hari + " hari)";
        } else if (hari <= 30 && hari > 7) {
            return "AKAN EXPIRED (" + hari + " hari)";
        } else if ("Aktif".equals(status)) {
            return "AKTIF";
        } else if ("Non-Aktif".equals(status)) {
            return "NON-AKTIF";
        } else {
            return "" + status;
        }
    }
    
    @Override
    public String toString() {
        return "ArsipDokumen{" +
                "idDokumen='" + idDokumen + '\'' +
                ", judulDokumen='" + judulDokumen + '\'' +
                ", kategori='" + kategoriDokumen + '\'' +
                ", logAktivitas='" + logAktivitas + '\'' +
                ", logUser='" + logUser + '\'' +
                '}';
    }
}