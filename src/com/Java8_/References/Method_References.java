package com.Java8_.References;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Method_References {
    /**
     * 使用情景 ：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
     * 方法引用 : 本质就是Lambda 表达式，而Lambda 表达式的本质 ：作为接口的实例
     * 所以： 方法引用也是函数接口的实例
     *
     * 3 使用格式：
     *  （类）对象::实例方法名
     *      情况一 :  对象::实例方法名(非静态方法)
     *      情况二 :  类::静态方法名
     *      情况三 :  类::实例方法名
     * 4 方法引用使用的要求：
     *          接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同(针对情况一 、二)
     */
    //情况一 : 对象::实例方法名(非静态方法)
    @Test
    public void m1(){
        /*
            Consumer 中的 void accept(T t)
             PrintStream 中的 void println(T t)
         */
        System.out.print("lambda 表达式:");
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("南京");


        System.out.print("方法引用:");
        PrintStream out = System.out;
        Consumer<String> con2 = out::println;
        con2.accept("金陵");
    }

    /*
        Supplier 中的T get()
        Employee 中的String getName()   ----见Employee.java

     */
    @Test
    public void m2(){
        Employee employee = new Employee(1001,"tom",23,20000);
        System.out.print("lambda 表达式:");
        Supplier<String> sup1 = () ->employee.getName();
        System.out.println(sup1.get());


        //方法引用
        System.out.print("方法引用:");
        Supplier<String> sup2 = employee ::getName;
        System.out.println(sup2.get());
    }


    //情况二 :  类::静态方法名
        /*
            Comparator 中的int compare(T t1,T t2)
            Integer 中的 int compare(T t1,T t2)
         */
    @Test
    public void m3() {
        Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
        int compare = com.compare(5, 9);
        System.out.print("lambda 表达式:");
        System.out.println(compare);

        System.out.print("方法引用:");
        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(8, 5));
    }
    /*
        Function 中的 R apply(T t)
        Math 中的 Long round(T t)
     */
    @Test
    public void m4(){
        System.out.print("lambda 表达式:");
        Function<Double,Long> fun = d -> Math.round(d);
        System.out.println(fun.apply(12.5));
        System.out.print("方法引用:");
        Function<Double,Long> fun1 = Math::round;
        System.out.println(fun1.apply(22.3));
    }


    //情况三 :  类::实例方法名
    /*
        Comparator 中的int compare (T t1, T t2)
        String 中的int compare (T t2)   [实际上是 t1.compare(t2) 所以 t1 可以省略]
     */
    @Test
    public void m5(){
        System.out.print("lambda 表达式:");
        Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare("abc", "abf"));

        System.out.print("方法引用:");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("acd", "acf"));
    }

    /*
        BiPredicate 中的boolean test (T t1, T t2)
        String 中的boolean equal(T t2)   [实际上是 t1.equal(t2) 所以 t1 可以省略]
     */
    @Test
    public void m6(){
        System.out.print("lambda 表达式:");
        BiPredicate<String,String> biPredicate =(o1,o2) -> o1.equals(o2);
        System.out.println(biPredicate.test("123", "124"));

        System.out.print("方法引用:");
        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("123", "123"));
    }



    /*
        Function 中的 R apply (T t)
        Employee 中的 String getAge()
     */
    @Test
    public void m7(){
        System.out.print("lambda 表达式:");
        Employee employ = new Employee(0000, "jack", 23, 5000);
        Function<Employee,Integer> fun = employee -> employee.getAge();
        System.out.println(fun.apply(employ));

        System.out.print("方法引用:");
        Function<Employee,Integer> fun1 = Employee::getAge;
        System.out.println(fun1.apply(employ));
    }
}
