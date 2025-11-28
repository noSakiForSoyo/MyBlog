package org;

import java.sql.*;

public class jdbcTest {
    public static void main() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/game";
        String user = "root";
        String password = "279289";

        Connection conn = DriverManager.getConnection(url, user, password);
        String sql ="select * from player where name = ? and email = ?";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, "Jim");
        p.setString(2, "212121212@qq.com");
        System.out.println("sql:"+sql);

        // Statement stmt = conn.createStatement();

        try {
            conn.setAutoCommit(false);
            ResultSet rs = p.executeQuery(sql);
            if(rs.next()){
                System.out.println("成功");
            }
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        }
        p.close();
        conn.close();

    }
}
