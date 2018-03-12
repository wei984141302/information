package connectsql;
import java.sql.*;

public class sqlinterface {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/cslog";
    Connection con = null;

    //数据库的连接
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

    //数据库增加数据
    public void add(String sql) throws SQLException {
        database();
        Statement stmte = con.createStatement();
        stmte.executeUpdate(sql);
    }
}