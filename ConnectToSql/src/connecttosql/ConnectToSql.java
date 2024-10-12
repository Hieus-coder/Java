import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToSql {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyLop;encrypt=true;trustServerCertificate=true;";
        String username = "sa"; // Thay doi neu can
        String password = "12345"; // Thay doi neu can

        try {
            // Ket noi den co so du lieu
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Ket noi thanh cong!");

            // Tao mot Statement
            Statement stmt = conn.createStatement();

            // Thuc hien truy van SQL
            String sql = "SELECT * FROM tbl_lop"; // Thay TenBang bang ten bang thuc te
            ResultSet rs = stmt.executeQuery(sql);

            // Duyet qua ket qua va in ra toi da 5 ban ghi
            int count = 0;
            while (rs.next() && count < 5) { // Giới hạn số lượng bản ghi in ra là 5
                int id = rs.getInt("malop"); // Thay doi 'id' bang ten cot thuc te
                String name = rs.getString("tenlop"); // Thay doi 'name' bang ten cot thuc te
                System.out.println("ID: " + id + ", Name: " + name);
                count++;
            }

            // Dong ResultSet va Statement
      
        } catch (SQLException e) {
            System.out.println("Loi SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi khac: " + e.getMessage());
        }
    }
}
