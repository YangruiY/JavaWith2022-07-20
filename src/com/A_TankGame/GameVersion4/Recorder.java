package com.A_TankGame.GameVersion4;

import java.io.*;
import java.util.Vector;

/*
    和文件交互
    计数器，记录我方机会敌方坦克，当游戏结束的时候，将数据写入到文件(recorder.txt)IO中


 */
@SuppressWarnings({"all"})
public class Recorder {

    //定义变量，记录我方击毁敌人坦克数
    private static int hitEnemyTank = 0;
    //定义IO流,准备写数据到文件中
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;
    private static String recordFile = "e:\\recorder.txt";

    //定义Vector,指向Mypanel对象的敌人坦克Vector
    private static Vector<EnemyTank> enemyTank = null;
    //定义一个Node  的Vector , 用于保存敌人的信息Node
    private static Vector<Node> nodes = new Vector<>();
    //返回记录文件的路径
    public static String getRecordFile() {
        return recordFile;
    }

    //继续上局的时候使用
    //读取文件recordFile,恢复相关信息
    public static Vector<Node> getNodeAndEnemyTankRecord(){
        BufferedReader bufferedReader = null;
        String  line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(recordFile));
            hitEnemyTank = Integer.parseInt(bufferedReader.readLine());
            //循环读文件，生成node集合
            while((line = bufferedReader.readLine())!= null){
                String []s = line.split(" ");
                Node node = new Node(Integer.parseInt(s[0]),
                        Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodes.add(node);  //放入到nodes Vector
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return nodes;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTank) {
        Recorder.enemyTank = enemyTank;
    }

    public static int getHitEnemyTank() {
        return hitEnemyTank;
    }


    //当游戏退出时，我们将allEnemyTankNum 保存到 recordFile文件之中
    //升级KeepRecord,保存敌人坦克坐标和方向
    public static void keepRecord(){
        try {
             bufferedWriter = new BufferedWriter(new FileWriter(recordFile));
            bufferedWriter.write(hitEnemyTank + "\r\n");
            //遍历敌人坦克Vector,然后根据情况保存
            //oop 思想: 定义一个属性由setXXX获得敌人坦克的Vector
            for (int i = 0; i < enemyTank.size(); i++) {
                EnemyTank enemyTank = Recorder.enemyTank.get(i);
                if (enemyTank.islive){
                    //保存信息
                    String record = enemyTank.getX() +  " " +
                            enemyTank.getY() +  " " +
                            enemyTank.getDirection()+"\r\n";
                    bufferedWriter.write(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null)
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void setHitEnemyTank(int hitEnemyTank) {
        Recorder.hitEnemyTank = hitEnemyTank;
    }

    //当我方坦克击毁一个敌人坦克，就应当 hitEnemyTank++

    public static void addSetHitEnemyTank() {
    Recorder.hitEnemyTank++;
    }
}
