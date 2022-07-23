package com.I_OStream.Object_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//序列化

public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception{

        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filepath = "e:\\data.dat";


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
        //序列化数据到data.dat里面
        objectOutputStream.writeInt(100);// int -> Integer (实现了 Serializable)
        objectOutputStream.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        objectOutputStream.writeChar('a');// char -> Character (实现了 Serializable)
        objectOutputStream.writeDouble(9.56);//double -> Double (实现了 Serializable)
        objectOutputStream.writeUTF("ryhello汉");//String

        //保存Dog对象
        objectOutputStream.writeObject(new Dog("旺财",18));

        //关闭流
        objectOutputStream.close();
        System.out.println("数据以序列化形式保存结束");


    }
}

class Dog implements Serializable{
    private String name;
    private int age;

    //序列化的版本号，可以提高兼容性
    private static final long  serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}