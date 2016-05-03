package com.yew1eb.polymorphism;

/*
 如何在多态下，使用父类引用调用子类特有方法。
 1：基本类型转换：
 1：自动：小->大    int x=1 double d=x;
 2：强制：大->小    int y=(int)d;
 2：类类型转换
 前提：继承，必须有关系
 1：自动：子类转父类  Father f=new Son();
 2：强转：父类转子类  Son s=(Son)f;
 1：类型转换
 1：Son s=(Son)f
 2：s.method3();
 */
class Father {

    void method1() {
        System.out.println("这是父类1");
    }

    void method2() {
        System.out.println("这是父类2");
    }
}

class Son extends Father {
    void method1() {
        System.out.println("这是子类1");
    }

    void method3() {
        System.out.println("这是子类3");
    }
}

class Demo3 {

    public static void main(String[] args) {
        Father f = new Son();
        f.method1(); // 这是子类1
        f.method2(); // 这是父类2

        // f.method3(); //编译报错。
        // 多态弊端，只能使用父类引用指向父类成员。

        // 类类型转换
        Son s = (Son) f;
        s.method3();

        System.out.println();
    }
}
