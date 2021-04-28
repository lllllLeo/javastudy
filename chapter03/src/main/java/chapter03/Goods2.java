package chapter03;

public class Goods2 {
	private String name;
	private int price;
	private int countSold;
	private int countStock;
	
	
	public Goods2() {	}
	
	public Goods2(String name, int price, int countSold, int countStock) {
		super();
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public void showInfo() {
		System.out.println(
				"name: " + name +
				"price: " + price +
				"countStock: " + countStock +
				"countSold: " + countSold);
	}
	public int calcDiscountPrice(double rate) {
		return (int) (price * rate); // int랑 double만나면 double됨. rate가 double이라서 .~값이 손실될 수있음. 반대의 경우에는 에너안뜨고 바로 됨.
	}
	
	
}
