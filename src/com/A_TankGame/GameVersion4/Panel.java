package com.A_TankGame.GameVersion4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;


//监听键盘事件 方便实现KeyListener
//为了让Panel不停地重绘子弹，需要将panel实现Runnable当做线程使用
public class Panel extends JPanel implements KeyListener, Runnable {
    //定义一个己方坦克
    myTank mytank = null;
    Vector<EnemyTank> enemyTank = new Vector<>();

    //定义一个存放Node对象Vector,用于恢复敌人坦克的坐标和方向
    Vector<Node> nodes = new Vector<>();


    //定义一个 Vector , 用于存放炸弹
    //说明，但子弹击中坦克是，加入一个Bomb对象到bomb
    Vector<Bomb> bomb = new Vector<>();
    //定义炸弹图片,显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    int enemyTanknum = 6;


    public Panel(String key) {

        //判断记录文件是否存在，存在就继续游戏，不存在就只能开启新游戏

        File file = new File(Recorder.getRecordFile());
        if (file.exists()){
           nodes = Recorder.getNodeAndEnemyTankRecord();
        }else{
            System.out.println("开启新游戏");
            key = "1";
        }
        nodes = Recorder.getNodeAndEnemyTankRecord();
        //将panel对象的enemyTank 设置给 Recorde 的enemyTank
        Recorder.setEnemyTanks(enemyTank);
        //初始化一个己方坦克
        mytank = new myTank(500, 500);
        mytank.setSpeed(5);

        switch (key) {
            case "1":
                for (int i = 0; i < enemyTanknum; i++) {
                    EnemyTank enemyTanks = new EnemyTank((100 * (i + 1)), 0);
                    enemyTanks.setEnemyTanks(enemyTank);
                    //设置坦克方向,下行的代码放在下面的for循环也是可以的
                    enemyTanks.setDirection(2);
                    enemyTanks.setSpeed(5);  //此处要设置速度，不然会使得坦克只转圈不移动.或者在Tank里面进行初始化speed
                    //启动敌人坦克线程，使其启动起来
                    new Thread(enemyTanks).start();

                    // 给该EnemyTank 加子弹
                    Shot shot = new Shot(enemyTanks.getX() + 20, enemyTanks.getY() + 60, enemyTanks.getDirection());
                    //加入 EnemyTank 的 Vector成员
                    enemyTanks.shots.add(shot);
                    //启动 shot 对象
                    new Thread(shot).start();

                    enemyTank.add(enemyTanks);

                }
                break;
            case "2": // go on
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);

                    EnemyTank enemyTanks = new EnemyTank(node.getX(), node.getY());
                    enemyTanks.setEnemyTanks(enemyTank);
                    //设置坦克方向,下行的代码放在下面的for循环也是可以的
                    enemyTanks.setDirection(node.getDirection());
                    enemyTanks.setSpeed(5);  //此处要设置速度，不然会使得坦克只转圈不移动.或者在Tank里面进行初始化speed
                    //启动敌人坦克线程，使其启动起来
                    new Thread(enemyTanks).start();

                    // 给该EnemyTank 加子弹
                    Shot shot = new Shot(enemyTanks.getX() + 20, enemyTanks.getY() + 60, enemyTanks.getDirection());
                    //加入 EnemyTank 的 Vector成员
                    enemyTanks.shots.add(shot);
                    //启动 shot 对象
                    new Thread(shot).start();

                    enemyTank.add(enemyTanks);

                }
                break;
            default:
                System.out.println("again input");
                //初始化一个敌方坦克

                //初始化图片对象
                image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
                image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
                image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

