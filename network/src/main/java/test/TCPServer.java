package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
//			1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
//			1-1 Tile-Wait 상태에서도 소켓에 포트 번호
//				할당이 가능하게 하기 위해서..
			serverSocket.setReuseAddress(true);
//			2. 주소 바인딩
//				Socket에 InetSocketAddress(IPAddress + Port)
//			IPAddress : 내 address X. 상대측의 address / 0.0.0.0 은 모든 address받고자 할 때
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
			
//			3. accept
			/*
			 * 클라이언트가 서버로 연결 요청을 보내면 서버는 연결을 accept하고 클라이언트와 연결된 소켓을 새로 생성하는데
			 * 이 때 해당 메서드의 처리가 완료되기 전까지 스페드에 blocking이 발생함. 또, 클라이언트가 연결된 소켓을 통해
			 * 서버로 데이터를 전송하면 서버는 클라이언트가 전송한 데이터를 읽기 위해 read 메소드를 호출하고 이 메소드의 처리가
			 * 완료되기 전까지 스레드가 blocking 됨 
			 * */
//			클라이언트의 연결 요청을 기다린다.
			Socket socket = serverSocket.accept(); // blocking
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // 포트번호, ip주소
			String remoteHostAddress  = inetRemoteSocketAddress.getAddress().getHostAddress(); // IP Address가 나옴
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			
//			연결되면 
			System.out.println("[server] connected by client["+remoteHostAddress+" : "+ remoteHostPort+"]" );
			
			try {
//			이 소켓이랑 위에 소켓이랑 catch에 IOException으로 같이 걸리니까 분리하기
//				4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while (true) {
//					5. 데이터 읽기
					byte[] buffer = new byte[256];
					System.out.println("?"+buffer[0]);
					int readByteCount = is.read(buffer); // blocking // buffer[] 배열 크기 만큼 읽음 / os.write에서 자동적으로 buffer로 데이터가 들오는건가
					System.out.println("??"+buffer[0]);
					if(readByteCount == -1) { // 끊으면(\n) -1 나온다 ?
						// 클라이언트가 정상적으로 종료( close() )
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8"); // 바이트를 String으로 바꿈
					System.out.println("??"+buffer[0]);
					System.out.println("[server] received: "+ data);
					
//					6. 데이터 쓰기
					
					try {
						Thread.sleep(2000);
						os.write(data.getBytes("utf-8"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (SocketException e) { // 서버측에서 끊어버릴때?
			  System.out.println("[server] sudden closed by client"); 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null & socket.isClosed() == false) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
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
}
