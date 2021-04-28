package chapter03;

public class StaticMethodTest {
	public static void main(String[] args) {
		String s = "123";
		
		int i = Integer.parseInt(s);
		int j = Math.abs(-1);
		int k = Math.max(10,20);
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
	}
//	값ㅇ르 바로 빼서 저장하고 싶은데 굳이 객체를 만들어서 할 필요없이  
}
