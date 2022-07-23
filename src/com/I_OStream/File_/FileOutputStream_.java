package com.I_OStream.File_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void OutPutstream() {
        FileOutputStream fileOutputStream = null;
        String filepath = "e:\\output.doc";
        try {

            // 1. new FileOutputStream(filepath)的创建方式，当写入内容时会覆盖原来的内容
            // 2. new FileOutputStream(filePath, true)的创建方式，当写入内容时是追加到文件后面
            //fileOutputStream = new FileOutputStream(filepath);
            fileOutputStream = new FileOutputStream(filepath, true);


            //写入一个字节
            //fileOutputStream.write('H');
            //写入一个字符串
            String str = "hello,word from ry ";
            //str.getBytes() 可以把字符串转化成字节
            //fileOutputStream.write(str.getBytes());
            System.out.println();
            //写某个数组到某个数组的位置
            /*write(byte[] b, int off, int len) 将 len 字节从位于偏移量 off 的指定字节数组写入此文件输出流 */
            fileOutputStream.write(str.getBytes(), 0, 5);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

