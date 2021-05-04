package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
	
//		 indexOf("abc", 7) 하는데 abc가 6번째부터인데 7이라 해놓으면 못찾으니까 -1을 리턴함
//		method chain  stringbuffer는 return this라서 stringbuffer객체를 리턴해주니까 바로 .append 해서 계속 붙일 수 있다.
//		String s5 = "ddd" + "asdfasdf" + "asdfasdf"는 실제로
//		String 25 = new StringBuffer("asdf").append("asdf").append("asdfasdf").toString(); 임
		
		StringBuffer sb = new StringBuffer("");
		sb.append(1);
		
//		주의 : 문자열 + 연산을 하지 말아야 할 때
		String s6 = "";
		for (int i = 0; i < 10000; i++) {
//			s6 += i; 는 아래와 같음. new를 10000번 한다. new는 cpu사용량 장난아님.
//			그래서 긴 루프에서 + 연산으로 하면 안좋음
			s6 = new StringBuffer(s6).append(i).toString();
		}
//		->
//		아래처럼 해야함
		StringBuffer sb3 = new StringBuffer("");
		for (int i = 0; i < 10000; i++) {
			sb3.append(i);
		}
		String s8 = sb3.toString();
		
		
	
	}
}
