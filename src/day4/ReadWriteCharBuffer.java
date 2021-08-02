package day4;
/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: ReadWriteCharBuffer
 * Description: class to read from command prompt  and Write to a file using character buffer
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
import java.io.*;  
public class ReadWriteCharBuffer {
	static void readWrite(BufferedReader reader) throws IOException{
			reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your name: ");
		    String name = reader.readLine();
		    FileWriter writer = new FileWriter("C:\\Users\\ve00ym261\\Desktop\\Java Eclipse WorkSpace\\lab assignment\\src\\day4\\hello2.txt");  
		    BufferedWriter buffer = new BufferedWriter(writer);  
		    buffer.write(name);  
		    buffer.close();  
		    System.out.println("Success");  
	}
	public static void main(String[] args) {
		try
	    {
			BufferedReader reader = null;
			readWrite(reader);
	    }
		 catch(IOException  e) { 
		      e.printStackTrace(); 
		 }
}
}
