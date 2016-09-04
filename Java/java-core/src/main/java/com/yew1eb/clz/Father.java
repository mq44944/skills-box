package com.yew1eb.clz;

public class Father{
    public int n;


    public Father(int n){
        this.n=n;
    }

    public Father(String msg){
        System.out.println(msg);
    }

}
class Son extends Father{
    public Son(String msg){
        super(msg);
        System.out.println(msg);
    }
}