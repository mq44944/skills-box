package com.yew1eb.core.mutiplthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouhai
 * @createTime 2016/11/5
 * @description
 */
public class VolatileDemo {

    private volatile int number = 0;

    private Lock lock = new ReentrantLock(); //加锁

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        //this.number++; //++操作不是原子操作
        synchronized (this){
            this.number++;
        }
    }


    public static void main(String[] args) {
        final VolatileDemo volDemo = new VolatileDemo();
        for (int i = 0; i < 500; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volDemo.increase();
                }
            }).start();
        }
        System.out.println("number:" + volDemo.getNumber());
        //入股还有子线程在运行，主线程就让出CPU资源，
        //直到所有的子线程都运行完了，主线程再继续往下执行
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("number:" + volDemo.getNumber());
    }
}
