package com.Collection_;

import java.util.Hashtable;

public class Hashtable_ {
    public static void main(String[] args){
        Hashtable hashtable = new Hashtable();
        hashtable.put("l",100);
        hashtable.put("s",200);
        hashtable.put("a",300);
        hashtable.put("l",300);
        hashtable.put("l1",300);
        hashtable.put("l2",300);
        hashtable.put("l3",300);
        hashtable.put("l4",300);
        hashtable.put("l5",300);
        hashtable.put("l6",300);
        hashtable.put("l7",300);
        System.out.println(hashtable);
        /*
        简述Hashtable的源码
         1.底层有数组 Hashtable$Entry[] 初始化大小11
         2.threshold 为 8(1 * 0.75 = 8)
         3.扩容:按照自己的扩容机制进行的
            执行方法 addEntry(hash, key, value, index);添加k-v 封装到Entry
            如果满足条件：if (count >= threshold) ，就进入rehash()方法进行扩容
            并按照 int newCapacity = (oldCapacity << 1) + 1 (2倍 + 1)的方式扩容
         */

    }
}

