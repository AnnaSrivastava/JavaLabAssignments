package day6;

import java.util.*;

/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day6
 * Class: Q1
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 */
public class Q1 {
	public static void main(String[] args) {
		 Set<String> hashSet = new HashSet<String>();
		 boolean var1 = hashSet.add("fyf");
		 System.out.println(var1);
		 hashSet.addAll(Arrays.asList(new String[] { "gsehg","huwu","yuyuy" }));
		 hashSet.remove("geshg");
		 hashSet.contains("guyt");
		 hashSet.toArray();
		 hashSet.removeAll(Arrays.asList(new String[] { "gsehg","huwu","yuyuy" }));
		 hashSet.clear();
		 hashSet.size();
		 hashSet.iterator();
		 
		 List<String> l1 = new ArrayList<String>();
		 boolean var2 = l1.add("gdg");
		 System.out.println(var2);
		 l1.addAll(Arrays.asList(new String[] { "gsehg","huwu","yuyuy" }));
		 l1.remove("huwu");
		 l1.toArray();
		 l1.contains("gdg");
		 l1.removeAll(Arrays.asList(new String[] { "gsehg","huwu","yuyuy" }));
		 l1.clear();
		 l1.size();
		 l1.iterator();
		 
	}
}
