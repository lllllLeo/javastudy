package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			result += text.charAt(i);
			System.out.println(result);
		}
		scanner.close();
		
		
//		int length = text.length();
//		for(int i = 0; i < length; i++) {
//			for(int j = 0; j <= i; j++) {
//				System.out.print(text.charAt(j));
//			}
//
//			System.out.println("");
//		}
	}

}
