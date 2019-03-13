package com.dima.weather.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatter {

    @SuppressLint("SimpleDateFormat")
    public static String timeFormatter(long time){
        return new SimpleDateFormat("HH:mm").format(new Date(time * 1000L));
    }
}
