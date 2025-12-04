# 2025.11.30
在**请求到达之前**和**客户端响应之后**进行统一拦截处理
### 使用方法
	可以基于注解来绑定网页
	@webFilter(filterName = "test",urlPatterns = "/*");
	在使用时需要 implements Filter
	需要实现三个方法
```
//初始化，只执行一次
@Override  
public void init(FilterConfig filterConfig) throws ServletException {  
  
}  
//每次请求都会触发
@Override  
public void doFilter(ServletRequest servletRequest
, ServletResponse servletResponse
, FilterChain filterChain) throws IOException, ServletException {  
  
}  
  
@Override  
public void destroy() {  
  
}
```

### 主要逻辑
	通过dofilter()来进行主要的拦截操作
	当满足一定逻辑时候直接return来禁止访问。反之则
	filterChain.doFilter(servletRequest,servletResponse);进行放行

# 2025.12.4
## listener
	用于监听事件启动和销毁
	存在三个事件监听器接口：
		ServletContextListener 应用级别
		HttpSessionListener 会话级别
		ServletRequestListener 请求级别
```
//启动时会执行
@Override  
public void contextInitialized(ServletContextEvent servletContextEvent) {  
      
}  
//销毁时执行
@Override  
public void contextDestroyed(ServletContextEvent servletContextEvent) {  
  
}
```