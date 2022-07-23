package com.NetProgrammer.TCP_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/*
分析：字节读取
    Client端 发送hello,server 给 Server端
    连接上服务端之后，生成Socket,通过socket.getOutPutStream()的方式输出
    通过输出流写数据到数据通道

 */
public class Client01{
    public static void main(String[] args) throws IOException {
        // 1. 连接服务端(ip,端口)
          // 连接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端端口类型"+socket.getClass());
        //转到服务器端继续写

        // 2. 连接上后，生成socket,通过socket.getOutputStream()
          //得到和Socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3. 通过输入流，写数据到数据通道
        outputStream.write("hello,服务端".getBytes());
        // 4. 关闭流对象和socket,必须关闭
        outputStream.close();
        socket.close();
        System.out.println("Client exit");
        //转到服务器端继续写
    }
}
