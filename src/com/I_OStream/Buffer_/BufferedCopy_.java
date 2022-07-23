package com.I_OStream.Buffer_;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) {

        // 1.BufferedReader 和 BufferedWriter 是安装字符操作
        // 2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
        String ParFilePath = "e:/news.txt";
        String DestFilePath = "e:/a.java";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line ;
        try {
            bufferedReader = new BufferedReader(new FileReader(ParFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(DestFilePath));

            while ((line =bufferedReader.readLine()) != null){
                //每读一行就写入
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("copy success");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader !=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
