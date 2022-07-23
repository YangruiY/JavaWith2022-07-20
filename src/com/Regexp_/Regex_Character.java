package com.Regexp_;

/**
 * 字符匹配符使用的演示
 */
public class Regex_Character {
    public static void main(String[] args) {
        /*   演示字符匹配符 和 选择匹配符
            String content = "aBcAAZZ11c8 #%￥%%……";
            String content1 = "ryang 杨 木易";
            String regStr = "[a-z]";
            String regStr = "[A-Z]";
            String regStr = "abc";  //匹配 abc 字符串[默认区分大小写]
            String regStr = "(?i)abc";  //匹配 abc 字符串[不区分大小写]
            String regStr = "[0-9]";//匹配 0-9 之间任意一个字符
            String regStr = "[^a-z]";//匹配 不在 a-z 之间任意一个字符
            String regStr = "[^0-9]";//匹配 不在 0-9 之间任意一个字符
            String regStr = "[abcd]";//匹配 在 abcd 中任意一个字符
            String regStr = "\\D";//匹配 不在 0-9 的任意一个字符
            String regStr = "\\w";//匹配 大小写英文字母, 数字，下划线, 特殊字符不可以
            String regStr = "\\W";//匹配 等价于 [^a-zA-Z0-9_]
            String regStr = "\\s"; //  \\s 匹配任何空白字符(空格,制表符等)
            String regStr = "\\S"; // \\S 匹配任何非空白字符 ,和\\s 刚好相反
            String regStr = ".";   // . 匹配出 \n 之外的所有字符,如果要匹配.本身则需要使用 \\.
            String regstr = "yang|杨|木易";
            Pattern pattern = Pattern.compile(regStr);
            Pattern pattern1 = Pattern.compile(regstr);
            // 当创建 Pattern 对象时，指定 Pattern.CASE_INSENSITIVE, 表示匹配是不区分字母大小写.
            //Pattern pattern = Pattern.compile(regstr,Pattern.CASE_INSENSITIVE);//不区分大小写
            Matcher matcher = pattern1.matcher(content1);
            while(matcher.find()){
                System.out.println("找到" + matcher.group(0));
            }
         */
       /* 演示 限定符 和 定位符
         String content = "11111111aaassaasasasssaaczxsadd";
            String regstr = "a{3}";
            String regstr = "1{3}";
            String regstr = "\\d{2}";
            //PS: java 匹配默认贪婪匹配，即尽可能匹配多的
            String regstr = "(a){1,4}";
            String regstr = "1{1,5}";
            String regstr = "\\d{2,5}";
            String regstr = "(as){2,4}";
            String regstr = "1+";
            String regstr = "\\d+";
            String regstr = "a*";
            String regstr = "1a?";

            Pattern pattern = Pattern.compile(regstr);
            Matcher matcher = pattern.matcher(content);
            while(matcher.find()){
                System.out.println("找到" + matcher.group(0));
            }
        */
        /*
            演示 定位符
                String content = "12df3-sdf 0000df jijdf";
                String regStr = "^[0-9]+[a-z]*";
                String regStr = "^[0-9]+\\-[a-z]+$";
                //只得到边界的df，表示匹配边界的 han[这里的边界是指：被匹配的字符串最后,也可以是空格的子字符串的后面]
                String regStr = "df\\b";
                String regStr = "df\\B";
                Pattern pattern = Pattern.compile(regStr);
                Matcher matcher = pattern.matcher(content);
                while(matcher.find()){
                    System.out.println("找到" + matcher.group(0));
                }
         */

        /*
                非命名分组
            // 1. matcher.group(0) 得到匹配到的字符串
            // 2. matcher.group(1) 得到匹配到的字符串的第 1 个分组内容
            // 3. matcher.group(2) 得到匹配到的字符串的第 2 个分组内容
            String content = "asda999828asda99ad  sada9989122 dsa89012";
            String regStr = "(\\d\\d)(\\d\\d)(\\d\\d)";
            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            while(matcher.find()){
                System.out.println("找到" + matcher.group(0));
                System.out.println("第 1 组()匹配到的值=" + matcher.group(1));
                System.out.println("第 2 组()匹配到的值=" + matcher.group(2));
                System.out.println("第 3 组()匹配到的值=" + matcher.group(3));
            }

                命名分组
            String content1 = "asda999828asda99ad  sada9989122 dsa89012";
            String regStr1 = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
            Pattern pattern1 = Pattern.compile(regStr1);
            Matcher matcher1 = pattern1.matcher(content1);
            while(matcher1.find()){
                System.out.println("通过组名找到找到" + matcher1.group(0));
                System.out.println("第 1 组g1匹配到的值=" + matcher1.group("g1"));
                System.out.println("第 2 组g2匹配到的值=" + matcher1.group("g2"));
            }
         */
        /*
                非捕获分组
             String content = "hello 韩顺平教育 jack 韩顺平老师 韩顺平同学 hello 韩顺平学生";
           //找到 韩顺平教育 、韩顺平老师、韩顺平同学 子字符串
             String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
           //上面的写法可以等价非捕获分组, 注意：不能 matcher.group(1)
             String regStr = "韩顺平(?:教育|老师|同学)";

           //找到 韩顺平 这个关键字,但是要求只是查找韩顺平教育和 韩顺平老师 中包含有的韩顺平
             String regStr = "韩顺平(?=教育|老师)";      //这个也是非捕获分组，不能使用 matcher.group(1)

           //找到 韩顺平 这个关键字,但是要求只是查找 不是 (韩顺平教育 和 韩顺平老师) 中包含有的韩顺平
             String regStr = "韩顺平(?!教育|老师)";        //这个也是非捕获分组，不能使用 matcher.group(1)


            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println("找到: " + matcher.group(0));
            }

         */


        /*
                非贪婪匹配
             String content = "asda999828asda99ad  sada9989122 dsa89012";
            //String regStr = "\\d+";  // 默认贪婪匹配
            String regStr = "\\d+?";  // 非贪婪匹配

            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            while(matcher.find()){
                System.out.println("找到" + matcher.group(0));

            }
         */

    }
}
