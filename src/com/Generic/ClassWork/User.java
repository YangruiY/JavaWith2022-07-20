package com.Generic.ClassWork;

class User {
    private int age;
    private int id;
    private String name;

    @Override
    public String toString() {
        return "name='" + name +",age=" + age +", id=" + id +"\n";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }
}
