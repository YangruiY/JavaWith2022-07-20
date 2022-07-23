package com.Inner_Class;

//底层原码有大量的内部类
//匿名内部类！！！！！！！！！！！！

public class InnerClass {
    public static void main(String[] args) {

    }
}

class Outer{
    private  int i = 0;

    public Outer(int i) {
        this.i = i;
    }

    public void m(){
        System.out.println("m()");
    }
    //代码块
    {
        System.out.println("类里面的代码块");
    }

    //外部类Outer里面的内部类Inner
    class Inner{

    }
}