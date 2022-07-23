package com.Generic;

public class Employee {

        private String name;
        private int salary;
        private ClassMyDate birthday;

        @Override
        public String toString() {
            return "Employee{" +
                    "name:" + name  +
                    ",salary:" + salary +
                    ",birthday:" + birthday +
                    '}' + "\n";
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

        public ClassMyDate getBirthday() {
            return birthday;
        }

        public void setBirthday(ClassMyDate birthday) {
            this.birthday = birthday;
        }

        public Employee(String name, int salary, ClassMyDate birthday) {
            this.name = name;
            this.salary = salary;
            this.birthday = birthday;
        }
    }

