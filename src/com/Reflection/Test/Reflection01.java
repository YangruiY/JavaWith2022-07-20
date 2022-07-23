package com.Reflection.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            m1();
            m2();
            m3();
    }
    //传统方法
    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1耗时是"+(end - start) + "ms");
    }
    //反射机制
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.Reflection.Test.Cat");
        Object o = aClass.newInstance();
        Method method = aClass.getMethod("hi");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {

            method.invoke(o);

        }
        long end = System.currentTimeMillis();
        System.out.println("m2耗时是"+(end - start)+"ms");
    }
    //反射调用优化 + 关闭访问检查
    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.Reflection.Test.Cat");
        Object o = aClass.newInstance();
        Method method = aClass.getMethod("hi");
        method.setAccessible(true);//在反射调用方法时，取消访问检查

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {

            method.invoke(o);

        }
        long end = System.currentTimeMillis();
        System.out.println("m3耗时是"+(end - start)+"ms");
    }

}