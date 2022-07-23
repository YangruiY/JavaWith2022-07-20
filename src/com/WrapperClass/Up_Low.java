package com.WrapperClass;

public class Up_Low {
    public static void main(String[] args) {
        String str = "yuaksadjashgduAuiaUHSDUIAHD额82092183@#%^&*";
        countnum(str);
    }
    /*
    思路分析：
    1 遍历字符串，char 在 '0'-'9' 之间就是数
    2 char 在 'a'-'z' 之间就是low
    3 char 在 'A'-'Z' 之间就是up
    4 用count1 count2 count3 分别计数
     */
    public static void countnum(String str){
        if(str == null){
            System.out.println("输入不能为null");
            return;
        }
        int countNum=0 ,countLow=0 ,countUp=0,OtherCount=0;
        //只能取出字符串的某一个位置的字符
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <='9'){
                countNum++;
            }else if (str.charAt(i) >= 'a' && str.charAt(i) <='z'){
                countLow++;
            }else if (str.charAt(i) >= 'A' && str.charAt(i) <='Z'){
                countUp++;
            }else {
                OtherCount++;
            }
        }

        System.out.println("数字有"+countNum);
        System.out.println("Low有"+countLow);
        System.out.println("Up有"+countUp);
        System.out.println("其他有"+OtherCount);
    }
}
