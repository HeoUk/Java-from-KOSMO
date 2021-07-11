package abstract17;

//추상 클래스]
abstract public class Figure {
	//[멤버변수]
	int width,height,radius;
	//[기본 생성자]

	public Figure() {
		System.out.println("Figure의 기본 생성자");
	}/////////////////
	//[인자 생성자]
	public Figure(int width, int height) {		
		this.width = width;
		this.height = height;		
		System.out.println("Figure의 인자 생성자:width:height");
	}////////////////////
	public Figure(int radius) {			
		this.radius = radius;
		System.out.println("Figure의 인자 생성자:radius");
	}////////////////////
	//[추상 메소드]
	//도형의 면적을 구하는 추상 메소드
	abstract void area(String figureName);
}
