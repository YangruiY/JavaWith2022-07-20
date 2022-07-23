package com.Inner_Class;

public class AnonyInnerClass_ {
    public static void main(String[] args) {
        phone phone = new phone();
        phone.alarm(new IB(){
            @Override
            public void ring() {
                System.out.println("懒猪起床啦");
            }
        });
        phone.alarm(new IB(){
            @Override
            public void ring() {
                System.out.println("懒猪上课啦");
            }
        });
        phone.alarm(new IB(){
            @Override
            public void ring() {
                System.out.println("懒猪吃饭啦");
            }
        });
        phone.alarm(new IB(){
            @Override
            public void ring() {
                System.out.println("懒猪睡觉啦");
            }
        });

    }
}

interface IB{
    void ring();
}
class phone{
    public void alarm(IB ib){
        ib.ring(); //动态绑定机制
    }
}
