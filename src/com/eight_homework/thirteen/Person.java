package com.eight_homework.thirteen;

public class Person {
    protected String play;
    private  String name;
    private  char sex;
    private  int age;

    public String play(){
        return getName() + "爱玩";
    }
    public  String baseinfo(){
        return "姓名" + name + "\n" + "性别" + sex + "\n" +"年龄" + age ;
    }
    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "play='" + play + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
