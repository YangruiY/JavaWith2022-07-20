package com.Exception;

import java.util.Scanner;

public class EXceptionEXcr {
    public static void main(String[] args) {

        //需求
        // 1. 创建 Scanner 对象
        // 2. 使用无限循环，去接收一个输入
        // 3. 然后将该输入的值，转成一个 int
        // 4. 如果在转换时，抛出异常，说明输入的内容不是一个可以转成 int 的内容
        // 5. 如果没有抛出异常，则 break 该循环
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String string = " ";
        do{
            System.out.println("input Integer");
            try {
                string = scanner.next();
                i = Integer.parseInt(string);
                //i = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("input again");
            }

        }while(true);

    }
}

