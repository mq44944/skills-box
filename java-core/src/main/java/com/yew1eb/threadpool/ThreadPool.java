package com.yew1eb.threadpool;

public interface ThreadPool {
	boolean execute(Runnable task);
	void shutdown();
}
