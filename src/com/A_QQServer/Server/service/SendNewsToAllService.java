package com.A_QQServer.Server.service;

import com.A_QQServer.Common.Message;
import com.A_QQServer.Utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SendNewsToAllService implements Runnable{
    @Override
    public void run() {

        //推送多次
        while(true) {
            System.out.println("请输入服务器要推送的新闻/消息");
            String news = Utility.readString(100);
            if ("exit".equals(news)){
                break;
            }
            //构建一个消息，群发
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人说：" + news);

            //遍历当前所有的通信线程，得到socket,并发送message
            HashMap<String, ServerConnectClientThread> hashMap = ManageClientThreads.getHashMap();
            Set<String> keySet = hashMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String onLineUserId = iterator.next().toString();
                ServerConnectClientThread serverConnectClientThread = hashMap.get(onLineUserId);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream
                            (serverConnectClientThread.getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
