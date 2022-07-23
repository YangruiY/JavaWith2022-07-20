package com.HouseRent.Service;

import com.HouseRent.Model.House;

//service

// houseview 调用   +  crud
public class HouseService {
    private House[] houses;
    private int housenum = 1; //当前房屋信息个数
    private int idnum = 1;

    public HouseService(int size) {
//        House = house;
        houses = new House[size];

        //静态对象
        houses[0] = new House(1, "jack", "南京市", 1400, "未出租", "1802");
    }

    public boolean add(House h) {
        if (housenum == houses.length) {
            System.out.println("不可超过数组长度");
            return false;
        }
        houses[housenum++] = h;
        h.setId(++idnum);//自增房屋id
        return true;
    }

    public boolean del(int id) {
        //注意，下表和房屋编号不是一个值
        int index = -1;
        for (int i = 0; i < housenum; i++) {
            if (id == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) { // 遍历一遍没找到id就是返回false
            return false;
        }
            //如果找到就删除<有难度>
            for (int i = index ; i < housenum - 1 ; i++) {
                houses[i] = houses[i + 1];


        }
        houses[--housenum] = null;
        return true;
    }

    public House[] listHouse() {
        return houses;
    }

    public House search(int id) {
        for (int i = 0; i < housenum; i++) {
            if (id == houses[i].getId()) {
                return houses[i];
            }

        }
        return null;
    }
}

