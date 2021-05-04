package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer2 printer = new Printer2();

		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
		printer.println( "=============================" );
		
		printer.println( 10, true, 5.7, "홍길동" );
		
	}
}