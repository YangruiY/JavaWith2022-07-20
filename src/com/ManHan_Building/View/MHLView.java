package com.ManHan_Building.View;

import com.ManHan_Building.Domain.*;
import com.ManHan_Building.Service.BillService;
import com.ManHan_Building.Service.DiningTableService;
import com.ManHan_Building.Service.EmployeeService;
import com.ManHan_Building.Service.MenuService;
import com.ManHan_Building.Utility.Utility;

import java.util.List;

/**
 * 主界面
 */
public class MHLView {
    public static void main(String[] args) {
        //显示主菜单
        new MHLView().mainMenu();
    }

    private boolean loop = true;
    private int choose;
    private boolean bool = true;
    //定义各个 Service 属性
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();



    public void mainMenu() {
        while (loop) {
            System.out.println("========满汉楼=======");
            System.out.println("\t\t\t 1 登录满汉楼");
            System.out.println("\t\t\t 2 退出满汉楼");
            System.out.println("请输入你的选择");
            choose = Utility.readInt();
            switch (choose) {
                case 1:
                    System.out.println("登录满汉楼");
                    System.out.println("请输入员工号");
                    String id = Utility.readString(50);
                    System.out.println("请输入员工编号");
                    String empId = Utility.readString(50);
                    Employee employeeFromIdempId = employeeService.getEmployeeFromIdempId(id, empId);
//                    System.out.print("[id="+id+",empid="+empId+"]");
//                    System.out.println(employeeFromIdempId);
                    //进行数据库校验
                    if (employeeFromIdempId != null) {
                        System.out.print("登陆成功[id=" + id + ",empid=" + empId + "]");
                        System.out.println("\n\n\n");
                        System.out.println("进入满汉楼二级菜单");
                        SecondLevel();
                    } else {
                        System.out.println("无法登陆");
                    }
                    break;
                case 2:
                    System.out.println("退出满汉楼");
                    loop = false;
                    break;
                default:
                    System.out.println("重新输入");
            }
        }
        System.out.println("baibai~");
    }

    //二级菜单
    public void SecondLevel() {
        while (loop) {
            System.out.println("========满汉楼二级菜单=======");
            System.out.println("\t\t\t 1 显示餐桌状态");
            System.out.println("\t\t\t 2 预定餐桌");
            System.out.println("\t\t\t 3 显示所有菜品");
            System.out.println("\t\t\t 4 点餐服务");
            System.out.println("\t\t\t 5 查看账单");
            System.out.println("\t\t\t 6 结账");
            System.out.println("\t\t\t 0 退出满汉楼二级菜单");
            System.out.println("请输入你的选择");
            choose = Utility.readInt();
            switch (choose) {
                case 1:
                    System.out.println("显示餐桌状态为：");
                    showDiningTable();
                    break;
                case 2:
                    System.out.println("预定餐桌");
                    bookTable();
                    break;
                case 3:
                    System.out.println("显示所有菜品");
                    bookMenu();
                    break;
                case 4:
                    System.out.println("点餐服务");
                    orderMeal();
                    break;
                case 5:
                    System.out.println("查看账单");
                    checkBill();
                    break;
                case 6:
                    System.out.println("结账");
                    payBill();
                    break;
                case 0:
                    System.out.println("退出满汉楼二级菜单");
                    loop = false;
                    break;
                default:
                    System.out.println("重新输入");
            }
        }
    }

    // 显示所有餐桌状态
    public void showDiningTable() {
        List<DiningTable> diningTable = diningTableService.getDiningTable();
        for (DiningTable dinner : diningTable) {
            System.out.println(dinner);
        }
    }

