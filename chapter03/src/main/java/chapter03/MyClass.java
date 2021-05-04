package chapter03;

import javax.management.InstanceAlreadyExistsException;

public class MyClass {
	private static MyClass instance;
	private MyClass() { }
	
	// Singleton + Factory Method
	public static MyClass getInstance()	{
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}
