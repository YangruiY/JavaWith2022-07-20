package com.eight_homework;


public class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;
    private double level;

    public Teacher(String name, int age, String post, double salary, double level) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.level = level;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public void introduct() {
        System.out.println("Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", level=" + level +
                '}');
    }
}