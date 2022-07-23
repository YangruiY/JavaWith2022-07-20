package com.HouseRent;

import com.HouseRent.View.HouseView;

//main
public class HouseRentapp {
    public static void main(String[] args) {
        //创建HouseView对象，显示主菜单
        new HouseView().mainMenu();
        System.out.println("你已退出本系统");
    }
}
