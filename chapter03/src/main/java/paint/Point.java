package paint;

public class Point {
	int x;
	int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		System.out.println("점 ["+x+","+y+"]에 점을 그렸다.");
		
	}
	public void show(boolean invisible) {
		if(invisible) {
			show();
		} else {
			
		}
	}
}
