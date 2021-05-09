	package udp;
	
	import java.io.IOException;
	import java.net.DatagramPacket;
	import java.net.DatagramSocket;
	import java.net.SocketException;
	
	public class UDPEchoServer {
		public static final int PORT = 7000;
		public static final int BUFFER_SIZE = 1024;
		
		public static void main(String[] args) {
			DatagramSocket socket = null;
			
	//		1. 소켓 생성
			try {
				 socket = new DatagramSocket(PORT);
				 
				 while (true) {
		//			 2. 데이터 수신
	//				 데이터를 받기 위한 DatagramPacket() 생성자
	//				 BUFFER_SIZE만큼의 byte배열을 만들고, BUFFER_SIZE로 다시 길이(length)를 받는다
	//				 다시 다른 생성자로 setData(buf, offset, length)하기 위해서 여기로 넘김
	//				 그러면 버퍼에
					 DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
					 
					 
	//				 System.out.println("receive  "+receivePacket.getData()); // 객체 값
	//				 System.out.println("receive  "+receivePacket.getLength()); // 1024
	//				 System.out.println("receive  "+receivePacket.getPort());  // 0
	//				 System.out.println("receive  "+receivePacket.getAddress()); // null
					 System.out.println("블로킹 대기중");
					 socket.receive(receivePacket); // blocking
    //				 System.out.println("receive2  "+receivePacket.getData()); // 객체 값 (바이트 배열로 반환)
	//				 System.out.println("receive2  "+receivePacket.getLength()); // 내가 입력한 값 길이
	//				 System.out.println("receive2  "+receivePacket.getPort()); // 7000
	//				 System.out.println("receive2  "+receivePacket.getAddress()); // /127.0.0.1
					 byte[] receiveData = receivePacket.getData(); // 객체 값이지만 아래를 위해 생성
					 int length = receivePacket.getLength();   // TODO 왜 바이트배열 -> 스트링 -> 바이트배열인지
					 String message = new String(receiveData, 0, length, "utf-8"); // String으로 변환 후 전송
					 System.out.println("[server] receive : " + message);
					 
	//				 3. 데이터 송신
					 byte[] sendData = message.getBytes("utf-8");
	//				 데이터를 보내기 위한 DatagramPacket() 생성자
//					 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), PORT);
					 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
//					 System.out.println("gdgd1" + receivePacket.getAddress()); // 127.0.0.1
//					 System.out.println("gdgd2" + receivePacket.getPort()); // 바뀜
					 socket.send(sendPacket);
				 }
				 
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(socket == null && socket.isClosed() == false) {
					socket.close();
				}
			}
		}
	}
