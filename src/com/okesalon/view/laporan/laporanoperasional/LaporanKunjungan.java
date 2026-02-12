package com.okesalon.view.laporan.laporanoperasional;
import com.okesalon.util.koneksi;
import com.okesalon.dao.LaporanKunjunganDAO;
import com.okesalon.dao.LaporanKunjunganDAO.RowKunjungan;
import com.okesalon.util.SessionManager;
import java.text.DecimalFormat;
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

public class LaporanKunjungan extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private LaporanKunjunganDAO dao;
    private DecimalFormat formatRupiah = new DecimalFormat("#,##0");
    private SimpleDateFormat formatTanggal = new SimpleDateFormat("dd/MM/yyyy");

    public LaporanKunjungan() {
        initComponents();
        dao = new LaporanKunjunganDAO();
        initTable();
        loadMembership();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kunjungan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        membership = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tgl_mulai = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        tgl_sampai = new com.toedter.calendar.JDateChooser();
        btnFilter = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblTotalMasuk = new javax.swing.JLabel();
        lblTotalKeluar = new javax.swing.JLabel();
        lblSaldoKas = new javax.swing.JLabel();
        txtTotalPelanggan = new javax.swing.JTextField();
        txtTotalPengeluaran = new javax.swing.JTextField();
        txtRataRataPengeluaran = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 255));

        tabel_kunjungan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_kunjungan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_kunjungan);

        jPanel2.setBackground(new java.awt.Color(255, 220, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Mulai Tanggal");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Membership");

        membership.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        membership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Silver", "Gold", "Platinum" }));
        membership.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(255, 102, 204));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("KUNJUNGAN PELANGGAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tgl_mulai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Sampai Tanggal");

        tgl_sampai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(36, 36, 36)
                        .addComponent(membership, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13)
                        .addGap(36, 36, 36)
                        .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addGap(36, 36, 36)
                .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(membership, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        btnFilter.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnFilter.setText("FILTER");
        btnFilter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCetak.setText("CETAK");
        btnCetak.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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

        txtCari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 204, 255));

        jPanel11.setBackground(new java.awt.Color(255, 102, 204));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("SUMMARY");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTotalMasuk.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTotalMasuk.setText("Total Pelanggan                :");

        lblTotalKeluar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTotalKeluar.setText("Total Pengeluaran             :");

        lblSaldoKas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblSaldoKas.setText("Rata-Rata Pengeluaran     :");

        txtTotalPelanggan.setEditable(false);
        txtTotalPelanggan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPelangganActionPerformed(evt);
            }
        });

        txtTotalPengeluaran.setEditable(false);
        txtTotalPengeluaran.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtRataRataPengeluaran.setEditable(false);
        txtRataRataPengeluaran.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblTotalMasuk)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalKeluar)
                            .addComponent(lblSaldoKas))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalPengeluaran)
                            .addComponent(txtRataRataPengeluaran))))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalMasuk)
                    .addComponent(txtTotalPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalKeluar)
                    .addComponent(txtTotalPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoKas)
                    .addComponent(txtRataRataPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        modelTabel = new DefaultTableModel(
            new Object[]{"No", "Kode", "Nama", "Telepon", "Membership", "Kunjungan", "Pengeluaran", "Tgl. Terakhir"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_kunjungan.setModel(modelTabel);
        tabel_kunjungan.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabel_kunjungan.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabel_kunjungan.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabel_kunjungan.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabel_kunjungan.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabel_kunjungan.getColumnModel().getColumn(5).setPreferredWidth(90);
        tabel_kunjungan.getColumnModel().getColumn(6).setPreferredWidth(150);
        tabel_kunjungan.getColumnModel().getColumn(7).setPreferredWidth(120);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_kunjungan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabel_kunjungan.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabel_kunjungan.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tabel_kunjungan.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tabel_kunjungan.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tabel_kunjungan.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
    }
    
    private void loadMembership() {
        try {
            List<String> list = dao.getMembership();
            membership.removeAllItems();
            for (String m : list) {
                membership.addItem(m);
            }
            membership.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal load membership: " + e.getMessage());
        }
    }   
    
    private void fillTable(List<RowKunjungan> rows) {
        modelTabel.setRowCount(0);
        int no = 1;
        for (RowKunjungan row : rows) {
            modelTabel.addRow(new Object[]{
                no++,
                row.kodePelanggan,
                row.namaLengkap,
                row.noTelepon,
                row.membershipType != null ? row.membershipType : "-",
                row.totalKunjungan,
                "Rp " + formatRupiah.format(row.totalPengeluaran),
                formatTanggal.format(row.kunjunganTerakhir)
            });
        }
    }
    
    private void updateSummary() {
        int totalPelanggan = 0;
        double totalPengeluaran = 0.0;
        int totalKunjungan = 0;

        for (int i = 0; i < modelTabel.getRowCount(); i++) {
            totalPelanggan++;
            totalKunjungan += Integer.parseInt(modelTabel.getValueAt(i, 5).toString());
            String pengeluaranStr = modelTabel.getValueAt(i, 6).toString();
            pengeluaranStr = pengeluaranStr.replace("Rp ", "").replace(",", "");
            totalPengeluaran += Double.parseDouble(pengeluaranStr);
        }

        double rataRata = totalPelanggan > 0 ? totalPengeluaran / totalPelanggan : 0;

        txtTotalPelanggan.setText(String.valueOf(totalPelanggan));
        txtTotalPengeluaran.setText("Rp " + formatRupiah.format(totalPengeluaran));
        txtRataRataPengeluaran.setText("Rp " + formatRupiah.format(rataRata));
    }
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        membership.setSelectedIndex(0);
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtTotalPelanggan.setText("");
        txtTotalPengeluaran.setText("");
        txtRataRataPengeluaran.setText("");

        JOptionPane.showMessageDialog(this, 
            "Form berhasil di-reset!", 
            "Info", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed

    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    try {
        if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Tanggal mulai dan sampai wajib diisi!", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (modelTabel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Tidak ada data untuk dicetak!\nKlik FILTER terlebih dahulu.", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Date mulai = new Date(tgl_mulai.getDate().getTime());
        Date sampai = new Date(tgl_sampai.getDate().getTime());
        String membershipType = membership.getSelectedItem().toString();
        
        SessionManager session = SessionManager.getInstance();
        
        int totalPelanggan = Integer.parseInt(txtTotalPelanggan.getText());
        String totalPengeluaran = txtTotalPengeluaran.getText().replace("Rp ", "").replace(",", "");
        String rataRata = txtRataRataPengeluaran.getText().replace("Rp ", "").replace(",", "");
        
        Map<String, Object> params = new HashMap<>();
        params.put("p_tgl_mulai", mulai);
        params.put("p_tgl_sampai", sampai);
        params.put("p_membership", membershipType);
        params.put("p_total_pelanggan", totalPelanggan);
        params.put("p_total_pengeluaran", Double.parseDouble(totalPengeluaran));
        params.put("p_rata_rata", Double.parseDouble(rataRata));
        params.put("namaUser", session.getNamaLengkap());
        params.put("roleUser", session.getRole());
        
        InputStream is = getClass().getResourceAsStream(
            "/report/laporanoperasional/LaporanKunjungan.jasper");
        
        if (is == null) {
            JOptionPane.showMessageDialog(this, 
                "File report tidak ditemukan!\n" +
                "Path: /report/laporanoperasional/LaporanKunjungan.jasper", 
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

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    try {
        if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Isi tanggal dulu!", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Date mulai = dao.toSqlDate(tgl_mulai.getDate());
        Date sampai = dao.toSqlDate(tgl_sampai.getDate());
        String Membership = (String) membership.getSelectedItem();      
        List<RowKunjungan> rows = dao.getData(mulai, sampai, Membership, txtCari.getText().trim());       
        fillTable(rows);       
        updateSummary();
        
        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Data tidak ditemukan!", 
                "Info", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Error: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        try {
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal wajib diisi!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            Date mulai = dao.toSqlDate(tgl_mulai.getDate());
            Date sampai = dao.toSqlDate(tgl_sampai.getDate());

            if (!dao.validatePeriode(tgl_mulai.getDate(), tgl_sampai.getDate())) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai > tanggal sampai!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String Membership = (String) membership.getSelectedItem();
            List<RowKunjungan> rows = dao.getData(mulai, sampai, Membership, txtCari.getText().trim());
            fillTable(rows);
            updateSummary();

            JOptionPane.showMessageDialog(this, 
                "Data dimuat! Total: " + rows.size() + " pelanggan", 
                "Sukses", 
                JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void txtTotalPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPelangganActionPerformed

    }//GEN-LAST:event_txtTotalPelangganActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldoKas;
    private javax.swing.JLabel lblTotalKeluar;
    private javax.swing.JLabel lblTotalMasuk;
    private javax.swing.JComboBox<String> membership;
    private javax.swing.JTable tabel_kunjungan;
    private com.toedter.calendar.JDateChooser tgl_mulai;
    private com.toedter.calendar.JDateChooser tgl_sampai;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtRataRataPengeluaran;
    private javax.swing.JTextField txtTotalPelanggan;
    private javax.swing.JTextField txtTotalPengeluaran;
    // End of variables declaration//GEN-END:variables
}