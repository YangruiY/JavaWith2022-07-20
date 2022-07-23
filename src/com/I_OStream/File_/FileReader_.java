package com.I_OStream.File_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    //单个字符读文件
    @Test
    public void readFile01(){
        String filepath = "e:\\news.txt";
        FileReader fileReader = null;
        int  data = 0;
        //创建fileReader对象
        try {
            fileReader = new FileReader(filepath);
            //读取
            while((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //字符数组读文件
    @Test
    public void readFile02(){
        String filepath = "e:\\news.txt";
        FileReader fileReader = null;
        int  readLen = 0;
        char[] bytes = new char[8];
        //创建fileReader对象
        try {
            fileReader = new FileReader(filepath);
            //使用read(bytes)读取。返回-1，则表示读到文件结尾
            while((readLen = fileReader.read(bytes)) != -1){
                System.out.print(new String(bytes,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
