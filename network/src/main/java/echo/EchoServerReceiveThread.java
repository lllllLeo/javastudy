package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // 포트번호, ip주소

		String remoteHostAddress  = inetRemoteSocketAddress.getAddress().getHostAddress(); // IP Address가 나옴
		int remoteHostPort = inetRemoteSocketAddress.getPort();

		//		연결되면 
		EchoServer.log("connected by client["+remoteHostAddress+" : "+ remoteHostPort+"]" );


		try {
			//		이 소켓이랑 위에 소켓이랑 catch에 IOException으로 같이 걸리니까 분리하기
			//			4. IO Stream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 버퍼가 다 차지 않더라도 출력시킴

			while (true) {
				//				5. 데이터 읽기
				String data = br.readLine();
				if(data == null) {
					EchoServer.log("closed by client");
					break;
				}
				EchoServer.log("received:" + data);
				//				6. 데이터 쓰기
				//				pw.print(data + "\n"); // 개행을 안쓰면 서버에서 못끊어냄
				pw.println(data); // 개행을 안쓰면 서버에서 못끊어냄
			}
		} catch (SocketException e) { // 서버측에서 끊어버릴때?
			EchoServer.log("sudden closed by client"); 
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
	} 
}
