package chapter03;

public class DiscountGoods extends Goods {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		// price가 protected임. Goods의 자식클래스이기 때문에 다른 패키지여도 접근이 됨.
		return price * discountRate;
	}
}
