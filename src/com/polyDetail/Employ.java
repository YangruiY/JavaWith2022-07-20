package com.polyDetail;

public class Employ {
    private String name;
    private double salary;

    public Employ(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getannual(){
        double annual = 0.0;
        annual  = salary * 12;
        return annual;
    }


}
