package day6;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day6
 * Class: Q2
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
import java.util.*;

public class Q2 {
	static String getString() throws IOException {
		String ss="";
		try {
			FileInputStream fr = new FileInputStream("C:\\Users\\ve00ym261\\Desktop\\Java Eclipse WorkSpace\\lab assignment\\src\\day6\\story.txt");
		 int c; 
         while ((c = fr.read()) != -1) {
        	 ss += (char)c;
         }
     	fr.close();
		}
		catch(IOException IOex) {
			System.out.println(IOex.getMessage());
		}
		catch(Exception ex) {
			  ex.printStackTrace(); 
		}
	
		return ss;
		}
  public static void main(String[] args) {
	  Map<String,Integer> mp=new TreeMap<>();
	String str="";
	try {
		str = getString();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      String arr[]=str.split(" ");


      for(int i=0;i<arr.length;i++)
      {
          
          if(mp.containsKey(arr[i]))
          {
              mp.put(arr[i], mp.get(arr[i])+1);
          }
          else
          {
              mp.put(arr[i],1);
          }
      }
      
 
      for(Map.Entry<String,Integer> entry: mp.entrySet())
      {
          System.out.println(entry.getKey()+ " appear "+entry.getValue()+" times");}
  	  }
}
