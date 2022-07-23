package com.encap;

public class encapusulation {
    public static void main(String[] args) {
        Person person = new Person("张三",78,231912.91829);

        System.out.println(person.show());
    }
}
class Person{
    public String name;
    private  int age;
    private  double salary;

    public Person() {
    }


    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        setName(name);
        setAge(age);
        setSalary(salary);
    }



    public void setName(String name) {
        if (name.length() >= 2  && name.length() < 17){
            this.name = name;
        }else{
            System.out.println("name isn't reason ,give default name is ry");
            this.name = "ry";
        }
    }

    public void setAge(int age) {

        if (age > 0 && age < 200){
            this.age = age;
        }else{
            System.out.println("age isn't reason ,give default age is 24");
            this.age = 24;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    public  String   show(){
        return "message is"  + "salary ="+ salary
                +"\t name =" +name + "\t age = " + age;
    }
}
