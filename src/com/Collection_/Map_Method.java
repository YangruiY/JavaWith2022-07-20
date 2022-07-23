package com.Collection_;

import java.util.*;

public class Map_Method {
    // 1. Map 与 Collection 并列存在。用于保存具有映射关系的数据:Key-Value(双列元素)
    // 2. Map 中的 key 和 value 可以是任何引用类型的数据，会封装到 HashMap$Node 对象中
    public static void main(String[] args) {
        Map map = new HashMap();

        // 3. Map 中的 key 不允许重复，原因和 HashSet 一样，前面分析过源码.
        map.put("id1", "ry");
        map.put("id1", "ryr"); // put(key,value),key一样的时候就会被覆盖替掉
        // 4. Map 中的 value 可以重复
        map.put("id3", "ry");
        map.put("id4", "ry");
        map.put("id5", "ry");

        // 5. Map 的 key 可以为 null, value 也可以为 null ，注意 key 为 null,只能有一个，value 为 null ,可以多个
        map.put(null, null);//不显示，key=null只能一个,会被后面的覆盖替换掉
        map.put(null, "ry");
        map.put("id6", null);
        map.put("id7", null);

        // 6. 常用 String 类作为 Map 的 key,但是 key 也可以是任意类型
        map.put(new Object(), "yu");
        map.put(1, "ty");

        // 7. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
        System.out.println(map.get(1));
        System.out.println(map.get("id3"));

        System.out.println(map);

        /*

        1. k-v 最后是HashMap$Node node= newNode(hash,key,value,null)
        2. k-v 为了最后方便程序员遍历，还会 创建EntrySet集合，该集合存放的元素类型Entry，而一个Entry
            对象就有k,v EntrySet<Entry<k,v>> 即：transient Set<Map.entry<k,v>>entrySet;
        3. entrySet 中，定义的类型是Map.Entry,但是实际存放的还是HashMap$Node,这是因为
            HashMap$Node<k,v> implements map.Entry<k,v>
        4. 当把 HashMap$Node 对象存放到 entrySet 就方便遍历，因为Map.Entry提供了重要的方法
            K getKey(); V getValue();
         */

        Set set = map.entrySet();
        System.out.println(set.getClass());  //class java.util.HashMap$EntrySet

        for (Object obj : set) {
            //System.out.println(obj.getClass());   //class java.util.HashMap$Node

            /*
            从hashMap$Node中取出K-V操作如下
                 先向下转型
             */

            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());

        }
            /*
             map 接口常用方法
             put: 添加
             remove:根据键删除映射关系
             get：根据键获取值
             size:获取元素个数
             isEmpty:判断个数是否为 0
             clear:清除 k-v
             containsKey:查找键是否存在
             */

            /*
                Map遍历方式

            Map map1 = new HashMap();
            map1.put("邓超", "孙俪");
            map1.put("王宝强", "马蓉");
            map1.put("宋喆", "马蓉");
            map1.put("刘令博", null);
            map1.put(null, "刘亦菲");
            map1.put("鹿晗", "关晓彤");
            //第一组: 先取出 所有的 Key , 通过 Key 取出对应的 Value
            Set keyset = map1.keySet();
            //(1) 增强 for
            System.out.println("-----增强 for-------");
            for (Object key : keyset) {
                System.out.println(key + "-" + map1.get(key));
            }
            //(2) 迭代器
            System.out.println("----迭代器--------");
            Iterator iterator = keyset.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                System.out.println(key + "-" + map1.get(key));
            }
        }

        Map map2 = new HashMap();
        map2.put("邓超", "孙俪");
        map2.put("王宝强", "马蓉");
        map2.put("宋喆", "马蓉");
        map2.put("刘令博", null);
        map2.put(null, "刘亦菲");
        map2.put("鹿晗", "关晓彤");

        //第二组: 取出所有的 Value
        Collection values = map2.values();
        ////这里可以使用所有的 Collections 使用的遍历方法，即可以用 增强for 、一般for(看有没有索引决定可不可以用)、迭代器
        // (1) 增强 for
         System.out.println("---取出所有的 value 增强 for----");
         for (Object value : values) {
         System.out.println(value);
         }
         //(2) 迭代器
         System.out.println("---取出所有的 value 迭代器----");
         Iterator iterator2 = values.iterator();
         while (iterator2.hasNext()) {
         Object value = iterator2.next();
             System.out.println(value);
        }

         //因为没有索引，所以不可以用普通for循环进行遍历


        //第三组: 通过 EntrySet 来获取 k-v
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
        // (1) 增强 for
        System.out.println("----使用 EntrySet 的 for 增强(第 3 种)----");
        for (Object entry : entrySet) {
            //将 entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

        //(2) 迭代器
        System.out.println("----使用 EntrySet 的 迭代器(第 4 种)----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry = iterator3.next();
            //System.out.println(next.getClass());// HashMap$Node -实现-> Map.Entry (getKey,getValue)
            // 向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

             */


    }
}
