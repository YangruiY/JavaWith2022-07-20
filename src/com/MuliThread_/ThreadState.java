package com.MuliThread_;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        TS ts = new TS();
        ts.start();
        System.out.println(ts.getName() + "状态" + ts.getState());

        while (Thread.State.TERMINATED != ts.getState()) {

            System.out.println(ts.getName() + "状态" + ts.getState());
            Thread.sleep(500);
        }

        System.out.println(ts.getName() + "状态" + ts.getState());

    }
}

class TS extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }

    }
}