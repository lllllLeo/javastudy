package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
//		throws IOException 얘 때문에 try catch가 강제됨
		System.out.println("some codes1");
		System.out.println("some codes2");

		if(5 - 5 == 0) {
			throw new MyException();
		}
		
		if(10 - 10 == 0) {
			throw new IOException();
		}
		
		System.out.println("some codes3");
		System.out.println("some codes4");
	}
}
