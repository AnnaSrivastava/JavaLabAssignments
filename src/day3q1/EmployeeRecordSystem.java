package day3q1;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day3
 * Class: EmployeeRecordSystem
 * Description: class to implement Employee Records using ArrayList, 
 * Created On:29 July 2021
 * @author Ananya Srivastava
 *	
 */
//Import for Scanner and ArrayList
import java.util.*;

//Base class to implement getWeeklySalary, setRate, display
abstract class Employee{
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

//tester class
public class EmployeeRecordSystem {
	public static void main(String[] args) {
		 List<Employee> arrEmployees = new ArrayList<Employee>();
		 arrEmployees.add(new CommissionEmployee("abc","e101", 20, 45));
		 arrEmployees.add(new HourlyEmployee("sss","e102", 20, 45));
		 arrEmployees.add(new CommissionEmployee("xyz","e103", 10, 43));
		 arrEmployees.add(new SalaryEmployee("xcx","e104", 45));
		 arrEmployees.add(new SalaryEmployee("yup","e105", 10 ));
		 arrEmployees.add(new HourlyEmployee("mnb","e106", 13, 12));
		 arrEmployees.add(new CommissionEmployee("fff","e107", 13, 12));
		 arrEmployees.add(new HourlyEmployee("oui","e108", 10, 43));
		 arrEmployees.add(new SalaryEmployee("ryi","e109", 12));
		 
		 Scanner scMain = new Scanner(System.in);
		 
		 for(int i=0;i<arrEmployees.size();i++) {
			 System.out.print("|"+i+"|");
			 arrEmployees.get(i).display();
		 }
		 while(true) {
			 System.out.println("1) get the weekly salary of any employee\r\n"
			 		+ "2) set the rate of any employee\r\n" + 
			 		"3) increase salary of particular employee type by a percentage\r\n"+
			 		"0) exit");
			 int choice = scMain.nextInt();
			 switch(choice) {
			 case 1:System.out.println("Enter Sno of employee:");
			        int sno = scMain.nextInt();
			        System.out.println(arrEmployees.get(sno).getWeeklySalary());
			        break;
			 case 2:System.out.println("Enter Sno of employee:");
		        	int sno1 = scMain.nextInt();
		        	System.out.println("Enter new rate:");
		        	int rate = scMain.nextInt();
		        	arrEmployees.get(sno1).setRate(rate);
		        	arrEmployees.get(sno1).display();
		        	break;
			 case 3:System.out.println("1) Increase the salary of Commission Employees\r\n"
				 		+ "2) Increase the salary of Hourly Employees\r\n" + 
				 		"3) Increase the salary of Salary Employees\r\n");
	        		int empType = scMain.nextInt();
	        		System.out.println("Enter % increase:");
	        		int increase = scMain.nextInt();
	        		switch(empType) {
	        		//increase rate of commission employees
	        		case 1:for(Employee emp:arrEmployees) {
	        					if(emp instanceof CommissionEmployee) {
	        						emp.increaseRate(increase);
	        						emp.display();
	        					}
	        				}
	        				break;
	        				
	        		//increase rate of hour based employees
	        		case 2:for(Employee emp:arrEmployees) {
    						if(emp instanceof HourlyEmployee) {
    							emp.increaseRate(increase);
    							emp.display();
    							}
    						}
    						break;
    						
    				//increase rate of salary employees
	        		case 3:for(Employee emp:arrEmployees) {
							if(emp instanceof SalaryEmployee) {
								emp.increaseRate(increase);
								emp.display();
								}
							}
							break;
	        		default:System.out.println("Wrong Input");
	        		}
	        		break;
			 case 0:scMain.close();
			 		System.exit(0);
			 		break;
			 default:System.out.println("Sorry! Wrong input. Try again");
			 }
		 }
	}
}
