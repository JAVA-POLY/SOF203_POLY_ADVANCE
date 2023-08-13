/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.main.view;

import com.poly.main.model.CongViec;
import com.poly.main.model.TheLoai;
import com.poly.main.service.CongViecService;
import com.poly.main.service.TheLoaiService;
import com.poly.main.service.impl.CongViecServiceImpl;
import com.poly.main.service.impl.TheLoaiServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hangnt
 */
public class ViewCongViec extends javax.swing.JFrame {

    /**
     * Creates new form ViewCongViec
     */
    private final CongViecService congViecService = new CongViecServiceImpl();
    private final TheLoaiService theLoaiService = new TheLoaiServiceImpl();
    private List<CongViec> listCongViec = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<TheLoai> listTheLoai = new ArrayList<>();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

    public ViewCongViec() {
        initComponents();
        listCongViec = congViecService.findAll();
        listTheLoai = theLoaiService.findAll();
        dtm = (DefaultTableModel) tbHienThi.getModel();
        dcbm = (DefaultComboBoxModel) cbbIDTheLoai.getModel();
        showTable(listCongViec);
        showCombobox(listTheLoai);
    }

    private void showTable(List<CongViec> lists) {
        dtm.setRowCount(0);
        lists.forEach(s -> dtm.addRow(new Object[]{s.getTenCongViec(),
            s.getTheLoai().getId(), s.getTheLoai().getTenTheLoai(),
            getTrangThai(s.getTrangThai()), s.getThoiGianHoanThanh()
        }));
    }

    private String getTrangThai(int indexTrangThai) {
        return switch (indexTrangThai) {
            case 1 ->
                "Đang thực hiên";
            case 2 ->
                "Đã thực hiện";
            default ->
                "Chưa thực hiện";
        };
    }

    private void showCombobox(List<TheLoai> lists) {
        dcbm.removeAllElements();
        lists.forEach(s -> dcbm.addElement(s.getTenTheLoai()));
    }

    private CongViec getFormData() {
        try {
            String tenCongViec = txtTenCongViec.getText();
            String thoiGianHoanThanh = txtThoiGianHoanThanh.getText();
            int idTheLoai = cbbIDTheLoai.getSelectedIndex();
            String format = "yyyy-MM-dd";

            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            int indexTrangThai = 0;
            if (rdDangThucHien.isSelected()) {
                indexTrangThai = 1;
            }
            if (rdDaThucHien.isSelected()) {
                indexTrangThai = 2;
            }
            return new CongViec(null, tenCongViec,
                    theLoaiService.findByID(Long.valueOf(idTheLoai)),
                    indexTrangThai, dateFormat.parse(thoiGianHoanThanh));
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    private void detailCongViec(int index) {
        CongViec cv = listCongViec.get(index);
        txtTenCongViec.setText(cv.getTenCongViec());
        cbbIDTheLoai.setSelectedItem(cv.getTheLoai().getTenTheLoai());
        txtThoiGianHoanThanh.setText(cv.getThoiGianHoanThanh().toString());
        switch (cv.getTrangThai()) {
            case 0 -> {
                buttonGroup1.clearSelection();
                rdChuaThucHien.setSelected(true);
            }
            case 1 -> {
                buttonGroup1.clearSelection();
                rdDangThucHien.setSelected(true);
            }
            case 2 -> {
                buttonGroup1.clearSelection();
                rdDaThucHien.setSelected(true);
            }
            default -> {
                buttonGroup1.clearSelection();
                rdChuaThucHien.setSelected(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbIDTheLoai = new javax.swing.JComboBox<>();
        rdChuaThucHien = new javax.swing.JRadioButton();
        rdDangThucHien = new javax.swing.JRadioButton();
        rdDaThucHien = new javax.swing.JRadioButton();
        txtThoiGianHoanThanh = new javax.swing.JTextField();
        txtTenCongViec = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý công việc");

        jLabel2.setText("Tên công việc");

        jLabel3.setText("Thể loại");

        jLabel4.setText("Thời gian hoàn thành");

        jLabel5.setText("Trạng thái");

        cbbIDTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(rdChuaThucHien);
        rdChuaThucHien.setSelected(true);
        rdChuaThucHien.setText("Chưa thực hiện");

        buttonGroup1.add(rdDangThucHien);
        rdDangThucHien.setText("Đang thực hiện");

        buttonGroup1.add(rdDaThucHien);
        rdDaThucHien.setText("Đã thực hiện");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên công việc", "ID Thể loại", "Tên thể loại", "Trạng thái", "Thời gian hoàn thành"
            }
        ));
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHienThi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbIDTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdChuaThucHien)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdDangThucHien)))))
                        .addGap(42, 42, 42)
                        .addComponent(rdDaThucHien)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(200, 200, 200)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addComponent(btnRemove)))
                        .addGap(44, 44, 44))))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtTenCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbIDTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdChuaThucHien)
                    .addComponent(rdDangThucHien)
                    .addComponent(rdDaThucHien))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        congViecService.insert(getFormData());
        listCongViec = congViecService.findAll();
        showTable(listCongViec);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tbHienThi.getSelectedRow();
        CongViec cv = getFormData();
        cv.setId(listCongViec.get(row).getId());
        congViecService.update(cv);
        listCongViec = congViecService.findAll();
        showTable(listCongViec);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = tbHienThi.getSelectedRow();
        CongViec cv = listCongViec.get(row);
        congViecService.delete(cv);
        listCongViec = congViecService.findAll();
        showTable(listCongViec);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        int row = tbHienThi.getSelectedRow();
        detailCongViec(row);
    }//GEN-LAST:event_tbHienThiMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ViewCongViec().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbIDTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdChuaThucHien;
    private javax.swing.JRadioButton rdDaThucHien;
    private javax.swing.JRadioButton rdDangThucHien;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTextField txtTenCongViec;
    private javax.swing.JTextField txtThoiGianHoanThanh;
    // End of variables declaration//GEN-END:variables
}
