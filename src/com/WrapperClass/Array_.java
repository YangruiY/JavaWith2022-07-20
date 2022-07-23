package com.WrapperClass;


import java.util.Arrays;
import java.util.Comparator;

public class Array_ {
    public static void main(String[] args) {
        Book[] book = new Book[4];
        book[0] = new Book("红楼梦", 100);
        book[1] = new Book("金瓶梅新", 90);
        book[2] = new Book("青年文摘 20 年", 5);
        book[3] = new Book("java 从入门到放弃~", 300);


        //price从大到小排序
//            Arrays.sort(book, new Comparator() {
//                        @Override
//                        public int compare(Object o1, Object o2) {
//                            Book book1 = (Book) o1;
//                            Book book2 = (Book) o2;
//                            double differ = book2.getPrice() - book1.getPrice();
//                            if (differ > 0){
//                                return  1;
//                            }else if (differ < 0){
//                                return  -1;
//                            }else {
//                                return 0;
//                            }
//                        }
//                    });
//            System.out.println(Arrays.toString(book));


        //price从大到小排序
//            Arrays.sort(book, new Comparator() {
//                @Override
//                public int compare(Object o1, Object o2) {
//                    Book book1 = (Book) o1;
//                    Book book2 = (Book) o2;
//                    double differ = book1.getPrice() - book2.getPrice();
//                    if (differ > 0){
//                        return  1;
//                    }else if (differ < 0){
//                        return  -1;
//                    }else {
//                        return 0;
//                    }
//                }
//            });
//            System.out.println(Arrays.toString(book));
        //书名name的长度
        Arrays.sort(book, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double differ = book2.getName().length() - book1.getName().length();
                if (differ > 0){
                    return  1;
                }else if (differ < 0){
                    return  -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(book));
    }
}

class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
