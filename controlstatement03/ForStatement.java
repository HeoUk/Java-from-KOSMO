package controlstatement03;

public class ForStatement {

	public static void main(String[] args) {
		/*
		 for문: 어떤 명령문들을 반복하고자 할때  사용하는 제어문
		 
		 형식:
		 
		 반복순서:	 
		 초기식->반복 조건->참인경우 for문 안으로(거짓인 경우
		 for문을 빠져 나감)->증감식->반복조건->참인 경우 for문 안으로
		 ->증감식->반복조건->......
		 
		 
		 for(초기식 ; 반복조건(조건식) ; 증감식){
		 
		 	반복 조건이 참일때 실행할 명령문들;
			
		 }
		 
		 
		 반복조건이 없거나 조건대신에 true를 
		 지정하면 무조건 무한 루프
		 예]
		 for(;;){
		 
		 }
		 for(;true;){
		 
		 }	 
		 
		 -for문은 반복횟수가 정해진 경우 주로 사용한다.
		  반대로 반복횟수를 모를 경우에는 while문을 사용한다.	 
		 */
		//반복문을 이용해서 1부터 10까지 누적합:1+2+3+4+5+6+7+8+9+10
		int sum = 0;//누적합을 저장할 변수 선언]
		for(int i = 1; i <=10  ; i++ ) {
			//i=1일때 sum = 0+1
			//i=2일때 sum = 0+1+2
			//i=3일때 sum = 0+1+2+3
			//...
			//i=10일때 sum = 0+1+2+3+4+5+6+7+8+9+10
			sum += i;//sum = sum +i
			
		}
		System.out.println("1부터 10까지 누적합:"+sum);
		//1부터 10까지 숫자중 2의 배수의 합:2+4+6+8+10
		sum = 0;
		//방법1]2씩 증가하도록 증감식 작성
		for(int i=0;i <=10;i+=2) {
			sum+=i;
		}
		System.out.println("1부터 10까지 2의 배수의 합:"+sum);
		//방법2]1부터 1씩증가하면서  10까지 반복하면서
		//      i의 값이 2의 배수인 경우에만 누적
		sum = 0;
		
		for(int i=1;i < 11;i++)
			//i가 2의 배수일때만 누적
			if(i % 2 ==0) sum+=i;		
			
		System.out.println("1부터 10까지 2의 배수의 합:"+sum);
		//System.out.println("for문이 끝난 후 i의 값:"+i);//[x]
		
		int i=5;
		for(;i < 10;i++) {}
		System.out.println("for문이 끝난 후 i의 값:"+i);//[o]
		for(int k=10;k > 0;k-- ); 
		//아래 블락는 for문과 관련없다
		{
			System.out.println("HELLO WORLD");
		}
		/*
		문]1부터 100까지 숫자중 3의 배수 이거나 5의 배수인
		    숫자의 합을 구해라
		    단,3과5의 공배수인 경우 ,누적합에 단 한번만
		   포함시켜라.
		   
		   3+5+6+9+10+12+15+18+20+21+24+25+27+30......
		*/
		sum = 0;
		for(i=1;i<=100;i++) {
			if(i % 3==0 || i % 5==0) sum+=i;
		}
		System.out.println("1부터 100까지 3의 배수이거나 5의 배수의 합:"+sum);
		/*
		  문]1부터 100까지 숫자중 3의 배수 이거나 5의 배수인
		     숫자의 합을 구해라
		     단, 3과5의 공배수는 제외시켜라
		     즉 15,30,45,60..은 제외
		     
		     3+5+6+9+10+12+18+20+....
	   */
		sum =0;
		//방법1] || 하고 &&연산 사용
		for(i=1;i<=100;i++) {
			if((i%3==0 || i % 5==0) && i % 15 !=0) sum+=i;
		}
		System.out.println("1부터 100까지 3의 배수이거나 5의 배수의 합(공배수 제외):"+sum);
		//방법2]^(XOR)연산 사용
		sum=0;
		for(i=1;i<=100;i++) {
			if(i%3==0 ^ i % 5==0) sum+=i;
		}
		System.out.println("1부터 100까지 3의 배수이거나 5의 배수의 합(공배수 제외):"+sum);
		/*
		이중(중첩) for문 :for문 안의 for문
		이중 for문에서 바깥 for문은 행(row)를 의미
		안쪽 for문은 열(column)을 나타낸다
		*/
		int repeatCount=1;
		for(int k=0;k<3;k++) {
			System.out.printf("[k가 %d일때]%n",k);
			for(int j=1;j<=3;j++) {
				System.out.printf("j는 %d,반복횟수:%d%n",j,repeatCount++);
			}
		}
		/*
		 * 0 0 0 1  (1,4) 
		 * 0 0 1 0  (2,3)
		 * 0 1 0 0  (3,2)
		 * 1 0 0 0  (4,1)처럼 출력해 보자
		 */
		//방법1]
		System.out.println("[증가 연산자 사용]");
		for(int k=1;k<5;k++ ) {//k 행번호
			for(int j=1;j<5;j++) {//j 열번호
				if(k+j == 5) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
			}
			//줄바꿈
			System.out.println();
		}
		//방법2]
		System.out.println("[감소 연산자 사용]");
		for(int k=1;k<=4;k++ ) {//k 행번호
			for(int j=4;j>=1;j--) {//j 열번호
				if(k==j) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
			}
			//줄바꿈
			System.out.println();
		}
		/*
		 
		  *
		  * *
		  * * *
		  * * * *
		  * * * * *  를 출력하여라 (이중 for문 이용) 			  
		 */
		System.out.println("[25번 반복]");
		for(int k=1;k<=5;k++) {			
			for(int j=1;j<=5;j++) {
				if(k >=j) System.out.printf("%2c",'*');
			}
			//줄바꿈
			System.out.println();
		}
		System.out.println("[15번 반복]");
		for(int k=1;k<=5;k++) {			
			for(int j=1;k >=j;j++) {
				System.out.printf("%2c",'*');
			}
			//줄바꿈
			System.out.println();
		}
		/*
		  문]아래 형식대로 구구단을 출력
			2 * 1 = 2   3 * 1 = 3   4 * 1 = 4........9 * 1 = 9
			2 * 2 = 4   3 * 2 = 6   4 * 2 = 8........9 * 2 =18
			..
			..
			2 * 9 = 18  3 * 9 = 27  4 * 9 =36....... 9 * 9 = 81	
	    */
		for(int k=1;k<=9;k++) {
			for(int j=2;j<=9;j++) {
				System.out.printf("%d * %d = %-3d",j,k,j*k);
			}
			//줄바꿈
			System.out.println();
		}
		for(;;) {
			System.out.println("무한반복");
			break;
		}
		//break;문 없으면 Unreachable code에러
		System.out.println("프로그램 끝");
	}/////////main

}///////////class
