package day4;

import java.io.*;

/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day4
 * Class: SerEmployee
 * Description: serialize Employee object
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
class Address implements Serializable{
	private static final long serialVersionUID = 2505527100891438924L;
	private String house;
	private String sector;
	private String town;
	private String city;
	private int pIN;
	
	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPIN() {
		return pIN;
	}

	public void setPIN(int pIN) {
		this.pIN = pIN;
	}

	Address(String house, String sector, String town, String city, int pIN){
		this.house = house;
		this.sector = sector;
		this.town = town;
		this.city = city;
		this.pIN = pIN;
	}
}
class Employee implements Serializable{
	private static final long serialVersionUID = -8369402016519031760L;
	private String name;
	private String id;
	private Address address;
	private transient double salary;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	Employee(String name, String id, Address address, double salary){
		this.name = name;
		this.address = address;
		this.id = id;
		this.salary = salary;
	}
	public void display() {
		System.out.println(name+"---"+id+"---"+salary);
		System.out.println("Address:"+address.getHouse()+"---"+address.getSector()+"---"+address.getTown()
							+"---"+address.getCity()+"---"+address.getPIN());
		return;
	}
}
public class SerEmployee {
	public static void main(String[] args) {
		Address address = new Address("A-106", "Tower A", "Prateek Royale", "Ghaziabad", 201012);
		Employee employee = new Employee("Ananya","s101", address, 2000);
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("demo.txt")));

			oos.writeObject(employee);
			System.out.println("ser is done");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
//   }	
		
	}//end-of-main
}//end-of-class
