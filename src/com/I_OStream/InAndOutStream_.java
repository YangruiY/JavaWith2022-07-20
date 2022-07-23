package com.I_OStream;

public class InAndOutStream_ {
    public static void main(String[] args) {
        //System.in 类的 public static InputStream in = null;
        //System.in 编译类型 InputStream
        //System.in 运行类型 BufferInputStream
        //表示标准输入 键盘
        System.out.println(System.in.getClass());


        //System.out 为 public final static PrintStream out = null;
        //System.out 编译类型 PrintStream
        //System.out 运行类型 PrintStream
        //表示标准输出 显示器

        System.out.println(System.out.getClass());

    }
}
