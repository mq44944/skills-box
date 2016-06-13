package com.yew1eb.core.thread;

public class SleepRunThread {
    public static void main(String[] args) {
        System.out.println("当前线程ID => " + Thread.currentThread().getId());

        SRThread t1 = new SRThread("t1");
        t1.start();
        SRThread t2 = new SRThread("t2");
        t2.run();
    }
}
class SRThread extends Thread {
    private String name;

    public SRThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name +", 线程ID => " + Thread.currentThread().getId());
    }
}