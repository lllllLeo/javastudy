package chapter03;

public class Goods {
	static public int countOfGoods;
	
	public Goods() {
		Goods.countOfGoods++;
	}
	
	public String name;	// 모든 접근 가능(접근 제한 없음)
	protected int price;	// 같은 패키지 + 자식 클래스에서 접근 가능
	int countStock;	// 같은 패키지에서 접근 가능
	private int countSold;	// 같은클래스/내부에서만 접근 가능
}
