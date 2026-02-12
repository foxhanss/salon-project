package com.okesalon.view.laporan.laporanoperasional;
import com.okesalon.util.koneksi;
import com.okesalon.dao.LaporanAbsensiDAO;
import com.okesalon.util.SessionManager;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;

public class LaporanAbsensi extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private LaporanAbsensiDAO dao;
    private SimpleDateFormat formatTanggal = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatJam = new SimpleDateFormat("HH:mm");

    public LaporanAbsensi() {
        initComponents();
        dao = new LaporanAbsensiDAO();
        initTable();
        loadJabatan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_laporan_absensi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tgl_mulai = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        tgl_sampai = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jabatan = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotalHadir = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTotalIzin = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTotalSakit = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTotalAlpha = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTotalDataAbsensi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTotalCuti = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 255));

        tabel_laporan_absensi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_laporan_absensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_laporan_absensi);

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 204));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ABSENSI KARYAWAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Mulai Tanggal");

        tgl_mulai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Sampai Tanggal");

        tgl_sampai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Jabatan");

        jabatan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seluruh Karyawan", "Stylist", "Beautician", "Nail Artist", "Spa Therapist", "Kasir", "Manager" }));
        jabatan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(29, 29, 29)
                .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel15)
                .addGap(29, 29, 29)
                .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnFilter.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnFilter.setText("FILTER");
        btnFilter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCetak.setText("CETAK");
        btnCetak.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));

        jPanel7.setBackground(new java.awt.Color(255, 102, 204));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SUMMARY");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Hadir :");

        txtTotalHadir.setEditable(false);
        txtTotalHadir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Izin :");

        txtTotalIzin.setEditable(false);
        txtTotalIzin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalIzin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalIzinActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Sakit :");

        txtTotalSakit.setEditable(false);
        txtTotalSakit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalSakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalSakitActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Alpha :");

        txtTotalAlpha.setEditable(false);
        txtTotalAlpha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalAlpha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAlphaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Total Data Absensi :");

        txtTotalDataAbsensi.setEditable(false);
        txtTotalDataAbsensi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("Cuti :");

        txtTotalCuti.setEditable(false);
        txtTotalCuti.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCutiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalDataAbsensi))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(29, 29, 29)
                        .addComponent(txtTotalHadir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalIzin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalSakit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalCuti, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotalCuti, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel16)
                        .addComponent(txtTotalIzin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtTotalAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txtTotalSakit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalHadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTotalDataAbsensi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        modelTabel = new DefaultTableModel(
            new Object[]{"No", "Kode", "Tanggal", "Nama Karyawan", "Jabatan", "Jam Masuk", "Jam Keluar", "Total Jam", "Status", "Keterangan"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_laporan_absensi.setModel(modelTabel);
        tabel_laporan_absensi.getColumnModel().getColumn(0).setPreferredWidth(40);  
        tabel_laporan_absensi.getColumnModel().getColumn(1).setPreferredWidth(120); 
        tabel_laporan_absensi.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tabel_laporan_absensi.getColumnModel().getColumn(3).setPreferredWidth(150); 
        tabel_laporan_absensi.getColumnModel().getColumn(4).setPreferredWidth(100); 
        tabel_laporan_absensi.getColumnModel().getColumn(5).setPreferredWidth(80);  
        tabel_laporan_absensi.getColumnModel().getColumn(6).setPreferredWidth(80);  
        tabel_laporan_absensi.getColumnModel().getColumn(7).setPreferredWidth(80);  
        tabel_laporan_absensi.getColumnModel().getColumn(8).setPreferredWidth(80);  
        tabel_laporan_absensi.getColumnModel().getColumn(9).setPreferredWidth(150); 
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_laporan_absensi.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabel_laporan_absensi.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabel_laporan_absensi.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tabel_laporan_absensi.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tabel_laporan_absensi.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
    }
    
        private void loadJabatan() {
         try {
             List<String> jabatanList = dao.getJabatan();
             jabatan.removeAllItems();
             for (String jab : jabatanList) {  
                 jabatan.addItem(jab);         
             }
             jabatan.setSelectedIndex(0);
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(this, 
                 "Gagal memuat data jabatan: " + e.getMessage(),
                 "Error", JOptionPane.ERROR_MESSAGE);
         }
     }

    private void fillTable(List<LaporanAbsensiDAO.RowAbsensi> rows) {
    modelTabel.setRowCount(0);
    
    int no = 1;
    for (LaporanAbsensiDAO.RowAbsensi row : rows) {
        modelTabel.addRow(new Object[]{
            no++,
            row.kodeAbsensi,
            formatTanggal.format(row.tanggalAbsensi),
            row.namaKaryawan,
            row.jabatan,
            row.jamMasuk != null ? formatJam.format(row.jamMasuk) : "-",
            row.jamKeluar != null ? formatJam.format(row.jamKeluar) : "-",
            row.totalJamKerja != null ? row.totalJamKerja : "-",
            row.statusKehadiran,
            row.keterangan != null ? row.keterangan : "-"
        });
    }
    updateSummary(rows);
}
    
    
    private void updateSummary(List<LaporanAbsensiDAO.RowAbsensi> rows) {
        int totalHadir = 0;
        int totalIzin = 0;
        int totalSakit = 0;
        int totalAlpha = 0;
        int totalCuti = 0;

        for (LaporanAbsensiDAO.RowAbsensi row : rows) {
            String status = row.statusKehadiran;

            if (status == null) continue;

            switch (status.toUpperCase()) {
                case "HADIR":
                    totalHadir++;
                    break;
                case "IZIN":
                    totalIzin++;
                    break;
                case "SAKIT":
                    totalSakit++;
                    break;
                case "ALPHA":
                    totalAlpha++;
                    break;
                case "CUTI":
                    totalCuti++;
                    break;
            }
        }

        int totalData = rows.size();

        txtTotalHadir.setText(String.valueOf(totalHadir));     
        txtTotalIzin.setText(String.valueOf(totalIzin));        
        txtTotalSakit.setText(String.valueOf(totalSakit));    
        txtTotalAlpha.setText(String.valueOf(totalAlpha));     
        txtTotalCuti.setText(String.valueOf(totalCuti));     
        txtTotalDataAbsensi.setText(String.valueOf(totalData)); 
    }
    
    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
     try {
        if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Tanggal mulai dan sampai wajib diisi!", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Date mulai = new Date(tgl_mulai.getDate().getTime());
        Date sampai = new Date(tgl_sampai.getDate().getTime());
        
        String Jabatan = jabatan.getSelectedItem().toString();
        if (Jabatan.equals("Seluruh Karyawan")) {
            Jabatan = "Semua Jabatan";
        }
        
        SessionManager session = SessionManager.getInstance();
        
        Map<String, Object> params = new HashMap<>();
        params.put("p_tgl_mulai", mulai);
        params.put("p_tgl_sampai", sampai);
        params.put("p_jabatan", Jabatan);
        params.put("namaUser", session.getNamaLengkap());
        params.put("roleUser", session.getRole());
        
        InputStream is = getClass().getResourceAsStream(
            "/report/laporanoperasional/LaporanAbsensi.jasper");
        
        if (is == null) {
            JOptionPane.showMessageDialog(this, 
                "File report tidak ditemukan!\n" +
                "Path: /report/laporanoperasional/LaporanAbsensi.jasper", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Connection conn = koneksi.getConnection();
        
        JasperPrint jp = JasperFillManager.fillReport(is, params, conn);
        
        JasperViewer.viewReport(jp, false);
        
        conn.close();
        
        JOptionPane.showMessageDialog(this, 
            "Report berhasil dicetak!", 
            "Sukses", 
            JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Gagal mencetak laporan: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatanActionPerformed

    }//GEN-LAST:event_jabatanActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
     try {
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai dan sampai wajib diisi!", 
                    "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Date mulai = new Date(tgl_mulai.getDate().getTime());
            Date sampai = new Date(tgl_sampai.getDate().getTime());
            
            if (mulai.after(sampai)) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai tidak boleh lebih besar dari tanggal sampai!", 
                    "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String Jabatan = (String) jabatan.getSelectedItem();
            
            List<LaporanAbsensiDAO.RowAbsensi> rows = 
                dao.getData(mulai, sampai, Jabatan, txtCari.getText());
            
            fillTable(rows);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data absensi: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tgl_mulai.setDate(null);
        tgl_sampai.setDate(null);
        jabatan.setSelectedIndex(0);
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtTotalHadir.setText("0");           
        txtTotalSakit.setText("0");            
        txtTotalIzin.setText("0");         
        txtTotalAlpha.setText("0");           
        txtTotalCuti.setText("0");          
        txtTotalDataAbsensi.setText("0");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    try {
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Isi tanggal filter terlebih dahulu!", 
                    "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Date mulai = new Date(tgl_mulai.getDate().getTime());
            Date sampai = new Date(tgl_sampai.getDate().getTime());
            String Jabatan = (String) jabatan.getSelectedItem();
            
            List<LaporanAbsensiDAO.RowAbsensi> rows = 
                dao.getData(mulai, sampai, Jabatan, txtCari.getText());
            
            fillTable(rows);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Gagal mencari data: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtTotalIzinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalIzinActionPerformed

    }//GEN-LAST:event_txtTotalIzinActionPerformed

    private void txtTotalSakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalSakitActionPerformed

    }//GEN-LAST:event_txtTotalSakitActionPerformed

    private void txtTotalAlphaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAlphaActionPerformed

    }//GEN-LAST:event_txtTotalAlphaActionPerformed

    private void txtTotalCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCutiActionPerformed

    }//GEN-LAST:event_txtTotalCutiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jabatan;
    private javax.swing.JTable tabel_laporan_absensi;
    private com.toedter.calendar.JDateChooser tgl_mulai;
    private com.toedter.calendar.JDateChooser tgl_sampai;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtTotalAlpha;
    private javax.swing.JTextField txtTotalCuti;
    private javax.swing.JTextField txtTotalDataAbsensi;
    private javax.swing.JTextField txtTotalHadir;
    private javax.swing.JTextField txtTotalIzin;
    private javax.swing.JTextField txtTotalSakit;
    // End of variables declaration//GEN-END:variables
}