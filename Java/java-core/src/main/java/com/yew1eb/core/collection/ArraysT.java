package com.yew1eb.core.collection;

import com.alibaba.fastjson.JSON;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ArraysT {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String str = "hostName";

        long start = System.currentTimeMillis();
        long hostId = 0L;
        int n = 100000000;
        for (int i = 0; i < n; ++i) {
            hostId = str.hashCode() % 1024;
            hostId = str.hashCode() & 0x3ff;
        }
        long end = System.currentTimeMillis();
        System.out.println("time total: " + (end - start) + "ms");
        List<String> list = new ArrayList<>();
        list.add("dasfd");
        list.add("daw");
        list.add("wew");
        System.out.println(list);


        Object x = JSON.toJSONString(list);
        System.out.println(x);
        try {

            String dateFromStr = "2016-10-10 00:00:00";
            Date dateFrom = dateFormat.parse(dateFromStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFrom);
            calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
            Date dateTo = calendar.getTime();
            System.out.println(dateFormat.format(dateFrom));
            System.out.println(dateFormat.format(dateTo));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