    //预定餐桌
    public void bookTable() {
        System.out.println("请输入预定餐桌的编号：(-1 退出):");
        int num = Utility.readInt();
        if (num == -1) {
            System.out.println("放弃预定");
            return;
        }
        char book = Utility.readConfirmSelection();
        if (book == 'Y') {
            // 根据book 返回对应的DiningTable对象，如果为null，则不存在
            DiningTable diningTableFromId = diningTableService.getDiningTableFromId(num);
            if (diningTableFromId == null) {
                System.out.println("预定的餐桌不存在");
                return;
            } else if ("空".equals(diningTableFromId.getState())) {
                System.out.println("输入预订人的姓名为：");
                String Name = Utility.readString(50);
                System.out.println("输入预订人的电话为：");
                String Tel = Utility.readString(50);
                diningTableService.orderMegFromId(num, Name, Tel);
                if (diningTableService.orderMegFromId(num, Name, Tel)){
                    System.out.println("预定成功");
                }else{
                    System.out.println("预定失败");
                }
            } else {
                System.out.println("餐桌已经被预定了");
                return;
            }
        } else {
            System.out.println("取消预定");
            return;
        }


    }

    //显示菜品
    public void bookMenu(){
        List<Menu> menuDao = menuService.getMenuDao();
        System.out.println("\t\t菜品编号 \t\t菜品名 \t\t价格 \t\t余量 \t\t种类");
        for (Menu menu: menuDao) {
            System.out.println(menu);
        }
    }

    //点餐服务
    public void orderMeal(){
        System.out.println("输入点餐桌号(-1 退出)");
        int diningtableid = Utility.readInt();
        exit(diningtableid);
        System.out.println("输入点餐菜品号(-1 退出)");
        int menuid = Utility.readInt();
        exit(menuid);
        System.out.println("输入点餐菜品数量");
        int menunum = Utility.readInt();
        exit(menunum);



        //验证餐桌号是否存在
        DiningTable diningTableFromId = diningTableService.getDiningTableFromId(diningtableid);
        if (diningTableFromId == null){
            System.out.println("餐桌号不存在");
            return;
        }
        //验证菜品是否存在
        Menu menuFromId = menuService.getMenuFromId(menuid);
        if (menuFromId == null){
            System.out.println("菜品号不存在");
            return;
        }
        boolean ordermenu = billService.orderMenu(menuid, menunum, diningtableid);
        if (ordermenu){

            // 余量
            Integer surplus = menuService.getMenuFromId(menuid).getSurplus();
            surplus -= menunum;
            menuService.updateMenuFromId(menuid,surplus);



            System.out.println("点餐成功");
        }else{
            System.out.println("点餐失败");
        }

    }

    //-1 退出
    public void exit(int i){

        if (i == -1) {
            System.out.println("取消");
            bool =false;
        }
    }
    //查看账单
    public void checkBill(){
//        List<Bill> bills = billService.billList();
//        System.out.println("\n编号  \t菜品编号 \t餐桌号 " +
//                "\t菜品数目 \t菜品名字 \t下单时间 \t\t\t\t\t账单状态 \t总金额");
//        for (Bill bill : bills){
//            System.out.println(bill);
//        }
        List<MultiTableBean> multiTableBeans = billService.billList2();
        System.out.println("\n编号  \t菜品编号 \t餐桌号 " +
                "\t菜品数目 \t菜品名字 \t下单时间 \t\t\t\t\t账单状态 \t总金额  \t菜品名 \t 价格");
        for (MultiTableBean multiTableBean : multiTableBeans){
            System.out.println(multiTableBean);
        }
    }
    //结账
    public void payBill(){
        System.out.println("请输入要结账的餐桌编号(-1退出)");
        int diningtableid = Utility.readInt();
        exit(diningtableid);
        //验证 餐桌是否存在
        DiningTable diningTableFromId = diningTableService.getDiningTableFromId(diningtableid);
        if (diningTableFromId == null){
            System.out.println("餐桌不存在");
            return ;
        }
        //验证餐桌是否有需要结账的账单
        boolean payBillByDiningTable = billService.hasPayBillByDiningTable(diningtableid);
        if (!payBillByDiningTable){
            System.out.println("没有待完成的账单");
            return;
        }
        System.out.println("请输入要结账的方式(现金/支付宝/微信),回车表示默认方式(空串)");
        String paymode = Utility.readString(20,"");
        if ("空".equals(paymode)){
            System.out.println("未1结账");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c=='Y'){
            boolean payment = billService.payment(diningtableid, paymode);
            if (payment){
                System.out.println("结束结账");
            }else{
                System.out.println("未2结账");
            }
        }else{
            System.out.println("未3结账");
        }


    }
}
