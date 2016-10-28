package com.yew1eb.core.collection;

import com.alibaba.fastjson.JSON;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArraysT {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
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


        Date d1 = dateFormat.parse("2013-10-22 05:12:10");
        Date d2 = dateFormat.parse("2013-10-23 08:10:10");
        long xiaoshi = (((d2.getTime() - d1.getTime()) / 1000) / 60);
        System.out.println("已累计在线：" + xiaoshi + "mins");
        System.out.println(d1.getTime());
        long d1min = (Integer.MAX_VALUE/2) / 1000 / 60;
        System.out.println(dateFormat.format(new Date(d1min*1000*60)));
    }
}
