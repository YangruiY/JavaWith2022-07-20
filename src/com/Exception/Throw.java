package com.Exception;

//自定义异常
public class Throw {
    public static void main(String[] args) {
        int age = 10;
        if(age <= 18 || age >=120){
            throw new Myexception("error of exception on input");
        }
        System.out.println("input successful");
    }
}

//1. 一般情况下，我们自定义异常是继承 RuntimeException
// 2. 即把自定义异常做成 运行时异常，好处是我们可以使用默认的处理机制
class Myexception extends RuntimeException{
    public Myexception(String message) {
        super(message);
    }
}