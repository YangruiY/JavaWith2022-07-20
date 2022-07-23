package com.Java8_.Stream_API;

import com.Java8_.References.Employee;
import com.Java8_.References.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 关注的是对数据的运算，与Cpu打交道，集合关注的是数据的存储，与内存打交道
 *
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 * Stream 的操作三个步骤
 * 1- 创建 Stream(即实例化)
 *      一个数据源（如：集合、数组），获取一个流
 *  2- 中间操作(一系列的过滤、映射......)
 *      一个中间操作链，对数据源的数据进行处理
 *  3- 终止操作(终端操作)
 *      一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */
public class Stream_api {
    /**
     * 实例化
     */
    /*
        创建 Stream 方式一  ： 通过集合
           Java8 中的 Collection 接口被扩展，提供了两个获取流的方法：
             1. default Stream<E> stream() : 返回一个顺序流
             2. default Stream<E> parallelStream() : 返回一个并行流
     */
    @Test
    public void m1(){

        List<Employee> employees = EmployeeData.getEmployees();
        // default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }


    /*
        创建 Stream 方式二 ： 通过数组
        Java8 中的 Arrays 的静态方法 stream() 可以获取数组流
            static <T> Stream<T> stream(T[] array): 返回一个流
          重载形式，能够处理对应基本类型的数组：
            public static IntStream stream(int[] array)
            public static LongStream stream(long[] array)
            public static DoubleStream stream(double[] array)
     */
    @Test
    public void m2(){
        int arr[] = {1,2,3,4,5,6};

        // int 型
        IntStream stream = Arrays.stream(arr);

        // 泛型
        Employee e1 = new Employee(1001,"tom");
        Employee e2 = new Employee(1002,"jack");
        Employee e3 = new Employee(1003,"jhon");
        Employee[] employees = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }
    // 创建 Stream方式三：通过Stream的of()
    // 可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。
    // public static<T> Stream<T> of(T... values) : 返回一个流
    @Test
    public void m3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }
    /*
        创建 Stream方式四：创建无限流
        可以使用静态方法 Stream.iterate() 和 Stream.generate(), 创建无限流。
              迭代  : public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
              生成  : public static<T> Stream<T> generate(Supplier<T> s)
     */
    @Test
    public void m4(){
        // 迭代  : public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // 遍历前十个偶数
        Stream.iterate(4,t -> t + 2).limit(20).forEach(System.out :: println);

        //生成  : public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math :: random).limit(3).forEach(System.out::println);
    }

    /**
     * 中间操作
     *      1-筛选与切片
     *      2-映 射
     *      3-排序
     */
    @Test
        public void m5(){
            /**
             *  2.1-筛选与切片
             *    filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
             *
             *    limit(long maxSize) 截断流，使其元素不超过给定数量
             *
             *    distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
             *
             *    skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
             */
            //filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
            //查询工资大于 7000 的员工信息
            System.out.println("filter");
            List<Employee> list = EmployeeData.getEmployees();
            Stream<Employee> stream = list.stream();
            stream.filter(e -> e.getSalary() > 7000).forEach(System.out :: println);


            //limit(long maxSize) 截断流，使其元素不超过给定数量
            System.out.println("limit");
            list.stream().limit(4).forEach(System.out::println);

            //skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
            System.out.println("skip");
            list.stream().skip(4).forEach(System.out :: println);


            //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
            System.out.println("distinct");
            list.add(new Employee(1000,"库克",56,1500));
            list.add(new Employee(1000,"库克",56,1500));
            list.add(new Employee(1000,"库克",56,1500));
            System.out.println(list);
            list.stream().distinct().forEach(System.out::println);

    }


    @Test
    public void  m6(){
        /**
         * 2.2-映 射
         *  map(Function f)  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         *
         *  mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
         *
         *  mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
         *
         *  mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
         *
         *  flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
         */
        //map(Function f)  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().map(str -> str.toUpperCase() + "\t").forEach(System.out::print);

        System.out.println();

        //练习一 ：获取员工姓名长度大于 3 的员工姓名
        System.out.println("练习一");
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);

