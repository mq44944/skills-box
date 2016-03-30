package com.yew1eb;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhouhai
 * @createTime 16/3/29
 * @description
 */
public class TestMultimap {
    public static void main(String args[]) {
        ListMultimap<String, Long> listMultimap = ArrayListMultimap.create();
        listMultimap.put("a", 1L);
        listMultimap.put("a", 2L);
        listMultimap.put("a", 2L);
        listMultimap.put("b", 3L);

        System.out.println("listMultimap:"+listMultimap.size());
        System.out.println("listMultimap:"+listMultimap.keys());
        for(String key : listMultimap.keySet()) {
            List<Long> values = listMultimap.get(key);
            System.out.println(key + ":" + values);
        }
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        System.out.println(set);
    }
}
