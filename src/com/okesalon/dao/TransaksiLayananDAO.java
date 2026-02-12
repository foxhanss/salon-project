package com.okesalon.dao;
import com.okesalon.util.koneksi;
import com.okesalon.model.TransaksiLayanan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiLayananDAO {
    public TransaksiLayananDAO() {}

    public boolean insertTransaksi(TransaksiLayanan transaksi) {
        String sql = "INSERT INTO transaksi_layanan " +
                     "(kode_transaksi, kode_pelanggan, nama_lengkap, no_telepon, " +
                     "kode_karyawan, nama_karyawan, kode_layanan, nama_layanan, " +
                     "harga_layanan, tanggal_transaksi, subtotal_layanan, diskon, " +
                     "total_pembayaran, metode_pembayaran, status_pembayaran, catatan_khusus) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        System.out.println("insertTransaksi() called");
        System.out.println("   Kode Transaksi: " + transaksi.getKodeTransaksi());
        System.out.println("   Nama Pelanggan: " + transaksi.getNamaLengkap());
        System.out.println("   Nama Karyawan: " + transaksi.getNamaKaryawan());
        System.out.println("   Nama Layanan: " + transaksi.getNamaLayanan());
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return false;
            }

            ps.setString(1, transaksi.getKodeTransaksi());
            ps.setString(2, transaksi.getKodePelanggan());
            ps.setString(3, transaksi.getNamaLengkap());
            ps.setString(4, transaksi.getNoTelepon());
            ps.setString(5, transaksi.getKodeKaryawan());
            ps.setString(6, transaksi.getNamaKaryawan());
            ps.setString(7, transaksi.getKodeLayanan());
            ps.setString(8, transaksi.getNamaLayanan());
            ps.setDouble(9, transaksi.getHargaLayanan());
            ps.setDate(10, new java.sql.Date(transaksi.getTanggalTransaksi().getTime()));
            ps.setDouble(11, transaksi.getSubtotalLayanan());
            ps.setString(12, transaksi.getDiskon());
            ps.setDouble(13, transaksi.getTotalPembayaran());
            ps.setString(14, transaksi.getMetodePembayaran());
            ps.setString(15, transaksi.getStatusPembayaran());
            ps.setString(16, transaksi.getCatatanKhusus());
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Transaksi berhasil disimpan!");
                return true;
            } else {
                System.err.println("Insert failed!");
                return false;
            }
            
        } catch (SQLException e) {
            System.err.println("Error insertTransaksi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<TransaksiLayanan> getAll() {
        List<TransaksiLayanan> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan ORDER BY tanggal_transaksi DESC, created_at DESC";
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getConnection();
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return list;
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                TransaksiLayanan t = extractFromResultSet(rs);
                list.add(t);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getAll: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        
        return list;
    }

    public TransaksiLayanan getByKode(String kodeTransaksi) {
        String sql = "SELECT * FROM transaksi_layanan WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeTransaksi);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error getByKode: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    public boolean update(TransaksiLayanan transaksi) {
        String sql = "UPDATE transaksi_layanan SET " +
                     "kode_pelanggan = ?, nama_lengkap = ?, no_telepon = ?, " +
                     "kode_karyawan = ?, nama_karyawan = ?, kode_layanan = ?, " +
                     "nama_layanan = ?, harga_layanan = ?, tanggal_transaksi = ?, " +
                     "subtotal_layanan = ?, diskon = ?, total_pembayaran = ?, " +
                     "metode_pembayaran = ?, status_pembayaran = ?, catatan_khusus = ? " +
                     "WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, transaksi.getKodePelanggan());
            ps.setString(2, transaksi.getNamaLengkap());
            ps.setString(3, transaksi.getNoTelepon());
            ps.setString(4, transaksi.getKodeKaryawan());
            ps.setString(5, transaksi.getNamaKaryawan());
            ps.setString(6, transaksi.getKodeLayanan());
            ps.setString(7, transaksi.getNamaLayanan());
            ps.setDouble(8, transaksi.getHargaLayanan());
            ps.setDate(9, new java.sql.Date(transaksi.getTanggalTransaksi().getTime()));
            ps.setDouble(10, transaksi.getSubtotalLayanan());
            ps.setString(11, transaksi.getDiskon());
            ps.setDouble(12, transaksi.getTotalPembayaran());
            ps.setString(13, transaksi.getMetodePembayaran());
            ps.setString(14, transaksi.getStatusPembayaran());
            ps.setString(15, transaksi.getCatatanKhusus());
            ps.setString(16, transaksi.getKodeTransaksi());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error update: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String kodeTransaksi) {
        String sql = "DELETE FROM transaksi_layanan WHERE kode_transaksi = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeTransaksi);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error delete: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<TransaksiLayanan> search(String keyword) {
        List<TransaksiLayanan> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan " +
                     "WHERE kode_transaksi LIKE ? " +
                     "OR nama_lengkap LIKE ? " +
                     "OR nama_karyawan LIKE ? " +
                     "OR nama_layanan LIKE ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            ps.setString(4, pattern);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TransaksiLayanan t = extractFromResultSet(rs);
                list.add(t);
            }
            
        } catch (SQLException e) {
            System.err.println("Error search: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public String generateKodeTransaksi() {
        String today = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
        String prefix = "TRX-" + today + "-";
        
        String sql = "SELECT kode_transaksi FROM transaksi_layanan " +
                     "WHERE kode_transaksi LIKE ? " +
                     "ORDER BY kode_transaksi DESC LIMIT 1";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, prefix + "%");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String lastKode = rs.getString("kode_transaksi");
                String lastNumber = lastKode.substring(lastKode.length() - 3);
                int nextNumber = Integer.parseInt(lastNumber) + 1;
                return prefix + String.format("%03d", nextNumber);
            } else {
                return prefix + "001";
            }
            
        } catch (SQLException e) {
            System.err.println("Error generateKode: " + e.getMessage());
            e.printStackTrace();
            return prefix + "001";
        }
    }

    public List<TransaksiLayanan> getByDateRange(Date startDate, Date endDate) {
        List<TransaksiLayanan> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan " +
                     "WHERE tanggal_transaksi BETWEEN ? AND ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TransaksiLayanan t = extractFromResultSet(rs);
                list.add(t);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByDateRange: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public List<TransaksiLayanan> getByPelanggan(String kodePelanggan) {
        List<TransaksiLayanan> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan " +
                     "WHERE kode_pelanggan = ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodePelanggan);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TransaksiLayanan t = extractFromResultSet(rs);
                list.add(t);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByPelanggan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public List<TransaksiLayanan> getByStatus(String status) {
        List<TransaksiLayanan> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_layanan " +
                     "WHERE status_pembayaran = ? " +
                     "ORDER BY tanggal_transaksi DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TransaksiLayanan t = extractFromResultSet(rs);
                list.add(t);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getByStatus: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    public double getTotalPendapatan() {
        String sql = "SELECT SUM(total_pembayaran) as total FROM transaksi_layanan " +
                     "WHERE status_pembayaran = 'Lunas'";
        
        try (Connection conn = koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getDouble("total");
            }
            
        } catch (SQLException e) {
            System.err.println("Error getTotalPendapatan: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }

    private TransaksiLayanan extractFromResultSet(ResultSet rs) throws SQLException {
        TransaksiLayanan t = new TransaksiLayanan();
        t.setKodeTransaksi(rs.getString("kode_transaksi"));
        t.setKodePelanggan(rs.getString("kode_pelanggan"));
        t.setNamaLengkap(rs.getString("nama_lengkap"));
        t.setNoTelepon(rs.getString("no_telepon"));
        t.setKodeKaryawan(rs.getString("kode_karyawan"));
        t.setNamaKaryawan(rs.getString("nama_karyawan"));
        t.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
        t.setKodeLayanan(rs.getString("kode_layanan"));
        t.setNamaLayanan(rs.getString("nama_layanan"));
        t.setHargaLayanan(rs.getDouble("harga_layanan"));
        t.setSubtotalLayanan(rs.getDouble("subtotal_layanan"));
        t.setDiskon(rs.getString("diskon"));
        t.setTotalPembayaran(rs.getDouble("total_pembayaran"));
        t.setMetodePembayaran(rs.getString("metode_pembayaran"));
        t.setStatusPembayaran(rs.getString("status_pembayaran"));
        t.setCatatanKhusus(rs.getString("catatan_khusus"));
        t.setCreatedAt(rs.getTimestamp("created_at"));
        t.setUpdatedAt(rs.getTimestamp("updated_at"));
        
        return t;
    }
    
    public String getKodePelangganByNama(String namaPelanggan) {
        if (namaPelanggan == null) {
            System.out.println("namaPelanggan NULL di getKodePelangganByNama");
            return null;
        }

        String sql = "SELECT kode_pelanggan FROM master_pelanggan WHERE nama_lengkap = ? LIMIT 1";

        System.out.println("getKodePelangganByNama() called: '" + namaPelanggan + "'");

        try (Connection conn = koneksi.getConnection()) {

            if (conn == null) {
                System.err.println("Connection is NULL di getKodePelangganByNama");
                return null;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, namaPelanggan);
                System.out.println("Executing query with nama_lengkap = " + namaPelanggan);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String kode = rs.getString("kode_pelanggan");
                        System.out.println("FOUND kode_pelanggan: " + kode);
                        return kode;
                    } else {
                        System.out.println("Pelanggan tidak ditemukan di DB: " + namaPelanggan);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error getKodePelangganByNama: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public String getKodeKaryawanByNama(String namaKaryawan) {
        String sql = "SELECT kode_karyawan FROM master_karyawan WHERE nama_lengkap = ? LIMIT 1";
        
        System.out.println("getKodeKaryawanByNama() called: '" + namaKaryawan + "'");
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            if (conn == null) {
                System.err.println("Connection is NULL!");
                return null;
            }
            
            ps.setString(1, namaKaryawan);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String kode = rs.getString("kode_karyawan");
                System.out.println("FOUND kode_karyawan: " + kode);
                return kode;
            } else {
                System.out.println("Karyawan tidak ditemukan: " + namaKaryawan);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getKodeKaryawanByNama: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    public boolean deleteTransaksi(String kodeTransaksi) {
        return delete(kodeTransaksi);
    }

    public TransaksiLayanan getTransaksiByNo(String kodeTransaksi) {
        return getByKode(kodeTransaksi);
    }

    public List<TransaksiLayanan> searchTransaksi(String keyword) {
        return search(keyword);
    }

    public boolean updateTransaksi(TransaksiLayanan transaksi) {
        return update(transaksi);
    }

    public String generateNoTransaksi() {
        return generateKodeTransaksi();
    }

    public List<TransaksiLayanan> getAllTransaksi() {
        return getAll();
    }
    
    public String getDiskonMemberByNama(String namaPelanggan) {
    String sql = "SELECT discount_member FROM master_pelanggan WHERE nama_lengkap = ? LIMIT 1";

    try (Connection conn = koneksi.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, namaPelanggan);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("discount_member");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error getDiskonMemberByNama: " + e.getMessage());
        e.printStackTrace();
    }
    return "0%";
  }
}