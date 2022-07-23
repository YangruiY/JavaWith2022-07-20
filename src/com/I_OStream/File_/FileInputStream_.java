package com.I_OStream.File_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    //演示读取文件,读取一个字节
    @Test
    public void readFile01() {
        String filePath = "e:\\news1.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建fileinputstream用于创建对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。如果返回-1 , 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);  //转成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //演示使用read(byte[] b)读取文件,读取效率提高
    public void readFile02() {
        String filePath = "e:\\news1.txt";
        int readLen = 0;
        FileInputStream fileInputStream = null;
        //定义字节数组
        byte[] bytes = new byte[8];
        try {
            //创建fileinputstream用于创建对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length个字节的数数组,此方法将阻塞，直到某些输入可用.如果返回-1,表示读取完毕,如果读取正常, 返回实际读取的字节数
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readLen));  //转成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
