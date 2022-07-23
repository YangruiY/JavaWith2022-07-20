package com.Interface_;

//接口的修饰符 只能是 public 和默认，这点和类的修饰符是一样的
public interface Inter {
    //    接口中的属性,只能是 final 的，而且是 public static final 修饰符
    int n = 100;  //等价于  public static  final int n = 100;

    //  PS : 快速生成接口的抽象方法  alt +enter
    //  PS : 抽象类去实现接口时，可以不实现接口的抽象方法
    //接口中可以有方法
    // 1 抽象方法 2 默认实现方法 3 静态方法
    // 1 抽象方法
    //接口内的抽象方法可以不加 public abstract
    /* public  (abstract) */void hello();

    void ol();

    void face();

    // 2 默认实现方法
    //需要default
    default public void ok() {

    }

    // 3 静态方法
    //需要static
    public static void hi() {

    }

}

    interface A {
        int x = 0;   //想到 等价 public static final int x = 0;
    }
