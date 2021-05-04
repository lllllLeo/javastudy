package gugudan;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		
		map.put("one", 1); // auto boxing
		map.put("two", 2);
		map.put("three", 2);
		
		int  i = map.get("one"); // auto unboxing
		int  j = map.get("two");
		
		
		System.out.println(i + "dfdfdfdf" + j);
		
		
//		Stack은 Vector를 상속받고 있음
		
		Stack<String> s= new Stack<>();
		
		s.push("1");
		s.push("2");
		s.push("3");
		
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		s.peek(); // pop을 하지 않고 확인하는 용도  /  제일 최근 데이터 조회
		
		
						
	}
}
