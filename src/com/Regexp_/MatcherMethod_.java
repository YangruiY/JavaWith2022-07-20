package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethod_ {
    public static void main(String[] args) {
        String content = "hello nju edu hello nj hello ";
        String regStr = "hello.*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("=================");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到：" + content.substring(matcher.start(), matcher.end()));
        }

        //整体匹配  常用于去校验某个字符串是否满足某个规则
        System.out.println("整体匹配:" + matcher.matches());

        //替换
            // 完成如果 content 有 nj 替换成 南京
        regStr = "nj";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        //注意：返回的字符串才是替换后的字符串 原来的 content 不变化
        String newContent = matcher.replaceAll("南京");
        System.out.println("newContent=" + newContent);
        System.out.println("oldContent=" + content);

    }
}
