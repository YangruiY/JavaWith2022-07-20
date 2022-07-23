package com.I_OStream.Buffer_;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReader_ {
    public static void main(String[] args)  throws Exception{
        String filepath = "e:\\news.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));

        String line;//按行读取,效率高

        /*说明：
            1. bufferedReader.readLine() 是按行读取文件
            2. 当返回 null 时，表示文件读取完毕
         */
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
//关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭节点流FileReader。
        /*
         源码：
                 public void close() throws IOException {
                    synchronized (lock) {
                        if (in == null)
                            return;
                        try {
                            in.close();  ////in 就是我们传入的 new FileReader(filePath), 关闭了.
                        } finally {
                            in = null;
                            cb = null;
                        }
                    }
                }
         */

        bufferedReader.close();


    }

}
