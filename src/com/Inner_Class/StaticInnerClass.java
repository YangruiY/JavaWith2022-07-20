package com.Inner_Class;

public class StaticInnerClass {
    public static void main(String[] args) {
        StaticOuter staticOuter = new StaticOuter();
        staticOuter.m();

        //外部其他类 使用静态内部类

        // 方式 1
        // 因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
        StaticOuter.Innerstatic innerstatic = new StaticOuter.Innerstatic();
        System.out.println("========");
        innerstatic.say();

        // 方式 2
        // 编写一个方法，可以返回静态内部类的对象实例.
        StaticOuter.Innerstatic getinnerstatic = new StaticOuter().getinnerstatic();
        System.out.println("---------");
        getinnerstatic.say();
        //或者静态get方法
        StaticOuter.Innerstatic innerstatic1 = new StaticOuter().getinnerstatic_();
        System.out.println("!!!!!!!!!!!!!!");
        innerstatic1.say();




    }
}
class StaticOuter{
    private int n =10;
    //静态成员
    private static String num = "000000";
    //静态方法
    private static void cry(){
        System.out.println("cry......");
    }

    // 静态内部类
    // 使用 static 修饰
    // 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    // 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员 //5. 作用域 ：同其他的成员，为整个类体
    static class Innerstatic{
        private static String num = "111111";
        // 如果外部类和静态内部类的成员重名时，静态内部类访问的时，
        // 默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.成员）
    public void say(){
        System.out.println("num = " + num);
        System.out.println("num = " +StaticOuter.num);
    }
    }

    //访问调用静态内部类
    public void m(){
        Innerstatic innerstatic = new Innerstatic();
        innerstatic.say();
        cry();
    }


    public Innerstatic getinnerstatic(){
        return  new Innerstatic();
    }
    public static Innerstatic getinnerstatic_(){
        return  new Innerstatic();
    }
 }