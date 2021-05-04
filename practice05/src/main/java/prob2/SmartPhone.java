package prob2;

public class SmartPhone extends MusicPhone {
	
	@Override
	public void execute(String function) {
		if (function.equals("음악") ) {
	        playMusic();
	        return; // ?
	    } else if (function.equals("통화")) {
	    	super.execute(function); 
	    } else {
	    	System.out.println("앱 실행");
	    }
	}

	private void playMusic(){
	    System.out.println("다운로드해서 음악재생");
	}
	
	
	
}
