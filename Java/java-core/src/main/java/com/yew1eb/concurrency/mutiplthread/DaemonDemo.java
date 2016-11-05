package com.yew1eb.concurrency.mutiplthread;

/**
 * Created by fuyishan on 16/4/24.
 */
public class DaemonDemo  extends Thread{

    @Override
    public void run() {
       while (true){
           System.out.println("I am alive!");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }


       }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new DaemonDemo();
       // t.setDaemon(true);
        t.start();

        Thread.sleep(2000);


    }
}
