package com.I_OStream.Work_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class work3_ {
    public static void main(String[] args) throws IOException {
        String filepath = "src\\com\\I_OStream\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filepath));
        properties.list(System.out);
        String  name = properties.get("name") + " ";   //Object -> String
        int age = Integer.parseInt(properties.get("age")+ "");//Object -> int
        String color = properties.get("color") + " ";

        Dog dog = new Dog(name, age, color);
        System.out.println("=======");
        System.out.println(dog);

        //创建Dog对象序列化到dog.dat文件
        String serfilepath = "e:\\Dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serfilepath));
        objectOutputStream.writeObject(new Dog("jack",6,"red"));
        objectOutputStream.close();
        System.out.println("Dog对象序列化完成");



    }


    //反序列化
    @Test
    public void m1() throws Exception{
        String userfilepath = "e:\\Dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(userfilepath));
        Dog dog1 = (Dog)objectInputStream.readObject();

        System.out.println("反序列化结果为\n");
        System.out.println(dog1);

        //关闭流
        objectInputStream.close();
    }
}
 class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

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

     public String getColor() {
         return color;
     }

     public void setColor(String color) {
         this.color = color;
     }

     public Dog(String name, int age, String color) {
         this.name = name;
         this.age = age;
         this.color = color;
     }

     @Override
     public String toString() {
         return "Dog{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", color='" + color + '\'' +
                 '}';
     }
 }