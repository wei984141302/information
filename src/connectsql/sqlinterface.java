package connectsql;
import java.sql.*;

public class sqlinterface {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/cslog";
    Connection con = null;

    //���ݿ������
    public void database() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //���ݿ���������
    public void add(String sql) throws SQLException {
        database();
        Statement stmte = con.createStatement();
        stmte.executeUpdate(sql);
    }
}