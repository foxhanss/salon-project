package com.okesalon.view.laporan.laporanstok;
import com.okesalon.util.koneksi;
import com.okesalon.dao.LaporanProdukAlertDAO;
import com.okesalon.dao.LaporanProdukAlertDAO.RowProdukAlert;
import com.okesalon.util.SessionManager;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;
import java.sql.Connection;

public class LaporanProdukAlert extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private LaporanProdukAlertDAO dao;

    public LaporanProdukAlert() {
        initComponents();
        dao = new LaporanProdukAlertDAO();
        setupRadioButtonColors();
        renameComponents();
        initTable();
        loadKategori();
        loadSupplier();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlert = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_alert = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kategori = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        rKritis = new javax.swing.JRadioButton();
        rWarning = new javax.swing.JRadioButton();
        rAman = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        supplier = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        urut = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtKritis = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtWarning = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtAman = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTotalProduk = new javax.swing.JTextField();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        tabel_alert.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_alert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Stok", "Stok Minimal", "Status", "Restock", "Supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_alert);

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 204));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Produk Hampir Habis/Alert");

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
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Kategori :");

        kategori.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Kategori", "Hair Care", "Hair Coloring", "Nail Care", "Skin Care" }));
        kategori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Alert Level :");

        rKritis.setBackground(new java.awt.Color(255, 0, 0));
        btnAlert.add(rKritis);
        rKritis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rKritis.setText("Kritis");

        rWarning.setBackground(new java.awt.Color(255, 255, 51));
        btnAlert.add(rWarning);
        rWarning.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rWarning.setText("Warning");

        rAman.setBackground(new java.awt.Color(153, 255, 153));
        btnAlert.add(rAman);
        rAman.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rAman.setText("Aman");
        rAman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAmanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Supplier :");

        supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        supplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Supplier" }));
        supplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Urut Berdasar :");

        urut.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        urut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kritis → Aman", "Nama", "Stok" }));
        urut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rKritis)
                        .addGap(18, 18, 18)
                        .addComponent(rWarning)
                        .addGap(18, 18, 18)
                        .addComponent(rAman))
                    .addComponent(urut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rKritis, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rAman, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(urut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
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
        jLabel13.setText("Habis/Kritis        :");

        txtKritis.setEditable(false);
        txtKritis.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtKritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKritisActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Warning             :");

        txtWarning.setEditable(false);
        txtWarning.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Aman                 :");

        txtAman.setEditable(false);
        txtAman.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmanActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("Total Produk      :");

        txtTotalProduk.setEditable(false);
        txtTotalProduk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalProdukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(txtKritis)
                    .addComponent(txtAman, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(txtTotalProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtKritis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtAman, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTotalProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(551, 551, 551)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void setupRadioButtonColors() {
        rKritis.setOpaque(true);
        rKritis.setBackground(new Color(255, 0, 0));
        rKritis.setForeground(Color.WHITE);
        rKritis.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        rWarning.setOpaque(true);
        rWarning.setBackground(new Color(255, 255, 51));
        rWarning.setForeground(Color.BLACK);
        rWarning.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        rAman.setOpaque(true);
        rAman.setBackground(new Color(153, 255, 153));
        rAman.setForeground(Color.BLACK);
        rAman.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    }
    
    private void renameComponents() {}
    
    private void initTable() {
        String[] columns = {"Nama Produk", "Stok", "Stok Minimal", "Status", "Perlu Restock", "Supplier"};
        modelTabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_alert.setModel(modelTabel);
        tabel_alert.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabel_alert.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabel_alert.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabel_alert.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel_alert.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabel_alert.getColumnModel().getColumn(5).setPreferredWidth(200);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_alert.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabel_alert.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabel_alert.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabel_alert.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }
    
    private void loadKategori() {
        try {
            List<String> list = dao.getKategori();
            kategori.removeAllItems();
            for (String k : list) {
                kategori.addItem(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error load kategori: " + e.getMessage());
        }
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
    
    private void fillTable(List<RowProdukAlert> rows) {
        modelTabel.setRowCount(0);
        for (RowProdukAlert row : rows) {
            modelTabel.addRow(new Object[]{
                row.namaProduk,
                row.stokSaatIni,
                row.stokMinimal,
                row.status,
                row.jumlahRestock > 0 ? row.jumlahRestock + " pcs" : "-",
                row.namaSupplier
            });
        }
    }
    
    private String getSelectedAlertLevel() {
        if (rKritis.isSelected()) {
            return "Kritis";
        } else if (rWarning.isSelected()) {
            return "Warning";
        } else if (rAman.isSelected()) {
            return "Aman";
        }
        return null;
    }
    
    private void updateSummary(List<RowProdukAlert> rows) {
        int totalProduk = rows.size();
        int countKritis = 0;
        int countWarning = 0;
        int countAman = 0;

        for (RowProdukAlert row : rows) {
            if (row.status.equals("Habis") || row.status.equals("Kritis")) {
                countKritis++;
            } else if (row.status.equals("Warning")) {
                countWarning++;
            } else if (row.status.equals("Aman")) {
                countAman++;
            }
        }

        DecimalFormat df = new DecimalFormat("0.0");
        String persenKritis = totalProduk > 0 ? df.format((countKritis * 100.0) / totalProduk) : "0.0";
        String persenWarning = totalProduk > 0 ? df.format((countWarning * 100.0) / totalProduk) : "0.0";
        String persenAman = totalProduk > 0 ? df.format((countAman * 100.0) / totalProduk) : "0.0";

        txtTotalProduk.setText(totalProduk + " produk");
        txtKritis.setText(countKritis + " produk (" + persenKritis + "%)");
        txtWarning.setText(countWarning + " produk (" + persenWarning + "%)");
        txtAman.setText(countAman + " produk (" + persenAman + "%)");
        if (countKritis > 0) {
            txtKritis.setForeground(new Color(204, 0, 0));
            txtKritis.setFont(new Font("Times New Roman", Font.BOLD, 18));
        } else {
            txtKritis.setForeground(Color.GRAY);
            txtKritis.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        }

        if (countWarning > 0) {
            txtWarning.setForeground(new Color(204, 153, 0));
            txtWarning.setFont(new Font("Times New Roman", Font.BOLD, 18));
        } else {
            txtWarning.setForeground(Color.GRAY);
            txtWarning.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        }

        if (countAman > 0) {
            txtAman.setForeground(new Color(0, 153, 0));
            txtAman.setFont(new Font("Times New Roman", Font.BOLD, 18));
        } else {
            txtAman.setForeground(Color.GRAY);
            txtAman.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        }
    }
    
    private void clearSummary() {
        txtTotalProduk.setText("");
        txtKritis.setText("");
        txtWarning.setText("");
        txtAman.setText("");
        txtKritis.setForeground(Color.BLACK);
        txtWarning.setForeground(Color.BLACK);
        txtAman.setForeground(Color.BLACK);
        txtKritis.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtWarning.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtAman.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    }

    private void rAmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAmanActionPerformed

    }//GEN-LAST:event_rAmanActionPerformed

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
            String summaryKritis = txtKritis.getText().replace(" produk", "").trim();
            String summaryWarning = txtWarning.getText().replace(" produk", "").trim();
            String summaryAman = txtAman.getText().replace(" produk", "").trim();
            String summaryTotal = txtTotalProduk.getText().replace(" produk", "").trim();

            Map<String, Object> params = new HashMap<>();
            params.put("p_kategori", (String) kategori.getSelectedItem());
            params.put("p_alert_level", getSelectedAlertLevel() != null ? getSelectedAlertLevel() : "Semua");
            params.put("p_supplier", (String) supplier.getSelectedItem());
            params.put("p_urut", (String) urut.getSelectedItem());
            params.put("p_summary_kritis", summaryKritis);
            params.put("p_summary_warning", summaryWarning);
            params.put("p_summary_aman", summaryAman);
            params.put("p_summary_total", summaryTotal);
            params.put("namaUser", session.getNamaLengkap());
            params.put("roleUser", session.getRole());

            InputStream is = getClass().getResourceAsStream("/report/laporanstok/LaporanProdukAlert.jasper");

            if (is == null) {
                JOptionPane.showMessageDialog(this, 
                    "File report tidak ditemukan!\nPastikan file LaporanProdukAlert.jasper ada di folder /report/laporanstok/", 
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
                "Error saat mencetak laporan:\n" + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        try {
            String Kategori = (String) kategori.getSelectedItem();
            String alertLevel = getSelectedAlertLevel();
            String Supplier = (String) supplier.getSelectedItem();
            String urutBerdasar = (String) urut.getSelectedItem();
            String keyword = txtCari.getText().trim();

            List<RowProdukAlert> rows = dao.getData(Kategori, alertLevel, Supplier, urutBerdasar, keyword);
            fillTable(rows);
            updateSummary(rows);      
            JOptionPane.showMessageDialog(this, 
                "Data dimuat!\n" +
                "Total: " + rows.size() + " produk", 
                "Info", 
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
        kategori.setSelectedIndex(0);
        supplier.setSelectedIndex(0);
        urut.setSelectedIndex(0);
        btnAlert.clearSelection();
        txtCari.setText("");
        modelTabel.setRowCount(0);
        clearSummary();
        JOptionPane.showMessageDialog(this, 
            "Form berhasil di-reset!", 
            "Info", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        try {
            String keyword = txtCari.getText().trim();

            if (keyword.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Masukkan keyword pencarian!", 
                    "Validasi", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String Kategori = (String) kategori.getSelectedItem();
            String alertLevel = getSelectedAlertLevel();
            String Supplier = (String) supplier.getSelectedItem();
            String urutBerdasar = (String) urut.getSelectedItem();

            List<RowProdukAlert> rows = dao.getData(Kategori, alertLevel, Supplier, urutBerdasar, keyword);
            fillTable(rows);
            updateSummary(rows);

            if (rows.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Data tidak ditemukan dengan keyword: " + keyword, 
                    "Info", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Ditemukan " + rows.size() + " produk", 
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

    private void txtAmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmanActionPerformed

    }//GEN-LAST:event_txtAmanActionPerformed

    private void txtKritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKritisActionPerformed

    }//GEN-LAST:event_txtKritisActionPerformed

    private void txtTotalProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalProdukActionPerformed

    }//GEN-LAST:event_txtTotalProdukActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnAlert;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JRadioButton rAman;
    private javax.swing.JRadioButton rKritis;
    private javax.swing.JRadioButton rWarning;
    private javax.swing.JComboBox<String> supplier;
    private javax.swing.JTable tabel_alert;
    private javax.swing.JTextField txtAman;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtKritis;
    private javax.swing.JTextField txtTotalProduk;
    private javax.swing.JTextField txtWarning;
    private javax.swing.JComboBox<String> urut;
    // End of variables declaration//GEN-END:variables
}