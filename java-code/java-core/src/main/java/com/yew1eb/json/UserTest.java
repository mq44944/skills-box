package com.yew1eb.json;

/**
 * @author zhouhai
 * @createTime 2016/11/10
 * @description
 */
public class UserTest {
    private int id;
    private int age;

    public UserTest() {

    }

    public UserTest(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id=" + String.valueOf(id) + ",age=" + String.valueOf(age);
    }
}