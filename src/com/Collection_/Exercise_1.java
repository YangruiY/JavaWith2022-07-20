package com.Collection_;

import java.util.LinkedList;
import java.util.List;

public class Exercise_1 {
    public static void main(String[] args) {
        //List list= new ArrayList();
        List list= new LinkedList();

        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
        //list.add(new Book("西游记", "吴承恩", 10));
       // System.out.println(list);

        //遍历,输出
//        for (Object o :list) {
//            System.out.println(o);
//        }

        //冒泡排序
        sort(list);
        for (Object o :list) {
            System.out.println(o);
        }

    }

    // 静态方法
    public static void sort(List list){
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                //取出book
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if(book1.getPrice() > book2.getPrice()){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t" +
                "作者：" + author + "\t\t"+
                "价格：" + price +"\t\t" ;
    }
}

