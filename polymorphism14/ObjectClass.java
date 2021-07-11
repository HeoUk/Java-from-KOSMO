package polymorphism14;

/*
-자바의 모든 클래스의 최상위 부모는 Object클래스이다
-Object클래스의 toString()메소드는 객체의 주소를
 String으로 반환해주는 메소드다 
-Object클래스의 equals()메소드는 
 두 객체간의 인스턴스비교
 즉 주소값 비교,주소가 같으면 true,다르면 false반환 
 Object클래스의 String toString()메소드]
		 :객체의 주소를 문자열로 반환
		  패키지명.클래스명@주소(16진수) 
 ※toString()메소드 오버라이딩시 반드시 hashCode()메소드도 오버라이딩하자		  
 Object클래스의 boolean equals()메소드]
        : 비교 클래스의 
          인스턴스변수.equals(대상클래스의 인스턴스변수)
          두 객체의 주소비교
 */
class MyClass{
	//[멤버 변수]
	int data;
	//인자 생성자]
	public MyClass(int data) {	
		this.data = data;
	}
	//실제 저장된 데이타가 반환되도록 Object로부터 상속받은
	//toString()메소드 오버라이딩(재정의)]
	@Override
	public String toString() {		
		return String.valueOf(data);
	}
	@Override
	public int hashCode() {		
		return data;
	}//////
	//실제 저장된 데이타를 비교하도록 equals(Object)메소드 
	//오버 라이딩]
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyClass) {//타입이 MyClass
			MyClass mc=(MyClass)obj;
			if(mc.data==this.data) return true;
			else return false;
		}
		return false;//타입이 MyClass가 아닌 경우
	}//////////////
	
}////////////MyClass
class Point{
	//[멤버변수]
	int x,y;
	//[인자 생성자]
	public Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}
	//문1]"x=10,y=20"처럼 반환하도록 toString() 메소드를 
    //   오버라이딩 하여라
	@Override
	public String toString() {		
		//return "x="+x+",y="+y;
		return String.format("x=%d,y=%d", x,y);
	}/////////////
	//문2]저장된 x좌표와 y좌표가 같은지 비교하도록 equals()메소드를
	//   오버라이딩하여라.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {//타입이 Point
			Point pt=(Point)obj;
			if(pt.x==x && pt.y==y) return true;
			else return false;
		}
		return false;//타입이 MyClass가 아닌 경우
	}	
}
public class ObjectClass {

	public static void main(String[] args) {
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		System.out.println("[두 객체의 toString()호출]");
		System.out.println(mc1.toString());		
		System.out.println(mc1.getClass().getName()+'@'+Integer.toHexString(mc1.hashCode()));
		System.out.println(mc2.toString());
		System.out.println(mc2.getClass().getName()+'@'+Integer.toHexString(mc2.hashCode()));
		System.out.println("[두 객체를 equals()메소드로 주소 비교]");
		System.out.println(mc1 == mc2 ?"Same":"Different");
		System.out.println(mc1.equals(mc2)?"같다":"다르다");
		
		Point point1 = new Point(10, 20);
		Point point2 = new Point(10, 20);
		System.out.println("[toString()호출]");
		System.out.println(point1);
		System.out.println(point2);
		System.out.println("[equals()호출]");
		System.out.println(point1.equals(point2));
	}////////////main

}//////////////class
