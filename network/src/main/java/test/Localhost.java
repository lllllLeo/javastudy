package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostname); // DESKTOP-ECB71RJ
			System.out.println(hostAddress); // 10.0.75.1
			
			byte[] addresses = inetAddress.getAddress();  
			for (byte b : addresses) {
//				System.out.print(b);
				System.out.print(b & 0x000000ff); // 1, 2보수 MSB 
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
