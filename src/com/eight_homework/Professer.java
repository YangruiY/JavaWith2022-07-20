package com.eight_homework;

public class Professer extends  Teacher{
    public Professer(String name, int age, String post, double salary, double level) {
        super(name, age, post, salary, level);
    }
    public  void introduct(){
        System.out.println("教授信息");
        super.introduct();
    }
}
