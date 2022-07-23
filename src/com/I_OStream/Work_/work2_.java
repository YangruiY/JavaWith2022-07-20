package com.I_OStream.Work_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class work2_ {
    public static void main(String[] args) {
        String fileName ="e:\\java.txt";
        BufferedReader bufferedReader = null;
        String line = "";
        int lineNum = 0;
        try {
             bufferedReader = new BufferedReader(new FileReader(fileName));
             while ((line = bufferedReader.readLine()) != null){
                 System.out.println( ++lineNum + line);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if (bufferedReader != null){
               try {
                   bufferedReader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}
