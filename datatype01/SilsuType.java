package datatype01;

import java.math.BigDecimal;

public class SilsuType {

	public static void main(String[] args) {
		
		//※실수형에서 대표 자료형은 double이다.
		//규칙1]정수형보다는 실수형이 더 큰 그릇이다
		//long(정수형):8byte,float(실수형):4byte
		long ln =100;
		float f1 = 200;
		//long ln1=ln + f1;//[x]long형과 float형 연산결과는 float
		//방법1]연산결과인 float형에 저장
		float f2 = ln + f1;//[o]
		System.out.println("f2="+f2);//[o]300.0
		//방법2]연산결과 전체를 long형으로 형변환
		long ln1=(long)(ln + f1);
		System.out.println("ln1="+ln1);//300
		//방법3]f1만 long형으로 형변환
		ln1=ln + (long)f1;
		System.out.println("ln1="+ln1);//300
		//tip)주로 소수점 이하를 제거하고자 할때
		//int 형으로 형변환하면 된다.
		float kor=99,eng=80,math=96;
		float avg=(kor+eng+math)/3;
		System.out.println("평균:"+avg);
		System.out.println("평균(소수점 제거):"+(int)avg);
		/*
		규칙2]실수형에서 기본 데이타 타입은 double이다
		소수점이 붙으면 무조건 double형으로 인식
		단, 소수점이 붙지 않은 값은 float에 담을 수 있다.*/	
		//float f3 = 3.14;//[x]3.14는 double형 상수
		float f3 =100;//[o]int형 상수 100을 float형 변수 f3에 저장
		System.out.println("f3="+f3);//100.0
		//방법1]형변환
		f3 = (float)3.14;//[o]
		System.out.println("f3="+f3);//3.14
		
		//방법2]실수 숫자뒤에 f 나 F(권장)
		f3 = 3.14F;//[O]3.14는 float형 상수
		System.out.println("f3="+f3);
		//3]실수형도 같은 자료형끼리의 연산결과는
		//  같은 자료형,큰 자료형과 작은 자료형과의 
		//  연산결과는 큰 자료형.
		float ff1=100,ff2=3.14f,fresult;
		double d1=100,d2=3.14,dresult;
		fresult=ff1+ff2;//[o]연산결과는 float형
		System.out.println("fresult="+fresult);
		dresult = d1+d2;//[o]연산결과는 double형
		System.out.println("dresult="+dresult);
		/*반지름이 10인 원의 면적을 구해라
		   단,면적을 저장하는 변수의 타입을 3가지 형태(int/float/double)의
		   자료형에 저장하여 출력하여라 그리고 소수점을 제거하여라
		   원의 면적:반지름*반지름*3.14  
		   단,아래의  변수 radius 와 pi를 사용해서 구해라*/
		int radius = 10;
		double pi=3.14;
		//면적을 저장하는 변수]
		int iarea;
		float farea;
		double darea;
		
		iarea = (int)(radius * radius * pi);
		//iarea = radius * radius * (int)pi;//300 논리적 오류
		System.out.println("iarea : "+iarea);
		//farea = radius * radius * (float)pi;//혹은
		farea = (float)(radius * radius * pi);
		System.out.println("farea : "+(int)farea);
		darea = radius * radius * pi;
		System.out.println("darea : "+(int)darea);
		
		d1 = 0.1;
		d2 = 0.2;
		System.out.println(d1 + d2);//예상:0.3,실제:0.30000000000000004
		System.out.println(d1 * d2);//예상:0.02,실제:0.020000000000000004 
		System.out.println(d1+d2 == 0.3 );//예상:true,실제:false
		
		BigDecimal big4 = new BigDecimal("0.1");
		BigDecimal big5 = new BigDecimal("0.2");
		BigDecimal big6 = big4.add(big5);
		System.out.println(big6);
		/*
		 * BigDecimal타입1.compareTo(BigDecimal타입2)
		 * 값이 같으면 0
		 * BigDecimal타입1이 가리키는 값이 더 크면 1
		 * BigDecimal타입1이 가리키는 값이 더 작으면 -1
		 * 
		 */
		System.out.println(big6.compareTo(new BigDecimal("0.3")));
		
		
	}/////////////main

}//////////////////class
