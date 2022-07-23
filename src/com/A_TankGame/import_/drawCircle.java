package com.A_TankGame.import_;

import javax.swing.*;
import java.awt.*;
/*
    理解：
        JFrame 视为窗口,画框
        JPanel 视为面板
        Graphics g 视为画笔
 */
public class drawCircle extends JFrame{
    private  Panel panel =null;
    public static void main(String[] args) {
       new drawCircle();
    }
    public drawCircle(){
        //初始化面板
        panel = new Panel();
        //把面板放入到画框
        this.add(panel);
        //设置窗口大小
        this.setSize(500,500);
        //点击JFrame的x就退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可视
    }
}

//定义一个面板Panel
class Panel extends JPanel{
    @Override
    //绘图方法
    public void paint(Graphics g) {
        //调用父类绘图方法
        super.paint(g);
        //画圆的方法,画椭圆边框 drawOval(int x, int y, int width, int height)
        g.drawOval(20,20,1000,1000);

        //演示绘制不同的图形..
        // 画直线 drawLine(int x1,int y1,int x2,int y2)
        g.drawLine(10, 10, 100, 100);
        // 画矩形边框 drawRect(int x, int y, int width, int height)
        g.drawRect(10, 10, 100, 100);
        // 填充矩形 fillRect(int x, int y, int width, int height)
        // 设置画笔的颜色
          g.setColor(Color.green);
          g.fillRect(10, 10, 100, 100);
        // 填充椭圆 fillOval(int x, int y, int width, int height)
         g.setColor(Color.red);
         g.fillOval(10, 10, 100, 100);
        // 画图片 drawImage(Image img, int x, int y, ..)
        // 1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
         Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
         g.drawImage(image, 10, 10, 300, 170, this);
        // 画字符串 drawString(String str, int x, int y)//写字
        // 给画笔设置颜色和字体 g.setColor(Color.red);
         g.setFont(new Font("隶书", Font.BOLD, 50));
        // 这里设置的 100， 100， 是 "北京你好"左下角
         g.drawString("南大百廿", 300, 300);
        // 设置画笔的字体 setFont(Font font)
        // 设置画笔的颜色 setColor(Color c)


    }

}