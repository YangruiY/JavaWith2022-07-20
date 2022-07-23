package com.Enum;

public class Enumeration {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//Class 使用枚举类

//class Season{
//
//    //  1. 将构造器私有化,目的防止 直接 new
//    //  2. 去掉 setXxx 方法, 防止属性被修改
//    //  3. 在 Season 内部，直接创建固定的对象
//    //  4. 优化，可以加入 final 修饰符
//    public static final Season SPRING = new Season("春天", "温暖");
//    public static final Season SUMMER = new Season("夏天", "炎热");
//    public static final Season AUTUMN = new Season("秋天", "凉爽");
//    public static final Season WINTER = new Season("冬天", "寒冷");
//
//    private String name;
//    private String des;
//
//    private Season(String name, String des) {
//        this.name = name;
//        this.des = des;
//    }
//
//    public String getDes() {
//        return des;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", des='" + des + '\'' +
//                '}';
//    }
//}


//enum 使用枚举类
enum Season{


    ////如果使用了 enum 来实现枚举类
    // 1. 使用关键字 enum 替代 class
    // 2. public static final Season SPRING = new Season("春天", "温暖") 直接使用 SPRING("春天", "温暖")  解读常量名(实参列表)
    // 3. 如果有多个常量(对象)， 使用 ,号间隔即可
    // 4. 如果使用 enum 来实现枚举，要求将定义常量对象，写在前面 //5. 如果我们使用的是无参构造器，创建常量对象，则可以省略 ()

    //枚举对象必须放在枚举类的行首.
    SPRING("春天", "温暖"),SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),WINTER("冬天", "寒冷"),
    //如果使用无参构造器 创建 枚举对象，则实参列表和小括号都可以省略
    what(),that;
    private String name;
    private String des;

    private Season() {
    }

    private Season(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}