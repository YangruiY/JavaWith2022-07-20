package com.eight_homework;

public class eight {
    public static void main(String[] args) {

        //排序题
//        pereon[] pereon = new pereon[3];
//        pereon[0] = new pereon("jack",40,"java");
//        pereon[1] = new pereon("tom",23,"bigdata");
//        pereon[2] = new pereon("smich",34,"cpp");
//        System.out.println("排序前的效果：");
//        for (int i = 0; i < pereon.length; i++) {
//            System.out.println(pereon[i]);
//        }
//        //冒泡排序
//        pereon tmp = null;
//        for (int i = 0; i < pereon.length; i++) {
//            for (int j = 0; j < pereon.length-1-i; j++) {
//                //if(person[i].getAge() <person[i+1].getAge() )
//                if(pereon[i].getName().length() < pereon[i+1].getName().length()){
//                    tmp = pereon[i];
//                    pereon[i] = pereon[i+1];
//                    pereon[i+1] = tmp;
//
//                }
//            }
//
//        }
//        System.out.println("排序后的效果：");
//        for (int i = 0; i < pereon.length; i++) {
//            System.out.println(pereon[i]);
//        }




    }
}

class pereon{
    private String name;
    private int age;
    private String job;

    public pereon(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "pereon{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}

