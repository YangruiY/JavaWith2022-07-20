package com.ManHan_Building.Domain;

import java.time.LocalDateTime;

/**
 * Javabean 的 Bill 和 bill 表匹配
 *  id INT PRIMARY KEY AUTO_INCREMENT,
 * 	billid VARCHAR(32) NOT NULL DEFAULT '' ,
 * 	menuid INT NOT NULL DEFAULT 0,
 * 	diningtableid INT NOT NULL DEFAULT 0,
 * 	menunum INT NOT NULL DEFAULT 0,
 * 	menuname VARCHAR(32) NOT NULL DEFAULT '' ,
 * 	billdate DATETIME NOT NULL,
 * 	billstate VARCHAR(32) NOT NULL DEFAULT '',
 * 	totalprice DOUBLE NOT NULL DEFAULT 0.0
 */
public class Bill {
    private Integer id;
    private String billid;
    private Integer menuid;
    private Integer diningtableid;
    private Integer menunum;
    private String  menuname;
    private LocalDateTime billdate;
    private String billstate;
    private Double totalprice;

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
        return   id +
                "\t\t" + menuid +
                "\t\t\t" + diningtableid +
                "\t\t" + menunum +
                "\t\t" + menuname +
                "\t\t" + billdate +
                "\t\t" + billstate +
                "\t\t" + totalprice;
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

    public Bill(Integer id, String billid, Integer menuid, Integer diningtableid, Integer menunum, String menuname, LocalDateTime billdate, String billstate, Double totalprice) {
        this.id = id;
        this.billid = billid;
        this.menuid = menuid;
        this.diningtableid = diningtableid;
        this.menunum = menunum;
        this.menuname = menuname;
        this.billdate = billdate;
        this.billstate = billstate;
        this.totalprice = totalprice;
    }

    public Bill() {
    }
}
