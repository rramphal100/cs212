package shape;

public class Main {
	public static void main(String [] args){
		Circle x = new Circle(5.0);
		System.out.println("The value for Circle instanceof Shape is: " + (x instanceof Shape) + '.');
		System.out.println("Circle x has an area of " + x.getArea() + " and a perimeter of " + x.getPerimeter() + '.');
	}
}
