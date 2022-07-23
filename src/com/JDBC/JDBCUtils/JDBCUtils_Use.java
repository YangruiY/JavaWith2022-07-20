package com.JDBC.JDBCUtils;

import java.sql.*;

public class JDBCUtils_Use {
    public static void main(String[] args) {
        //testDML();
        testSelect();
    }

    public static void testDML() {  //update delete insert
        // 1得到连接
        Connection connection = null;
        // 2组织sql
        String sql = "update actor set name = ? where id = ?";
        // 3创建PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getconnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "彭于晏");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }

    }

    public static void testSelect() {  //select
        // 1得到连接
        Connection connection = null;

        // 2组织sql
        String sql = "select * from actor";
        // 3创建PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getconnection();
            //connection 的真实运行类型
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date brondate = resultSet.getDate("brondate");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t" +
                        name + "\t" +
                        sex + "\t" +
                        brondate + "\t" +
                        phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
