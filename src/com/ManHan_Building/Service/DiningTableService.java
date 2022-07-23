package com.ManHan_Building.Service;

import com.ManHan_Building.Dao.DiningTableDao;
import com.ManHan_Building.Domain.DiningTable;

import java.util.List;

/**
 * 业务层  返回所有餐桌信息
 */
public class DiningTableService {
    private DiningTableDao diningTableDao = new DiningTableDao();
    
    public List<DiningTable> getDiningTable(){
        List<DiningTable> diningTables = diningTableDao.queryMulti("select * from diningTable", DiningTable.class);
        return diningTables;
    }
    public DiningTable getDiningTableFromId(int Id){
        return diningTableDao.querySingle("select * from diningTable where id = ?", DiningTable.class,Id);
    }

    //如果餐桌可以预定。进行状态更新并返回信息
    public boolean orderMegFromId(int Id,String orderName,String orderTel){
        int rows = diningTableDao.update("update diningTable set state=?, orderName= ?,orderTel=? where id =?",  "已经预定", orderName, orderTel,Id);
        System.out.println(rows > 0 ? "预定更新完成":"预定更新失败");
        return rows >0;
    }

    //更新餐桌的状态
    public boolean updatedDiningTableState(int id,String state){
        int update = diningTableDao.update("update diningtable set state=? where id= ?", state, id);
        if (update>0){
            return true;
        }else{
            return false;
        }
    }

    //更新餐桌的状态并将diningtable 的 orderName 和 orderTel 置空
    public boolean updatedDiningTable(int id,String state){
        int update = diningTableDao.update("update diningtable set state=?,orderName = ?,orderTel = ? where id= ?", state," "," ", id);
        if (update>0){
            return true;
        }else{
            return false;
        }
    }
}
