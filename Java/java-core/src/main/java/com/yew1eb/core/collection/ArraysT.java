package com.yew1eb.core.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArraysT {

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
    }
}
