package day1;
//Q1. Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n), where
//F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like:
//The first 20 Fibonacci numbers are:
//1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
//The average is 885.5

public class q1 {
	public static void main(String args[]){
		int fib[] = new int[20];
		fib[0]=1;
		fib[1]=1;
		int sum = fib[0]+fib[1];
		for(int i=2;i<20;i++)
		{
			fib[i] = fib[i-1] + fib[i-2];
			sum += fib[i];
		}
		for(int i=0;i<20;i++){
			System.out.print(fib[i]+" ");
		}
		System.out.println("\nThe average is:"+((double) sum/20));
		
	}

}
