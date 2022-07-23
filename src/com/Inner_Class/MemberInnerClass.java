package com.Inner_Class;

public class MemberInnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.f();
        //外部其他类，使用成员内部类的两种方式


        // 第一种方式
        // outerClass.new InnerClass(); 相当于把 new OuterClass()当做是 outerClass 成员
        // 这就是一个语法，不要特别的纠结.
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.say();
        // 第二方式 在外部类中，编写一个方法，可以返回 InnerClass 对象
        OuterClass.InnerClass innerClass1 = outerClass.getInnerClass();
        innerClass1.say();

    }
}

class OuterClass {
    private int n = 100;
    public String name = "Tom";

    private void hi() {
        System.out.println("Bye~Bye~");
    }

    //成员内部类
    //注意: 成员内部类，是定义在外部内的成员位置上
    class InnerClass {
        private int n = 24;
        private double b = 1.2;

        public void say() {
            System.out.println("n\t" + n + "\n" + "name\t" + name);
            System.out.println(n);
            // 如果成员内部类的成员和外部类的成员重名，会遵守就近原则.
            // 可以通过 外部类名.this.属性 来访问外部类的成员
            System.out.println(OuterClass.this.n);
            hi();
        }

    }

    //外部类使用成员内部类的方法
    public void f() {
        InnerClass innerClass = new InnerClass();
        innerClass.say();
        System.out.println(innerClass.b);
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }
}