package com.okesalon.view.laporan.laporanstok;
import com.okesalon.util.koneksi;
import com.okesalon.dao.LaporanPembelianProdukDAO;
import com.okesalon.dao.LaporanPembelianProdukDAO.RowPembelian;
import com.okesalon.dao.LaporanPembelianProdukDAO.SummaryPembelian;
import com.okesalon.util.SessionManager;
import java.text.DecimalFormat;
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

public class LaporanPembelianProduk extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private LaporanPembelianProdukDAO dao;
    private DecimalFormat formatRupiah = new DecimalFormat("#,##0");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LaporanPembelianProduk() {
        initComponents();
        dao = new LaporanPembelianProdukDAO();
        initTable();
        loadSupplier();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pembelian = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tgl_mulai = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        tgl_sampai = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        supplier = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotalTransaksi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTotalItem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTotalPembelian = new javax.swing.JTextField();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        tabel_pembelian.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_pembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Supplier", "Produk", "Jumlah Beli", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_pembelian);

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pembelian Dari Supplier");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Mulai Tanggal");

        tgl_mulai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Sampai Tanggal");

        tgl_sampai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Supplier ");

        supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        supplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "CV Cantik Jaya", "PT Kosmetik Nusantara", "PT Beauty Indonesia" }));
        supplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel14)
                        .addGap(29, 29, 29)
                        .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tgl_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tgl_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
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
        jLabel13.setText("Total Transaksi     :");

        txtTotalTransaksi.setEditable(false);
        txtTotalTransaksi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Total Item             :");

        txtTotalItem.setEditable(false);
        txtTotalItem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Total Pembelian    :");

        txtTotalPembelian.setEditable(false);
        txtTotalPembelian.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalPembelian.setText("Rp");
        txtTotalPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPembelianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalItem, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(txtTotalTransaksi)
                    .addComponent(txtTotalPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTotalPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        String[] columns = {"Tanggal", "Supplier", "Produk", "Jumlah Beli", "Total Harga"};
        modelTabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_pembelian.setModel(modelTabel);
        tabel_pembelian.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabel_pembelian.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabel_pembelian.getColumnModel().getColumn(2).setPreferredWidth(400);
        tabel_pembelian.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabel_pembelian.getColumnModel().getColumn(4).setPreferredWidth(200);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_pembelian.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabel_pembelian.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tabel_pembelian.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    }
    
    private void loadSupplier() {
        try {
            List<String> list = dao.getSupplier();
            supplier.removeAllItems();
            for (String s : list) {
                supplier.addItem(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error load supplier: " + e.getMessage());
        }
    }
       
    private void fillTable(List<RowPembelian> rows) {
        modelTabel.setRowCount(0);
        for (RowPembelian row : rows) {
            modelTabel.addRow(new Object[]{
                dateFormat.format(row.tanggalTransaksi),
                row.namaSupplier,
                row.namaProduk,
                row.jumlahBeli,
                "Rp " + formatRupiah.format(row.totalHarga)
            });
        }
    }
    
    private void updateSummary(SummaryPembelian summary) {
        txtTotalTransaksi.setText(String.valueOf(summary.totalTransaksi));
        txtTotalItem.setText(String.valueOf(summary.totalItem));
        txtTotalPembelian.setText("Rp " + formatRupiah.format(summary.totalPembelian));
    }
    
    private void supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierActionPerformed

    }//GEN-LAST:event_supplierActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            if (modelTabel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, 
                    "Klik FILTER dulu untuk memuat data!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Tanggal mulai dan sampai wajib diisi!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            SessionManager session = SessionManager.getInstance();
            Map<String, Object> params = new HashMap<>();
            params.put("p_tanggal_mulai", new java.sql.Date(tgl_mulai.getDate().getTime()));
            params.put("p_tanggal_sampai", new java.sql.Date(tgl_sampai.getDate().getTime()));
            params.put("p_supplier", (String) supplier.getSelectedItem());
            params.put("namaUser", session.getNamaLengkap());
            params.put("roleUser", session.getRole());
            InputStream is = getClass().getResourceAsStream("/report/laporanstok/LaporanPembelianProduk.jasper");

            if (is == null) {
                JOptionPane.showMessageDialog(this, 
                    "File report tidak ditemukan!\nPastikan file LaporanPembelianProduk.jasper ada di folder /report/laporanstok/", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection conn = koneksi.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(is, params, conn);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error cetak laporan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        try {
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Harap pilih tanggal mulai dan sampai!", "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (tgl_mulai.getDate().after(tgl_sampai.getDate())) {
                JOptionPane.showMessageDialog(this, "Tanggal mulai tidak boleh lebih besar dari tanggal sampai!", "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Date tanggalMulai = tgl_mulai.getDate();
            Date tanggalSampai = tgl_sampai.getDate();
            String Supplier = (String) supplier.getSelectedItem();
            
            List<RowPembelian> rows = dao.getData(tanggalMulai, tanggalSampai, Supplier, txtCari.getText().trim());
            fillTable(rows);
            
            SummaryPembelian summary = dao.getSummary(tanggalMulai, tanggalSampai, Supplier);
            updateSummary(summary);
            
            JOptionPane.showMessageDialog(this, "Data dimuat! Total: " + rows.size() + " transaksi");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        supplier.setSelectedIndex(0);
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtTotalTransaksi.setText("");
        txtTotalItem.setText("");
        txtTotalPembelian.setText("");
        
        JOptionPane.showMessageDialog(this, "Form di-reset!");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
     try {
            if (tgl_mulai.getDate() == null || tgl_sampai.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Harap pilih tanggal terlebih dahulu!", "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Date tanggalMulai = tgl_mulai.getDate();
            Date tanggalSampai = tgl_sampai.getDate();
            String Supplier = (String) supplier.getSelectedItem();
            String keyword = txtCari.getText().trim();
            
            if (keyword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Masukkan keyword pencarian!", "Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            List<RowPembelian> rows = dao.getData(tanggalMulai, tanggalSampai, Supplier, keyword);
            fillTable(rows);
            SummaryPembelian summary = dao.getSummary(tanggalMulai, tanggalSampai, Supplier);
            updateSummary(summary);
            
            if (rows.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtTotalPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPembelianActionPerformed

    }//GEN-LAST:event_txtTotalPembelianActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> supplier;
    private javax.swing.JTable tabel_pembelian;
    private com.toedter.calendar.JDateChooser tgl_mulai;
    private com.toedter.calendar.JDateChooser tgl_sampai;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtTotalItem;
    private javax.swing.JTextField txtTotalPembelian;
    private javax.swing.JTextField txtTotalTransaksi;
    // End of variables declaration//GEN-END:variables
}