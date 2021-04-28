package paint;

public class paintApp {
	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		
		point1.show();
		
//		Point point2 = new Point(100, 200);
		Point point2 = new Point();
		point2.show();
		
		point2.show(false);
		
		Point point3 = new ColorPoint();
		point3.setX(50);
		point3.setY(100);
		((ColorPoint)point3).setColor("red"); // 다운캐스팅
		point3.show(true); // 색깔이 나옴 true면 Point의 show()를 쓰는데 오버라이딩한 ColorPoint의 show()가 불림
		
	}
}
