package com.Generic;

import java.util.ArrayList;
import java.util.Comparator;

public class ClassExercise {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 2600, new ClassMyDate(1997, 11, 18)));
        employees.add(new Employee("jack", 2900, new ClassMyDate(2000, 5, 19)));
        employees.add(new Employee("jack", 2900, new ClassMyDate(2000, 8, 19)));
        employees.add(new Employee("jack", 2900, new ClassMyDate(2000, 4, 19)));
        employees.add(new Employee("marry", 1600, new ClassMyDate(2003, 1, 17)));
        employees.add(new Employee("marry", 1600, new ClassMyDate(2004, 2, 17)));
        System.out.println(employees);
        System.out.println("排序");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee Employee1, Employee Employee2) {
                //按照姓名排序，否则按照生日日期前后排序
                //校验参数
                if (!(Employee1 instanceof Employee && Employee2 instanceof Employee)) {
                    return 0;
                } else {
                    //比较名字

                    //名字不同
                    int i = (Employee1.getName()).compareTo(Employee2.getName());
                    if (i != 0)
                        return i;
                }
                return Employee1.getBirthday().compareTo(Employee2.getBirthday());
            }
        });
        System.out.println(employees);
    }
}
