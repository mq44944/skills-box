package com.yew1eb.core.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListT {

    public static void main(String[] args) {
        listMethods();
    }

    /**
     * 测试ArrayList基本操作方法，其角标的使用及迭代器next()的使用。
     */
    public static void listMethods() {

        List list = new ArrayList<String>(10);

        list.add("List01");
        list.add("List03");
        list.add("List04");
        System.out.print("原来集合：\n\t" + list + "\n");
        list.add(1, "List02");
        System.out.print("指定角标1插入：\n\t" + list + "\n");
        list.remove(2);
        System.out.print("指定角标2删除：\n\t" + list + "\n");
        System.out.print("指定角标2查询：\n\t" + list.get(2) + "\n");
        // 获取ArrayList的大小
        System.out.println("Arraylist size=: " + list.size());
        // 判断list中是否包含"3"
        System.out.println("ArrayList contains 3 is: " + list.contains(3));
        // 设置第2个元素为10
        list.set(1, "10");
        Iterator i1 = list.iterator();
        System.out.println("用迭代器查询全部元素：");
        while (i1.hasNext())
            System.out.print(i1.next() + "\t");

        // 将ArrayList转换为数组
        String[] arr = (String[]) list.toArray(new String[0]);

        // 清空ArrayList
        list.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: " + list.isEmpty());
    }
}
