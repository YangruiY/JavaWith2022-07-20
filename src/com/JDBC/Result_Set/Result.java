package com.JDBC.Result_Set;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * select 语句返回ResulrSet,并取出结果
 */
public class Result {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //注册驱动
        Class.forName(driver);// 可写可不写，建议写上
        //得到连接
        Connection connect = DriverManager.getConnection(url, user, password);
        //得到statement
        Statement statement = connect.createStatement();
        //组织sql
        String sql = "select id,name,sex,brondate from actor";
        //执行给定的 SQL 语句，该语句返回单个 ResultSet 对象
         /*
         +----+-----------+-----+---------------------+
         | id | name | sex | brondate |
         +----+-----------+-----+---------------------+-------+
         | 1 | 刘德华 | 男 | 1970-11-11|
         | 2 | 周星驰 | 男 | 1990-11-11|
         +----+-----------+-----+---------------------+-------+
         */

        //debug源码
        ResultSet resultSet = statement.executeQuery(sql);
        //循环取出数据
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" +
                    name + "\t" +
                    sex + "\t" +
                    date );

        }
        //关闭连接
        resultSet.close();
        statement.close();
        connect.close();

    }
}
