package com.Inner_Class;
/*
    局部内部类案例
 */
public class LocalInnerclass {
    public static void main(String[] args) {
        LocalOuter localOuter = new LocalOuter();
        localOuter.m1();
     // System.out.println(localOuter);
    }
}
class LocalOuter{
    /*
    //1.局部内部类是定义在外部类的局部位置,通常在方法中
    3.不能添加访问修饰符,但是可以使用 final 修饰
    4.作用域 : 仅仅在定义它的方法或代码块中
     */
    private int n = 1;
    private void m2() {
        System.out.println("private m2()");
    }
    public void m1(){
        System.out.println("m1()");

        class LocalInner{
            private int n = 100 ;
            //2.可以直接访问外部类的所有成员，包含私有的
          public   void f1(){
                /*
                 5. 局部内部类可以直接访问外部类的成员，比如下面 外部类 n1 和 m2()
                 7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，
                    如果想访问外部类的成员,使用 (外部类名.this.成员)去访问
                 老韩解读 Outer02.this 本质就是外部类的对象,
                 即哪个对象调用了 m1, Outer02.this 就是哪个对象
     */
                System.out.println("局部内部类中的n = " + n);
                System.out.println("外部类中的n = " + LocalOuter.this.n);
           // System.out.println(LocalOuter.this);
              //上面打印的地址和下面(main中的)
              //System.out.println(localOuter);
              //打印的地址一样；均为：com.Inner_Class.LocalOuter@4554617c
                m2();
            }
        }
        //6. 外部类在方法中，可以创建 LocalInner 对象，然后调用方法即可
        LocalInner localInner = new LocalInner();
        localInner.f1();
    } // m1()结束


    {
        //代码块里面的局部内部类
        class Inner01 {

        }
    }

}


