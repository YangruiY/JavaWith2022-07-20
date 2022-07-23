package com.JDBC.JDBC_Simulation;

public class JdbcImplement implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("mysql 连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 连接");
    }
}
