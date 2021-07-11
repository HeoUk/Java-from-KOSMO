package accessmodifier07;
//AccessModifierTwo클래스는 AccessModifierOne과 같은 패키지 안에 있다.
//AccessModifierOne의 멤버(변수,메소드)에 접근해 보자
public class AccessModifierTwo {
	//[멤버 변수]
	//두 클래스 모두 같은 패키지안에 있기때문에
    //import할 필요 없다.
	AccessModifierOne one;
	//[멤버 메소드]
	public void access() {
		/*
		 * AccessModifierOne 멤버중 private이 붙은 
		      멤버는 접근불가]-클래스가 서로 다름으로
		
		 * private이 붙은 멤버는 주로 public이 붙은
		 * 멤버 메소드를 통해서 간접으로 호출할 수 있다.
		 * 직접 호출불가(접근이 안되니까)
		 */
		
		one = new AccessModifierOne();
		//멤버변수에 접근
		//one.privateVar=10;//[x]is not visible
		one.packageVar=10;//[o]
		one.publicVar=10;//[o]
		//멤버 메소드에 접근
		//one.privateMethod();//[x]is not visible
		one.packageMethod();
		one.publicMethod();
		//PackageClass클래스는 접근지정가 생략형이지만
		//AccessModifierTwo와 같은 패키지 안에
		//있기때문에 접근가능
		PackageClass pack = new PackageClass();
		
	}
}
