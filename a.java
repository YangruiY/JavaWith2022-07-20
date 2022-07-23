package com.I_OStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        /*
        完成 文件拷贝，将 e:\\XXXX拷贝 c:\\
        思路分析：
            1. 创建文件的输入流 , 将文件读入到程序
            2. 创建文件的输出流， 将读取到的文件数据，写入到指定的文件.
         */
        String filepath = "C:\\Users\\Administrator\\Desktop\\转\\Han" +
                "\\韩顺平 2021零基础学Java 【软件 资料 代码 笔记】\\资料\\分享资料\\无名.mp3";
        String destfilepath = "e:\\无名.mp3";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
            fileOutputStream = new FileOutputStream(destfilepath);
            //定义一个字节数组
            byte[] bytes = new byte[2048];
            int readLen = 0;
            while((readLen = fileInputStream.read(bytes)) != -1){
                //读取到后就写入文件(是边读边写的)
                fileOutputStream.write(bytes);

            }
            System.out.println("copy success");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
