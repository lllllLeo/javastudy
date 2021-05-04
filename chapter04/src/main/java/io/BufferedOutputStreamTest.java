package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;
//		데코레이션 패턴 런타임할때
		try {
//			기반 스트림
//			FileOutputStream fos = new FileOutputStream("test.txt");
//			버퍼에 모아놨다가 한 번에 줌
//			보조 스트림
			
			/* FileOutputStream으로 주 스트림을 생성하고, 보조스트림 BufferedOutputStream을 주 스트림에 할당 
             * 데코레이터 패턴이며, 파일을 읽어들이는 것은 주스트림인데, 실제로 파일을 다루는 것은 보조스트림이기 때문입니다.
             */
			bos = new BufferedOutputStream(new FileOutputStream("test.txt"));	// 프로그램은 얘만 사용
			
			for (int i = 'a'; i < 'z'; i++) { // 97 < 122
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("can't open: " + e);
		} catch (IOException e) {
			System.out.println("error: "+ e);
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close(); // 스트림을 close()하면 자동으로 플러시됨. bos.flush()
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
