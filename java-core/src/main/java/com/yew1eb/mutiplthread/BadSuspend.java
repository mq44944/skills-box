package com.yew1eb.mutiplthread;

/**
 * Created by fuyishan on 16/4/24.
 */
public class BadSuspend extends Thread {


    @Override
    public void run() {
     synchronized (BadSuspend.class){

         System.out.println("int "+getName());
         Thread.currentThread().suspend();

     }
    }

    public static void main(String[] args) throws InterruptedException {

        BadSuspend t1 = new BadSuspend();
        BadSuspend t2 = new BadSuspend();
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();

    }
}
