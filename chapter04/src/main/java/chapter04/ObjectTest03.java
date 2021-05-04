package chapter04;

public class ObjectTest03 {
	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
//		String 클래스는 hashcode, toString, equal 다 정의되어있음
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
		
		System.out.println("=============================");
		
		
//		힙에 리터럴 (스트링풀)이 있는데 아래처럼 생성하게 되면 여기에 저장되어서 hasing을하여서 
//		같은 값이면 새로 생성하지않고 같은 객체를 참조하게 됨
		String s3 = "ABC";
		String s4 = "ABC";
		
		
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));

		
//		리터럴풀도 개수제한이 있음
		Integer i = 10;
	}
}
