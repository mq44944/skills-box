package com.yew1eb.core.collection.list;


import java.util.LinkedList;

public class LinkedListT {

    public static void main(String[] args) {
        testLinkedListAPIs();
    }

    private static void testLinkedListAPIs() {
        String val = null;
        //LinkedList llist;
        //llist.offer("10");
        // 新建一个LinkedList
        LinkedList llist = new LinkedList();
        //---- 添加操作 ----
        // 依次添加1,2,3
        llist.add("1");
        llist.add("2");
        llist.add("3");

        // 将“4”添加到第一个位置
        llist.add(1, "4");


        System.out.println("\nTest \"addFirst(), removeFirst(), getFirst()\"");
        // (01) 将“10”添加到第一个位置。  失败的话，抛出异常！
        llist.addFirst("10");
        System.out.println("llist:" + llist);
        // (02) 将第一个元素删除。        失败的话，抛出异常！
        System.out.println("llist.removeFirst():" + llist.removeFirst());
        System.out.println("llist:" + llist);
        // (03) 获取第一个元素。          失败的话，抛出异常！
        System.out.println("llist.getFirst():" + llist.getFirst());


        System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");
        // (01) 将“10”添加到第一个位置。  返回true。
        llist.offerFirst("10");
        System.out.println("llist:" + llist);
        // (02) 将第一个元素删除。        失败的话，返回null。
        System.out.println("llist.pollFirst():" + llist.pollFirst());
        System.out.println("llist:" + llist);
        // (03) 获取第一个元素。          失败的话，返回null。
        System.out.println("llist.peekFirst():" + llist.peekFirst());


        System.out.println("\nTest \"addLast(), removeLast(), getLast()\"");
        // (01) 将“20”添加到最后一个位置。  失败的话，抛出异常！
        llist.addLast("20");
        System.out.println("llist:" + llist);
        // (02) 将最后一个元素删除。        失败的话，抛出异常！
        System.out.println("llist.removeLast():" + llist.removeLast());
        System.out.println("llist:" + llist);
        // (03) 获取最后一个元素。          失败的话，抛出异常！
        System.out.println("llist.getLast():" + llist.getLast());


        System.out.println("\nTest \"offerLast(), pollLast(), peekLast()\"");
        // (01) 将“20”添加到第一个位置。  返回true。
        llist.offerLast("20");
        System.out.println("llist:" + llist);
        // (02) 将第一个元素删除。        失败的话，返回null。
        System.out.println("llist.pollLast():" + llist.pollLast());
        System.out.println("llist:" + llist);
        // (03) 获取第一个元素。          失败的话，返回null。
        System.out.println("llist.peekLast():" + llist.peekLast());


        // 将第3个元素设置300。不建议在LinkedList中使用此操作，因为效率低！
        llist.set(2, "300");
        // 获取第3个元素。不建议在LinkedList中使用此操作，因为效率低！
        System.out.println("\nget(3):" + llist.get(2));


        // ---- toArray(T[] a) ----
        // 将LinkedList转行为数组
        String[] arr = (String[]) llist.toArray(new String[0]);
        for (String str : arr)
            System.out.println("str:" + str);

        // 输出大小
        System.out.println("size:" + llist.size());
        // 清空LinkedList
        llist.clear();
        // 判断LinkedList是否为空
        System.out.println("isEmpty():" + llist.isEmpty() + "\n");

    }
}
