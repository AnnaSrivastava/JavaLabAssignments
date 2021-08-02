package day4;
/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: evenOddQ6
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
import java.util.*;
class IntGreaterThanN extends Exception{
	private static final long serialVersionUID = -1568903466407610141L;
	public IntGreaterThanN(int n) {
        super("Number can’t be greater than ["+n+"]");
    }
}
public class EvenOddQ6 {
	static void isGreaterThanN(int num, int n) throws IntGreaterThanN{
		if(num>n)
			throw new IntGreaterThanN(n);
		else 
			return;
	}
	public static void main(String[] args) {
		
		while(true)
		{
			Scanner scMain = new Scanner(System.in);
			int n =122;
			System.out.println("Please enter a number or enter ‘-1’ if you want to quit");
			try {
			int num = scMain.nextInt();
			isGreaterThanN(num, n);
			switch(num) {
				case -1:scMain.close();
						System.exit(0);
						break;
				default:boolean isEven = (num % 2 == 0);
						String outString = (isEven) ? "You have entered an even number" : "You have entered an odd number";
						System.out.println(outString);
			}
			}
			catch(InputMismatchException ex) {
				System.out.println("You must enter an integer");
			}
			catch(IntGreaterThanN ex) {
				 System.out.println(ex);
			}
		}
	}
}

