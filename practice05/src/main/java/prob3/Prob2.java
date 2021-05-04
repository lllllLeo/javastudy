package prob3;

public class Prob2 {
	public static void main(String[] args) {
		Bird bird01 = new Duck();
		bird01.setName( "꽥꽥이" );
		bird01.fly();
		bird01.sing();
		System.out.println( bird01 );
		
		Bird bird02 = new Sparrow();
		bird02.setName( "짹짹이" );
		bird02.fly();
		bird02.sing();
		System.out.println( bird02 );
	}
}


//오리(꽥꽥이)는 날지 않습니다.
//오리(꽥꽥이)가  소리내어 웁니다.
//오리의 이름은 꽥꽥이 입니다.
//참새(짹짹)가 날아다닙니다.
//참새(짹짹)가  소리내어 웁니다.
//참새의 이름은 짹짹 입니다.
