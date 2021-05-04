package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try { 
			is = new FileInputStream("sad_frog.jpg");
			os = new FileOutputStream("sad_frog_copy.jpg");
			
			int data =  -1;
			while((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (FileNotFoundException e) { // 파일이 없는 경우
			System.out.println("file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error : "+ e);
			e.printStackTrace();
		} finally {
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
