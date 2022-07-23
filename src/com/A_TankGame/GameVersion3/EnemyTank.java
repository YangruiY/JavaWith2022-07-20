package com.A_TankGame.GameVersion3;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    boolean islive = true;
    //创建属性,使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        while (true) {

            //判断如果shots size() = 0,创建一颗子弹，放入到shots集合中，并启动
            if(islive && shots.size() < 1){
                Shot s = null;
                switch (getDirection()){
                    case 0:
                        s = new Shot(getX() +20,getY(),0);
                        break;
                    case 1:
                        s = new Shot(getX() +60,getY() + 20,1);
                        break;
                    case 2:
                        s = new Shot(getX() +20,getY() +60,2);
                        break;
                    case 3:
                        s = new Shot(getX() ,getY()+20,3);
                        break;

                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据坦克方向继续移动
            switch (getDirection()) {
                case 0:
                    //让坦克保持一个方向走多个步
                    for (int i = 0; i < 30; i++) {
                      if (getY() > 0){
                          moveup();
                      }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 80 < 1000) {
                            moveright();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 110 < 750) {
                            movedown();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                    if (getX() > 0){
                        moveleft();
                    }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            setDirection((int)(Math.random() * 4));

            //一旦写并发程序，就一定要考虑清楚什么时候退出和结束
            if (!(islive)) {
                break;
            }
        }
    }
}