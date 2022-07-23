package com.extend;

public class Student {
    public String name;
    private int score;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public  String info(){
        return "学生信息为:"+ "\t 姓名" + name + "" +
                "\t 年龄 " +age +  "\t 分数" + score;
    }
}
