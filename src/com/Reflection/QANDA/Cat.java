package com.Reflection.QANDA;

class Cat{
    private String name = "猫猫";
    public int  age = 10;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi(){
        System.out.println("hi" + name);
    }
}
