package Database;

import Proccess.nguoidung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieus
 */
public class nguoidungcn {

    private Connection conn;

    public nguoidungcn(Connection conn) {
        this.conn = conn;
    }

    public boolean dangnhap(String username, String password) {
        try {
            String sql = "select * from nguoidung where username = ? and password = ? ";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean dangky(String username, String password) {
        try {
            String sql = "INSERT INTO LoaiSP (MaLoai, TenLoai) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int usernew = pstmt.executeUpdate();
            return usernew > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
