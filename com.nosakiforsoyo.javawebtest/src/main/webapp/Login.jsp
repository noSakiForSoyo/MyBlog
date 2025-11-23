<%--
  Created by IntelliJ IDEA.
  User: 27928
  Date: 2025/11/18
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=session.getAttribute("username")%>
    <%
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals("userName")){
                out.write("欢迎回来:"+c.getValue());
            }
        }
    %>
    <a href="/cookieLogout">退出登录</a>
</body>
</html>
