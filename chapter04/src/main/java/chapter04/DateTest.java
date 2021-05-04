package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date(); 
		System.out.println(date);
		
		printDate01(date);
		printDate02(date);
	}

	private static void printDate02(Date date) {
//		년도
		date.getYear();
	}

	private static void printDate01(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd h시 m분 s초");
		System.out.println(sdf.format(date));
	}
}
