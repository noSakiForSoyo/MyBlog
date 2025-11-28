### 2025.11.9
java内部自带的用于与客户端通信的组件。
可以创建并返回基于客户请求的动态html页面，也可以与数据库进行通信。
使用前在pom.xml里面加javax.servlet依赖。
之后可以implements接口并实现五个方法，也是其生命周期{
init():初始化
getservletConfig():获取servlet信息
service():进行的逻辑操作
getServletInfo():返回读取信息
destory():销毁
}

之后可以在web.xml里面使用<servlet>和<servlet-mapping>对java文件进行映射来使其可被使用

```xml

<servlet>  
    <servlet-name>MyServlet</servlet-name>  
    <servlet-class>com.nosakiforsoyo.servlet.MyServlet</servlet-class>  
</servlet>  
  
<servlet-mapping>  
    <servlet-name>MyServlet</servlet-name>  
    <url-pattern>/myServlet</url-pattern>  
</servlet-mapping>

```

不过也可以直接继承HttpServlet方法然后重写doGet()等do字辈的方法.

### 2025.11.19

cookie：用于缓存不重要的数据，保存在浏览器，  
```
//创建Cookie，响应客户端
Cookie cookie =new Cookie("name","tim")
response.addCookie(cookie);
//读取cookie
Cookie[] cookies = request.getCookies();
for(Cookie c : cookies){
out.write(c.getName()+":"+c.getValue()+"<br/>");
}
```

有几个常用的方法：
void cookie.setMaxAge(int age) 设置生命周期(s)
int getMaxAge() 得到生命周期
