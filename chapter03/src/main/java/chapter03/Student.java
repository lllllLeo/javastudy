package chapter03;

public class Student extends Person {
	private int grade;
	private String major;
	
	
	public Student() {
//		자식의 모든 생성자에서 부모의 특정 생성자를 명시하지 않으면 암묵적으로 부모의 기본 생성자가 호출됨
		System.out.println("Student() called");
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
