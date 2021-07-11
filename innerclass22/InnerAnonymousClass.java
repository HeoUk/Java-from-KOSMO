package innerclass22;

/*
 * 익명 클래스]
 * -이름이 없는 클래스
 * -GUI프로그래밍 시 주로 사용(이벤트 처리하기 위해서)
 * -부모 클래스의 메소드를 오버라이딩하는 것이 주된 용도
 * -메소드 안에 정의된 클래스  
 *  형식]
 *  부모클래스명 인스턴스변수 = new 부모클래스명(){
 *  
 *  };//반드시 ;을 붙여라
 * 
 */
class Person{
	String name;
	//인자 생성자]
	public Person(String name) {		
		this.name = name;
	}
	@Override
	public String toString() {		
		return "이름:"+name;
	}
}////////////////////////////
class Student extends Person{
	String stNumber;//자식에서 새롭게 확장한 멤버변수]
	//인자 생성자]
	public Student(String name,String stNumber) {
		super(name);		
		this.stNumber=stNumber;
	}/////////
	//자식에서 새롭게 확장한 멤버 메소드]	
	String get() {
		return String.format("%s,학번:%s",super.toString(),stNumber);
	}
	@Override
	public String toString() {		
		return get();
	}
}//////////////////
//[추상 클래스]
abstract class AbstractClass{
	abstract void abstractMethod();
}//////////////
//[인터 페이스]
interface Inter{
	void abstractMethod();
}/////////////////
public class InnerAnonymousClass {
	
	public static void main(String[] args) {
		//[이름이 있는 자식클래스의 일반적인 이질화 형태]
		Person person = new Student("홍길동", "2021학번");
		System.out.println(person);
		//[자식에서 새롭게 확장한 멤버 접근]-형변환(다운캐스팅)
		Student student=(Student)person;
		System.out.println(student.stNumber);
		System.out.println(student.get());
		
		Person anonyPerson = new Person("가길동") {//익명클래스 시작
			//[멤버변수]
			int newVar;//익명클래스에서 새롭게 확장한 멤버
			//[멤버 메소드]
			void newMethod() {
				System.out.println("익명 클래스에서 새롭게 확장한 메소드");
			}
			@Override
			public String toString() {				
				return super.toString()+",newVar:"+newVar;
			}			
		};//익명클래스 끝
		System.out.println(anonyPerson);
		/*[자식에서 새롭게 정의한 멤버 접근]
		다운캐스팅:(자식클래스명)부모타입인스턴스변수
		클래스명이 없음으로 다운캐스팅 불가
		고로 자식에서 새롭게 정의한 멤버 접근 불가
		※고로 익명클래스는 오버라이딩이 목적*/
		Student anonyStudent = new Student("박길동","2021학번") {
			int age=1;//멤버 변수(새롭게 추가한 멤버)

			@Override
			String get() {				
				return super.get()+",익명 클래스의 새로운 멤버변수:"+age;
			}
			@Override
			public String toString() {				
				return get();
			}			
		};
		System.out.println(anonyStudent);
		//추상 클래스를 상속받은 익명 클래스]
		AbstractClass ac = new AbstractClass() {

			@Override
			void abstractMethod() {
				System.out.println("추상 메소드 오버라이딩");				
			}			
		};
		ac.abstractMethod();
		//인터페이스를 상속받은 익명 클래스]
		Inter inter = new Inter() {

			@Override
			public void abstractMethod() {
				System.out.println("추상 메소드 오버라이딩:인터페이스");					
			}			
		};
		inter.abstractMethod();
	}/////////////main

}///////////////class
