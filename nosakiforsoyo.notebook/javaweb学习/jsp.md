## 2025.11.14
jsp是种前后端融合在一起的一种文件，本质还是servlet，不过已经被淘汰了。
就简单的学了一下，如下
### jsp表达式

有三种表达式
```
<%
System.out.println("这是用来写代码逻辑的");
%>
```
还有两种
```
<%!
String toHello(){
	return "这是用来写函数方法的"；
}
%>

<%
	String str = toHello();
%>
//这是用来输出对象到html页面的
<%=str%>
```

### jsp内置对象

内置九种对象，分别是

request:表示一次请求 类型为HttpServletRequest
response:表示一次响应，类型为HttpServletResponse
pageContext:页面上下文，获取页面信息，pageContext
session:表示一次回话，保存用户信息，HttpSession
application:表示当前web应用，全局对象，保存所有用户共享信息，ServletContext
config:获取当前servlet信息，ServletConfig
out:向浏览器输出数据，jspWriter
page:当前对应的servlet对象，相当于this，servlet
exception:表示当前jsp页面发生的异常，Execption

request常用：
		String getParameter(String key) 获取浏览器客户端传回值
		void setAttribute(String key,Object value) 通过键值对保存数据，可用于转发
		Object getAttribute(String key) 通过key取出value 
		RequestDispatcher get RequestDispatcher(String path) 返回一个对象，该对象的forword方法用于请求转发到其他的网址
		String[] getParameterValues()获取客户端传来的多个同名参数。
		void setCharacterEncoding(String charset) 指定请求的编码
response常用：
		response.getRedirect("/Path")重定向
session常用：
		String getId() 获取sessionid
		void setMaxinactiveInterval(int interval) 设置失效时间，单位为秒
		int getMaxInactiveInterval() 获取当前失效时间
		void invalidate()设置session立即失效
		
