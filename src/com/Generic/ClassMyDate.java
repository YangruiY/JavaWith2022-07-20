package com.Generic;

public class ClassMyDate implements Comparable<ClassMyDate> {

    private int year;
    private int month;
    private int day;

    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day ;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public ClassMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    //年月日的比较
    public int compareTo(ClassMyDate o) {

            //名字相同，比较年
            int years = year -o.getYear();
            if (years != 0)
                return years;
            //年相等
            //比较月
            int months = month - o.getMonth();
            if (months != 0)
                return months;
            //月相同
            //比较日
            return day - o.getDay();
        }
}
