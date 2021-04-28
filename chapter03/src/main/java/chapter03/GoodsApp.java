package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods1 = new Goods();
		goods1.name = "camera";
		goods1.price = 1000;
		goods1.countStock = 50;
		
//		goods1.countSold = 20;
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
	}
}
