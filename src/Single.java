/**
 * 2单例设计模式

 一些人总结出来用来解决特定问题的固定的解决方案。

 解决一个类在内存中只存在一个对象，想要保证对象的唯一。
 1 为了避免其他程序过多的建立该类对象。禁止其他程序建立该类对象。
 2 为了其他程序可以访问该类对象，在本类中自定义一个对象。
 3 方便其他程序对自定义类的对象的访问，对外提供一些访问方式。
 代码：
 1将构造函数私有化
 2在类中创建一个私有的本类对象
 3提供一个用类名调用的公有方法获取该对象。
 */
public class Single {
    private static Single s = new Single(); //恶汉式
    private Single() {

    }
    public static Single getInstance() {
        return s;
    }
}

class Single2 {
    private static Single2 s = null; //懒汉
    private Single2(){

    }
    public static Single2 getInstance() {
        if( s == null) {
            s = new Single2();
        }
        return s;
    }
}