package com.A_TankGame.GameVersion2;

public class Tank {
    private int x;  //横坐标
    private int y;  //纵坐标
    private int direction;
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveup(){
        y -= speed;
    }
    public void movedown(){
        y += speed;
    }
    public void moveleft(){
        x -= speed;
    }
    public void moveright(){
        x += speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
