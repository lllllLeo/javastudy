package tv;

public class WatchTV {
	public static void main(String[] args) {
		TV tv = new TV(7, 20, false);  	

        tv.status();	// 파워 false 채널7 볼륨 20

        tv.power(true);
        tv.volume(120);    
        tv.status();		// 파워 true 채널7 볼륨 120          

        tv.volume(false);	
        tv.status();		// 파워 true 채널7 볼륨 119

        tv.channel(0); 
        tv.status();		// 파워 true 채널0 볼륨 119	          

        tv.channel(true); // 채널 1
        tv.channel(true); // 채널 2
        tv.channel(true); // 채널 3
        tv.status();		// 파워 true 채널3 볼륨 119

        tv.power(false); 
        tv.status(); 		// 파워 false 채널3 볼륨 119
	}
}
