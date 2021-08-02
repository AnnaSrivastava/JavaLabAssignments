package day3q2;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day3q2
 * Class: PaymemtSystem
 * Description:  
 * Created On:31 July 2021
 * @author Ananya Srivastava
 *	
 */
//Import for Scanner
import java.util.Scanner;
//Base class to implement getWeeklySalary, setRate, display
interface Payable{
	double getPayment();
}
class Invoice implements Payable{
	private String partNum;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	Invoice(String partNum, String partDescription, int quantity, double pricePerItem){
		this.partNum = partNum;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}
	public double getPayment() {
		return pricePerItem*quantity;
	}
	public void display() {
		System.out.println("Invoice:"+partNum+"---"+partDescription+"---"+quantity+"---"+pricePerItem);
	}
}
abstract class Employee implements Payable{
	 private String name;
	 private String eid;
	
	 //Constructor for base class
	Employee(String name, String eid){
		 this.name = name;
		 this.eid = eid;
	 }
	public String getName() {
		return name;
	}
	public String getEid() {
		return eid;
	}
	//abstract functions to be implemented and overridden by derived class
	abstract double getWeeklySalary();
	abstract void setRate(double x);
	abstract void display();
	abstract void increaseRate(int x);
	
}
//class for salaried employee has weeklyRate
class SalaryEmployee extends Employee{
	private double weeklyRate;
	
	//Constructor
	SalaryEmployee(String name, String eid, double weeklyRate){
		super(name, eid);
		this.weeklyRate = weeklyRate;
	}
	public double getWeeklySalary() {
		return weeklyRate;
	}
	public double getPayment() {
		this.display();
		return this.getWeeklySalary();
	}
	public void setRate(double weeklyRate) {
		this.weeklyRate = weeklyRate;
		System.out.println("Weekly rate set!");
		return;
	}
	public void increaseRate(int increase) {
		this.setRate(weeklyRate*((double)(100+increase)/100));
	}
	public void display() {
		System.out.println("Salary:"+super.getEid()+"---"+super.getName()+"---"+weeklyRate);
		return;
	}
}
//class for Hour-based employee has working hours and hour rate
class HourlyEmployee extends Employee{
	private int hoursWorkedPerWeek;
	private double hourlyRate;
	
	//Constructor
	HourlyEmployee(String name, String eid, double hourlyRate, int hoursWorkedPerWeek){
		super(name, eid);
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
		this.hourlyRate = hourlyRate;
	}
	public double getWeeklySalary() {
		return hourlyRate*hoursWorkedPerWeek;
	}
	public double getPayment() {
		this.display();
		return this.getWeeklySalary();
	}
	public void setRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
		System.out.println("Hourly rate set!");
		return;
	}
	public void increaseRate(int increase) {
		this.setRate(hourlyRate*((double)(100+increase)/100));
	}
	public void display() {
		System.out.println("Hourly:"+super.getEid()+"---"+super.getName()+"---"+hourlyRate+"---"+hoursWorkedPerWeek);
		return;
	}
}
// class for commissioned employees has percentage cut and weekly sales
class CommissionEmployee extends Employee{
	private double percentage;
	private int weeklySale;
	
	//Constructor
	CommissionEmployee(String name, String eid, double percentage, int weeklySale){
		super(name, eid);
		this.percentage = percentage;
		this.weeklySale = weeklySale;
	}
	public double getWeeklySalary() {
		return (percentage*weeklySale)/100;
	}
	public double getPayment() {
		this.display();
		return this.getWeeklySalary();
	}
	public void setRate(double percentage) {
		this.percentage = percentage;
		System.out.println("Percentage set!");
		return;
	}
	public void increaseRate(int increase) {
		this.setRate(percentage*((double)(100+increase)/100));
	}
	public void display() {
		System.out.println("Commission:"+super.getEid()+"---"+super.getName()+"---"+percentage+"---"+weeklySale);
		return;
	}
}
public class PaymentSystem {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		Invoice invoice = new Invoice("s101","Lenevo Mouse", 2, 400.0);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Ananya", "e101", 20, 45);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Shreya", "s201", 32, 50);
		SalaryEmployee salaryEmployee = new SalaryEmployee("Lana", "s765",67);
		
		invoice.display();
		commissionEmployee.display();
		hourlyEmployee.display();
		salaryEmployee.display();
		
		System.out.println("1) Select Invoice");
		System.out.println("2) Select Commission Employee");
		System.out.println("3) Select Hourly Employee");
		System.out.println("4) Select Salary Employee");
		
		int choice = scMain.nextInt();
		switch(choice) {
		case 1:System.out.println("1)To get payment");
				int invoiceChoice = scMain.nextInt();
				switch(invoiceChoice) {
					case 1:System.out.println(invoice.getPayment());
						   break;
					default:System.out.println("Sorry! Wrong Input");
				}
				break;
		case 2:System.out.println("1)To get payment");
			   System.out.println("2)To get salary");
			   System.out.println("3)To set salary");
			   int commissionEmployeeChoice = scMain.nextInt();
			   switch(commissionEmployeeChoice) {
			   		case 1:System.out.println(commissionEmployee.getPayment());
			   				break;
			   		case 2:System.out.println(commissionEmployee.getWeeklySalary());
	   						break;
			   		case 3:System.out.println("Enter new rate:");
			   		       double newRate = scMain.nextDouble();
			   		       commissionEmployee.setRate(newRate);
			   		       break;
			   		default:System.out.println("Sorry! Wrong Input");       
			   }break;
		case 3:System.out.println("1)To get payment");
		   		System.out.println("2)To get salary");
		   		System.out.println("3)To set salary");
		   		int hourlyEmployeeChoice = scMain.nextInt();
		   		switch(hourlyEmployeeChoice) {
		   			case 1:System.out.println(hourlyEmployee.getPayment());
		   					break;
		   			case 2:System.out.println(hourlyEmployee.getWeeklySalary());
							break;
		   			case 3:System.out.println("Enter new rate:");
		   		       		double newRate = scMain.nextDouble();
		   		       		hourlyEmployee.setRate(newRate);
		   		       		break;
		   			default:System.out.println("Sorry! Wrong Input");       
		   }break;
		case 4:System.out.println("1)To get payment");
   				System.out.println("2)To get salary");
   				System.out.println("3)To set salary");
   				int salaryEmployeeChoice = scMain.nextInt();
   				switch(salaryEmployeeChoice) {
   					case 1:System.out.println(salaryEmployee.getPayment());
   							break;
   					case 2:System.out.println(salaryEmployee.getWeeklySalary());
   							break;
   					case 3:System.out.println("Enter new rate:");
   		       				double newRate = scMain.nextDouble();
   		       				salaryEmployee.setRate(newRate);
   		       				break;
   					default:System.out.println("Sorry! Wrong Input");       
   				}break;
		default:System.out.println("Sorry! Wrong Input");
		}
		scMain.close();
	}
}
