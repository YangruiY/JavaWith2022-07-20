package com.MuliThread_;

public class ThreadUsing01{

    /*

    通过继承 Thread 类创建线程


        当一个类继承了Thread的类，该类就可以当做线程使用，
        此时就需要重写run方法，并在该run()方法写上自己的业务代码，
        run Thread类实现了 Runnable 接口的 run 方法
            @Override
            public void run() {
                if (target != null) {
                    target.run();
                }
            }

     */
    public static void main(String[] args) throws InterruptedException {
        /*
        创建一个Dog对象用来当做线程使用
         */
        Dog dog = new Dog();
        //启动线程，最终执行的是 dog 的run方法
        dog.start();
        /*
            start()源码
            1. 执行
            public synchronized void start() {
                 try {
                    start0();
                    started = true;
                 }
            }
            2. 执行
             start0();
             PS：此处的 start0()方法是本地方法，是由JVM机调用实现的，底层是C/C++实现
                真正实现多线程的效果是start0()方法，而不是run

             private native void start0();


         */
        //run()就是一个普通的方法，并没有能够真正的达到多线程的效果，只有把run()执行完才会继续向下执行
        //dog.run();
        //当main线程启动一个子线程时，主线程并不会阻塞，而是继续执行
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+i);
            Thread.sleep(1000);
        }
    }
}

class Dog extends Thread{
    @Override
    public void run() {
        int i = 0;
       while(i < 80){
           //此处重写run方法，写上自己的业务逻辑
           System.out.println("汪汪汪汪~"+(i));
           //让线程睡眠1秒
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               System.out.println(e.getMessage());
           }
           i++;
       }

    }
}