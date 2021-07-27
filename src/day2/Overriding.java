package day2;
/**
// *code is correct
 *   //Documentation not completed
 *   
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day2
 * Class: Overriding
 * Description: 
 * Created On:26 July 2021
 * @author Ananya Srivastava
 *	
 */

import java.util.Scanner;
class Vehicle{
	private int noOfWheel;
	private int noOfPassenger;
	private int model;
	private String make;
	Vehicle(int noOfWheel, int noOfPassenger, int model, String make){
		this.noOfPassenger = noOfPassenger;
		this.noOfWheel = noOfWheel;
		this.model = model;
		this.make = make;
	}
	public void display() {
		System.out.println(noOfWheel+"--"+noOfPassenger+"--"+model+"--"+make);
	}
	public int getModel() {
		return model;
	}
	public String getMake() {
		return make;
	}
}
class Car extends Vehicle{
	private int noOfDoor;
	Car(int noOfPassenger, int model, String make, int noOfDoor){
		super(4, noOfPassenger, model, make);
		this.noOfDoor = noOfDoor;
	}
	@Override
	public void display() {
		System.out.println(super.getMake()+"--"+super.getModel()+"--"+noOfDoor);
	}
	public int getNoOfDoor() {
		return noOfDoor;
	}
	public void setNoOfDoor(int noOfDoor) {
		this.noOfDoor = noOfDoor;
	}
}
class Convertible extends Car{
	private boolean isHoodOpen;
	
	Convertible(int noOfPassenger, int model, String make, int noOfDoor, boolean isHoodOpen){
		super(noOfPassenger, model, make, noOfDoor);
		this.isHoodOpen = isHoodOpen;
	}
	@Override
	public void display() {
		super.display();
		System.out.print("Is Hood Open: ");
		String ans = isHoodOpen==true ? "Yes" : "No";
		System.out.println(ans);
	}
}
class SportCar extends Car{
	SportCar(int noOfPassenger, int model, String make){
		super(noOfPassenger, model, make, 2);
	}
	@Override
	public void display() {
		super.display();
	}
}

//application class
class Overriding {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("1 – to create a Vehicle object.\r\n" + 
				"2 – to create a Car object.\r\n" + 
				"3– to create a Convertible object.\r\n" + 
				"4– to create a SportCar object.");
		int choice = scMain.nextInt();
		switch(choice) {
		case 1: System.out.println("Number of Wheels:");
				int noOfWheels = scMain.nextInt();
				System.out.println("Number of Passengers:");
				int noOfPassenger = scMain.nextInt();
				System.out.println("Model:");
				int model = scMain.nextInt();
				System.out.println("Make:");
				String make = scMain.next();
				Vehicle newVehicle = new Vehicle(noOfWheels, noOfPassenger, model, make);
				newVehicle.display();
				break;
		case 2: System.out.println("Number of Passengers:");
				int noOfPassenger1 = scMain.nextInt();
				System.out.println("Model:");
				int model1 = scMain.nextInt();
				System.out.println("Make:");
				String make1 = scMain.next();
				System.out.println("Number of Doors:");
				int noOfDoors = scMain.nextInt();
				Car newCar = new Car(noOfPassenger1, model1, make1, noOfDoors);
				newCar.display();
				break;
		case 3: System.out.println("Number of Passengers:");
				int noOfPassenger11 = scMain.nextInt();
				System.out.println("Model:");
				int model11 = scMain.nextInt();
				System.out.println("Make:");
				String make11 = scMain.next();
				System.out.println("Number of Doors:");
				int noOfDoors1 = scMain.nextInt();
				System.out.println("Is hood open?:");
				boolean isHoodOpen = scMain.nextBoolean();
				Convertible newConvertible = new Convertible(noOfPassenger11, model11, make11, noOfDoors1, isHoodOpen);
				newConvertible.display();
				break;
		case 4: System.out.println("Number of Passengers:");
				int noOfPassenger111 = scMain.nextInt();
				System.out.println("Model:");
				int model111 = scMain.nextInt();
				System.out.println("Make:");
				String make111 = scMain.next();
				SportCar newSportCar = new SportCar(noOfPassenger111, model111, make111);
				newSportCar.display();
				break;
		default:System.out.println("Sorry wrong input");
				break;
		}
		scMain.close();
	}
}
