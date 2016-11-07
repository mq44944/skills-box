package com.yew1eb.core.mutiplthread;

/**
 * Created by fuyishan on 16/4/24.
 */
public class SimpleWNA {

    final static Object object = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T1 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! ");
                try {
                    System.out.println(System.currentTimeMillis() + ":T2 wait for object ");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new T1();
        Thread t2 = new T2();
        t2.start();

//        thread.sleep(1000);
        t1.start();


    }

}


