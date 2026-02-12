package com.okesalon.view.laporan.laporanarsip;
import com.okesalon.util.koneksi;
import com.okesalon.dao.ArsipDokumenDAO;
import com.okesalon.dao.ArsipDokumenDAO.RowKategoriDokumen;
import com.okesalon.dao.ArsipDokumenDAO.SummaryKategori;
import com.okesalon.util.SessionManager;
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

public class LaporanKategoriDokumen extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private ArsipDokumenDAO dao;

    public LaporanKategoriDokumen() {
        initComponents();
        dao = new ArsipDokumenDAO();
        initTable();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kategori_dokumen = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        status_dokumen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tanggal_mulai = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        tanggal_sampai = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        urutan = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblupload = new javax.swing.JLabel();
        txtAktif = new javax.swing.JTextField();
        lblakses = new javax.swing.JLabel();
        txtNonAktif = new javax.swing.JTextField();
        lbledit = new javax.swing.JLabel();
        txtExpired = new javax.swing.JTextField();
        txtTotalDokumen = new javax.swing.JTextField();
        lbltotalaktivitas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 255));

        tabel_kategori_dokumen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_kategori_dokumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kategori Dokumen", "Jumlah", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_kategori_dokumen);
        if (tabel_kategori_dokumen.getColumnModel().getColumnCount() > 0) {
            tabel_kategori_dokumen.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 102, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kategori Dokumen");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Status Dokumen");

        status_dokumen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        status_dokumen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Status", "Aktif", "Non-Aktif", "Expired" }));
        status_dokumen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        status_dokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_dokumenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Tanggal Mulai");

        tanggal_mulai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Sampai Tanggal");

        tanggal_sampai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Urut Berdasar");

        urutan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        urutan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jumlah Dokumen", "Nama Dokumen", "Tanggal" }));
        urutan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        urutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urutanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(tanggal_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(status_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urutan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8))
                    .addComponent(tanggal_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(urutan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(status_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnCari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

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
        lblupload.setText("Aktif                   :");

        txtAktif.setEditable(false);
        txtAktif.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAktifActionPerformed(evt);
            }
        });

        lblakses.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblakses.setText("Non-Aktif :");

        txtNonAktif.setEditable(false);
        txtNonAktif.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbledit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbledit.setText("Expired     :");

        txtExpired.setEditable(false);
        txtExpired.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTotalDokumen.setEditable(false);
        txtTotalDokumen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbltotalaktivitas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbltotalaktivitas.setText("Total Dokumen   :");

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
                        .addComponent(txtTotalDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(687, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblupload)
                        .addGap(18, 18, 18)
                        .addComponent(txtAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblakses)
                        .addGap(18, 18, 18)
                        .addComponent(txtNonAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbledit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblupload)
                    .addComponent(txtNonAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblakses)
                    .addComponent(lbledit)
                    .addComponent(txtExpired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltotalaktivitas)
                    .addComponent(txtTotalDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(559, 559, 559)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        String[] columns = {
            "No",
            "Kategori Dokumen", 
            "Jumlah", 
            "Status"
        };

        modelTabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabel_kategori_dokumen.setModel(modelTabel);
        tabel_kategori_dokumen.getColumnModel().getColumn(0).setPreferredWidth(50);   
        tabel_kategori_dokumen.getColumnModel().getColumn(1).setPreferredWidth(350);  
        tabel_kategori_dokumen.getColumnModel().getColumn(2).setPreferredWidth(100);  
        tabel_kategori_dokumen.getColumnModel().getColumn(3).setPreferredWidth(200);  

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_kategori_dokumen.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);  
        tabel_kategori_dokumen.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);  
        
        System.out.println("Tabel kategori dokumen initialized");
    }

    private void fillTable(List<RowKategoriDokumen> rows) {
        modelTabel.setRowCount(0);
        int no = 1;

        for (RowKategoriDokumen row : rows) {
            modelTabel.addRow(new Object[]{
                no++,
                row.kategoriDokumen,
                row.jumlah,
                row.status
            });
        }
        
        System.out.println("Tabel diisi dengan " + rows.size() + " kategori");
    }

    private void updateSummary(SummaryKategori summary) {
        txtAktif.setText(String.valueOf(summary.aktif));
        txtNonAktif.setText(String.valueOf(summary.nonAktif));
        txtExpired.setText(String.valueOf(summary.expired));
        txtTotalDokumen.setText(String.valueOf(summary.total));
        
        System.out.println("Summary updated: Aktif=" + summary.aktif + 
                         ", Non-Aktif=" + summary.nonAktif + 
                         ", Expired=" + summary.expired + 
                         ", Total=" + summary.total);
    }
    
    private void status_dokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_dokumenActionPerformed

    }//GEN-LAST:event_status_dokumenActionPerformed

    private void urutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urutanActionPerformed

    }//GEN-LAST:event_urutanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            if (modelTabel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, 
                    "Klik FILTER terlebih dahulu!\nTidak ada data untuk dicetak.", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            SessionManager session = SessionManager.getInstance();

            String summaryAktif = txtAktif.getText().trim();
            String summaryNonAktif = txtNonAktif.getText().trim();
            String summaryExpired = txtExpired.getText().trim();
            String summaryTotal = txtTotalDokumen.getText().trim();

            Map<String, Object> params = new HashMap<>();
            
            if (tanggal_mulai.getDate() != null && tanggal_sampai.getDate() != null) {
                params.put("p_tanggal_mulai", new java.sql.Date(tanggal_mulai.getDate().getTime()));
                params.put("p_tanggal_sampai", new java.sql.Date(tanggal_sampai.getDate().getTime()));
            } else {
                params.put("p_tanggal_mulai", null);
                params.put("p_tanggal_sampai", null);
            }
            
            params.put("p_status_dokumen", (String) status_dokumen.getSelectedItem());
            params.put("p_urutan", (String) urutan.getSelectedItem());
            params.put("p_summary_aktif", summaryAktif);
            params.put("p_summary_nonaktif", summaryNonAktif);
            params.put("p_summary_expired", summaryExpired);
            params.put("p_summary_total", summaryTotal);
            params.put("namaUser", session.getNamaLengkap());
            params.put("roleUser", session.getRole());

            InputStream is = getClass().getResourceAsStream("/report/laporanarsip/LaporanKategoriDokumen.jasper");

            if (is == null) {
                JOptionPane.showMessageDialog(this, 
                    "File report tidak ditemukan!\nPastikan file LaporanKategoriDokumen.jasper ada di folder /report/laporanarsip/", 
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

    private void txtAktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAktifActionPerformed

    }//GEN-LAST:event_txtAktifActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        try {
            Date tanggalMulai = tanggal_mulai.getDate();
            Date tanggalSampai = tanggal_sampai.getDate();
            String statusFilter = (String) status_dokumen.getSelectedItem();
            String orderBy = (String) urutan.getSelectedItem();

            if (tanggalMulai != null && tanggalSampai != null) {
                if (tanggalMulai.after(tanggalSampai)) {
                    JOptionPane.showMessageDialog(this, 
                        "Tanggal mulai tidak boleh lebih besar dari tanggal sampai!", 
                        "Validasi", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            List<RowKategoriDokumen> rows = dao.getDataKategori(
                tanggalMulai, 
                tanggalSampai, 
                statusFilter, 
                txtCari.getText().trim(),
                orderBy
            );

            fillTable(rows);

            SummaryKategori summary = dao.getSummaryKategori(
                tanggalMulai, 
                tanggalSampai, 
                statusFilter
            );

            updateSummary(summary);

            JOptionPane.showMessageDialog(this, 
                "Data dimuat! Total: " + rows.size() + " kategori", 
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
        status_dokumen.setSelectedIndex(0);
        urutan.setSelectedIndex(0);
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtAktif.setText("");
        txtNonAktif.setText("");
        txtExpired.setText("");
        txtTotalDokumen.setText("");

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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblakses;
    private javax.swing.JLabel lbledit;
    private javax.swing.JLabel lbltotalaktivitas;
    private javax.swing.JLabel lblupload;
    private javax.swing.JComboBox<String> status_dokumen;
    private javax.swing.JTable tabel_kategori_dokumen;
    private com.toedter.calendar.JDateChooser tanggal_mulai;
    private com.toedter.calendar.JDateChooser tanggal_sampai;
    private javax.swing.JTextField txtAktif;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtExpired;
    private javax.swing.JTextField txtNonAktif;
    private javax.swing.JTextField txtTotalDokumen;
    private javax.swing.JComboBox<String> urutan;
    // End of variables declaration//GEN-END:variables
}