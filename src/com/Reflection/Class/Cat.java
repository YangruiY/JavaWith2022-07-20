package com.Reflection.Class;

public class Cat {
    public String name = "英短猫";
    public int age = 5;
    public int price = 2000;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}
