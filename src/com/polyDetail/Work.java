package com.polyDetail;

public class Work extends Employ{
    public Work(String name, double salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println("普通员工:" + getName() + "正在工作~");
    }
    public double getannual(){
        double annual = 0.0;
        annual  = getSalary() * 11;
        return annual;
    }
}
