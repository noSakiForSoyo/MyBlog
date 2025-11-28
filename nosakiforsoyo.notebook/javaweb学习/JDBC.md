### 2025.11.26
基本源码：
```
//建立连接
Class.forName("com.mysql.cj.jdbc.Driver");  
String url = "jdbc:mysql://localhost:3306/game";  
String user = "root";  
String password = "279289";  
Connection conn = DriverManager.getConnection(url, user, password);  
Statement stmt = conn.createStatement();  

//设定sql
String sql = "select * from player;";  

//开启事务
ResultSet count = stmt.executeQuery(sql);  
stmt.close();  
conn.close();
```

# JDBC的api
## DriverManager
1. DriverManager.getConnection(url,user,password)；获取连接
	传参时候url是一定的格式-->jdbc:mysql://域名:端口号/数据库名称
2. DriverManager.registerDriver(new Driver()); 注册驱动
## Connection
	
### 1. 获取执行sql的对象
	普通执行的对象
	createStateent();
	防sql注入的预编译执行sql信号
	preparedStatment(sql);
	执行存储过程的对象
	prepareCall(sql);
### 2. 事务管理
	开启事务
	setAutoCommit(false);	
	提交事务
	commit();
	回滚事务
	rollback();
	
	代码示例
```
前面建立连接与上文相同

try {  
    conn.setAutoCommit(false);  
    ResultSet rs = stmt.executeQuery(sql);  
    while (rs.next()) {  
        System.out.println(rs.getString(1)+" "+rs.getString(2));  
    }  
    conn.commit();  
} catch (Exception e) {  
    conn.rollback();  
    e.printStackTrace();  
}
```
## Statement
### 执行sql语句
	int executeUpdate(sql); 用于执行DML，DDL语句。返回值围为受影响的行数

	ResultSet executeQuery; 用于执行DQL语句。 返回值为查询结果ResultSet集合
## ResultSet
### 用于获取查询结果
	boolean next();将光标向前移动一格并且判断当前行是否有效

	xxx getxxx(第几位);返回xxx类型的参数-->Sting,int等等

	在使用结束后需要rs.close回收
## PreparedStatement
### 1. 预编译sql并执行sql语句
```
//sql中的参数使用？替代
//获取对象
String sql ="select * from player where name = ? and email = ?";
PreparedStatement p = conn.PreparedStatement(sql);
//设置对象填充？
p.setString(1, "Jim");  
p.setString(2, "212121212@qq.com");
```
	预编译功能开启，需要String url= "jdbc:mysql://localhost:3306/game?useServerPrepStmts=true";来开启功能

# 数据库连接池

	用于分配管理数据库连接connection
	标准接口为 dataSource
	使用连接池Druid