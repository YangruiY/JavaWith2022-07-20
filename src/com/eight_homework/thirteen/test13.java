package com.eight_homework.thirteen;

public class test13 {
    public static void main(String[] args) {
        new Student("小明",'男',23,"2020010101").info();
        new Teacher("张芳",'女',45,23).info();

        Person[] people = new Person[4];
        people[0] = new Student("jack",'男',23,"2020010101");
        people[1] = new Student("james",'女',22,"0010101");
        people[2] = new Teacher("tom",'男',45,23);
        people[3] = new Teacher("kongzi",'女',42,22);

        test13 test13 = new test13();

        System.out.println("调用方法");
        for (int i = 0; i < people.length; i++) {
            test13.test(people[i]);
        }

        test13.bubblesort(people);
    }

    //年龄排序
    public  void  bubblesort(Person[] person){
        for (int i = 0; i < person.length; i++) {
            Person tmp = null;
            for (int j = 0; j < person.length - 1-i; j++) {
                if(person[i].getAge() >person[i+1].getAge()){
                    tmp = person[i];
                    person[i] = person[i+1];
                    person[i+1] = tmp;
                }
            }

        }
        System.out.println("排序后结果：");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]); //重写了tostring方法
        }
    }
    public  void  test(Person p){ //p为运行类型
    if(p instanceof  Student){
        ((Student) p).study();
    }else if( p instanceof Teacher){
        ((Teacher) p).teach();
    }else{
        System.out.println("nothing");
    }
    }
}
