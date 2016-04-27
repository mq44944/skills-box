package com.yew1eb.others;

/**
 * @author zhouhai
 * @createTime 16/4/5
 * @description
 */
public class Test {

    public static void main(String[] args) {

        int[] a = new int[]{2, 1};
        Arrays.selectSort(a);

        System.out.println(a[ (a.length-1) / 2]);
    }
}
