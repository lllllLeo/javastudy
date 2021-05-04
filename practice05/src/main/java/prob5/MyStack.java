package prob5;

public class MyStack {
	private String[] data;
	private int top = -1;
	
	public MyStack(int size) {
		data = new String[size];
	}

	public void push(String data) {
		top++;
		if(this.data.length == top) {
			resize(); // data를 새로운 배열만들고 기존꺼를 카피하고 다시 넣음 (보통 2배정도 만듦)
		}
		this.data[top] = data;
		System.out.println("stack값 " + data + " " +this.data.length);
		System.out.println("top은 " +top);
	}

	private void resize() {
		System.out.println("resize called " + top);
		String[] temp = new String[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public String pop() throws MyStackException {
		System.out.println(top);
		System.out.println("pop called");
		System.out.println(data[top]);
		String popValue = data[top];
		--top;
		return popValue;
			
	}
	
// top의 위치?
	public boolean isEmpty() {
		System.out.println("isEmpty called");
		System.out.println(data.length);
		if(data.length >= 0) {
			return true;
		}
		
		return false;
		/*
		 * if (top == 0) { return true; } return false;
		 */
	}
}