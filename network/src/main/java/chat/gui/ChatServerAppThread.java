package chat.gui;

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

public class ChatServerAppThread extends Thread{
	private Socket socket;
	private List<Writer> pwList;
	private String nickName;
	
	public ChatServerAppThread(Socket socket, List<Writer> pwList) {
		this.socket = socket;
		this.pwList = pwList;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
//		1. 호스트 정보 얻기/연결
//		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		try {
//		2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
//		3. 요청 처리
			while(true) {
				String line = br.readLine();
				if(line == null) {
					doQuit(pw);
					break;
				}
	//		4. 프로토콜 분석
				String[] tokens = line.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} else if ("message".equals(tokens[0])) {
					if (line.length() > tokens[0].length() + 1) {
						doMessage(tokens[1]);
					}
				} else {
					System.out.println("알 수 없는 에러");
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doMessage(String message) { broadcast(nickName + " : " + message); }
	private void doJoin(String nickName, PrintWriter pw) {
		this.nickName = nickName;
		String message = "======= " + nickName + "님이 입장했습니다. =======";
		broadcast(message);
		addWriter(pw);
		pw.println("join:ok\r\n"); // ack
		pw.flush();
	}
	private void doQuit(PrintWriter pw) {
		removeWriter(pw);
		String message = "======= " + nickName + "님이 퇴장했습니다. =======";
		broadcast(message);
	}

	private void addWriter(PrintWriter pw) { synchronized (pwList) { pwList.add(pw); } 	}
	private void removeWriter(PrintWriter pw) { synchronized (pwList) { pwList.remove(pw); } }
	private void broadcast(String message) {
		synchronized (pwList) {
			for (Writer writer : pwList) {
				PrintWriter pw = (PrintWriter) writer;
				pw.println(message);
				pw.flush();
			}
		}
	}
}
