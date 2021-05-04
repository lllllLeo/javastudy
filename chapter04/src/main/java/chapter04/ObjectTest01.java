package chapter04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point point = new Point(10, 10);
		
//		Class klass = point.getClass();
		System.out.println(point.getClass()); // reflection 클래스를 훑어보는거
//		hasing은 encryption하는게아님. 같은 값이 나올 수 있음. 고유한 값임
		System.out.println(point.hashCode()); // address 기반의 hasing 값       address X, reference X
		System.out.println(point.toString());	//	 getClass().getName() + "@" + Integer.toHexString(hashCode());
		System.out.println(point);
	}
}
