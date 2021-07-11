package innerclass22;
/*
내부 정적 클래스:클래스안의 클래스로 class앞에 static이 붙음
- 정적 멤버도 가질 수 있고
- 외부 클래스의 인스턴스형 멤버는 사용할 수 없다
- 외부클래스명$내부클래스명.class로 파일이 생긴다.
※ 원래 클래스 앞에는 static을 붙일 수 없으나 
   내부 클래스는 가능하다
*/
class OuterStatic{
	//내부 클래스 타입의 인스턴스변수 선언
	static InnerClass inner = new InnerClass();
	//[외부의 인스턴스형 멤버]
	int outerInstanceVar;
	void outerInstanceMethod() {
		/*
		 * ※내부의 정적 멤버는 내부 클래스 인스턴스화 필요없이
		 *   내부클래스명.내부정적멤버명 으로 접근
		 * ※내부 클래스의 인스턴스형 멤버 접근:
		 *   내부 클래스를 인스턴스화 한후 접근
		 */
		//내부 클래스의 정적 멤버
		System.out.println(InnerClass.innerStaticVar);
		//내부 클래스의 인스터스형 멤버-인스턴스화한후 변수로 접근
		System.out.println(inner.innerInstanceVar);//[o]
	}///////////
	//[외부의 정적 멤버]
	static int outerStaticVar;
	static int sameVar;
	static void outerStaticMethod() {
		System.out.println(InnerClass.innerStaticVar);
		System.out.println(inner.innerInstanceVar);
	}/////////////////
	//[내부 정적 클래스]
	//※내부 정적 클래스에서는 외부의 정적 멤버만 사용 가능]
	static class InnerClass{
		//[내부의 인스턴스형 멤버]
		int innerInstanceVar;
		int sameVar;
		void innerInstanceMethod() {
			//outerInstanceMethod();//[x]
			//외부의 정적 멤버만 사용가능
			System.out.println(outerStaticVar);//[o]
			outerStaticMethod();//[o]
			OuterStatic.sameVar=sameVar;//[o]
		}////////////////////
		//[내부의 정적 멤버]
		//※정적 멤버도 가질수 있다.
		static int innerStaticVar;
		static void innerStaticMethod() {
			System.out.println(outerStaticVar);//[o]
		}
	}////////////
}///////////////////////
public class InnerStaticClass {

	public static void main(String[] args) {
		/*
		 * ※외부 클래스가 아닌 별개의 다른 클래스에서
		 * 내부 정적 클래스에 접근할때는 외부 클래스를
		 * 먼저 인스턴스화 할 필요없이 내부 정적 클래스의
		 * 인스턴스화가 가능하다.	
		 */
		/*1]내부 정적 클래스의 정적 멤버에 접근할때는	    
    	외부클래스명.내부클래스명.정적멤버
	   */	
		OuterStatic.inner.innerInstanceMethod();
		
		//2]내부 클래스의 인스턴스형 멤버 접근시
		//외부 클래스명.내부클래스명 인스턴스변수 = new 외부 클래스명.내부클래스명()
		OuterStatic.InnerClass inner = new OuterStatic.InnerClass();
		inner.innerInstanceMethod();
	}/////////main

}////////////class
