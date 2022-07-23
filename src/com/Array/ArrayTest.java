package com.Array;

//格式化代码 Ctrl+Alt+L
//复制代码 Ctrl+Alt+向下箭头
//删除代码 Ctrl+Y
//运行代码  Alt+R
//搜索  Shift+Shift
//Settings界面  Ctrl+Alt+S
//Ctrl+Alt+L
//Alt+enter  导包
//.var快速生成变量名
// main sout fori forarr
public class ArrayTest {
    public static void main(String[] args) {
        MyTools myTools = new MyTools();
        int arr[] = {1, -2, 3, 4, -5, 69, 59, 34};
        myTools.bubble(arr);
        //.var快速生成变量名
        person person = new person();
        //Alt+enter  导包
        person person2 = new person();
        person person1 = new person("杨睿", "202201010101", 24);


        System.out.println("排序后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

class person {
    String name;
    String number;
    int age;
    //生成构造器的快捷键 Ctrl+end

    public person() {
    }

    public person(String name, String number, int age) {
        this.name = name;
        this.number = number;
        this.age = age;
    }
}

class MyTools {
    public void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}