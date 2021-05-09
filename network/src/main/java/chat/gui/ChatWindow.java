package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private String nickName;

//	소켓
	public ChatWindow(String nickName, Socket socket) {
		frame = new Frame(nickName);
		pannel = new Panel();
		buttonSend = new Button("전송");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		this.nickName = nickName;
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		/*
		 * 2. IO 스트림 생성
		 */
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * 3. chat client thread 생성(receive thread)
		 */
		updateTextArea("환영합니다. 즐거운 채팅하세요.");
		new ChatClientThread().start();
	}
	
	private void finish() {
		pw.println("quit:");
		pw.flush();
		System.exit(0);
		try {
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage() {
		String message = textField.getText();
		if("quit".equals(message)) {
			finish();
			return;
		}
		pw.println("message:" + message);
		pw.flush();
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextArea(String message) {
		if (message.contains(nickName)) { 
			textArea.append("(나) ");
		} 
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				while(true) {
					String line = br.readLine();
					updateTextArea(line);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
