package com.Reflection.Get;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) throws ClassNotFoundException {
        method1Api();
    }

    public static void method1Api() throws ClassNotFoundException {

        //得到Class对象
        Class<?> aClass = Class.forName("com.Reflection.Get.Son");

//        第一组: java.lang.Class类
//        1. getName:获取全类名
        System.out.println(aClass.getName());
//        2. getSimpleName:获取简单类名
        System.out.println(aClass.getSimpleName());
//        3. getFields:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            System.out.println("父子类中的public属性" + f.getName());
        }
//        4. getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("父子类中所有public属性" + declaredField.getName());
        }

//        5. getMethods:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            System.out.println("所有public的方法" + m + "name is" + m.getName());
        }
//        6. getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("所有的本类方法" + declaredMethod.getName());

        }
//        7. getConstructors: 获取本类所有public修饰的构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("构造器" + constructor.getName());
        }
//        8. getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("所有构造器" + declaredConstructor.getName());
        }
//        9. getPackage:以Package形式返回 包信息
        System.out.println(aClass.getPackage().getName());  //com.Reflection.Get
//        10.getSuperClass:以Class形式返回父类信息
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass.getName());   //Dad
//        11.getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println("接口有" + inter);
        }
//        12.getAnnotations:以Annotation[]形式返回注解信息
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息" + annotation);
        }




    }

    @Test
    public void method2Api() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.Reflection.Get.Son");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
//        第二组: java.lang.reflect.Field 类
//        1. getModifiers:以int形式返回修饰符
//     [说明:默认修饰符是0，public 是1 , private是 2 , protected 是4 , static是8 , final 是16] , public(1) + static (8) = 9
//        2. getType:以Class形式返回类型
//        3. getName:返回属性名

            System.out.println("本类中所有的属性=" + declaredField.getName() +
                    "该属性的修饰符值=" + declaredField.getModifiers() +
                    "该属性的类型是=" +declaredField.getType());
        }
        //        第三组: java lang reflect.Method类
//        1. getModifiers:以int形式返回修饰符
//                [说明:默认修饰符是0，public 是1 , private是2 , protected是4,static是8 , final 是16]
//        2. getReturnType:以Class形式获取返回类型
//        3. getName:返回方法名
//        4. getParameterTypes:以Class[]返回参数类型数组

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("所有的本类方法" + declaredMethod.getName()
                    + "该方法的访问修饰符值=" + declaredMethod.getName()
                    + "该方法的返回值类型 = " + declaredMethod.getReturnType());
            //获得当前这个方法的形参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class parameterType:parameterTypes) {
                System.out.println("形参列表" + parameterType);
            }
        }

//        第四组: java.lang reflect.Constructor类
//        1. getModifiers:以int形式返回修饰符
//        2. getName:返回构造器名(全类名)
//        3. getParameterTypes:以Class[]返回参数类型数组
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("所有构造器" + declaredConstructor.getName());

            System.out.println("==========");
            Class[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class parameterType:parameterTypes) {
                System.out.println("构造器列表类型" + parameterType);
            }
        }


    }
}

class Dad {
    public String nick = "father";

    public Dad() {
    }

    public Dad(String nick) {
        this.nick = nick;
    }

    public void hi() {

    }

}

@Deprecated
class Son extends Dad implements IA, IB {
    //属性
    String job;
    public String name;
    private int age;
    protected double salary;
    private static int price;
    private static final String color = "黑色";

    //方法
    public void m1(String name,double price,int age,boolean bool,char ch,String[] str) {

    }

    protected void m2() {

    }

    void m3() {

    }

    private void m4() {

    }

    public Son() {
    }

    public Son(String name, int age, String job, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    private Son(String name) {
        this.name = name;
    }

}

interface IA {

}

interface IB {

}