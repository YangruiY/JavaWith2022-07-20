package com.ManHan_Building.Domain;

import java.time.LocalDateTime;

/**
 * 这是一个可以和多个表进行对应的 javabean
 */
public class MultiTableBean {

    // 此处的属性名 最好要和 表 的类名保持一致，不然要对select语句进行修改 As 别名
    private Integer id;
    private String billid;
    private Integer menuid;
    private Integer diningtableid;
    private Integer menunum;
    private String  menuname;
    private LocalDateTime billdate;
    private String billstate;
    private Double totalprice;
    //加上Menu的name 字段
    private String name;

    public MultiTableBean(Integer id, String billid, Integer menuid, Integer diningtableid, Integer menunum, String menuname, LocalDateTime billdate, String billstate, Double totalprice, String name, Double price) {
        this.id = id;
        this.billid = billid;
        this.menuid = menuid;
        this.diningtableid = diningtableid;
        this.menunum = menunum;
        this.menuname = menuname;
        this.billdate = billdate;
        this.billstate = billstate;
        this.totalprice = totalprice;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultiTableBean(Integer id, String billid, Integer menuid, Integer diningtableid, Integer menunum, String menuname, LocalDateTime billdate, String billstate, Double totalprice, String name) {
        this.id = id;
        this.billid = billid;
        this.menuid = menuid;
        this.diningtableid = diningtableid;
        this.menunum = menunum;
        this.menuname = menuname;
        this.billdate = billdate;
        this.billstate = billstate;
        this.totalprice = totalprice;
        this.name = name;
    }

    public LocalDateTime getBilldate() {
        return billdate;
    }

    public void setBilldate(LocalDateTime billdate) {
        this.billdate = billdate;
    }

    public void setBillstate(String billstate) {
        this.billstate = billstate;
    }

    public String getBillstate() {
        return billstate;
    }



    @Override
    public String toString() {
        return id +
                "\t\t" + menuid +
                "\t\t\t" + diningtableid +
                "\t\t" + menunum +
                "\t\t" + menuname +
                "\t\t" + billdate +
                "\t\t" + billstate +
                "\t\t" + totalprice +
                "\t\t" + name +
                "\t\t" + price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getDiningtableid() {
        return diningtableid;
    }

    public void setDiningtableid(Integer diningtableid) {
        this.diningtableid = diningtableid;
    }

    public Integer getMenunum() {
        return menunum;
    }

    public void setMenunum(Integer menunum) {
        this.menunum = menunum;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }


    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }


    public MultiTableBean() {
    }
}
