package com.JDBC.JDBC_Simulation;

public class OralJdbcImplement implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("oracle 连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成对 oracle 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 oracle 连接");
    }

}
