package com.I_OStream.Buffer_;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferWrite_ {
    public static void main(String[] args) throws Exception{
        String filepath = "e:/hello.txt";
        // 1. new FileWriter(filePath, true) 表示以追加的方式写入
        // 2. new FileWriter(filePath) , 表示以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath/*,true*/));
        bufferedWriter.write("hello,word!");
        //插入一个和系统相关的换行
        bufferedWriter.newLine();
        bufferedWriter.write("hello1,word!");
        //插入一个和系统相关的换行
        bufferedWriter.newLine();
        bufferedWriter.write("hello2,word!");
        //插入一个和系统相关的换行
        bufferedWriter.newLine();

        //说明：关闭外层包装流即可，传入的new FileWriter(filepath)会在底层执行时关闭
        bufferedWriter.close();
    }
}
