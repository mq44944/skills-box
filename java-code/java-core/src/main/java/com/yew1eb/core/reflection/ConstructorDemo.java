package com.yew1eb.core.reflection;

import java.lang.reflect.Constructor;

public class ConstructorDemo {
    public ConstructorDemo() {
        System.out.println("no params");
    }

    private int a;
    private int b;

    public ConstructorDemo(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("A=" + a + ";B=" + b);
    }

    public void print() {
        System.out.println("A+B=" + (this.a + this.b));
    }

    public static void main(String args[]) {
        try {
            Class<?> cls = Class.forName("com.yew1eb.core.reflection.ConstructorDemo"); //实现动态类的加载
            //带参数的构造函数
            Class<?> partypes[] = new Class[]{Integer.TYPE, Integer.TYPE};
            Constructor<?> ct = cls.getConstructor(partypes);
            Object arglist[] = new Object[]{new Integer(37), new Integer(47)};
            ConstructorDemo object = (ConstructorDemo) ct.newInstance(arglist);
            object.print();

        } catch (Throwable e) {
            System.err.println(e);
        }
    }
} 
