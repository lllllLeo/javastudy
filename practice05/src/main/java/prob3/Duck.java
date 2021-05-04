package prob3;

public class Duck extends Bird {

	@Override
	protected void fly() {
		System.out.println("오리(꽥꽥)는 못날아");
		
	}

	@Override
	protected void sing() {
		System.out.println("오리(꽥꽥)가 소리내어 웁니다.");
		
	}

	@Override
	public String toString() {
		return "오리의 이름은" + name + "입니다";
	}
	
	

}
