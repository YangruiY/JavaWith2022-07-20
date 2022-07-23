package com.NetProgrammer.TCP_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class Server02{
    public static void main(String[] args) throws IOException {
        // 1.在本地的 9999(未被占用) 端口监听，等待连接
        // 这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server socket"+9999);

        // 2. 当客户端连接9999端口时，程序会阻塞，等待链接
        // 如果有客户端连接，则返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("Server socket" +socket.getClass());

        //3. 通过socket.getInputStream() 读取
        InputStream inputStream = socket.getInputStream();
        //4. 读取IO流
        byte[] bytes = new byte[1024];
        int readLine = 0;
        while((readLine = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,readLine)); // 根据读取的实际长度显示内容

        }

        //相比于01，多了一个发送给02的客户端
        // 5.获取socket相关输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello,客户端".getBytes());


        // 此处是重点
        //设置结束标志
        socket.shutdownInput();

        // 6. 关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
