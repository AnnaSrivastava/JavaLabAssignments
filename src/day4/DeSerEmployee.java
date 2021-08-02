package day4;
/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: DeSerEmployee
 * Description: deserialize Employee object
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
import java.io.*;
public class DeSerEmployee {
	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("demo.txt")));

			Employee employee=(Employee) ois.readObject();
			employee.display();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
