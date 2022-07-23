package com.MuliThread_.ClassWork;

import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        Thread thread = new Thread(threadA);

        ThreadB threadB = new ThreadB(threadA);
        thread.start();
        threadB.start();
    }
}

class ThreadA implements Runnable{
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while(loop){
            System.out.println((int)(Math.random()*100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//键盘读出Qa
//
class ThreadB extends Thread{
    private  ThreadA tha;

    public ThreadB(ThreadA tha) {
        this.tha = tha;
    }

    @Override
    public void run() {
        //接收到用户输入
        while(true){
            System.out.println("输入指令Q即可退出");
            Scanner scanner = new Scanner(System.in);
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q' ||key == 'q' ){
                tha.setLoop(false);
                System.out.println("ThreadB Exit");
                break;
            }
        }
    }
}