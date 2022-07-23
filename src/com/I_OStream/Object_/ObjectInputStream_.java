package com.I_OStream.Object_;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

//反序列化
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception{
        //指定反序列化的文件
        String filepath = "e:/data.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath));

        //数据反序列化的顺序要和你保存数据序列化的顺序要一致，否则会发生异常
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());

        //dog的编译类型是Object，dog的运行类型是Dog
        Object dog =objectInputStream.readObject();
        System.out.println(dog.getClass());
        System.out.println(dog);

        /*
            特别重要的：
            1. 如果我们希望调用的是Dog方法，需要向下转型
            2. 需要将Dog类定义到可以引用的位置
         */
         Dog dog2 = (Dog)dog;
        System.out.println(dog2.getClass());
        objectInputStream.close();

    }
}
