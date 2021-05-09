package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

// receive안에 데이터옴. 굳이 쓰레그 만들어지않아도됨. 클라이언트가 연결이 되어있지 않는 구조니까. 가만히 있어도 다 됨. 근데 뭐 처리할 패킷 량이 많으면 Thread로 하면됨
public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPEchoServer.PORT;
	private static final int BUFFER_SIZE = UDPEchoServer.BUFFER_SIZE;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner sc = null;
		try {
//		1. Scanner 생성
			sc = new Scanner(System.in);
//		2. 소켓 생성
			socket = new DatagramSocket();
			while (true) {
	//		3. 키보드 입력받기
				System.out.println(">");
				String line = sc.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
//		4. 데이터 송신
				byte[] sendData = line.getBytes("utf-8");
				DatagramPacket sendPacket = 
						new DatagramPacket(
								sendData, 
								sendData.length, 
								new InetSocketAddress(SERVER_IP, SERVER_PORT));	
				// new InetSocketAddress(SERVER_IP, SERVER_PORT) 이렇게 해줘도 됨 서버에서는 receivepacket에서 받아왓지만
				socket.send(sendPacket);
//		5. 데이터 수신
 				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
 				socket.receive(receivePacket); // blocking
				 byte[] receiveData = receivePacket.getData();
				 int length = receivePacket.getLength();
				 String message = new String(receiveData, 0, length, "utf-8");
				 
//		6. 콘솔 출력
				System.out.println("<" + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sc != null) {
				sc.close();
			}
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}
}
