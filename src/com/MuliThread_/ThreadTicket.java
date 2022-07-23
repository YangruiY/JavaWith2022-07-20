package com.MuliThread_;

public class ThreadTicket {
    public static void main(String[] args) {
//        SellTicket sellTicket0 = new SellTicket();
//        SellTicket sellTicket1 = new SellTicket();
//        SellTicket sellTicket2 = new SellTicket();
//        sellTicket0.start();
//        sellTicket1.start();
//        sellTicket2.start();

//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();//第一个窗口
//        new Thread(sellTicket02).start();//第二个窗口
//        new Thread(sellTicket02).start();//第三个窗口
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第一个窗口
        new Thread(sellTicket03).start();//第二个窗口
        new Thread(sellTicket03).start();//第三个窗口
        /*
            错误写法,因为这里创建了三个新的new
            new Thread(new SellTicket03()).start();
            new Thread(new SellTicket03()).start();
            new Thread(new SellTicket03()).start();
         */
    }
}

class SellTicket extends Thread{
    private static  int  ticketnum = 100;

    @Override
    public void run() {
        while(true){
            if(ticketnum <= 0){
            System.out.println("无票~");
            break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("窗口" + Thread.currentThread().getName() +
                                "售出一张票，剩余票数为" + (--ticketnum));
        }
    }
}

class SellTicket02 implements Runnable{
    private static  int  ticketnum = 100;

    @Override
    public void run() {
        while(true){
            if(ticketnum <= 0){
                System.out.println("无票~");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("窗口" + Thread.currentThread().getName() +
                    "售出一张票，剩余票数为" + (--ticketnum));
        }
    }
}

class SellTicket03 implements Runnable{
    private boolean loop = true; //控制变量，控制run方法
    private int  ticketnum = 100;
    Object obj = new Object();


    /*
        1. public synchronized void sync() {} 就是一个同步方法
        2. 这时锁在 this 对象
        3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在 this 对象
        4. public synchronized static void m1() {} 锁是加在 SellTicket03.class
        5. 如果在静态方法中，实现一个同步代码块. 写法如下：
            synchronized (SellTicket03.class) {
                 System.out.println("m2");
            }
         6. 使用 extends Thread 方式创建线程
             new SellTicket01().start(); 新创建一个对象
             new SellTicket01().start(); 又新创建一个对象
             new ......
                class SellTicket01 extends Thread {
                    private static int ticketNum = 100;//让多个线程共享 ticketNum
                         public void m1() {
     // this 需要是同一个对象，但是上面创建了多个对象，所以是锁不住的,就和main里面的错误写法一样
                              synchronized (this) {
                                  System.out.println("hello");
                              }
                  }
     */
    public  /*synchronized*/ void sync(){

     synchronized (/*this*/ obj /* new Object()也是不能满足同步的*/){
         if(ticketnum <= 0){
             System.out.println("无票~");
             loop =false;
             return;
         }

         try {
             Thread.sleep(10);
         } catch (InterruptedException e) {
             e.getMessage();
         }

         System.out.println("窗口" + Thread.currentThread().getName() +
                 "售出一张票,剩余票数为" + (--ticketnum));
     }
    }

    @Override
    //同步方法，即在同一时刻只有一个线程执行一个run()方法
    public void run() {
        while(loop){
            sync();
//            if(ticketnum == 0){
//                break;
//            }
        }
    }
}