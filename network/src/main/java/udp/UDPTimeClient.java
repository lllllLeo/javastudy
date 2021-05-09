package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPTimeClient {

//	클라이언트는  서버에 서버 시간을 요청한다.
	private static final int SERVER_PORT = UDPTimeServer.PORT;
	private static final String SERVER_IP = "127.0.0.1";
	private static final int BUFFER_SIZE = UDPTimeServer.BUFFER_SIZE;
			
	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner sc = null;
		try {
			socket = new DatagramSocket();
			sc = new Scanner(System.in);
			while (true) {
				System.out.println(">");
				String line = sc.nextLine();
				
				if (!"".equals(line)) {
					System.out.println("공백이 아닐때");
					continue;
				} else if ("exit".equals(line)) {
					System.out.println("종료합니다");
					return;
				} 
//			데이터 송신
//					byte[] sendData = "".getBytes();
				byte[] sendData = line.getBytes("utf-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, new InetSocketAddress(SERVER_IP, SERVER_PORT));
				socket.send(sendPacket);
				
//			데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); // 블로킹
				
				byte[] receiveData = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(receiveData, 0, length, "utf-8");
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			if (socket == null && socket.isClosed() == false) {
				socket.close();
			}
			
		}
		
	}
}
	private static void log(String log) {
		System.out.println("[Client : " +log+ "]");
	}
}
