package com.A_TankGame.GameVersion2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Panel extends JPanel implements KeyListener {
    //定义一个己方坦克
    myTank mytank = null;
     Vector<EnemyTank> enemyTank = new Vector<>();
     int enemyTanknum =5;
    public Panel() {
        //初始化一个己方坦克
        mytank = new myTank(100, 100);
        mytank.setSpeed(5);
        //初始化一个敌方坦克
        for (int i = 0; i < enemyTanknum; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 10);
            //设置坦克方向   ， 下行的代码放在下面的for循环也是可以的
            enemyTank.setDirection(2);
            this.enemyTank.add(enemyTank);

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //封装画己方坦克的方法
//        drawTank(mytank.getX(),mytank.getY(),g,"up",0);
//        drawTank(mytank.getX() +100,mytank.getY(),g,"right",0);
//        drawTank(mytank.getX() +200,mytank.getY(),g,"down",0);
//        drawTank(mytank.getX() +300,mytank.getY(),g,"left",0);
//        drawTank(mytank.getX() + 100,mytank.getY(),g,"up",1);
        drawTank(mytank.getX() + 100,mytank.getY(),g,mytank.getDirection(),0);
        //封装画敌方坦克的方法
        for (int i = 0; i < enemyTank.size(); i++) {
            //创建敌方坦克
            EnemyTank enemy = enemyTank.get(i);
//            设置坦克方向
//            enemy.setDirection(2);
            drawTank(enemy.getX(), enemy.getY(), g,enemy.getDirection(),1);
        }
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

        //坦克方向
        //坦克的方向不仅仅是direction的变化，其自身形状也是需要变化的
        switch (direction){
            case 0: // up表示向上
                g.fill3DRect(x,y,10,60,false); //画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false); //画出坦克右边的轮子
                g.fill3DRect(x+10,y + 10,20,40,false); //画出坦克中间部分
                g.fillOval(x+9,y + 20,20,20); //画出坦克圆形盖子
                g.drawLine(x+19,y + 30,x+20,y); //画出坦克炮台
                break;
            case 1: //right表示向右
                g.fill3DRect(x,y,60,10,false); //画出坦克左边的轮子
                g.fill3DRect(x,y+30,60,10,false); //画出坦克右边的轮子
                g.fill3DRect(x+10,y + 10,40,20,false); //画出坦克中间部分
                g.fillOval(x+20,y + 9,20,20); //画出坦克圆形盖子
                g.drawLine(x+30,y + 19,x+60,y+20); //画出坦克炮台
                break;
            case 2:// down表示向下
                g.fill3DRect(x,y,10,60,false); //画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false); //画出坦克右边的轮子
                g.fill3DRect(x+10,y + 10,20,40,false); //画出坦克中间部分
                g.fillOval(x+9,y + 20,20,20); //画出坦克圆形盖子
                g.drawLine(x+19,y + 30,x+20,y+60); //画出坦克炮台
                break;
            case 3://left表示向左
                g.fill3DRect(x,y,60,10,false); //画出坦克左边的轮子
                g.fill3DRect(x,y+30,60,10,false); //画出坦克右边的轮子
                g.fill3DRect(x+10,y + 10,40,20,false); //画出坦克中间部分
                g.fillOval(x+20,y + 9,20,20); //画出坦克圆形盖子
                g.drawLine(x+30,y + 19,x ,y+20); //画出坦克炮台
                break;
            default:
                System.out.println("未处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*
         处理wasd按键按下的移动
     */
    @Override
    public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W){
                    mytank.setDirection(0);
                    mytank.moveup();
            }else  if(e.getKeyCode() == KeyEvent.VK_S){
                mytank.setDirection(2);
                mytank.movedown();
            }else if(e.getKeyCode() == KeyEvent.VK_A){
                mytank.setDirection(3);
                mytank.moveleft();
            }else if(e.getKeyCode() == KeyEvent.VK_D){
                mytank.setDirection(1);
                mytank.moveright();
            }
            this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
