package com.A_TankGame.GameVersion4;

public class Node {
    //一个node对象就是一个Tank信息
    private int x;  //横坐标
    private int y;  //纵坐标
    private int direction ;

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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Node(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
