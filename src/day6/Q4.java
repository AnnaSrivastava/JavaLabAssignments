package day6;
/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day6
 * Class: Q4
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
import java.io.*;
import java.util.*;

public class Q4 {
	public static void main(String[] args) {
		 Scanner scan;
		    File file = new File("C:\\Users\\ve00ym261\\Desktop\\Java Eclipse WorkSpace\\lab assignment\\src\\day6\\data.txt");
		    try {
		        scan = new Scanner(file);
		        double ans = Integer.MIN_VALUE;
		        while(scan.hasNextDouble())
		        {
		        	double db = scan.nextDouble();
		            if(db > ans)
		            	ans = db;
		        }
		        System.out.println(ans);

		    } catch (FileNotFoundException e1) {
		            e1.printStackTrace();
		    }
	}
}
