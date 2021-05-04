package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader reader = null; 
		InputStream is = null;
		try {
			reader = new FileReader("1234.txt"); // UTF-8.3바이트 이 파일은 7개
			int data = -1;
			int count = 0;
			while((data = reader.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println("\n"+count);
			
			is= new FileInputStream("1234.txt");
			
			data = -1;
			count = 0;
			while((data = is.read()) != -1) {	// 바이트 단위로 읽어서 글이 깨짐
				System.out.print((char)data);
				count++;
			}
			System.out.println("\n"+count);
		} catch (FileNotFoundException e) {
			System.out.println("file not found: "+e);
		} catch (IOException e) {
			System.out.println("error : "+e);
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
				reader.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}

	}

}
