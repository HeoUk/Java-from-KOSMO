package innerclass22;

import innerclass22.OuterClass.InnerClass;

/*
[내부 멤버 클래스]:클래스안의 클래스로 static이 안붙음
- 외부클래스의 모든 멤버(정적이든 인스턴스형이든)
    를 사용할 수있다.
- 정적멤버는 가질 수 없다.
- 외부클래스명$내부클래스명.class로 파일이 생긴다.
- 이벤트 기반 프로그래밍( GUI프로그래밍):
    윈도우 프로그래밍,웹프로그래밍,모바일 프로그래밍등
   시 주로 사용
*/
/* ※외부클래스에서 내부클래스의 멤버 접근에 관한 이론
 * 
 * -외부클래스에서는 내부 클래스의 멤버 접근 불가	 
   -외부 클래스에서 내부 클래스의 멤버에 접근하려면
       내부 클래스를 인스턴스화 한 후에 접근할 수 있다 
 *  단,외부의 정적 메소드에서는 내부의 모든 멤버 사용불가
 *  그러나 내부 클래스의 정적 상수는 내부 클래스명으로
        접근가능.
 */
class OuterClass{
	//[멤버 변수]
	//인스턴스형 멤버 변수]
	int outerInstanceVar;
	int sameVar=100;
	//정적 멤버 변수]
	static int outerStaticVar;
	
	//내부 클래스 인스턴스화 하기]
	//방법1]내부 클래스 타입의 멤버변수 선언과 동시에 인스턴스화
	//InnerClass inner = new InnerClass();
	//방법2]
    //1]내부 클래스 타입의 멤버변수 선언
	InnerClass inner;
	//2]외부 클래스의 생성자에서 인스턴스화
	public OuterClass() {
		inner = new InnerClass();
		System.out.println("외부 클래스의 생성자");
	}
	
	//[멤버 메소드]
	//인스턴스형 멤버 메소드]
	void outerInstanceMethod() {
		//내부 클래스 인스턴스화 전]
		//System.out.println(innerInstanceVar);//[x]
		//innerInstanceMethod();//[x]
		System.out.println(InnerClass.INNER_MAX_INT);//[o]
		//내부 클래스 인스턴스화 후]
		System.out.println(inner.innerInstanceVar);//[o]
		//inner.innerInstanceMethod();//[o]recursive발생-주석처리
	}
	//정적 멤버 메소드]
	static void outerStaticMethod() {
		//System.out.println(inner.innerInstanceVar);//[x]
		System.out.println(InnerClass.INNER_MAX_INT);//[o]
	}
	//[내부 멤버 클래스]
	class InnerClass{
		//[멤버 변수]
		//인스턴스형 멤버]
		int innerInstanceVar;
		int sameVar=1;
		public InnerClass() {
			System.out.println("내부 클래스의 생성자");
		}////
		void innerInstanceMethod() {
			//※내부 클래스에서는 외부의 모든 멤버 사용 가능
			System.out.println(outerInstanceVar);
			System.out.println(outerStaticVar);
			outerInstanceMethod();
			outerStaticMethod();
			//※외부의 멤버 와 내부 멤버 충돌할때
			//내부 클래스안에서 this는 내부 클래스 지칭
			//내부 클래스안에서 외부클래스명.this는 외부 클래스를 지칭
			
			//내부 멤버변수 = 내부 멤버변수	
			this.sameVar =sameVar;
			//※외부 멤버변수 = 내부 멤버변수
			OuterClass.this.sameVar = sameVar;
		}///////////////
		//정적 멤버]
		//※정적 멤버(상수 제외)는 가질 수 없다.
		//  단,static이 붙은 상수는 가질 수 있다.
		//static int innerStaticVar;//[x]
		//static void innserStaticMethod() {}//[x]
		static final int INNER_MAX_INT = Integer.MAX_VALUE;//[O]
	}////////////////InnerClass
}
public  class InnerMemberClass {

	public static void main(String[] args) {
		//내부 클래스의 상수 접근:외부 클래스가 아니라 별개의 클래스에서...
		System.out.println(InnerClass.INNER_MAX_INT);
		//외부 클래스가 아닌 별개의 다른 클래스에서는 내부 멤버 클래스가
		//안보인다 즉 직접 인스턴스화 불가]
		//InnerClass inner = new InnerClass();//[X]
		
		//1]외부클래스는 무조건 먼저 인스턴스화
		OuterClass outer = new OuterClass();
		/*
		 * 외부 클래스가 아닌 다른 클래스에서 
		 * 내부클래스에
		 * 접근하려면 외부클래스 생성후 접근 가능
		 * 
		방법1]외부 클래스의 멤버 변수로 
		      내부 클래스 타입을 선언후,
		      객체 생성
		     (선언과 동시에 객체 생성 혹은 
		      외부클래스의 생성자에서 객체 생성)
		      외부클래스의 인스턴스 변수로 접근
		*/		
		outer.inner.innerInstanceMethod();
		//방법2]외부클래스를 이용해서 
		//     직접 내부클래스 인스턴스화.
		OuterClass.InnerClass inner= outer.new InnerClass();
		inner.innerInstanceMethod();
	}//////////main

}//////////////class
