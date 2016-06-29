package com.yew1eb.log;


import org.apache.log4j.Logger;

/**
 * @author zhouhai
 * @createTime 16/6/28
 * @description
 */
public class TestStatic {
    private static final Logger LOGGER = Logger.getLogger(TestStatic.class);
    private static int a1 = 1;
    public static int a2 = 2;

    static {
        a1 = 10;
        a2 = 20;
    }

    public static void main(String[] args) {
        System.out.println(TestStatic.a1+":"+TestStatic.a2);
        LOGGER.info("test");
        Logger logger = Logger.getLogger(TestStatic.class);
        System.out.println(logger.getClass().getName());
    }
}
