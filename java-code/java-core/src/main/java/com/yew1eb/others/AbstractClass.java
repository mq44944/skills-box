package com.yew1eb.others;

/**
 * @author zhouhai
 * @createTime 16/4/3
 * @description
 */

    abstract class Animal {
        String name;

        Animal() {}
        Animal(String name) {
            this.name = name;
        }
        abstract void shout();
    }

    class Dog extends Animal {
        Dog() {}
        Dog(String name) {
            super(name);
        }
        @Override
        void shout() {
            System.out.println("Wang, Wang!");
        }
    }

public class AbstractClass {
    public static void main(String[] args) {
        //抽象类不能创建对象
        //Animal a = new Animal();
        Dog d = new Dog("wang");

        System.out.println();
    }
}
