package polymorphism14;

import java.util.Date;

/*
 *오버라이딩(Overriding)-재정의
	상속시에 적용되는개념 즉 부모로부터 상속 받은 메소드를 
	재정의해서 사용하는 것
	    - 메소드명이 동일해야 한다.
	    - 메소드의 매개변수 갯수, 데이터타입 및 순서가 모두  같아야 한다.
	    - 메소드의 반환타입도 같아야 한다.
	    - 부모 메서드의 접근 지정자가 
	       public이거나 protected인 경우에만 오버라이딩이 된다.

	    - 부모 메서드가 default 지정자나 private지정자를 
	       가진 메서드를 오버라이딩 한경우
	       자식 고유의 메서드로 처리된다(오버라이딩 한 것이 아님)	
	       //단,default접근 지정자는 다른 패키지에서는
	      //접근이 안됨으로 부모와 자식이 다른 패키지일 경우에만
	       //오버라이딩 한것이 아님.
	      //같은 패키지일 경우는 오버라이딩에 해당

	    - Exception의 경우 부모 클래스의 메소드와 동일하거나 
	           더 구체적인 Exception을
	           발생시켜야 한다.
 
 */
public class Parent {
	//[멤버변수]
	String name;
	int age;
	//[생성자]
	//기본 생성자]
	public Parent() {}
	//인자 생성자]
	public Parent(String name, int age) {	
		this.name = name;
		this.age = age;
	}
	//[멤버메소드]
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep(int age) {
		System.out.println("부모님이 주무신다");
		return null;
	}/////////////
	protected int walk(Date date) {
		System.out.println("부모님이 산책하신다");
		return 0;
	}
	public void exercise() {
		System.out.println("부모님이 운동하신다");
	}
	 static void staticMethod() {
		 System.out.println("부모님의 정적 메소드");
	 }
	String getParent() {
		return String.format("성함:%s,연세:%s",name,age);
	}
	void printParent() {
		System.out.println(getParent());
	}
}////////////////////
