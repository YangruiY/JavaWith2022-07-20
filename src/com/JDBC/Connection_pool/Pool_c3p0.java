package com.JDBC.Connection_pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Pool_c3p0 {

    @Test
    //方式1 相关参数在程序中指定user,url,password等
    public void testC3P0_01(){
        //创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //通过配置文件mysql.properties获取相关信息
        //定义相关的属性(4 个), 因为只需要一份，因此，我们做出 static
        String user; //用户名
        String password; //密码
        String url; //url
        String driver; //驱动名

        //static 代码块中进行初始化

            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream("src\\mysql.properties"));
                //读取相关的属性值
                user = properties.getProperty("user");
                password = properties.getProperty("password");
                url = properties.getProperty("url");
                driver = properties.getProperty("drivers");
                //给数据源 ComboPooledDataSource 设置相关参数
                comboPooledDataSource.setDriverClass(driver);
                comboPooledDataSource.setJdbcUrl(url);
                comboPooledDataSource.setUser(user);
                comboPooledDataSource.setPassword(password);

                //初始化连接数
                comboPooledDataSource.setInitialPoolSize(10);
                //最大连接数
                comboPooledDataSource.setMaxPoolSize(50);

                long start = System.currentTimeMillis();
                //测试连接池的连接效率
                for (int i = 0; i < 5000; i++) {

                Connection connection = comboPooledDataSource.getConnection();// 此方法就是从 Datasource 接口实现的
                connection.close();
                }
                long end =System.currentTimeMillis();
                System.out.println("c3p0 5000次 耗时" + (end - start));
            } catch (Exception e) {
                //在实际开发中，我们可以这样处理
                // 1. 将 编译异常 转成 运行异常
                // 2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
                throw new RuntimeException(e);
            }

        }



    //第二种方式 使用配置文件模板来完成
    // 1. 将 c3p0 提供的 c3p0.config.xml 拷贝到 src 目录下
    // 2. 该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("ryang");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0方式二耗时" + (end - start));
    }
}
