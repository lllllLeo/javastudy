package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;


/*
 * read() inputStream으로부터 1바이트를 읽고 읽은 바이트를 4바이트 int 타입으로 리턴
 * 		입력 스트림으로부터 더 이상 바이트를 읽을 수 없으면 read()는 -1 리턴
 * read(byte []b)는 주어진 바이트 배열의 길이만큼 바이트를 읽고 저장
 * 
 ***** 
 	byte양이 많을때는 read(byte[] b)를 이용하는게 좋다. 왜냐하면 read()는 바이트 수 만큼 루프하지만 read(byte[]b)는 한 번 읽을때
 	주어진 바이트 배열의 길이만큼 읽기 때문에 루프횟수가 적음
 * */

public class IOExample {
	public static void main(String[] args) throws IOException {
		byte[] src = {1,2,3,4};
		byte[] dest= null;
		
		InputStream is = new ByteArrayInputStream(src);
		OutputStream os = new ByteArrayOutputStream();
				
//		int data = is.read();
//		System.out.println(data);

		int data = -1;
		
		while((data = is.read()) != -1){
			os.write(data);
			System.out.println(data);
		}
		
		dest = ((ByteArrayOutputStream)os).toByteArray();	// 내부에있는 바이트를 내놔라
		System.out.println("dest는" + dest[0]);
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
		
	}
}
