/**
Class Name: CST8284
Author Name: Yunting Yin
Date: Jun 19, 2021
**/

//user blueprint
public class User {
	private static int userNextId = 1000;
	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String address = "";
	private int age = 0;
	
	//constructor for id, firstName, lastName, address, age
	public User(int id, String firstName, String lastName, String address, int age) {
		this(firstName, lastName, address, age);
		setId(id);
	}
	
	//constructor for firstName, lastName, address, age
	public User(String firstName, String lastName, String address, int age) {
		this(firstName, lastName, address);
		this.setAge(age);
	}
	
	//constructor for firstName, lastName, address
	public User(String firstName, String lastName, String address) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		this.setAge(18);
		userNextId++;
		this.setId(userNextId);
	}
	
	//print the user(s)
	public String toString() {
		String user = "************ User id: " + this.getId() + 
					  "\n************ User name: " + this.getFirstName()+" " + this.getLastName() + 
					  "\n************ Age: "  + this.getAge() + 
					  "\n************ Address: " + this.getAddress() + "\n";
		return user;
	}
	
	//getter of id
	public int getId() {
		return id;
	}
	
	//getter of first name
	public String getFirstName() {
		return firstName;
	}
	
	//getter of last name
	public String getLastName() {
		return lastName;
	}
	
	//getter of address
	public String getAddress() {
		return address;
	}
	
	//getter of age
	public int getAge() {
		return age;
	}
	
	//setter of id
	public void setId(int id) {
		this.id = id;
	}
	
	//setter of first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//setter of last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//setter of address
	public void setAddress(String address) {
		this.address = address;
	}
	
	//setter of age
	public void setAge(int age) {
		this.age = age;
	}
}
