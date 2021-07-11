package polymorphism14;

import java.util.Date;

/*
Overloading(중복정의):
하나의 클래스안에서 같은 이름의 메소드를 
여러개 정의 할 수 있다.
조건:
1)매개변수 갯수가 다르거나
2)갯수가 같다면 매개변수 타입이 다르거나
3)타입과 갯수가 같다면 매개변수 순서가 달라야한다
그러면 다른 메소드로 본다.
※단, 반환타입과는 전혀 관계가 없다.

원래는 하나의 클래스안에서 메소드를 중복 
정의해서 사용할 수 없다.
단,오버로딩을 적용해 같은 이름의 메소드를 
중복정의 할 수는 있다.
*/
public class Overloading {
	/*
	 -아래 두 메소드는 같은 메소드임[x] 오버로딩이 아님
	 -메소드명 동일,매개변수 타입 및 개수 및 순서가 
	   동일하기때문에
	   같은 메소드로 본다 즉 오버로딩이 아니다.
	 -반환 타입 하고는 전혀 상관 없다.
	 */
	//int noOverloading(String str,Date date) {return 0;}//[x]
	//float noOverloading(String str2,Date date2) {return 0;}//[x]
	//메소드 오버로딩 방법]
	//1]매개변수 타입이 다른 경우-양념의 종류가 다른 경우
	void paramTypeDiff(int param) {}
	void paramTypeDiff(float param) {}
	void paramTypeDiff(double param) {}
	//2] 매개변수 갯수가 다른 경우-양념을 넣는 횟수가 다른 경우
	void paramCountDiff() {}
	void paramCountDiff(int param) {}
	void paramCountDiff(int param,int param2) {}
	void paramCountDiff(int param,int param2,int param3) {}
	//3] 매개변수 타입이 같고 개수도 같지만 
    //   순서가 다른 경우-양념은 같은 데 넣는 순서를 다름.
	void paramOrderDiff(int args1,float args2,double args3) {}
	void paramOrderDiff(float args2,int args1,double args3) {}
	void paramOrderDiff(float args2,double args3,int args1) {}
	/*
	JDK5.0이상부터 메소드의 기능은 동일하고
	매개변수의 타입이 하나의 자료형일 경우
	매개변수 갯수에 따라서 매번 오버로딩 하지않고
	VarArgs라는 기능을 이용해서 
	하나의 메소드로 처리할 수 있다.
	[매개변수 형식]
	메서드명(자료형 ... 매개변수명)
	이때 매개변수명는 배열명이 된다.
	즉 하나의 메소드로 여러 호출 형식의 메소드를 
	호출할 수 있다.
	*/	
	/*
	 VarArgs기능 미 사용시 여러개 메소드 Overloading해야함	
	 */
	/*
	static int getTotal(int param) {
		int sum=0;
		sum+=param;
		return sum;
	}////////////
	static int getTotal(int param1,int param2) {
		int sum=0;
		sum+=param1+param2;
		return sum;
	}////////////
	static int getTotal(int param1,int param2,int param3) {
		int sum=0;
		sum+=param1+param2+param3;
		return sum;
	}////////////*/
	
	//VarArgs기능 사용
	static int getTotal(int ... param) {
		int sum=0;
		for(int i=0;i < param.length;i++) sum+=param[i];
		return sum;
	}	
	public static void main(String[] args) {
		System.out.println(getTotal(10));
		System.out.println(getTotal(10,20));
		System.out.println(getTotal(10,20,30));
		System.out.println(getTotal(10,20,30,40));
		System.out.println(getTotal(1,2,3,4,5,6,7,8,9,10));
	}///////////////main

}///////////////////class
