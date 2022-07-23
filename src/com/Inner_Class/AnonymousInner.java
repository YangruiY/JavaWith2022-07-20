package com.Inner_Class;
/*
    匿名内部类
 */
public class AnonymousInner {
    public static void main(String[] args) {
        Anonclass anonclass = new Anonclass();
        anonclass.method();
    }
}

class Anonclass{
    private int i= 10;
    public void method(){
        //基于接口的匿名内部类
            //传统方式，是写一个类，实现该接口，并创建对象
            IA tiger = new Tiger();
            tiger.cry();
            //如果一个类只是使用一次，后面再不使用，则可以使用匿名内部类来简化开发

            //tiger 的编译类型 ? IA
            //tiger 的运行类型 ? 就是匿名内部类 Anonclass$1(底层运行时分配的)

            // jdk 底层在创建匿名内部类 Anonclass$1,
            // 立即马上就创建了 Anonclass$1 实例，并且把地址返回给 Dog

            //匿名内部类使用一次，就不能再使用
               IA dog = new IA(){
                    public void cry(){
                        System.out.println("Dog");
                    }
                };//分号不能少
            System.out.println("Dog 运行类型" + dog.getClass()); //Anonclass$1
                    dog.cry();



        //基于类的匿名内部类

        // father 编译类型 Father
        // father 运行类型 Anonclass$2
        // 同时也直接返回了 匿名内部类 Anonclass$2 的对象
        Father tom = new Father("Tom"){
            @Override
            public void test() {
                System.out.println("tom Override father test");
            }
        };//分号不能少

        tom.test();
        System.out.println("tom的运行类型为" + tom.getClass());




        //基于抽象类的匿名内部类
        anmial an = new anmial(){

            @Override
            void eat() {
                System.out.println(" an implements eat");
            }
        };
        an.eat();
    }



}
interface IA{
   void cry();
}
class Tiger  implements  IA{

    @Override
    public void cry() {
        System.out.println("tiger");
    }
}
class Father{
    public Father(String name) {

    }
    public void test(){

    }
}
abstract class anmial{
    abstract  void eat();
}