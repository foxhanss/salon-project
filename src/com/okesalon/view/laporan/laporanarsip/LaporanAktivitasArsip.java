package com.okesalon.view.laporan.laporanarsip;
import com.okesalon.util.koneksi;
import com.okesalon.dao.ArsipDokumenDAO;
import com.okesalon.dao.ArsipDokumenDAO.RowAktivitasArsip;
import com.okesalon.dao.ArsipDokumenDAO.SummaryArsip;
import com.okesalon.util.SessionManager;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class LaporanAktivitasArsip extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private ArsipDokumenDAO dao;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LaporanAktivitasArsip() {
        initComponents();
        dao = new ArsipDokumenDAO();
        initTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_aktivitas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tanggal_mulai = new com.toedter.calendar.JDateChooser();
        tanggal_sampai = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jenis_aktivitas = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblupload = new javax.swing.JLabel();
        txtUpload = new javax.swing.JTextField();
        lblakses = new javax.swing.JLabel();
        txtAkses = new javax.swing.JTextField();
        lbledit = new javax.swing.JLabel();
        txtEdit = new javax.swing.JTextField();
        txtTotalAktivitas = new javax.swing.JTextField();
        lbltotalaktivitas = new javax.swing.JLabel();
        txtDelete = new javax.swing.JTextField();
        lblhapus = new javax.swing.JLabel();

        button1.setLabel("button1");

        setBackground(new java.awt.Color(255, 153, 255));

        tabel_aktivitas.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tabel_aktivitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Nama Dokumen", "Jenis Aktivitas", "Log Ringkas"
            }
        ));
        jScrollPane1.setViewportView(tabel_aktivitas);

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 102, 204));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AKTIVITAS ARSIP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tanggal Mulai");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Sampai Tanggal");

        tanggal_mulai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tanggal_sampai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Jenis Aktivitas :");

        jenis_aktivitas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jenis_aktivitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Aktivitas", "Upload", "Akses", "Edit", "Delete" }));
        jenis_aktivitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(tanggal_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tanggal_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jenis_aktivitas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(310, 310, 310))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel8))
                    .addComponent(tanggal_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenis_aktivitas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        btnCari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnFilter.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnFilter.setText("FILTER");
        btnFilter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
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

        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 204, 255));

        jPanel9.setBackground(new java.awt.Color(255, 102, 204));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SUMMARY");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblupload.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblupload.setText("Upload               :");

        txtUpload.setEditable(false);
        txtUpload.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUploadActionPerformed(evt);
            }
        });

        lblakses.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblakses.setText("Akses :");

        txtAkses.setEditable(false);
        txtAkses.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbledit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbledit.setText("Edit      :");

        txtEdit.setEditable(false);
        txtEdit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTotalAktivitas.setEditable(false);
        txtTotalAktivitas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbltotalaktivitas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbltotalaktivitas.setText("Total Aktivitas   :");

        txtDelete.setEditable(false);
        txtDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lblhapus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblhapus.setText("Delete :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbltotalaktivitas)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(txtTotalAktivitas, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(687, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblupload)
                        .addGap(18, 18, 18)
                        .addComponent(txtUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblakses)
                        .addGap(18, 18, 18)
                        .addComponent(txtAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbledit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblhapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblhapus)
                        .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUpload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblupload)
                        .addComponent(txtAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblakses)
                        .addComponent(lbledit)
                        .addComponent(txtEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltotalaktivitas)
                    .addComponent(txtTotalAktivitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(569, 569, 569)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        String[] columns = {
            "No", 
            "Tanggal",
            "Nama Dokumen", 
            "Jenis Aktivitas", 
            "Log Ringkas"
        };

        modelTabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabel_aktivitas.setModel(modelTabel);
        tabel_aktivitas.getColumnModel().getColumn(0).setPreferredWidth(50); 
        tabel_aktivitas.getColumnModel().getColumn(1).setPreferredWidth(150);  
        tabel_aktivitas.getColumnModel().getColumn(2).setPreferredWidth(350); 
        tabel_aktivitas.getColumnModel().getColumn(3).setPreferredWidth(120);  
        tabel_aktivitas.getColumnModel().getColumn(4).setPreferredWidth(400);  
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_aktivitas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);  
        tabel_aktivitas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);  
        tabel_aktivitas.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);  
        
        System.out.println("Tabel aktivitas arsip initialized");
    }

    private void fillTable(List<RowAktivitasArsip> rows) {
        modelTabel.setRowCount(0);
        int no = 1;

        for (RowAktivitasArsip row : rows) {
            modelTabel.addRow(new Object[]{
                no++,
                dateFormat.format(row.tanggal),
                row.namaDokumen,
                row.jenisAktivitas,
                row.logRingkas
            });
        }
        
        System.out.println("Tabel diisi dengan " + rows.size() + " baris data");
    }
    
    private void updateSummary(SummaryArsip summary) {
        txtUpload.setText(String.valueOf(summary.upload));
        txtAkses.setText(String.valueOf(summary.akses));
        txtEdit.setText(String.valueOf(summary.edit));
        
        int deleteCount = summary.total - (summary.upload + summary.akses + summary.edit);
        if (deleteCount < 0) deleteCount = 0;
        txtDelete.setText(String.valueOf(deleteCount));
        
        txtTotalAktivitas.setText(String.valueOf(summary.total));
        
        System.out.println("Summary updated: Upload=" + summary.upload + 
                         ", Akses=" + summary.akses + 
                         ", Edit=" + summary.edit + 
                         ", Delete=" + deleteCount +
                         ", Total=" + summary.total);
    }

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            if (modelTabel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, 
                    "Klik FILTER terlebih dahulu!\nTidak ada data untuk dicetak.", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (tanggal_mulai.getDate() == null || tanggal_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai dan sampai wajib diisi!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            SessionManager session = SessionManager.getInstance();

            String summaryUpload = txtUpload.getText().trim();
            String summaryAkses = txtAkses.getText().trim();
            String summaryEdit = txtEdit.getText().trim();
            String summaryDelete = txtDelete.getText().trim();
            String summaryTotal = txtTotalAktivitas.getText().trim();

            Map<String, Object> params = new HashMap<>();
            params.put("p_tanggal_mulai", new java.sql.Date(tanggal_mulai.getDate().getTime()));
            params.put("p_tanggal_sampai", new java.sql.Date(tanggal_sampai.getDate().getTime()));
            params.put("p_jenis_aktivitas", (String) jenis_aktivitas.getSelectedItem());
            params.put("p_summary_upload", summaryUpload);
            params.put("p_summary_akses", summaryAkses);
            params.put("p_summary_edit", summaryEdit);
            params.put("p_summary_delete", summaryDelete);
            params.put("p_summary_total", summaryTotal);
            params.put("namaUser", session.getNamaLengkap());
            params.put("roleUser", session.getRole());

            InputStream is = getClass().getResourceAsStream("/report/laporanarsip/LaporanAktivitasArsip.jasper");

            if (is == null) {
                JOptionPane.showMessageDialog(this, 
                    "File report tidak ditemukan!\nPastikan file LaporanAktivitasArsip.jasper ada di folder /report/laporanarsip/", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection conn = koneksi.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(is, params, conn);
            JasperViewer.viewReport(jp, false);
            
            System.out.println("Laporan berhasil dicetak");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error saat mencetak laporan:\n" + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void txtUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUploadActionPerformed

    }//GEN-LAST:event_txtUploadActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
    try {
            if (tanggal_mulai.getDate() == null || tanggal_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Harap pilih tanggal mulai dan sampai!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (tanggal_mulai.getDate().after(tanggal_sampai.getDate())) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai tidak boleh lebih besar dari tanggal sampai!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            Date tanggalMulai = tanggal_mulai.getDate();
            Date tanggalSampai = tanggal_sampai.getDate();
            String jenisAktivitas = (String) jenis_aktivitas.getSelectedItem();

            List<RowAktivitasArsip> rows = dao.getData(
                tanggalMulai, 
                tanggalSampai, 
                jenisAktivitas, 
                txtCari.getText().trim()
            );

            fillTable(rows);

            SummaryArsip summary = dao.getSummary(
                tanggalMulai, 
                tanggalSampai, 
                jenisAktivitas
            );

            updateSummary(summary);

            JOptionPane.showMessageDialog(this, 
                "Data dimuat! Total: " + rows.size() + " aktivitas", 
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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tanggal_mulai.setDate(null);
        tanggal_sampai.setDate(null);
        jenis_aktivitas.setSelectedIndex(0);
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtUpload.setText("");
        txtAkses.setText("");
        txtEdit.setText("");
        txtDelete.setText("");
        txtTotalAktivitas.setText("");

        JOptionPane.showMessageDialog(this, "Form di-reset!", "Info", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Form direset");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    btnFilterActionPerformed(evt);
    }//GEN-LAST:event_btnCariActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis_aktivitas;
    private javax.swing.JLabel lblakses;
    private javax.swing.JLabel lbledit;
    private javax.swing.JLabel lblhapus;
    private javax.swing.JLabel lbltotalaktivitas;
    private javax.swing.JLabel lblupload;
    private javax.swing.JTable tabel_aktivitas;
    private com.toedter.calendar.JDateChooser tanggal_mulai;
    private com.toedter.calendar.JDateChooser tanggal_sampai;
    private javax.swing.JTextField txtAkses;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDelete;
    private javax.swing.JTextField txtEdit;
    private javax.swing.JTextField txtTotalAktivitas;
    private javax.swing.JTextField txtUpload;
    // End of variables declaration//GEN-END:variables
}