package com.WrapperClass;
/*

 */
public class Reserve {
    public static void main(String[] args) {
        String  str = "qwertyu";
        System.out.println(str);
        try {
            str = reverse(str,1,4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }
    /*
    String 转化为 char[]，char[]是可以交换的
     */
    public static  String reverse( String str, int start, int end){
        //方法一
//        if (str == null || start <= 0 || end >= 0 || end >str.length()){
//            throw new RuntimeException("参数不正确");
//        }
        //方法二    先写出正确的，再取反
        if (!(str != null && start >= 0 && end <= 0 && end < str.length())){
            throw new RuntimeException("参数不正确");
        }
        char [] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start,j = end ; i < j; i++,j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp ;
        }
        //用chars 重构String，返回即可
        return  new String(chars);
    }
}
