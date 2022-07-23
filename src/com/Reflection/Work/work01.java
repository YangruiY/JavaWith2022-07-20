package com.Reflection.Work;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class work01 {
    public static void main(String[] args) throws Exception{
        //1 得到PrivateTest类对应的Class对象
        Class<PrivateTest> privateTestClass = PrivateTest.class;
        //2 创建对象实例
        PrivateTest privateTest = privateTestClass.newInstance();
        //3 得到name属性的对象
        Field name = privateTestClass.getDeclaredField("name"); // name 是 private 的
        //4 暴破
        name.setAccessible(true);
        name.set(privateTest,"cat");
        //5 得到getName方法的对象
        Method getName = privateTestClass.getMethod("getName");
        //6 getName()是public的 无需暴破
        Object invoke = getName.invoke(privateTest);
        System.out.println("name的值为"+invoke);
    }
}
 class PrivateTest{
    private String name = "hellokitty";
    //默认无参构造器
    public String getName(){
        return name;
    }
}