package com.JDBC.JDBC_CONNECTION;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connection {
    public static void main(String[] args) throws Exception {
        connection01();
        connection02();
        connection03();
        connection04();
        connection05();
    }
    @Test
    public static void connection01() throws SQLException {
        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/jdbc_exercise";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式一 + "+connect);
    }
    @Test
    public static void connection02() throws  Exception {
        //使用反射加载Driver类,动态加载减少依赖性
        Class aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver =(Driver)aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/jdbc_exercise";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式二 + "+connect);
    }

    //使用DriverManager替换Driver
    @Test
    public static void connection03() throws  Exception {
        //使用反射加载Driver类,动态加载减少依赖性
        Class aClass1 = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver =(Driver)aClass1.newInstance();

        String url = "jdbc:mysql://localhost:3306/jdbc_exercise";
        String user = "root";
        String password = "root";
        DriverManager.registerDriver(driver); // 注册Driver驱动
        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println("方式三 + "+connect);
    }


    //使用Class.forName自动完成注册驱动-----------------------推荐使用
    @Test
    public static void connection04() throws  Exception {
        //使用反射加载Driver类,动态加载减少依赖性
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/jdbc_exercise";
        String user = "root";
        String password = "root";
        /*
        源码:
        1. 静态代码块，在类加载时，会执行一次.
        2. DriverManager.registerDriver(new Driver());
        3. 因此注册 driver 的工作已经完成
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        
        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println("方式四 + "+connect);
    }

    @Test
    public static void connection05() throws  Exception {
        //通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);// 可写可不写，建议写上
        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println("方式五 + "+connect);
    }

}
