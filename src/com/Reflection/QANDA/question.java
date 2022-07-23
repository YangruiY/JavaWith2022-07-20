package com.Reflection.QANDA;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class question {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /*
        传统方法： new对象 + 调用方法
         */
        Cat cat = new Cat();
        cat.hi();

        //引入
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com\\Reflection/QANDA\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + method);

        //产生问题
        //new clsaafullpath()   clsaafullpath是String的变量，不是类名

        //解决
        //(1) 加载类，返回class类型的对象
        Class aClass = Class.forName(classfullpath);
        //(2)通过aClass 得到加载的类 com.ry.Cat 的对象实例
        Object o = aClass.newInstance();
        System.out.println("o是"+ o);
        System.out.println("o类型是"+o.getClass());
        //(3)通过 aClass 得到你加载的类 com.ry.Cat 的 method的 "hi" 的方法对象,反射中将方法也视为对象
        Method method1 = aClass.getMethod(method);
        System.out.println("method1 =" + method1);
        //(4) 通过 method1 方法对象来实现 方法调用
        method1.invoke(o);   //传统 对象.方法     反射：方法.invoke()


        //续
        //getField得不到私有变量,必须为 public 的变量
        Field age = aClass.getField("age");
        System.out.println("age的类"+age);
        // PS : 原： 对象.成员变量     现:(反射) 成员变量对象.get(对象)
        System.out.println("age"+age.get(o));

        //无参构造器
        Constructor constructor = aClass.getConstructor(); //() 中可以指定构造器类型
        System.out.println("constructor的类" + constructor);

        // 有参构造器
        Constructor constructor1 = aClass.getConstructor(String.class,int.class);
        System.out.println("constructor1的类" + constructor1);

    }
}


