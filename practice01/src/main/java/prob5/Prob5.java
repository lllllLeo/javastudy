package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		
		String number = "";
		for (int i = 1; i < 100; i++) {
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
		
	}
}
