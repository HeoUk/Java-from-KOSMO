package thread23;

//스레드로 구현하지 않은 클래스]
class NotThread{
	String title;
	//[인자 생성자]
	public NotThread(String title) {
		this.title = title;
	}
	//스레드로 구현하지 않은 메소드]
	void notThreadMethod() {
		/*아래 로직이 시간이 오래 걸리는 작업이라고 가정*/
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {e.printStackTrace();}
			
			System.out.println(String.format("%s]i=%d",title,i));
		}
	}
}////////////NotThread
//스레드로 구현한 클래스]
//1]Thread클래스를 상속받아 스레드 구현
class YesThread extends Thread{

	//인자 생성자:매개변수(인자)로 스레드명으로 사용할 문자열을 받는다
	public YesThread(String threadName) {
		super(threadName);
	}////
	
	void threadMethod() throws InterruptedException{
		/*아래 로직이 시간이 오래 걸리는 작업이라고 가정*/
		for(int i=0;i<=10;i++) {
			//sleep(천분의 1초);
			//스레드를 1000분 1초동안 wait상태로
			//빠지게 하는 메소드.
		    //1000분 1초후에는 다시 Runnable상태로
		    //자동으로 돌아감.
			sleep(1000);
			System.out.println(String.format("%s]i=%d",getName(),i));
		}
	}
	
	/*2]run()메소드 오버라이딩
	  -run()메소드안에 시간이 오래 걸리는 작업 기술
	  -개발자가 직접 호출 못하고 스레드가
	   Running상태로 들어갔을때 자동으로 호출되는 메소드(콜백 메소드)
	*/
	@Override
	public void run() {
		try {
			threadMethod();
		}
		catch(InterruptedException e) {e.printStackTrace();}
	}//////////////////
	
}////////////////
/*
 * 독립 스레드(Non Daemon 스레드):
      메인스레드와 working스레드(개발자가 만든 스레드)
 * 메인스레드가 끝나도 종료되지 않고 스레드가
 * Dead상태 될때까지 계속 실행되는 스레드
 * 
 * 종속 스레드(Daemon 스레드):
 * 모든 독립스레드가 끝나면 자동으로 종료(Dead)가 되는
 * 스레드
 * -주 스레드의 보조역할을 하는 스레드
 * -종속 스레드는 주로 무한루프로 구성한다.
 * -예]배경음악 깐다든지,10분마다 자동저장한다든지 등등..
 * 
 * 어떤 스레드를 종속 스레드로 만들려면
 * setDaemon(true)로 설정
 */

//종속 스레드로 사용할 스레드]
//1]Thread 클래스 상속
class DaemonThread extends Thread{
	//2]run메소드 오버라이딩
	@Override
	public void run() {
		while(true) {
			System.out.println(String.format("%s]배경음악이 흘려요",getName()));
			System.out.println(String.format("%s]3마다 저장", getName()));
			try {
				sleep(3000);
			} 
			catch (InterruptedException e) {e.printStackTrace();}
		}/////////////
	}//////////
	
}/////////////////////
public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("main 스레드 시작");
		//스레드로 구현하지 않은 클래스 테스트]
		/*
		NotThread nt1 = new NotThread("1st 클래스");
		NotThread nt2 = new NotThread("2nd 클래스");
		nt1.notThreadMethod();
		nt2.notThreadMethod();*/
		//스레드로 구현한 클래스 테스트]
		YesThread yt1= new YesThread("1st 스레드");
		YesThread yt2 = new YesThread("2nd 스레드");
		//메소드로 스레드명 설정
		yt1.setName("첫번째 스레드");		
		yt1.start();//스레드를 Runnable상태로 전이시킴.run()메소드안의 코드가 실행되는 것은 아님
		/*
		 -join() 메소드
		  1]start()호출후에 join()메소드를 호출해야 한다
		  2]join()메소드를 호출한 스레드가 
		    다 실행이 끝나야 다른 스레드가 동작한다.
		*/
		yt1.join();
		/*스레드의 우선권 설정]
		우선순위가 높다고 그 스레드가
		먼저 실행된다는 보장은 없다.(확률만 높을뿐)*/
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
		
		//스레드명 미 설정시 자동으로 부여됨]
		DaemonThread daemon = new DaemonThread();
		daemon.setName("데몬스레드");
		daemon.setDaemon(true);//종속 스레드 설정]
		daemon.start();//스레드 runnable상태로]
		
		
		System.out.println("현재 활성화 상태(Runnable혹은 Running상태)에 있는 스레드 수:"+Thread.activeCount());
		System.out.println("첫번째 스레드 우선권:"+yt1.getPriority());
		System.out.println("두번째 스레드 우선권:"+yt2.getPriority());
		System.out.println("main스레드 우선권:"+Thread.currentThread().getPriority());
		System.out.println("현재 실행중인(Running)스레드:"+Thread.currentThread().getName());
		System.out.println("main 스레드 끝");

	}///////////////main

}//////////////////class
