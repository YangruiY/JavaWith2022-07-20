package com.Java8_.Optional_;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Optional_ {
    /**
     * Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在。
     * 或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
     *
     *
     *
     * Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
     *  创建Optional类对象的方法：
     *  Optional.of(T t) : 创建一个 Optional 实例，t必须非空；  Optional.empty() : 创建一个空的 Optional 实例
     *  Optional.ofNullable(T t)：t可以为null
     *  判断Optional容器中是否包含对象：
     *  boolean isPresent() : 判断是否包含对象
     *  void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
     *  获取Optional容器的对象：
     *  T get(): 如果调用对象包含值，返回该值，否则抛异常
     *  T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
     *  T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
     *  T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
     */
    @Test
    public void m1() {
        Dog dog = new Dog();
        //dog = null;   //有这句  会有java.lang.NullPointerException
        Optional<Dog> opdog = Optional.of(dog);

        System.out.println();
        dog = null;
        System.out.println(Optional.ofNullable(dog));  //不会报错, dog 可以是 null
        // orElse(T other) ：如果有值则将其返回，否则返回指定的other对象
        Dog keji = Optional.ofNullable(dog).orElse(new Dog("柯基"));
        System.out.println(keji);

        System.out.println("\n\n\n");
        Cat cat = new Cat();   //二哈
//        cat = null;  //小鸡毛
         cat = new Cat(new Dog("柴犬"));  //柴犬
        String dogName = getDogName(cat);
        System.out.println(dogName);
    }
//    public String getDogName(Cat cat){
//        return cat.getDog().getName();     //有java.lang.NullPointerException 空指针异常
//    }

    //优化 getDogName()
//    public String getDogName(Cat cat){
//        if (cat != null){
//            Dog dog = cat.getDog();
//            if (dog != null){
//                return dog.getName();
//            }
//        }
//        return null;                        //不会有 java.lang.NullPointerException 空指针异常
//    }
    // Optional类的getDogName();
    public String getDogName(Cat cat) {
        Optional<Cat> cat1 = Optional.ofNullable(cat);
        Cat jimao = cat1.orElse(new Cat(new Dog("小鸡毛")));
        Dog dog = jimao.getDog();
        Optional<Dog> dog1 = Optional.ofNullable(dog);
        Dog erha = dog1.orElse(new Dog("二哈"));
        return erha.getName();
    }

}
