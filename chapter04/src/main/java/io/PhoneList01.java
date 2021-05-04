package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList01 {	
	public static void main(String[] args) {
		Scanner sc = null;
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
	
			sc = new Scanner(file);
//			스캐너는 내부에 토커나이즈 io가 들어가있음 그래서 구현하기 쉬움
			while (sc.hasNextLine()) {		// 읽을 때 자동으로 탭 스페이스 개행으로 끊어서 읽어줌
				String name = sc.next();
				String phone1= sc.next();
				String phone2= sc.next();
				String phone3= sc.next();
				System.out.println(
									name+ ":" + 
									phone1 + "-" + 
									phone2 + "-" + 
									phone3
								  );
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();				
			}
		}
	}
}
