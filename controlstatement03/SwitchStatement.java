package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class SwitchStatement {

	public static void main(String[] args) throws IOException {
		//switch문:if문처럼 조건에 따라서 분기하는 제어문
		//형식:
		  /*  
		  정수식(산술식): 연산의 결과값이 byte/short/char/int타입으로 
		       나오는 식 long형은 해당 안됨.          
		       정수식은 산술식이거나 직접 변수를 정수식으로 
		       사용하거나
		       예] num % 5 혹은 num 	       
		               
		  switch(정수식){  
		   	case 값1 :
		     	명령문1;
		        break;
		    case 값2 :
		     	명령문2;
		        break;
		    ......
		    case 값n :
		     	명령문n;
		        break;
		   
		    [default :
		     	명령문m;
		     	[break;]
		    ]
		  }			  	  
		    
		  break문을 만나면 switch문 밖으로 빠져 나옴.   
		    범위를 가지고 분기할때는 주로 if문을 사용하고
		    수식의 결과값이 이산적일때 switch문 사용		   
		 */ 
		//JDK 5.0부터 추가된 클래스:Scanner
		Scanner sc = new Scanner(System.in);		
		System.out.println("숫자를 입력하세요?");
		int inputNumber=sc.nextInt();
		System.out.println("입력한 숫자:"+inputNumber);
		System.out.println("[if문으로 나머지값 판단]");
		int remain = inputNumber % 3;
		if(remain==0) System.out.println("나머지가 0");
		else if(remain == 1) System.out.println("나머지가 1");
		else System.out.println("나머지가 2");
		
		System.out.println("[switch문으로 나머지값 판단]");
		switch (remain) {
			case 0:
				System.out.println("나머지가 0");
				break;
			case 1:
				System.out.println("나머지가 1");
				break;
			default:
				System.out.println("나머지가 2");	
		}
		//※switch문에는 정수식 즉 결과값이  byte/short/int/char/String타입의 와야함
	    // boolean값은 불가 즉 비교식이나 논리식 사용할 수 없다.
		//switch(inputNumber % 3 == 0) {}//[x]
		//switch(inputNumber % 3 == 0 || inputNumber > 100) {}//[x]
		
		byte b = 5;
		switch(b) {//변수가 와도 됨(단,타입은 byte/short/char/int형/String형 만 가능)
			case 1:
				System.out.println("b에 저장된 값 1");
		    /*
		     * case로 분기시 값 중복 불가
			case 2:
				System.out.println("b에 저장된 값 2");
			case 2:
				System.out.println("b에 저장된 값 2");
		     */
			/*
			 * break가 없는 경우 :
			 * 먼저 해당  case를 찾고
			 * 해당 case아래 명령문들도 모두 차례로 실행됨.
			 * 고로 반드시 break를 추가해라
			 */
			case 5:
				System.out.println("b에 저장된 값 5");
			case 10:
				System.out.println("b에 저장된 값 10");
		}
		long ln =5;
		//switch(ln) {}//[x]long형이니까
		//switch(ln % 3) {}//[x]정수식이지만 연산결과가 long형이니까
		
		System.out.println("첫번째 숫자 입력?");
		int fnum=sc.nextInt();
		System.out.println("연산자 기호 입력(+,-,*,/)입력?");
		char op = (char)System.in.read();
		System.out.println("두번째 숫자 입력?");
		int snum=sc.nextInt();
		System.out.printf("fnum:%d,snum:%s,op:%c%n",fnum,snum,op);
		switch(op) {
			case '+':
				System.out.printf("%d + %d = %d%n",fnum,snum,fnum+snum);
				break;
			case '-':
				System.out.printf("%d - %d = %d%n",fnum,snum,fnum-snum);
				break;
			case '*':
				System.out.printf("%d * %d = %d%n",fnum,snum,fnum*snum);
				break;
			case '/':
				System.out.printf("%d / %d = %d%n",fnum,snum,fnum/snum);
				break;
			default:
				System.out.printf("잘못된 연산자 기호입니다:%c%n",op);
		}
		String subject="수학";
		switch(subject) {
			case "국어":
				System.out.println("과목은 국어");break;
			case "수학":
				System.out.println("과목은 수학");break;
			default:System.out.println("개설되지 않은 과목입니다");
		}
		/*

		여러 case를 동시에 처리할때는
		case 값1:
		case 값2:
		case 값n: 실행문n; break;
		값1인경우,값2인경우, 값n인경우에도
		위의 실행문n이 실행됨.
		*/
		switch(inputNumber) {
			case 1:
			case 2:
			case 100:
			case 200:
				System.out.println("1이거나 2이거나 100이거나 200중 하나");
				break;
			case 300:
				System.out.println(inputNumber);
		}
		
		System.out.println("국어 점수 입력?");
		int kor=sc.nextInt();		
		System.out.println("영어 점수 입력?");
		int eng=sc.nextInt();		
		System.out.println("수학 점수 입력?");
		int math=sc.nextInt();
		/*		
		문]평균을 구해서 90점이상 "A학점"출력
		                 80점이상 "B학점"출력
		                 70점이상 "C학점"출력
		                 60점이상 "D학점"출력
		                 60점미만 "F학점"을 출력하여라
		                 단,switch문 사용
		*/
		int avg = (kor+eng+math)/30;
		switch(avg) {
			case 10:
			case 9:System.out.println("A학점");break;
			case 8:System.out.println("B학점");break;
			case 7:System.out.println("C학점");break;
			case 6:System.out.println("D학점");break;
			default:System.out.println("F학점");
			
		}
	}//////////////main
}/////////////////class
