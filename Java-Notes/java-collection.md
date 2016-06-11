Java集合是java提供的工具包，包含了常用的数据结构：集合、链表、队列、栈、数组、映射等。Java集合工具包位置是java.util.*
Java集合主要可以划分为4个部分：List列表、Set集合、Map映射、工具类(Iterator迭代器、Enumeration枚举类、Arrays和Collections)。  
Java集合工具包框架图:  
![](http://images.cnitblog.com/blog/497634/201309/08171028-a5e372741b18431591bb577b1e1c95e6.jpg)

## Collection架构
link: <http://www.cnblogs.com/skywang12345/p/3308513.html>   

![](http://images.cnitblog.com/blog/497634/201309/08172429-1ecddb7a87e347369ffc7c1c30f18396.jpg)  

### ArrayList详细介绍(源码解析)和使用示例
link:<http://www.cnblogs.com/skywang12345/p/3308556.html>

ArrayList 是一个数组队列，相当于 动态数组。与Java中的数组相比，它的容量能动态增长。它继承于AbstractList，实现了List, RandomAccess, Cloneable, java.io.Serializable这些接口。

###  fail-fast总结(通过ArrayList来说明fail-fast的原理、解决办法)
link:<http://www.cnblogs.com/skywang12345/p/3308762.html>  

fail-fast 机制是java集合(Collection)中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。

### LinkedList详细介绍(源码解析)和使用示例
link:<http://www.cnblogs.com/skywang12345/p/3308807.html>   
LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。  
LinkedList 实现 List 接口，能对它进行队列操作。  
LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。  
LinkedList 实现了Cloneable接口，即覆盖了函数clone()，能克隆。  
LinkedList 实现java.io.Serializable接口，这意味着LinkedList支持序列化，能通过序列化去传输。  
LinkedList 是非同步的。  
![](http://images.cnitblog.com/blog/497634/201401/272345393446232.jpg)  

## Map架构
link:<http://www.cnblogs.com/skywang12345/p/3308931.html>
![](http://images.cnitblog.com/blog/497634/201309/08221402-aa63b46891d0466a87e54411cd920237.jpg)

### HashMap详细介绍(源码解析)和使用示例
link:<http://www.cnblogs.com/skywang12345/p/3310835.html>

### Hashtable详细介绍(源码解析)和使用示例
link:<http://www.cnblogs.com/skywang12345/p/3310887.html>

### TreeMap详细介绍(源码解析)和使用示例
link:<http://www.cnblogs.com/skywang12345/p/3310928.html>

### WeakHashMap详细介绍(源码解析)和使用示例
link:<http://www.cnblogs.com/skywang12345/p/3311092.html>
 WeakReference是“弱键”实现的哈希表。它这个“弱键”的目的就是：实现对“键值对”的动态回收。当“弱键”不再被使用到时，GC会回收它，WeakReference也会将“弱键”对应的键值对删除。  
    “弱键”是一个“弱引用(WeakReference)”，在Java中，WeakReference和ReferenceQueue 是联合使用的。在WeakHashMap中亦是如此：如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。 接着，WeakHashMap会根据“引用队列”，来删除“WeakHashMap中已被GC回收的‘弱键’对应的键值对”。  
    另外，理解上面思想的重点是通过 expungeStaleEntries() 函数去理解。
    