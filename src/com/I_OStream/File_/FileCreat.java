package com.I_OStream.File_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreat {
    public static void main(String[] args) {

    }

    //创建文件方式一
    @Test
    public void create01() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件1创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建文件方式二
    @Test
    public void create02() {
        File parentFile = new File("e:\\");
        String filename = "news2.pdf";
        File file = new File(parentFile, filename);
        try {
            file.createNewFile();
            System.out.println("文件2创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建文件方式二
    @Test
    public void create03() {

        String parentPath = "e:/";
        String Filename = "news3.jar";
        File file = new File(parentPath, Filename);
        try {
            file.createNewFile();
            System.out.println("文件3创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void info() {
        File file = new File("e:/news1.txt");
        System.out.println("文件名：" + file.getName());
        System.out.println("文件绝对路径" + file.getAbsolutePath());
        System.out.println("文件父目录" + file.getParent());
        System.out.println("文件大小(字节)" + file.length());
        System.out.println("文件是否存在" + file.isDirectory());
    }

    @Test
    //判断e:\news2.pdf是否存在，存在就删除
    public void makedir1() {
        String filePath = "e:\\news2.pdf";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除文件！");
            } else {
                System.out.println("删除失败");
            }
        } else {
            System.out.println("文件不存在");
        }
    }

    @Test
    //判断e:\demo是否存在，存在就删除,java中，目录也是视为文件的
    public void makedir2() {
        String filePath = "e:\\demo";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除目录成功");
            } else {
                System.out.println(filePath + "删除目录失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }

    @Test
    //判断e:\\demo\\a\\b\\c是否存在，存在就提示存在,不存在就创建
    public void makedir3() {
        String directoryPath = "e:\\demo/a/b/c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "目录存在");
        } else {

            //mkdir创建一级目录
            //mkdirs创建多级目录
            if (file.mkdirs()) {
                System.out.println(directoryPath + "目录已创建");
            }else{
                System.out.println(directoryPath + "目录未创建");
            }
        }
    }
}

