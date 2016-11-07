package com.yew1eb.core.mutiplthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        // 创建新线程的线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff()); // 由线程池Ececutor决定执行给定的线程。
        // 顺序关闭，执行以前提交的线程，不接受新的线程。
        exec.shutdown();
    }
}
