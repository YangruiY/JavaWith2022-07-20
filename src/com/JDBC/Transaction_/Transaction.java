package com.JDBC.Transaction_;

import com.JDBC.JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC中使用事务
 */
public class Transaction {
    @Test  //未使用事务
   public void noTransaction(){
       // 1得到连接
       Connection connection = null;
       // 2组织sql
       String sql = "update account set balance = balance - 100 where id = 1";
       String sql1 = "update account set balance = balance + 100 where id = 2";

       // 3创建PreparedStatement 对象
       PreparedStatement preparedStatement = null;
       try {
           connection = JDBCUtils.getconnection();    // 默认情况下，connection 默认自动提交
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.executeUpdate();
           int i = 1/0; // 有异常
           preparedStatement = connection.prepareStatement(sql1);
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } finally {
           // 关闭资源
           JDBCUtils.close(null, preparedStatement, connection);
       }
   }
    @Test  //使用事务
    public void UseTransaction(){
        // 1得到连接
        Connection connection = null;
        // 2组织sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql1 = "update account set balance = balance + 100 where id = 5";

        // 3创建PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getconnection();    // 默认情况下，connection 默认自动提交
            //将connection 设置为不自动提交
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            //int i = 1/0; // 有异常
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            //回滚，撤销执行的sql
            //默认回滚事物开始状态
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
