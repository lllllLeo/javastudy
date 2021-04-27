package prob2;

public class Prob2 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			String sum = "";
			for (int j = i+1; j < i+11; j++) {
				sum += " "+j;
			}
			if(i == 10) {
				return;
			}
			System.out.println(sum);
		}
		
	}
}
