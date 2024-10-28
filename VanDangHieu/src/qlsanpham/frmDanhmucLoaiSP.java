/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlsanpham;

import Database.loaispcn;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.*;
import qlsanpham.dangnhap;

/**
 *
 * @author Hieus
 */
public class frmDanhmucLoaiSP extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private loaispcn loaiSP;
    private int lastSelectedRow = -1; // Lưu chỉ số của dòng đã được nhấn trước đó

    /**
     * Creates new form frmDanhmucLoaiSP
     */
    public frmDanhmucLoaiSP() {
        if (!dangnhap.isAuthenticated) { // Kiểm tra trạng thái đăng nhập
            JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước!");
            this.dispose(); // Đóng cửa sổ này
            new dangnhap().setVisible(true); // Quay lại trang đăng nhập
            return;
        }

        initComponents();
        tableModel = new DefaultTableModel(new String[]{"Mã loại", "Tên loại"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Tất cả các ô đều không cho phép chỉnh sửa
                return false;
            }
        };
        table.setModel(tableModel);

        table.setModel(tableModel); // Gán mô hình cho bảng
        loaiSP = new loaispcn(); // Khởi tạo đối tượng loaispcn
        loadDataToTable(); // Gọi hàm load dữ liệu khi khởi tạo
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Lấy chỉ số dòng hiện tại
                int selectedRow = table.getSelectedRow();

                // Hiển thị dữ liệu lên JTextField dù có nhấn lại vào dòng đã chọn
                String maLoai = (String) tableModel.getValueAt(selectedRow, 0);
                String tenLoai = (String) tableModel.getValueAt(selectedRow, 1);

                // Hiển thị dữ liệu lên các JTextField
                txtMaloai.setText(maLoai);
                txtTenloai.setText(tenLoai);

                // Khóa JTextField mã loại
                txtMaloai.setEnabled(false);
                txtTenloai.setEnabled(false);

                // Cập nhật dòng đã chọn cuối cùng
                lastSelectedRow = selectedRow;
            }
        });

    }

    private void loadDataToTable() {
        try {
            ResultSet rs = loaiSP.getAllLoaiSP(); // Lấy dữ liệu từ CSDL
            tableModel.setRowCount(0); // Xóa dữ liệu cũ trên bảng
            while (rs.next()) {
                String maLoai = rs.getString("MaLoai");
                String tenLoai = rs.getString("TenLoai");
                tableModel.addRow(new Object[]{maLoai, tenLoai}); // Thêm dòng vào bảng
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi load dữ liệu: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaloai = new javax.swing.JTextField();
        txtTenloai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKLuu.setText("K.Lưu");
        btnKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH MỤC LOẠI SẢN PHẨM");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel2.setText("Mã loại:");

        jLabel3.setText("Tên loại: ");

        txtMaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaloaiActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnLuu)
                                .addGap(18, 18, 18)
                                .addComponent(btnKLuu)
                                .addGap(18, 18, 18)
                                .addComponent(btnThoat))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnKLuu)
                    .addComponent(btnThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaloaiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String maLoai = txtMaloai.getText().trim();
        String tenLoai = txtTenloai.getText().trim();

        // Kiểm tra tính hợp lệ của dữ liệu
        if (maLoai.isEmpty() || tenLoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        // Thêm loại sản phẩm vào cơ sở dữ liệu
        boolean result = loaiSP.frmDanhmucLoaiSP(maLoai, tenLoai); // Sửa tên hàm

        // Thông báo kết quả và cập nhật trực tiếp bảng nếu thành công
        if (result) {
            JOptionPane.showMessageDialog(this, "Thêm loại sản phẩm thành công!");

            // Thêm dòng mới vào bảng mà không cần load lại toàn bộ dữ liệu
            tableModel.addRow(new Object[]{maLoai, tenLoai});

            // Xóa nội dung trong các ô nhập để người dùng có thể thêm mới
            txtMaloai.setText("");
            txtTenloai.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm loại sản phẩm thất bại!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn hay không
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
            return;
        }

        // Lấy mã loại từ cột đầu tiên của dòng được chọn
        String maLoai = (String) tableModel.getValueAt(selectedRow, 0);

        // Xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa loại sản phẩm này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Xóa loại sản phẩm khỏi cơ sở dữ liệu
            boolean result = loaiSP.xoaLoaiSP(maLoai);

            if (result) {
                // Xóa dòng khỏi bảng nếu xóa thành công trong cơ sở dữ liệu
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa loại sản phẩm thất bại!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Lấy chỉ số dòng đã chọn
        int selectedRow = table.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn hay không
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa!");
            return;
        }

        // Lấy mã loại từ cột đầu tiên của dòng được chọn
        String maLoai = (String) tableModel.getValueAt(selectedRow, 0);
        String tenLoai = (String) tableModel.getValueAt(selectedRow, 1);

        // Hiển thị thông tin lên các trường nhập liệu
        txtMaloai.setText(maLoai);
        txtTenloai.setText(tenLoai);

        // Khóa JTextField mã loại (không cho phép chỉnh sửa mã loại)
        txtMaloai.setEnabled(false);
        txtTenloai.setEnabled(true); // Cho phép chỉnh sửa tên loại

        // Hiện nút Lưu và đảm bảo nút Không Lưu luôn hiển thị
        btnLuu.setEnabled(true);
        btnKLuu.setEnabled(true); // Giữ cho nút Không Lưu luôn hiển thị

        // Cập nhật chỉ số dòng đã chọn
        lastSelectedRow = selectedRow; // Lưu chỉ số dòng đã chọn
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin mới từ JTextField
        String maLoai = txtMaloai.getText().trim();
        String tenLoaiMoi = txtTenloai.getText().trim();

        // Kiểm tra xem tên loại có bị trống không
        if (tenLoaiMoi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại sản phẩm!");
            return;
        }

        // Cập nhật vào cơ sở dữ liệu
        boolean result = loaiSP.capNhatLoaiSP(maLoai, tenLoaiMoi);

        if (result) {
            // Cập nhật thành công: Cập nhật dòng trong bảng
            int selectedRow = table.getSelectedRow();
            tableModel.setValueAt(tenLoaiMoi, selectedRow, 1); // Cập nhật tên loại trong bảng

            JOptionPane.showMessageDialog(this, "Cập nhật loại sản phẩm thành công!");

            // Khóa lại các trường sau khi cập nhật
            txtTenloai.setEnabled(false);
            btnLuu.setEnabled(false);
            btnKLuu.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật loại sản phẩm thất bại!");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKLuuActionPerformed
        // Đặt lại các trường nhập liệu
        txtMaloai.setText(""); // Làm sạch trường mã loại
        txtTenloai.setText(""); // Làm sạch trường tên loại

        // Cho phép nhập liệu mới
        txtMaloai.setEnabled(true);
        txtTenloai.setEnabled(true);

        // Khóa nút Lưu và Không Lưu
        btnLuu.setEnabled(false);
        btnKLuu.setEnabled(false);

        // Đặt lại chỉ số dòng đã chọn
        lastSelectedRow = -1; // Đặt lại để không giữ trạng thái
    }//GEN-LAST:event_btnKLuuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDanhmucLoaiSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMaloai;
    private javax.swing.JTextField txtTenloai;
    // End of variables declaration//GEN-END:variables
}