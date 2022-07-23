package com.WrapperClass;

public class StringBuilder_{
    public static void main(String[] args) {

        // StringBuilder 的直接父类 是 AbstractStringBuilder
        // StringBuilder 实现了 Serializable, 即 StringBuilder 的对象可以串行化,可以进行网络编程
        // StringBuilder是final的，不可以被继承
        // StringBuilder对象字符序列依然是存放在父类AbstractStringBuilder的char[] value，因此字符序列是在堆里面的
        //StringBuilder的方法没有做互斥处理，即没有Synchronized关键字，因此在单线程下使用


        //String、StringBuffer 和 StringBuilder 的比较  pdf 598页
        StringBuilder stringBuilder = new StringBuilder();
        // 三者 java 效率 ： StringBuilder > StringBuffer > String
        //String、StringBuffer 和 StringBuilder 的选择  pdf 600页

    }
}
