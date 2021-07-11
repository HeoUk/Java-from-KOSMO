package encapsulation13;
/*
 * 캡술화 
 * 
 * 캡술화(은닉화)]
 * -관련있는 데이타를 하나로 묶는것 
 * -멤버변수에 외부에서(다른 클래스) 접근 못하도록 
 *  막는 것
 *  단,메소드를 통해서 멤버변수의 값을
 *  읽거나 설정하도록 한다.
 *  
 *  -Getter]접근지정자가 private인 
 *          멤버변수의 값을 읽을 수 있는 메소드
 *  private int name;
	형식:
	public 반환타입(해당 멤버변수의 자료형) get멤버변수명(){
	
		return 멤버변수명;
	}
	예]
	private int money;
	//-getter
	public int getMoney(){
		
		return money;
	}
	
	-Setter]private한 멤버변수에 값을 설정하는 메소드
	public void set멤버변수명(매개변수타입(멤버변수의 타입) 매개변수명){
		멤버변수명=매개변수명;
	}
	//-setter
	public void setMoney(int m){
		money = m;
	}
 */
public class EncapsulationApp {

	public static void main(String[] args) {
		EncapsulationDAO cap = new EncapsulationDAO();
		//데이타 초기화
		cap.initialize("가길동", "123-567", 1000);
		//통장 정리]
		cap.print();
		//출금]
		cap.withDraw(1500);
		cap.withDraw(500);
		//입금]
		cap.deposit(10000);
		cap.print();
	}///main

}////class
