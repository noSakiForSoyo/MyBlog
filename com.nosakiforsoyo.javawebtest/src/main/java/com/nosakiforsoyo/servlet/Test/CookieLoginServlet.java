package com.nosakiforsoyo.servlet.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login-form")
public class CookieLoginServlet extends HttpServlet {

    private String MyuserName ="admin";
    private String MypassWord = "123456";

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        if(userName.equals(MyuserName) && passWord.equals(MypassWord)){
            HttpSession session = req.getSession();
            session.setAttribute("username", MyuserName);
            //
            Cookie cookie = new Cookie("userName", userName);
            resp.addCookie(cookie);
            resp.sendRedirect("Login.jsp");
        }else{
            resp.sendRedirect("Test.jsp");
        }
    }
}
