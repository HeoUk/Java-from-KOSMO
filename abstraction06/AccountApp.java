package abstraction06;

//은행계좌를 추상화 하자]
class Account{
	//[멤버 변수]
	String name;//예금주
	String accountNo;//계좌번호
	int balance;//잔액
	//[멤버 메소드]
	//입금하다
	void deposit(int money) {
		balance+=money;
		System.out.println(money+"가 입금 되었어요");
	}
	//출금하다
	void withDraw(int money) {
		if(balance < money) {
			System.out.println("잔액이 부족해요");
			return;
		}
		balance-=money;
		System.out.println(money+"가 출금 되었어요");
	}
	//통장정보 출력용]
	void printAccount() {
		System.out.printf("[%s님의 계좌정보]%n",name);
		System.out.printf("계좌번호:%s%n",accountNo);
		System.out.printf("잔액:%d%n",balance);
	}
}////////////Account
public class AccountApp {

	public static void main(String[] args) {
		//통장개설]
		Account ac1 = new Account();
		System.out.println("[멤버변수 초기화 전]");
		ac1.printAccount();
		//[멤버변수 초기화]
		ac1.accountNo="123-567";
		ac1.name="가길동";
		ac1.balance=1000;
		System.out.println("[멤버변수 초기화 후]");
		ac1.printAccount();
		//인출]
		ac1.withDraw(15000);
		ac1.withDraw(500);
		//통장 정리]
		ac1.printAccount();
		//입금]
		ac1.deposit(10000);
		//통장 정리]
		ac1.printAccount();
		//또 다른 통장 개설]
		Account ac2 = new Account();
		ac2.name="나길동";
		ac2.accountNo="567-123";
		ac2.balance=10000;
		ac2.printAccount();
	}//////////////main

}///////////////class
