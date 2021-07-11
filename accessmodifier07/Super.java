package accessmodifier07;

/*
 *   ※protetced접근지정자:
 *    같은 패키지는 물론 다른 패키지 일지지라도
 *    두 클래스간의 상속관계가 존재한다면  접근 가능
 */
public class Super {
	//[멤버 메소드]
	private void privateMethod() {}
	void packageMethod() {};
	protected void protectedMethod() {}
	public void publicMethod() {}
	//자기 클래스 안에서는 모든 멤버 접근 가능
	void callAll() {
		privateMethod();
		packageMethod();
		protectedMethod();
		publicMethod();
	}
}
