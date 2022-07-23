package com.Collection_.Homework;

import java.util.ArrayList;

public class work1 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("千万!恒河水!堪忧!值得反思!"));
        arrayList.add(new News("南大百廿庆典!"));
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            News news = (News)arrayList.get(i);

            System.out.println(ProcessTitle(news.getTitle()));
        }

    }

    //处理标题的方法
    public static String ProcessTitle(String title){
        if(title == null){
            return  null;
        }else if (title.length() > 9){
            return  title.substring(0,9)+"...";
        }else{
            return title;
        }

    }

}

class News{
    private String title;
    private String content;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public News(String title) {
        this.title = title;
    }
}