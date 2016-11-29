package com.yew1eb.mutiplthread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuyishan on 16/4/26.
 */
public class BadVolatile {


    public static void main(String[] args) throws InterruptedException {

        List<Thread> threadList = new ArrayList<Thread>();

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(new RunnableTest(counter));
             t1.start();
            threadList.add(t1);
    }


        for (int i = 0; i < threadList.size(); i++) {
            threadList.get(i).join();
        }


        System.out.println(counter.getCount());

    }


}


class RunnableTest implements Runnable {
    //private Counter counter;
    private Counter counter;

    public RunnableTest(Counter counter) {
        this.counter = counter;
    }

    public void run() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter.increment();

    }
}


class Counter {

    private  int count = 0;
   // private int  count = 0;
    public  void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}