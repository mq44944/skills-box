package com.yew1eb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhouhai
 * @createTime 16/3/30
 * @description
 */
public class TestMap {
    public static void main(String args[]) {
        Map<Integer, Integer> ipMap = new HashMap<Integer, Integer>();
        int n = 1000000;
        for (int i = 0; i <=n; ++i) {
            ipMap.put(i, i);
        }

        Set<Integer> set = null;
        List<Long> arrays = null;
        try {
            set = ipMap.keySet();

        }catch (Exception e) {
            long a = arrays.get(120);
            System.out.println(e);
        }

        long start = System.currentTimeMillis();
        boolean bool = set.contains(n);
        long end = System.currentTimeMillis();
        System.out.println(bool+"time cost : " + (end - start) + "ms");
    }
}
