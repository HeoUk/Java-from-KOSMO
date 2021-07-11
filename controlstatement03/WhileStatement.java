package controlstatement03;

import java.io.IOException;

public class WhileStatement {

	public static void main(String[] args) throws IOException {
		//while문:반복문으로 반복횟수가 정해져 있지 않을때
		//        주로 사용
		//형식:
		/*
			[초기식;]
			while(반복조건){
			
			  반복조건이 참일때 실행할 명령문들;
			   [증감식;]
			  
			} 
					 
			 무한루프 처리]
			 while(true){
			 	실행할 명령문들;

			 }
		*/
		//while(int i=0) {}//[x]초기식은 for문에서만 사용가능
		//1부터 10까지 누적합:while문 사용
		//누적합을 저장할 변수 선언
		int sum =0;
		int i=1;//[초기식]
		while(i<=10) {//[반복조건]
			sum+=i;//[명령문]
			i++;//[증감식]
		}
		System.out.println("1부터 10까지 누적합:"+sum);
		System.out.println("while문이 끝난 후 i:"+i);
		/*
		문]1부터 1000까지 숫자중 3의 배수 이거나 5의 배수인
		   숫자의 합을 구해라
		   단, 3과5의 공배수인 경우 제외(while문 사용)
		*/
		sum=0;
		i=1;
		while(i<=100) {
			if(i%3==0 ^ i % 5==0) sum+=i;
			i++;
		}
		System.out.println("1부터 100까지 3의 배수이거나 5의 배수의 합(공배수 제외):"+sum);
		//사용자가 몇 자를 입력할지 모름으로 while문 사용.(for문도 가능)
		System.out.println("문자열을 입력하세요?");
		char word;
		while((word=(char)System.in.read()) != 13) {
		//for(;(word=(char)System.in.read()) != 13;) {
			System.out.print(word);
		}
		System.out.printf("%n");
		/*
		 * 1 0 0 0
		 * 0 1 0 0
		 * 0 0 1 0
		 * 0 0 0 1  while문으로...
		 */
		int k=1;
		int j=4;
		while(k<=4) {//k 행번호
			//int j=4;
			while(j>=1) {//j 열번호
				if(k==j) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
				j--;
			}
			j=4;//안쪽while의 초기식을 바깥쪽 while에 위치 시킬때 추가
			//줄바꿈
			System.out.println();			
			k++;
		}
		/*
		
		  * 
		  * *
		  * * *
		  * * * *
		  * * * * *(while문으로)		
		 
		 */
		k=1;
		while(k<=5) {
			j=1;
			while(k >=j) {
				System.out.printf("%2c",'*');
				j++;
			}
			//줄바꿈
			System.out.println();
			k++;
		}
		/*
		  문]아래 형식대로 구구단을 출력
			2 * 1 = 2   3 * 1 = 3   4 * 1 = 4........9 * 1 = 9
			2 * 2 = 4   3 * 2 = 6   4 * 2 = 8........9 * 2 =18
			..
			..
			2 * 9 = 18  3 * 9 = 27  4 * 9 =36....... 9 * 9 = 1	
			
			while문으로...
	    */
		k=1;
		while(k<=9) {
			j=2;
			while(j<=9) {
				System.out.printf("%d * %d = %-3d",j,k,j*k);
				j++;
			}
			//줄바꿈
			System.out.println();
			k++;
		}
		while(true) {
			System.out.println("무한루프");
			break;
		}
		System.out.println("프로그램 끝");
	}////////////main

}//////////////class
