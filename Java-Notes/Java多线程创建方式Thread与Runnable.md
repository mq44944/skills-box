Title:Java多线程创建方式Thread与Runnable
Date:2015-4-19 12:38:35
Category: Java
Tags: Java, 多线程
Slug: java_multi-threaded_thread_and_runnable
Summary: 线程创建的两种方式比较； 线程的生命周期； 线程的守护神——守护线程  
                        
## 线程创建的两种方式  

1. 继承Thread 类
2. 实现Runnable接口 

## 两种方式的比较
* Runnable方式可以避免Thread方式由于Java单继承特性带来的缺陷
* Runnable的代码可以被多个线程（Thread实例）共享，适合于多个线程处理同一资源的情况

## 线程的生命周期



## 深入学习Java多线机制   
待学习。。。[《Java线程：从入门到实践》 — 51cto](http://developer.51cto.com/art/200512/15883.htm)