package com.Regexp_;

public class RegExer_ {
    public static void main(String[] args) {
       /*       汉字范围
            String content = "1条狗是dog";
            //汉字范围  "^[\u0391-\uffe5]$"
            String regStr = "^[\u0391-\uffe5]+$";
            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            if(matcher.find()){
                System.out.println("满足格式");
            }else {
                System.out.println("不满足格式");
            }
        */

        /*
            邮政编码  要求: 为1-9开头的6位数
            String content = "123456";
            String regStr = "^[0-9]\\d{5}$";
            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            if(matcher.find()){
                System.out.println("满足格式");
            }else {
                System.out.println("不满足格式");
            }
         */
        /*
            QQ号   要求: 是 1-9 开头的一个(5 位数-10 位数) 比如: 12389 , 1345687 , 187698765
            String content = "1234561321231";
            String regStr = "^[0-9]\\d{4,9}$";
            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            if(matcher.find()){
                System.out.println("满足格式");
            }else {
                System.out.println("不满足格式");
            }
         */

        /*
            手机号码，要求:必须以 13,14,15,18 开头的 11 位数 , 比如 13456132121
                String content = "13456132121";
                String regStr = "^[1][3|4|5|8|3]\\d{9}$";
                Pattern pattern = Pattern.compile(regStr);
                Matcher matcher = pattern.matcher(content);
                if(matcher.find()){
                    System.out.println("满足格式");
                }else {
                    System.out.println("不满足格式");
                }
         */
        /*
            URL地址: 如https://map.baidu.com/@13223777.478051959,3748215.980210659,16.41z

            String content = "https://map.baidu.com/@13223777.478051959,3748215.980210659,16.41z";

         // 思路 ：
         // 1 确定 http https
         // 2 然后通过 ([\w-]+\.)+[\w-]+ 匹配 map.baidu.com
         // 3 /@13223777.478051959,3748215.980210659,16.41z  匹配(\/[\w-?=,.&/%@#！]*)?

        String regStr = "^((http|https)://)?(([\\w-])+\\.)+[\\w-]+(\\/[\\w-?=,.&/%@#！]*)?$";  //注意：[. ? *] . ? *在中括号中就表示匹配就是.本身
            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(content);
            if(matcher.find()){
                System.out.println("满足格式");
            }else {
                System.out.println("不满足格式");
            }
        //这里如果使用 Pattern 的 matches 整体匹配 比较简洁
        System.out.println(Pattern.matches(regStr, content));
        */
    }
}
