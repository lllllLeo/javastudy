package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() ); // client의 ip, port번호
					
			String request = null;
			while(true) { // Accept이런데 보면 한 줄만읽으면 안되니까 true로 여러번 읽음
				String line = br.readLine();

				// 브라우저가 연결을 끊으면.				
				if (line == null) {
					break;
				}
				
//				Request Header만 읽음
				if("".equals(line)) {
					break;
				}
//				첫 번째 라인만 처리
				if(request == null) {
					request = line;
					break;
				}
			}
			
			
//			요청 처리
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				consoleLog("request: "+ tokens[1]);
				responseStaticResource(os, tokens[1], tokens[2]);				
			} else { // Method PUT, POST 등이 들어올 경우
				/* Simple Http Server 에서는 무시*/
				
//				response400Error(os, tokens[1], tokens[2]);
				

				
			}
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.    이미지도 보내야할 상황이 있기때문에 outputStream으로함  HTML은 Text, 이미지, 동영상은 binary기 때문. text일수도있고 이미지 일 수도 있으니까 한 번에 퉁치기위해 바이너리로 보냄. 내용이 중요한게 아니다
//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\r\n".getBytes() );	// 이때부터 내용시작한다~~
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
//			요청에 응답하고 socket 끊음(HTTP규약) keep-alive 그래서 session?.
		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}	
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void response400Error(OutputStream os, String string, String string2) {
//		응답 예시
//		HTTP/1.1 400 File Bad Request\r\n
//		Content-Type:text/html; charset=utf-8\r\n
//		\r\n
//		HTML 에러 문서 (./webapp/error/400.html) 이거를 읽어서 보내주게 
		
	}

	private void responseStaticResource(OutputStream os, String url, String protocol) throws IOException {

		// set welcom file 
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			// 404
			response404Error(os, url, protocol);
			return;
		}
		
//		nio
		byte[] body = Files.readAllBytes(file.toPath());	// body내용을 통째로 읽음
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + " 200 OK\r\n").getBytes( "UTF-8" ) );
		os.write(("Content-Type:"+ contentType +"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		os.write("\r\n".getBytes() );	// 이때부터 내용시작한다~~
		os.write(body);
//		index.html 읽으면서 내부에 있는 링크들 읽으면서 css나 img를 계속 읽어옴.
//		근데 css 파일은 MIME type을 제대로 지정안해주면 text/html로 인식하기 때문에 제대로 명시해줘야함
	}

//	파일이 없는 경우
	private void response404Error(OutputStream os, String url, String protocol) throws IOException {
//		응답 예시
		url = "./error/404.html";
		
		os.write((protocol + " 404 File Not Fount\r\n").getBytes("UTF-8"));
//		HTTP/1.1 404 File Not Found\r\n
//		Content-Type:text/html; charset=utf-8\r\n
//		\r\n
//				HTML 에러 문서 (./webapp/error/404.html) 이거를 읽어서 보내주게 
//		<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
//		body
		
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );	// Thread상속받아있기때문에 getId()해도 Thread에 있는 메소드
	}
}
