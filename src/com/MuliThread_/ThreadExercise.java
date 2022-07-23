package com.MuliThread_;

public class ThreadExercise {
    public static void main(String[] args) throws InterruptedException {
        Son son = new Son();
        Thread thread = new Thread(son);
        thread.start();
        for (int i = 1; i < 11; i++) {
            System.out.println("hi"+ i);
            if(i == 5){
                thread.join(); //son子进程加入到主进程，插队
            }
        }
        Thread.sleep(1000);
    }
}
class Son implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("hello" + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}