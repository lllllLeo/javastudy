package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

//  List로 들어와야함(Print 객체)
public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName;
	private List<Writer> pwList;
	
	public ChatServerThread(Socket socket, List<Writer> pwList) {
		this.socket = socket;
		this.pwList = pwList; 
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw  = null;
//		1. Remote Host Information
		InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
		log( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() ); // client의 ip, port번호
		
		try {
//		2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), false); // TODO 뒤에 고치기
			
//		3. 요청 처리
			while(true) {
				String line = br.readLine(); // \n 이면인가?
				if(line == null) {
					log("closed by client");
					doQuit(pw);
					break;
				}
//		4. 프로토콜 분석
//			요청명령:파라미터1:파라미터2:...\r\n
//			join:
//			\r\n은 각 요청을 구분하는 경계
//			: 을 기준으로 요청명령과 파라미터로 분리
				String[] tokens = line.split(":");
				if("join".equals(tokens[0])) { // join:
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					System.out.println("doMessage In "+tokens.toString());
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					ChatServer.log("에러 : 알 수 없는 요청 ("+ tokens[0] +")");
				}
			}
		} catch (SocketException e) {
			log("SocketException error ! " + e);
		} catch (UnsupportedEncodingException e) {
			log("UnsupportedEncodingException error ! " + e);
		} catch (IOException e) {
			log("IOException error ! " + e);
		} finally {
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}	
				
			} catch( IOException ex ) {
				log( "error ! " + ex );
			}
		}
	}
//	사용자가 나갈 때 리스트에서 스레드 제거하고 전체에 뿌리기
	private void doQuit(PrintWriter writer) {
		log("doQuit called");
		removeWriter(writer);
		String data = nickName + " 님이 퇴장했습니다."; 
		broadcast(data);
	}

	//	message:ㅎㅇ ㅇ\r\n
	private void doMessage(String chatMessage) {
		log("doMessage called");
		log("doMessage called nickname : "+ nickName + " chatMessage = " + chatMessage);
//		broadcast("message:" + chatMessage); // 전체가 프로토콜을 인식해서 뿌려야하기 때문
		broadcast(nickName + " : " + chatMessage); // 전체가 프로토콜을 인식해서 뿌려야하기 때문
	}

//	join:nickname\r\n  
	private void doJoin(String nickName, PrintWriter pw) throws IOException {
		log("doJoin called");
		this.nickName = nickName;
		String data = nickName + " 님이 입장하셨습니다.";
		broadcast(data);
		addWriter(pw);
		
//		ack ok 클라이언트에게 알려줌
		pw.println("join:ok\r\n");  // IOException
		pw.flush();
	}

//	전체 송신
	private void broadcast(String data) {
		log("broadcast called");
		synchronized (pwList) {
			for (Writer writer : pwList) {
				PrintWriter pw = (PrintWriter) writer;
				pw.println(data);
				pw.flush();
			}
		}
		
	}

	private void removeWriter(PrintWriter writer) { synchronized (pwList) { pwList.remove(writer); } }
	private void addWriter(Writer pw) { synchronized (pwList) { pwList.add(pw); } }

	
/*============================== log ==================================*/
	public static void log(String log) {
		System.out.println("[ServerThread : " + log + "]");
	}
}
