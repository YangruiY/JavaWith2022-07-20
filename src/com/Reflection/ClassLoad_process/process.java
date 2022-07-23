package com.Reflection.ClassLoad_process;

import com.Reflection.Class.Cat;

public class process {
    public static void main(String[] args) {
        //1 加载
        /*
        JVM在该阶段的主要目的是将字节码从不同的数据源(可能是class文件、也可能是jar包，甚至网络)
        转化为二进制字节流加载到内存中，并生成个代表该类的java.lang.Class对象
         */
        Cat cat = new Cat();

        //2 验证：
        /*
        1.目的是为了确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
        2.包括:文件格式验证(是否以魔数oxcafebabe开头)、 元数据验证、字节码验证和符号引用验证[举例说明]
        3.可以考虑使用-Xverify:none参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间。
         */


        //3 准备
        /*
            JVM 会在该阶段对静态变量，分配内存并默认初始化(对应数据类型的默认初始值，
            如0、OL、null、 false 等)。这些变量所使用的内存都将在方法区中进行分配

         */

        //4 解析
        /*
           虚拟机将常量池内的 符号引用 替换为 直接引用 的过程。
         */

        //5 初始化
        /*
        1.到初始化阶段，才真正开始执行类中定义的Java程序代码，此阶段是执行<clinit> ()方法的过程。
        2. < clinit> 0)方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有
        静态变量的赋值动作和静态代码块中的语句，并进行合井。[举例说明ClassLoad03.java]
        3.虚拟机会保证一个类的< clinit> ()方法在多线程环境中被正确地加锁、同步，如果
        多个线程同时去初始化一个类，那么只会有一一个线程去执行这个类的<clinit>0) 方
        法，其他线程都需要阻塞等待，直到活动线程执行< clinit> 0)方法完毕[debug源码]
         */

        //1 加载B类,并生成B的Class对象
        //2 连接 num = 0;
        //3 初始化阶段
            //依次执行自动收集类中的所有静态变量的赋值动作和静态代码块中的语句
            /*
                clinit(){
                        System.out.println("hi");
                        num = 300;
                        num = 100;
                }
                合并
                num = 100
             */

                // 执行构造器
                // new B();
        System.out.println(new B().num);  // 100 
        
        
        //加载类的时候是有同步机制控制的

            B b = new B();

    }
}

//准备案例
class A{
    //属性==字段==成员变量
    private int n1 =10;   // n1是实例属性，不是静态变量，不会分配内存
    public static int n2 =20;  // n2 是静态变量，分配内存，n2默认初始哈为0 ，并不是20
    public static final int n3 =30; // n3是 static final的变量，其与静态变量不一样，因为其一旦赋值就不再允许改变
}


//初始化案例
class B{
    static {
            System.out.println("hi");
            num = 300;
    }
    static int num =100;
    public B(){
        System.out.println("B() 构造器被执行");
    }

}