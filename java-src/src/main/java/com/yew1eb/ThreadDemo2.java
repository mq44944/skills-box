package com.yew1eb;

/**
 * @author zhouhai
 * @createTime 16/3/16
 * @description 使用线程模拟三个窗口同时在卖五十张票，要求不能出现线程安全问题
 * 使用Runnable接口，重写Runnable 接口中的run方法，将线程的代码放入到run方法
 */

class Run implements Runnable {

    int p = 100;
    @Override
    public void run() {
        while(true) {
            synchronized ("锁") {
                if (p > 0) {
                    System.out.println(Thread.currentThread().getName()
                            + "窗口销售" + p + "号票");
                    p--;
                } else {
                    System.out.println("已售馨");
                    break;
                }
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        Run r1 = new Run();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
    }
}
