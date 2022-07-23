package com.WrapperClass;

public class StringFunction {
    public static void main(String[] args) {
        String str = "Han Shun Ping";
        printName(str);


    }
    /*
    思路分析：
        1 对输入的字符串进行分割spilt(" ");
        2 对得到的String[]进行格式化String.format()
        3 对输入的字符串进行校验
     */
    public static void printName(String str){

        if(str == null){
            System.out.println("str 不能为空！");
            return;
        }
        String name[] = str.split(" ");

        if(name.length != 3){
            System.out.println("格式不对！");
            return;
        }
        String format = String.format("%s,%s .%c", name[2], name[0], name[1].toUpperCase().charAt(0));

        System.out.println(format);
    }
}
