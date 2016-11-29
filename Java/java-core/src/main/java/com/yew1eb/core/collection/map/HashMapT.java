package com.yew1eb.core.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HashMapT {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //map.clear();
        map.put(new String("A2342"), 10);
        map.put(new String("A1231"), 5);
        System.out.println("contains key=A2342, " + map.containsKey("A2342"));
        System.out.println("key = A2342, value=" + map.get("A2342"));
        System.out.println("map Elements:");
        System.out.print("\t" + map + "\n\n");

        System.out.println("entrySet: " + map.entrySet());
        System.out.println("keySet: " + map.keySet());
        System.out.println("valueSet: " + map.values());
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            // 获取key
            String key = (String) entry.getKey();
            // 获取value
            Integer integ = (Integer) entry.getValue();
        }

        Integer[] list = null;
        map.values().toArray(list);
        System.out.println(list);
    }
}
