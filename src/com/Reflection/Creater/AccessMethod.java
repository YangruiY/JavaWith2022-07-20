package com.Reflection.Creater;

import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 */
public class AccessMethod {
    public static void main(String[] args) throws Exception{
        //1 得到User类的Class对象
        Class<?> aClass = Class.forName("com.Reflection.Creater.Dog");
        //2 创建对象
        Object o = aClass.newInstance();
        System.out.println("o的运行类型" + o.getClass());
        System.out.println("=======");
        //3 调用public的hello()方法
        //Method hello = aClass.getMethod("hello");
        //3.1 得到hello()方法对象
        Method hello = aClass.getDeclaredMethod("hello",String.class);
        //3.2 调用
        hello.invoke(o,"cat");

        //调用 private static 的方法  要使用暴破
        Method hi = aClass.getDeclaredMethod("hi", int.class, String.class, char.class);
        hi.setAccessible(true);
        System.out.println(hi.invoke(o,23,"hihihi",'y'));
        System.out.println(hi.invoke(null, 34, "789789", 'n'));

        //在反射中，如果方法有返回值，统一返回Object
        Object n = hi.invoke(null, 34, "789789", 'n');
        System.out.println("n 运行类型" + n.getClass());  //运行类型和方法的返回类型是一样的

    }
}

class Dog{
    public int age;
    private static String password;

    public Dog() {
    }
    private static String hi(int n, String s,char ch){
        System.out.println("hi~");
        return "n=" + n + "s=" + s + "ch=" + ch;
    }
    public void hello(String s){
        System.out.println("dog hello world" + s);
    }

}