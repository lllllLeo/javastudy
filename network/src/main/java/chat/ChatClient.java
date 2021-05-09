package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = ChatServer.PORT;
	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;
		try {
		   //1. 키보드 연결
			sc = new Scanner(System.in);
		   //2. socket 생성
			socket = new Socket();
		   //3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
		   //4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 버퍼가 다 차지 않더라도 출력시킴
		   //5. join 프로토콜
		   System.out.print("닉네임을 설정하세요.");
		   String nickname = sc.nextLine();
		   pw.println( "join:" + nickname );
		   pw.flush();
		   
		   //6. ChatClientReceiveThread 시작
		   String line = br.readLine(); // ack 받아서 안주면 쓰레드에서 ok를 받아버림 그래서 서버스레드에서 줘야함
		   if("ok".equals(line.split(":")[1])) { // join:ok -> ack ok
//			   Thread 생성 이 스레드는 메시지하고 그런거 받는곳
			   new ChatClientThread(socket).start();
		   }
		   System.out.println("입장성공함 채팅하셈");
		   //7. 키보드 입력 처리 대화 내용
		   while( true ) {
		      String input = sc.nextLine();
		      if( "quit".equals( input ) == true ) {
		          // 8. quit 프로토콜 처리
		    	  pw.println("quit:");	// pw.print 돼있어서 안됐었노
		    	  log("종료 quit 입력");
		          break;
		      } else {
		          // 9. 메시지 처리      
//		    	  System.out.println(line.split(":")[1] + " : " + input);
		    	  pw.println("message:"+input);
		      }
//		      System.out.println("> " + input);
		   }
		} catch( IOException ex ) {
		       log( "error : " + ex );
		} finally {
		      //10. 자원정리
			try{
				if(sc != null) {
					sc.close();
				}
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}	
			} catch( IOException ex ) {
				log( "error ! " + ex );
			}
		} 
	
	}
	/*============================== log ==================================*/
	private static void log(String log) {
		System.out.println("[Client : " + log + "]");
	}
}
