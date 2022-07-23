package com.override_;

public class OverrideTest {
    public static void main(String[] args) {
        Person jack = new Person("jack", 10);
        System.out.println(jack.say());

        Student smitch = new Student("smitch", 20,"123455",97.7);
        System.out.println(smitch.say());

    }
}
