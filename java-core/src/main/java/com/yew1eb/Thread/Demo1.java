package com.yew1eb.thread;

/**
 * @author zhouhai
 * @createTime 16/4/4
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
        Person p = new Person();
        Producer pro = new Producer(p);
        Consumer con = new Consumer(p);
        Thread t1 = new Thread(pro, "生产者");
        Thread t2 = new Thread(con, "消费者");
        t1.start();
        t2.start();
    }
}

class Person {
    String name;
    String gender;

    public synchronized void set(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public synchronized void read() {
        System.out.println("name:" + this.name + "----gender:" + this.gender);
    }
}

class Producer implements Runnable {
    Person p;

    public Producer() {}

    public Producer(Person p) {
        this.p = p;
    }

    public void run() {
        int i = 0;
        while(true) {
            if (i % 2 == 0) {
                p.set("jack","man");
            } else {
                p.set("alice","woman");
            }
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Person p;

    public Consumer() {}

    public Consumer(Person p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            p.read();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}