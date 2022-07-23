package com.tenhomework;

public class one {
    public static void main(String[] args) {


    }
}
class Fork{
    public Fork() {
        serialNumber = getNextNum();
    }

    public static  int currentNum = 100000;
    public static  int getNextNum(){
        currentNum += 100;
        return currentNum;
    }
    private int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }
}
class TestFork{
    public static void main(String[] args) {
        //静态属性是所有值共享的，只会随类的加载加载一次
        System.out.println(Fork.getNextNum()); //100100
        System.out.println(Fork.getNextNum()); //100200
        Fork fork0 = new Fork();
        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        System.out.println(fork0.getNextNum()); //100600
        System.out.println(fork0.getSerialNumber()); //100300
        System.out.println(fork1.getNextNum()); //100700
        System.out.println(fork1.getSerialNumber()); //100400
        System.out.println(fork2.getNextNum()); //100800
        System.out.println(fork2.getSerialNumber()); //100500
    }
}

