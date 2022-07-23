package com.Reflection.Class;

import java.io.Serializable;
import java.lang.reflect.Field;
/*
    反射是动态加载   ---运行时加载需要的类， 如果运行时不用该类，即使不存在该类，则不报错
    而一般的new XX()，则是静态加载   --- 编译时加载相关的类，如果没有则报错，

    类加载时机及分类：
        1.当创建对象时(new) ----------------------静态加载
        2.当子类被加载时,父类也加载-----------------静态加载
        3.调用类中的静态成员时----------------------静态加载
        4.通过反射--------------------------------动态加载
 */
public class class01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //Class 类也是继承 Object的
        /* ClassLoad类
         public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */

        //反射方式
        Class aClass = Class.forName("com.Reflection.Class.Cat");
        String classAllPath1 = "com.Reflection.Class.Cat";
        //获取到Cat类 对应Class 对象   <?> 表示不确定的Java类型
        Class<?> aClass1 = Class.forName(classAllPath1);
        System.out.println(aClass1);   //显示aClass1的对象是哪个类的对象   为com.Reflection.Class.Cat
        System.out.println(aClass1.getClass());  // 运行类型 java.lang.Class

        //获得XX名
        System.out.println(aClass1.getPackage().getName());   //包名
        System.out.println(aClass1.getName());   //全类名

        Object cat = (Cat)aClass1.newInstance();
        System.out.println(cat);     //cat.toString()

        Field age = aClass1.getField("age");//获得属性
        System.out.println(age.get(cat));

        age.set(cat,4);//通过反射给属性设值
        System.out.println(age.get(cat));
        System.out.println("=====");
        //得到所有的属性
        Field[] fields = aClass1.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        //获取Class对象的方法 6种
        //1 class.forName()    应用场景： 读取配置文件获取
        String classAllPath = "com.Reflection.Class.Cat";
        //获取到Cat类 对应Class 对象   <?> 表示不确定的Java类型
        Class<?> aCla = Class.forName(classAllPath);
        System.out.println(aCla);

        //2 类名.class          应用场景：用于参数传递
        System.out.println(Cat.class);

        //3 对象.getClass       应用场景：有对象实例
        Cat cat1 = new Cat();
        Class aClass2 = cat1.getClass();
        System.out.println(aClass2);

        //4 通过类加载器[4种]来获取到类的Class 对象
        //1)得到类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        //2)通过类加载器得到Class对象
        Class<?> aClass3 = classLoader.loadClass(classAllPath);
        System.out.println(aClass3);

        //5 基本数据类型   形： Class XXXXX =基本数据类型.class
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);
        System.out.println(characterClass);
        System.out.println(booleanClass);

        //6 基本数据类型对应的包装类   Class XXXXX =包装类.TYPE
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type);
        System.out.println(type1);


        //具有Class类型的对象
        Class<String> stringClass = String.class;  //外部类
        Class<Serializable> serializableClass = Serializable.class;  //接口
        Class<Integer[]> aClass4 = Integer[].class;   // 数组
        Class<float[][]> aClass5 = float[][].class;   // 二维数组
        Class<Deprecated> deprecatedClass = Deprecated.class;//注解
        Class<Enum> enumClass = Enum.class;//枚举
        Class<Thread.State> stateClass = Thread.State.class;   //枚举
        Class<Long> longClass = long.class;  //基本数据类型
        Class<Void> voidClass = void.class; // void数据类型
        Class<Class> classClass = Class.class;  // Class
        System.out.println("-----------------------------");
        System.out.println(stringClass);
        System.out.println(serializableClass);
        System.out.println(aClass4);
        System.out.println(aClass5);
        System.out.println(deprecatedClass);
        System.out.println(enumClass);
        System.out.println(stateClass);
        System.out.println(longClass);
        System.out.println(voidClass);
        System.out.println(classClass);
    }

}
