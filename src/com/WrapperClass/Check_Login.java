package com.WrapperClass;

import java.util.Scanner;

public class Check_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名！");
        String name = scanner.next();
        System.out.println("输入密码！");
        String pwd = scanner.next();
        System.out.println("输入邮箱！");
        String email = scanner.next();
        try {
            userLogin(name,pwd,email);
            System.out.println("注册成功！");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //判断密码是否为数字
    public static boolean isDigital(String str){
        //String型字符串 转化为 char型数组
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i] < '0' || chars[i] >9){
                return false;
            }
        }
        return true;
    }
    public static void userLogin(String name, String pwd,String email){
        //1 校验用户名
        if(!(name.length() >= 2 && name.length() <= 4)){
            throw new RuntimeException("用户名错误！");
        }

        //1 校验密码
        if(pwd.length()!= 6 || isDigital(pwd)==true){
            throw new RuntimeException("密码错误！");
        }

        //校验邮箱
        int i= email.indexOf('@');
        int j = email.indexOf('.');
        if(!(i > 0 && j>i)){
            throw new RuntimeException("邮箱错误！");
        }
    }
}
