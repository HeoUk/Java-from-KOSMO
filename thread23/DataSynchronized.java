package thread23;

//동기화 블락을 이용한 데이타 동기화
//동기화 블락:
/*
synchronized(동기화할 객체){

	동기화할 로직

} 
*/
/* 여러 스레드가 공유하는 데이타(메모리)를 갖고 있는 클래스 */
class DataSyncClass{
	//여러 스레드가 공유하는 메모리]
	int shareData;
	//인자 생성자]

	public DataSyncClass(int shareData) {		
		this.shareData = shareData;
	}	
}/////////////
/* 공유 데이타를 사용하는 스레드 */
class DataSyncThread extends Thread{
	//[멤버변수]
	//공유할 데이타를 갖고 있는 DataSynClass타입의 멤버
	DataSyncClass dsc;
	//일정하게 증가시킬 숫자를 저장할 멤버
	int inc;
	//[인자 생성자]	
	public DataSyncThread(DataSyncClass dsc, int inc,String threadName) {
		super(threadName);
		this.dsc = dsc;
		this.inc = inc;
	}//////////////
	//[오래 걸리는 메소드]
	//DataSynClass의 shareData에 저장된 값을 반복하면서
	//inc(증가분)만큼 누적해서 계속 저장.
	void increase() {
		for(int i=0;i < 10;i++) {
			dsc.shareData+=inc;
			System.out.println(String.format("[스레드명:%s,공유 데이터:%s]",
					getName(),dsc.shareData));
			try {
				sleep(2000);
			} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}////////////
	
	@Override
	public void run() {
		//데이타 동기화 전]
		increase();
		//데이타 동기화  후]	
		//synchronized (dsc) {
		//	increase();
		//}
	}
	
}//////////
public class DataSynchronized {

	public static void main(String[] args) throws InterruptedException {
		//공유 메모리 갖고 있는 클래스, 하나만 인스턴스화]
		DataSyncClass dsc = new DataSyncClass(10);
		//두 개의 스레드 생성]
		DataSyncThread dst1 = new DataSyncThread(dsc, 2, "1st 스레드");
		dst1.start();
		/*
		 * -데이타 동기화 없이  특정 스레드를 지정해서
		 *  동기화 작업을 하고자 할때
		 */
		dst1.join();
		
		DataSyncThread dst2 = new DataSyncThread(dsc, 5, "2nd 스레드");
		dst2.start();
		

	}/////main

}////////class
