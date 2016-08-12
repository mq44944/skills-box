package com.yew1eb.core.mutiplthread;

/**
 * Created by fuyishan on 16/4/24.
 */
public class AccountingSyncClass implements Runnable {


    public void run() {
        for (int j = 0; j < 10000; j++) {
            CountClassObj.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AccountingSyncClass accountingSync1 = new AccountingSyncClass();
        AccountingSyncClass accountingSync2 = new AccountingSyncClass();
        Thread t1 = new Thread(accountingSync1);
        Thread t2 = new Thread(accountingSync2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(CountClassObj.getCount());

    }


}


class CountClassObj {

    private static int count;


    public static int getCount() {
        return count;
    }


    public static synchronized void increment() {
        count++;
    }
}
