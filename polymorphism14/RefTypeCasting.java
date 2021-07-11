package polymorphism14;
/*
참조형 사이의 형변환(Type Casting)

 - 두 클래간의 상속관계가 존재할때 형변환이 가능하다.
 - 형변환시 타입캐스팅 연산자(자료형)를 사용
 - 부모클래스 -> 자식클래스의 인스턴스에 저장(Down Casting)
 - 자식클래스 -> 부모클래스의 인스턴스 저장(Up Casting) 
 	
[업 캐스팅] 	
	부모의 인스턴스 변수 = 자식의 인스턴스 변수;//[O]
	묵시적 형변환 
	즉 캐스팅 연산자를 사용할 필요가 없다.
	
[다운 캐스팅]

	자식타입의 인스턴스 변수= (자식타입)부모의 인스턴스변수
	강제적 형변환 즉 캐스팅 연산자 사용
	※
 	만약에 부모의 인스턴스변수에 
 	자식의 인스턴스 변수가
 	저장되어 있지 않다면 
 	다운캐스팅 하더라도 실행시 에러
 	
 	다운캐스팅 조건: 반드시 부모의 인스턴스 변수에 자식의
 	                        인스턴스 변수가 저장되어 있어야 한다
 	                 
 			  
*/
class Base{
	void base() {
		System.out.println("Base의 메소드:base()");
	}
}///////////Base
class Noderived{}
class Derived  extends Base{
	void derived() {
		System.out.println("Derived의 메소드:derived()");
	}
	@Override
	void base() {
		System.out.println("Derived에서 오버라이딩한 메소드:base()");
	}
	
}///////////Derived

public class RefTypeCasting {

	public static void main(String[] args) {
		Base base = new Base();
		base.base();
		Derived derived = new Derived();
		derived.base();//오버라이딩한 메소드
		/*상속관계가 존재 하지 않을때 -주소 대입 연산 및 형변환 불가*/
		Noderived noderived = new Noderived();
		//대입연산:X
		//noderived = base;//[x]
		//base = noderived;//[x]
		//형변환:X
		//noderived = (Noderived)base;//[x]
		//base = (Base)noderived;//[x]
		/*두 클래스간 상속관계가 존재시-주소 대입 연산 및 형변환 가능 */
		System.out.println("[base인스턴스 변수에 derived인스턴스 변수 대입전]");
		System.out.println("base가 참조하는 클래스명:"+base.getClass().getName());
		System.out.println(base instanceof Derived);
		
		//Derived de = (Derived)base;//실행시 오류
		base = derived;////[o]업캐스팅.암묵적 형변환
		
		System.out.println("[base인스턴스 변수에 derived인스턴스 변수 대입후]");
		System.out.println("base가 참조하는 클래스명:"+base.getClass().getName());
		System.out.println(base instanceof Derived);
		base.base();//오버라이딩한 메소드
		//단,자식에서 새롭게 정의 한 멤버(변수/메소드등)는
		//부모 타입의 
		//인스턴스 변수로는 접근불가(해결방안:형변한-다운캐스팅)
		//base.derived();//[x] undefined
		//[강제적 형변환(다운 캐스팅)]
		//방법1]자식타입의 변수에 담지 않고 바로 .으로 접근
		((Derived)base).derived();
		//방법2]자식타입의 변수에 담은후 그 변수로 접근
		Derived dev = (Derived)base;
		dev.derived();
	}/////////main

}////////////class
