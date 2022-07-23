package com.I_OStream.Work_;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class work1_ {
    public static void main(String[] args) throws IOException {
        //目录
        String  filepath = "e:\\King";
        File file = new File(filepath);
        if(!file.exists()){
            //创建
            if(file.mkdirs()){
                System.out.println(filepath +" Success!");
            }else{
                System.out.println(filepath +" Fail!");
            }
        }
        //文件
        String path = filepath + "/k.txt";   //就等于 "e:\\King\k.txt"
        file = new File(path);
        if(!file.exists()){
            if (file.createNewFile()){
                System.out.println(path +" Success!");

                //文件存在就是用 BufferedWriter 字符输入流写入内容  BufferedWriter 处理流， FileWriter 节点流
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
                bufferedWriter.write("hi~ nju~ ");
                bufferedWriter.close();
            }else{
                System.out.println(path +" Fail!");
            }
        }else{
            System.out.println("Already exist~");
        }


    }
}
