package prob2;

public class PhoneApp {

	public static void main(String[] args) {
		Phone phone = new SmartPhone();

		phone.execute("음악");	// 다운로드해서 음악재생
		phone.execute("통화");	// 통화가능 시작
		phone.execute("앱");	// 앱실행
	}
}



/*
 * 실행결과
 * 
 * 다운로드해서 음악재생
 * 통화기능시작 
 * 앱실행
 
 */