package day2;
class Circle{
	private double radius;
//	private String color;
	 
	public Circle() {};
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return Math.PI* Math.pow(radius, 2);
	}
	
}
public class q1 {
	public static void main(String args[]) {
		Circle circle1 = new Circle(7.0);
		System.out.println(circle1.getArea());
	}
}
