package com.okesalon.dao;
import com.okesalon.util.koneksi;
import com.okesalon.model.ArsipDokumen;
import com.okesalon.util.SessionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class ArsipDokumenDAO {
    private Connection connection;
    
    public ArsipDokumenDAO() {
        this.connection = koneksi.getConnection();
    }

    public boolean insert(ArsipDokumen dokumen) {
        String sql = "INSERT INTO arsip_dokumen " +
                     "(id_dokumen, kategori_dokumen, judul_dokumen, tanggal_dokumen, " +
                     "tanggal_expired, status, deskripsi, file_path, " +
                     "log_aktivitas, log_user, log_timestamp) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Tambah', ?, NOW())";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dokumen.getIdDokumen());
            ps.setString(2, dokumen.getKategoriDokumen());
            ps.setString(3, dokumen.getJudulDokumen());
            ps.setDate(4, new java.sql.Date(dokumen.getTanggalDokumen().getTime()));
            
            if (dokumen.getTanggalExpired() != null) {
                ps.setDate(5, new java.sql.Date(dokumen.getTanggalExpired().getTime()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            
            ps.setString(6, dokumen.getStatus());
            ps.setString(7, dokumen.getDeskripsi());
            ps.setString(8, dokumen.getFilePath());
            
            SessionManager session = SessionManager.getInstance();
            String userName = session.getDisplayName();
            ps.setString(9, userName);
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("[TAMBAH] Dokumen " + dokumen.getIdDokumen() + 
                                 " berhasil ditambahkan oleh " + userName);
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error insert dokumen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<ArsipDokumen> getAll() {
        List<ArsipDokumen> list = new ArrayList<>();
        String sql = "SELECT * FROM arsip_dokumen ORDER BY log_timestamp DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
            System.out.println("Berhasil load " + list.size() + " dokumen");
            
        } catch (SQLException e) {
            System.err.println("Error getAll dokumen: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public ArsipDokumen getById(String idDokumen) {
        String sql = "SELECT * FROM arsip_dokumen WHERE id_dokumen = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, idDokumen);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Dokumen ditemukan: " + idDokumen);
                return extractDokumenFromResultSet(rs);
            } else {
                System.out.println("Dokumen tidak ditemukan: " + idDokumen);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getById: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    public boolean update(ArsipDokumen dokumen) {
        String sql = "UPDATE arsip_dokumen SET " +
                     "kategori_dokumen = ?, judul_dokumen = ?, tanggal_dokumen = ?, " +
                     "tanggal_expired = ?, status = ?, deskripsi = ?, file_path = ?, " +
                     "log_aktivitas = 'Edit', log_user = ?, log_timestamp = NOW() " +
                     "WHERE id_dokumen = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dokumen.getKategoriDokumen());
            ps.setString(2, dokumen.getJudulDokumen());
            ps.setDate(3, new java.sql.Date(dokumen.getTanggalDokumen().getTime()));
            
            if (dokumen.getTanggalExpired() != null) {
                ps.setDate(4, new java.sql.Date(dokumen.getTanggalExpired().getTime()));
            } else {
                ps.setNull(4, Types.DATE);
            }
            
            ps.setString(5, dokumen.getStatus());
            ps.setString(6, dokumen.getDeskripsi());
            ps.setString(7, dokumen.getFilePath());
            
            SessionManager session = SessionManager.getInstance();
            String userName = session.getDisplayName();
            ps.setString(8, userName);
            ps.setString(9, dokumen.getIdDokumen());
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("[EDIT] Dokumen " + dokumen.getIdDokumen() + 
                                 " berhasil diupdate oleh " + userName);
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error update dokumen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String idDokumen) {
        String sqlLog = "UPDATE arsip_dokumen SET " +
                       "log_aktivitas = 'Hapus', log_user = ?, log_timestamp = NOW() " +
                       "WHERE id_dokumen = ?";
        
        String sqlDelete = "DELETE FROM arsip_dokumen WHERE id_dokumen = ?";
        
        try {
            SessionManager session = SessionManager.getInstance();
            String userName = session.getDisplayName();

            PreparedStatement psLog = connection.prepareStatement(sqlLog);
            psLog.setString(1, userName);
            psLog.setString(2, idDokumen);
            psLog.executeUpdate();

            Thread.sleep(50);

            PreparedStatement psDelete = connection.prepareStatement(sqlDelete);
            psDelete.setString(1, idDokumen);
            int result = psDelete.executeUpdate();
            
            if (result > 0) {
                System.out.println("[HAPUS] Dokumen " + idDokumen + 
                                 " berhasil dihapus oleh " + userName);
                return true;
            }
            
            return false;
            
        } catch (SQLException | InterruptedException e) {
            System.err.println("Error delete dokumen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<ArsipDokumen> search(String keyword) {
        List<ArsipDokumen> list = new ArrayList<>();
        String sql = "SELECT * FROM arsip_dokumen " +
                     "WHERE judul_dokumen LIKE ? " +
                     "OR id_dokumen LIKE ? " +
                     "OR kategori_dokumen LIKE ? " +
                     "ORDER BY log_timestamp DESC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
            System.out.println("Pencarian '" + keyword + "' menghasilkan " + list.size() + " dokumen");
            
        } catch (SQLException e) {
            System.err.println("Error search dokumen: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public String generateIdDokumen() {
        String sql = "SELECT id_dokumen FROM arsip_dokumen " +
                     "ORDER BY id_dokumen DESC LIMIT 1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                String lastId = rs.getString("id_dokumen");
                int lastNumber = Integer.parseInt(lastId.substring(4));
                int nextNumber = lastNumber + 1;
                String newId = String.format("DOC-%03d", nextNumber);
                System.out.println("ID Dokumen baru: " + newId);
                return newId;
            } else {
                System.out.println("ID Dokumen pertama: DOC-001");
                return "DOC-001";
            }
            
        } catch (SQLException e) {
            System.err.println("Error generate ID: " + e.getMessage());
            e.printStackTrace();
            return "DOC-001";
        }
    }

    public List<ArsipDokumen> getDokumenExpired(int hariSebelumExpired) {
        List<ArsipDokumen> list = new ArrayList<>();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, hariSebelumExpired);
        java.sql.Date tanggalBatas = new java.sql.Date(cal.getTimeInMillis());
        
        String sql = "SELECT * FROM arsip_dokumen " +
                     "WHERE tanggal_expired IS NOT NULL " +
                     "AND tanggal_expired <= ? " +
                     "AND status = 'Aktif' " +
                     "ORDER BY tanggal_expired ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, tanggalBatas);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
            System.out.println("Ditemukan " + list.size() + " dokumen yang akan/sudah expired");
            
        } catch (SQLException e) {
            System.err.println("Error getDokumenExpired: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public int autoUpdateStatusExpired() {
        String sql = "UPDATE arsip_dokumen SET status = 'Expired' " +
                     "WHERE tanggal_expired < CURDATE() " +
                     "AND status = 'Aktif'";
        
        try (Statement stmt = connection.createStatement()) {
            int updated = stmt.executeUpdate(sql);
            
            if (updated > 0) {
                System.out.println("Auto-update: " + updated + " dokumen diubah status ke Expired");
            }
            
            return updated;
            
        } catch (SQLException e) {
            System.err.println("Error autoUpdateStatus: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
    
    public static class RowAktivitasArsip {
        public int no;
        public Date tanggal;
        public String namaDokumen;
        public String jenisAktivitas;
        public String logRingkas;
    }
    
    public static class SummaryArsip {
        public int upload;   
        public int akses;    
        public int edit;    
        public int total;   
    }
    
    public List<RowAktivitasArsip> getData(
            Date tanggalMulai, 
            Date tanggalSampai, 
            String jenisAktivitas,
            String keyword) {
        
        List<RowAktivitasArsip> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT ");
        sql.append("    id_dokumen, ");
        sql.append("    judul_dokumen, ");
        sql.append("    kategori_dokumen, ");
        sql.append("    status, ");
        sql.append("    file_path, ");
        sql.append("    log_aktivitas, ");
        sql.append("    log_user, ");
        sql.append("    log_timestamp ");
        sql.append("FROM arsip_dokumen ");
        sql.append("WHERE log_timestamp BETWEEN ? AND ? ");

        if (jenisAktivitas != null && !jenisAktivitas.equals("Semua Aktivitas")) {
            if (jenisAktivitas.equals("Upload")) {
                sql.append("AND file_path IS NOT NULL AND file_path != '' ");
            } else if (jenisAktivitas.equals("Akses")) {
                sql.append("AND log_aktivitas = 'Tambah' ");
            } else if (jenisAktivitas.equals("Edit")) {
                sql.append("AND log_aktivitas = 'Edit' ");
            } else if (jenisAktivitas.equals("Delete")) {
                sql.append("AND log_aktivitas = 'Hapus' ");
            }
        }
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append("AND (judul_dokumen LIKE ? OR id_dokumen LIKE ? OR log_user LIKE ?) ");
        }
        
        sql.append("ORDER BY log_timestamp DESC");
        
        try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int paramIndex = 1;
            Calendar calMulai = Calendar.getInstance();
            calMulai.setTime(tanggalMulai);
            calMulai.set(Calendar.HOUR_OF_DAY, 0);
            calMulai.set(Calendar.MINUTE, 0);
            calMulai.set(Calendar.SECOND, 0);
            
            Calendar calSampai = Calendar.getInstance();
            calSampai.setTime(tanggalSampai);
            calSampai.set(Calendar.HOUR_OF_DAY, 23);
            calSampai.set(Calendar.MINUTE, 59);
            calSampai.set(Calendar.SECOND, 59);
            
            ps.setTimestamp(paramIndex++, new Timestamp(calMulai.getTimeInMillis()));
            ps.setTimestamp(paramIndex++, new Timestamp(calSampai.getTimeInMillis()));
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                String pattern = "%" + keyword + "%";
                ps.setString(paramIndex++, pattern);
                ps.setString(paramIndex++, pattern);
                ps.setString(paramIndex++, pattern);
            }
            
            ResultSet rs = ps.executeQuery();
            int no = 1;
            
            while (rs.next()) {
                RowAktivitasArsip row = new RowAktivitasArsip();
                row.no = no++;
                row.tanggal = rs.getTimestamp("log_timestamp");
                row.namaDokumen = rs.getString("judul_dokumen");
                row.jenisAktivitas = determineJenisAktivitas(
                    rs.getString("file_path"),
                    rs.getString("log_aktivitas")
                );
                row.logRingkas = generateLogRingkas(
                    rs.getString("log_aktivitas"),
                    rs.getString("log_user"),
                    rs.getString("status"),
                    rs.getString("kategori_dokumen")
                );
                
                list.add(row);
            }
            
            System.out.println("Laporan aktivitas: " + list.size() + " dokumen");
            
        } catch (SQLException e) {
            System.err.println("Error getData laporan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    public SummaryArsip getSummary(
            Date tanggalMulai, 
            Date tanggalSampai,
            String jenisAktivitas) {
        
        SummaryArsip summary = new SummaryArsip();
        
        try {
            Calendar calMulai = Calendar.getInstance();
            calMulai.setTime(tanggalMulai);
            calMulai.set(Calendar.HOUR_OF_DAY, 0);
            calMulai.set(Calendar.MINUTE, 0);
            calMulai.set(Calendar.SECOND, 0);
            
            Calendar calSampai = Calendar.getInstance();
            calSampai.setTime(tanggalSampai);
            calSampai.set(Calendar.HOUR_OF_DAY, 23);
            calSampai.set(Calendar.MINUTE, 59);
            calSampai.set(Calendar.SECOND, 59);
            
            Timestamp tsMulai = new Timestamp(calMulai.getTimeInMillis());
            Timestamp tsSampai = new Timestamp(calSampai.getTimeInMillis());
            
            String baseSql = "FROM arsip_dokumen WHERE log_timestamp BETWEEN ? AND ? ";
            String sqlUpload = "SELECT COUNT(*) as total " + baseSql + 
                              "AND file_path IS NOT NULL AND file_path != ''";
            PreparedStatement ps = connection.prepareStatement(sqlUpload);
            ps.setTimestamp(1, tsMulai);
            ps.setTimestamp(2, tsSampai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                summary.upload = rs.getInt("total");
            }
            
            String sqlAkses = "SELECT COUNT(*) as total " + baseSql + 
                             "AND log_aktivitas = 'Tambah'";
            ps = connection.prepareStatement(sqlAkses);
            ps.setTimestamp(1, tsMulai);
            ps.setTimestamp(2, tsSampai);
            rs = ps.executeQuery();
            if (rs.next()) {
                summary.akses = rs.getInt("total");
            }
            
            String sqlEdit = "SELECT COUNT(*) as total " + baseSql + 
                            "AND log_aktivitas = 'Edit'";
            ps = connection.prepareStatement(sqlEdit);
            ps.setTimestamp(1, tsMulai);
            ps.setTimestamp(2, tsSampai);
            rs = ps.executeQuery();
            if (rs.next()) {
                summary.edit = rs.getInt("total");
            }
            
            String sqlTotal = "SELECT COUNT(*) as total " + baseSql;
            ps = connection.prepareStatement(sqlTotal);
            ps.setTimestamp(1, tsMulai);
            ps.setTimestamp(2, tsSampai);
            rs = ps.executeQuery();
            if (rs.next()) {
                summary.total = rs.getInt("total");
            }
            
            System.out.println("Summary: Upload=" + summary.upload + 
                             ", Akses=" + summary.akses + 
                             ", Edit=" + summary.edit + 
                             ", Total=" + summary.total);
            
        } catch (SQLException e) {
            System.err.println("Error getSummary: " + e.getMessage());
            e.printStackTrace();
        }
        
        return summary;
    }
    
    public List<String> getAllKategori() {
        List<String> list = new ArrayList<>();
        list.add("Semua Kategori");
        
        String sql = "SELECT DISTINCT kategori_dokumen FROM arsip_dokumen " +
                     "WHERE kategori_dokumen IS NOT NULL " +
                     "ORDER BY kategori_dokumen";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String kategori = rs.getString("kategori_dokumen");
                if (kategori != null && !kategori.trim().isEmpty()) {
                    list.add(kategori);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error getAllKategori: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public int countByStatus(String status) {
        String sql = "SELECT COUNT(*) as total FROM arsip_dokumen WHERE status = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("Error countByStatus: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }

    public int countByKategori(String kategori) {
        String sql = "SELECT COUNT(*) as total FROM arsip_dokumen WHERE kategori_dokumen = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kategori);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("Error countByKategori: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }

    public int countExpiredButActive() {
        String sql = "SELECT COUNT(*) as total FROM arsip_dokumen " +
                     "WHERE tanggal_expired < CURDATE() AND status = 'Aktif'";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                int total = rs.getInt("total");
                if (total > 0) {
                    System.out.println("WARNING: " + total + " dokumen sudah expired tapi masih Aktif!");
                }
                return total;
            }
            
        } catch (SQLException e) {
            System.err.println("Error countExpiredButActive: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }

    public List<ArsipDokumen> getDokumenHampirExpired(int hariSebelumExpired) {
        List<ArsipDokumen> list = new ArrayList<>();
        
        String sql = "SELECT * FROM arsip_dokumen " +
                     "WHERE tanggal_expired IS NOT NULL " +
                     "AND tanggal_expired BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL ? DAY) " +
                     "AND status = 'Aktif' " +
                     "ORDER BY tanggal_expired ASC";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, hariSebelumExpired);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ArsipDokumen d = extractDokumenFromResultSet(rs);
                list.add(d);
            }
            
            if (list.size() > 0) {
                System.out.println("PERHATIAN: " + list.size() + 
                                 " dokumen akan expired dalam " + hariSebelumExpired + " hari!");
            }
            
        } catch (SQLException e) {
            System.err.println("Error getDokumenHampirExpired: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static class RowKategoriDokumen {
        public String kategoriDokumen;
        public int jumlah;
        public String status;
    }

    public static class SummaryKategori {
        public int aktif;
        public int nonAktif;
        public int expired;
        public int total;
    }

    public List<RowKategoriDokumen> getDataKategori(
            Date tanggalMulai,
            Date tanggalSampai,
            String statusFilter,
            String keyword,
            String orderBy) {

        List<RowKategoriDokumen> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ");
        sql.append("    kategori_dokumen, ");
        sql.append("    COUNT(*) as jumlah, ");
        sql.append("    GROUP_CONCAT(DISTINCT status ORDER BY status SEPARATOR ', ') as status ");
        sql.append("FROM arsip_dokumen ");
        sql.append("WHERE 1=1 ");

        if (tanggalMulai != null && tanggalSampai != null) {
            sql.append("AND tanggal_dokumen BETWEEN ? AND ? ");
        }

        if (statusFilter != null && !statusFilter.equals("Semua Status")) {
            sql.append("AND status = ? ");
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append("AND kategori_dokumen LIKE ? ");
        }

        sql.append("GROUP BY kategori_dokumen ");

        if ("Jumlah Dokumen".equals(orderBy)) {
            sql.append("ORDER BY jumlah DESC, kategori_dokumen ASC");
        } else if ("Nama Dokumen".equals(orderBy)) {
            sql.append("ORDER BY kategori_dokumen ASC");
        } else if ("Tanggal".equals(orderBy)) {
            sql.append("ORDER BY MAX(tanggal_dokumen) DESC");
        } else {
            sql.append("ORDER BY jumlah DESC");
        }

        try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int paramIndex = 1;

            if (tanggalMulai != null && tanggalSampai != null) {
                Calendar calMulai = Calendar.getInstance();
                calMulai.setTime(tanggalMulai);
                calMulai.set(Calendar.HOUR_OF_DAY, 0);
                calMulai.set(Calendar.MINUTE, 0);
                calMulai.set(Calendar.SECOND, 0);

                Calendar calSampai = Calendar.getInstance();
                calSampai.setTime(tanggalSampai);
                calSampai.set(Calendar.HOUR_OF_DAY, 23);
                calSampai.set(Calendar.MINUTE, 59);
                calSampai.set(Calendar.SECOND, 59);

                ps.setTimestamp(paramIndex++, new Timestamp(calMulai.getTimeInMillis()));
                ps.setTimestamp(paramIndex++, new Timestamp(calSampai.getTimeInMillis()));
            }

            if (statusFilter != null && !statusFilter.equals("Semua Status")) {
                ps.setString(paramIndex++, statusFilter);
            }

            if (keyword != null && !keyword.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RowKategoriDokumen row = new RowKategoriDokumen();
                row.kategoriDokumen = rs.getString("kategori_dokumen");
                row.jumlah = rs.getInt("jumlah");
                row.status = rs.getString("status");

                list.add(row);
            }

            System.out.println("Laporan kategori: " + list.size() + " kategori");

        } catch (SQLException e) {
            System.err.println("Error getDataKategori: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public SummaryKategori getSummaryKategori(
            Date tanggalMulai,
            Date tanggalSampai,
            String statusFilter) {

        SummaryKategori summary = new SummaryKategori();

        try {
            StringBuilder baseSql = new StringBuilder("FROM arsip_dokumen WHERE 1=1 ");

            if (tanggalMulai != null && tanggalSampai != null) {
                Calendar calMulai = Calendar.getInstance();
                calMulai.setTime(tanggalMulai);
                calMulai.set(Calendar.HOUR_OF_DAY, 0);
                calMulai.set(Calendar.MINUTE, 0);
                calMulai.set(Calendar.SECOND, 0);

                Calendar calSampai = Calendar.getInstance();
                calSampai.setTime(tanggalSampai);
                calSampai.set(Calendar.HOUR_OF_DAY, 23);
                calSampai.set(Calendar.MINUTE, 59);
                calSampai.set(Calendar.SECOND, 59);

                Timestamp tsMulai = new Timestamp(calMulai.getTimeInMillis());
                Timestamp tsSampai = new Timestamp(calSampai.getTimeInMillis());

                String sqlAktif = "SELECT COUNT(*) as total " + baseSql.toString() + 
                                 "AND tanggal_dokumen BETWEEN ? AND ? AND status = 'Aktif'";
                PreparedStatement ps = connection.prepareStatement(sqlAktif);
                ps.setTimestamp(1, tsMulai);
                ps.setTimestamp(2, tsSampai);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    summary.aktif = rs.getInt("total");
                }

                String sqlNonAktif = "SELECT COUNT(*) as total " + baseSql.toString() + 
                                    "AND tanggal_dokumen BETWEEN ? AND ? AND status = 'Non-Aktif'";
                ps = connection.prepareStatement(sqlNonAktif);
                ps.setTimestamp(1, tsMulai);
                ps.setTimestamp(2, tsSampai);
                rs = ps.executeQuery();
                if (rs.next()) {
                    summary.nonAktif = rs.getInt("total");
                }

                String sqlExpired = "SELECT COUNT(*) as total " + baseSql.toString() + 
                                   "AND tanggal_dokumen BETWEEN ? AND ? AND status = 'Expired'";
                ps = connection.prepareStatement(sqlExpired);
                ps.setTimestamp(1, tsMulai);
                ps.setTimestamp(2, tsSampai);
                rs = ps.executeQuery();
                if (rs.next()) {
                    summary.expired = rs.getInt("total");
                }

                String sqlTotal = "SELECT COUNT(*) as total " + baseSql.toString() + 
                                 "AND tanggal_dokumen BETWEEN ? AND ?";
                ps = connection.prepareStatement(sqlTotal);
                ps.setTimestamp(1, tsMulai);
                ps.setTimestamp(2, tsSampai);
                rs = ps.executeQuery();
                if (rs.next()) {
                    summary.total = rs.getInt("total");
                }
            } else {
                summary.aktif = countByStatus("Aktif");
                summary.nonAktif = countByStatus("Non-Aktif");
                summary.expired = countByStatus("Expired");
                summary.total = summary.aktif + summary.nonAktif + summary.expired;
            }

            System.out.println("✅ Summary Kategori: Aktif=" + summary.aktif + 
                             ", Non-Aktif=" + summary.nonAktif + 
                             ", Expired=" + summary.expired + 
                             ", Total=" + summary.total);

        } catch (SQLException e) {
            System.err.println("Error getSummaryKategori: " + e.getMessage());
            e.printStackTrace();
        }

        return summary;
    }

    private String determineJenisAktivitas(String filePath, String logAktivitas) {

        if (filePath != null && !filePath.isEmpty()) {
            return "Upload";
        }
        
        if ("Tambah".equals(logAktivitas)) {
            return "Akses";
        } else if ("Edit".equals(logAktivitas)) {
            return "Edit";
        } else if ("Hapus".equals(logAktivitas)) {
            return "Delete";
        } else {
            return "Akses";
        }
    }
    
    private String generateLogRingkas(String logAktivitas, String logUser, 
                                      String status, String kategori) {
        StringBuilder log = new StringBuilder();
        
        if ("Tambah".equals(logAktivitas)) {
            log.append("Dokumen ditambahkan");
        } else if ("Edit".equals(logAktivitas)) {
            log.append("Dokumen diedit");
        } else if ("Hapus".equals(logAktivitas)) {
            log.append("Dokumen dihapus");
        } else {
            log.append("Aktivitas dokumen");
        }
        
        log.append(" oleh ").append(logUser != null ? logUser : "System");
        log.append(" | Kategori: ").append(kategori != null ? kategori : "N/A");
        log.append(" | Status: ").append(status);
        
        return log.toString();
    }

    private ArsipDokumen extractDokumenFromResultSet(ResultSet rs) throws SQLException {
        ArsipDokumen d = new ArsipDokumen();
        d.setIdDokumen(rs.getString("id_dokumen"));
        d.setKategoriDokumen(rs.getString("kategori_dokumen"));
        d.setJudulDokumen(rs.getString("judul_dokumen"));
        d.setTanggalDokumen(rs.getDate("tanggal_dokumen"));
        d.setTanggalExpired(rs.getDate("tanggal_expired"));
        d.setStatus(rs.getString("status"));
        d.setDeskripsi(rs.getString("deskripsi"));
        d.setFilePath(rs.getString("file_path"));
        d.setLogAktivitas(rs.getString("log_aktivitas"));
        d.setLogUser(rs.getString("log_user"));
        d.setLogTimestamp(rs.getTimestamp("log_timestamp"));
        
        return d;
    }
}