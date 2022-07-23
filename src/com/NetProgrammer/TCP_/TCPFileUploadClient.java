package com.NetProgrammer.TCP_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        // 客户端连接服务端 7777 端口号，得到 Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);
        //创建读取文件磁盘的输入流
        String filePath = "e:\\bg.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        //使用Stre
        // am.Utils 工具类
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //通过 socket 获取到输出流, 将 bytes 数据发送给服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);//将文件对应的字节数组的内容，写入到数据通道
        bufferedInputStream.close();
        socket.shutdownOutput();//设置写入数据的结束标记

        //  接收从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        //  使用 StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        //关闭相关的流
        inputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
