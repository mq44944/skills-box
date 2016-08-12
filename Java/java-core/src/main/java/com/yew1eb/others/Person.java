package com.yew1eb.others;

/**
 * @author zhouhai
 * @createTime 16/5/19
 * @description
 */
public class Person {
    String name;
    Person () {}
    public Person(String personName) {
        name = personName;
    }

    public String greet(String yourName) {
        return  String.format("Hi %s, my name is %s", name, yourName);
    }
}