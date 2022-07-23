package com.Annotation;

import java.util.ArrayList;
import java.util.List;

public class Annotation_ {
    /*
        1) @Override: 限定某个方法，是重写父类方法, 该注解只能用于方法
            //1. @Override 注解放在 fly 方法上，表示子类的 fly 方法时重写了父类的 fly
            //2. 这里如果没有写 @Override 还是重写了父类 fly
            //3. 如果你写了@Override 注解，编译器就会去检查该方法是否真的重写了父类的方法，
                如果的确重写了，则编译通过，如果没有构成重写，则编译错误
            //4. 看看 @Override 的定义   PS： 如果发现 @interface 表示一个 注解类
                @Override源码
                @Target(ElementType.METHOD)   //@Target称为元注解
                @Retention(RetentionPolicy.SOURCE)
                public @interface Override {
                 }
        2) @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
            //1. @Deprecated 修饰某个元素, 表示该元素已经过时
            //2. 即不在推荐使用，但是仍然可以使用
            //3. 查看 @Deprecated 注解类的源码
                    源码：
            @Documented
            @Retention(RetentionPolicy.RUNTIME)
            @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
            public @interface Deprecated {
            }
            //4. 可以修饰方法，类，字段, 包, 参数 等等
            //5. @Deprecated 可以做版本升级过渡使用

        3) @SuppressWarnings: 抑制编译器警告
     */
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
    /*
         1. 当我们不希望看到这些警告的时候，可以使用 SuppressWarnings 注解来抑制警告信息
         2. 在{""} 中，可以写入你希望抑制(不显示)警告信息
         3. 可以指定的警告类型有
         all，抑制所有警告
         boxing，抑制与封装/拆装作业相关的警告
         cast，抑制与强制转型作业相关的警告
         dep-ann，抑制与淘汰注释相关的警告
         deprecation，抑制与淘汰的相关警告
         fallthrough，抑制与 switch 陈述式中遗漏 break 相关的警告
         finally，抑制与未传回 finally 区块相关的警告
         hiding，抑制与隐藏变数的区域变数相关的警告
         incomplete-switch，抑制与 switch 陈述式(enum case)中遗漏项目相关的警告
         javadoc，抑制与 javadoc 相关的警告
         nls，抑制与非 nls 字串文字相关的警告
         null，抑制与空值分析相关的警告
         rawtypes，抑制与使用 raw 类型相关的警告
         resource，抑制与使用 Closeable 类型的资源相关的警告
         restriction，抑制与使用不建议或禁止参照相关的警告
         serial，抑制与可序列化的类别遗漏 serialVersionUID 栏位相关的警告
         static-access，抑制与静态存取不正确相关的警告
         static-method，抑制与可能宣告为 static 的方法相关的警告
         super，抑制与置换方法相关但不含 super 呼叫的警告
         synthetic-access，抑制与内部类别的存取未最佳化相关的警告
         sync-override，抑制因为置换同步方法而遗漏同步化的警告
         unchecked，抑制与未检查的作业相关的警告
         unqualified-field-access，抑制与栏位存取不合格相关的警告
         unused，抑制与未用的程式码及停用的程式码相关的警告
         4. 关于 SuppressWarnings 作用范围是和你放置的位置相关
         比如 @SuppressWarnings 放置在 main 方法，那么抑制警告的范围就是 main方法的上面
         通常我们可以放置具体的语句, 方法, 类(如果放在整个类的上面，就是最大的范围了)
        5. 看看 @SuppressWarnings 源码
         (1) 放置的位置就是 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
         (2) 该注解类有数组 String[] values() 设置一个数组比如 {"rawtypes", "unchecked", "unused"}
          @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
          @Retention(RetentionPolicy.SOURCE)
          public @interface SuppressWarnings {
             String[] value ();
              }
     */
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(0));
    }
}
/*
元注解的种类
1) Retention    //指定注解的作用范围，三种 SOURCE(作用在java源码),CLASS(作用在class文件),RUNTIME(作用在jvm加载运行时间)
2) Target       // 指定注解可以在哪些地方使用
3) Documented   //指定该注解是否会在 javadoc 体现
4) Inherited    //子类会继承父类注解
 */

