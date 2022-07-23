package com.polyDetail;

public class EmployTest {
    public static void main(String[] args) {
        Work work = new Work("tom", 2500);
        Mannager mannager = new Mannager("jack", 3000, 45000);
        EmployTest employTest = new EmployTest();
        employTest.showEmploy(work);
        employTest.showEmploy(mannager);
        employTest.testWork(work);
        employTest.testWork(mannager);
    }
    public void showEmploy(Employ e){
        System.out.println(e.getannual());
    }

    //非常重要√√√√√√√√√√√
    public  void testWork(Employ e){
        Object o = new Object();
        if (e instanceof Work){
            ((Work) e).work();
        }else{
            ((Mannager) e).mannager();
        }
    }
}
