package chapter03;

public class Swaptest02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);
		
		swap(a,b);
		
		System.out.println(a + ":" + b);
	}

	private static void swap(int p, int q) {
		int temp = p;
		p = q;
		q = temp;		
	}
}
