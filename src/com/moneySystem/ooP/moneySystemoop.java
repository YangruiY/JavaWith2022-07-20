package com.moneySystem.ooP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
oop 版本的moneySystem
 */
public class moneySystemoop {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    //输入1
    String details = "---------------明细---------------";
    //显示细节
    double money = 0.0;
    double balance = 0.0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //输入2
    String getmoney = "---------------入账---------------";
    //输入3
    String useful = "";
    //输入4
    String choose = "";




    public void mainmenu() {
        do{
            System.out.println("===============菜单(OOP)==============");
            System.out.println("\t\t\t 1 明细");
            System.out.println("\t\t\t 2 入账");
            System.out.println("\t\t\t 3 消费");
            System.out.println("\t\t\t 4 退出");
            System.out.println("输入数字~");
            key = scanner.next();

            switch (key){
                case "1":
                    if (balance < 0){
                        System.out.println("余额不得出现负数，请仔细检查");
                    }
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误，重新输入~");
            }
        }while(loop);
    }

    public void detail() {
        System.out.println(details);
    }

    public void income() {
        System.out.println(getmoney);
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        balance += money;
        if (money <= 0) {
            System.out.println("收益入账金额需要>0");
            return;
        }
//                    if (balance<0){
//                        System.out.println("余额不得<0");
//                        break;
//                    }
        date = new Date();
        //System.out.println(sdf.format(date));
        //拼接收益入账
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date)
                + "\t" + "余额:" + "\t" + balance;
    }

    public void pay() {
        System.out.println("消费金额：");
        money = scanner.nextDouble();
        System.out.println("消费用途：");
        useful = scanner.next();
        balance -= money;
        if (money < 0 || money > balance) {
            System.out.println("消费金额应该在0-" + balance + "之间");

        }
        date = new Date();
        //System.out.println(sdf.format(date));
        //拼接消费信息
        details += "\n" + useful + "\t-" + money + "\t" + sdf.format(date)
                + "\t" + "余额:" + "\t" + balance;
    }

    public void exit() {
        while (true) {
            System.out.println("是否(yse/no)确定退出");
            choose = scanner.next();
            if ("yes".equals(choose) || "no".equals(choose)) {
                break;
            } else {
                System.out.println("输入错误，重新输入");
            }
        }
        if (choose.equals("yes")) {
            loop = false;
            System.out.println("已经退出");
        }
    }
}
