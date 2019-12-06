package com.example.hotel_project.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransform {


    static public Date String2Date(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //小写的mm表示的是分钟
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("时间转换失败");
        }
        return date;
    }

    static public String Date2String(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }
}
