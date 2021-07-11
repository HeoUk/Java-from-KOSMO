package method05;

public class CommandLine {
	/*
	명령줄(Command Line) 인수:
	main메서드의 매개변수인 param에 전달하는 값을
	명령줄 인수라 한다
	param는 Command Line에서 인수를 의미 즉
	예] dos>java.exe CommandLine 100    가길동 에서  args는 100를 
	담은 매개변수임

	[실행시] 인수 개수가 args 배열의 인덱스보다 
	많으면 상관없으나
	부족하면 ArrayOutofBoundsException예외 발생

	dos>java.exe CommandLine 홍길동 20 강남

	*/
	public static void main(String[] param) {
		System.out.println("[명령줄 인수]");
		System.out.println("이름:"+param[0]);
		System.out.println("나이:"+param[1]);
		System.out.println("주소:"+param[2]);
	}/////////main

}/////////////////class
