package abstraction06;
/*
 *  .java파일에 여러개의 class를 정의할때는 
 *  main메소드가 있는 클래스에 public을 붙여라
 *  그 외 클래스는 public생략
 *  원칙은 .java파일당 내가 정의한 클래스 하나 선언
 */
//학생을 추상화하자]
class Student{
	//[멤버변수]
	Person person;
	Person another= new Person();//선언과 동시에 메모리 할당.
	String stNumber;////학번 속성
	//[멤버 메소드]
	void study() {
		System.out.println(person.name+"가(이) 공부하다");
	}
	//프로그램 효율성을 위한 멤버메소드]
	void printStudent() {
		person.printPerson();
		System.out.println("학번:"+stNumber);
	}
}
public class StudentApp {

	public static void main(String[] args) {
		//Student타입의 메모리 생성]
		//Student타입 객체화
		//Student타입 인스턴스화
		Student student1 = new Student();
		System.out.println("student1:"+student1);
		//student1.person이 null임으로 즉 Person타입의
		//메모리를 가리키고 있지 않음으로(참조하지 않음으로)
		//NullPointerExceptiond예외 발생
		//student1.printStudent();//실행시 에러
		System.out.println("student1.person:"+student1.person);
		/*
		//해결방법1]Person타입의 메모리 생성해서 주소 대입
		student1.person = new Person();
		System.out.println("student1.person(주소 저장후):"+student1.person);
		student1.printStudent();
		//초기화
		student1.person.name="가길동";
		student1.person.age=20;
		student1.person.weight=99;
		System.out.println("[Person초기화 후]");
		student1.printStudent();*/
		//해결방법2]another의 주소값을 person에 대입
		student1.person = student1.another;
		System.out.println("student1.person:"+student1.person);
		System.out.println("student1.another:"+student1.another);
		//초기화
		student1.person.name="다길동";
		student1.another.age=100;
		student1.person.weight=50;
		student1.stNumber="2021학번";		
		student1.printStudent();
	}/////////////main

}///////////////class
