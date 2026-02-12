package com.okesalon.view.master;
import com.okesalon.dao.ProdukDAO;
import com.okesalon.model.Produk;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

public class FormProduk extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    private ProdukDAO produkDAO;
    private Produk selectedProduk = null;
    private boolean isViewRiwayatMode = false;

    public FormProduk() {
        initComponents();
        produkDAO = new ProdukDAO();
        initTable();
        setupComboBoxes();
        setupStatusRenderer();
        loadDataToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnViewDetailProduk = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabel_produk = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnViewRiwayatTransaksi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        nama_produk = new javax.swing.JTextField();
        kategori = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        nama_supplier = new javax.swing.JTextField();
        telp_supplier = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        harga_beli = new javax.swing.JTextField();
        harga_jual = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        stok_saat_ini = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        satuan = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        stok_minimum = new javax.swing.JTextField();
        tanggal_expired = new com.toedter.calendar.JDateChooser();
        jLabel82 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        status = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 21)); // NOI18N
        jLabel3.setText("Master Data Produk");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(1298, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 153, 255));

        btnTambah.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnViewDetailProduk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewDetailProduk.setText("View Detail Produk");
        btnViewDetailProduk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewDetailProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailProdukActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabel_produk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_produk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_produkMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tabel_produk);

        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnViewRiwayatTransaksi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewRiwayatTransaksi.setText("View Riwayat Transaksi");
        btnViewRiwayatTransaksi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewRiwayatTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRiwayatTransaksiActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 220, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DETAIL DATA PRODUK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel72.setText("Nama Produk");

        nama_produk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        kategori.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hair Care", "Hair Coloring", "Nail Care", "Skin Care", "Make Up" }));
        kategori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel73.setText("Kategori Produk");

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel75.setText("Nama Supplier");

        nama_supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nama_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        telp_supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        telp_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel76.setText("Telepon Supplier");

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel77.setText("Harga beli");

        harga_beli.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        harga_jual.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        harga_jual.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        harga_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel78.setText("Harga Jual");

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel79.setText("Stok Saat Ini");

        stok_saat_ini.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel81.setText("Satuan");

        satuan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Botol", "Tube", "Sachet", "Box", "Pcs", "Pack", "Liter", "Ml" }));
        satuan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        satuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satuanActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel80.setText("Stok Minimum");

        stok_minimum.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stok_minimum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        tanggal_expired.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel82.setText("Tanggal Expired");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel74.setText("Jenis");

        jenis.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dijual", "Layanan", "Dijuall dan Layanan" }));
        jenis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        status.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Non-Aktif" }));
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel83.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel83.setText("Status");

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel84.setText("Deskripsi");

        deskripsi.setColumns(20);
        deskripsi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deskripsi.setRows(5);
        jScrollPane11.setViewportView(deskripsi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stok_saat_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(harga_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(telp_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(harga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel84)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel83)
                            .addComponent(jLabel80)
                            .addComponent(jLabel82)
                            .addComponent(jLabel74))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tanggal_expired, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stok_minimum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jenis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telp_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(harga_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(harga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok_saat_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel82))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(stok_minimum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tanggal_expired, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74)
                            .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnViewRiwayatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewDetailProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(338, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(586, 586, 586))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewDetailProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewRiwayatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(501, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void setupComboBoxes() {
        kategori.removeAllItems();
        kategori.addItem("Hair Care");
        kategori.addItem("Hair Coloring");
        kategori.addItem("Nail Care");
        kategori.addItem("Skin Care");
        
        jenis.removeAllItems();
        jenis.addItem("Dijual");
        jenis.addItem("Layanan");
        jenis.addItem("Dijual & Layanan");
        
        satuan.removeAllItems();
        satuan.addItem("Botol");
        satuan.addItem("Tube");
        satuan.addItem("Sachet");
        satuan.addItem("Box");
        satuan.addItem("Pcs");
        satuan.addItem("Pack");
        satuan.addItem("Liter");
        satuan.addItem("Ml");

        status.removeAllItems();
        status.addItem("Aktif");
        status.addItem("Non-Aktif");
    }
    
    private void initTable() {
        String[] kolom = {
            "Kode",
            "Nama Produk",
            "Kategori",
            "Jenis",
            "Harga Jual",
            "Stok",
            "Satuan",
            "Status"
        };
        
        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabel_produk.setModel(tableModel);
        tabel_produk.setRowHeight(25);
        tabel_produk.getTableHeader().setReorderingAllowed(false);
        tabel_produk.getColumnModel().getColumn(0).setPreferredWidth(80);   
        tabel_produk.getColumnModel().getColumn(1).setPreferredWidth(200);  
        tabel_produk.getColumnModel().getColumn(2).setPreferredWidth(100);  
        tabel_produk.getColumnModel().getColumn(3).setPreferredWidth(120);  
        tabel_produk.getColumnModel().getColumn(4).setPreferredWidth(100);  
        tabel_produk.getColumnModel().getColumn(5).setPreferredWidth(70);   
        tabel_produk.getColumnModel().getColumn(6).setPreferredWidth(70);   
        tabel_produk.getColumnModel().getColumn(7).setPreferredWidth(70);   
    }
    
    private void loadDataToTable() {
        tableModel.setRowCount(0);
        
        List<Produk> dataProduk = produkDAO.getAll();
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        
        for (Produk p : dataProduk) {
            Object[] row = {
                p.getKodeProduk(),
                p.getNamaProduk(),
                p.getKategoriProduk(),
                p.getJenis(),
                rupiah.format(p.getHargaJual()),
                p.getStokSaatIni(),
                p.getSatuan(),
                p.getStatus()
            };
            tableModel.addRow(row);
        }
    }
    
    private void setupStatusRenderer() {
        tabel_produk.getColumnModel().getColumn(7).setCellRenderer(
            new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {

                    Component cell = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                    String status = (String) value;

                    if (!isSelected) {
                        if ("Aktif".equals(status)) {
                            cell.setBackground(new Color(220, 255, 220));  
                            cell.setForeground(new Color(0, 128, 0));      
                        } else if ("Non-Aktif".equals(status)) {
                            cell.setBackground(new Color(255, 220, 220));  
                            cell.setForeground(new Color(200, 0, 0));
                        }
                    }

                    setHorizontalAlignment(SwingConstants.CENTER);
                    return cell;
                }
            }
        );
    }
    
    private Produk getProdukFromForm() throws Exception {
        String nama = nama_produk.getText().trim();
        if (nama.isEmpty()) {
            throw new Exception("Nama Produk tidak boleh kosong!");
        }
        
        String hargaBeliStr = harga_beli.getText().trim();
        if (hargaBeliStr.isEmpty()) {
            throw new Exception("Harga Beli tidak boleh kosong!");
        }
        double hargaBeli = 0;
        try {
            hargaBeli = Double.parseDouble(hargaBeliStr);
            if (hargaBeli < 0) {
                throw new Exception("Harga Beli tidak boleh negatif!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Format Harga Beli tidak valid!");
        }
        
        String hargaJualStr = harga_jual.getText().trim();
        if (hargaJualStr.isEmpty()) {
            throw new Exception("Harga Jual tidak boleh kosong!");
        }
        double hargaJual = 0;
        try {
            hargaJual = Double.parseDouble(hargaJualStr);
            if (hargaJual < 0) {
                throw new Exception("Harga Jual tidak boleh negatif!");
            }
            if (hargaJual < hargaBeli) {
                int konfirm = JOptionPane.showConfirmDialog(this,
                    "Harga Jual lebih rendah dari Harga Beli!\n" +
                    "Anda akan rugi. Tetap lanjutkan?",
                    "Peringatan",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                
                if (konfirm != JOptionPane.YES_OPTION) {
                    throw new Exception("Input dibatalkan.");
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("Format Harga Jual tidak valid!");
        }
        
        String stokStr = stok_saat_ini.getText().trim();
        if (stokStr.isEmpty()) {
            throw new Exception("Stok Saat Ini tidak boleh kosong!");
        }
        int stok = 0;
        try {
            stok = Integer.parseInt(stokStr);
            if (stok < 0) {
                throw new Exception("Stok tidak boleh negatif!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Format Stok tidak valid!");
        }
        
        String stokMinStr = stok_minimum.getText().trim();
        if (stokMinStr.isEmpty()) {
            throw new Exception("Stok Minimum tidak boleh kosong!");
        }
        int stokMin = 0;
        try {
            stokMin = Integer.parseInt(stokMinStr);
            if (stokMin < 0) {
                throw new Exception("Stok Minimum tidak boleh negatif!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Format Stok Minimum tidak valid!");
        }
        
        Produk produk = new Produk();
        produk.setNamaProduk(nama);
        produk.setKategoriProduk(kategori.getSelectedItem().toString());
        produk.setJenis(jenis.getSelectedItem().toString());
        produk.setNamaSupplier(nama_supplier.getText().trim());
        produk.setTeleponSupplier(telp_supplier.getText().trim());
        produk.setHargaBeli(hargaBeli);
        produk.setHargaJual(hargaJual);
        produk.setStokSaatIni(stok);
        produk.setStokMinimum(stokMin);
        produk.setSatuan(satuan.getSelectedItem().toString());
        produk.setTanggalExpired(tanggal_expired.getDate());
        produk.setStatus(status.getSelectedItem().toString());
        produk.setDeskripsi(deskripsi.getText().trim());
        
        return produk;
    }
    
    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }
    
    private void clearForm() {
        nama_produk.setText("");
        kategori.setSelectedIndex(0);
        jenis.setSelectedIndex(0);
        nama_supplier.setText("");
        telp_supplier.setText("");
        harga_beli.setText("");
        harga_jual.setText("");
        stok_saat_ini.setText("");
        stok_minimum.setText("");
        satuan.setSelectedIndex(0);
        tanggal_expired.setDate(null);
        status.setSelectedIndex(0);
        deskripsi.setText("");
        selectedProduk = null;
        tabel_produk.clearSelection();
        nama_produk.requestFocus();
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (selectedProduk == null) {
            JOptionPane.showMessageDialog(this,
                "Pilih data di tabel yang akan dihapus!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus produk:\n" +
            selectedProduk.getNamaProduk() + " (" + selectedProduk.getKodeProduk() + ")?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);
        
        if (konfirmasi == JOptionPane.YES_OPTION) {
            boolean success = produkDAO.delete(selectedProduk.getKodeProduk());
            
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this,
                    "Data produk berhasil dihapus!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menghapus data produk!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if (selectedProduk == null) {
            JOptionPane.showMessageDialog(this,
                "Pilih data di tabel yang akan diubah!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Produk updated = getProdukFromForm();
            updated.setKodeProduk(selectedProduk.getKodeProduk());
            
            boolean success = produkDAO.update(updated);
            
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this,
                    "Data produk berhasil diubah!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal mengubah data produk!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed

    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

    }//GEN-LAST:event_jTextField5ActionPerformed

    private void btnViewDetailProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailProdukActionPerformed
    isViewRiwayatMode = false;
    
    String[] kolomDetail = {
        "Kode",
        "Nama Produk",
        "Kategori",
        "Jenis",
        "Harga Beli",
        "Harga Jual",
        "Margin",
        "% Margin",
        "Stok",
        "Supplier"
    };
    
    tableModel = new DefaultTableModel(kolomDetail, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    tabel_produk.setModel(tableModel);
    tabel_produk.setRowHeight(25);
    tabel_produk.getColumnModel().getColumn(0).setPreferredWidth(80);   
    tabel_produk.getColumnModel().getColumn(1).setPreferredWidth(150);  
    tabel_produk.getColumnModel().getColumn(2).setPreferredWidth(90);   
    tabel_produk.getColumnModel().getColumn(3).setPreferredWidth(100); 
    tabel_produk.getColumnModel().getColumn(4).setPreferredWidth(100);  
    tabel_produk.getColumnModel().getColumn(5).setPreferredWidth(100); 
    tabel_produk.getColumnModel().getColumn(6).setPreferredWidth(100); 
    tabel_produk.getColumnModel().getColumn(7).setPreferredWidth(80);   
    tabel_produk.getColumnModel().getColumn(8).setPreferredWidth(60);   
    tabel_produk.getColumnModel().getColumn(9).setPreferredWidth(130);  
    
    List<Produk> dataProduk = produkDAO.getAll();
    NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    double totalMargin = 0;
    int totalStok = 0;
    
    for (Produk p : dataProduk) {
        double margin = p.getMargin();
        double persenMargin = p.getPersentaseMargin();
   
        totalMargin += margin;
        totalStok += p.getStokSaatIni();
        
        String persenStr = String.format("%.1f%%", persenMargin);
        
        Object[] row = {
            p.getKodeProduk(),
            p.getNamaProduk(),
            p.getKategoriProduk(),
            p.getJenis(),
            rupiah.format(p.getHargaBeli()),
            rupiah.format(p.getHargaJual()),
            rupiah.format(margin),
            persenStr,
            p.getStokSaatIni() + " " + p.getSatuan(),
            p.getNamaSupplier() != null ? p.getNamaSupplier() : "-"
        };
        tableModel.addRow(row);
    }
    
    Object[] rowTotal = {
        "",
        "",
        "",
        "TOTAL",
        "",
        "",
        rupiah.format(totalMargin),
        "",
        totalStok + " items",
        ""
    };
    tableModel.addRow(rowTotal);
    
    JOptionPane.showMessageDialog(this,
        "View Detail Produk berhasil ditampilkan!\n" +
        "Total Produk: " + dataProduk.size() + "\n" +
        "Total Stok: " + totalStok + " items\n" +
        "Total Potensi Margin: " + rupiah.format(totalMargin),
        "Info Detail Produk",
        JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnViewDetailProdukActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
   
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void satuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satuanActionPerformed

    }//GEN-LAST:event_satuanActionPerformed

    private void tabel_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_produkMouseClicked
    int row = tabel_produk.getSelectedRow();
    if (row == -1) return;
    
    String kode = tabel_produk.getValueAt(row, 0).toString();
    selectedProduk = produkDAO.getByKode(kode);
    
    if (selectedProduk != null) {
        nama_produk.setText(selectedProduk.getNamaProduk());
        kategori.setSelectedItem(selectedProduk.getKategoriProduk());
        jenis.setSelectedItem(selectedProduk.getJenis());
        nama_supplier.setText(selectedProduk.getNamaSupplier());
        telp_supplier.setText(selectedProduk.getTeleponSupplier());
        harga_beli.setText(String.valueOf((int) selectedProduk.getHargaBeli()));
        harga_jual.setText(String.valueOf((int) selectedProduk.getHargaJual()));
        stok_saat_ini.setText(String.valueOf(selectedProduk.getStokSaatIni()));
        stok_minimum.setText(String.valueOf(selectedProduk.getStokMinimum()));
        satuan.setSelectedItem(selectedProduk.getSatuan());
        tanggal_expired.setDate(selectedProduk.getTanggalExpired());
        status.setSelectedItem(selectedProduk.getStatus());
        deskripsi.setText(selectedProduk.getDeskripsi());
    }
    }//GEN-LAST:event_tabel_produkMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
     try {
            Produk produk = getProdukFromForm();
            String kode = produkDAO.generateKodeProduk();
            produk.setKodeProduk(kode);
            
            boolean success = produkDAO.insert(produk);
            
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this,
                    "Produk berhasil ditambahkan dengan kode: " + kode,
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                
                if (produk.isStokMenipis()) {
                    JOptionPane.showMessageDialog(this,
                        "PERHATIAN!\n\n" +
                        "Stok produk " + produk.getNamaProduk() + " sudah menipis!\n" +
                        "Stok saat ini: " + produk.getStokSaatIni() + " " + produk.getSatuan() + "\n" +
                        "Stok minimum: " + produk.getStokMinimum() + " " + produk.getSatuan(),
                        "Alert Stok",
                        JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan data produk!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
     String keyword = txtCari.getText().trim();
        
        if (keyword.isEmpty()) {
            if (isViewRiwayatMode) {
                btnViewRiwayatTransaksiActionPerformed(null);
            } else {
                loadDataToTable();
            }
            return;
        }
        
        tableModel.setRowCount(0);
        List<Produk> results = produkDAO.search(keyword);
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        
        for (Produk p : results) {
            Object[] row = {
                p.getKodeProduk(),
                p.getNamaProduk(),
                p.getKategoriProduk(),
                p.getJenis(),
                rupiah.format(p.getHargaJual()),
                p.getStokSaatIni(),
                p.getSatuan(),
                p.getStatus()
            };
            tableModel.addRow(row);
        }
        
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Tidak ada data yang cocok dengan keyword: " + keyword,
                "Info Pencarian",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnViewRiwayatTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRiwayatTransaksiActionPerformed
    isViewRiwayatMode = true;
    
    String[] kolomRiwayat = {
        "Kode Produk",
        "Nama Produk",
        "Kategori",
        "Total Terjual",
        "Satuan",
        "Harga Jual",
        "Total Pendapatan"
    };
    
    tableModel = new DefaultTableModel(kolomRiwayat, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    tabel_produk.setModel(tableModel);
    tabel_produk.setRowHeight(25);
    tabel_produk.getColumnModel().getColumn(0).setPreferredWidth(90);   
    tabel_produk.getColumnModel().getColumn(1).setPreferredWidth(180);  
    tabel_produk.getColumnModel().getColumn(2).setPreferredWidth(100); 
    tabel_produk.getColumnModel().getColumn(3).setPreferredWidth(90);   
    tabel_produk.getColumnModel().getColumn(4).setPreferredWidth(70);   
    tabel_produk.getColumnModel().getColumn(5).setPreferredWidth(110);  
    tabel_produk.getColumnModel().getColumn(6).setPreferredWidth(130);  
    
    List<Object[]> riwayat = produkDAO.getRiwayatTransaksi();
    
    NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    if (riwayat.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Belum ada riwayat transaksi produk.",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
        
        Object[] rowKosong = {
            "-", "-", "-", "0", "-", "-", "Rp 0"
        };
        tableModel.addRow(rowKosong);
    } else {
        double totalPendapatan = 0;
        
        for (Object[] row : riwayat) {
            String kode = (String) row[0];
            String nama = (String) row[1];
            String kategori = (String) row[2];
            int totalTerjual = (int) row[3];
            String satuan = (String) row[4];
            double hargaJual = (double) row[5];
            double pendapatan = totalTerjual * hargaJual;
            
            totalPendapatan += pendapatan;
            
            Object[] rowData = {
                kode,
                nama,
                kategori,
                totalTerjual,
                satuan,
                rupiah.format(hargaJual),
                rupiah.format(pendapatan)
            };
            tableModel.addRow(rowData);
        }
        
        Object[] rowTotal = {
            "",
            "",
            "TOTAL PENDAPATAN",
            "",
            "",
            "",
            rupiah.format(totalPendapatan)
        };
        tableModel.addRow(rowTotal);
        
        JOptionPane.showMessageDialog(this,
            "View Riwayat Transaksi berhasil ditampilkan!\n" +
            "Total Pendapatan: " + rupiah.format(totalPendapatan),
            "Info Riwayat Transaksi",
            JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnViewRiwayatTransaksiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnViewDetailProduk;
    private javax.swing.JButton btnViewRiwayatTransaksi;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JTextField harga_beli;
    private javax.swing.JTextField harga_jual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTextField nama_produk;
    private javax.swing.JTextField nama_supplier;
    private javax.swing.JComboBox<String> satuan;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField stok_minimum;
    private javax.swing.JTextField stok_saat_ini;
    private javax.swing.JTable tabel_produk;
    private com.toedter.calendar.JDateChooser tanggal_expired;
    private javax.swing.JTextField telp_supplier;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}