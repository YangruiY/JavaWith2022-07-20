package com.A_TankGame.GameVersion1;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    //定义一个己方坦克
    myTank mytank = null;

    public Panel() {
        mytank = new myTank(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //封装画出坦克的方法
        drawTank(mytank.getX(),mytank.getY(),g,0,0);
        drawTank(mytank.getX() + 100,mytank.getY(),g,0,1);
    }

    /*

        坦克使用到的参数
           x 坦克左上角x坐标
           y 坦克左上角y坐标
           g 画笔
           direction 坦克方向
           type  坦克类型
    */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0: //己方坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌方坦克
                g.setColor(Color.yellow);
                break;
//            case 0: //己方坦克
//                g.setColor(Color.cyan);
//            case 0: //己方坦克
//                g.setColor(Color.cyan);
        }
        switch (direction){
            case 0:
                g.fill3DRect(x,y,10,60,false); //画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false); //画出坦克右边的轮子
                g.fill3DRect(x+10,y + 10,20,40,false); //画出坦克中间部分
                g.fillOval(x+9,y + 20,20,20); //画出坦克圆形盖子
                g.drawLine(x+19,y + 30,x+20,y); //画出坦克炮台

                break;
            default:
                System.out.println("未处理");
        }
    }
}
