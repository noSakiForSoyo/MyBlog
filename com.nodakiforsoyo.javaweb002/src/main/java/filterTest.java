import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "test",urlPatterns = "/*")
public class filterTest implements Filter {
    List<String> ips = new ArrayList<>();
    {
        ips.add("127.0.0.1");
        ips.add("192.168.0.1");
        ips.add("0:0:0:0:0:0:0:1");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=GB2312");
        //获取本机地址
        String remoteAddr = servletRequest.getRemoteAddr();
        System.out.println("remoteAddr:"+remoteAddr);
        boolean isBlack =false;
        for(String ip:ips){
            if(ip.equals(remoteAddr)){
                isBlack=true;
            }
        }
        if(isBlack){
            PrintWriter writer = servletResponse.getWriter();
            writer.println("<h1>"+"你的ip禁止访问"+"</h1>");
            return ;
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
