package shape;

public class Circle extends Shape{
	public Circle(double diameter){
		setArea(calcArea(diameter));
		setPerimeter(calcCircumference(diameter));
	}
	
	public double calcArea(double diameter){
		return 3.14159265*(diameter/2)*(diameter/2);
	}
	
	public double calcCircumference(double diameter){
		return 3.14159265*diameter;
	}
}
