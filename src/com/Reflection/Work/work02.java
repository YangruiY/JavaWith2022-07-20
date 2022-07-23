package com.Reflection.Work;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class work02 {
    public static void main(String[] args) throws Exception{
        //1 得到 File 的 Class 对象
        Class<?> aClass = Class.forName("java.io.File");
        //2 得到所有构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        //3 遍历输出
        for (Constructor declaredConstructor:declaredConstructors) {
            System.out.println("File 的构造器=" + declaredConstructor);
        }

        //4 创建File,指定得到 public java.io.File(java.lang.String)
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        String Fileallpath = "e:/reflect.txt";
        Object o = declaredConstructor.newInstance(Fileallpath);  //创建File对象 o
        System.out.println(o.getClass());  // o 的运行类型就是 File
        //5 创建文件的方法
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);

        System.out.println("创建成功" + Fileallpath);

    }
}
