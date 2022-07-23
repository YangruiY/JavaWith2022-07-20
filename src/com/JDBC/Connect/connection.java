package com.JDBC.Connect;

import com.JDBC.JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class connection {
    @Test
    public void testCon(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //传统方式
            Connection connection = JDBCUtils.getconnection();
            //sql操作
            //......
            //关闭
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式总共耗时：" + (end - start));
    }
}
