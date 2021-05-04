package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList02 {	
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt"); // 아까와는 다르게 file 정보, 경로, 수정한날짜? 이런거 알려주는 클래스
			
			if(!file.exists()) { // 앞에서는 trt ~ catch를 했는데. 이건 이걸로간으. try catch는 에러찾아가면서 stack에 쌓이고 exception객체를
				// 만들어야기때문에 비용이 비싸다.  그래서 이런 로직은 if문으로 처리해라
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=========== 파일 정보 ===========");
			System.out.println(file.getAbsolutePath()); // Y:\douzone\eclipse-project\javastudy\chapter04\phone.txt
			
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			
			System.out.println("=========== 전화 번호 ===========");
	//		1. 기반 스트림
			FileInputStream fis = new FileInputStream(file);
			
//			2. 보조 스트림1 (byte -> char)
			InputStreamReader isr = new InputStreamReader(fis);
			
//			3. 보조 스트림2 (char1|char2|char3| \n -> "char1char2char3"
			br = new BufferedReader(isr);
			
//			4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
//				System.out.println(line);
				StringTokenizer s = new StringTokenizer(line, "\t ");	// \t, 공백으로 쪼개줌
				int index = 0;
				while(s.hasMoreTokens()) {
					String token = s.nextToken();
					if(index == 0) { // 이름
						System.out.print(token + ":");
					} else if (index == 1) { // 전화번호 1
						System.out.print(token + "-");
					} else if (index == 2) { // 전화번호 2
						System.out.print(token + "-");
					} else {  // 전화번호 3
						System.out.print(token);
					}
					index++;
				}
				System.out.println("");
			}
			
		} catch (IOException e) { 	// 원래 FileNotFoundException인데 IOException으로 함 FileNotFoundException은 IOException 자식클래스니까 ㄱㅊ 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	}
}
