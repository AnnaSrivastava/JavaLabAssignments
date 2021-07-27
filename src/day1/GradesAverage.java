package day1;

import java.util.Scanner;
//Q3. Write a program called GradesAverage, which prompts user for the number of students, reads it
//from the keyboard, and saves it in an int variable called numStudents. It then prompts user for the
//grades of each of the students and saves them in an int array called grades. Your program shall
//check that the grade is between 0 and 100. A sample session is as follow:
//Enter the number of students: 3
//Enter the grade for student 1: 55
//Enter the grade for student 2: 108
//Invalid grade, try again...
//Enter the grade for student 2: 56
//Enter the grade for student 3: 57
//The average is: 56.0

public class GradesAverage {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of students:");
		int numStudents = sc.nextInt();
		int sum = 0;
		int grades[] = new int[numStudents];
		for(int i=0;i<numStudents;i++) {
			System.out.print("Enter the grade of student "+(i+1)+":");
			grades[i] = sc.nextInt();
			sum += grades[i];
			if(grades[i]<0 || grades[i]>100) {
				System.out.println("Invalid grade, try again...");
				sum -= grades[i--];
			}
		}
		System.out.println("The average is: "+((double)sum/numStudents));
		sc.close();
	}
}
