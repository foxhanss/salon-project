package com.okesalon.view.laporan.laporankeuangan;
import com.okesalon.util.koneksi;
import com.okesalon.dao.LaporanLabaRugiDAO;
import com.okesalon.util.SessionManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;

public class LaporanLabaRugi extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private LaporanLabaRugiDAO dao;
    private DecimalFormat formatRupiah = new DecimalFormat("#,##0");
    private SimpleDateFormat formatTanggal = new SimpleDateFormat("dd/MM/yyyy");

    public LaporanLabaRugi() {
        initComponents();
        dao = new LaporanLabaRugiDAO();
        initTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_laba_rugi = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tgl_mulai = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        tgl_sampai = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jenis_laporan = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblTotalMasuk = new javax.swing.JLabel();
        lblTotalKeluar = new javax.swing.JLabel();
        lblSaldoKas = new javax.swing.JLabel();
        txtTotalLaba = new javax.swing.JTextField();
        txtTotalRugi = new javax.swing.JTextField();
        txtLabaBersih = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1444, 850));

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 153, 255));

        tabel_laba_rugi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_laba_rugi);

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

        jPanel5.setBackground(new java.awt.Color(255, 220, 255));

        jPanel7.setBackground(new java.awt.Color(255, 102, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LABA/RUGI");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel31.setText("Mulai Tanggal");

        tgl_mulai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel32.setText("Sampai Tanggal ");

        tgl_sampai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setText("Jenis Laporan");

        jenis_laporan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jenis_laporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Laba", "Rugi" }));
        jenis_laporan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(26, 26, 26)
                .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel32)
                .addGap(50, 50, 50)
                .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jenis_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel32)))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenis_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel35))
                .addGap(35, 35, 35))
        );

        btnCari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
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

        lblTotalMasuk.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTotalMasuk.setText("Total Laba            : ");

        lblTotalKeluar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTotalKeluar.setText("Total Rugi             : ");

        lblSaldoKas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblSaldoKas.setText("Laba Bersih           : ");

        txtTotalLaba.setEditable(false);
        txtTotalLaba.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalLaba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalLabaActionPerformed(evt);
            }
        });

        txtTotalRugi.setEditable(false);
        txtTotalRugi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtLabaBersih.setEditable(false);
        txtLabaBersih.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblTotalMasuk)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalKeluar)
                            .addComponent(lblSaldoKas))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLabaBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalRugi, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalMasuk)
                    .addComponent(txtTotalLaba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalKeluar)
                    .addComponent(txtTotalRugi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoKas)
                    .addComponent(txtLabaBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(594, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1454, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1351, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        modelTabel = new DefaultTableModel(
            new Object[]{"Tanggal", "Jenis", "Kategori", "Kode", "Deskripsi", "Total"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_laba_rugi.setModel(modelTabel);
        tabel_laba_rugi.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabel_laba_rugi.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabel_laba_rugi.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabel_laba_rugi.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel_laba_rugi.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabel_laba_rugi.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
    
    private void fillTable(List<LaporanLabaRugiDAO.RowLabaRugi> rows) {
        modelTabel.setRowCount(0);
  
        BigDecimal totalLaba = BigDecimal.ZERO;
        BigDecimal totalRugi = BigDecimal.ZERO;
        
        for (LaporanLabaRugiDAO.RowLabaRugi row : rows) {
            modelTabel.addRow(new Object[]{
                formatTanggal.format(row.tanggal),
                row.jenisLR,
                row.kategori,
                row.kode,
                row.deskripsi,
                formatRupiah.format(row.total)
            });
            
            if ("Laba".equalsIgnoreCase(row.jenisLR)) {
                totalLaba = totalLaba.add(row.total);
            } else if ("Rugi".equalsIgnoreCase(row.jenisLR)) {
                totalRugi = totalRugi.add(row.total);
            }
        }

        BigDecimal labaBersih = totalLaba.subtract(totalRugi);

        updateSummary(totalLaba, totalRugi, labaBersih);
    }
    
    private void updateSummary(BigDecimal totalLaba, BigDecimal totalRugi, BigDecimal labaBersih) {
        txtTotalLaba.setText("Rp " + formatRupiah.format(totalLaba));
        txtTotalRugi.setText("Rp " + formatRupiah.format(totalRugi));
        txtLabaBersih.setText("Rp " + formatRupiah.format(labaBersih));
    }
    
    
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
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
            
            if (mulai.after(sampai)) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai tidak boleh lebih besar dari tanggal sampai!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String jenisLaporan = jenis_laporan.getSelectedItem().toString();
            
            List<LaporanLabaRugiDAO.RowLabaRugi> rows = 
                dao.getData(mulai, sampai, jenisLaporan, "");
            
            fillTable(rows);
            
            JOptionPane.showMessageDialog(this, 
                "Data berhasil difilter!\nTotal: " + rows.size() + " transaksi", 
                "Filter Berhasil", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

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

            String jenisLaporan = jenis_laporan.getSelectedItem().toString();

            SessionManager session = SessionManager.getInstance();

            Map<String, Object> params = new HashMap<>();
            params.put("p_tgl_mulai", mulai);
            params.put("p_tgl_sampai", sampai);
            params.put("p_jenis_lr", jenisLaporan);
            params.put("namaUser", session.getNamaLengkap());
            params.put("roleUser", session.getRole());

            InputStream is = getClass().getResourceAsStream(
                "/report/laporankeuangan/LaporanLabaRugi.jasper");
            
            if (is == null) {
                JOptionPane.showMessageDialog(this, 
                    "File report tidak ditemukan!\n" +
                    "Path: /report/laporankeuangan/LaporanLabaRugi.jasper", 
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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tgl_mulai.setDate(null);
        tgl_sampai.setDate(null);
        if (jenis_laporan != null) {
            jenis_laporan.setSelectedIndex(0);
        }
        
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtTotalLaba.setText("");
        txtTotalRugi.setText("");
        txtLabaBersih.setText("");
        
        JOptionPane.showMessageDialog(this, 
            "Form berhasil direset!", 
            "Clear", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    try {
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Isi tanggal filter terlebih dahulu!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Date mulai = new Date(tgl_mulai.getDate().getTime());
            Date sampai = new Date(tgl_sampai.getDate().getTime());
            
            String jenisLaporan = jenis_laporan.getSelectedItem().toString();
            
            String keyword = txtCari.getText().trim();
            
            List<LaporanLabaRugiDAO.RowLabaRugi> rows = 
                dao.getData(mulai, sampai, jenisLaporan, keyword);
            
            fillTable(rows);
            
            JOptionPane.showMessageDialog(this, 
                "Pencarian berhasil!\nDitemukan: " + rows.size() + " transaksi", 
                "Cari Data", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Gagal mencari data: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtTotalLabaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalLabaActionPerformed

    }//GEN-LAST:event_txtTotalLabaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis_laporan;
    private javax.swing.JLabel lblSaldoKas;
    private javax.swing.JLabel lblTotalKeluar;
    private javax.swing.JLabel lblTotalMasuk;
    private javax.swing.JTable tabel_laba_rugi;
    private com.toedter.calendar.JDateChooser tgl_mulai;
    private com.toedter.calendar.JDateChooser tgl_sampai;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtLabaBersih;
    private javax.swing.JTextField txtTotalLaba;
    private javax.swing.JTextField txtTotalRugi;
    // End of variables declaration//GEN-END:variables
}