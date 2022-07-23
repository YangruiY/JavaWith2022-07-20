package com.JDBC.Dao.test;

import com.JDBC.Dao.dao.ActorDao;
import com.JDBC.Dao.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDao {
    @Test
    //测试ActorDao 对 actor 表 crud操作


    public void testactorDao(){
        ActorDao actorDao = new ActorDao();
        // 查询

        // 多行操作
        List<Actor> actors = actorDao.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("show time mulity");
        for (Actor actor:actors) {
            System.out.print(actor);
        }
        //单行操作
        Actor actor = actorDao.querySingle("select * from actor where id = ?", Actor.class, 1);
        System.out.println("show time single");
        System.out.print(actor);

        //单行单列操作
        Object obj = actorDao.queryScalar("select name from actor where id = ?", Actor.class, 1);
        System.out.println("show time Single&&Single");
        System.out.print(obj);

        //dml语句
        int update = actorDao.update("insert into actor values(null,?,?,?,?)","张无忌","男","1999-11-12","777777777");
        System.out.println("insert");
        System.out.println(update > 0 ? "执行成功": "执行失败");

    }



}
