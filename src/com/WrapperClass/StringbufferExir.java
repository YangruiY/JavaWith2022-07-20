package com.WrapperClass;

public class StringbufferExir {
    /*
    要求：价格的小数点前面每三位用逗号隔开, 在输出。 思路分析

    1. 定义一个 Scanner 对象，接收用户输入的 价格(String)
    2. 希望使用到 StringBuffer 的 insert ，需要将 String 转成 StringBuffer
    3. 然后使用相关方法进行字符串的处理 代码实现
     */
    public static void main(String[] args) {
        String price  = "12346813235.599";
        StringBuffer stringBuffer = new StringBuffer(price);

//        int i = stringBuffer.lastIndexOf(".");
//        stringBuffer = stringBuffer.insert(i - 3,",");
        //循环优化
        for (int j = stringBuffer.lastIndexOf(".") - 3; j > 0 ; j -= 3) {
            stringBuffer = stringBuffer.insert(j,",");
        }
        System.out.println(stringBuffer);

    }

}
