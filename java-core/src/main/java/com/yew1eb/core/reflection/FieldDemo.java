package com.yew1eb.core.reflection;

import java.lang.reflect.*; 

public class FieldDemo{ 
	private int i; 

	public static void main(String args[]){ 
		try { 
			Class<?> cls = Class.forName("reflection.FieldDemo"); 
			Field fld = cls.getDeclaredField("i");
			FieldDemo fobj = new FieldDemo(); 
			System.out.println(fld.toString());
			System.out.println(fld.getName() + " = " + fobj.i);
			//fld.setAccessible(true);
			fld.setInt(fobj, 15); 
			System.out.println(fld.getName() + " = " + fobj.i); 
		} catch (Throwable e){ 
			System.err.println(e);
		} 
	} 
} 