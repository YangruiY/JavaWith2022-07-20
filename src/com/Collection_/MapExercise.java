package com.Collection_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {

        Map hashMap = new HashMap();
        Object jack = hashMap.put(1,new Employee("jack", 10001, 123456));
        Object tom = hashMap.put(2,new Employee("tom", 10002, 234567));
        Object john = hashMap.put(3,new Employee("john", 10003, 345678));
        Object smith = hashMap.put(4,new Employee("smith", 10004, 456789));

        //遍历
        //方式一,使用 keySet
        Set keyset = hashMap.keySet();
        for (Object obj :keyset) {
            //现获取value
            Employee emp = (Employee)hashMap.get(obj);
            if (emp.getSalary() > 222222)
            {
                System.out.println(emp);
            }
        }

        //方式二：使用entrySet
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            //由entry取得key 和 value
            Employee emp = (Employee) entry.getValue();
            if (emp.getSalary() >333333){
                System.out.println(emp);
            }
        }

    }
}

class Employee{

    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}