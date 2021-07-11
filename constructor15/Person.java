package constructor15;

public class Person {
	//[멤버변수]	
	String name;
	int age;
	String addr;
	//[생성자]
	/*
	 기본(default) 생성자:매개변수(인자)가 없는 생성자
	 형식]
	 public 클래스명(){
	 	super()		
	 }	 
	  반환타입이 없다. 
	  멤버변수 초기화에 주로 사용. 
	  ※사용자가 기본 생성자를 정의하지 않으면 
	    컴파일러가 자동으로 제공해줌 
	 */
	//private Person() {}//다른 클래스에서 인스턴스화 불가하도록 막는다.
	//기본 생성자]
	public Person() {
		/*
		name="미상";
		age=1;
		addr="부모님 주소";*/
		this("미상",1,"부모님 주소");
		System.out.println("기본 생성자");
	}////////////////
	/*
	 * 인자 생성자: 매개변수가 있는 생성자
                  ※인자 생성자를 정의하면 기본(디폴트) 생성자를 더 이상 제공해주지 않는다.
        -생성자 오버로딩에 해당
    */
	public Person(String name) {
		/*this.name=name;
		age=1;
		addr="부모님 주소";*/
		this(name,1,"부모님 주소");
		System.out.println("인자 생성자:name");
	}////////////////
	public Person(String name,int age) {
		/*this.name=name;
		this.age=age;
		addr="부모님 주소";*/
		this(name,age,"부모님 주소");
		System.out.println("인자 생성자:name,age");
		
	}////////////////
	public Person(String name,int age,String addr) {
		this.name=name;
		this.age=age;
		this.addr=addr;
		System.out.println("인자 생성자:name,age,addr");
	}////////////////
	
	//[멤버 메소드]
	//멤버변수 초기화용 메소드]
	void initialize(String name,int age,String addr) {
		this.name=name;
		this.age=age;
		this.addr=addr;
	}/////////////initialize
	//정보출력용 메소드]
	void print() {
		
		System.out.println(
				String.format(
				"[%s님의 정보]%n나이:%d%n사는곳:%s",name,age,addr));
	}
}/////////////Person
