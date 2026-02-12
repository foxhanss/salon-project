package com.okesalon.view.transaksi;
import com.okesalon.dao.TransaksiPembelianProdukDAO;
import com.okesalon.dao.ProdukDAO;
import com.okesalon.model.TransaksiPembelianProduk;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class FormTransaksiPembelianProduk extends javax.swing.JPanel {
    private TransaksiPembelianProdukDAO transaksiPembelianProdukDAO;
    private ProdukDAO produkDAO;
    private DefaultTableModel tableModel;
    private TransaksiPembelianProduk selectedTransaksi = null;

    public FormTransaksiPembelianProduk() {
        initComponents();
        transaksiPembelianProdukDAO = new TransaksiPembelianProdukDAO();
        produkDAO = new ProdukDAO();
        initTable();
        setupComboBoxes();
        loadProdukToComboBox();
        loadSupplierToComboBox();
        loadDataToTable();
        setupComboBoxKeyReleased();
        setupAutoCalculation();
        setupAutoFillKodeProduk();
        tanggal.setDate(new Date());       
        System.out.println("FormTransaksiPembelianProduk initialized!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnViewSupplier = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabel_pembelian = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        nama_produk = new javax.swing.JComboBox<>();
        kode_produk = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        stok_sebelum = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jumlah_display = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        stok_sesudah = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        total_harga = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        telepon_supplier = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        metode_pembayaran = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        nama_supplier = new javax.swing.JComboBox<>();
        btnViewDetailPembelian = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 21)); // NOI18N
        jLabel3.setText("Transaksi Pembelian Produk");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(1208, Short.MAX_VALUE))
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

        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        btnViewSupplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewSupplier.setText("View Supplier");
        btnViewSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tabel_pembelian.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_pembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaksi", "Tanggal", "Kode Produk", "Nama Produk", "Supplier", "Jumlah", "Total Harga", "Actions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel_pembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pembelianMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabel_pembelian);

        btnHapus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 220, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFO PRODUK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setText("Tanggal Transaksi");

        tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("Nama Produk");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setText("Jumlah Beli");

        jumlah.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahjTextField7ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setText("Harga Satuan");

        harga.setEditable(false);
        harga.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        nama_produk.setEditable(true);
        nama_produk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nama_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_produkActionPerformed(evt);
            }
        });
        nama_produk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nama_produkKeyReleased(evt);
            }
        });

        kode_produk.setEditable(false);
        kode_produk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kode_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_produkjTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel28)
                    .addComponent(jLabel26)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kode_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jumlah)
                    .addComponent(harga))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kode_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 220, 255));

        jPanel7.setBackground(new java.awt.Color(255, 102, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DETAIL & SUMMARY");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setText("Stok Sebelum");

        stok_sebelum.setEditable(false);
        stok_sebelum.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stok_sebelum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setText("Jumlah Beli");

        jumlah_display.setEditable(false);
        jumlah_display.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jumlah_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setText("Stok Sesudah");

        stok_sesudah.setEditable(false);
        stok_sesudah.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stok_sesudah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setText("Total Harga");

        total_harga.setEditable(false);
        total_harga.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        total_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(123, 123, 123)
                        .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel31)
                            .addComponent(jLabel35))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jumlah_display, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stok_sesudah, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stok_sebelum, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok_sebelum, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlah_display, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok_sesudah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTambah.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTambah.setText("TAMBAH ");
        btnTambah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
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

        jPanel8.setBackground(new java.awt.Color(255, 220, 255));

        jPanel9.setBackground(new java.awt.Color(255, 102, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INFO SUPPLIER");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setText("Nama Supplier");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setText("Telepon Supplier");

        telepon_supplier.setEditable(false);
        telepon_supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        telepon_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setText("Metode Pembayaran");

        metode_pembayaran.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        metode_pembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Qris", "Transfer Bank" }));
        metode_pembayaran.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        metode_pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setText("Keterangan");

        keterangan.setColumns(20);
        keterangan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        keterangan.setRows(5);
        jScrollPane6.setViewportView(keterangan);

        nama_supplier.setEditable(true);
        nama_supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel34)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telepon_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(metode_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama_supplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(nama_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(telepon_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metode_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        btnViewDetailPembelian.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnViewDetailPembelian.setText("View Detail Pembelian");
        btnViewDetailPembelian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewDetailPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailPembelianjButton5ActionPerformed(evt);
            }
        });

        btnClear1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClear1.setText("Cari");
        btnClear1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(355, 355, 355)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnViewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnViewDetailPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewDetailPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        String[] columns = {
            "No Transaksi", 
            "Tanggal", 
            "Kode Produk", 
            "Nama Produk",
            "Supplier", 
            "Jumlah", 
            "Metode Pembayaran", 
            "Total Harga"
        };
        
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabel_pembelian.setModel(tableModel);
        tabel_pembelian.setRowHeight(30);
        tabel_pembelian.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabel_pembelian.getColumnModel().getColumn(0).setPreferredWidth(150); 
        tabel_pembelian.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tabel_pembelian.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tabel_pembelian.getColumnModel().getColumn(3).setPreferredWidth(250); 
        tabel_pembelian.getColumnModel().getColumn(4).setPreferredWidth(200); 
        tabel_pembelian.getColumnModel().getColumn(5).setPreferredWidth(100); 
        tabel_pembelian.getColumnModel().getColumn(6).setPreferredWidth(150); 
        tabel_pembelian.getColumnModel().getColumn(7).setPreferredWidth(150); 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_pembelian.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tabel_pembelian.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        
        System.out.println("Table initialized (7 columns)");
    }
    
    private void setupComboBoxes() {
        metode_pembayaran.removeAllItems();
        metode_pembayaran.addItem("Cash");
        metode_pembayaran.addItem("Transfer Bank");
        metode_pembayaran.addItem("Kredit");
        
        System.out.println("ComboBoxes setup!");
    }
    
    private void loadProdukToComboBox() {
        nama_produk.removeAllItems();
        nama_produk.addItem("-- Pilih Produk --");
        
        List<String> namaProdukList = transaksiPembelianProdukDAO.getNamaProdukList();
        
        for (String nama : namaProdukList) {
            nama_produk.addItem(nama);
        }
        
        System.out.println("Loaded " + namaProdukList.size() + " produk");
    }
    
    private void loadSupplierToComboBox() {
        nama_supplier.removeAllItems();
        nama_supplier.addItem("-- Pilih Supplier --");
        
        List<String> supplierList = transaksiPembelianProdukDAO.getUniqueSupplierList();
        
        for (String supplier : supplierList) {
            nama_supplier.addItem(supplier);
        }
        
        System.out.println("Loaded " + supplierList.size() + " suppliers");
    }
    
    private void setupComboBoxKeyReleased() {
        nama_produk.setEditable(true);
        nama_supplier.setEditable(true);

        JTextField produkEditor = (JTextField) nama_produk.getEditor().getEditorComponent();
        JTextField supplierEditor = (JTextField) nama_supplier.getEditor().getEditorComponent();
        produkEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = produkEditor.getText().trim();

                if (!text.isEmpty() && !text.startsWith("--")) {
                    filterProdukComboBox(text);
                } else if (text.isEmpty()) {
                    loadProdukToComboBox();
                }
            }
        });

        supplierEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = supplierEditor.getText().trim();

                if (!text.isEmpty() && !text.startsWith("--")) {
                    filterSupplierComboBox(text);
                } else if (text.isEmpty()) {
                    loadSupplierToComboBox();
                }
            }
        });

        nama_produk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = nama_produk.getSelectedItem();

                if (selected != null) {
                    String selectedText = selected.toString();
                    if (!selectedText.startsWith("--")) {
                        loadProdukData(selectedText);
                    }
                }
            }
        });

        nama_supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = nama_supplier.getSelectedItem();

                if (selected != null) {
                    String selectedText = selected.toString();
                    if (!selectedText.startsWith("--")) {
                        loadSupplierData(selectedText);
                    }
                }
            }
        });

        System.out.println("ComboBox KeyReleased setup!");
    }
    
    private void filterProdukComboBox(String keyword) {
        List<String> allProduk = transaksiPembelianProdukDAO.getNamaProdukList();
        List<String> filtered = new ArrayList<>();

        for (String nama : allProduk) {
            if (nama.toLowerCase().contains(keyword.toLowerCase())) {
                filtered.add(nama);
            }
        }

        ActionListener[] listeners = nama_produk.getActionListeners();
        for (ActionListener listener : listeners) {
            nama_produk.removeActionListener(listener);
        }

        nama_produk.removeAllItems();
        nama_produk.addItem("-- Pilih Produk --");
        for (String nama : filtered) {
            nama_produk.addItem(nama);
        }

        for (ActionListener listener : listeners) {
            nama_produk.addActionListener(listener);
        }

        if (!filtered.isEmpty()) {
            nama_produk.setPopupVisible(true);
        }

        System.out.println("Filtered produk: " + filtered.size() + " results");
    }
    
    private void filterSupplierComboBox(String keyword) {
        List<String> allSupplier = transaksiPembelianProdukDAO.getUniqueSupplierList();
        List<String> filtered = new ArrayList<>();

        for (String supplier : allSupplier) {
            if (supplier.toLowerCase().contains(keyword.toLowerCase())) {
                filtered.add(supplier);
            }
        }

        ActionListener[] listeners = nama_supplier.getActionListeners();
        for (ActionListener listener : listeners) {
            nama_supplier.removeActionListener(listener);
        }

        nama_supplier.removeAllItems();
        nama_supplier.addItem("-- Pilih Supplier --");
        for (String supplier : filtered) {
            nama_supplier.addItem(supplier);
        }

        for (ActionListener listener : listeners) {
            nama_supplier.addActionListener(listener);
        }

        if (!filtered.isEmpty()) {
            nama_supplier.setPopupVisible(true);
        }

        System.out.println("Filtered supplier: " + filtered.size() + " results");
    }
    
    private void loadProdukData(String namaProduk) {
        try {
            String kodeProduk = transaksiPembelianProdukDAO.getKodeProdukByNama(namaProduk);
            
            if (kodeProduk != null) {
                Map<String, Object> data = transaksiPembelianProdukDAO.getProdukData(kodeProduk);
                
                if (!data.isEmpty()) {
                    harga.setText(String.valueOf(data.get("harga_beli")));
                    
                    String namaSupplier = (String) data.get("nama_supplier");
                    nama_supplier.setSelectedItem(namaSupplier);
                    
                    telepon_supplier.setText((String) data.get("telepon_supplier"));
                    
                    int stokSebelum = (int) data.get("stok_saat_ini");
                    stok_sebelum.setText(String.valueOf(stokSebelum));
                    
                    calculateStokSesudah();
                    
                    System.out.println("Loaded: " + namaProduk);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private void loadSupplierData(String namaSupplier) {
        try {
            Map<String, Object> data = transaksiPembelianProdukDAO.getSupplierData(namaSupplier);
            
            if (!data.isEmpty()) {
                telepon_supplier.setText((String) data.get("telepon_supplier"));
                System.out.println("Loaded supplier: " + namaSupplier);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private void setupAutoCalculation() {
        jumlah.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateTotal();
                calculateStokSesudah();
            }
        });
        
        harga.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateTotal();
            }
        });
        
        System.out.println("Auto calculation setup!");
    }
    
    private void calculateStokSesudah() {
        try {
            String stokSebelumStr = stok_sebelum.getText().trim();
            String jumlahBeliStr = jumlah.getText().trim();
            
            if (!stokSebelumStr.isEmpty() && !jumlahBeliStr.isEmpty()) {
                int stokSebelum = Integer.parseInt(stokSebelumStr);
                int jumlahBeli = Integer.parseInt(jumlahBeliStr);
                int stokSesudah = stokSebelum + jumlahBeli;
                
                stok_sesudah.setText(String.valueOf(stokSesudah));
                jumlah_display.setText(String.valueOf(jumlahBeli));
            }
        } catch (NumberFormatException e) {}
    }
    
    private void calculateTotal() {
        try {
            String jumlahStr = jumlah.getText().trim();
            String hargaStr = harga.getText().trim();
            
            if (!jumlahStr.isEmpty() && !hargaStr.isEmpty()) {
                int jumlah = Integer.parseInt(jumlahStr);
                double harga = Double.parseDouble(hargaStr);
                double total = jumlah * harga;
                
                DecimalFormat df = new DecimalFormat("#,###");
                total_harga.setText("Rp " + df.format(total));
            }
        } catch (NumberFormatException e) {}
    }
    
    private void loadDataToTable() {
        tableModel.setRowCount(0);
        
        List<TransaksiPembelianProduk> transaksiList = transaksiPembelianProdukDAO.getAllTransaksi();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat currencyFormat = new DecimalFormat("#,###");
        
        for (TransaksiPembelianProduk transaksi : transaksiList) {
            Object[] row = {
                transaksi.getKodeTransaksi(),
                dateFormat.format(transaksi.getTanggalTransaksi()),
                transaksi.getKodeProduk(),
                transaksi.getNamaProduk(),
                transaksi.getNamaSupplier(),
                transaksi.getJumlahBeli() + " pcs",
                transaksi.getMetodePembayaran(),
                "Rp " + currencyFormat.format(transaksi.getTotalHarga())
            };
            tableModel.addRow(row);
        }
        
        System.out.println("Loaded " + transaksiList.size() + " records");
    }
    
    private void searchTransaksi() {
        String keyword = txtCari.getText().trim();
        
        if (keyword.isEmpty()) {
            loadDataToTable();
            return;
        }
        
        tableModel.setRowCount(0); 
        List<TransaksiPembelianProduk> transaksiList = transaksiPembelianProdukDAO.searchTransaksi(keyword);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat currencyFormat = new DecimalFormat("#,###");
        
        for (TransaksiPembelianProduk transaksi : transaksiList) {
            Object[] row = {
                transaksi.getKodeTransaksi(),
                dateFormat.format(transaksi.getTanggalTransaksi()),
                transaksi.getKodeProduk(),
                transaksi.getNamaProduk(),
                transaksi.getNamaSupplier(),
                transaksi.getJumlahBeli() + " pcs",
                transaksi.getMetodePembayaran(),
                "Rp " + currencyFormat.format(transaksi.getTotalHarga())
            };
            tableModel.addRow(row);
        }
        
        System.out.println("Found " + transaksiList.size() + " results");
    }
    
    private TransaksiPembelianProduk getTransaksiFromForm() throws Exception {
        if (nama_produk.getSelectedIndex() == 0) {
            throw new Exception("Pilih produk!");
        }

        if (nama_supplier.getSelectedIndex() == 0) {
            throw new Exception("Pilih supplier!");
        }

        if (tanggal.getDate() == null) {
            throw new Exception("Pilih tanggal!");
        }

        String jumlahStr = jumlah.getText().trim();
        if (jumlahStr.isEmpty()) {
            throw new Exception("Isi jumlah beli!");
        }

        int jumlahBeli = Integer.parseInt(jumlahStr);
        if (jumlahBeli <= 0) {
            throw new Exception("Jumlah harus > 0!");
        }

        TransaksiPembelianProduk transaksi = new TransaksiPembelianProduk();
        if (selectedTransaksi == null) {
            String kodeBaru = transaksiPembelianProdukDAO.generateKodeTransaksi();
            transaksi.setKodeTransaksi(kodeBaru);
        } else {
            transaksi.setKodeTransaksi(selectedTransaksi.getKodeTransaksi());
        }

        transaksi.setTanggalTransaksi(tanggal.getDate());
        String namaProduk = (String) nama_produk.getSelectedItem();
        String kodeProduk = transaksiPembelianProdukDAO.getKodeProdukByNama(namaProduk);
        transaksi.setKodeProduk(kodeProduk);
        transaksi.setNamaProduk(namaProduk);
        transaksi.setJumlahBeli(jumlahBeli);
        transaksi.setHargaSatuan(Double.parseDouble(harga.getText().trim()));
        transaksi.setNamaSupplier((String) nama_supplier.getSelectedItem());
        transaksi.setTeleponSupplier(telepon_supplier.getText().trim());
        transaksi.setMetodePembayaran((String) metode_pembayaran.getSelectedItem());
        transaksi.setKeterangan(keterangan.getText().trim());
        transaksi.setStokSebelum(Integer.parseInt(stok_sebelum.getText().trim()));
        transaksi.setStokSesudah(Integer.parseInt(stok_sesudah.getText().trim()));
        transaksi.setTotalHarga(jumlahBeli * transaksi.getHargaSatuan());

        return transaksi;
    }

    private void clearForm() {
        nama_produk.setSelectedIndex(0);
        nama_supplier.setSelectedIndex(0);
        jumlah.setText("");
        harga.setText("");
        telepon_supplier.setText("");
        metode_pembayaran.setSelectedIndex(0);
        keterangan.setText("");
        stok_sebelum.setText("");
        jumlah_display.setText("");
        stok_sesudah.setText("");
        total_harga.setText("");
        tanggal.setDate(new Date());
        selectedTransaksi = null;
        System.out.println("Form cleared!");
    }
    
    private void fillFormFromSelectedTransaksi() {
        if (selectedTransaksi == null) {
            return;
        }

        try {
            tanggal.setDate(selectedTransaksi.getTanggalTransaksi());
            nama_produk.setSelectedItem(selectedTransaksi.getNamaProduk());
            jumlah.setText(String.valueOf(selectedTransaksi.getJumlahBeli()));
            harga.setText(String.valueOf(selectedTransaksi.getHargaSatuan()));
            nama_supplier.setSelectedItem(selectedTransaksi.getNamaSupplier());
            telepon_supplier.setText(selectedTransaksi.getTeleponSupplier());
            metode_pembayaran.setSelectedItem(selectedTransaksi.getMetodePembayaran());
            keterangan.setText(selectedTransaksi.getKeterangan());
            stok_sebelum.setText(String.valueOf(selectedTransaksi.getStokSebelum()));
            jumlah_display.setText(String.valueOf(selectedTransaksi.getJumlahBeli()));
            stok_sesudah.setText(String.valueOf(selectedTransaksi.getStokSesudah()));
            DecimalFormat df = new DecimalFormat("#,###");
            total_harga.setText("Rp " + df.format(selectedTransaksi.getTotalHarga()));
            kode_produk.setText(selectedTransaksi.getKodeProduk());

            System.out.println("Form filled!");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void setupAutoFillKodeProduk() {
        nama_produk.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedProduk = (String) nama_produk.getSelectedItem();

                    // skip jika belum pilih
                    if (selectedProduk == null ||
                        selectedProduk.trim().isEmpty() ||
                        selectedProduk.startsWith("--")) {
                        kode_produk.setText("");
                        return;
                    }

                    String kode = transaksiPembelianProdukDAO.getKodeProdukByNama(selectedProduk);
                    if (kode != null && !kode.trim().isEmpty()) {
                        kode_produk.setText(kode);
                        System.out.println("Auto-filled kode produk: " + kode);
                    } else {
                        kode_produk.setText("");
                        System.out.println("Kode produk tidak ditemukan untuk: " + selectedProduk);
                    }
                }
            }
        });
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    tableModel.setRowCount(0);
    tableModel.setColumnCount(0);
    tableModel.addColumn("Nama Supplier");
    tableModel.addColumn("Telepon");
    tableModel.addColumn("Jumlah Transaksi");
    tableModel.addColumn("Total Pembelian");
    tableModel.addColumn("Produk Terakhir");
    tableModel.addColumn("Tanggal Terakhir");

    List<Map<String, Object>> supplierList = transaksiPembelianProdukDAO.getSupplierSummary();
    
    DecimalFormat currencyFormat = new DecimalFormat("#,###");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    for (Map<String, Object> supplier : supplierList) {
        Object[] row = {
            supplier.get("nama_supplier"),
            supplier.get("telepon_supplier"),
            supplier.get("total_transaksi") + " x",
            "Rp " + currencyFormat.format(supplier.get("total_pembelian")),
            supplier.get("produk_terakhir"),
            dateFormat.format(supplier.get("tanggal_terakhir"))
        };
        tableModel.addRow(row);
    }
    
    tabel_pembelian.getColumnModel().getColumn(0).setPreferredWidth(250); 
    tabel_pembelian.getColumnModel().getColumn(1).setPreferredWidth(130);
    tabel_pembelian.getColumnModel().getColumn(2).setPreferredWidth(150); 
    tabel_pembelian.getColumnModel().getColumn(3).setPreferredWidth(150); 
    tabel_pembelian.getColumnModel().getColumn(4).setPreferredWidth(200); 
    tabel_pembelian.getColumnModel().getColumn(5).setPreferredWidth(120); 
   
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    tabel_pembelian.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    tabel_pembelian.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    
    System.out.println("View Supplier: Showing " + supplierList.size() + " suppliers");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed

    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed

    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
     
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
       
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed

    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
       
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
      
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    try {
            TransaksiPembelianProduk transaksi = getTransaksiFromForm();
            boolean success = transaksiPembelianProdukDAO.insertTransaksi(transaksi);
            
            if (success) {
                JOptionPane.showMessageDialog(this,
                    "Transaksi berhasil disimpan!\n\n" +
                    "Kode: " + transaksi.getKodeTransaksi() + "\n" +
                    "Produk: " + transaksi.getNamaProduk() + "\n" +
                    "Jumlah: " + transaksi.getJumlahBeli() + " pcs\n" +
                    "Total: Rp " + new DecimalFormat("#,###").format(transaksi.getTotalHarga()),
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                " " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void jumlahjTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahjTextField7ActionPerformed
     
    }//GEN-LAST:event_jumlahjTextField7ActionPerformed

    private void btnViewDetailPembelianjButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailPembelianjButton5ActionPerformed
    initTable();
    loadDataToTable();
    selectedTransaksi = null;
    System.out.println("View Detail Pembelian: Back to normal view");
    }//GEN-LAST:event_btnViewDetailPembelianjButton5ActionPerformed

    private void kode_produkjTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_produkjTextField7ActionPerformed
   
    }//GEN-LAST:event_kode_produkjTextField7ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    tabel_pembelian.clearSelection();
    selectedTransaksi = null;
    clearForm();
    System.out.println("Selection cleared!");  
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
     if (selectedTransaksi == null) {
            JOptionPane.showMessageDialog(this,
                "Pilih transaksi dari tabel!",
                "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus transaksi?\n\n" +
            "Kode: " + selectedTransaksi.getKodeTransaksi() + "\n" +
            "Produk: " + selectedTransaksi.getNamaProduk() + "\n\n" +
            "Stok akan dikurangi kembali!",
            "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = transaksiPembelianProdukDAO.deleteTransaksi(selectedTransaksi.getKodeTransaksi());
            if (success) {
                JOptionPane.showMessageDialog(this, "Berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabel_pembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pembelianMouseClicked
    int selectedRow = tabel_pembelian.getSelectedRow();
    
    if (selectedRow >= 0) {
        String kodeTransaksi = tabel_pembelian.getValueAt(selectedRow, 0).toString();
        selectedTransaksi = transaksiPembelianProdukDAO.getTransaksiByKode(kodeTransaksi);
        
        if (selectedTransaksi != null) {
            // ✅ AUTO-FILL FORM FROM SELECTED ROW
            fillFormFromSelectedTransaksi();
            
            System.out.println("✅ Selected & auto-filled: " + kodeTransaksi);
        }
    }
    }//GEN-LAST:event_tabel_pembelianMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
    searchTransaksi();
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    if (selectedTransaksi == null) {
        JOptionPane.showMessageDialog(this,
            "Pilih data transaksi di tabel terlebih dahulu!",
            "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        TransaksiPembelianProduk transaksi = getTransaksiFromForm();
        boolean success = transaksiPembelianProdukDAO.updateTransaksi(transaksi);
        if (success) {
            JOptionPane.showMessageDialog(this,
                "Transaksi berhasil diupdate!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this,
                "Gagal update transaksi!",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "" + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
    searchTransaksi(); 
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void nama_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_produkActionPerformed

    }//GEN-LAST:event_nama_produkActionPerformed

    private void nama_produkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_produkKeyReleased
 
    }//GEN-LAST:event_nama_produkKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnViewDetailPembelian;
    private javax.swing.JButton btnViewSupplier;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField jumlah_display;
    private javax.swing.JTextArea keterangan;
    private javax.swing.JTextField kode_produk;
    private javax.swing.JComboBox<String> metode_pembayaran;
    private javax.swing.JComboBox<String> nama_produk;
    private javax.swing.JComboBox<String> nama_supplier;
    private javax.swing.JTextField stok_sebelum;
    private javax.swing.JTextField stok_sesudah;
    private javax.swing.JTable tabel_pembelian;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField telepon_supplier;
    private javax.swing.JTextField total_harga;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}