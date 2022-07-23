package com.I_OStream.Properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//配置文件
public class Properties_ {
    public static void main(String[] args) throws IOException {
        //读取 mysql.properties 文件，并得到 ip, user 和 pwd
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\com\\I_OStream\\mysql.properties"));
        String line = "";
        while((line = bufferedReader.readLine()) != null){ //循环读取
            String[] split = line.split("=");

            //如果我们要求指定的 ip 值
            if ("ip".equals(split[0])) {
                System.out.println(split[0] + "值为：" + split[1]);
            }
        }
        bufferedReader.close();
    }
}
