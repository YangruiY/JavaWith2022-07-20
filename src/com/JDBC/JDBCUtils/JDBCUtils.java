package com.JDBC.JDBCUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //定义相关的属性(4 个), 因为只需要一份，因此，我们做出 static
    private static String user; //用户名
    private static String password; //密码
    private static String url; //url
    private static String driver; //驱动名

    //static 代码块中进行初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取相关的属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("drivers");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            // 1. 将 编译异常 转成 运行异常
            // 2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }
    //连接数据库, 返回 Connection
    public static Connection getconnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        关闭相关资源
        1. ResultSet 结果集
        2. Statement 或者 PreparedStatement
        3. Connection
        4. 如果需要关闭资源，就传入对象，否则传入 null
     */
    // 将引用断掉，将使用的连接重新放会连接池
     public static void close(ResultSet resultSet, Statement statement,Connection connection){
         //判断是否为空
         try {
             if (resultSet != null){
                 resultSet.close();
             }
             if (statement != null){
                 statement.close();
             }
             if (connection != null){
                 connection.close();
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
}
