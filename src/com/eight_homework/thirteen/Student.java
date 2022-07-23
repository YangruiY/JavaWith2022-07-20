package com.eight_homework.thirteen;

public class Student extends Person {
    private String id;

    public void study(){
        System.out.println(getName()+"好好学习");
    }
    public  String play(){
        return super.play() + "足球";
    }
    public  void info(){
        System.out.println("学生的信息：");
        System.out.println(super.baseinfo());
        System.out.println(play());;
        study();
    }
    public Student(String name, char sex, int age, String id) {
        super(name, sex, age);
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                 super.toString() ;
    }
}
