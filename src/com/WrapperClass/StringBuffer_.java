package com.WrapperClass;

public class StringBuffer_{
    //StringBuffer 直接父类 AbstractStringBuilder
    //StringBuffer 实现了 Serializable, 即StringBuffer 的对象可以串行化
    //在父类中AbstractStringBuilder有属性char[]value,不是final,该value数组存放字符串内容,引出存放在堆中的
    //StringBuffer 是一个 final 类，不能被继承
    //因为 StringBuffer 字符内容是存在char[]value,所以在变化(即增加/删除)时，不用每次都更换地址(即不是每次创建新对象)，所以效率高于String

    //String VS StringBuffer  pdf 590页


    public static void main(String[] args) {
        // String——>StringBuffer
        String str = "ry";

        // 方式一  使用构造器
        // 注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);

        //方式 2 使用的是 append 方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);




        //StringBuffer ->String
        StringBuffer sb3 = new StringBuffer("韩顺平教育");

        //方式 1 使用 StringBuffer 提供的 toString 方法
        String s = sb3.toString();
        //方式 2: 使用构造器来搞定
        String s1 = new String(sb3);

    }

}