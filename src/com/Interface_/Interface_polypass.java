package com.Interface_;

//演示多态传递现象

public class Interface_polypass {
    public static void main(String[] args) {
        ploy p = new Tea();
        p.hi();
        //如果 IG 继承了 IH 接口，而 Teacher 类实现了 IG 接口
        // 那么，实际上就相当于 Teacher 类也实现了 IH 接口.
        // 这就是所谓的 接口多态传递现象.
        pass p1 =new Tea();
        p1.hi();
    }

}

interface pass{
    void hi();
}
interface ploy extends pass{

}
class Tea implements  ploy{

    @Override
    public void hi() {
        System.out.println("say hi~");
    }
}