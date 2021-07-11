package wrapperclass10;

import java.util.Scanner;

public class WrapperClass03 {
	//문]인자로 전달받은 value가 숫자형식이면 true반환 아니면 false를 반환하는
	//   메소드를 정의해라
	//예] "20" =>true,"20A1"=>false
	public static boolean isNumber(String value) {
		//System.out.println("문자열의 길이:"+value.length());
		//Character클래스의 메소드 사용	
		for(int i=0;i < value.length();i++) {
			//방법1]isDigit 와 codePointAt 사용
			if(!Character.isDigit(Character.codePointAt(value, i)))  
				return false;
			//방법2]codePointAt()만 사용
			//int codeValue = Character.codePointAt(value, i);
			//if(!(codeValue>='0' && codeValue<='9')) return false;
			
		}
		return true;
	}////////////////////////
	public static void main(String[] args) {
		/*JDK 1.4 이전 버전의 코딩 형태*/
		char ch='A';
		Character chObj = new Character(ch);
		char chReuslt=(char)(chObj.charValue()+1);
		System.out.println("chReuslt:"+chReuslt);
		/*JDK 5.0 이후 버전의 코딩 형태*/
		chObj = 'C';//오토박싱 char->Character형으로
		chReuslt = chObj;//오토 언박싱  Character->char형으로
		System.out.println("chReuslt:"+chReuslt);
		/*
		[Character클래스의 주요 메소드]
		1]static int codePointAt(CharSequence seq, 
		                         int index)  
		:문자열에서 index에 해당하는 위치의 한 문자의
		 아스키 코드(유니코드)값을 반환한다.(index는 0부터 시작) 		
		*/
		System.out.println("[codePointAt메소드]");
		System.out.println(Character.codePointAt("ABCD",2));
		System.out.println("[isDigit메소드]");
		//2]static boolean isDigit(char ch)  
		//  static boolean isDigit(int codePoint)  
		//  :어느 한 문자가 숫자인지 아닌지 판단하는 
		//   메소드.
		System.out.println(Character.isDigit('A'));
		System.out.println(Character.isDigit('2')? "숫자다":"숫자가 아니다");
		System.out.println(Character.isDigit(65)? "숫자다":"숫자가 아니다");
		System.out.println(Character.isDigit(50)? "숫자다":"숫자가 아니다");
		System.out.println(Character.isDigit('가')? "숫자다":"숫자가 아니다");
		System.out.println(Character.isDigit(44032)? "숫자다":"숫자가 아니다");
		
		System.out.println("[내가 만든 메소드:isNumber()]");
		System.out.println(isNumber("1004"));//true
		System.out.println(isNumber("100사"));//false
		System.out.println(isNumber("10A4321"));//false
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요?");
		String value=sc.nextLine();
		if(isNumber(value))
			System.out.println("당신의 10년후 나이:"+Integer.parseInt(value));
		else 
			System.out.println("나이는 숫자만...");*/
		//3]static boolean isLetter(char ch)  
		//:문자인지 아닌지(언어(한글,한문,영어,일본어등)에 해당하는 것만) 판단하는메소드
		System.out.println("[isLetter메소드]");
		System.out.println(Character.isLetter('가'));
		System.out.println(Character.isLetter('A'));
		System.out.println(Character.isLetter('家'));
		System.out.println(Character.isLetter('9'));
		System.out.println(Character.isLetter('@'));
		//4]static boolean isWhitespace(char ch)  
		//  static boolean isWhitespace(int codePoint)  
		//:공백문자인지 판단하는 메소드
		System.out.println("[isWhiteSpace메소드]");
		System.out.println(Character.isWhitespace('가'));
		System.out.println(Character.isWhitespace(' '));//공백의 아스키코드값 32
		System.out.println(Character.isWhitespace(32));
		String whiteString = "  H   E  L LO ";
		int whiteCount=0;
		for(int i=0;i < whiteString.length();i++)
			if(Character.isWhitespace(Character.codePointAt(whiteString, i))) 
				whiteCount++;
		
		System.out.println("총 공백 수:"+whiteCount);
		//5]대소문자를 판단하는 메소드
		//  (영문자에만 적용)
		//static boolean isLowerCase(char ch)  
		//static boolean isUpperCase(char ch)
		//알파벳이 아닌 문자에 적용시 모두 false반환.
		System.out.println("[isLowerCase/isUpperCase메소드]");
		System.out.println(Character.isUpperCase('A'));
		System.out.println(Character.isUpperCase('a'));
		System.out.println(Character.isLowerCase('A'));
		System.out.println(Character.isLowerCase('a'));
		System.out.println(Character.isLowerCase('가'));
		System.out.println(Character.isLowerCase('9'));
		System.out.println("[String클래스의 toCharArray()메소드]");
		String value="KOSMO";
		char[] chArray=value.toCharArray();
		System.out.println(chArray[0]);
		System.out.println(chArray[2]);
		System.out.println(chArray[4]);
		/*
		  문]아이디를 입력받는데 영문자 소문자 와 숫자로만 
		     입력받아야한다
		     대문자가 포함되면 "잘못 입력했어요"라고 출력하고 
		     제대로된 아이디를 입력 받을때까지
		     계속 입력 받도록 하여라.		
		     단,숫자로 시작해서도 안된다 즉 숫자로 시작한 아이디를
	             입력 했을때도
		  "잘못 입력했어요" 라고 출력 하시오		     
		  hint]아이디 입력받을때 Scanner의 nextLine사용
		          String클래스의 toCharArray()사용
		 */
		/*
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("아이디를 입력하세요?");
			String nickName = sc.nextLine();
			if(nickName.length() < 6) {
				System.out.println("아이디는 6자 이상입니다");
				continue;
			}
			char[] chNick=nickName.toCharArray();			
			//옳은 아이디인지 아닌지 판단용 변수
			boolean isCorrect = true;
			for(int i=0;i < chNick.length;i++) {
				if(Character.isDigit(chNick[0]) || 
						!Character.isLowerCase(chNick[i]) && !Character.isDigit(chNick[i])) {
					System.out.println("잘못 입력했어요");
					isCorrect=false;
					break;
				}			
			}////for
			if(isCorrect) {
				System.out.println("당신의 아이디는 "+nickName);
				break;
			}
			
		}////while
		*/
		//6]대문자를 소문자로 , 소문자를 대문자로
		//static char toUpperCase(char ch)  
		//static int toUpperCase(int code) 
		//static char toLowerCase(char ch) 
		//static int toLowerCase(int code) 
		System.out.println("[toLowerCase/toUpperCase메소드]");
		System.out.println(Character.toUpperCase('A'));
		System.out.println(Character.toUpperCase('a'));
		System.out.println(Character.toLowerCase('A'));
		System.out.println(Character.toLowerCase('a'));
		System.out.println(Character.toLowerCase('가'));
		System.out.println(Character.toLowerCase('9'));
		//문]사용자로부터 문자열(영문자)을 입력받아서
		//   대문자는 소문자로,소문자는 대문자로 변경하여
		//   출력하여라
		//   예]Hello입력 => hELLO출력
		Scanner sc = new Scanner(System.in);
		System.out.println("영문자를 입력하세요?");
		String alphabet = sc.nextLine();
		char[] chAlpha= alphabet.toCharArray();
		
		//3번째 방법을 위한 변수 선언
		String alphaString="";//빈 문자열 		
		for(int i =0;i < chAlpha.length;i++) {
			if(Character.isLowerCase(chAlpha[i])) {
				//1]방법-직접 출력
				//System.out.print(Character.toUpperCase(chAlpha[i]));
				//2]방법-대문자로 변경해서 i방에 다시 저장(원본이 변함)
				//chAlpha[i]=Character.toUpperCase(chAlpha[i]);
				//3]방법-문자들을 하나씩 String형 변수에 누적
				alphaString+=Character.toUpperCase(chAlpha[i]);
			}
			else {
				//1]방법-직접 출력
				//System.out.print(Character.toLowerCase(chAlpha[i]));
				//2]방법-대문자로 변경해서 i방에 다시 저장(원본이 변함)
				//chAlpha[i]=Character.toLowerCase(chAlpha[i]);
				//3]방법-문자들을 하나씩 String형 변수에 누적
				alphaString+=Character.toLowerCase(chAlpha[i]);
			}
			//2번째 방법 출력]
			//System.out.print(chAlpha[i]);
		}///for
		//3번째 방법 출력]
		System.out.println(alphaString);
		//문]위의 최종 변환된 문자열을 거꾸로 출력하여라
		//   예]Hello ->hELLO -> OLLEh출력
		System.out.println("[거꾸로 출력]");
		chAlpha=alphaString.toCharArray();
		for(int i = chAlpha.length-1;i >=0;i--)
			System.out.print(chAlpha[i]);
		System.out.println();
		/*
		 ※모든 Wrapper클래스는 기본 자료형을 
	       String형으로
		   변환 해줄 수 있는 아래와 같은 메소드를
		   공통으로 갖고 있음
		   String toString()  
		   static String toString(기본 자료형 타입)  
		 */
		
		
		short s =200;//200->"200"
		//static String toString(기본 자료형 타입) 사용
		System.out.println(Short.toString(s)+200);
		// String toString() 사용
		Short shObj =s;//오토박싱
		System.out.println(shObj.toString()+200);
		
		ch ='가';//'가'->"가"
		System.out.println(Character.toString(ch));
		//오토박싱하지 않고  Character valueOf(char) 사용
		System.out.println(Character.valueOf(ch).toString());
		
		boolean b=true;//true ->"true"
		System.out.println(Boolean.toString(b));
		System.out.println(Boolean.valueOf(b).toString());
		/*
		 * 모든 Wrapper클래스에는 valueOf()계열 
		 * 메소드를
		 * 가지고 있다
		 * 
		 * static Wapper클래스 valueOf(기본형)
		 *  기본형을 참조형으로(오토박싱 지원으로 의미없음)
		 * 
		 * static Wapper클래스 valueOf(String): 
		 * 숫자형식의 문자열을
		 * Wrapper클래스로(단, ※ 래퍼클래스.parse계열 많이 사용)
		 */
		//b = TRue;//[x]논리값은 모두 소문자
		String boolString="TRue";//"TRue"(문자열) -> true(논리값)
		System.out.println(Boolean.parseBoolean(boolString) && false);
		System.out.println(Boolean.valueOf(boolString) && true);
	}//////////main

}/////////////class
