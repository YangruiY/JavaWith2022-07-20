package com.I_OStream.Properties_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUsing_ {
    public static void main(String[] args) {

    }

    @Test
    //使用 Properties 类来读取 mysql.properties 文件
    public void read() throws IOException {
        //1. 创建 Properties 对象
        Properties properties = new Properties();

        //2.加载指定配置文件
        properties.load(new FileReader("src\\com\\I_OStream\\mysql.properties"));

        //3.把 k-v 显示控制台
        properties.list(System.out);

        //4.根据 key 获取对应的值
        String pwd = properties.getProperty("pwd");
        String user = properties.getProperty("user");
        System.out.println("user = " + user);
        System.out.println("pwd  = " + pwd);


    }

    //使用 Properties 类来创建 配置文件, 修改配置文件内容
    @Test
    public void write() throws IOException {
        Properties properties = new Properties();
        //创建

        /* 对于setProperty()而言：
           1.如果该文件没有 key 就是创建
           2.如果该文件有 key ,就是修改

           Properties 父类是 Hashtable ， 底层就是 Hashtable 核心方法
           底层源码：
             public synchronized V put(K key, V value) {
                // Make sure the value is not null
                if (value == null) {
                    throw new NullPointerException();
                }

                // Makes sure the key is not already in the hashtable.
                Entry<?,?> tab[] = table;
                int hash = key.hashCode();
                int index = (hash & 0x7FFFFFFF) % tab.length;
                @SuppressWarnings("unchecked")
                Entry<K,V> entry = (Entry<K,V>)tab[index];
                for(; entry != null ; entry = entry.next) {
                    if ((entry.hash == hash) && entry.key.equals(key)) {
                        V old = entry.value;
                        entry.value = value;   //如果 key 存在，就替换
                        return old;
                    }
                }
                        addEntry(hash, key, value, index); //如果是新 k, 就 addEntry
                return null;
            }

         */
        properties.setProperty("charSet", "utf8");
        properties.setProperty("user", "汤姆");
        properties.setProperty("ip", "128.192.192.255");

        //将 k-v 存储文件中即可
        properties.storeToXML(new FileOutputStream("src\\com\\I_OStream\\mysql2.properties"), null);

        System.out.println("保存配置成功~");



    }
}
