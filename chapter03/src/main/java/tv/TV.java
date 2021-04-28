package tv;

public class TV {
	private int channel; // 1~255 로테이션 가능하게 255넘어가면 1
	private int volume;	// 0~100
	private boolean power;
	
	public TV() { }	
	
	
	public TV(int channel, int volume, boolean power) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
//	중복코드 ㄴㄴ
//	파워 on off여부 체크
	public void power(boolean on) {
		if(on) {
			power = true;
			System.out.println("파워 켜짐");
		} else {
			power = false;
			System.out.println("파워 꺼짐");
		}
	}
	public void channel(boolean up) {
		if(power) {
			if(up) {
				if(channel > 255) {
					channel = 1;
				}else {
					channel += 1;
				}
			} else {
				if(channel < 0) {
					channel = 255;
				} else {
					channel -= 1;
				}
			}
		} else {
			System.out.println("channel 변경실패 현재 파워 off");
		}
	}
	public void channel(int channel) {
		this.channel = channel;
	}
	public void volume(boolean up) {
		if(power) {
			if(up) {
				if(volume > 100) {
					volume = 1;
				} else {
					volume += 1;
				}
			} else {
				if(volume < 0) {
					volume = 100;
				} else {
					volume -= 1;
				}
			}
		} else {
			System.out.println("volume 조절실패 현재 파워 off");
		}
	}
	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void status() {
		System.out.println("TV\t[power= " + power + "\t\tchannel= " + channel + "\tvolume= " + volume);
	}
	
}
