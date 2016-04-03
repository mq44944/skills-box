package com.yew1eb.polymorphism;

/*
 案例2
 1：定义一功能，接收用户传入动物，根据用于传入的具体动物，执行该动物特有的方法
 2：使用多态，方法形参，不能确定用户传入的是那种动物
 3：使用instanceof 关键字，判断具体是何种动物，
 4：类转换，执行该动物的特有方法。
 */
class Animal {
    String color;

    Animal() {

    }

    Animal(String color) {
        this.color = color;
    }

    void run() {
        System.out.println("跑跑");
    }
}

class Dog extends Animal {
    Dog() {

    }

    Dog(String color) {
        super(color);
    }

    void run() {
        System.out.println("狗儿跑跑");
    }

    void protectHome() {
        System.out.println("旺旺，看家");
    }
}

class Fish extends Animal {
    Fish() {

    }

    Fish(String color) {
        super(color);
    }

    void run() {
        System.out.println("鱼儿水中游");
    }

    void swim() {
        System.out.println("鱼儿游泳");
    }
}

class Bird extends Animal {
    Bird() {

    }

    Bird(String color) {
        super(color);
    }

    void run() {
        System.out.println("鸟儿空中飞");
    }

    void fly() {
        System.out.println("我是一只小小鸟。。。。");
    }
}

class Demo4 {

    public static void main(String[] args) {

        System.out.println();
        doSomething(new Dog());
        doSomething(new Bird());
        doSomething(new Fish());
    }

    // 定义一功能，接收用户传入动物，根据用于传入的具体动物，执行该动物特有的方法
    public static void doSomething(Animal a) {
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.protectHome();
        } else if (a instanceof Fish) {
            Fish f = (Fish) a;
            f.swim();
        } else if (a instanceof Bird) {
            Bird b = (Bird) a;
            b.fly();
        } else {
            System.out.println("over");
        }
    }
}