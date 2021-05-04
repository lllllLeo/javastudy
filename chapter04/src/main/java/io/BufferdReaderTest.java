package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferdReaderTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
//		기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferdReaderTest.java");
//		보조 스트림
			br = new BufferedReader(fr);
			
			
			
			String line = null;
			int index = 0;
			while((line = br.readLine()) != null) { //	String은 객체라서 null사용
				System.out.print(index);
				System.out.println(line);
				index++;
			}
					
		} catch (FileNotFoundException e) {
			System.out.println("file not found" +e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
