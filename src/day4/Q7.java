package day4;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: Q7
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
class throwException extends Exception{
	private static final long serialVersionUID = -1906947990591531471L;
	throwException() throws IOException, InputMismatchException{
		System.out.println("throw Exception");
	}
}
public class Q7 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			throwException throwExc = new throwException();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
