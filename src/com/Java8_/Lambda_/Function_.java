package com.Java8_.Lambda_;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *java 内置的4大核心函数式接口
 * 消费型接口 Consumer<T>  包含方法：void accept(T t)
 *
 * 供给型接口 Supplier<T>  包含方法：T get()
 *
 * 函数型接口 Function<T, R> 包含方法：R apply(T t)
 *
 * 断定型接口 Predicate<T> 包含方法：boolean test(T t)
 *
 * java 内置的其他函数式接口
 *  BiFunction<T, U, R>  包含方法： R apply(T t, U u);
 *  UnaryOperator<T>    包含方法为：T apply(T t);
 * BinaryOperator<T>    包含方法为： T apply(T t1, T t2);
 *  BiConsumer<T, U>    包含方法为： void accept(T t, U u)
 * BiPredicate<T,U>     包含方法为： boolean test(T t,U u)
 *
 *  以上可以使用lambda表达式
 *
 *
 * ToIntFunction<T>、ToLongFunction<T>、ToDoubleFunction<T> 分别计算int、long、double值的函数
 * IntFunction<R>、LongFunction<R>、DoubleFunction<R>     参数分别为int、long、double 类型的函数
 */
public class Function_ {
    @Test
    public void m1(){
        time(2000, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("南京旅游" + aDouble);
            }
        });

        //lambda 表达式
        time(2000,money -> System.out.println("去南京旅游" + money));
    }
    public void time(double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void m2(){
        List<String> strings = Arrays.asList("南京", "南京8", "南京7", "南京6", "南京5", "南京4", "南京3", "南京1", "南京2");
        List<String> filterString = filterString(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("南京");
            }
        });

        System.out.println(filterString);


        //lambda表达式
        List<String> filterString1 = filterString(strings, s -> s.contains("京"));
        System.out.println(filterString1);

    }

    //根据给定的规则过滤集合中的字符串，规则有predicate 的方法决定
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> strings = new ArrayList<>();
        for (String Str:list) {
            if (predicate.test(Str)){
                strings.add(Str);
            }
        }
        return strings;
    }
}
