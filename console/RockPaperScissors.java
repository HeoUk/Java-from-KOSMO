package console;

import java.util.Scanner;

/*
 * Math클래스의 random()메소드:
 * 0.0사이에서 1.0사이의 double형값을 무작위로
 * 발생시켜주는 메소드(단,1.0은 미 포함)
 * 
 * 특정 범위의 숫자를 랜덤하게 발생 시키려면
 * 
 * (int)(Math.random()*차이값)+시작값
 * 단,끝값은 포함 안됨
 * 끝값을 포함 시키려면
 * (int)(Math.random()*(차이값+1))+시작값
 * 
 * 예] 5부터 15사이의 숫자를 랜덤하게 발생시키려면
 * 차이값: 15-5 =10;
 * 시작값: 5
 * 끝값:15
 * 
 * (int)(Math.random()*10)+5 : 단,15는 발생 안됨
 * 
 * 끝값도 발생시키려면 
 * (int)(Math.random()*11)+5
 */
public class RockPaperScissors {
	
	//상수 정의]
	
	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;
	
	public static void main(String[] args) {
		//4~8사이의 숫자 랜덤하게 발생시키자
		//시작값:4,끝값:8,차이값:4
		//System.out.println((int)(Math.random()*5)+4);
		Scanner sc = new Scanner(System.in);
		while(true) {
			//1]메뉴 출력
			System.out.println("=============메뉴 번호=============");
			System.out.println("1.가위 2.바위 3.보 9.종료");
			System.out.println("=================================");
			//2]컴퓨터 숫자 랜덤하게 발생
			int computer=(int)(Math.random()*3)+1;
			//System.out.println("컴퓨터:"+computer);
			//3]사용자 숫자 입력 받기
			System.out.println("메뉴 번호를 입력하세요?");
			int user = sc.nextInt();
			if(user==9) break;
			//4]게임 승리여부 판단
			String userString = user==SCISSORS ?"가위": user==ROCK ? "바위" :"보" ;
			String computerString = computer==SCISSORS ?"가위": computer==ROCK ? "바위" :"보" ;
			System.out.printf("[컴퓨터:%s,사용자:%s] ",computerString,userString);
			
			if(user==SCISSORS && computer==ROCK ||
			   user==ROCK && computer==PAPER    ||
			   user==PAPER && computer==SCISSORS
					)
				System.out.println("당신이 졌어요");
			else if(user == computer)	
				System.out.println("비겼어요");
			else
				System.out.println("당신이 이겼어요");
		}////while
		System.out.println("즐거웠죠!!!");

	}////main

}///////class
