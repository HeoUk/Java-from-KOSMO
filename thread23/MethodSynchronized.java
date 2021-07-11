package thread23;

/*
메소드 동기화: 여러 스레드에 의해 호출되는
공유 메소드를 동기화 함으로써 여러 스레드가
동시에 호출 못하도록 lock을 거는 것

[형식]
	  접근지정자 synchronized  반환타입 메소드명([매개변수]){
	
	}
*/
/* 여러 스레드가 공유하는 메소드를 가진 클래스*/
class MethodSyncClass{
	int seed;
	//인자 생성자]

	public MethodSyncClass(int seed) {
		this.seed = seed;
	}
	//동기화시 synchronized 지정자 메소드에 추가]
	synchronized void increase(int inc) {
		for(int i=0;i < 10;i++) {
			seed+=inc;
			System.out.println(String.format("[스레드명:%s,데이터:%s,i=%s]",
					Thread.currentThread().getName(),seed,i));
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}	
}////////////////////////
//[공유 메소드를 호출하는 스레드]
class MethodSyncThread extends Thread{
	//[멤버 변수]
	MethodSyncClass msc;
	int inc;
	//[인자 생성자]
	public MethodSyncThread(MethodSyncClass msc, int inc,String threadName) {
		super(threadName);
		this.msc = msc;
		this.inc = inc;
	}
	
	@Override
	public void run() {
		msc.increase(inc);
	}
	
}////////////////////////////


public class MethodSynchronized {

	public static void main(String[] args) {
		//공유 메소드 갖고 있는 클래스, 하나만 인스턴스화]
		MethodSyncClass msc = new MethodSyncClass(10);
		//스레드는  여러개]
		MethodSyncThread mst1= new MethodSyncThread(msc, 2, "1st 스레드");
		MethodSyncThread mst2= new MethodSyncThread(msc, 5, "2nd 스레드");
		mst1.start();
		mst2.start();

	}//////////main

}///////////class
