package com.Reflection.Creater;

import java.lang.reflect.Constructor;

/**
 * 通过反射机制创建实例对象
 */
public class CreatObject{
    /*
    1.方式一:调用类中的public修饰的无参构造器
    2.方式二:调用类中的指定构造器
    3. Class类相关方法
        newInstance :调用类中的无参构造器，获取对应类的对象
        getConstructor(Cas..clazz):根据参数列表，获取对应的public构造器对象
        getDecalaredConstructor(Clas..clazz):根据参数列表，获取对应的所有构造器对象
    4. Constructor类相关方法
        setAccessible:暴破
        newlnstance(Objct..obj):调用构造器

     */

    public static void main(String[] args) throws Exception {

        //1 得到User类的Class对象
        Class<?> aClass = Class.forName("com.Reflection.Creater.User");
        //2 通过public的无参构造器创建实例
        Object o = aClass.newInstance();
        System.out.println("o="+o);
        //3 通过public的有参构造器创建实例

                /*
                constructor 对象就是
                public User(int age, String name) {
                    this.age = age;
                    this.name = name;
                }
                 */
        Constructor<?> constructor = aClass.getConstructor(int.class,String.class);
        Object cat = constructor.newInstance(5,"cat");
        System.out.println("dog="+cat);
        //4 通过非public的有参构造器创建实例
        //4.1 得到私有类型的构造器 private
        Constructor<?> constructor1 = aClass.getDeclaredConstructor(String.class);
        //4.2 创建实例
        constructor1.setAccessible(true); //暴破，即其可使用反射可以访问private的构造器
        Object pig = constructor1.newInstance("pig");
        System.out.println("pig="+pig);
    }
}
class User{
    private int age = 10;
    private String name = "dog";
    public User(){

    }

    private User(String name) {
        this.name = name;
    }


    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}