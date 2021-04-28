package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("숫자를 입력하세요: ");
		int number = scanner.nextInt();
		int result = 0;	
		
//		if(number%2 != 0) { // 홀
//			for (int i = 0; i < number+1; i++) {
//				if(i%2 !=0) {
//					result += i;
//				}
//			}
//			System.out.println("결과 값 : " + result);
//		} else {
//			for (int i = 0; i < number+1; i++) {
//				if(i%2 ==0) {
//					result += i;
//				}
//			}			
//			System.out.println("결과 값 : " + result);
//		}
		
		for (int i = 0; i <= number; i++) {
			if(number%2 != 0 && i%2 != 0 || number%2 == 0 && i%2 == 0) {
				result += i;
			}
		}
		System.out.println("결과 값 : " + result);
		
		scanner.close();
	}
}
