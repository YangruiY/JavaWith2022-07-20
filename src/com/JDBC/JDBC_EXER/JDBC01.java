package com.JDBC.JDBC_EXER;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 简单操作
 */
public class JDBC01 {
    public static void main(String[] args) throws SQLException {
        //前置工作，在项目下创建文件夹 (libs) 将mysql.jar 拷贝到该目录下，点击add... 加入到此项目
        // 注册驱动
        Driver driver = new Driver();
        // 得到连接
        // (1) jdbc:mysql:// 规定好表示协议，通过 jdbc 的方式连接 mysql
        // (2) localhost 主机，可以是 ip 地址
        // (3) 3306 表示 mysql 监听的端口
        // (4) jdbc_exerice 连接到 mysql dbms 的哪个数据库
        // (5) mysql 的连接本质就是前面学过的 socket 连接
        String url = "jdbc:mysql://localhost:3306/jdbc_exercise";
        //将 用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url, properties);

        //前提工作
//        String sql = "insert into actor values (3,'刘德华','男','1970-11-11',123456789101)";
//        String sql1 = "update  actor set  name = '周星驰' where id = 2";
        String sql2 = "delete from  actor where id = 3";
        //创建statement 用于执行静态 SQL 语句并返回其生成的结果的对象,简单说创建 statement 就是 执行 sql 语句
        Statement statement = connect.createStatement();
        //如果是dml语句，返回的就是影响的行数
//        int rows = statement.executeUpdate(sql);
//        int rows1 = statement.executeUpdate(sql1);
        int rows2 = statement.executeUpdate(sql2);
//        System.out.println(rows>0?"成功添加":"失败添加");
//        System.out.println(rows1>0?"成功更新":"失败更新");
        System.out.println(rows2>0?"成功删除":"失败删除");
        // 执行sql
        statement.close();
        connect.close();


        // 关闭资源链接

    }
}
