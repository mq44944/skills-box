package com.yew1eb.log;

/**
 * @author zhouhai
 * @createTime 16/6/22
 * @description
 */
public class PrintClassLoader {

    public static void main(String [] args) {

        ClassLoader cl = PrintClassLoader.class.getClassLoader();
        System.out.println(cl.getResource("org/slf4j/impl/"));
    }
}
