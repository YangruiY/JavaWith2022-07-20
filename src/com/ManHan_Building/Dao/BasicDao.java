package com.ManHan_Building.Dao;


import com.ManHan_Building.Utility.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

//其他dao的父类
public class BasicDao<T> {  //泛型指定具体类型
    QueryRunner queryRunner = new QueryRunner();

    //开发通用的dml方法
    public int update(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
            int update = queryRunner.update(connection, sql, parameters);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);  //将一个编译异常转换成运行时异常，并抛出
        }finally {

        }
    }
    /**
     *  @param sql sql 语句，可以有 ?
     *  @param cla 传入一个类的 Class 对象 比如 Actor.class
     *  @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据 Actor.class 返回对应的 ArrayList 集合
     */
    //针对任意一个表可以返回多个对象
    public List<T> queryMulti(String sql,Class<T> cla,Object... parameters){
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
           return queryRunner.query(connection,sql,new BeanListHandler<T>(cla),parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);  //将一个编译异常转换成运行时异常，并抛出
        }finally {
            DruidUtils.close(null,null,connection);
        }
    }
    //针对任意一个表可以返回单个对象
    public  T querySingle(String sql,Class<T> cla,Object... parameters){
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<T>(cla),parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);  //将一个编译异常转换成运行时异常，并抛出
        }finally {
            DruidUtils.close(null,null,connection);
        }
    }
    //针对任意一个表可以返回单个值
    public Object queryScalar(String sql,Class<T> cla,Object... parameters){
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler(),parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);  //将一个编译异常转换成运行时异常，并抛出
        }finally {
            DruidUtils.close(null,null,connection);
        }
    }
}
