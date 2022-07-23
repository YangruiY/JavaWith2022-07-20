package com.Collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Coll_Method {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // 1. 集合主要是两组(单列集合 , 双列集合)
        // 2. Collection 接口有两个重要的子接口 List Set , 他们的实现子类都是单列集合
        // 3. Map 接口的实现子类 是双列集合，存放的 K-V

        //Collection 接口方法
        //添加
        List list = new ArrayList();
        list.add("1");
        list.add(12);
        list.add(true);
        System.out.println(list);  //[1, 12, true]

        //删除
        list.remove(1);
        System.out.println(list); //[1, true]
        list.remove("1");
        System.out.println(list); //[true]

        // contains:查找元素是否存在
        // size:获取元素个数
        // isEmpty:判断是否为空
        // clear:清空
        // addAll:添加多个元素
        // containsAll:查找多个元素是否都存在
        // removeAll：删除多个元素



        // Collection 接口遍历元素方式
        // 1-使用 Iterator(迭代器)
        Collection col = new ArrayList();
        Iterator iterator = col.iterator();

        // 显示所有的快捷键的的快捷键 ctrl + j
        // 迭代器里面：快速生成 while => itit + 回车
        while (iterator.hasNext()) {
            Object next =  iterator.next();

        }

        // Collection 接口遍历对象方式
        // 2-for 循环增强

        // 使用增强的 for 循环 ,快捷键 I
        // 增强的for循环
//形如：        for (Object o :) {
//
//        }





        //两种循环遍历
        /*
        1 使用迭代器

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
        Object dog = iterator.next();
        System.out.println("dog=" + dog);
            }
        2 使用 增强的for循环

        for (Object dog : list) {
        System.out.println("dog=" + dog);
        }
         */

        /*
        List 接口的常用方法

        void add(int index, Object ele):在 index 位置插入 ele 元素
        eg: list.add(1, "韩顺平");

        boolean addAll(int index, Collection eles):从 index 位置开始将 eles 中的所有元素添加进来

        Object get(int index):获取指定 index 位置的元素

        int indexOf(Object obj):返回 obj 在集合中首次出现的位置

        int lastIndexOf(Object obj):返回 obj 在当前集合中末次出现的位置

        Object remove(int index):移除指定 index 位置的元素，并返回此元素

        Object set(int index, Object ele):设置指定 index 位置的元素为 ele , 相当于是替换.

        List subList(int fromIndex, int toIndex):返回从 fromIndex 到 toIndex 位置的子集合
        注意返回的子集合 fromIndex <= subList < toIndex





        */


    }
}
