package com.yew1eb.regular;

/**
 * @author zhouhai
 * @createTime 16/4/4
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("a".matches("."));
        System.out.println("a1a".matches("\\d"));
        System.out.println("a1a%".matches("\\D"));
        System.out.println("\r".matches("\\s"));
        System.out.println("^".matches("\\S"));
        System.out.println("a".matches("\\w"));

        System.out.println( "a".matches(".") );
        System.out.println( "a".matches("a") );
        System.out.println("a".matches("a?") );
        System.out.println( "aaa".matches("a*") );
        System.out.println( "".matches("a+") );
        System.out.println( "aaaaa".matches("a{5}") );
        System.out.println( "aaaaaaaaa".matches("a{5,8}") );
        System.out.println( "aaa".matches("a{5,}") );
        System.out.println( "aaaaab".matches("a{5,}") );
    }
}
