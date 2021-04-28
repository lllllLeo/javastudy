package prob02;

import java.util.Iterator;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("상품을 3개 입력하세요");
		
		Goods[] goods = new Goods[COUNT_GOODS];
		for (int i = 0; i < COUNT_GOODS; i++) {
			System.out.println((i+1)+"번째 상품 입력");
			goods[i] = new Goods();
			goods[i].setName(scanner.next());
			goods[i].setPrice(scanner.nextInt());
			goods[i].setCount(scanner.nextInt());
		}

		for (int i = 0; i < goods.length; i++) {
			System.out.println(goods[i].getName() + "(가격:" + goods[i].getPrice()+"원)이 "+goods[i].getCount()+"개 입고 되었습니다.");
		}
		scanner.close();
	}
}
