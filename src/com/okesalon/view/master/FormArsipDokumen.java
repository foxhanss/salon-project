package com.okesalon.view.master;
import com.okesalon.dao.ArsipDokumenDAO;
import com.okesalon.model.ArsipDokumen;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

public class FormArsipDokumen extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    private ArsipDokumenDAO dokumenDAO;
    private ArsipDokumen selectedDokumen = null;
    private String selectedFilePath = null;
    private boolean isViewExpiredMode = false;
    private String selectedFotoPath = "";

    public FormArsipDokumen() {
        initComponents();
        dokumenDAO = new ArsipDokumenDAO();
        dokumenDAO = new ArsipDokumenDAO();
        initTable();
        setupComboBoxes();
        setupStatusRenderer();
        loadDataToTable();
        autoUpdateExpiredStatus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnViewExpired = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_arsip = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnViewDetailArsip = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        file_path = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        Judul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        kategori_dokumen = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        tanggal_expired = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 21)); // NOI18N
        jLabel3.setText("Arsip Dokumen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(1341, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 153, 255));

        btnTambah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCari.setText("CARI");
        btnCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnViewExpired.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnViewExpired.setText("View Expired");
        btnViewExpired.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewExpired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewExpiredActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tabel_arsip.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_arsip.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_arsip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_arsipMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_arsip);

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnViewDetailArsip.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnViewDetailArsip.setText("View Detail Arsip");
        btnViewDetailArsip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewDetailArsip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailArsipActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 220, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DETAIL ARSIP DOKUMEN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("File Path");

        file_path.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnUpload.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpload.setText("Upload File");
        btnUpload.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tanggal Dokumen");

        Judul.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Judul Dokumen");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Kategori Dokumen");

        kategori_dokumen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kategori_dokumen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Surat Izin Usaha", "Kontrak Karyawan", "Faktur", "Sertifikat" }));
        kategori_dokumen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        deskripsi.setColumns(20);
        deskripsi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deskripsi.setRows(5);
        jScrollPane1.setViewportView(deskripsi);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Deskripsi");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Status");

        status.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Expired", "Archived" }));
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        tanggal_expired.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Tanggal Expired");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Judul, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kategori_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal_expired, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6))
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Judul, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kategori_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tanggal_expired, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnViewExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnViewDetailArsip, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(1199, 1199, 1199)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(622, 622, 622)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewDetailArsip, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(522, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    private void setupComboBoxes() {
        kategori_dokumen.removeAllItems();
        kategori_dokumen.addItem("Surat Izin Usaha");
        kategori_dokumen.addItem("Kontrak Karyawan");
        kategori_dokumen.addItem("Kontrak Supplier");
        kategori_dokumen.addItem("Invoice/Kwitansi");
        kategori_dokumen.addItem("Laporan Keuangan");
        kategori_dokumen.addItem("Sertifikat Pelatihan");
        kategori_dokumen.addItem("Dokumen Pajak");
        kategori_dokumen.addItem("Asuransi");
        kategori_dokumen.addItem("Perjanjian Kerjasama");
        kategori_dokumen.addItem("Dokumen Lainnya");
        status.removeAllItems();
        status.addItem("Aktif");
        status.addItem("Non-Aktif");
        status.addItem("Expired");
    }
    
    private void initTable() {
        String[] kolom = {
            "ID Dokumen",
            "Judul Dokumen",
            "Kategori",
            "Tanggal Dokumen",
            "Tanggal Expired",
            "Status"
        };
        
        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabel_arsip.setModel(tableModel);
        tabel_arsip.setRowHeight(25);
        tabel_arsip.getTableHeader().setReorderingAllowed(false);
        
        tabel_arsip.getColumnModel().getColumn(0).setPreferredWidth(90);  
        tabel_arsip.getColumnModel().getColumn(1).setPreferredWidth(250);  
        tabel_arsip.getColumnModel().getColumn(2).setPreferredWidth(150);  
        tabel_arsip.getColumnModel().getColumn(3).setPreferredWidth(110);  
        tabel_arsip.getColumnModel().getColumn(4).setPreferredWidth(110);  
        tabel_arsip.getColumnModel().getColumn(5).setPreferredWidth(80);   
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        
        List<ArsipDokumen> dataDokumen = dokumenDAO.getAll();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (ArsipDokumen d : dataDokumen) {
            String tglExpired = d.getTanggalExpired() != null ? 
                               sdf.format(d.getTanggalExpired()) : "-";
            
            Object[] row = {
                d.getIdDokumen(),
                d.getJudulDokumen(),
                d.getKategoriDokumen(),
                sdf.format(d.getTanggalDokumen()),
                tglExpired,
                d.getStatus()
            };
            tableModel.addRow(row);
        }
    }
    
    private void autoUpdateExpiredStatus() {
        int updated = dokumenDAO.autoUpdateStatusExpired();
        if (updated > 0) {
            System.out.println("" + updated + " dokumen diupdate menjadi Expired");
        }
    }
    
    private void openFile() {
        if (selectedDokumen == null || selectedDokumen.getFilePath() == null) {
            JOptionPane.showMessageDialog(this,
                "Tidak ada file yang terhubung dengan dokumen ini.",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        File file = new File(selectedDokumen.getFilePath());
        
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this,
                "File tidak ditemukan!\n" +
                "Path: " + selectedDokumen.getFilePath(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Desktop tidak didukung di sistem ini.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal membuka file: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void setupStatusRenderer() {
        tabel_arsip.getColumnModel().getColumn(5).setCellRenderer(
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
                        } else if ("Expired".equals(status)) {
                            cell.setBackground(new Color(255, 255, 200));  
                            cell.setForeground(new Color(200, 150, 0));    
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
    
    private ArsipDokumen getDokumenFromForm() throws Exception {
        String judul = Judul.getText().trim();
        if (judul.isEmpty()) {
            throw new Exception("Judul Dokumen tidak boleh kosong!");
        }
        
        Date tanggalDokumen = tanggal.getDate();
        if (tanggalDokumen == null) {
            throw new Exception("Tanggal Dokumen tidak boleh kosong!");
        }

        ArsipDokumen dokumen = new ArsipDokumen();
        dokumen.setKategoriDokumen(kategori_dokumen.getSelectedItem().toString());
        dokumen.setJudulDokumen(judul);
        dokumen.setTanggalDokumen(tanggalDokumen);
        dokumen.setTanggalExpired(tanggal.getDate());
        dokumen.setStatus(status.getSelectedItem().toString());
        dokumen.setDeskripsi(deskripsi.getText().trim());
        dokumen.setFilePath(selectedFilePath);
        
        return dokumen;
    }
    
    private void clearForm() {
        kategori_dokumen.setSelectedIndex(0);
        Judul.setText("");
        tanggal.setDate(new Date());
        tanggal_expired.setDate(null);
        status.setSelectedIndex(0);
        deskripsi.setText("");
        file_path.setText("");
        selectedFilePath = null;
        selectedDokumen = null;
        tabel_arsip.clearSelection();
        
        Judul.requestFocus();
    }

    private String getFileExtension(String fileName) {
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot > 0) {
            return fileName.substring(lastDot + 1);
        }
        return "";
    }
 
    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed

    }//GEN-LAST:event_statusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
     try {
            ArsipDokumen dokumen = getDokumenFromForm();
            String id = dokumenDAO.generateIdDokumen();
            dokumen.setIdDokumen(id);
            boolean success = dokumenDAO.insert(dokumen);
            
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this,
                    "Dokumen berhasil ditambahkan dengan ID: " + id,
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                
                if (dokumen.getTanggalExpired() != null) {
                    long hariTersisa = dokumen.getHariTersisa();
                    if (hariTersisa >= 0 && hariTersisa <= 30) {
                        JOptionPane.showMessageDialog(this,
                            "PERHATIAN!\n\n" +
                            "Dokumen ini akan expired dalam " + hariTersisa + " hari!\n" +
                            "Tanggal Expired: " + new SimpleDateFormat("dd/MM/yyyy")
                                .format(dokumen.getTanggalExpired()),
                            "Alert Expired",
                            JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan data dokumen!",
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
            if (isViewExpiredMode) {
                btnViewExpiredActionPerformed(null);
            } else {
                loadDataToTable();
            }
            return;
        }

        if (isViewExpiredMode) {
            JOptionPane.showMessageDialog(this,
                "Pencarian tidak tersedia di mode View Expired.\n" +
                "Kembali ke mode normal terlebih dahulu.",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        tableModel.setRowCount(0);
        List<ArsipDokumen> results = dokumenDAO.search(keyword);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (ArsipDokumen d : results) {
            String tglExpired = d.getTanggalExpired() != null ? 
                               sdf.format(d.getTanggalExpired()) : "-";
            
            Object[] row = {
                d.getIdDokumen(),
                d.getJudulDokumen(),
                d.getKategoriDokumen(),
                sdf.format(d.getTanggalDokumen()),
                tglExpired,
                d.getStatus()
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

    private void btnViewExpiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewExpiredActionPerformed
    isViewExpiredMode = true;
        
        String[] kolomExpired = {
            "ID Dokumen",
            "Judul Dokumen",
            "Kategori",
            "Tanggal Expired",
            "Status",
            "Hari Tersisa"
        };
        
        tableModel = new DefaultTableModel(kolomExpired, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabel_arsip.setModel(tableModel);
        tabel_arsip.setRowHeight(25);
        tabel_arsip.getColumnModel().getColumn(0).setPreferredWidth(90);   
        tabel_arsip.getColumnModel().getColumn(1).setPreferredWidth(250);  
        tabel_arsip.getColumnModel().getColumn(2).setPreferredWidth(150);  
        tabel_arsip.getColumnModel().getColumn(3).setPreferredWidth(110);  
        tabel_arsip.getColumnModel().getColumn(4).setPreferredWidth(80);   
        tabel_arsip.getColumnModel().getColumn(5).setPreferredWidth(100);  
        
        List<ArsipDokumen> dokumenExpired = dokumenDAO.getDokumenExpired(90);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if (dokumenExpired.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Tidak ada dokumen yang expired atau akan expired!\n" +
                "Semua dokumen masih valid.",
                "Info Expired",
                JOptionPane.INFORMATION_MESSAGE);
            
            isViewExpiredMode = false;
            initTable();
            loadDataToTable();
        } else {
            int countExpired = 0;
            int countAkanExpired = 0;
            
            for (ArsipDokumen d : dokumenExpired) {
                long hariTersisa = d.getHariTersisa();
                String statusExpired;
                
                if (hariTersisa < 0) {
                    statusExpired = "Expired ";
                    countExpired++;
                } else if (hariTersisa == 0) {
                    statusExpired = "Expired Hari Ini! ";
                    countExpired++;
                } else {
                    statusExpired = hariTersisa + " hari lagi ";
                    countAkanExpired++;
                }
                
                Object[] row = {
                    d.getIdDokumen(),
                    d.getJudulDokumen(),
                    d.getKategoriDokumen(),
                    sdf.format(d.getTanggalExpired()),
                    d.getStatus(),
                    statusExpired
                };
                tableModel.addRow(row);
            }
            
            JOptionPane.showMessageDialog(this,
                "ALERT DOKUMEN EXPIRED!\n\n" +
                "Dokumen Sudah Expired: " + countExpired + "\n" +
                "Dokumen Akan Expired (90 hari): " + countAkanExpired + "\n\n" +
                "Total: " + dokumenExpired.size() + " dokumen perlu perhatian",
                "Alert Expired",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewExpiredActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih File Dokumen");
    
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Dokumen Files (PDF, DOC, DOCX, JPG, PNG)", 
        "pdf", "doc", "docx", "jpg", "jpeg", "png"
    );
    fileChooser.setFileFilter(filter);
    
    int result = fileChooser.showOpenDialog(this);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        try {
            File folderDokumen = new File("uploads/dokumen");
            if (!folderDokumen.exists()) {
                folderDokumen.mkdirs(); 
            }
           
            String extension = getFileExtension(selectedFile.getName());
            String newFileName = "dokumen_" + System.currentTimeMillis() + "." + extension;
            File destFile = new File(folderDokumen, newFileName);
            
            Files.copy(selectedFile.toPath(), destFile.toPath(), 
                      StandardCopyOption.REPLACE_EXISTING);
            
            selectedFotoPath = "uploads/dokumen/" + newFileName;
            
            file_path.setText(selectedFotoPath);
            
            JOptionPane.showMessageDialog(this,
                "File berhasil diupload!\n\n" +
                "Original: " + selectedFile.getName() + "\n" +
                "Saved as: " + newFileName + "\n" +
                "Location: " + selectedFotoPath,
                "Upload Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mengupload file: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    } 
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
    if (selectedDokumen == null) {
            JOptionPane.showMessageDialog(this,
                "Pilih data di tabel yang akan dihapus!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus dokumen:\n" +
            selectedDokumen.getJudulDokumen() + " (" + selectedDokumen.getIdDokumen() + ")?\n\n" +
            "File dokumen tidak akan dihapus dari folder.",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);
        
        if (konfirmasi == JOptionPane.YES_OPTION) {
            boolean success = dokumenDAO.delete(selectedDokumen.getIdDokumen());
            
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this,
                    "Data dokumen berhasil dihapus!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menghapus data dokumen!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabel_arsipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_arsipMouseClicked
     int row = tabel_arsip.getSelectedRow();
        if (row == -1) return;
        
        String id = tabel_arsip.getValueAt(row, 0).toString();
        selectedDokumen = dokumenDAO.getById(id);
        
        if (selectedDokumen != null) {
            kategori_dokumen.setSelectedItem(selectedDokumen.getKategoriDokumen());
            Judul.setText(selectedDokumen.getJudulDokumen());
            tanggal.setDate(selectedDokumen.getTanggalDokumen());
            tanggal_expired.setDate(selectedDokumen.getTanggalExpired());
            status.setSelectedItem(selectedDokumen.getStatus());
            deskripsi.setText(selectedDokumen.getDeskripsi());
            
            if (selectedDokumen.getFilePath() != null && !selectedDokumen.getFilePath().isEmpty()) {
                File file = new File(selectedDokumen.getFilePath());
                file_path.setText(file.getName());
                selectedFilePath = selectedDokumen.getFilePath();
            } else {
                file_path.setText("");
                selectedFilePath = null;
            }
            
            if (evt.getClickCount() == 2) {
                openFile();
            }
        }   
    }//GEN-LAST:event_tabel_arsipMouseClicked

    private void btnViewDetailArsipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailArsipActionPerformed
    isViewExpiredMode = false;
        initTable();
        loadDataToTable();
        
        JOptionPane.showMessageDialog(this,
            "Tabel dikembalikan ke tampilan normal.",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnViewDetailArsipActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    if (selectedDokumen == null) {
            JOptionPane.showMessageDialog(this,
                "Pilih data di tabel yang akan diubah!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            ArsipDokumen updated = getDokumenFromForm();
            updated.setIdDokumen(selectedDokumen.getIdDokumen());
            
            if (selectedFilePath == null) {
                updated.setFilePath(selectedDokumen.getFilePath());
            }
            
            boolean success = dokumenDAO.update(updated);
            
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this,
                    "Data dokumen berhasil diubah!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal mengubah data dokumen!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Judul;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnViewDetailArsip;
    private javax.swing.JButton btnViewExpired;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JTextField file_path;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> kategori_dokumen;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable tabel_arsip;
    private com.toedter.calendar.JDateChooser tanggal;
    private com.toedter.calendar.JDateChooser tanggal_expired;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}