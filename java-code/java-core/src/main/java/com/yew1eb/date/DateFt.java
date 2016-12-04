package com.yew1eb.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouhai
 * @createTime 2016/10/26
 * @description
 */
public class DateFt {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println(toMinutes("2016-10-26 11:51:46"));
        System.out.println(toMinutes("2016-10-26 13:01:03"));
        String str = "2016-10-26 11:51:46";
        String substr = str.substring(0, 16);
        System.out.println(substr);

        System.out.println(sdf.format(new Date(1477637889L*1000)));
        System.out.println(sdf.format(new Date(24627298L*1000*60)));
        System.out.println(sdf.format(new Date(24627297L*1000*60)));
    }

    private static long toMinutes(String dateTime) {
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date.getTime() / 1000 / 60;
    }
}
