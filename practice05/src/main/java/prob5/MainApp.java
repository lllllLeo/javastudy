package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			
			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());  // 여기서 인덱스바운즈오브 익셉션 익셉션 일어남
			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

//	.
//	Java
//	!!!
//	World
//	Hello
//	==================================
//	Hello
//	Prob5.MyStackException: stack is empty

}
