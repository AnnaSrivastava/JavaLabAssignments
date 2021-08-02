package day4;
/**
 * 
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: ReadWriteIOByte
 * Description: class to read file in byte format and write to command prompt in byte format and formatted output
 * Created On:30 July 2021
 * @author Ananya Srivastava
 *	
 */
//import java.io.*;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;


public class ReadWriteIOByte {
	static void readWrite(FileInputStream fr) throws IOException {
		try {
			//read in Byte format using Java 6
		fr = new FileInputStream("C:\\Users\\ve00ym261\\Desktop\\Java Eclipse WorkSpace\\lab assignment\\src\\day4\\hello.txt");
		 int c;
		 
		//Write using byte format
		 System.out.print("Byte Format:");
         String ss="";
         byte b[] ;
         while ((c = fr.read()) != -1) {
        	 ss += (char)c;
         }
         b = ss.getBytes();
         System.out.println(b);
		 //write using formatted output
//         fr = new FileInputStream("C:\\Users\\ve00ym261\\Desktop\\Java Eclipse WorkSpace\\lab assignment\\src\\day4\\hello.txt");
         System.out.print("Formatted Output:");
//         while ((c = fr.read()) != -1) {
//             System.out.print((char)c);
//         }
         System.out.println(ss);
         System.out.println();
         
		}
		catch(IOException IOex) {
			System.out.println(IOex.getMessage());
		}
		catch(Exception ex) {
			  ex.printStackTrace(); 
		}
		
	}
	
	
	public static void main(String[] args) {
		try
	    {
			FileInputStream fr = null;
			readWrite(fr);
	    }
		 catch(IOException  e) { 
		      e.printStackTrace(); 
		 }
		
		
	}//end-of-main()
}//end-of-class ReadWriteIOByte
