package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
// io 데코레이턴 패트를 써서 만들어놓은거
// 위를 편하게 util클래스로 만들어 놓은게 scanner
public class KeyboardTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
	//		1. 기반 스트림(표준입력, stdin, System.in)
//			System.in ->InputStream로 입력받는거
	//		2. 보조 스트림 1 (byte | byte | byte -> char) InputStreamReader
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
//			3. 보조 스트림 2 (char | char | char | \n -> "char1char2char3")
			br = new BufferedReader(isr);
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					System.out.println("종료");
					break;
				}
				System.out.println(line);
			}
		} catch (UnsupportedEncodingException e) { //지원해주는 인코딩 셋인지 Exception
			System.out.println("error " + e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
