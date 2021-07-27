package day2;
/**
 * Code Is Faulty
 * Documentation incomplete
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day2
 * Class: Overloading
 * Description: 
 * Created On:26 July 2021
 * @author Ananya Srivastava
 *	
 */

import java.util.Scanner;
class Student{
	private String name;
	private String id;
	private Double grade;
	
	Student(String name, String id, double grade){
		this.name = name;
		this.id= id;
		this.grade = grade;
	}
	Student(String name, String id){
		//how to call constructors inside other constructors
		this(name, id, 0.0);
	}
	Student(String id){
		//constructor chaining. always the first statement in the block it is used.
		this("", id, 0.0);
	}
	Student(){
		
	}
	public void display() {
		System.out.println(name+"--"+id+"--"+grade);
	}
	public void display(int year) {
		System.out.println(name+"--"+id+"--"+grade+"--"+year);
	}
	
}

//application class
public class Overloading {
	public static void main(String[] args) {
		
		Scanner scMain = new Scanner(System.in);
		Student student = new Student();
		int grade=-1, year=-1;
		String id="-", name="";
		while(true) {
			System.out.println("‘1’ – to create a Student object.\r\n" + 
					"‘2’ – to display the student info.");
		int choice = scMain.nextInt();
		
		
		switch(choice) {
		//is this logic okay??
			case 1:System.out.println("‘1’ – to only provide ID.\n" + 
					"‘2’ – to give ID and name.\n"+
					"‘3’ – to give ID, name, grade.\n");
					int noOfInputs = scMain.nextInt();
					switch(noOfInputs) {
					case 1:System.out.println("ID:");
							id = scMain.next();
							student = new Student(id);
							break;
					case 2:System.out.println("ID:");
							id = scMain.next();
							System.out.println("Name:");
							name = scMain.next();
							student = new Student(id,name);
							break;
					case 3:System.out.println("ID:");
							id = scMain.next();
							System.out.println("Name:");
							name = scMain.next();
							System.out.println("Grade:");
							grade = scMain.nextInt();
							student = new Student(id,name, grade);
							break;
					default:System.out.println("OOPS");
					}
					break;
			case 2:System.out.println("‘0’ – to not provide any year.\n" + 
					"‘1’ – to provide a year.\n");
					int yearOrNot = scMain.nextInt();
					switch(yearOrNot) {
					case 0:student.display();
							break;
					case 1:System.out.println("Year:");
							year = scMain.nextInt();
							student.display(year);
							break;
					default:System.out.println("OOPS");
					}break;
			default:System.out.println("Wrong Input");
					scMain.close();
				}
		}
		
		
		
	}//main end
}//class end
