package com.I_OStream.Transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//OutputStreamWrite字节转换流
//把 FileOutputStream 字节流 转换成 OutputStreamWriter字符流，其中指定编码为 gbk/utf-8/utf8
public class OutputStreamWrite_ {
    public static void main(String[] args) throws IOException {
        String  filepath = "e:/b.txt";
        String charSetName = "utf-8";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filepath),charSetName );
        outputStreamWriter.write("hi.java基础知识");
        outputStreamWriter.close();
        System.out.println("编码方式" + charSetName);
    }
}
