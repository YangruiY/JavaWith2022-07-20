package com.user;


import com.ry.edu.Person;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);//com.ry.edu.Person@4554617c
        com.yr.edu.Person person1 = new com.yr.edu.Person();    //带上包名
        System.out.println(person1);//com.yr.edu.Person@74a14482


    }
}
