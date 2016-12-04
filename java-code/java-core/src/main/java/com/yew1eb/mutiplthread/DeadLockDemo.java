package com.yew1eb.mutiplthread;

/**
 * 死锁
 */
public class DeadLockDemo {

    final Object a = new Object();
    final Object b = new Object();

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("read:a" + Thread.currentThread().getName());

                }
                synchronized (b) {
                    System.out.println("read:b");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("read:b" + Thread.currentThread().getName());
                }
                synchronized (a) {
                    System.out.println("read:a");

                }
            }
        };

        t1.start();
        t2.start();

    }

}



