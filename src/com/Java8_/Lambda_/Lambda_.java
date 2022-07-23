package com.Java8_.Lambda_;

/**
 * Lambda 表达式的使用举例(引入)
 * <p>
 * <p>
 * <p>
 * public class Lambda_ {
 * public static void main(String[] args) {
 * m1();
 * m2();
 * }
 * public static void m1(){
 * Runnable runnable = new Runnable() {
 *
 * @Override public void run() {
 * System.out.println("nju");
 * }
 * };
 * <p>
 * runnable.run();
 * <p>
 * <p>
 * //lambda 表达式  ->
 * Runnable r2 =() -> System.out.println("nju");
 * r2.run();
 * }
 * <p>
 * <p>
 * public static void m2(){
 * Comparator<Integer> com1 = new Comparator<Integer>() {
 * @Override public int compare(Integer o1, Integer o2) {
 * return Integer.compare(o1,o2);
 * }
 * };
 * int compare1 = com1.compare(12,21);
 * System.out.println(compare1);
 * <p>
 * // Lambda 表达式  ->
 * Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
 * int compare2 = com2.compare(21,21);
 * System.out.println(compare2);
 * <p>
 * // 方法引用  ::
 * Comparator<Integer> com3 =  Integer::compare;
 * int compare3 = com3.compare(32,21);
 * System.out.println(compare3);
 * <p>
 * }
 * <p>
 * }
 */


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式的使用
 *
 * 1. 举例   (o1,o2) -> Integer.compare(o1,o2);
 * 2. 格式：
 *          ->: Lambda 称为操作符或者叫箭头操作符
 *          ->左边: Lambda形参列表(其实就是接口中的抽象方法的形参列表)
 *          ->右边：lambda体(其实就是重写的的抽象方法的方法体)
 *3.Lambda 表达式的使用(6种方法)
 *4.Lambda 表达式的本质 ：作为接口的实例
 *5.如果一个接口中只声明了一个抽象方法，则此接口就成为函数式接口   如Runnable compare 和自定义的等等
 *      函数式接口:可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 *      同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
 *6.所以之前如果是要用一个匿名实现类表示的现在都可以用在Lambda表达式来写
 *
 * 总结：
 *      Lambda左边：形参列表类型可以省略(类型推断):如果lambda形参列表只有一个参数，其一对小括号也可以省略
 *      Lambda右边：lambda体应该用一对{}包含，如果lambda体只有一条执行语句,{}和{return...} 可以省
 *
 */
public class Lambda_ {
    public static void main(String[] args) {

    }

    // 语法格式一: 无参，无返回值
    @Test
    public  void m1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("nju");
            }
        };

        runnable.run();


        //lambda 表达式  ->
        Runnable r2 = () -> System.out.println("nju");
        r2.run();
    }


    // 语法格式二:Lambda 需要一个参数，但是没有返回值
    @Test
    public  void m2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("南京");

        Consumer<String> cons2 = (String s) -> {
            System.out.println(s);
        };
        cons2.accept("鼓楼");
    }


    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断” [方式二的简化]
    @Test
    public  void m3(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("杭州");

        Consumer<String> cons2 = (s) -> {
            System.out.println(s);
        };
        cons2.accept("西湖");
    }

    // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略 [方式二、三的简化]
    @Test
    public  void m4(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("杭州");

        Consumer<String> cons2 = s -> {
            System.out.println(s);
        };
        cons2.accept("西湖");
    }

    // 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public  void m5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare2 = com2.compare(21, 21);
        System.out.println(compare2);
    }

    // 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略[方式五的简化]
    @Test
    public  void m6() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        Comparator<Integer> com2 = (o1, o2) ->  o1.compareTo(o2);
        int compare2 = com2.compare(21, 21);
        System.out.println(compare2);

    }

}
