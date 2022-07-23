package com.A_QQServer.Server.service;

import com.A_QQServer.Common.Message;
import com.A_QQServer.Common.MessageType;
import com.A_QQServer.Common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

//服务器，监听9999，等待客户端的连接并保持通信
public class QQ_Server {
    private ServerSocket serverSocket = null;
    //创建一个集合,存放多个用户，如果是这些用户登录,就说明是合法的
    //ConcurrentHashMap 可以处理并发的集合，没有线程安全问题
    //hashMap 没有处理线程安全，因此在多线程情况下是不安全的
    //ConcurrentHashMap 处理线程安全，即线程同步处理，因此在多线程情况下是安全的

    private static ConcurrentHashMap<String,User> validUsers = new ConcurrentHashMap<>();
    static {
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));
    }
    //验证用户是否有效的方法
    private boolean checkUser(String userId,String password){
        User user = validUsers.get(userId);
        if (user == null){
            System.out.println("不存在该user");
            return false;
        }
        if (!user.getPassword().equals(password)){
            System.out.println("密码错误");
            return false;
        }
        return true;
    }

    public QQ_Server(){
        System.out.println("服务端端口在9999监听");
        try {
            new Thread(new SendNewsToAllService()).start();
            serverSocket = new ServerSocket(9999);
            while(true){
                //当和某个客户端连接后会继续监听，所以while循环
                Socket socket = serverSocket.accept(); // 如果没有客户端连接就会阻塞
                //得到socket关联的对象输入流
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(socket.getOutputStream());

                User user = (User)objectInputStream.readObject();

                    //此处应该和数据库相连

                    //创建一个Message对象，准备回复客户端
                    Message message = new Message();
                    //验证
                    if (checkUser(user.getUserId(),user.getPassword())){
                        //合法
                        message.setMesType(MessageType.MESSAGE_LOGIN_SUCCESS);
                        //将 message 对象回复给客户端
                        objectOutputStream.writeObject(message);

                        //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                        ServerConnectClientThread serverConnectClientThread =
                                new ServerConnectClientThread(socket, user.getUserId());

                        //启动线程
                        serverConnectClientThread.start();
                        //把该线程对象放入到集合中进行管理
                        ManageClientThreads.addClientThread(user.getUserId(),serverConnectClientThread);
                    }else{
                        //登录失败
                        message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                        objectOutputStream.writeObject(message);
                        socket.close();

                    }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务器端退出了while，则服务器端不再监听，因此关闭serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
