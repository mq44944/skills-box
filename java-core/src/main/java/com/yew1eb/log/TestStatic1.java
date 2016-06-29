package com.yew1eb.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static void main(String[] args) {
        System.out.println(TestStatic1.a1 + ":" + TestStatic1.a2);
        LOGGER.info("test");
        Logger logger = LoggerFactory.getLogger(TestStatic1.class);
        System.out.println(logger.getClass().getName());
    }
}
