package com.NetProgrammer.Work;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})

//字符流  将getInputStream()得到的inputstream,InputStream 转化成Reader(使用转换流[InputStreamReader])
public class WorkServer01{
    public static void main(String[] args) throws IOException {
        // 1.在本地的 9999(未被占用) 端口监听，等待连接
        // 这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server socket"+9999);

        // 2. 当客户端连接9999端口时，程序会阻塞，等待链接
        // 如果有客户端连接，则返回Socket对象，程序继续
        Socket socket = serverSocket.accept();



        //3. 通过socket.getInputStream() 读取
        InputStream inputStream = socket.getInputStream();
        //4. 读取IO流,使用字符流，使用 InputStreamReader 将 inputStream 转换成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        //得到客户端发来的(hello,服务端 字符流)
        System.out.println(s); // 输出

        //判断
        String answer = " ";
        if ("name".equals(s)){
            answer = " tom";
        }else if ("hobby".equals(s)){
            answer = "java";
        }else{
            answer = "nothing";
        }

        // 5.获取socket相关输出流
        OutputStream outputStream = socket.getOutputStream();
        // 使用字符输出流方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //发送给客户端(hello,客户端 字符流)
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();



        // 6. 关闭流和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
