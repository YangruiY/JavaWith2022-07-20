package com.JDBC.JDBC_Simulation;

public class Test {
    public static void main(String[] args) {
        JdbcInterface jdbcImplement = new JdbcImplement();
        jdbcImplement.getConnection(); //通过接口调用实现类[动态绑定]
        jdbcImplement.crud();
        jdbcImplement.close();

        JdbcInterface ojdbcImplement = new OralJdbcImplement();
        ojdbcImplement.getConnection(); //通过接口调用实现类[动态绑定]
        ojdbcImplement.crud();
        ojdbcImplement.close();

    }
}
