package com.yew1eb.concurrency.mutiplthread;

/**
 * Created by fuyishan on 16/4/24.
 */
public class AccountingSyncMethod implements Runnable {

    private CountMethodObj countObj;

    public AccountingSyncMethod(CountMethodObj countObj) {
        this.countObj = countObj;
    }

    public CountMethodObj getCountObj() {
        return countObj;
    }

    public void run() {
        for (int j = 0; j < 10000; j++) {
                countObj.increment();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CountMethodObj countObj= new CountMethodObj();
        AccountingSyncInstance accountingSync1 = new AccountingSyncInstance(countObj);
        AccountingSyncInstance accountingSync2 = new AccountingSyncInstance(countObj);
        Thread t1 =  new Thread(accountingSync1);
        Thread t2 =new Thread(accountingSync2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(countObj.getCount());

    }
}


class CountMethodObj {

            private int count ;


        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
        public synchronized void increment(){

            count++;
    }
}