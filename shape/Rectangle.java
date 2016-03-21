package shape;

public class Rectangle extends Shape{
	
	public Rectangle(double height){
		setArea(height);
		setPerimeter((2*height) + 2);
	}
	
	public Rectangle(double height, double width){
		setArea(calcArea(height,width));
		setPerimeter(calcPerimeter(height, width));
	}
	
	public double calcArea(double height, double width){
		return height*width;
	}
	
	public double calcPerimeter(double height, double width){
		return 2*(height + width);
	}
}
