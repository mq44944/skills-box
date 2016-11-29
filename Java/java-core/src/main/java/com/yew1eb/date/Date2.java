package com.yew1eb.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouhai
 * @createTime 2016/11/8
 * @description
 */
public class Date2 {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static void main(String[] args) throws ParseException {
        Date curDate = new Date();
        long ts = curDate.getTime();
        System.out.println(sdf.format(curDate));
        System.out.println(ts);
        long nts = ts / 1000 / 60 * 1000 * 60;
        System.out.println(nts);
        Date nDate = new Date(nts);
        System.out.println(sdf.format(nDate));
        System.out.println(sdf.parse("2016-11-22 23:11:00").getTime() / 1000);
    }

}
