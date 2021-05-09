package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = ChatServerApp.PORT;
	
	public static void main(String[] args) {
		String nickName = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				nickName = sc.nextLine();
				if (nickName.isEmpty() == false) { break; }
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}

			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

			pw.println("join:" + nickName);
			pw.flush();
			
			String line = br.readLine();
			if("join:ok".equals(line)) { 
				new ChatWindow(nickName, socket).show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		
	}


}