        //练习二 ：
        System.out.println("练习二");
        Stream<Stream<Character>> streamStream = list.stream().map(Stream_api::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::print);
        });
        System.out.println();
        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(Stream_api::fromStringToStream);
        characterStream.forEach(System.out::println);

        ArrayList  integers = new ArrayList ();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        ArrayList  integers1 = new ArrayList ();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(integers);      //[1, 2, 3, [1, 2, 3]]   类似 map
        integers1.addAll(integers);   //[1, 2, 3, 1, 2, 3]   类似 flatmap
        System.out.println(integers1);

    }

    //将字符串中的多个字符构成的集合转换成对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character character :str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }


    /**
     *  2.3-排序
     *      sorted() 产生一个新流，其中按自然顺序排序
     *      sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
     */
    @Test
    public void m7(){
        //sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> integers = Arrays.asList(12, 23, 34, 41, 5, 34, 32, 2, 1, -1);
        integers.stream().sorted().forEach(System.out::println);
//          产生异常，
//              java.lang.ClassCastException: com.Java8_.References.Employee cannot be cast to java.lang.Comparable
//              原因， EmployeeData 没有实现 Comparable 接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((o1,o2) -> Integer.compare(o1.getAge(),o2.getAge())).
                forEach(System.out::println);

        System.out.println();
        List<Employee> employees1 = EmployeeData.getEmployees();
        employees1.stream().sorted((o1,o2) ->{
            int compare = Integer.compare(o1.getAge(), o2.getAge());
            if (compare != 0){
                return compare;
            }else{
                return -Double.compare(o2.getSalary(),o1.getSalary());
            }
        }).forEach(System.out::println);
    }

    /**
     * 3- 终止操作(终端操作)
     *
     * Stream 的终止操作
     *  3.1-匹配与查找
     *  allMatch(Predicate p) 检查是否匹配所有元素
     *  anyMatch(Predicate p) 检查是否至少匹配一个元素
     *  noneMatch(Predicate p) 检查是否没有匹配所有元素
     *  findFirst() 返回第一个元素
     *  findAny() 返回当前流中的任意元素
     *  count() 返回流中元素总数
     *  max(Comparator c) 返回流中最大值
     *   min(Comparator c) 返回流中最小值
     *  forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
     */

    @Test
    public void m8(){
        //allMatch(Predicate p) 检查是否匹配所有元素
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 13);
        System.out.println(allMatch);

        //anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 8000);
        System.out.println(anyMatch);
        //noneMatch(Predicate p) 检查是否没有匹配所有元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getId() == 1001);
        System.out.println(noneMatch);
        //findFirst() 返回第一个元素
        System.out.println(employees.stream().findFirst());
        //findAny() 返回当前流中的任意元素
        System.out.println(employees.parallelStream().findAny());
        //count() 返回流中元素总数
        System.out.println(employees.stream().filter(e -> e.getSalary() > 4000).count());
        //max(Comparator c) 返回流中最大值
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        System.out.println(doubleStream.max(Double::compare));
        //min(Comparator c) 返回流中最小值
        Optional<Employee> min = employees.stream().min((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        System.out.println(min);
        //forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        //forEach(Consumer c) 内部迭代
        employees.stream().forEach(System.out::println);
        //使用集合的遍历方式
        employees.forEach(System.out::println);
    }
    @Test
    public void m9(){
        /**
         * 3.2-归约
         *  reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
         *  reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
         *      PS : 备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 Google用它来进行网络搜索而出名。
         */
        //reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        //1~10 求和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce(0, Integer::sum));

        //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //所有员工求和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Stream<Double> doubleStream1 = employees.stream().map(Employee::getSalary);
        System.out.println(doubleStream.reduce(Double::sum));
        System.out.println(doubleStream1.reduce((d1,d2) -> d1 +d2));
    }
    @Test
    public void m10(){
        /**
         * 3-收集
         * Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)。
         *  另外， Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，具体方法与实例如下表
         *  toList List<T> 把流中元素收集到List List<Employee> emps= list.stream().collect(Collectors.toList());
         * toSet Set<T> 把流中元素收集到Set  Set<Employee> emps= list.stream().collect(Collectors.toSet());
         * toCollection Collection<T> 把流中元素收集到创建的集合 Collection<Employee> emps =list.stream().collect(Collectors.toCollection(ArrayList::new))
         * 等等.......
         */
        //Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)。
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println(employees.stream().filter(e -> e.getSalary() > 4009).collect(Collectors.toList()));

        System.out.println(employees.stream().filter(e -> e.getSalary() > 4009).collect(Collectors.toSet()));

        Set<Employee> collect = employees.stream().filter(e -> e.getSalary() > 4009).collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }

}
