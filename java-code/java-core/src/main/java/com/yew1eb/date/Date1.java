package com.yew1eb.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouhai
 * @createTime 2016/11/8
 * @description
 */
public class Date1 {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Date curDate = new Date();
        long ts = curDate.getTime();
        System.out.println(sdf.format(curDate));
        System.out.println(ts);
        long nts = ts / 1000 / 60 * 1000 * 60;
        System.out.println(nts);
        Date nDate = new Date(nts);
        System.out.println(sdf.format(nDate));
    }

}
