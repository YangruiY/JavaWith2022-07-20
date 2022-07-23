package com.NetProgrammer.Work;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class WorkClient03 {
    public static void main(String[] args) throws Exception {
        //接收用户输入，指定下载文件输入名
        Scanner scanner = new Scanner(System.in);
        System.out.println("input download name");
        String downloadName = scanner.next();
        //客户端连接服务器，准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //将接收到的数据发送出去
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadName.getBytes());
        //设置写入结束标志
        socket.shutdownOutput();
        //读取服务器返回的文件(字节数组)
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(socket.getInputStream());
        //使用工具类
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //得到一个输出流，准备将bytes写入到磁盘文件
        String filePath = "e:\\"+downloadName + ".mp3";
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);
        //关闭相关资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("下载结束");
        //

    }
}
