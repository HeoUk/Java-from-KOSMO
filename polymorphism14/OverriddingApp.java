package polymorphism14;

import java.util.Date;

public class OverriddingApp {

	public static void main(String[] args) {
		/* 인스턴스 변수:Child타입(자식)
		 * 메모리 : Child타입(자식)
		 */
		Child child = new Child("가길동",20,"Child Member Var1");
		System.out.println("[자식타입의 인스턴스 변수 - 오버라이딩한 메소드 호출]");
		child.sleep(10);
		child.exercise();
		child.printParent();
		System.out.println(child.getParent());
		System.out.println("[자식타입의 인스턴스 변수 - 자식에서 새롭게 확장한 메소드 호출]");
		child.newExtendMethod();
		child.walk(10);
		//child.walk(new Date());
		/* 인스턴스 변수:Parent타입(부모)
		 * 메모리 : Child타입(자식)
		 * 
		 */
		/*
		 * ※ 인스턴스 변수가 부모타입든 자식타입든
		 *   무조건 오버라이딩한 메소드가 호출된다.
		 *   단, 오버라이딩을 하지 않았다면 당연히
		 *   상속받은 부모의 메소드가 호출된다.
		 *   
		 * ※만약 오버라이딩한 메소드호출시 
		 *   부모의 메소드를 사용하고자 한다면
		 *   super키워드로 접근해서 재정의 하면된다.
		 *   
		 */
		Parent parent = new Child("나길동",30,"Child Member Var2");
		System.out.println("[부모타입의 인스턴스 변수 - 오버라이딩한 메소드 호출]");
		parent.sleep(10);
		parent.exercise();
		parent.printParent();
		System.out.println(parent.getParent());
		System.out.println("[부모타입의 인스턴스 변수 - 자식에서 새롭게 확장한 메소드 호출]");
		//parent.newExtendMethod();//[x]undefined 컴파일 오류
		//parent.walk(10);//[x]
		//parent.walk(null)//[o]
		//※부모타입의 인스턴스 변수로 자식에서 새롭게 확장한
		//  멤버(변수,메소드등)에 접근하려면 형변환 해야 한다.
		//if(parent instanceof Child) {			
			((Child)parent).newExtendMethod();			
			Child ch = (Child)parent;
			ch.walk(10);
		//}
	}/////////main

}/////////////class
