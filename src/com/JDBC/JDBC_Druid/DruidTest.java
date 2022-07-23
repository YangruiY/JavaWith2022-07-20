package com.JDBC.JDBC_Druid;

import com.JDBC.Dao.domain.Actor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DruidTest {

    public static void main(String[] args) {
        testSelectToArrayList();
    }

    //使用原始方法将 ResultSet ==> 封装到 ArrayList
    public static ArrayList testSelectToArrayList() {  //select
        System.out.println("使用druid方式");
        // 1得到连接
        Connection connection = null;

        // 2组织sql
        String sql = "select * from actor";
        // 3创建PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Actor> arrayList = new ArrayList<>();
        try {
            connection = DruidUtils.getConnection();
            //connection 的真实运行类型
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date brondate = resultSet.getDate("brondate");
                String phone = resultSet.getString("phone");
//                System.out.println(id + "\t" +
//                        name + "\t" +
//                        sex + "\t" +
//                        brondate + "\t" +
//                        phone);
                // 把得到的 resultset 的记录封装到Actor 对象，放入到 list 集合
                arrayList.add(new Actor(id,name,sex,brondate,phone));
            }
            System.out.println("arraylist 的数据为" + arrayList );
            for (Actor actor:arrayList) {
                System.out.println("id =" + actor.getId() + " \t" + actor.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            DruidUtils.close(resultSet, preparedStatement, connection);
        }
        //因为 ArrayList 和 connection 没有任何关联，所以该集合可以复用
        return arrayList;
    }
//    public static void testSelect() {  //select
//        System.out.println("使用druid方式");
//        // 1得到连接
//        Connection connection = null;
//
//        // 2组织sql
//        String sql = "select * from actor";
//        // 3创建PreparedStatement 对象
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DruidUtils.getConnection();
//            //connection 的真实运行类型
//            System.out.println(connection.getClass());
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String sex = resultSet.getString("sex");
//                Date brondate = resultSet.getDate("brondate");
//                String phone = resultSet.getString("phone");
//                System.out.println(id + "\t" +
//                        name + "\t" +
//                        sex + "\t" +
//                        brondate + "\t" +
//                        phone);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            // 关闭资源
//            DruidUtils.close(resultSet, preparedStatement, connection);
//        }
//    }
}
