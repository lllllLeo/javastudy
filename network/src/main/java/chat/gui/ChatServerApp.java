package chat.gui;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerApp {
	public static final int PORT = 8888;
	
	public static void main(String[] args) {
//		1. 소켓 생성
		ServerSocket serverSocket = null;
		List<Writer> pwList = new ArrayList();
//		2.연결 (바인딩)
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
//		3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerAppThread(socket, pwList).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
