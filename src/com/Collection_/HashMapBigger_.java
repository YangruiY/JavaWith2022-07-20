package com.Collection_;

import java.util.HashMap;

public class HashMapBigger_ {
    //HashMap 扩容树化触发 ， debug验证 ， 注意其中设计的是hashcode是一样的
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for(int i = 0;i<12;i++){
            hashMap.put(new A(i),"hi");
        }
        System.out.println(hashMap);
    }
}

class A{
    private int num;
    public A(int num){
        this.num = num;
    }

    @Override
    public String toString() {
        return "A{" +"num=" + num +'}' + "\n";
    }

    @Override
    public int hashCode() {
        return 100;
    }
}