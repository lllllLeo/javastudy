package chapter04;

import java.util.HashSet;
import java.util.Set;

public class WrapperClassTest02 {
	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1);
		
//		반대로
		String s2 = String.valueOf(i);

		String s3 = i + "";
		
		
		System.out.println(s1);
		System.out.println(s2);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		
//		2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
//		16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	
		
		
		Set<String> s = new HashSet<String>();
		String s11 = new String("도어누");
		String s22 = new String("도어누");
		
		s.add(s11);
		s.add("둘리");
		s.add("마이콜");
		s.add("ㅈㅈ");
		
		System.out.println(s.size());
		System.out.println(s.contains(s22));
		
		
		
	}
}
