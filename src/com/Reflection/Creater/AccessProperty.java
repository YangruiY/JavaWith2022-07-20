package com.Reflection.Creater;

import java.lang.reflect.Field;

/**
 * 使用反射访问属性
 */
public class AccessProperty {
    public static void main(String[] args) throws Exception {
        //1 得到User类的Class对象
        Class<?> aClass = Class.forName("com.Reflection.Creater.Student");
        //2 创建对象
        Object o = aClass.newInstance();
        System.out.println("o的运行类型" + o.getClass());
        System.out.println("=======");
        //3 使用反射得到age 属性对象
        Field age = aClass.getField("age");
        age.set(o,98); // 通过反射设置操作属性
        System.out.println(o);
        System.out.println(age.get(o));

        Field password = aClass.getDeclaredField("password");
        //password为private，所以需要进行暴破
        password.setAccessible(true);
        password.set(o,"123456");
        System.out.println(o);
        System.out.println(password.get(o));

        Field name = aClass.getDeclaredField("name");
        //password为private，所以需要进行暴破
        name.setAccessible(true);
        name.set(null,"cat"); //因为name为static属性，所以o也可以为null ,只有静态才能这么用
        System.out.println(o);
        System.out.println(name.get(o));
        System.out.println("=====");
        System.out.println(name.get(null));//因为name为static属性，所以o也可以为null ,只有静态才能这么用
    }
}

class Student {
    public int age;
    private String password;
    private static  String name;

    public Student() {
    }

    public Student(int age, String password) {
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}