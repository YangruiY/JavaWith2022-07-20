package com.NetProgrammer.TCP_;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/*
02 比01 多了一个返回的发送，即，客户端接收到服务器发来的 hello ,客户端
 */
@SuppressWarnings({"all"})
public class Client02 {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务端(ip,端口)
        // 连接本机的9999端口，如果连接成功返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket "+socket.getClass());
        // 2. 连接上后，生成socket,通过socket.getOutputStream()
        //得到和Socket对相关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3. 通过输入流，写数据到数据通道
        outputStream.write("hello,服务端".getBytes());

        // 此处是重点
        //设置结束标志
        socket.shutdownOutput();

        //相较于一而言多了下面的  “读”服务端发来的信息
        // 4.获取和socket关联的输入流，读取数据(字节)，并显示
        InputStream inputStream = socket.getInputStream();
        byte []bytes = new byte[2048];
        int readLen = 0;
        while((readLen = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,readLen));
        }

        // 5. 关闭流对象和socket,必须关闭
        outputStream.close();
        socket.close();
        System.out.println("Client exit");

    }
}

