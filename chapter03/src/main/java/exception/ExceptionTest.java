package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("코드 1");
		
		try {
			System.out.println("코드 2");
//			int result = (1 + 2 + 3) /b;
			System.out.println("코드 3");
		} catch (ArithmeticException e) {
//			catch문을 비워놓으면 나쁜 예외처리
			// 1. 사과
			// 2. 로깅. 파일에 남겨놓던지 디비에 남겨놓아야함. 
//			3. 정상 종료 return
			System.out.println("dd " + e);
			e.printStackTrace();
		} finally {
//			자원 해제
			System.out.println("finally 출력");
		}
		System.out.println("코드4");
	}
}
