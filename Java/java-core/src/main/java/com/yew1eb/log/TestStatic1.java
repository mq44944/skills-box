package com.yew1eb.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;


/**
 * @author zhouhai
 * @createTime 16/6/28
 * @description
 */
public class TestStatic1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestStatic1.class);
    private static int a1 = 1;
    public static int a2 = 2;

    static {
        a1 = 10;
        a2 = 20;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class intClass = int.class;
        Class stringClass = Class.forName("java.lang.String");
        System.out.println(intClass.isPrimitive());
        System.out.println(stringClass.isPrimitive());
        StringBuilder sb = new StringBuilder();
        sb.reverse();
    }
}
