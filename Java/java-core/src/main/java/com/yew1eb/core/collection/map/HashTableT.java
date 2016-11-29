package com.yew1eb.core.collection.map;

import java.util.Hashtable;

//TODO HashTable 是同步操作的,可以用于多线程并发环境, 而HashMap 是 不是同步实现, 一般只用于单线程中
//TODO 使用中一般使用 java.util.concurrent包里的ConcurrentHashMap类
public class HashTableT {

    public void main(String[] args) {
        Hashtable<String, Integer> htable = new Hashtable<String, Integer>();


    }
}
