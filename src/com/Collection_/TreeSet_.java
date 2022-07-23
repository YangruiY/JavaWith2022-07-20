package com.Collection_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {

        /*
            当我们使用无参构造器，创建 TreeSet 时，仍然是无序的，
             但是当我们希望添加的元素，按照字符串大小来排序，
             则可以使用 TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)，并指定排序规则
                追溯源码
                1. 构造器把传入的比较器对象赋给了 TreeSet 底层的 TreeMap 中的属性 this.comparator
                     public TreeSet(Comparator<? super E> comparator) {
                        this(new TreeMap<>(comparator));
                     }
                2. 在调用treeSet.add("tom"),在底层会执行到
                    if (cpr != null) {//cpr 就是我们的匿名内部类(对象)
                        do {
                             parent = t;
                             //动态绑定到我们的匿名内部类(对象)
                             compare cmp = cpr.compare(key, t.key);
                             if (cmp < 0)
                                t = t.left;
                                else if (cmp > 0)
                                t = t.right;
                              else //如果相等，即返回 0,这个 Key 就没有加入，直接设置为原来的value
                             return t.setValue(value);
                        } while (t != null);
                   }
                 }//添加模块的代码
                        else {
                            if (key == null)
                                throw new NullPointerException();
                            @SuppressWarnings("unchecked")
                                Comparable<? super K> k = (Comparable<? super K>) key;
                            do {
                                parent = t;
                                cmp = k.compareTo(t.key);
                                if (cmp < 0)
                                    t = t.left;
                                else if (cmp > 0)
                                    t = t.right;
                                else
                                    return t.setValue(value);
                            } while (t != null);

         */

       // TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 调用 String 的 compareTo 方法进行字符串大小比较
                // return ((String)o1).compareTo((String)o2);

                //按照长度大小
                return ((String)o1).length()- ((String)o2).length();
            }
        });
        treeSet.add("xixixi");
        treeSet.add("yiyiyi");//不会加入，因为源码中长度一旦相同就直接return 了,不会添加到TreeSet里面
        treeSet.add("haha");
        treeSet.add("heiheihei");

        System.out.println(treeSet);
    }
}