                //播放指定音乐
                new AePlayWave("src\\com\\A_TankGame\\GameVersion4").start();
        }
    }

        //编写击毁敌方坦克的信息
        public void showinfo (Graphics g){
            g.setColor(Color.BLACK);
            g.setFont(new Font("隶书", Font.BOLD, 25));
            g.drawString("累计击毁敌方坦克", 1020, 30);
            drawTank(1020, 60, g, 0, 0);//敌方坦克
            g.setColor(Color.BLACK);
            g.drawString(Recorder.getHitEnemyTank() + " ", 1080, 100);
        }

        @Override
        public void paint (Graphics g){
            super.paint(g);
            g.fillRect(0, 0, 1000, 750);
            showinfo(g);
            //己方坦克
            if (mytank != null && mytank.islive) {
                drawTank(mytank.getX(), mytank.getY(), g, mytank.getDirection(), 0);
            }
            //画出己方坦克的射击的一颗子弹
//        if (mytank.shot != null && mytank.shot.isLive() == true) {
//            g.draw3DRect(mytank.shot.x, mytank.shot.y, 2, 2, false);
//        }
            //画出己方坦克的多颗子弹

            for (int i = 0; i < mytank.shots.size(); i++) {
                Shot shot = mytank.shots.get(i);
                if (shot != null && shot.isLive() == true) {
                    g.draw3DRect(shot.x, shot.y, 2, 2, false);
                } else {
                    //该shot对象已经销毁无效，就从shots集合中拿掉
                    mytank.shots.remove(shot);
                }
            }
            //如果bomb中有对象就画出
            for (int i = 0; i < bomb.size(); i++) {
                Bomb bomb1 = bomb.get(i);
                //根据当前这个的bomb对象的live值去画出对应的图片
                if (bomb1.live > 6) {
                    g.drawImage(image1, bomb1.x, bomb1.y, 60, 60, this);
                }
                if (bomb1.live > 3) {
                    g.drawImage(image2, bomb1.x, bomb1.y, 60, 60, this);
                } else {
                    g.drawImage(image2, bomb1.x, bomb1.y, 60, 60, this);
                }
                //让这个炸弹生命值减少
                bomb1.liveDown();
                if (bomb1.live == 0) {
                    bomb.remove(bomb1);
                }
            }
            //从集合中取出敌军坦克
            //封装画敌方坦克的方法
            for (int i = 0; i < enemyTank.size(); i++) {
                //创建敌方坦克
                EnemyTank enemy = enemyTank.get(i);

                // 设置坦克方向
                //enemy.setDirection(2);
                //当敌人坦克是存活的才是绘制坦克
                if (enemy.islive) {
                    //画出敌军坦克
                    drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
                    //画出所有敌军坦克的子弹
                    for (int j = 0; j < enemy.shots.size(); j++) {
                        //创建子弹
                        Shot shot = enemy.shots.get(j);
                        if (shot.isLive()) {
                            g.draw3DRect(shot.x, shot.y, 1, 1, false);
                        } else {
                            //移除子弹
                            enemy.shots.remove(shot);
                        }
                    }
                }


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

        public void drawTank ( int x, int y, Graphics g,int direction, int type){
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
            switch (direction) {
                case 0: // up表示向上
                    g.fill3DRect(x, y, 10, 60, false); //画出坦克左边的轮子
                    g.fill3DRect(x + 30, y, 10, 60, false); //画出坦克右边的轮子
                    g.fill3DRect(x + 10, y + 10, 20, 40, false); //画出坦克中间部分
                    g.fillOval(x + 10, y + 20, 20, 20); //画出坦克圆形盖子
                    g.drawLine(x + 20, y + 30, x + 20, y); //画出坦克炮台
                    break;
                case 1: //right表示向右
                    g.fill3DRect(x, y, 60, 10, false); //画出坦克左边的轮子
                    g.fill3DRect(x, y + 30, 60, 10, false); //画出坦克右边的轮子
                    g.fill3DRect(x + 10, y + 10, 40, 20, false); //画出坦克中间部分
                    g.fillOval(x + 20, y + 10, 20, 20); //画出坦克圆形盖子
                    g.drawLine(x + 30, y + 20, x + 60, y + 20); //画出坦克炮台
                    break;
                case 2:// down表示向下
                    g.fill3DRect(x, y, 10, 60, false); //画出坦克左边的轮子
                    g.fill3DRect(x + 30, y, 10, 60, false); //画出坦克右边的轮子
                    g.fill3DRect(x + 10, y + 10, 20, 40, false); //画出坦克中间部分
                    g.fillOval(x + 10, y + 20, 20, 20); //画出坦克圆形盖子
                    g.drawLine(x + 20, y + 30, x + 20, y + 60); //画出坦克炮台
                    break;
                case 3://left表示向左
                    g.fill3DRect(x, y, 60, 10, false); //画出坦克左边的轮子
                    g.fill3DRect(x, y + 30, 60, 10, false); //画出坦克右边的轮子
                    g.fill3DRect(x + 10, y + 10, 40, 20, false); //画出坦克中间部分
                    g.fillOval(x + 20, y + 10, 20, 20); //画出坦克圆形盖子
                    g.drawLine(x + 30, y + 20, x, y + 20); //画出坦克炮台
                    break;
                default:
                    System.out.println("未处理");
            }
        }


        //坦克可以发射多发子弹时，在判断坦克是否击中敌方坦克的时候就需要集中所有子弹
        public void hitEnemyTank () {
//
//        //遍历子弹
//        for (int i = 0; i < mytank.shots.size(); i++) {
//            Shot shot = mytank.shots.get(i);
//            //当我方子弹还存活时
//            if (shot != null && shot.isLive()){
//                //遍历所有坦克
//                for (int j = 0; j < enemyTank.size(); j++) {
//                    EnemyTank enemyt =  enemyTank.get(i);
//                    hitTank(shot, enemyt);
//                }
//            }
//        }

            //重绘的时候判断是否击中敌人坦克   此时只单颗子弹
            if (mytank.shot != null && mytank.shot.isLive()) {  //我的子弹还存活
                for (int i = 0; i < enemyTank.size(); i++) {
                    EnemyTank enemytank = enemyTank.get(i);
                    hitTank(mytank.shot, enemytank);
                }
            }
        }

        // 编写方法，判断敌人子弹是否击中己方坦克
        public void hitmyTank () {
            //先遍历敌方坦克
            for (int i = 0; i < enemyTank.size(); i++) {
                EnemyTank enemyTank = this.enemyTank.get(i);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //判断shot 是否击中坦克
                    if (mytank.islive && shot.isLive()) {
                        hitTank(shot, mytank);
                    }
                }
            }

        }


        //编写方法，判断我方子弹是否击中敌人坦克
        public void hitTank (Shot s, Tank enemy){
            //判断s 击中坦克
            switch (enemy.getDirection()) {
                case 0://敌军坦克向上
                case 2://敌军坦克向下
                    if (s.x > enemy.getX() && s.x < enemy.getX() + 40
                            && s.y > enemy.getY() && s.y < enemy.getY() + 60) {
                        s.setLive(false);
                        enemy.islive = false;
                        //当子弹击中坦克之后，将enemy从Vector中移除即可
                        enemyTank.remove(enemy);

                        //当我方机击毁一个敌方坦克的时候就将数据allenemyTank++
                        //因为enemyTank可以是mytank也可以是EnemyTank
                        if (enemy instanceof EnemyTank) {
                            Recorder.addSetHitEnemyTank();
                        }
                        Bomb bombs = new Bomb(enemy.getX(), enemy.getY());
                        bomb.add(bombs);
                    }
                    break;
                case 1: //敌军坦克向右

                case 3://敌军坦克向左
                    if (s.x > enemy.getX() && s.x < enemy.getX() + 60
                            && s.y > enemy.getY() && s.y < enemy.getY() + 40) {
                        s.setLive(false);
                        enemy.islive = false;
                        enemyTank.remove(enemy);
                        //当我方机击毁一个敌方坦克的时候就将数据allenemyTank++
                        //因为enemyTank可以是mytank也可以是EnemyTank
                        if (enemy instanceof EnemyTank) {
                            Recorder.addSetHitEnemyTank();
                        }
                        Bomb bombs = new Bomb(enemy.getX(), enemy.getY());
                        bomb.add(bombs);
                    }
                    break;

            }
        }

        @Override
        public void keyTyped (KeyEvent e){

        }

    /*
         处理wasd按键按下的移动
     */
        @Override
        public void keyPressed (KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_W) {
                mytank.setDirection(0);
                if (mytank.getY() > 0) {
                    mytank.moveup();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                mytank.setDirection(2);
                if (mytank.getY() + 110 < 750) {
                    mytank.movedown();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_A) {
                mytank.setDirection(3);
                if (mytank.getX() > 0) {
                    mytank.moveleft();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                mytank.setDirection(1);
                if (mytank.getX() + 80 < 1000) {
                    mytank.moveright();
                }
            }
            //按下J就发射子弹
            if (e.getKeyCode() == KeyEvent.VK_J) {
                //  发射一颗子弹
//            if ( mytank.shot.isLive() == false && mytank.shot == null ) {
//                mytank.ShotEnemyTank();
//            }
                //发射多颗子弹
                mytank.ShotEnemyTank();
            }
            this.repaint();

        }

        @Override
        public void keyReleased (KeyEvent e){

        }

        @Override
        public void run () {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                hitEnemyTank();
                hitmyTank();
                this.repaint();
            }
        }
    }
