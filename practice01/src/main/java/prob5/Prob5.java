package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		
		String number = "";
		for (int i = 1; i <= 100; i++) {
			int num = i;
			number = Integer.toString(num);
				
			if(number.contains("3") || number.contains("6") || number.contains("9") ) {
				System.out.print(number);
				
				if(number.charAt(0) == '3' || number.charAt(0) == '6' || number.charAt(0) == '9') {
					System.out.print("짝");
				}
				
				if(i>10) {
					if(number.charAt(1) == '3' || number.charAt(1) == '6' || number.charAt(1) == '9') {
						System.out.print("짝");
					}					
				}
				System.out.println("");
			}
		}
		
		
		
//		for(int i = 1; i <= 100; i++) {
//			String s = String.valueOf(i);
//
//			int length = s.length();
//			int clap = 0;
//
//			for(int j = 0; j < length; j++) {
//				char c = s.charAt(j);
//				if(c == '3' || c == '6' || c == '9') {
//					clap++;
//				}
//			}
//
//			if(clap == 0) {
//				continue;
//			}
//
//			System.out.print(s + " ");
//			for(int j = 0; j < clap; j++) {
//				System.out.print("짝");
//			}
//
//			System.out.print("\n");
//		}
	}
}
