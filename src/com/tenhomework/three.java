package com.tenhomework;


public class three {
    public static void main(String[] args) {
        //此处的问题就是，产生了新的对象(new了一个新的对象使后面的getXXXX方法没用到)，浪费了传入的交通工具
        Person person = new Person("唐", new Horse());
        person.passload();
        person.passRevier();
        person.passload();
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("一般使用马");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("过河使用船");
    }
}

class Factory {

    //马为同一匹
    private static Horse horse = new Horse();

    private Factory() {

    }

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //封装具体要求为方法
    public void passRevier() {
        //判断当前Vehicle属性是否已经存在
        //判断当前的vehicles是否为Boat，
        // if vehicles =null,则(vehicles instanceof Boat)=false
        // if vehicles =horse(),则(vehicles instanceof Boat)=false
        // if vehicles =Boat(),则(vehicles instanceof Boat)=true
        if (!(vehicles instanceof Boat)) {
            //多态
            //Boat boat = Factory.getBoat();
            //  boat.work();   或者写为
            vehicles = Factory.getBoat();
        }
        //体现接口调用
        vehicles.work();
    }

    public void passload() {
        if (!(vehicles instanceof Horse)) {
            vehicles = Factory.getHorse();
        }
        vehicles.work();
    }
}
