package com.yew1eb;

/**
 * @author zhouhai
 * @createTime 16/3/16
 * @description 继承Thread 类，复写run方法，把线程代码放入到run方法中，使用start方法启动线程。
 */
public class ThreadDemo1 extends Thread {

    public void run() {
        print();
    }

    public ThreadDemo1(String name) {
        super(name);
    }

    public void print() {
        for (int i = 0; i < 200; ++i) {
            System.out.println(this.getName() + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 t1 = new ThreadDemo1("Thread 1#1, ");
        ThreadDemo1 t2 = new ThreadDemo1("Thread 2#2, ");
        t1.start();
        t2.start();
    }
}
