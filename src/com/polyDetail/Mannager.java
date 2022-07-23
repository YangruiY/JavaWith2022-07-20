package com.polyDetail;

public class Mannager extends Employ {
    private  double bouns;

    public Mannager(String name, double salary, double bouns) {
        super(name, salary);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
    public void  mannager(){
        System.out.println("经理:" +getName() +"正在管理~");
    }
    public double getannual(){
        double annual = 0.0;
        annual  = getSalary() * 15 + bouns;
        return annual;
    }
}
