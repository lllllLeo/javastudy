package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8888;
	
	public static void main(String[] args) {
//		1. 서버 소켓 생성
		ServerSocket serverSocket = null;
		List<Writer> pwList = new ArrayList();
//		2. 연결(바인딩)
		try {
			serverSocket = new ServerSocket();
			
//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림 모든 IP(모든 사용자)" + " 포트 :" + PORT);
//		3. 요청 대기
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, pwList).start();
				System.out.println("pwList에 몇 명"+pwList.size());
			}
		} catch (UnknownHostException e) {
			log("error ! " + e);
//			e.printStackTrace();
		} catch (IOException e) {
			log("error ! " + e);
//			e.printStackTrace();
		} finally {
// 		5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				log("error: ! " + ex);
			}
		}
	}
	/*============================== log ==================================*/
	public static void log(String log) {
		System.out.println("[Server : " + log + "]");
	}
}
