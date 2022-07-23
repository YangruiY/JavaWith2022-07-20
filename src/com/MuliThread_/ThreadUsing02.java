package com.MuliThread_;

public class ThreadUsing02 {
    /*
        通过实现Runnable接口实现线程
     */
    public static void main(String[] args) {
        Cat cat = new Cat();
        // 通过实现Runnable接口实现线程是没有start()方法的
        // cat.start();

        //创建了一个Thread的对象，将(实现Runnable的)dog对象放入Thread


        Thread thread = new Thread(cat);
        thread.start();





        //模拟代理类
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Cat implements Runnable {
    int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵喵喵~" + (++i) + Thread.currentThread().getClass());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            if (i == 10)
                break;
        }
    }
}

//如何使用代理类的演示
class  Anminal{

}

class Tiger extends Anminal implements Runnable{

    @Override
    public void run() {
        System.out.println("吼吼吼吼~");
    }
}
//底层实现了 代理模式    ----->    下面用 代码 模拟 实现机制

//线程代理类
class ThreadProxy implements Runnable{
    private Runnable target = null;  //属性 target 就是 Runnable 类型

    @Override
    public void run() {
        if (target != null){
            target.run();  // 动态绑定 ( 此时 运行类型为Tiger )
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0(); // 真正实现多线程的方法
    }
    public void start0(){
        run();
    }
}