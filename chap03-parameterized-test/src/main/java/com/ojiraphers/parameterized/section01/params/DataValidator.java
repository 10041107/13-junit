package com.ojiraphers.parameterized.section01.params;

import java.time.Month;

public class DataValidator {
    public static boolean isCollect(Month month){
        int monthValue = month.getValue();
        return monthValue >= 1 && monthValue <=12;
    }

    public static int get(Month month){
        return
    }

    public static int getLastDayOf(Month month) {
    }
}
