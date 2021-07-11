package inheritance16;
/*
 * Animal을 상속받은 Dog클래스 생성하자(Ainmal의 기본생성자 정의 안하고
 * 인자 생성자만 정의 한 경우)마자 Dog클래스명에 레드라인 해결법
 * 1.부모 클래스에 기본 생성자 정의하거나
 * 2.자식 클래스에서 부모클래스의 인자 생성자 호출
 */
//[Dog is a Animal성립]
public class Dog extends Animal {
	//[멤버변수]
	//[확장한 멤버]
	String dogKind;	
	int year;//Dog에서 새롭게 추가(확장)한 멤버 변수
	//기본 생성자]	
	public Dog() {		
		super(null,0,null);
		//this(null,0,null,null);//[x]동시 호출 불가
	}
	//[인자 생성자]
	public Dog(String species, int year, String gender, String dogKind) {
		//this.species= species;
		//this.gender=gender;
		//this.year = year;//Dog의 year초기화
		//super.year=year;//Animal의 year초기화
		super(species,year,gender);
		
		this.dogKind=dogKind;
		//super(species,year,gender);//[x]항상 첫문장이어야한다
	}/////////////
	//[멤버 메소드]
	void bark() {
		//super();//[x]생성자 안에서만 호출 가능
		System.out.println(super.year+"살인 "+dogKind+"가 짓다");
	}
	void printDog() {
		printAnimal();
		System.out.println(",개 종류:"+dogKind);
	}
	static void staticMethod() {
		//super//[x]인스턴스 메소드에서만 사용가능
		//super();//[x]생성자 안아서
	}
	
	int getSuperYear() {
		return super.year;//Animal의 year반환
	}
}///////////////////class
