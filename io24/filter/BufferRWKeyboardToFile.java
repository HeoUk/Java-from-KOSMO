package io24.filter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;

import common.utility.CommonUtilities2;

/*
키보드로 부터 입력받아서
파일(KeyboardChar.txt)로 출력(FileWriter스트림 사용)
하자
단,키보드로 입력받은 데이타(1바이트)는
브릿지 스트림을 통해 문자단위로 변환해라
그리고 필터스트림(2바이트 기반)을 통해 필터링하자
(BufferedReader/PrintWriter필터 스트림 사용)		
 */
public class BufferRWKeyboardToFile {
	/*Scanner클래스의 nextLine()이나 nextInt()같은 메소드 만들기*/
	private static int nextInt() throws InputMismatchException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {
			inputString= br.readLine();
		} 
		catch (IOException e) {e.printStackTrace();}
		
		if(!CommonUtilities2.isNumber(inputString))
			throw new InputMismatchException();
		
		return Integer.parseInt(inputString);		
	}//////////////
	private static String nextLine() {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {
			inputString= br.readLine();
		} 
		catch (IOException e) {e.printStackTrace();}		
		return inputString;			
	}///////////////////
	
	public static void main(String[] args) throws IOException {
		/*
		//1]필터끼운 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//2]필터 끼운 출력 스트림 생성
		PrintWriter pw = new PrintWriter(
				new FileWriter("src/io24/filter/KeyboardChar.txt"),true);
		//3]br로 읽고 pw로 출력
		String data;
		while((data=br.readLine()) !=null) {
			pw.println(data);
		}
		//4]스트림닫기
		pw.close();*/
		System.out.println("나이를 입력하세요?");
		int age= nextInt();
		System.out.println("당신의 10년 후 나이:"+(age+10));
		System.out.println("이름을 입력하세요?");
		System.out.println("당신의 이름:"+nextLine());
	}///////////main

}/////////////class
