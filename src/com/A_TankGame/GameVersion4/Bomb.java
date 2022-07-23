package com.A_TankGame.GameVersion4;

public class Bomb {
    int x,y;
    int live = 9; //炸弹生命周期
    boolean islive = true; //是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void liveDown(){
        if(live > 0){
            live--;
        }else{
            islive = false;
        }
    }
}
