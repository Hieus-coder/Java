/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hieus
 */
public class loaispcn {

    public boolean frmDanhmucLoaiSP(String MaLoai, String TenLoai) {
        try {
            java.sql.Connection conn = Connect.getConnect();
            String sql = "INSERT INTO LoaiSP (MaLoai, TenLoai) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, MaLoai);
            pstmt.setString(2, TenLoai);
            // Thay executeQuery() bằng executeUpdate()
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Kiểm tra xem có dòng nào bị ảnh hưởng hay không
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllLoaiSP() {
        try {
            java.sql.Connection conn = Connect.getConnect();
            String sql = "SELECT MaLoai, TenLoai FROM LoaiSP";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery(); // Trả về ResultSet chứa dữ liệu
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean xoaLoaiSP(String maLoai) {
        try {
            java.sql.Connection conn = Connect.getConnect();
            String sql = "DELETE FROM LoaiSP WHERE MaLoai = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maLoai);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean capNhatLoaiSP(String maLoai, String tenLoaiMoi) {
        try {
            java.sql.Connection conn = Connect.getConnect();
            String sql = "UPDATE LoaiSP SET TenLoai = ? WHERE MaLoai = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenLoaiMoi);
            pstmt.setString(2, maLoai);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
