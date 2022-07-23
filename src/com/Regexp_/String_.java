package com.Regexp_;

public class String_ {
    public static void main(String[] args) {

        String  content=
                "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业" +
                "标准的支持。2001年9月24日，J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算" +
                "能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的" +
                "XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志" +
                "与断言。2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的" +
                "重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，Tiger包含了从" +
                "1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、" +
                "枚举类型、格式化I/O及可变参数。" ;

        //     替换
                content = content.replaceAll("JDK1\\.3|JDK1\\.4","JDK");
                System.out.println(content);
        //     验证/判断
                content = "18058812748";
                if (content.matches("1(80|99)\\d{8}")){
                    System.out.println("验证成功");
                }else {
                    System.out.println("验证失败");
                }
        // 分割    要求:按照 # 或者 - 或者 ~ 或者 数字 来分割
                content = "hello#abc-jack12smith~北京";
                String[] split = content.split("#|-|~|\\d+");
                for (String str:split) {
                    System.out.println(str);
                }
    }
}
