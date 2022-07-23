package com.Enum;

public class Enum_ {
    public static void main(String[] args) {


        /*
        name():
             //输出枚举对象的名字
             System.out.println(autumn.name());

        ordinal()
            //输出的是该枚举对象的次序/编号，从 0 开始编号
            //AUTUMN 枚举对象是第三个，因此输出 2 System.out.println(autumn.ordinal());

        values()
            //从反编译可以看出 values 方法，返回 Season2[]
            //含有定义的所有枚举对象
            Season2[] values = Season2.values();
            System.out.println("===遍历取出枚举对象(增强 for)====");
            for (Season2 season: values) {
                //增强 for 循环
                System.out.println(season);
            }


            //valueOf：将字符串转换成枚举对象，要求字符串必须 为已有的常量名，否则报异常
            //执行流程
            //1. 根据你输入的 "AUTUMN" 到 Season2 的枚举对象去查找
            //2. 如果找到了，就返回，如果没有找到，就报错
            Season2 autumn1 = Season2.valueOf("AUTUMN");
            System.out.println("autumn1=" + autumn1);
            System.out.println(autumn == autumn1);


            //compareTo：比较两个枚举常量，比较的就是编号
            //1. 就是把 Season2.AUTUMN 枚举对象的编号 和 Season2.SUMMER 枚举对象的编号比较
            //2. 看看结果
            源码： return self.ordinal - other.ordinal;

            代码：System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));   //输出的是一个数字
         */







        Week[] values = Week.values();
        for(Week week : values){
            System.out.println(week);
        }
    }
}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),
    THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),
    SUNDAY("星期日");
    private String name;

    Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }

}
