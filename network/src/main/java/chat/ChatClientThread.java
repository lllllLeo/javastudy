package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread{
	private Socket socket;
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) **받은거만
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while (true) {
				String line = br.readLine();
				if(line == null) {
					log("closed by server");
					break;
				}
				System.out.println(line);
			}
		} catch (UnsupportedEncodingException e) {
			log("UnsupportedEncodingException error ! " + e);
//			e.printStackTrace();
		} catch (IOException e) {
			log("IOException error ! " + e);
//			e.printStackTrace();
		} finally {
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}	
			} catch( IOException ex ) {
				log( "error ! " + ex );
			}
		}
	}
	/*============================== log ==================================*/
	private static void log(String log) {
		System.out.println("[ClientThread : " + log + "]");
	}
}
