package com.Java8_.References;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 格式： ClassName::new
 * 注意： 其与方法引用类似，函数式接口 中抽象方法的形参列表和构造器的形参列表一致，
 *       抽象方法返回值类型即为构造器所属的类的类型
 * 二、数组引用
 * 格式： type[] :: new
 * 注意： 将数组看做是特殊的类，那么写法与构造器引用一样
 *
 * Created by shkstart
 */
public class Constructor_Reference {
	//构造器引用
    //Supplier 中的为T get()
    //Employee 中的为Employee()
    @Test
    public void m1(){
        //原始的oop
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.print("原始的为:");
        System.out.println(sup.get());


        // lambda 表达式
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.print("lambda 表达式:");
        System.out.println(sup1.get());

        //构造器引用
        Supplier<Employee> sup2 = Employee::new;
        System.out.print("方法引用:");
        System.out.println(sup2.get());
    }

	//Function 中的 R apply(T t)
    //Employee 中的为 Employee(int id)
    @Test
    public void m2(){
        Employee employee1 = new Employee();
        //原始的oop
        Function<Integer,Employee> fun =new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(1000);
            }
        };
        System.out.print("原始的为:");
        System.out.println(fun.apply(1000));


        // lambda 表达式
        Function<Integer,Employee> fun1 = id -> new Employee(id);
        System.out.print("lambda 表达式:");
        System.out.println(fun1.apply(1001));

        //构造器引用
        Function<Integer,Employee> fun2 =Employee::new;
        System.out.print("方法引用:");
        System.out.println(fun2.apply(1002));
	}

	//BiFunction中的R apply(T t,U u)
    //Employee 中的为 (int id, String name)
    @Test
    public void m3(){
        Employee employee = new Employee();
        //原始的oop
        BiFunction<Integer,String,Employee> biFunction = new BiFunction< Integer, String,Employee>() {
            @Override
            public Employee apply( Integer integer,String s) {
                return  new Employee(10000,"jack");
            }
        };
        System.out.print("原始的为:");
        System.out.println(biFunction.apply(10000,"jack"));


        // lambda 表达式
        BiFunction<Integer,String,Employee> biFunction1 = (id,name) -> new Employee(id,name);
        System.out.print("lambda 表达式:");
        System.out.println(biFunction1.apply(10001,"john"));

        //构造器引用
        BiFunction<Integer,String,Employee> biFunction2 =Employee::new;
        System.out.print("方法引用:");
        System.out.println(biFunction2.apply(10002,"joke"));
	}

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        System.out.println("lambda 表达式");
        Function<Integer,String[]> fun1 = length -> new String[length];
        String[] apply = fun1.apply(5);
        System.out.println(Arrays.toString(apply));


        System.out.println("数组引用");
        Function<Integer,String[]> fun2 = String[] ::new;
        String[] apply1 = fun1.apply(3);
        System.out.println(Arrays.toString(apply1));
    }
}
