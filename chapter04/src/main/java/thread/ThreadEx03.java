package thread;

public class ThreadEx03 {
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UppercaseAlphabetRunnableImpl()); // 생성자에 넣어줄 때 Runnable 인터페이스를 구현하고 있어야함.
		
		thread2.start();
		thread1.start();
		thread3.start();
	}
}
