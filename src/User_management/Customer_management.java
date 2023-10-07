package User_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Customer_management {
	static ArrayList<customer> cust=new ArrayList<>();
	static {
		try {
			readdata();
		}
		catch(IOException e){
			 e.printStackTrace();
		}
	}
	//static ArrayList<customer> cust=new ArrayList<>();
public static void customerinfo()throws IOException {
	//readdata();
	Scanner sc=new Scanner(System.in);
	boolean runcode=true;
	while(runcode) {
		System.out.println("1.Add Customer");
		System.out.println("2.Update Customer");
		System.out.println("3.Delete Customer");
		System.out.println("4.Search Customer");
		System.out.println("5.Exit");
		
		int number=sc.nextInt();
		Choise choise=new Choise();
		if(number==choise.Exit) {
			
			File file=new File("/Hotel_Reservation_System/src/User_management/customer.csv");
			FileWriter filewriter=new FileWriter(file,false);
			BufferedWriter bufferwriter=new BufferedWriter(filewriter);
			for(customer c1:cust) {
				bufferwriter.write(c1.name+","+c1.email+","+c1.Password+"\n");
				
			}
			bufferwriter.close();
			filewriter.close();
			file=null;
			
			
			System.out.println("Program Closed");
			runcode=false;
		}
		else if(number==choise.Add_customer)
		{
			adduser();
		}
		else if(number==choise.Update_customer)
		{
			System.out.println("Enter user name:");
			sc.nextLine();
			String edit=sc.nextLine();
			update_user(edit);
		}
		else if(number==choise.Search_customer) {
			System.out.println("Enter user name:");
			sc.nextLine();
			String serc=sc.nextLine();
			searchuser(serc);
		}
		else if(number==choise.Delete_customer) {
			System.out.println("Enter user name:");
			sc.nextLine();
			String delete=sc.nextLine();
			Delete_customer(delete);
		}
		
		
	}
	for(customer c1:cust) {
		System.out.println("Name:"+c1.name);
		System.out.println("Email:"+c1.email);
		
	}
}
public static void adduser()
{
	 Scanner sc=new Scanner(System.in);
	customer c1=new customer();
	System.out.println("Enter Name:");
     c1.name=sc.nextLine();
	System.out.println("Enter Email_id:");
	c1.email=sc.nextLine();
	System.out.println("Enter Password:");
	c1.Password=sc.nextLine();
	System.out.println("confirm password:");
	c1.com_pass=sc.nextLine();
	
    
    System.out.println("Name:"+c1.name);
    System.out.println("Email_ID:"+c1.email);
    System.out.println("Password:"+c1.Password);

    cust.add(c1);
}
public static void update_user(String name) {
	Scanner sc=new Scanner(System.in);
	for(customer c1:cust){
		if(c1.name.equalsIgnoreCase(name)) {
			System.out.println("Enter New Name:");
			c1.name=sc.nextLine();
			System.out.println("Enter New Email:");
			c1.email=sc.nextLine();
			System.out.println("new Password:");
			c1.Password=sc.nextLine();
			System.out.println("confirm Password");
			c1.com_pass=sc.nextLine();
		}
		System.out.println("user has been upadated");
		
	}
}
public static void searchuser(String name) {
	Scanner sc=new Scanner(System.in);
	for(customer c1:cust) {
		if(c1.name.equalsIgnoreCase(name)) {
			System.out.println("Name:"+c1.name);
			System.out.println("ID:"+c1.email);
			System.out.println("password:"+c1.Password);
			
			return;
		}
	}
	System.out.println("Customer not found..");
	}
public static void Delete_customer(String name) {
	Scanner sc=new Scanner(System.in);
	Iterator<customer> c1=cust.iterator();
	while(c1.hasNext())
	{
			customer user=c1.next();
			if(user.name.equalsIgnoreCase(name)) {
				c1.remove();
				System.out.println("Name "+user.name+" has been removed..");
				break;
	}
}
}
public static void readdata() throws IOException {
	File file=new File("/Hotel_Reservation_System/src/User_management/customer.csv");
	FileReader filereader=new FileReader(file);
	BufferedReader bufferedreader=new BufferedReader(filereader);
	String List="";
	while((List=bufferedreader.readLine())!=null) {
		customer c1=new customer();
		String[] customerdetail=List.split(",");
		if(customerdetail.length>2) {
			c1.name=customerdetail[0];
			c1.email=customerdetail[1];
			c1.Password=customerdetail[2];
			cust.add(c1);
		}
		
	}
	bufferedreader.close();
	filereader.close();
	file=null;
}
public static boolean validdatauserandpassword(String email,String Password) {
	
	Iterator<customer> customerIterator=cust.iterator();
	
	while(customerIterator.hasNext()) {
		
		customer c1=customerIterator.next();
		
		if(c1.email.equalsIgnoreCase(email) && c1.Password.equalsIgnoreCase(Password)) {
			return true;
		}
		
	}
	return false;
}

}
