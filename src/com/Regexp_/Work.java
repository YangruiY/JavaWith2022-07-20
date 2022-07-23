package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Work {
    public static void main(String[] args) {
        //验证电子邮箱
        /*
            规定电子邮件规则为
            1. 只能有一个@
            2. @前面是用户名,可以是a-z A-Z 0-9 -字符
            3. @后面是域名，并且域名只能是英文字母， 比如sohu.com或者tsinghua.org.cn
            4. 写出对应的正则表达式，验证输入的字符串是否为满足规则

         */
        String content = "1281841920@qq.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+[.])+[a-zA-Z]+$";
        //PS: String 的matches 是整体匹配
        /**
         * 看看matches的源码
         *
         *
         *  public boolean matches(String regex) {
         *         return Pattern.matches(regex, this);
         *     }
         *
         *                  |
         *                  |
         *                  |
         *                  |
         *                  ↓
         *     public static boolean matches(String regex, CharSequence input) {
         *         Pattern p = Pattern.compile(regex);
         *         Matcher m = p.matcher(input);
         *         return m.matches();
         *     }
         *                 |
         *                 |
         *                 |
         *                 ↓
         *      public boolean matches() {
         *         return match(from, ENDANCHOR);
         *     }            // Attempts to find the next subsequence of the input sequence that matches the pattern.
         *
         */
        if (content.matches(regStr)){
            System.out.println("匹配成功");
        }else{
            System.out.println("匹配失败");
        }

        //验证整数还是小数
        /**
         * 思路：
         *  1 先写简单的正则表达式
         *  2 再逐步完善
         */
        content = "123.56";
        regStr =  "^([-+]*([1-9]\\d*)|[0])(\\.\\d+)?$";
        if (content.matches(regStr)){
            System.out.println("匹配成功,是整数或者小数");
        }else{
            System.out.println("匹配失败");
        }


        //url的解析
        content = "http://www.sohu.com:8080/abc/index.html";
        //正则表达式是根据需求来写的！！！！  [] 过滤掉的内容,   ()是分组的，下面的group()得到的
        regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w]+)$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        //整体匹配，匹配成功就可以通过group(x) 获得相应分组内容
        if (matcher.matches()){
            System.out.println(matcher.group(0));
            System.out.println("协议" + matcher.group(1));
            System.out.println("域名" + matcher.group(2));
            System.out.println("端口" + matcher.group(3));
            System.out.println("文件" + matcher.group(4));
        }else{
            System.out.println("匹配不成功");
        }

    }



}
