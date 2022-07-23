package com.JDBC.Dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource dataSource;

    //静态代码块完成 dataSource 的初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getConnection 的连接方法
    public static Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }

    //关闭连接,在数据库连接池技术中，close 不是真的断掉连接,而是把使用的 Connection 对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        //判断是否为空
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();         //connection 本质是接口
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
