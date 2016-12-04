package com.yew1eb.core.reflection;

import java.lang.reflect.*; 

public class FieldDemo{ 
	private int i; 

	public static void main(String args[]){ 
		try { 
			Class<?> cls = Class.forName("com.yew1eb.core.reflection.FieldDemo");
			Field fld = cls.getDeclaredField("i");
			FieldDemo fobj = new FieldDemo(); 
			System.out.println(fld.toString());
			System.out.println(fld.getName() + " = " + fld.getInt(fobj));

			fld.setInt(fobj, 15); 
			System.out.println(fld.getName() + " = " + fld.getInt(fobj));
		} catch (Throwable e){ 
			System.err.println(e);
		} 
	} 
} 