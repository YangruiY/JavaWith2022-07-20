package com.A_TankGame.GameVersion3;

public class Shot implements Runnable {
    int x;
    int y;
    int direction = 0;
    int speed = 5;
    private boolean isLive = true;

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {//射击行为
        while (isLive) {
            //线程休眠
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向改变想，y坐标
            switch (direction) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;

            }
            System.out.println("子弹坐标,x= " + x + ",y=" + y);
            //如果子弹移动到面板的边界时，就应该销毁(把启动的子弹的线程销毁)
            //如果子弹碰到敌人坦克时，也应该销毁(把启动的子弹的线程销毁)

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive() )) {
                isLive = false;
                break;
            }
        }

    }
}
