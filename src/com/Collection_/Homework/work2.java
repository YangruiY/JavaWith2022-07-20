package com.Collection_.Homework;

import java.util.*;

public class work2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("tom",1200);
        hashMap.put("jack",600);
        hashMap.put("smith",1600);
        //System.out.println(hashMap);

        //将tom工资改为1500
        hashMap.put("tom",1500);
        System.out.println(hashMap);

        //为所有员工工资加上100
        Set keyset = hashMap.keySet();
        for (Object obj :keyset) {
            hashMap.put(obj,(Integer)hashMap.get(obj)+100);
        }
        System.out.println(hashMap);

        //遍历
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + "-" +entry.getValue());
        }

        // 遍历所有工资
        Collection values = hashMap.values();
        for (Object o :values) {
            System.out.println(o);
        }


    }
}
class Employee {
    private String name;
    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}