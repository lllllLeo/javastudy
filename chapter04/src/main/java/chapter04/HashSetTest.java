package chapter04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>();
		
		Rect rect1 = new Rect(10, 20);
		Rect rect2 = new Rect(10, 20);
		
		
		set.add(rect1);
		set.add(rect2);
		
		for (Rect rect : set) {
			System.out.println(rect);
		}

//		1. hashcode가 같은지 확인 -> ㅇㅋ
//		2. equals 비교 -> ㅇㅋ
//		-> 같다.
		
//		1번
//		hashcode 오버라이드 안하면 해시코드가 다르니까 set에 바로 넣어버림 
		System.out.println(rect1.hashCode()); // 653305407
		System.out.println(rect2.hashCode()); // 1130478920
		
//		2번
//		hashcode 오버라이드 하면 equals까지 비교함
		System.out.println(rect1.hashCode()); // 1591
		System.out.println(rect2.hashCode()); // 1591
		
//		hashcode, equals를 동시에 오버라이드해야함
		
		
		
		
		System.out.println(set.toString()); // 1번은 2개 다 들어감, 2번은 하나만 들어감
		

		
	}
}
