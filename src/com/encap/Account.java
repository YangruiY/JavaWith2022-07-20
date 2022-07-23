package com.encap;

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {

    }


    public Account(String name, double balance, String password) {
        this.setName(name);
        this.balance = balance;
        this.password = password;
        setBalance(balance);
        setPassword(password);
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <=4){
            this.name = name;
        }else{
            System.out.println("默认名字为 张三李四");
            this.name = "张三李四";
        }
    }

    public void setBalance(double balance) {
        if(balance >= 20){
            this.balance = balance;
        }else{
            System.out.println("默认余额为 0.0");
            this.balance = 0.0;
        }
    }

    public void setPassword(String password) {
        if(password.length() == 6){
            this.password = password;
        }else{
            System.out.println("密码无效，默认密码为 000000");
            this.password = "000000";
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }
    public String show(){
       return "账号信息为:"+ "\t 姓名" + name + "" +
                "\t 余额 " +balance +  "\t 密码" + password;
    }
}
