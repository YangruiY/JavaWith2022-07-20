package com.JDBC.Dao.domain;

import java.util.Date;

/**
 * Actor 对象和Actor 表相对应
 */
public class Actor {  //JavaBean POJO Domain
    private Integer id;
    private String name;
    private String sex;
    private Date brondate;
    private String phone;
    public Actor() {   //因为反射需要，此处一定要给一个无参构造器
    }

    public Actor(Integer id, String name, String sex, Date brondate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.brondate = brondate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "\n Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", brondate=" + brondate+ '\'' +
                ", phone='" + phone  +
                '}';
    }
}
