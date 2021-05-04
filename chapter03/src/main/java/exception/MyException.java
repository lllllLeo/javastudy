package exception;

public class MyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public MyException() {
		super("이이이이이");
	}
	
	public MyException(String message) {
		super(message);
	}
	
}
