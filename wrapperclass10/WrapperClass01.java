package wrapperclass10;
//[AutoBoxing <->AutoUnBoxing]
/*
- 오토박싱 ,오토 언박싱은 JDK5.0 이상에서만 적용 됨 
- Wrapper클래스와 기본 자료형과의 관계에서 나온 개념

- 오토박싱 : 기본 자료형이 자동으로(Auto) 
                참조형(Wrapper클래스)으로
                바뀌는거
예] int -> Integer

- 오토언박싱 :참조형(Wrapper클래스)이 
                 기본 자료형으로 자동으로 
                 바뀌는거

			 예] Integer -> int
*/
public class WrapperClass01  {
	
	public static void main(String[] args) {
		
		
		/* JDK 1.4이전 버전에서의 코딩 형태*/	
		//기본 자료형으로 +  연산]
		int num1 =200;
		int num2 =20;
		int result = num1+num2;
		System.out.println("result="+result);
		//Wrapper클래스로 + 연산]
		Integer num1Obj = new Integer(200);
		Integer num2Obj = new Integer(20);
		//System.out.println(num1Obj+ num2Obj);//[x]JDK1.4이전버전에서
		result=num1Obj.intValue()+num2Obj.intValue();//[O]JDK1.4이전버전에서
		System.out.println("result="+result);
		//기본 자료형은 멤버가 없다
		//num1.//[x]
		Integer num1Object=new Integer(num1);//[o]JDK1.4이전버전에서
		System.out.println("num1(int)을 byte형 값으로 변경:"+num1Object.byteValue());
		System.out.println((byte)num1);
		System.out.println("num1(int)을 이진수로 변경:"+Integer.toBinaryString(num1));
		System.out.println("num1Object:"+num1Object);
		System.out.println("num1Object.toString():"+num1Object.toString());
		/* JDK 5.0이후의 코딩 형태*/
		//int ->Integer:오토박싱이 일어남
		num1Obj = num1;//JDK1.4이전 버전에서는 에러남
		//Integer -> int형으로:오토 언박싱
		int num3 = num1Object;//JDK1.4이전 버전에서는 에러남
		Integer num3Obj = 300;//오토 박싱(int형 상수(300)->Integer)
		/*
		Wrapper클래스를 사용하는 이점:
		Wrapper클래스 안의 많은 메소드 사용가능
		고로 쉽게 정수를 이진수로 혹은 8진수로 쉽게 
		변환 가능 등등
		*/
		System.out.println("int형 최대값:"+Integer.MAX_VALUE);
		System.out.println("int형 최소값:"+Integer.MIN_VALUE);
		System.out.println("num1을 8진수로 변경:"+Integer.toOctalString(num1));
		System.out.println(0310);
		System.out.println("num1을 16진수로 변경:"+Integer.toHexString(num1));
		/*
		 자바의 모든 클래스들은 Object라는 
		 최상위 클래스로터
		 상속을 받는다 .
		 Wrapper클래스들은 Object부터 상속받은 
		 toString()메소드를
		 오버라이딩하여 인스턴스 변수 출력시 
		 주소가 아니라
		 실제 저장된 값이 반환되도록 오버라이딩 되었다.	  
		 */
		Integer remodel = new Integer(99);
		System.out.println("remodel="+remodel);
		System.out.println("remodel.toString()="+remodel.toString());
		System.out.println("remodel의 클래스명:"+remodel.getClass().getName());
		System.out.println(remodel.hashCode());
		/*
		  원래 Object클래스의 toString()메소드는 
		  메모리 주소를 
		  아래와 같은 문자열로	반환하도록 정의됨.
		  패키지명1.패키지명2....클래스명@16진수체계의 메모리 주소
		*/
		WrapperClass01 wc = new WrapperClass01();
		System.out.println("wc:"+wc);
		System.out.println("wc:"+wc.toString());
		System.out.println("wc.hashCode():10진수"+wc.hashCode());
		//366712642는 wc.hashCode()의 반환값
		System.out.println(Integer.toHexString(366712642));
	}///////////////main

}/////////////////class
