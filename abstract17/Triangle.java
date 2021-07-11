package abstract17;

public class Triangle extends Figure {
	//[인자 생성자]
	public Triangle(int width, int height) {
		super(width, height);
		System.out.println("Triangle의 인자 생성자");
	}
	@Override
	void area(String figureName) {
		System.out.println(figureName+"의 면적:"+width*height*0.5);				
	}

	

}
