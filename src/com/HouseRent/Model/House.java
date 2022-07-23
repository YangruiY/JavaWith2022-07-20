package com.HouseRent.Model;
//model(数据)层     一个房屋信息

public class House {
    private int id;
    private String name;
    private String address;
    private int rent;
    private String state;
    private String phone;

    public House(int id, String name, String address, int rent, String state, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rent = rent;
        this.state = state;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return   id +
                "\t\t" + name +
                "\t" + address +
                "\t" + phone +
                "\t" + rent +
                "\t\t" + state ;
    }
}
