package com.tenhomework;

public class two {
    public static void main(String[] args) {
        Phone phone = new Phone();
        // 1.匿名内部类是
            /*
            new Computer() {
                @Override
                public double work(double a, double b) {
                    return a + b;
                }
            }    //同时是一个对象
            其编译类型  接口类型 Computer
            其运行类型  匿名内部类(系统分配的带有$的类名)
             */
        //
        phone.testwork(new Computer() {
            @Override
            public double work(double a, double b) {
                return a + b;
            }
        },10,8);
        phone.testwork(new Computer() {
            @Override
            public double work(double a, double b) {
                return a * b;
            }
        },11,8);
    }

}

interface Computer{
    //具体方法交给匿名内部类实现
   public double work(double a,double b);
}

class Phone{
    //当调用testwork方法时，直接传入Computer的匿名内部类即可
    //该匿名内部类可以灵活实现不同的计算任务
    public void testwork(Computer com,double c,double d){
        double res =com.work(c,d) ;  //动态绑定
        System.out.println(res);
    }
}