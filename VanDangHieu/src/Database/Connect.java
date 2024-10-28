package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hieus
 */
public class Connect {

    public  static java.sql.Connection getConnect() {
        try {
            // Sửa tên driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSanpham;encrypt=true;trustServerCertificate=true;";
            Connection conn;
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(connectionUrl, "sa", "12345");
            System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver JDBC: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
