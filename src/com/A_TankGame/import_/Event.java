package com.A_TankGame.import_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
    小球通过上下左右键进行移动

    java的事件控制机制
 */
public class Event extends JFrame{
    myPanel myPanel = null;
    public static void main(String[] args) {
        Event event = new Event();

    }
    public Event(){
        myPanel = new myPanel();
        this.add(myPanel);
        this.setSize(400,300);
        //窗口JFrame 对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

class myPanel extends JPanel implements KeyListener {

    //为了让小球可以移动，把左上角的坐标设置为变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //此处要改为x,y才能使得黑点移动
        g.fillOval(x,y,20,20);//默认是黑色
    }

    //有字符输入输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "已按下");
        //根据用户按下的字母键处理小球的移动
        //VK_DOWN == 0x28   对应的ASCAII码就是键盘上的向下的箭头对应的 code
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y++;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }

        //让面板重绘
        this.repaint();
    }

    //当某个键松开，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {


    }
}