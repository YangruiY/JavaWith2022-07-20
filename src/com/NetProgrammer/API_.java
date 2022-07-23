package com.NetProgrammer;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {


        //演示相关方法


        // 1.获取本机 InetAddress 对象 getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);  //USER-20200508BL/127.0.0.1

        // 2.根据指定主机名/域名获取 InetAddress 对象
        InetAddress host1 = InetAddress.getByName("USER-20200508BL");
        System.out.println(host1);  //USER-20200508BL/127.0.0.1

        // 3.根据域名获取 InetAddress 对象 ,比如www.baidu.com对应的
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);   //www.baidu.com/36.152.44.96

        // 4.获取 InetAddress 对象的地址 getHostAddress
         String host2Address = host2.getHostAddress();
         System.out.println(host2Address); //36.152.44.96

        // 5.获取 InetAddress 对象的主机名/域名 getHostName
         String host2Name = host2.getHostName();
         System.out.println(host2Name); //www.baidu.com
    }
}
