package com.okesalon.view.laporan.laporanoperasional;
import com.okesalon.util.koneksi;
import com.okesalon.dao.LaporanLayananTerlarisDAO;
import com.okesalon.dao.LaporanLayananTerlarisDAO.RowLayanan;
import com.okesalon.util.SessionManager;
import java.text.DecimalFormat;
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

public class LaporanLayananTerlaris extends javax.swing.JPanel {
    private DefaultTableModel modelTabel;
    private LaporanLayananTerlarisDAO dao;
    private DecimalFormat formatRupiah = new DecimalFormat("#,##0");

    public LaporanLayananTerlaris() {
        initComponents();
        dao = new LaporanLayananTerlarisDAO();
        initTable();
        loadRanking();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_terlaris = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Ranking = new javax.swing.JComboBox<>();
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
        txtTotalLayanan = new javax.swing.JTextField();
        txtTotalPendapatan = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 255));

        tabel_terlaris.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabel_terlaris.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_terlaris);

        jPanel2.setBackground(new java.awt.Color(255, 220, 255));

        jPanel3.setBackground(new java.awt.Color(255, 102, 204));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("LAYANAN TERLARIS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Ranking Layanan Berdasarkan");

        Ranking.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Ranking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hari Ini", "Seminggu Terakhir", "Sebulan Terakhir", "3 Bulan Terakhir", "6 Bulan Terakhir", "Setahun Terakhir", "All The Time" }));
        Ranking.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(Ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Ranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
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
        lblTotalMasuk.setText("Total Layanan                  :");

        lblTotalKeluar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTotalKeluar.setText("Total Pendapatan             :");

        txtTotalLayanan.setEditable(false);
        txtTotalLayanan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotalLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalLayananActionPerformed(evt);
            }
        });

        txtTotalPendapatan.setEditable(false);
        txtTotalPendapatan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

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
                        .addComponent(txtTotalLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblTotalKeluar)
                        .addGap(20, 20, 20)
                        .addComponent(txtTotalPendapatan)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalMasuk)
                    .addComponent(txtTotalLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalKeluar)
                    .addComponent(txtTotalPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(514, 514, 514)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initTable() {
        modelTabel = new DefaultTableModel(
            new Object[]{"No", "Kode", "Nama Layanan", "Kategori", "Total Pembelian", "Total Pendapatan", "Rata-Rata Harga"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_terlaris.setModel(modelTabel);
        
        tabel_terlaris.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabel_terlaris.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabel_terlaris.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabel_terlaris.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabel_terlaris.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabel_terlaris.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabel_terlaris.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabel_terlaris.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabel_terlaris.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabel_terlaris.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabel_terlaris.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tabel_terlaris.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        tabel_terlaris.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
    }
    
    private void loadRanking() {
        List<String> list = dao.getRanking();
        Ranking.removeAllItems();
        for (String r : list) {
            Ranking.addItem(r);
        }
        Ranking.setSelectedIndex(0);
    }
    
    private void fillTable(List<RowLayanan> rows) {
        modelTabel.setRowCount(0);
        int no = 1;
        for (RowLayanan row : rows) {
            modelTabel.addRow(new Object[]{
                no++,
                row.kodeLayanan,
                row.namaLayanan,
                row.kategoriLayanan != null ? row.kategoriLayanan : "-",
                row.totalPembelian,
                "Rp " + formatRupiah.format(row.totalPendapatan),
                "Rp " + formatRupiah.format(row.rataHarga)
            });
        }
    }
    
    private void updateSummary() {
        int totalLayanan = 0;
        double totalPendapatan = 0.0;

        for (int i = 0; i < modelTabel.getRowCount(); i++) {
            totalLayanan++;
            String pendapatanStr = modelTabel.getValueAt(i, 5).toString();
            pendapatanStr = pendapatanStr.replace("Rp ", "").replace(",", "");
            totalPendapatan += Double.parseDouble(pendapatanStr);
        }

        txtTotalLayanan.setText(String.valueOf(totalLayanan));
        txtTotalPendapatan.setText("Rp " + formatRupiah.format(totalPendapatan));
    }
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        Ranking.setSelectedIndex(0);
        txtCari.setText("");
        modelTabel.setRowCount(0);
        txtTotalLayanan.setText("");
        txtTotalPendapatan.setText("");

        JOptionPane.showMessageDialog(this, 
            "Form berhasil di-reset!", 
            "Info", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
     try {
        String ranking = Ranking.getSelectedItem().toString();
        List<RowLayanan> rows = dao.getData(ranking, txtCari.getText().trim());
        fillTable(rows);
        updateSummary();
        JOptionPane.showMessageDialog(this, 
            "Data dimuat! Total: " + rows.size() + " layanan", 
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

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
     try {
        String ranking = Ranking.getSelectedItem().toString();
        List<RowLayanan> rows = dao.getData(ranking, txtCari.getText().trim());        
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

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    try {
        if (modelTabel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Tidak ada data untuk dicetak!\nKlik FILTER terlebih dahulu.", 
                "Validasi", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String rankingPeriod = Ranking.getSelectedItem().toString();
        SessionManager session = SessionManager.getInstance();
        
        int totalLayanan = Integer.parseInt(txtTotalLayanan.getText());
        String totalPendapatan = txtTotalPendapatan.getText().replace("Rp ", "").replace(",", "");
        
        Map<String, Object> params = new HashMap<>();
        params.put("p_ranking", rankingPeriod);
        params.put("p_total_layanan", totalLayanan);
        params.put("p_total_pendapatan", Double.parseDouble(totalPendapatan));
        params.put("namaUser", session.getNamaLengkap());
        params.put("roleUser", session.getRole());
        
        InputStream is = getClass().getResourceAsStream(
            "/report/laporanoperasional/LaporanLayananTerlaris.jasper");
        
        if (is == null) {
            JOptionPane.showMessageDialog(this, 
                "File report tidak ditemukan!\n" +
                "Path: /report/laporanoperasional/LaporanLayananTerlaris.jasper", 
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

    private void txtTotalLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalLayananActionPerformed

    }//GEN-LAST:event_txtTotalLayananActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Ranking;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalKeluar;
    private javax.swing.JLabel lblTotalMasuk;
    private javax.swing.JTable tabel_terlaris;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtTotalLayanan;
    private javax.swing.JTextField txtTotalPendapatan;
    // End of variables declaration//GEN-END:variables
}