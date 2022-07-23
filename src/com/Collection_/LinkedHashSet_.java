
package com.Collection_;


import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSet_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
      /*

       //LinkedHashSet底层机制
          //解读
            //LinkedHashSet加入元素顺序和取出元素顺序是一样的
            //LinkedHashSet底层维护的是一个LinkedHashMap(HashMap的一个子类)
            //LinkedHashSet底层维护的是数组table + 双向链表
            //添加第一次的时候，直接将数组table扩容到16,存放的节点类型是LinkedHashMap$Entry
            //数组是HashMap$Node[] 存放的是元素/数据是 HashMap$Entry类型

            源码分析---------HashMap$Entry
                static class Entry<K,V> extends HashMap.Node<K,V> {
                    Entry<K,V> before, after;
                    Entry(int hash, K key, V value, Node<K,V> next) {
                        super(hash, key, value, next);
                    }
                }


        Set set = new LinkedHashSet();
                set.add(new String("AA"));
                set.add(123);
                set.add(123);
                set.add(new Customer("ry","1001"));
                set.add(456);
                set.add("ry");

                System.out.println(set);
                }

                }

class Customer{
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';

       */

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("特斯拉",212));
        linkedHashSet.add(new Car("特斯拉",213));
        linkedHashSet.add(new Car("特斯拉",211));
        linkedHashSet.add(new Car("宝马",200));
        linkedHashSet.add(new Car("奔驰",300));
        linkedHashSet.add(new Car("奥迪",100));
        linkedHashSet.add(new Car("奥迪",100));
        linkedHashSet.add(new Car("奥迪",100));
        linkedHashSet.add(new Car("法拉利",700));
        linkedHashSet.add(new Car("保时捷",300));

        System.out.println(linkedHashSet);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "price=" + price +"\n";
    }

    //name和price都相同就返回相同的hashcode，equals就返回true,并且加入不到linkedHashSet之中
    // 需要重写equals()和hashcode()方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
