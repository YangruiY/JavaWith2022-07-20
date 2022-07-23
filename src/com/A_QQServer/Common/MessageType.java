package com.A_QQServer.Common;

public interface MessageType {
    //在接口中定义一些常量表示不同的消息类型
    String MESSAGE_LOGIN_SUCCESS ="1";
    String MESSAGE_LOGIN_FAIL ="2";
    String MESSAGE_COM_MES = "3";//普通信息包
    String MESSAGE_GET_ONLINE = "4";//返回在线用户
    String MESSAGE_RET_ONLINE = "5";//返回在线列表
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出
    String MESSAGE_TO_ALL_MES = "7";//群发消息
    String MESSAGE_FILE_MES = "8";//文件消息

}
