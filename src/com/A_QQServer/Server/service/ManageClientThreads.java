package com.A_QQServer.Server.service;

import java.util.HashMap;
import java.util.Iterator;

//管理和客户端通信的线程
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hashMap = new HashMap<>();

    //返回hashmap
    public static HashMap<String, ServerConnectClientThread> getHashMap() {
        return hashMap;
    }

    //添加线程对象到hashMap集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){

        hashMap.put(userId,serverConnectClientThread);

    }

    //根据userid返回ServerConnectThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return  hashMap.get(userId);
    }

    // 在此处写方法，可以返回在线用户列表
    public static String getOnlineUser(){
        Iterator<String> iterator = hashMap.keySet().iterator();
        String onlineUserList = " ";
        while(iterator.hasNext()){
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }
    //从集合中移除某个对象
    public static void removeServerConnectClientThread(String userId){
        hashMap.remove(userId);

    }
}
