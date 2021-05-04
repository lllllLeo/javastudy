package prob01;

public class Printer2 {
	
//	제네릭 지렸다
	public <T> void println(T t) {
		System.out.println(t);
	}
//  22	
	public <T> void println(T... ts) {
		for (T t2 : ts) {
			System.out.println(t2);
		}
	}
}
