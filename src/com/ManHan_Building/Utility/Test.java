package com.ManHan_Building.Utility;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("输入一个整数");
        int i = Utility.readInt();
        System.out.println(i);


        Connection connection = DruidUtils.getConnection();
        System.out.println(connection);
    }
}
