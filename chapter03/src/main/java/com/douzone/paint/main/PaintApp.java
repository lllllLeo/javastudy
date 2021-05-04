package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PaintApp {
	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
//		point1.setX(10);
//		point1.setY(20);
		point1.show();
		
		Point point2 = new Point(100, 200);
//		Point point2 = new Point();
		point2.show();
		
		point2.show(false);
		
		Point point3 = new ColorPoint(10, 20, "red");
//		point3.setX(50);
//		point3.setY(100);
//		((ColorPoint)point3).setColor("red"); // 다운캐스팅
		point3.show(true); // 색깔이 나옴 true면 Point의 show()를 쓰는데 오버라이딩한 ColorPoint의 show()가 불림
		draw(point3);
		
		Rect rect = new Rect();
//		drawRect(rect);
//		이것도 원래 업캐스팅
//		Shape p = rect;  drawShape() 파라미터가 Shape라서
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTrigngle(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("그래픽텍스트"));
		
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		
//		오류 : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rect);
//		interface는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다.
		
		
	}
	
	public static void draw(Drawable drawable) { // ColorPoint도 들어가고 Point도 들어감
		drawable.draw();
	}
//	public static void drawPoint(Point pt) { // ColorPoint도 들어가고 Point도 들어감
//		pt.show();
//	}
//	public static void drawColorPoint(ColorPoint pt) {
//		pt.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	
//	public static void drawTrigngle(Triangle triangle) {
//		triangle.draw();
//	}
		
}
