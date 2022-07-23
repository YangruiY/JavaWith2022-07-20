package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory01 {
    public static void main(String[] args) {

        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。" +
                " 1999 年 6 月，Sun 公司发布了第二代 Java 平台（简称为 Java2）" +
                "的 3 个版本：J2ME（Java2 Micro Edition，Java2平台的微型版），" +
                "应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2 平台的标准版），" +
                "应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2 平台的企业版），" +
                "应用 3443 于基于 Java 的应用服务器。Java 2 平台的发布，是 Java 发展过程中最重要的一个" +
                "里程碑，标志着 Java 的应用开始普及 9889 ";
        //说明:  \\d 表示一个任意的数字
        String regstr = "\\d\\d\\d\\d";
        //2. 创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regstr);
        //3. 创建匹配器
        // 说明：创建匹配器 matcher,按照正则表达式的规则 去匹配 content 字符串
        Matcher matcher = pattern.matcher(content);
        //4.开始匹配
        /**
         * matcher.find() 完成的任务
         * 1 根据指定的规则 ,定位满足规则的子字符串(比如(1998))
         * 2 找到后，将 子字符串的开始的索引记录到 matcher 对象的属性 int[] groups;
         *       groups[0] = 0 , 把该子字符串的结束的索引+1 的值记录到 groups[1] = 4
         *       ......
         * 3. 同时记录 oldLast 的值为子字符串的结束的 索引+1 的值即 4, 即下次执行 find 时,就从4开始匹配
         *
         *
         *
         * matcher.group(0) 源码分析：
         *   public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *
         *  1. 根据 groups[0]=0 和 groups[1]=4 的记录的位置，从 content 开始截取子字符串返回
         *      就是 [0,4) 即包含 0 但是不包含索引为 4 的位置
         *      ......
         *  2. 如果再次指向 find 方法.仍然安上面分析来执行
         */
        while(matcher.find()){
            //匹配内容，文本方法 m.group(0)中
            System.out.println("找到 ：" + matcher.group(0));
        }
    }
}
