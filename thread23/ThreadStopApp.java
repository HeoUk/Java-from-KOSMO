package thread23;


class ThreadStop extends Thread{
	
	//플래그 변수 이용시 아래 멤버 추가-비 추천]
	//boolean isFlag;
	
	@Override
	public void run() {
		
		//플래그 변수 사용시(비추천)	
		/*
		int i=0;
		while(!isFlag) {
			System.out.println("i="+ ++i);
			try {
				sleep(1000);
			} 
			catch (InterruptedException e) {e.printStackTrace();}
		}*/
		//[interrupt()메소드 호출(추천)]
		int i=0;
		//while밖으로 catch절을 뺀다
		try {
			while(true) {
				System.out.println("i="+ ++i);
				sleep(1000);		
				
			}
		}
		catch(InterruptedException e) {
			System.out.println("interrupt()메소드 호출");
		}
		finally {
			System.out.println("스래드 중지");
		}
		
		
	}////
}///////////////
public class ThreadStopApp {

	public static void main(String[] args) {
		ThreadStop thread= new ThreadStop();
		thread.start();
		//메인 스레드 5초동안 대기상태로 만들기
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e) {}
		//플래그 이용] boolean형 플래그 변수 사용-비추천
		//thread.isFlag=true;
		//[interrupt()메소드 호출-추천]
		if(thread.isAlive()) thread.interrupt();
	}////////////main

}///////////class
