package com.yew1eb.core.reflection;
class a{
	public int i;
	private int j;
	protected int z;
}

public class ClassDemo {
	public static void main(String args[]) { 
		try { 
			Class<?> cls = Class.forName("reflection.a"); 
			System.out.println("name:" + cls.getName());
			System.out.println("method: " + cls.getMethods().length);
			System.out.println("declared method: " + cls.getDeclaredMethods().length);
			System.out.println("constructor: " + cls.getConstructors().length);
			System.out.println("declared constructor: " + cls.getDeclaredConstructors().length);
			System.out.println("field: " + cls.getFields().length);
			System.out.println("declared field: " + cls.getDeclaredFields().length);
		    boolean b1 = cls.isInstance(new Integer(37)); 
		    System.out.println(b1); 
		    boolean b2 = cls.isInstance(new a()); 
		    System.out.println(b2); 
		} catch (Throwable e) { 
			System.err.println(e); 
		}
	}
}
