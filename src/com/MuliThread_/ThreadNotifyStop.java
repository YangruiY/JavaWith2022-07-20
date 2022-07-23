package com.MuliThread_;
/*
    线程退出、终止
 */
public class ThreadNotifyStop {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        //希望主线程去控制t进程的终止，此处可以设定loop
        //让t进程退出run方法，从而达到终止t线程  -> 通知方式

        //让主线程休眠10s再通知t进程退出
        System.out.println("主线程休眠10秒~ ");
        Thread.sleep(10000);
        t.setLoop(false);

    }
}

class T extends Thread{

    int i = 0;
    //设置控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println(i++);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}