package com.Collection_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {
        // TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });
        //使用默认构造器创造TreeMap，存储也是无序的

        /*
            如果要求按照传入的 key (String) 的大小进行排序

        源码分析
        1. 在构造器中把传入的实现了 Comparator 接口的匿名内部类(对象)，传给 TreeMap 的 comparator
                   public TreeMap(Comparator < ? super K > comparator) {
            this.comparator = comparator;
        }
        2. 调用 put 方法
        2.1 第一次添加, 把 k - v 封装到 Entry 对象，放入 root
        Entry<K, V> t = root;
        if (t == null) {
            compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        2.2 添加时
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                //遍历所有的 key , 给当前 key 找到适当位置
                parent = t;
                cmp = cpr.compare(key, t.key);
                //动态绑定到我们的匿名内部类的 compare
                if (cmp < 0) t = t.left;
                else if (cmp > 0) t = t.right;
                else //如果遍历过程中，发现准备添加 Key 和当前已有的 Key 相等，就不添加
                    return t.setValue(value);
            } while (t != null);
        }
         */

        treeMap.put("ajack", "杰克");
        treeMap.put("btom", "汤姆");
        treeMap.put("ckristina", "克瑞斯提诺");
        treeMap.put("dsmith", "斯密斯");
        System.out.println(treeMap);
    }
}
