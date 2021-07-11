package interface18;

public class Circle extends FigureData implements Drawable, Figure {

	public Circle(int radius) {
		super(radius);		
	}
	@Override
	public void area(String figureName) {
		
		System.out.println(figureName+"의 면적:"+radius*radius*Math.PI);
	}
	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"을 그리다");
	}

}
