package com.HouseRent.View;

import com.HouseRent.Model.House;
import com.HouseRent.Service.HouseService;
import com.HouseRent.Utils.Utility;

//显示界面
// 接受用户输入
// 调用houseservice的方法
public class HouseView {
    //显示界面
    private boolean loop = true;
    private char key =' ';
    private HouseService houseService = new HouseService(3);//House数组大小3


    //添加House对象
    public void addHouse() {
        System.out.println("=========添加房屋======");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(13);
        System.out.print("地址：");
        String address = Utility.readString(15);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(4);
        //id 系统分配，自增长形式
        House house = new House(0, name, address, rent, state, phone);

        if (houseService.add(house)) {
            System.out.println("添加成功~");
        } else {
            System.out.println("添加失败~");
        }
    }

    //查找
    public void searchHouse() {
        System.out.println("====查找房源====");
        System.out.println("====输入查找的房源编号======");
        int id = Utility.readInt();
        if (id == -1) {
            System.out.println("查找失败");
            return;
        }
        if (houseService.search(id) != null) {
            System.out.println(houseService.search(id));
        } else {
            System.out.println("编号为" + id + "的房源不存在");
        }

    }

    //删除房源
    public void delHouse() {
        System.out.println("开始删除房源");
        System.out.println("输入删除房源的编号");
        int id = Utility.readInt();
        if (id == -1) {
            System.out.println("放弃删除");
            return;
        }
        char del = Utility.readConfirmSelection();
        if (del == 'Y') {
            if (houseService.del(id)) {
                System.out.println("deleted success");
            } else {
                System.out.println("deleted failed");
            }
        } else {
            System.out.println("输入有误，重新输入");
        }

    }

    //修改房屋信息
    public void update() {
        System.out.println("=====修改房屋信息=====");
        System.out.println("修改房屋的编号");
        int updateid = Utility.readInt();
        if (updateid == -1) {
            System.out.println("放弃修改~");
            return;
        }

        House house = houseService.search(updateid);
        if (house == null) {
            System.out.println("修改的房屋信息编号不存在");
            return;
        }
        System.out.println("原姓名:" + house.getName());
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.println("原号码:" + house.getPhone());
        String phone = Utility.readString(15, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.println("原地址:" + house.getAddress());
        String address = Utility.readString(16, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.println("原月租:" + house.getRent());
        int rent = Utility.readInt(0);
        if (rent != 0) {
            house.setRent(rent);
        }
        System.out.println("原状态:" + house.getState());
        String state = Utility.readString(4,"");
        if(!"".equals(state)){
            house.setState(state);
        }
        System.out.println("修改成功~");
    }

    //显示房源列表的表头
    public void listHouses() {
        System.out.println("===房源列表====");
        System.out.println("编号\t\t房主\t\t地址\t\t号码\t\t月租\t\t状态(已出租/未出租)");
        House[] houses = houseService.listHouse(); //得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("=========显示结束======");
    }


    //退出
    private void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void mainMenu() {
        do {
            System.out.println("==========房屋出租系统（菜单）");
            System.out.println("\t\t\t 1 新 增 房 源");
            System.out.println("\t\t\t 2 查 找 房 源");
            System.out.println("\t\t\t 3 删 除 房 源 信 息");
            System.out.println("\t\t\t 4 修 改 房 源 信 息");
            System.out.println("\t\t\t 5 房 源 列 表");
            System.out.println("\t\t\t 6    退 出");
            System.out.println("输入你的选择(1-6)");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;

                default:
                    System.out.println("输入有误");
            }

        } while (loop);
    }
}


