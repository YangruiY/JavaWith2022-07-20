package com.WrapperClass;

public class Wrapper {
    public static void main(String[] args) {
   //包装类
    //手动
        // jdk5 前是手动装箱和拆箱
        // 手动装箱
        // int->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        // 手动拆箱
        // Integer -> int
        int i = integer.intValue();


    //自动
        // jdk5 后，就可以自动装箱和自动拆箱
        int n2 = 200;
        // 自动装箱 int->Integer
         Integer integer2 = n2;// 底层使用的是 Integer.valueOf(n2)
        // 自动拆箱 Integer->int
        int n3 = integer2; //底层仍然使用的是 intValue()方法 }


   //包装类转换为String
        //包装类(Integer)->String
        Integer i1 = 100;//自动装箱
        //方式一
        String str = i1 + "";
        //方式二
        String str1 = i1.toString();
        //方式三
        String str2 = String.valueOf(i1);


        //String -> 包装类(Integer)
         String str3 = "12345";
         //方式一:使用到自动装箱
         Integer i2 = Integer.parseInt(str3);//使用到自动装箱
         //方式二:构造器
         Integer i3 = new Integer(str3);//构造器




        //面试题

        Integer ii = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(ii == j); //False

        //1. 如果 i 在 IntegerCache.low(-128)~IntegerCache.high(127),就直接从数组返回
        // 2. 如果不在 -128~127,就直接 new Integer(i)
        /*
        源码
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
            */
         Integer m = 1; //底层 Integer.valueOf(1);  -> 阅读源码
         Integer n = 1;//底层 Integer.valueOf(1);
         System.out.println(m == n); //T



        //这里主要是看范围 -128 ~ 127 就是直接返回,否则，就 new Integer(xx);
         Integer x = 128;//底层 Integer.valueOf(1);
         Integer y = 128;//底层 Integer.valueOf(1);
         System.out.println(x == y);//False


        //只有有基本数据类型，判断的是值是否相同
        Integer i11=127;
        int i12=127;
        System.out.println(i11==i12); //T

        Integer i13=128;
        int i14=128;
        System.out.println(i13==i14);//T

        Integer i9 = 127; //Integer.valueOf(127)
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);//F

        Integer i5 = 127;//底层 Integer.valueOf(127)
        Integer i6 = 127;//-128~127
        System.out.println(i5 == i6); //T
        }
    }

