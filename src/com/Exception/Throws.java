package com.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws {
    public static void main(String[] args) {


    }
    public void method() throws FileNotFoundException {
        //创建文件流
        //此处异常 FileNotFoundException 为编译时异常;
        //可以使用try-catch-finally也可以使用throws;
        //throws是让method()方法的调用者处理;
        //throws后面的可以是细节异常，也可以是父类异常，还可以是异常列表，多个异常
        FileInputStream fileInputStream = new FileInputStream("d://aa.txt");

    }

    public void method2() /*throws ArithmeticException*/{
        // 1.对于编译异常，程序中必须处理，比如 try-catch 或者 throws
        // 2.对于运行时异常，程序中如果没有处理，默认就是 throws 的方式处理

    }
    public static void method4() throws FileNotFoundException{
        // method5();  报错    原因： method5抛出编译异常，就要 method4() 必须处理这个编译异常
                            // 所以在 method4() 中，要么 try-catch-finally ,或者继续 throws 这个编译异常
        method5();   //method4() 后加throws FileNotFoundException，就不会报错了
    }
    public static void method5() throws FileNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("d://aa.txt");

    }
    public static void method6(){
        method7();  //不会报错，原因：method7()抛出的是运行异常，java 中，并不要求程序员显示处理,因为有默认处理机制
    }
    public static void method7() throws ArithmeticException{

    }

}
class Father{
    public void method3()  throws RuntimeException{

    }
}

class Son extends Father{
    // 3. 子类重写父类的方法时，对抛出异常的规定:子类重写的方法，
    // 所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
    // 4. 在 throws 过程中，如果有方法 try-catch , 就相当于处理异常，就可以不必 throws
    @Override
    public void method3() throws ArithmeticException{
        super.method3();
    }
}