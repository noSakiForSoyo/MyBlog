### 2025.11.9
java内部自带的用于与客户端通信的组件。
可以创建并返回基于客户请求的动态html页面，也可以与数据库进行通信。
使用前在pom.xml里面加javax.servlet依赖。
之后可以implements接口并实现五个方法：{
init():初始化
getservletConfig():获取servlet信息
service():进行的逻辑操作
getServletInfo():返回读取信息
destory():销毁
}

之后可以在web.xml里面使用<servlet>和<servlet-mapping>对java文件进行映射来使其可被使用
```
<servlet>  
    <servlet-name>MyServlet</servlet-name>  
    <servlet-class>com.nosakiforsoyo.servlet.MyServlet</servlet-class>  
</servlet>  
  
<servlet-mapping>  
    <servlet-name>MyServlet</servlet-name>  
    <url-pattern>/myServlet</url-pattern>  
</servlet-mapping>
```