package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loaispcn {

    private Connection conn;

    public loaispcn(Connection conn) {
        this.conn = conn;
    }

    public boolean frmDanhmucLoaiSP(String maLoai, String tenLoai) {
        try {
            String sql = "INSERT INTO LoaiSP (MaLoai, TenLoai) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maLoai);
            pstmt.setString(2, tenLoai);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllLoaiSP() {
        try {
            String sql = "SELECT MaLoai, TenLoai FROM LoaiSP";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean xoaLoaiSP(String maLoai) {
        try {
            String sql = "DELETE FROM LoaiSP WHERE MaLoai = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maLoai);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean capNhatLoaiSP(String maLoai, String tenLoaiMoi) {
        try {
            String sql = "UPDATE LoaiSP SET TenLoai = ? WHERE MaLoai = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenLoaiMoi);
            pstmt.setString(2, maLoai);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
