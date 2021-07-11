package exception21;

import java.io.IOException;

/*
예외객체 생성후  throw키워드를 이용해서 직접 던지기
- 반환타입 메소드명 throws 예외클래스와 쌍이다.

- throws를 이용해서 던진 예외는 언젠가는 반드시 
try~catch를
해야 한다. 즉 만약 계속 던졌다면
최종 main에서는 다시 던질 수는 있지만 
실행시 에러 고로 
try~catch해야 한다.	

	형식]
	접근지정자 [modifier] 반환타입 메소드명 throws 예외클래스{
		특정조건일때
		throw new Exception();
		
		//throw 이후의 명령문은 실행이 안된다.
	}
*/
public class ExceptionThrowsApp {
	/* 
	 * 기존 자바에서 제공해주는 예외를 던지는
	 * 메소드(예:read()) 호출하는 경우]
	 */
	static void throwsMethodByJava() throws IOException {
		System.out.println("문자입력?");
		System.in.read();
	}
	static void callByJava() throws IOException {
		throwsMethodByJava();
	}
	
	static void throwsMethodByUser(int value) throws  Exception{
		if(value % 2==0) {
			//1.예외객체 생성
			Exception e=new Exception("짝수는 안되요");
			//2.생성된 예외 객체 던지기(throw키워드 사용)
			throw e;
			//unreachable code에러 발생
			//System.out.println("throw키워드 이후");//[x]
		}
		System.out.println(value+"는 홀수");
	}	
	static void callByUser(int value) throws Exception {
		throwsMethodByUser(value);
	}
	public static void main(String[] args) /*throws Exception*/ {
		//callByJava();//예외를 던져도 되고 try~catch해도 된다
		/* 내가 직접 던진 예외는 계속 던져도 되나
		 * 반드시 메인 메소드에서는 try~catch로 처리
		 * 해야한다.(던져도 실행시 오류)
		 */
		//callByUser(10);//실행시 역시 오류 발생
		try {
			callByUser(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//////////main

}/////////////class
