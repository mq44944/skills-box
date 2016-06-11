package com.yew1eb.core.collection.queue;

import java.util.PriorityQueue;

public class PriorityQueueT {
    public static void main(String[] args) {
        int[] nums = {1, 10, 5, 3, 4, 7, 6, 9, 8};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int x : nums)
            pq.offer(x);
        // 注意排序
        System.out.println("pq: " + pq);
    }
}