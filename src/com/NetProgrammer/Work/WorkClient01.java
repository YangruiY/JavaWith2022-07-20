package com.NetProgrammer.Work;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


//此处对比于02 此处是字符流，用于传送文本 (02 01 是字节流，可传图片视频音频等)

//字符流  将getOutputStream()得到的outputstream,OutputStream 转化成Writer(使用转换流[OutputStreamWriter])
@SuppressWarnings({"all"})
public class WorkClient01 {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务端(ip,端口)
        // 连接本机的9999端口，如果连接成功返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("Client socket "+socket.getClass());
        // 2. 连接上后，生成socket,通过socket.getOutputStream()
        //得到和Socket对相关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3. 通过输出流，写数据到数据通道，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户问题
        Scanner scanner = new Scanner(System.in);
        System.out.println("input question");
        String question = scanner.next();
        bufferedWriter.write(question);
        bufferedWriter.newLine(); //插入一个换行符，表示写入的内容结束(结束标记)，注意，要求对方使用readLine()
        bufferedWriter.flush();  //如果使用的是字符流，需要手动刷新，否则数据不会写入数据通道



        // 4.获取和socket关联的输入流，读取数据(字节)，并显示
        InputStream inputStream = socket.getInputStream();
        //转换流  (得到服务端发来的hello，客户端 字符流)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s); // 输出


        // 5. 关闭流对象和socket,必须关闭
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("Client exit");

    }
}

