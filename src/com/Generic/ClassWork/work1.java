package com.Generic.ClassWork;

import org.junit.jupiter.api.Test;

import java.util.List;

public class work1 {
    public static void main(String[] args) {

    }
    @Test
    public void testList(){
        DAO<User> user = new DAO<>();
        user.save("001",new User(10,1001,"li"));
        user.save("002",new User(20,1002,"liu"));
        user.save("003",new User(30,1003,"san"));
        user.save("004",new User(40,1004,"shu"));

        List<User> list = user.list();
        System.out.println(list);

        user.update("001",new User(12,1001,"han"));
         list = user.list();
        System.out.println(list);

        user.delete("001");
        list = user.list();
        System.out.println(list);
        System.out.println(user.get("004"));
    }
}
