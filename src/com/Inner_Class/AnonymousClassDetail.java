package com.Inner_Class;

public class AnonymousClassDetail {
    public static void main(String[] args) {
        AnonClass anonClass = new AnonClass();
        anonClass.method();
    }
}
class AnonClass{
    private int n1 = 99;
        public void method(){

            //基于类的匿名内部类
          Person p = new Person(){
              private int n1 = 100;
                @Override
                public void hi() {
                    System.out.println("基于类的匿名内部类");

                    //可以直接访问外部类的所有成员，包含私有的
                    // 如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
                    // 默认遵循就近原则，如果想访问外部类的成员，
                    // 则可以使用 （外部类名.this.成员）去访问
                    System.out.println(AnonClass.this.n1);
                    System.out.println(n1);

                }
            };
          p.hi(); // //动态绑定, 运行类型是 AnonClass$1



            //直接调用
            new Person(){
                @Override
                public void hi() {
                    System.out.println("直接调用");
                }

                @Override
                public void ok(String name) {
                    System.out.println(name);
                }
            }.ok("ry");
        }
}

class Person{
    public void hi(){
        System.out.println("Person say hi~");
    }
    public void ok(String name){
        System.out.println("Person say ok~");
    }

}