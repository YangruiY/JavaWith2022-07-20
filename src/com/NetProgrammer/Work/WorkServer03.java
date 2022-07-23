package com.NetProgrammer.Work;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WorkServer03 {
    public static void main(String[] args) throws Exception {
        //监听 9999 端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待客户端连接
        System.out.println("9999");
        Socket socket = serverSocket.accept();
        //读取客户端下载的文件名字    while()可适用于数据量较大时
        InputStream inputStream = socket.getInputStream();
        //写入到字节数组中
        byte[] bytes = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while((len = inputStream.read(bytes)) != -1){
            downLoadFileName += new String(bytes ,0 , len);
        }
        System.out.println("客户端需要下载的文件名 =" + downLoadFileName);

        // 无名.mp3
        String resFileName = "";
        if ("无名".equals(downLoadFileName)){
            resFileName = "src:\\无名.mp3 ";
        }else {
            resFileName = "e:\\孤勇者.mp3 ";
        }
        //创建输入流，读取文件
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(resFileName));
        //使用工具类StreamUtils,读取文件到字节
        byte[] bytes1 = StreamUtils.streamToByteArray(bufferedInputStream);
        //得到Socket关联的输出流
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(socket.getOutputStream());
        //写入到数据通道 返回文件字节数组给客户端
        bufferedOutputStream.close();
        socket.shutdownOutput();
        //关闭相关资源
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
