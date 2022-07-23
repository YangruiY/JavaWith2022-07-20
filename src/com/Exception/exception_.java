package com.Exception;
//快捷键 将该代码块->选中->快捷键 ctrl + alt + t -> 选中 try-catch

//程序员若没有显示的处理异常，则默认为throws方式
public class exception_ {
    public static void main(String[] args) {

        // 1. 如果异常发生了，则异常发生后面的代码不会执行，直接进入到 catch 块
        // 2. 如果异常没有发生，则顺序执行 try 的代码块，不会进入到 catch
        // 3. 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)则使用如下代码- finally
//        try {
//            String str ="123";
//            int a = Integer.parseInt(str);
//            System.out.println(a);
//        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//        }finally {
//            System.out.println("执行~~");
//        }
//        System.out.println("main");

        // 1.如果 try 代码块有可能有多个异常
        // 2.可以使用多个 catch 分别捕获不同的异常，相应处理
        // 3.要求子类异常写在前面，父类异常写在后面
        try {
            Person person = new Person();
            System.out.println(person.getName());
            Person person1 = new Person();
            person1.name = null;
            System.out.println(person1.getName());
            int a = 10;
            int b= 0;
            int c = a/b;
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage()+ "~~~");
//        }catch(Exception e){
//            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally");
        }

        /*可以进行 try-finally 配合使用, 这种用法相当于没有捕获异常，
        因此程序会直接崩掉/退出。应用场景，就是执行一段代码，不管是否发生异常，
        都必须执行某个业务逻辑 */

        System.out.println("main");
    }

}

class Person{
    String name = "ry";

    public String getName() {
        return name;
    }
}