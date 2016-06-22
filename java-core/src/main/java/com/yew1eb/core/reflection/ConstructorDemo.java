package com.yew1eb.core.reflection;
import java.lang.reflect.*; 

public class ConstructorDemo{
	public ConstructorDemo(){
		System.out.println("no params");
	} 
	public ConstructorDemo(int a, int b){ 
		System.out.println("a="+a+";b="+b); 
	}

	public static void main(String args[]){ 
		try { 
			Class<?> cls = Class.forName("reflection.ConstructorDemo"); //实现动态类的加载
			
			//cls.newInstance();//创建对象
			
			//获取所有的构造函数
		
			
			//不带参数的构造函数
			/*
			Constructor<?> ct= cls.getConstructor(new Class[]{});
			ct.newInstance();
			*/
			
			//带参数的构造函数
	        Class<?> partypes[] = new Class[2]; 
	        partypes[0] = Integer.TYPE;   
	        partypes[1] = Integer.TYPE; 
	        Constructor<?> ct= cls.getConstructor(partypes); 
	        Object arglist[] = new Object[2]; 
	        arglist[0] = new Integer(37); 
	        arglist[1] = new Integer(47); 
	        ct.newInstance(arglist);
	    } catch (Throwable e) { 
	    	System.err.println(e);
	    } 
	}
} 
