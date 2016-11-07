package com.yew1eb.core.mutiplthread;

/**
 * Created by fuyishan on 16/4/25.
 */
public class VisibilityTest extends Thread {

    private volatile boolean stop;

    public void run() {
        int i = 0;
        while (!stop) {
            i++;
            //System.out.println(i);
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }

    public static void main(String[] args) throws Exception {
        VisibilityTest v = new VisibilityTest();
        v.start();
        Thread.sleep(1000);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }
}
