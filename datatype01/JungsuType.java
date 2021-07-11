package datatype01;

public class JungsuType {

	public static void main(String[] args) {
		/*
		원칙] 1.큰 자료형과 작은 자료형의 연산 결과는  
		             큰 자료형을    따른다.
		      2.같은 자료형끼리의 연산 결과는
		               같은 자료형이 된다  
	        예외]int형보다 작은 자료형(byte,short,char)들끼리
		               연산 결과는 int형이다.
		       	즉 적용이 안된다.
		*/
		//규칙1]기본 자료형중 수치형의 정수형의 대표 자료형은 int
		byte b1;//변수 선언
		b1 = 127;//[o]최대 127(int형 상수)까지 저장가능
		System.out.println("b1="+b1);
		//b1 = 128;//[x]128은 int형 상수로 대입불가
		b1 = (byte)128;//[o]형변환.예상치 못한 값이 저장됨.
		System.out.println("b1="+b1);//-128
		//규칙2]int형보다 작은 자료형(byte,short,char)들의 
	    //연산결과는 int형이다.(예외에 속하는 것)
		byte b2 =20,b3 =30;
		//byte b4=b2+b3;//[x]b2+b3의 더하기 연산결과는 int형
		//방법1]연산 결과인 int형에 담는다
		int num1 = b2+b3;//[o]
		System.out.println("num1="+num1);
		//방법2]연산결과 전체를 byte형으로 형변환
		byte b4=(byte)(b2+b3);//[o]
		System.out.println("b4="+b4);
		
		short s1 = 1000,s2=2000;
		//short s3 = s1+s2;//[x]
		//방법1]
		num1 = s1+s2;///[o]
		System.out.println("num1="+num1);
		//방법2]
		short s3 = (short)(s1+s2);//[o]
		System.out.println("s3="+s3);
		/*
		규칙3]정수형에서 int형보다 작은 자료형들을 제외한
		         자료형들끼리(int,long)의 연산결과는 모두 원칙을 따른다.
		         즉 int형 과 int형 의 연산결과는 int형
		       long형과 long의 연산결과는 long형
		       int형과 long형의 연산결과는 long형
		*/
		int num2=100,num3=200;
		long ln1=1000,ln2=2000;
		num1 =num2+num3;//[o]연산결과 int형
		System.out.println("num1="+num1);
		long ln3 = ln1+ln2;//[o]연산결과 long형
		System.out.println("ln3="+ln3);
		//int num4=ln1+num2;//[x]
		//방법1]long형에 담는다
		ln3 = ln1+num2;//[o]
		System.out.println("ln3="+ln3);
		//방법2]연산결과 전체를  int형으로 변환
		int num4=(int)(ln1+num2);
		System.out.println("num4="+num4);
		//방법3]long형인 ln1만 int 형으로 형변환
		//      int형끼리의 연산은  int형이니까
		num4=(int)ln1+num2;
		System.out.println("num4="+num4);
		//long ln4 =2200000000;//[x]
		/*
		컴파일러에게 22억이라는 숫자은 int형 상수가 아닌
		long형 상수라는것을
		알려주기위해 숫자뒤에 l(소문자)이나 L을 붙인다
		*/
		long ln4 =2200000000L;//[O]
		System.out.println("ln4="+ln4);
		num4 =(int)2200000000l;
		System.out.println("num4="+num4);
		//규칙5]숫자 앞에 0(영)이 붙으면 8진수를 의미한다.
		num4 = 0412;// 4*8^2 + 1*8^1+2*8^0 = 256+8+2=266
		System.out.println("num4="+num4);
		//규칙6]숫자 앞에 0x(0X)가 붙으면 16진수를 의미
		//0 1,2...9,A(10을 의미),B,C,D,E,F(15를 의미)
		num4 = 0x1F;//1*16^1 + 15*16^0=16+15=31
		System.out.println("num4="+num4);
		//1]국어,영어 ,수학 점수 및 점수 총합을 저장할 수 있는 
		//  변수 4개를 선언하여라(int형 사용)
		int kor,eng,math,total;
		//2]국어에는 89,영어는 99,수학은 78을 저장하여라
		kor=89;
		eng=99;
		math=78;
		//3]국영수의 총합을 구해서 1]번에서 선언한 총합 저장용 변수에 저장하여라
		total = kor+eng+math;
		//4]각 국영수 점수 및 총합을 출력하여라
		/*
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
		System.out.println("총합:"+total);*/
		System.out.println("국어:"+kor+",영어:"+eng+",수학:"+math+",총점:"+total);
	}///////////////main
}//////////////////class
