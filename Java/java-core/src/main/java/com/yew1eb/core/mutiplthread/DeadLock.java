package com.yew1eb.core.mutiplthread;

/**
 * @author zhouhai
 * @createTime 16/4/4
 * @description
 */
public class DeadLock {
    public static void main(String[] args) {
        new Thread(new Runnable() {

            public void run() {
                synchronized ("刀叉") {
                    System.out.println(Thread.currentThread().getName()
                    +  ": 你不给我筷子, 我就不给你刀叉");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized ("筷子") {
                        System.out.println(Thread.currentThread()
                                .getName() + ": 给你刀叉");
                    }
                }
            }
        }, "Chinese").start();

        new Thread(new Runnable() {

            public void run() {
                synchronized ("筷子") {
                    System.out.println(Thread.currentThread().getName()
                            + ": 你先给我刀叉, 我再给你筷子");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized ("刀叉") {
                        System.out.println(Thread.currentThread()
                                .getName() + ": 好吧, 把筷子给你.");
                    }
                }
            }
        }, "American").start();
    }
}
