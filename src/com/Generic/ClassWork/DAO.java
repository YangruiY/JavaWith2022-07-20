package com.Generic.ClassWork;

import java.util.*;

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    /*
        分别创建以下方法:
        (1) public void save(String id,T entity): 保存T类型的对象到Map成员变量中
        (2) public T get(String id): 从map中获取id对应的对象
        (3) public void update(String id,T entity): 替换map中key为id的内容,改为entity对象
        (4) public List<T> list(): 返回map中存放的所有T对象
        (5) public void delete(String id):删除指定id对象

     */
    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        //遍历map[k-v],返回map的所有value(T entity),封装到ArrayList并返回
        List<T> list = new ArrayList<>();
//        Set<String> keySet = map.keySet();
//        for (String key :keySet) {
//            list.add(map.get(key));
//        }


        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> next = iterator.next();

            //返回的就是User对象，放入到ArrayList
            list.add(next.getValue());
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }
}
