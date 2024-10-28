package Database;

import Proccess.nguoidung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieus
 */
public class nguoidungcn{
    // Phương thức đăng nhập
    public boolean dangnhap(String username, String password) {
        try {
            java.sql.Connection conn = Connect.getConnect();
            String sql = "select * from nguoidung where username = ? and password = ? ";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,password);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
