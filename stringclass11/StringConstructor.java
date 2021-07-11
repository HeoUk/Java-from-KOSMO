package stringclass11;

import java.util.Scanner;

import common.utility.CommonUtilities2;

public class StringConstructor {

	public static void main(String[] args) {
		//[String클래스의 생성자]
		//1]byte형 배열을 문자열로 변환
		//String(byte[] bytes) 생성자 이용
		//String(byte[] bytes,int 시작인덱스,int 길이)
		byte[] bArr= {65,66,67,69,48};
		String byteToString = new String(bArr);
		System.out.println("바이트형 배열을 문자열로 변환:"+byteToString);
		byteToString = new String(bArr,2,2);
		System.out.println("바이트형 배열 일부분을 문자열로 변환:"+byteToString);
		//1-1]문자열을 byte형 배열로:String 클래스의 getBytes()
		bArr=byteToString.getBytes();
		for(int i=0; i < bArr.length;i++)
			System.out.println(String.format("bArr[%d]:%d",i,bArr[i]));
		//2]char형 배열을 문자열로 변환
		//  생성자 혹은 static String valueOf(char[])이용
		//String(char[] value) 
		//String(char[] value, int offset, int count)
		char[] chArr= {'H','I','!',' ','안','녕'};
		String charToString = new String(chArr);
		System.out.println("char형 배열을 문자열로 변환:"+charToString);
		charToString = new String(chArr,4,2);
		System.out.println("char형 배열 일부분을 문자열로 변환:"+charToString);
		//2-1]문자열을 char형 배열로:String클래스의 toCharArray()
		chArr = charToString.toCharArray();
		for(int i=0;i<chArr.length;i++)
			System.out.println(String.format("chArr[%d]:%c",i,chArr[i]));
		//3]아스키나 유니코드값이 저장된
		//  int형 배열을 문자열로 변환
		int[] codePoints= {50,51,65,66,44032,94};
		String intToString=new String(codePoints,0,codePoints.length);
		System.out.println("int형 배열을 문자열로 변환:"+intToString);
		// String과 StringBuffer사이는 서로 생성자로 변환
		/* 
		 * 문]Scanner클래스로 문자열를 입력받아
		 * (nextLine()사용) char형 배열로 변환해서
		 * 출력하고
		 * 또한 입력받은 문자열을 숫자로 변환해서 2를 곱한
		 * 값을 출력 해라.단 입력받은 문자열이 숫자 형식이 아니면
		 * 숫자 형식일때까지 계속 입력받아서
		 * 위의 결과를 출력해라.		
		 */
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("숫자 형태의 문자열을 입력하세요?");
			String value = sc.nextLine();
			if(!CommonUtilities2.isNumber(value)) {
				System.out.println("숫자 형식이 아닙니다");
				continue;
			}
			chArr = value.toCharArray();
			for(int i=0;i<chArr.length;i++)
				System.out.println(String.format("chArr[%d]:%c",i,chArr[i]));
			System.out.println("2를 곱한 값:"+Integer.parseInt(value)*2);
			break;
		}
	}//////////////main

}////////////////class
