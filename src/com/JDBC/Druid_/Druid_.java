package com.JDBC.Druid_;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    @Test
    public void druid() throws Exception{
        // 1. 加入 Druid jar 包
        // 2. 加入 配置文件 druid.properties , 将该文件拷贝项目的 src 目录
        // 3. 创建 Properties 对象, 读取配置文件
         Properties properties = new Properties();
         properties.load(new FileInputStream("src\\druid.properties"));

        //4. 创建一个指定参数的数据库连接池, Druid 连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Druid 方式总共耗时：" + (end - start));
    }
}
