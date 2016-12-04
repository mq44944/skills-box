package com.yew1eb.core.reflection;
import java.lang.reflect.*; 

public class MethodDemo{
	public int add(int a, int b){ 
		return a + b; 
	}
	
	public static int plus(int a, int b) {
		return a * b;
	}

	public static void main(String args[]){ 
		try {

			Class<?> cls = Class.forName("reflection.MethodDemo"); 
			Class<?> partypes[] = new Class[2]; 
			partypes[0] = Integer.TYPE; 
			partypes[1] = Integer.TYPE; 
			Method method = cls.getMethod("add", partypes); 
			MethodDemo methodobj = new MethodDemo();
			//Object arglist[] = new Object[2]; 
			//arglist[0] = new Integer(37); 
			//arglist[1] = new Integer(47); 
			Object retobj= method.invoke(methodobj, 1,2); 
			Integer retval = (Integer)retobj; 
			System.out.println(retval.intValue()); 
			/*
			Class<?> c = Class.forName("java.lang.reflect.Method"); 
	        //Method[] m = c.getDeclaredMethods(); 
	        Method[] m = c.getMethods(); 
        	System.out.println(m.length);
	        for (int i = 0; i < m.length; i++) {
	        	System.out.println(m[i].toString());
	        }
	        */
	    } catch (Throwable e) { 
	    	System.err.println(e); 
	    }
	 } 
} 