package lamda26;

public class MyCalculator {
	//인자(매개변수)에 남다식을 받는 메소드]
	static void paramFunc(MyInterface lamda,int a,int b) {
		System.out.println(lamda.calc(a, b));
	}///////////////
	//남다식 반환하는 메소드]
	static MyInterface returnFunc(int c) {
		return (x,y)-> x*y+c;
	}
	public static void main(String[] args) {
		//방법1]인터페이스를 구현한 클래스파일 사용
		MyInterface my = new MyInterfaceImpl();
		System.out.println(my.calc(10, 5));
		//방법2]익명 클래스로 구현 즉 별도의 클래스파일 불필요.방법1 보다 코드 간결. 단 재사용 불가 
		MyInterface my2 = new MyInterface() {
			//기능 하나만 정의 가능
			@Override
			public int calc(int a, int b) {				
				return a+b;
			}
			
		};
		System.out.println(my2.calc(10, 5));
		//방법3] 람다식 사용.클래스파일 불필요.방법2 보다 코드 간결. 단 재사용 불가
		//      추상 메소드 하나로 다양한 기능 구현.
		MyInterface lamda = (a,b) -> {return a+b;};
		System.out.println(lamda.calc(10, 5));
		lamda = (a,b) -> a-b;
		System.out.println(lamda.calc(10, 5));
		lamda = (a,b) -> a/b;
		System.out.println(lamda.calc(10, 5));
		lamda = (a,b) ->a*b;
		System.out.println(lamda.calc(10, 5));
		lamda = (a,b) -> a%b;
		System.out.println(lamda.calc(10, 5));
		//함수의 인자로 남다식(익명함수) 전달
		paramFunc((x, y)->x%y, 10,5);
		//함수를 반환
		System.out.println(returnFunc(100).calc(10, 5));
	}/////////main

}///////////class
