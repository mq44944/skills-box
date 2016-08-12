package com.yew1eb.core.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastT {

    private static List<String> list = new ArrayList<String>();

    //private static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static void printAll() {
        System.out.println("");

        String value = null;
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
    }

    private static class Thread1 extends Thread {
        public void run() {
            int i = 0;
            while( i < 6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            int i = 10;
            while( i < 16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }
}
