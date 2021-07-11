package datatype01;

public class VariableDeclaration {
	
	public static void main(String[] args) {
		System.out.println("[변수 선언 방법 첫번째]");
		//자료형(data type) 변수명; 
		int num;//int형(숫자-정수)을 저장 할 수 있는 num이라는 이름의 메모리를 할당해주세요.
		//변수 초기화:생성된 메모리에 최초로 값을 할당.
		//※지역변수는 초기화하지 않고 사용시 컴파일오류 
		//System.out.println(num);//[x]
		num = 100;//변수 초기화.100이라는 값을 왼쪽의 num이라는
		  //메모리에 대입(할당)해주세요 
		System.out.println(num);//[o]
		System.out.println("[변수 선언 방법 두번째-선언과 동시에 초기화]");
		//1]200을 저장할 메모리 생성:int initNum
		//2]initNum이라는 이름의 메모리 생성
		//3]오른쪽의 200이 왼쪽의 변수로 복사된다
		int initNum =200;
		System.out.println(initNum);
		System.out.println("[변수 선언 방법 세번째-동시에 같은 타입의 변수 여러개 선언하기]");
		//,(콤마)로 구분해서 같은 자료형의 변수 여러개 선언.
		//또한 초기화도 같이 할 수 있다.
		int fnum,snum=1000,tnum;
		//System.out.println(fnum);//[x]초기화가 안되서
		fnum = snum;//fnum을 초기화
		System.out.println("fnum="+fnum);//[o]
		//fnum = snum+tnum;//[x]tnum이 초기화가 안되서
		tnum = 500;//tnum초기화
		fnum = snum+tnum;//[o]
		System.out.println("fnum="+fnum);
		//항상 =(대입(할당)연산자) 의 왼쪽에는
		//값을 변경할 수 있는 변수가 와야한다.
		//오른쪽에는 값이나 값이 저장된 변수가 온다.
		//100 = fnum;//[x]
		//[변수 선언시 에러나는 경우]
		//1]같은 지역(블락)안에서 동일한 이름의 변수 선언시
		//int fnum;//[x]
		//[o]fnum 과 fNum는 다름.자바는 엄격하게 대소문자 구분.
		int fNum;//[o]
		//2]명명 규칙에 어긋나는 경우
		//2-1]숫자로 시작하는 경우
		//int 4you-;//[x]
		int you4,y4ou;//[o]
		//2-2] _나 $를 제외한 특수문자 포함시
		//int special#var;//[x]
		int _underbar,under_bar,underbar_;//[o]
		int $dollar,doll$ar,dollar$;//[o]
		//int public;//[x]public은 예약어
		int puBlic;//[O]puBlic은 예약어가 아님.
		
		
		
	}///main
}//////class
