import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.*;

@WebServlet("/login")
public class javaTest extends HttpServlet{
    static int count=0;
    public javaTest(){
        count = 0;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/game?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String sqlPassword = "279289";
            Connection conn = DriverManager.getConnection(url,user,sqlPassword);
            String sql = "select * from user where name=? and password=?";
            PreparedStatement stat =conn.prepareStatement(sql);

            stat.setString(1,name);
            stat.setString(2,password);

            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                count++;
                System.out.println("yes"+count);
            }else{
                System.out.println("no"+count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}