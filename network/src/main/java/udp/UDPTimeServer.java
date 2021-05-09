package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	
//	서버는 서버 시간을 클라이언트에게 제공해 준다
	
	public static final int BUFFER_SIZE = 1024;
	public static final int PORT = 7777;
		public static void main(String[] args) {
			DatagramSocket socket = null;
			try {
			// 1. 소켓 연결
				socket = new DatagramSocket(PORT); // 아 PORT를 받아야하네
				System.out.println("시간이 궁금하면 공백 입력 ㄱㄱ");
				while (true) {
					// 2. 데이터 수신
					DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
					socket.receive(receivePacket); // blocking
					byte[] receiveData = receivePacket.getData();
					int dataLength = receivePacket.getLength();
					String data = new String(receiveData, 0, dataLength, "utf-8"); // data의 길이만큼만 읽으면 됨. 근데 ""보내는데 버퍼크기는 1024만큼이니까 trim으로함
					if("".equals(data.trim())) {
		//			 3. 데이터 송신
						String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
						byte[] sendData = now.getBytes("utf-8");
						DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
						socket.send(sendPacket);
						System.out.println("Client로 현재시간 "+now+" 을 보냄");
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (socket == null && socket.isClosed() == false) {
					socket.close();
				}
			}
			 
			 
		}
		private static void log(String log) {
			System.out.println("[Server : " +log+ "]");
			
		}

}
