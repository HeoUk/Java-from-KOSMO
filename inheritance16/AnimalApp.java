package inheritance16;

public class AnimalApp {
	
	public static void main(String[] args) {
		Dog dog = new Dog("포유류",2,"수컷","치와와");
		dog.printDog();
		dog.bark();
		//※자식이 아닌 다른 클래스에서 부모(Animal)의 멤버(year)에 접근하려면 
		//별도의 메소드를 자식에서 정의해서 접근 해야 한다.
		System.out.println("Dog클래스의 year:"+dog.year);
		System.out.println("Animal의 year:"+dog.getSuperYear());
	}///////////main

}//////////////class
/*
accessmodifier07->polymorphism14
protected            오버라이딩 (다형성)
                                          이질화(다형성)
                     instanceOf연산자
                                          타입캐스팅(참조형사이의 형변환)    
                                      
*/
