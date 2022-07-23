package com.Generic;

public class generic_ {
    public static void main(String[] args) {

        Person<String> person = new Person<>("ry");
        person.show();

        /*
        你可以这样理解，下面的 Person 类 中的所有E 就变成了String
        class Person {
            String s;//E 表示 s 的数据类型, 该数据类型在定义 Person 对象的时候指定,即在编译期间，就确定 E 是什么类型

            public Person(String s) {
                //E 也可以是参数类型 this.s = s;
            }

            public String f() {
                //返回类型使用
                E return s;
            }
        }
         */

        Person<Integer> Person = new Person<Integer>(2);
        Person.show();
    }
}

//泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型,或者是某个方法的返回值的类型，或者是参数类型
class Person<E> {
    //E 表示 s 的数据类型, 该数据类型在定义 Person 对象的时候指定,即在编译期间，就确定 E 是什么类型
    E name;

    //E 也可以是参数类型
    public Person(E name) {
        this.name = name;
    }

    //返回类型使用 E
    public E f() {
        return name;
    }
   public void show(){
       System.out.println(name.getClass());
    }
}