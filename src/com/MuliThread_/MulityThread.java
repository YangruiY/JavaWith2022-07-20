package com.MuliThread_;

public class MulityThread {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread01);
        Thread thread1 = new Thread(thread02);
        thread.start();
        thread1.start();

    }
}

class Thread01 implements Runnable{
    int count = 0;


    @Override
    public void run() {
        while(true){
            System.out.println("123123" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            if (count == 5)
                break;
        }
    }
}

class Thread02 implements Runnable{
    int count = 0;


    @Override
    public void run() {
        while(true){
            System.out.println("456456" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            if (count == 8)
                break;
        }
    }
}