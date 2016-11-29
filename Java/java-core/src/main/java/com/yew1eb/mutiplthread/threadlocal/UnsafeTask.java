package com.yew1eb.mutiplthread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 描述:私有变量会被所有线程共享
 * Created by bysocket on 16/3/8.
 */
public class UnsafeTask implements Runnable{
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting thread:%s : %s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finish thread:%s : %s\n",Thread.currentThread().getId(),startDate);
    }
}
