package com.ManHan_Building.Service;

import com.ManHan_Building.Dao.MenuDao;
import com.ManHan_Building.Domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDao menuDao = new MenuDao();
    //所有菜品

    public List<Menu> getMenuDao() {
        List<Menu> menus = menuDao.queryMulti("select * from menu", Menu.class);
        return menus;
    }
    // 由id 得到Menu对象
    public Menu getMenuFromId(int id){
        return menuDao.querySingle("select * from menu where id = ?",Menu.class,id);
    }
    public boolean updateMenuFromId(int id,int surplus){
        int update = menuDao.update("update menu set surplus=? where id =? ", surplus, id);
        return update>0;
    }
}
