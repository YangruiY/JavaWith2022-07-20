package com.ManHan_Building.Service;

import com.ManHan_Building.Dao.BillDao;
import com.ManHan_Building.Dao.MultiTableDao;
import com.ManHan_Building.Domain.Bill;
import com.ManHan_Building.Domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    //定义 BillDao 属性
    private BillDao billDao = new BillDao();


    //定义  DiningTableService和MenuService的属性，实现Service之间的相互调用
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDao multiTableBeanDao = new MultiTableDao();

    //生成账单，更新对应餐桌的状态
    public boolean orderMenu(int menuid,int menunum,int diningtableid){
        //生成账单号,菜名单独得到，而且金额要计算
        String uuid = UUID.randomUUID().toString();
        int update = billDao.update("insert into bill values(null,?,?,?,?,?,now(),'未结账',?)",
                uuid, menuid, diningtableid, menunum,
                menuService.getMenuFromId(menuid).getName(),
                menuService.getMenuFromId(menuid).getPrice() * menunum);
        if(update <= 0){
         return  false;
        }

        //修改餐桌状态
       return diningTableService.updatedDiningTableState(diningtableid,"就餐中");
    }

    // 返回所有账单
    public List<Bill> billList(){
        return billDao.queryMulti("select * from bill",Bill.class);
    }

    //是否有未结账的账单
    public boolean hasPayBillByDiningTable(int diningTableId){
        Bill bill = billDao.querySingle("select * from bill where diningtableid=? and billstate = '未结账' LIMIT 0,1", Bill.class, diningTableId);
        return bill != null;
    }

    //完成账单[如果餐桌存在，并且该餐桌有未结账的账单]
    public boolean payment(int diningtableId,String paymode){
        //1 修改 bill 表
        int update = billDao.update("update bill set billstate = ?  where diningtableid = ? and billstate = '未结账'",paymode,diningtableId);
        if (update <=0){
            return false;
        }
        //2 修改 diningtable 表
        return diningTableService.updatedDiningTable(diningtableId,"空");
    }









    // 返回所有账单
    public List<MultiTableBean> billList2(){
        return multiTableBeanDao.queryMulti("select bill.* ,name,price from bill,menu where bill.menuid = menu.id",MultiTableBean.class);
    }
}
