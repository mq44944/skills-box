package com.yew1eb.core.collection.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zhouhai
 * @createTime 16/6/24
 * @description
 */
public class ConcurrentMapT {
    
    public static void main(String [] args) {
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<String, Integer>();
        concurrentMap.put("a", 1);
        concurrentMap.put("b", 2);
        concurrentMap.put("c", 3);
        List<Integer> nums = null;
        Collection coll = concurrentMap.values();
        nums = new ArrayList(coll);
        System.out.println(nums);
    }
}
