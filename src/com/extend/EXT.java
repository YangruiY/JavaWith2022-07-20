package com.extend;

public class EXT {
    public static void main(String[] args) {
        pupil pupil = new pupil();
        pupil.name = "小明";
        pupil.setAge(11);
        pupil.setScore(66);
        System.out.println(pupil.show());
        System.out.println(pupil.info());
        System.out.println("=============");

        Graduate graduate = new Graduate();
        graduate.name = "大明";
        graduate.setAge(23);
        graduate.setScore(98);
        System.out.println(graduate.show());
        System.out.println(graduate.info());
    }
}
