package com.Regexp_;

import java.util.regex.Pattern;

/**
 * matches 方法 ，用于整体匹配, 在验证输入的字符串是否满足条件使用
 */
public class PatternMatcher {
    public static void main(String[] args) {
        String content = "hello world abc 猫猫猫狗狗狗";

        String regStr = "hello.*";

        boolean matches = Pattern.matches(regStr, content);

        System.out.println("整体匹配" + matches);
    }
}
