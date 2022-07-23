package com.Collection_;

import java.util.HashSet;
import java.util.Objects;

public class HashSet_Exercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employ("ry",18));
        hashSet.add(new Employ("ry",28));
        hashSet.add(new Employ("ry",28));//一旦重写了hashcode和equals方法，就不能添加了
        System.out.println(hashSet);
    }
}

class Employ{
    private String name;
    private int age;

    public Employ(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return age == employ.age &&
                Objects.equals(name, employ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}