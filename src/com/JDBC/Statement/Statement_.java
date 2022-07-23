package com.JDBC.Statement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Statement_ {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        //用户输入管理员密码和信息
        //  -- 输入用户名 为 [1' or]
        //      -- 输入万能密码 为 [or '1'= '1]  仍然可以成功
        System.out.println("输入名字");                //next(): 当接收到 空格或者 '(单引号)就是表示结束
        String admin_name = scanner.nextLine();    //如果希望看到 SQL 注入，这里需要用 nextLine，回车才算结束
        System.out.println("输入密码");
        String admin_pwd = scanner.nextLine();


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
        String sql = "select name,pwd from admin " +
                "where name = '"+ admin_name +" ' " +
                "and pwd = '"+ admin_pwd +" ' ";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(sql);
        if (resultSet.next()){ //如果查询到一条记录就说明登录成功
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }


        //关闭连接
        resultSet.close();
        statement.close();
        connect.close();
    }
}
