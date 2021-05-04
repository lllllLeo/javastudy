package chapter03;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("김커피");
		s1.setGrade(4);
		s1.setMajor("CS");
		
		
		Person p1 = s1; // 업캐스팅. Student꺼를 못 씀. 많은 곳에서 적은 곳으로 갈 때는 암시적으로 됨.
		
		Student s2 = (Student) p1; // 다운 캐스팅. p1이 큰놈으로 올라갈 때(부모클래스에서 자식클래스로 캐스팅할때)
	}
}
