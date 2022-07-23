package com.Generic;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("tom",12));
        students.add(new Student("marry",17));
        students.add(new Student("jack",13));

        for (Student student :students) {
            System.out.println(student);
        }

        HashMap<String, Student> HashMap = new HashMap<String, Student>();
            HashMap.put("tom",new Student("tom",12));
            HashMap.put("marry",new Student("marry",14));
            HashMap.put("jack",new Student("jack",15));

        Set<Map.Entry<String, Student>> entrySet = HashMap.entrySet();
        /*
        entrySet源码：

         public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        Iterator<Map.Entry<String, Student>> iterator = entrySet.iterator();
        /*
        entrySet.iterator()源码

        public final Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }
         */
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry =  iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}

class Student{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}