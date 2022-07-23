package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Back_reference {
    public static void main(String[] args) {
        // 1.要匹配两个连续的相同数字: (\d)\1
//        String content = "hello nju edu hello nj hello heeh lool hiih 8998";
//        String regStr = "(\\w)\\1";
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(content);
//        while(matcher.find()){
//            System.out.println("找到 ：" + matcher.group(0));
//        }
        // 2.要匹配五个连续的相同数字: (\d)\\1{4}
//        String content = "hello nju edu hello nj hello heeeeeeh lool hiih666666 11111 8989899";
//        String regStr = "(\\w)\\1{4}";
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(content);
//        while(matcher.find()){
//            System.out.println("找到 ：" + matcher.group(0));
//        }
        // 3.要匹配个位与干位相同，十位与百位相同的数5225 , 1551 (\d)(\d)\\2\\1
//        String content = "hello nju edu hello nj hello heeh lool hiih 8998";
//        String regStr = "(\\w)(\\w)\\2\\1";
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(content);
//        while(matcher.find()){
//            System.out.println("找到 ：" + matcher.group(0));
//        }


        //请在字符串中检索商品编号,形式如:12321-333999111这样的号码,
        // 要求:满足前面是一个五位数，然后一个-号,然后是一个九位数,连续的每三位要相同
//        String content = "qweqweqwe234232312321-333999111";
//        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(content);
//        while(matcher.find()){
//            System.out.println("找到 ：" + matcher.group(0));
//        }


        //结巴程序
        String content = "我....我要....学学学学....编程java!";
        //1 去掉所有的 .
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        System.out.println(content);



        /*
            2 去掉重复的字
             思路
             (1) 使用 (.)\\1+
             (2) 使用 反向引用$1 来替换匹配到的内容
         */
        // 注意：因为正则表达式变化，所以需要重置 matcher
        regStr = "(.)\\1+";
        pattern = Pattern.compile(regStr);    // 分组的捕获内容记录到$1
        matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到 ：" + matcher.group(0));
        }
        //3 使用反向引用 $1 来替换匹配到的内容
        content = matcher.replaceAll("$1");
        System.out.println(content);


        //2和3的归总：使用一条语句 去掉重复的字
        content = Pattern.compile(regStr).matcher(content).replaceAll("$1");
        System.out.println(content);
    }
}
