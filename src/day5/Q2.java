package day5;
import java.util.Random;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day5
 * Class: Q2
 * Description: Implement threads using Runnable and generate the random numbers and print the sum afterwards using main thread
 * Created On:04 August 2021
 * @author Ananya Srivastava
 */


//class to implement Runnable and generate random numbers
class RandomSumThread implements Runnable {
	private int sum;
	
	//constructor
	RandomSumThread(int sum) {
		this.sum = sum;	
	}
	
	//overriding run method
	@Override
	public void run() {
		this.addRandomVal();
		
	}
	
	//getter for sum
	public int getSum() {
		return sum;
	}

	//setter for sum
	public void setSum(int sum) {
		this.sum = sum;
	}

	//method to generate random number and add to sum
	private void addRandomVal() {
		Random random = new Random();
		int num = random.nextInt(10) + 1;
		System.out.println("Number generated: " + num);
			this.sum += num;
	}
}

//tester class
public class Q2 {
	//tester method
	public static void main(String[] args) {
		RandomSumThread randomSumThread = new RandomSumThread(0);
		Thread thread1 = new Thread(randomSumThread);
		Thread thread2 = new Thread(randomSumThread);
		Thread thread3 = new Thread(randomSumThread);
		Thread thread4 = new Thread(randomSumThread);
		Thread thread5 = new Thread(randomSumThread);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
	        thread1.join();
	        thread2.join();
	        thread3.join();
	        thread4.join();
	        thread5.join();
	    } catch (InterruptedException e) {
	    	System.out.println("Interruption Occured");
	        e.printStackTrace();
	    }
		System.out.println("Total Sum: " + randomSumThread.getSum());
	}//end-of-main
}//end-of-class
