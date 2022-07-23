package com.I_OStream.Buffer_;

import java.io.*;
// 思考：字节流可以操作二进制文件，可以操作文本文件吗？
// 当然可以
public class BufferCopyOfStream_ {
    public static void main(String[] args) {
        String  srcfilepath = "e:/无名.mp3";
        String  destfilepath = "e:/No Name.mp3";

        BufferedInputStream bufferedInputStream =null;
        BufferedOutputStream bufferedOutputStream =null;

        try {
            //因为FileInputStream 是InputStream的子类
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcfilepath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destfilepath));

            //循环读取文件并写入到 destfilepath 中
            byte[] bytes = new byte[2048];
            int readLen = 0;

            //当返回 -1 就读取完毕
            while((readLen =bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,readLen);
            }
            System.out.println("Copy Success");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            if (bufferedInputStream !=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
