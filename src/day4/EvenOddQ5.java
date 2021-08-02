package day4;
/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: evenOddQ5
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
import java.util.*;
class IntGreaterThan100 extends Exception{
	private static final long serialVersionUID = -1568903466407810141L;
	public IntGreaterThan100() {
        super("Integer Greater Than 100!");
    }
}
public class EvenOddQ5 {
	static void isGreaterThan100(int num) throws IntGreaterThan100{
		if(num>100)
			throw new IntGreaterThan100();
		else 
			return;
	}
	public static void main(String[] args) {
		
		while(true)
		{
			Scanner scMain = new Scanner(System.in);
			System.out.println("Please enter a number or enter ‘-1’ if you want to quit");
			try {
			int num = scMain.nextInt();
			isGreaterThan100(num);
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
			catch(IntGreaterThan100 ex) {
				 System.out.println(ex);
			}
		}
	}
}

