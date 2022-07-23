package com.A_TankGame.GameVersion2;

import javax.swing.*;

public class Frame extends JFrame {
    Panel panel = null;
    public static void main(String[] args) {
        new Frame();
    }
    public Frame(){
        panel = new Panel();
        this.add(panel);
        this.setSize(1000,750);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
