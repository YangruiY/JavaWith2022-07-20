package com.NetProgrammer.UDP_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiveA {
    public static void main(String[] args) throws Exception {

        //1. 创建一个 DatagramSocket 对象，准备在 9999 接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //2. 构建一个 DatagramPacket 对象，准备接收数据  ps: UDP 协议的一个数据包最大 64k
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象,填充到 packet 对象
            //ps :当有数据包发送到 本机的 9999 端口时，就会接收到数据
            // 如果没有数据包发送到 本机的 9999 端口, 就会阻塞等待.
        System.out.println("接收端A等待接受数据");
        datagramSocket.receive(datagramPacket);

        //4. 把 packet 进行拆包，取出数据，并显示.
        int length = datagramPacket.getLength();
        byte [] buf = datagramPacket.getData();
        String str = new String(buf,0,length);
        System.out.println(str);

        // 回复信息给B
        //将需要发送的数据，封装到 DatagramPacket 对象
        buf = "OK,明天见".getBytes();
        //说明: 封装的 DatagramPacket 对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        datagramPacket  =
                new DatagramPacket(buf, buf.length, InetAddress.getByName("10.4.32.170"), 9998);
        datagramSocket.send(datagramPacket);

        //5. 关闭资源
        datagramSocket.close();
        System.out.println("A结束");
    }
}
