package com.JDBC.ApDBUtils;


import com.JDBC.Dao.domain.Actor;
import com.JDBC.JDBC_Druid.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class ApDBUtils_Use {

    @Test
    // 使用 Apache-DBUtils 工具类 + Druid 实现对表的CRUD操作
    public void testQueryMany() throws Exception {
        //得到连接(连接druid)
        Connection connection = DruidUtils.getConnection();
        //使用 DBUtils 相关的类和接口,先引入 DBUtils 相关的 jar , 加入到本 Project,创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();  // queryRunner 就可以执行相关的方法，返回 ArrayList 结果集
        String sql = "select id, name from actor where id >= ?";
        /*
             (1) query 方法就是执行 sql 语句，得到 resultset 封装到  ArrayList 集合中
             (2) 返回集合
             (3) connection: 连接
             (4) sql : 执行的 sql 语句
             (5) new BeanListHandler<>(Actor.class): 在将 resultset 取出来放到 Actor 对象 再封装到 ArrayList
              底层使用反射机制 去获取 Actor 类的属性，然后进行封装
             (6) 下面的1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数 Object... params
             (7) 底层得到的 resultset ,会在底层 query方法 关闭, 并且关闭 PreparedStatment,所以下面的都是 null
         */




        /*
            queryRunner.query源码
             public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
                PreparedStatement stmt = null; //定义 PreparedStatement
                ResultSet rs = null; //接收返回的 ResultSet
                Object result = null;//返回 ArrayList

                try {
                    stmt = this.prepareStatement(conn, sql);//创建 PreparedStatement
                    this.fillStatement(stmt, params);//对 sql 进行 ? 赋值
                    rs = this.wrap(stmt.executeQuery());//执行 sql,返回 resultset
                    result = rsh.handle(rs); //返回的 resultset封装到arrayList[result] [使用到反射，对传入 class 对象 处理]
                } catch (SQLException var33) {
                    this.rethrow(var33, sql, params);
                } finally {
                    try {
                        this.close(rs);  //关闭 resultset
                    } finally {
                        this.close((Statement)stmt); //关闭 preparedstatement 对象
                    }
                }

                return result;
            }

         */
        List<Actor> query =
                //返回的是多个对象 就是 BeanListHandler
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        for (Actor actor:query) {
            System.out.print(actor);
        }

        //释放资源
        DruidUtils.close(null,null,connection);

    }
    @Test
    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    public void testQuerysingle() throws Exception{
        //得到连接(连接druid)
        Connection connection = DruidUtils.getConnection();
        //使用 DBUtils 相关的类和接口,先引入 DBUtils 相关的 jar , 加入到本 Project,创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();  // queryRunner 就可以执行相关的方法，返回单个对象
        String sql = "select id, name from actor where id >= ?";
        //因为我们返回的单行记录 对应的就是 单个对象 , 使用的 Hander 就是 BeanHandle
        Actor query = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(query);

        //释放资源
        DruidUtils.close(null,null,connection);
    }
    @Test
    //演示 apache-dbutils + druid 完成查询结果是单行单列-返回的就是 object
    public void testQueryScalar() throws Exception {
        //得到连接(连接druid)
        Connection connection = DruidUtils.getConnection();
        //使用 DBUtils 相关的类和接口,先引入 DBUtils 相关的 jar , 加入到本 Project,创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();  // queryRunner 就可以执行相关的方法，返回单个对象
        String sql = "select name from actor where id >= ?";

        //因为我们返回的单行单列记录 使用的 Hander 就是 ScalarHandler
        Object obj= queryRunner.query(connection, sql, new ScalarHandler(), 2);
        System.out.println(obj);

        //释放资源
        DruidUtils.close(null,null,connection);
    }
    @Test
    //演示 apache-dbutils + druid 完成查询结果是DML(update, insert ,delete)
    public void testDml() throws Exception{
        //得到连接(连接druid)
        Connection connection = DruidUtils.getConnection();
        //使用 DBUtils 相关的类和接口,先引入 DBUtils 相关的 jar , 加入到本 Project,创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();  // queryRunner 就可以执行相关的方法，返回单个对象

        //组织SQL语句，完成 update, insert ,delete
        //String sql = "update actor set name = ? where id = ?";
        String sql1 = "insert into  actor values(null,?,?,?,?)";
        String sql2 = "delete from actor where id = ?";
        //int affectRow = queryRunner.update(connection, sql, "张师傅", 1);
        //int affectRow1 = queryRunner.update(connection, sql1,"王师傅","男","1996-10-12",1234568789);
        int affectRow2 = queryRunner.update(connection, sql2,2);

        System.out.println(affectRow2 > 0 ?"执行成功":"执行失败");

        //释放资源
        DruidUtils.close(null,null,connection);

    }
}
