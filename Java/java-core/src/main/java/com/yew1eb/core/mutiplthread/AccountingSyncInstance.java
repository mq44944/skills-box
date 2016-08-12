package com.yew1eb.core.mutiplthread;

/**
 * Created by fuyishan on 16/4/24.
 */
public class AccountingSyncInstance implements Runnable {

    private CountMethodObj countObj;

    public AccountingSyncInstance(CountMethodObj countObj) {
        this.countObj = countObj;
    }



    public CountMethodObj getCountObj() {
        return countObj;
    }

    public void run() {
        for (int j = 0; j < 100; j++) {
            //synchronized (countObj) {
                countObj.increment();
            //}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountMethodObj countObj= new CountMethodObj();
        AccountingSyncInstance accountingSync1 = new AccountingSyncInstance(countObj);
        AccountingSyncInstance accountingSync2 = new AccountingSyncInstance(countObj);
        for(int i =0;i<100;i++) {
            Thread t1 = new Thread(accountingSync1);
            Thread t2 = new Thread(accountingSync2);
            t1.start();
            t2.start();
        }
        Thread.sleep(10000);
        System.out.println(countObj.getCount());

    }
}


class CountObj {

    private int count ;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void increment() throws InterruptedException {
        int tmp = count+1;
        Thread.sleep(1);
        count = tmp;
    }
}