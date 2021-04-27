package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.println("돈 입력해요");
		int result = scanner.nextInt();
		int won = 0;
		if(result >= 50000) {
			won = result/50000;
			System.out.println("50000원 : " + won+"개");
			result -= 50000 * won;
		}
		if(result >= 10000) {
			won = result/10000;
			System.out.println("10000원 : " + won+"개");
			result -= 10000 * won;
		}
		if(result >= 5000) {
			won = result/5000;
			System.out.println("5000원 : " + won+"개");
			result -= 5000 * won;
		}
		if(result >= 1000) {
			won= result/1000;
			System.out.println("1000원 : " + won+"개");
			result -= 1000 * won;
		}
		if(result >= 500) {
			won = result/500;
			System.out.println("500원 : " + won+"개");
			result -= 500 * won;
		}
		if(result >= 100) {
			won = result/100;
			System.out.println("100원 : " + won+"개");
			result -= 100 * won;
		}
		if(result >= 50) {
			won = result/50;
			System.out.println("50원 : " + won+"개");
			result -= 50 * won;
		}
		if(result >= 10) {
			won = result/10;
			System.out.println("10원 : " + won+"개");
			result -= 10 * won;
		}
		if(result >= 5) {
			won = result/5;
			System.out.println("5원 : " + won+"개");
			result -= 5 * won;
		}
		if(result >= 1) {
			won = result/1;
			System.out.println("1원 : " + won+"개");
			result -= 1 * won;
		}
		
		
		scanner.close();
 	}
}