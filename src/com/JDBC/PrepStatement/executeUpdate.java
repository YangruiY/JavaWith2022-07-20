package com.JDBC.PrepStatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class executeUpdate {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        //用户输入管理员密码和信息
        //  -- 输入用户名 为 [1' or]
        //      -- 输入万能密码 为 [or '1'= '1]  仍然可以成功
        System.out.println("输入名字");                //next(): 当接收到 空格或者 '(单引号)就是表示结束
        String admin_name = scanner.nextLine();    //如果希望看到 SQL 注入，这里需要用 nextLine，回车才算结束
//        System.out.println("输入密码");
//        String admin_pwd = scanner.nextLine();


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
        //组织sql sql 语句的 ? 就相当于占位符
        String sql = "insert into admin values(?,?) ";
        String update = "update  admin set pwd = ? where name = ? ";
        String delete = "delete from admin where name = ? ";
        //PrepareStatement 对象实现了 PrepareStatement 接口的实现类对象
        //PreparedStatement preparedStatement = connect.prepareStatement(sql);  //此处已经处理sql
        //PreparedStatement preparedStatement = connect.prepareStatement(update);  //此处已经处理 update
        PreparedStatement preparedStatement = connect.prepareStatement(delete);  //此处已经处理 update

        //给 ? 赋值
        //preparedStatement.setString(1,admin_pwd);
        preparedStatement.setString(1,admin_name);
        //执行 select 语句使用 executeQuery
        //如果执行的是dml(update, insert, delete) executeUpdate()
        //这里执行executeQuery的时候 不要在写sql，因为上面 prepareStatement 已经执行过了
        int rows = preparedStatement.executeUpdate();
        //System.out.println(update);
        if (rows > 0){ //如果查询到一条记录就说明登录成功
            System.out.println("执行成功");
        }else{
            System.out.println("执行失败");
        }


        //关闭连接

        preparedStatement.close();
        connect.close();
    }
}
