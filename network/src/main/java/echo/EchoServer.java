package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 7000;
	
	public static void main(String[] args) {
	
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
//			2. 주소 바인딩
//				Socket에 InetSocketAddress(IPAddress + Port)
//			IPAddress : 내 address X. 상대측의 address / 0.0.0.0 은 모든 address받고자 할 때
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts...[port:" + PORT + "]");
			while(true) {
//			3. accept
//			클라이언트의 연결 요청을 기다린다.
				Socket socket = serverSocket.accept();
				
				Thread thread = new EchoServerReceiveThread(socket);
				thread.start();
			}
//			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // 포트번호, ip주소
//			
//			String remoteHostAddress  = inetRemoteSocketAddress.getAddress().getHostAddress(); // IP Address가 나옴
//			int remoteHostPort = inetRemoteSocketAddress.getPort();
//			
////			연결되면 
//			log("connected by client["+remoteHostAddress+" : "+ remoteHostPort+"]" );
//			
//			
//			try {
////			이 소켓이랑 위에 소켓이랑 catch에 IOException으로 같이 걸리니까 분리하기
////				4. IO Stream 받아오기
//				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 버퍼가 다 차지 않더라도 출력시킴
//				
//				while (true) {
////					5. 데이터 읽기
//					String data = br.readLine();
//					if(data == null) {
//						log("closed by client");
//						break;
//					}
//					log("received:" + data);
////					6. 데이터 쓰기
////					pw.print(data + "\n"); // 개행을 안쓰면 서버에서 못끊어냄
//					pw.println(data); // 개행을 안쓰면 서버에서 못끊어냄
//				}
//			} catch (SocketException e) { // 서버측에서 끊어버릴때?
//				log("sudden closed by client"); 
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (socket != null & socket.isClosed() == false) {
//						socket.close();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static void log (String log) {
		System.out.println("[EchoServer]" + log);
	};
}