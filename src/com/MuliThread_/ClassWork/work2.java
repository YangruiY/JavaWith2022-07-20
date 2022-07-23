package com.MuliThread_.ClassWork;

public class work2 {
    public static void main(String[] args) {
        withdraw withdraw = new withdraw();
        Thread thread = new Thread(withdraw);
        thread.setName("A");
        Thread thread1 = new Thread(withdraw);
        thread1.setName("B");
        thread.start();
        thread1.start();
    }
}

class  withdraw implements Runnable{
private double money = 9999;
    @Override
    public void run() {
        while (true){
            /*
                1. 这里使用 synchronized 实现了线程同步
                2. 当多个线程执行到这里就会争夺this的对象锁
                3. 哪个线程争夺到(获取到)this对象锁，就会执行 synchronized 代码块
                4. 争夺不到this对象，就会block,准备继续争夺
                5. this对象锁是非公平锁
             */
            synchronized (this){
                if(money < 1000){
                    System.out.println("余额不足~"+Thread.currentThread().getName() + "无法取钱");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000钱剩余余额为" +money);

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Money{
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

