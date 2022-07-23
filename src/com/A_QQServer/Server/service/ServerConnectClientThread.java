package com.A_QQServer.Server.service;

import com.A_QQServer.Common.Message;
import com.A_QQServer.Common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

//该类的对象和某个客户端保持通信
public class ServerConnectClientThread  extends  Thread{
    private Socket socket;
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //这里的线程处于run状态，可以接受和发送消息
        while(true){
            System.out.println("客户"+userId+"服务保持通讯");
            try {
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(socket.getInputStream());
                Message message = (Message)objectInputStream.readObject();
                //后面使用message，根据message的类型，做相应的业务
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE)){
                    //客户端在线列表
                    /*
                        在线用户列表 100 200 紫霞仙子

                     */
                    System.out.println(message.getSender() + "在线列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    // 返回 message
                    // 构建一个 Message 对象，返回给客户端
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE);
                    message1.setContent(onlineUser);
                    message1.setReceiver(message.getSender());
                    //写入数据通道，返回客户端
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message1);

                }else if(message.getMesType().equals(MessageType.MESSAGE_COM_MES)) {
                    //根据message获取getter id,然后再得到对应线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getReceiver());
                    //得到socket的对象输出流，将message对象转发给指定客户端
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream
                            (serverConnectClientThread.getSocket().getOutputStream());
                    objectOutputStream.writeObject(message); //转发，如果用户不在线可以保存到数据库，实现离线留言

                }else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    //客户端退出
                    System.out.println(message.getSender() + "退出");
                    //将客户端对应的线程，从集合删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();
                    //退出while循环
                    break;
                }else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //需要遍历管理线程的集合，把所有的线程的socket得到，然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hashMap = ManageClientThreads.getHashMap();
                    Iterator<String> iterator = hashMap.keySet().iterator();
                    while(iterator.hasNext()){
                        String onLineUserId = iterator.next().toString();
                        if (!onLineUserId.equals(message.getSender())){  //排除群发消息的本用户
                            //进行转发
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream
                                    (hashMap.get(onLineUserId).getSocket().getOutputStream());
                            objectOutputStream.writeObject(message);

                        }
                    }
                }else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据 receiverId 获取相应的表现成，将message 对象转发
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getReceiver());
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(
                                    serverConnectClientThread.getSocket().getOutputStream());
                    //直接转发
                    objectOutputStream.writeObject(message);
                } else {
                    System.out.println("暂不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
