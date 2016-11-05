package com.yew1eb.concurrency.mutiplthread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuyishan on 16/4/25.
 */
public class DemoIneerClass {


    private final List<String> testList = new ArrayList<String>();


    private Inner1 inner1 = new Inner1();

    public class Inner1{


        public void addValue(){

            testList.add("abc");
        }




    }

    public Inner1 getInner1() {
        return inner1;
    }

    public List<String> getTestList() {
        return testList;
    }

    public static void main(String[] args) {

        DemoIneerClass demoIneerClass = new DemoIneerClass();
        Inner1 inner1 = demoIneerClass.getInner1();
        inner1.addValue();
       System.out.println(demoIneerClass.getTestList());
    }



}
