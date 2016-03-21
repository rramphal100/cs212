package shape;

public class Triangle extends Shape{
	public Triangle (double base, double height){
		setArea(calcArea(base, height));
		setPerimeter(calcPerimeter(base));
	}
	
	public double calcArea(double base, double height){
		return base*height*0.5;
	}
	
	public double calcPerimeter(double base){
		return 3*base;
	}
}
