package exception21;

//1]Exception클래스를 상속받아 예외클래스로 만든다.
public class NotGoodAppearanceException extends Exception {
	//2]생성자 정의
	//[기본 생성자]
	public NotGoodAppearanceException() {
		//Exception의 인자 생성자인 Exception(String message) 호출]
		//인자인 message는 getMessage()로 호출할때 
		//반환되는 예외 메시지임
		super("복장 불량은 입장 불가");
	}
	//[인자 생성자]
	public NotGoodAppearanceException(String message) {
		super(message);
	}
}
