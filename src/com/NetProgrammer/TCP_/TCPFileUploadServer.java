package com.NetProgrammer.TCP_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    关于流的读写方法
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        // 服务端在本机监听 7777 端口
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务端在7777端口监听~");
        //等待连接
        Socket socket = serverSocket.accept();


        //从Client回来
        // 读取客户端发送的数据,通过 Socket 得到输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //4. 将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        String copyPath = "e:\\pb.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(copyPath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();


        //向Client回复收到数据,socket 获取到输出流(字符)
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到数据");
        bufferedWriter.flush();
        socket.shutdownOutput();

        //关闭资源
        bufferedWriter.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();



    }
}
