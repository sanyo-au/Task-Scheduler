package com.example.sanyo.hw2_groups24;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by sanyo on 2/3/2018.
 */

public class Task implements Comparable<Task>,Serializable{
    String title;
    int day;
    int month;
    int year;
    int hour;
    int minutes;
    String priority;
    Calendar calendar;



    public void setDate() {
        calendar = new GregorianCalendar(year,month,day,hour,minutes);
    }
    

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minutes=" + minutes +
                ", priority='" + priority + '\'' +
                '}';
    }


    @Override
    public int compareTo(Task o) {
        return this.calendar.compareTo(o.calendar);
    }
}
