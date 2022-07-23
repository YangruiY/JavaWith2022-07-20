package com.Generic;

import java.util.HashMap;

public class DefineGeneric {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //方法使用泛型

        Car car = new Car();
        car.ring("宝马", 100);//当调用方法时，传入参数，编译器，就会确定类型
        System.out.println("=======");
        car.ring(300, 100.1);//当调用方法时，传入参数，编译器，就会确定类型
        Boat<String, HashMap> sHMB = new Boat<>();
        sHMB.he(new HashMap(),"ry");
    }
}
        /*
            1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
            2, T, R, M 泛型的标识符, 一般是单个大写字母
            3. 泛型标识符可以有多个.
            4. 普通成员可以使用泛型 (属性、方法)
            5. 使用泛型的数组，不能初始化
            6. 静态方法中不能使用类的泛型
         */
class Tiger<T,R,M>{
    String name;
    T t;
    R r;
    M m;
    //Type parameter 'M' cannot be instantiated directly
    //因为数组在 new 不能确定 T 的类型，就无法在内存开空间
    //M[] ms = new M[8];

    //因为静态是和类相关的，在类加载时，对象还没有创建,所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化
    //static R r2;
    //public static void m1(M m) {}

    //构造器使用泛型
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //返回类型使用泛型
    public T getT() {
        return t;
    }

    //方法使用泛型
    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}

//泛型接口
interface  IU<U,R>{

    int n =10;

    //接口中，静态成员也不能使用泛型
    //U name;    注意，其中接口中变量 name 默认为静态变量
}

//泛型方法，可以定义在普通类中, 也可以定义在泛型类中
class Car{
    public void run(){

    }
    // 1. <T,R> 就是泛型
    // 2. 是提供给 ring 使用的
    public <T,R> void ring(T t, R r){
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class Boat<M,N>{
    public void run(){

    }
    // 1. <T,R> 就是泛型
    // 2. 是提供给 ring 使用的
    public <T,R> void ring(T t, R r){

    }

    //下面 ha 方法不是泛型方法 只是 ha 方法使用了类声明的 泛型
    public void ha(M m){

    }
    //泛型方法，可以使用类声明的泛型(下面的N)，也可以使用自己声明泛型(下面的K)
    public<K>void he(N n,K k){
        System.out.println(n.getClass());
        System.out.println(k.getClass());
    }
}