package day5;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day5
 * Class: Q1
 * Description: Implement threads using Runnable and execute them concurrently
 * Created On:04 August 2021
 * @author Ananya Srivastava
 */
//Thread class implementing Runnable
class SampleThread implements Runnable {
	private String threadName;
	private Thread thread;
	
	//Constructor
	 SampleThread(String threadName) {
		this.threadName = threadName;
		thread = new Thread(this, this.threadName);
		System.out.println("Thread Started: " + threadName);
		thread.start();
	}

	 //overriding run method of Runnable interface
	@Override
	public void run() {
		try {
			for (int i = 0; i <= 100; i++) {
				System.out.println(threadName + ": " + i);
				Thread.sleep(50); 
			}
		} catch (Exception e) {
			System.out.println("Interruption occured in " + threadName);
		}
		System.out.println("Thread Terminated:" + threadName);
	}

}

//tester class
public class Q1 {
	//tester method + SupressWarning annotations for unused variables
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SampleThread sampleThread1 = new SampleThread("thread #1");
		SampleThread sampleThread2 = new SampleThread("thread #2");
		SampleThread sampleThread3 = new SampleThread("thread #3");
		
//		sampleThread1.run();
//		sampleThread2.run();
//		sampleThread3.run();
	}//end-of-main
}//end-of-class
