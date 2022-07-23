package com.I_OStream.PrintStream_;

import org.junit.jupiter.api.Test;

import java.io.*;

/*
        字节打印流
     */
public class PrintWriter_ {
        public static void main(String[] args) throws IOException {
            PrintStream out = System.out;
            //默认情况下，PrintStream 输出数据的位置是标准输出，即显示器
            /*
            源码:
                 public void print(String s) {
                    if (s == null) {
                        s = "null";
                    }
                    write(s);
                }

             */
            out.println("hello");
            //因为 print 底层使用的是 write , 所以我们可以直接调用 write 进行打印/输出
            out.write("hello".getBytes());

            out.close();

            /*
                修改打印流输出的设备/位置
                输出修改成到 "e:\\f.txt"
                "{hello}" 就会输出到 e:\f.txt


                源码：

                    public static void setOut(PrintStream out) {
                        checkIO();
                        setOut0(out);
                    }

             */

           System.setOut(new PrintStream("e:/G.txt"));
            System.out.println("{hello}");


            System.out.println("\n\n\n");




        }
        //PrintWriter 使用方式
        @Test
        public void ma() throws IOException {
            PrintWriter printWrite = new PrintWriter(System.out);
            PrintWriter printWriter = new PrintWriter(new FileWriter("e:/A.txt"));
            printWriter.println("hi,NJU~");

            printWriter.close();  //flush + 关闭流, 才会将数据写入到文件.

        }
}
