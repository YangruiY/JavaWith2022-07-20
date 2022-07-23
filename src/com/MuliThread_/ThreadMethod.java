package com.MuliThread_;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
       /* Th th = new Th();
        th.setName("hh");
        th.setPriority(Thread.MIN_PRIORITY);
        th.start();
        System.out.println(th.getName());

        System.out.println(th.getPriority());


        //当主线程打印五个hello就中断子进程休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hello" + i);
        }
        th.interrupt();  // interrupt是中断休眠的

        */
        Th th = new Th();
        th.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程吃了" + i + "个包子");
            if (i == 10) {
                System.out.println("谦让一下");
                // join(),线程插队,一定成功
                //th.join();//先让子线程继续吃

                //yield(),线程礼让，不一定成功
                Thread.yield();

                System.out.println("自己继续吃");
            }
        }


    }
}

class Th extends Thread {
    int i = 0;
   /*
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃饭了..." + ++i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠了");
                Thread.sleep(20000);//20s
            } catch (InterruptedException e) {
                //InterruptedException是中断异常
                System.out.println(Thread.currentThread().getName() + "阻止了");
            }
        }
    }
    */

    @Override
    public void run() {

        for (int j = 0; j < 20; j++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("子线程吃了" + j + "个包子");
        }

    }
}