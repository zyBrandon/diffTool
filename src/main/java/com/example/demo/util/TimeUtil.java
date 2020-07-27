package com.example.demo.util;

import java.util.Date;

public class TimeUtil {

    public static final int Minute = 60;
    public static final int Hour = 60 * 60;
    public static final int Day = 60 * 60 * 24;
    public static final int Week = 60 * 60 * 24 * 7;

    public static long getTime(){
        return new Date().getTime();
    }




}
