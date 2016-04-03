package com.yew1eb.polymorphism;

/*
多态练习
	1：多态可以作为形参，接受范围更广的对象，避免函数重载过度使用。
		1：定义功能，根据输出任何图形的面积和周长。
		子类重写了父类的抽象方法，多态下，会执行子类的非静态方法。
	2：多态可以作为返回值类型。
		获取任意一辆车对象
	3：抽象类和接口都可以作为多态中的父类引用类型。
*/

import java.util.Map;

abstract class MyShape {
    public abstract double getArea();
    public abstract double getCircumference();
}
class Rect extends MyShape {
    double width;
    double height;
    Rect() {}
    Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumference() {
        return 2*(width + height);
    }
}
class Circle extends MyShape {
    double r;
    public static final double PI = Math.PI;

    Circle() {}
    Circle(double r) {
        this.r = r;
    }
    @Override
    public double getArea() {
        return PI * r * r;
    }

    @Override
    public double getCircumference() {
        return 2 * PI * r;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(new Rect(3, 4));
        System.out.println(new Circle(3));
    }
}
