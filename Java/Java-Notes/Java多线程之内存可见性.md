Title: Java多线程之内存可见性
Date: 2015-4-19 11:45:47
Category: Java
Tags: Java, 多线程
Slug: java_memory_multi-threaded_visibility
Summary: Java多线程之内存可见性；Java内存模型（JMM)

## 可见性

__可见性__：一个线程对共享变量值得修改，能够及时地被其他线程看到。  
__共享变量__：如果一个变量在多个线程的工作内存中都存在副本，那么这个变量就是这几个线程的共享变量。  
   

## Java内存模型（JMM)
__Java内存模型（Java Memory Model)__：描述了Java程序中各种变量（线程共享变量）的访问规则，以及在JVM中将变量存储到内存和从内存中读取出变量这样的底层细节。  

有待深入学习：[深入理解java内存模型系列文章](http://ifeve.com/java-memory-model-0/)
***

## 共享变量可见性实现的原理
线程A对共享变量的修改要想被线程B及时看到，必须要经过如下2个步骤：  
* 把工作内存A中更新过的共享变量刷新到主内存中  
* 将主内存中最新的共享变量的值更新到工作内存B中  

## Java可见性的实现方式
Java语言层面支持的可见性实现方式：
* synchronized  
* volatile  
  

待学习：<http://www.imooc.com/learn/352>