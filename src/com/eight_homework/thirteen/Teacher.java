package com.eight_homework.thirteen;

public class Teacher extends Person{

    private int wokeyear;

    public void teach(){
        System.out.println(getName()+"好好教学");
    }
    public  String  play(){
       return super.play() +"象棋";
    }

    public  void info(){
        System.out.println("老师的信息：");
        System.out.println(super.baseinfo());
        System.out.println(play());
        teach();
    }
    public Teacher(String name, char sex, int age, int wokeyear) {
        super(name, sex, age);
        this.wokeyear = wokeyear;
    }

    public int getWokeyear() {
        return wokeyear;
    }

    public void setWokeyear(int wokeyear) {
        this.wokeyear = wokeyear;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "wokeyear=" + wokeyear
                 +  super.toString() ;
    }
}
