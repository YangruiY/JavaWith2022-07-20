package com.A_TankGame.GameVersion4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Frame extends JFrame {
    Panel panel = null;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new Frame();
    }
    public Frame(){

        System.out.println("请输入选择1(new) OR 2(go on) ");
        String key = scanner.next();
        panel = new Panel(key);
        Thread thread = new Thread(panel);
        thread.start();
        this.add(panel);
        this.setSize(1300,750);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.out.println("监听到关闭窗口");
                System.exit(0);
            }
        });
    }
}
