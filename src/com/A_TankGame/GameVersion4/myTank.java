package com.A_TankGame.GameVersion4;

import java.util.Vector;

public class myTank extends Tank {
    //Shot对象表示一个射击线程,一个子弹
    Shot shot = null;

    //一组子弹
    Vector<Shot> shots = new Vector<>();
    public myTank(int x, int y) {
        super(x, y);
    }
    //射击敌军坦克
    public void ShotEnemyTank(){
        if (shots.size() == 5){
            return;
        }
        //创建shot对象, 根据当前myTank的对象位置和方向创建Shot
        switch (getDirection()){//myTank的方向
            case 0:
                shot = new Shot(getX()+18,getY(),0);
                break;
            case 1:
                shot = new Shot(getX()+60,getY()+18,1);
                break;
            case 2:
                shot = new Shot(getX()+18,getY()+58,2);
                break;
            case 3:
                shot = new Shot(getX(),getY()+18,3);
                break;


        }

        //把新创建的shots加入到集合之中
        shots.add(shot);
        //启动shot线程
        new Thread(shot).start();
    }
}
