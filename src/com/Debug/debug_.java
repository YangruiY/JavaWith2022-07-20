package com.Debug;

import java.util.Arrays;

//F7(跳入) F8(跳过) shift+F8(跳出)
//F9(resume,执行到下一个断点)
// F7：跳入方法内.
// F8: 逐行执行代码.
// shift+F8: 跳出方法
public class debug_ {
    public static void main(String[] args) {
      int arr[]= {2,-3,4,5,56,34,-23};
        debug__ debug = new debug__();
        debug.bubble(arr);
        Arrays.sort(arr);
    }

}

class debug__{
    public void  bubble(int[] arr) {
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
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }

    }


}