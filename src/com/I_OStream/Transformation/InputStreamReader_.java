package com.I_OStream.Transformation;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        /*
        问题：读取 e:\\a.txt文件到程序
        思路分析：
            1. 创建字符输入流 BufferedReader [处理流]
            2. 使用BufferedReader对象读取a.txt
            3. 默认情况下读取文件是按照UTF-8的格式来的   否则会出现乱码：java����֪ʶ
            4. 解决方法,指定转化编码--转换流

            题设：
            使用 InputStreamReader 转换流解决中文乱码问题，
            将字节流 FileInputStream 转成字符流 InputStreamReader, 指定编码 gbk/utf-8
         */
//                String  filepath = "e:/a.txt";
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
//                String s= bufferedReader.readLine();
//                System.out.println(s);
//                bufferedReader.close();

        //修改
        String  filepath = "e:/a.txt";
        /*
        1. 把FileInputStream 转化为  InputStreamReader
//        2. 指定编码方式 gbk
//         */
//        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath), "gbk");
//        /*
//        3. 将 InputStreamReader 传入 BufferedReader
//         */
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //2 3 合并
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                                new FileInputStream(filepath), "gbk"));
        //4. 读取
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }
}
