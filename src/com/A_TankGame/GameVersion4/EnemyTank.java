package com.A_TankGame.GameVersion4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    boolean islive = true;
    //创建属性,使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();

    //增加一个成员，EnemyTank 可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();


    public EnemyTank(int x, int y) {
        super(x, y);
    }


    // 此处提供一个方法，可以将MyPanel的成员 Vector<EnemyTank> enemyTanks = new Vector<>()
    // 设置到EnemyTank的成员enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    @SuppressWarnings({"all"})
    //编写方法，判断当前的这个敌人坦克是否和enemyTanks中的其他坦克发生重叠或者碰撞
    public boolean isTouchEnemyTanks() {
        //判断当前这个敌人(this)坦克的方向
        switch (this.getDirection()) {
            case 0:
                //让当前的敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        /*
                       1. 如果敌人坦克是上/下
                          那么敌人坦克坐标 x∈[enemyTank.getX(),enemyTank.getX()+40]
                                      y∈[enemyTank.getY(),enemyTank.getY()+60]
                        */
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //当前敌人坦克  左上角坐标 x∈[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前敌人坦克  右上角坐标 x∈[this.getX(),this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                          /*
                        如果敌人坦克是左/右
                        那么敌人坦克坐标   x∈[enemyTank.getX(),enemyTank.getX()+60]
                                        y∈[enemyTank.getY(),enemyTank.getY()+40]

                            当前敌人坦克 左上角坐标 x∈[this.getX(),this.getY()]
                            */
                            if (this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                                return true;
                        }
                        //当前敌人坦克  右下角坐标 x∈[this.getX() + 40,this.getY()]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY()  >= enemyTank.getY()
                                && this.getY()  <= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                }

                break;
            case 1:
                //让当前的敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        /*
                       1. 如果敌人坦克是上/下
                          那么敌人坦克坐标 x∈[enemyTank.getX(),enemyTank.getX()+40]
                                        y∈[enemyTank.getY(),enemyTank.getY()+60]
                        */
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //当前敌人坦克  右上角坐标 x∈[this.getX()+60,this.getY()]
                            if (this.getX() +60>= enemyTank.getX()
                                    && this.getX() +60<= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前敌人坦克  右下角坐标 x∈[this.getX() +60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() +40>= enemyTank.getY()
                                    && this.getY() +40<= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                          /*
                        如果敌人坦克是左/右
                        那么敌人坦克坐标   x∈[enemyTank.getX(),enemyTank.getX()+60]
                                        y∈[enemyTank.getY(),enemyTank.getY()+40]

                            当前敌人坦克 左上角坐标 x∈[this.getX() +60,this.getY()]
                            */
                            if (this.getX()+60>= enemyTank.getX()
                                    && this.getX() +60<= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                                return true;
                        }
                        //当前敌人坦克  右下角坐标 x∈[this.getX() + 60,this.getY() +40]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() + 40>= enemyTank.getY()
                                && this.getY() + 40<= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        /*
                       1. 如果敌人坦克是上/下
                          那么敌人坦克坐标 x∈[enemyTank.getX(),enemyTank.getX()+40]
                                      y∈[enemyTank.getY(),enemyTank.getY()+60]
                        */
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //当前敌人坦克  左下角坐标 x∈[this.getX(),this.getY() +60]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() +60 >= enemyTank.getY()
                                    && this.getY() +60<= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前敌人坦克  右下角坐标 x∈[this.getX() + 40,this.getY() + 60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                          /*
                        如果敌人坦克是左/右
                        那么敌人坦克坐标   x∈[enemyTank.getX(),enemyTank.getX()+60]
                                        y∈[enemyTank.getY(),enemyTank.getY()+40]

                            当前敌人坦克 左下角坐标 x∈[this.getX(),this.getY() + 60]
                            */
                            if (this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 40)
                                return true;
                        }
                        //当前敌人坦克  右下角坐标 x∈[this.getX() + 40,this.getY() + 60]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                }
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        /*
                       1. 如果敌人坦克是上/下
                          那么敌人坦克坐标 x∈[enemyTank.getX(),enemyTank.getX()+40]
                                      y∈[enemyTank.getY(),enemyTank.getY()+60]
                        */
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //当前敌人坦克  左上角坐标 x∈[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前敌人坦克  左下角坐标 x∈[this.getX(),this.getY() +40]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 40
                                    && this.getY() + 40>= enemyTank.getY()
                                    && this.getY() + 40<= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                          /*
                        如果敌人坦克是左/右
                        那么敌人坦克坐标   x∈[enemyTank.getX(),enemyTank.getX()+60]
                                        y∈[enemyTank.getY(),enemyTank.getY()+40]

                            当前敌人坦克 左上角坐标 x∈[this.getX(),this.getY()]
                            */
                            if (this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                                return true;
                        }
                        //当前敌人坦克  左下角坐标 x∈[this.getX() ,this.getY()+ 40]
                        if (this.getX()  >= enemyTank.getX()
                                && this.getX()  <= enemyTank.getX() + 60
                                && this.getY()  + 40>= enemyTank.getY()
                                && this.getY()  + 40<= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                }

        }
        return false;
    }

    @Override
    public void run() {
        while (true) {

            //判断如果shots size() = 0,创建一颗子弹，放入到shots集合中，并启动
            if (islive && shots.size() < 1) {
                Shot s = null;
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
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
                        if (getY() > 0 && !isTouchEnemyTanks()) {
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
                        if (getX() + 80 < 1000 && !isTouchEnemyTanks()) {
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
                        if (getY() + 110 < 750 && !isTouchEnemyTanks()) {
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
                        if (getX() > 0 && !isTouchEnemyTanks()) {
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

            setDirection((int) (Math.random() * 4));

            //一旦写并发程序，就一定要考虑清楚什么时候退出和结束
            if (!(islive)) {
                break;
            }
        }
    }
}