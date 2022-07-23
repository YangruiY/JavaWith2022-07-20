package com.Generic;

public class Generic_detail {
    /*
        1.给泛型指向数据类型是，要求是引用类型，不能是基本数据类型

        2. 说明
         因为 E 指定了 A 类型, 构造器传入了 new A()
         在给泛型指定具体类型后，可以传入该类型或者其子类类型

        3. 泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        但是常常推荐简写，如下所示：
            ArrayList<Integer> list3 = new ArrayList<>();
            List<Integer> list4 = new ArrayList<>();
        如果是这样写 泛型默认是 Object
        ArrayList arrayList = new ArrayList();
        //等价
        ArrayList<Object> arrayList = new ArrayList<Object>();
     */
}
