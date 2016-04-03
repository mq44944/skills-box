1. 文件编码
2. File 类的使用
3. RandomAccessFile类的使用
4. 字节流
5. 字符流

#### 6. 对象的序列化和反序列化
1、对象序列化: 就是将Object转换成byte序列，反之叫对象的反序列化

2、序列化流（ObjectOutputStream)，字节的过滤流 —— writeObject()方法
   反序列化流（ObjectInputStream）—— readObject（）方法

3、序列化接口（Serializable）
对象必须实现序列化接口，才能进行序列化，否则将出现异常。
这个接口，没有任何方法，只是一个【标准】

二、transient关键字
1、transient修饰的元素，不会进行JVM默认的序列化：如int transient age = 10;
在序列化和反序列化后，age的值为默认分配的值0
2、可以自己通过重写序列化操作方式，来对transient修饰的元素进行想要的序列化。
***方法：通过从ArrayList中拿到writeObject()和readObject()方法，进行自写完成。
· 先执行s.defaultWriteObject(); 和 s.defaultReadObject()方法
· 再对于无法默认序列化的成员，可以进行.writeObject(obj)和this.obj = s.readObject()完成序列化
3、这样做的目的是提高效率。如ArrayList里，对数组的有效对象进行序列化