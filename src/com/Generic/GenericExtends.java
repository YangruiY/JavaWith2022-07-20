package com.Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {
        Object o = new String("hello");

        //泛型没有继承性
        // List<Object> list = new ArrayList<String>();   错误的


        //下面方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);


            //printCollection2(list1); //false
            //printCollection2(list2); //false
            printCollection2(list3); //true
            printCollection2(list4); //true
            printCollection2(list5); //true

        printCollection3(list1);
        //printCollection3(list2); //false
        printCollection3(list3);
        //printCollection3(list4); //false
        //printCollection3(list5); //false

    }
    //方法



    //说明: List<?> 表示 任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object object : c) {
            // 通配符，取出时，就是 Object
            System.out.println(object);
        }
    }

    // ? extends AA 表示 上限，可以接受 AA 或者 AA 子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    // ? super 子类类名 AA:支持 AA 类以及 AA 类的父类，不限于直接父类,规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

}

class AA {

}

class BB extends AA {

}

class CC extends BB {

}