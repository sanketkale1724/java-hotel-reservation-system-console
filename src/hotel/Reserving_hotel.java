package hotel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Reserving_hotel {
	static ArrayList<person> customer=new ArrayList();
	
	//static int avelabl = 20;
	static int single=15,Double=11,Triple=9;
	
public static void Hotel_Booking() throws IOException{
	loadcustomerdata();
	Scanner sc=new Scanner(System.in);
	boolean bookhotel=true;
	while(bookhotel) {
		System.out.println("1.Book hotel");
		System.out.println("2.Availablility Room");
		System.out.println("3.Search Booking");
		System.out.println("4.Edit Booking");
		System.out.println("5.Delete Booking");
		System.out.println("6.Exit");
		System.out.println("Enter your choise");
		int choise=sc.nextInt();
		Choise choose=new Choise();
		
		if(choise==choose.Book_hotel) {
			addCustomer();
		}
		else if(choise==choose.Availabile_room) {
			Avalibility();
		}
		else if(choise==choose.Search_customer) {
			System.out.println("Enter Customer Name");
			sc.nextLine();
			String search=sc.nextLine();
			Searchcustomer(search);
		}
		else if(choise==choose.Delete_Customer_Details) {
			System.out.println("Enter Customer Name");
			sc.nextLine();
			String delete=sc.nextLine();
			Deletecustomer(delete);
		}
		else if(choise==choose.Edit_customer) {
			System.out.println("Enter Customer Name");
			sc.nextLine();
			String edit=sc.nextLine();
			Editcustomer(edit);	
		}
		else if(choise==choose.Exit) {
			
			 File file=new File("/Hotel_Reservation_System/src/hotel/Customer_info.csv");
			 FileWriter filewriter=new FileWriter(file,false);
			 BufferedWriter bufferwriter=new BufferedWriter(filewriter);
			 for(person per:customer) {
				
				bufferwriter.write(per.name+","+per.age+","+per.gender+","+per.phone+","+per.ID_no+","+per.room_type+","+per.no_days+"\n");
				
			 }
			 bufferwriter.close();
				filewriter.close();
				file=null;
				 bookhotel=false;
				 System.out.println("Program has bben closed....");
		}
		
	}
	for(person p1:customer) {
		System.out.println("Name:"+p1.name);
		System.out.println("Age"+p1.age);
		System.out.println("Gender"+p1.gender);
	}
	
}
public static void addCustomer()
{
	//avelabl--;
	single--;
	Double--;
	Triple--;
	
	Scanner sc=new Scanner(System.in);
	person per=new person();
	System.out.println("Enter Your Name:");
	per.name=sc.nextLine();
	System.out.println("Enter Your Age:");
	per.age=sc.nextLine();
	System.out.println("Gender (Male/Female:)");
	per.gender=sc.nextLine();
	System.out.println("Phone Number:");
	per.phone=sc.nextLine();
	System.out.println("ID Proof:(Adhar/PAN)");
    per.ID=sc.nextLine();
    System.out.println("ID Number:");
    per.ID_no=sc.nextLine();
    System.out.println("Enetr the number of Dys of Booking");
    per.no_days=sc.nextInt();
    System.out.println("Type of Room:(1.Single Occupancy,2.Double Occupancy,3.Triple Room )");
    per.room_type=sc.nextLine();
    System.out.println("Select type of Room:");
    int Room_type=sc.nextInt();
    Room_choise choise=new Room_choise();
    if(Room_type==choise.Single_Occupancy)
    {
    	int price=per.no_days*1000;
    	System.out.println("Price of Rooom :"+price);
    	
    }
    else if(Room_type==choise.Double_Occupancy) {
    	
    	int price=per.no_days*1500;
    	System.out.println("Price of Room  :"+price);
    	
    }
    else if(Room_type==choise.Duluxe_Room) {
    	int price=per.no_days*2000;
    	System.out.println("Price of Room  :"+price);
    	
    }
    
    System.out.println("             HOTEL SK             ");
    System.out.println("---------------------------------------");
    System.out.println("Name  : "+per.name);
    System.out.println("Phone : "+per.phone);
    System.out.println("Room Type : "+per.room_type);
    System.out.println("No of Days : "+per.no_days+"\n");
    
    System.out.println("Your room has been booked...\n");
    customer.add(per);
    
}

public static void Avalibility() {
  //  System.out.println("avelable Rooms : "+ avelabl);
	Scanner sc=new Scanner(System.in);
	System.out.println("1.Single Occupancy");
	System.out.println("2.Double Occupancy");
	System.out.println("3.Triple Occupancy");
	int choise=sc.nextInt();
	if(choise==1) {
		System.out.println("Available Rooms : "+ single);
		
	}
	else if(choise==2) {
		System.out.println("Available Rooms : "+ Double);
	}
	else if(choise==3) {
		System.out.println("Available Rooms : "+ Triple);
	}
	
    System.out.println("");
}
 public static void Searchcustomer(String name) {
	Scanner sc=new Scanner(System.in);
	for(person per:customer) {
		if(per.name.equalsIgnoreCase(name)) {
			System.out.println("Name : "+per.name);
			System.out.println("Age : "+per.age);
			System.out.println("Phone No : "+per.phone);
			System.out.println("Room Type : "+per.room_type);
			System.out.println("No of Days : "+per.no_days+"\n");
			
			return;
		}
	}
	System.out.println("Customer not found");
}
 
 
  public static void Deletecustomer(String name) {
	//  avelabl++;
	  single++;
		Double++;
		Triple++;
	Scanner sc=new Scanner(System.in);
	Iterator<person> per=customer.iterator();
	while(per.hasNext()) {
		person per2=per.next();
		if(per2.name.equalsIgnoreCase(name)) {
			per.remove();
			System.out.println("Customer"+per2.name+" has been removed"+"\n");
			break;
		}
	}
	
}
  public static void Editcustomer(String name) {
		Scanner sc=new Scanner(System.in);
		for(person per:customer) {
			if(per.name.equalsIgnoreCase(name)) {
				System.out.println("Enter new Customer Name");
				per.name=sc.nextLine();
				System.out.println("Enter new Your Age:");
				per.age=sc.nextLine();
				System.out.println("Gender (Male/Female:)");
				per.gender=sc.nextLine();
				System.out.println("New Phone Number:");
				per.phone=sc.nextLine();
				System.out.println("ID Proof:");
			    per.ID=sc.nextLine();
			    System.out.println("ID Number:");
			    per.ID_no=sc.nextLine();
			    System.out.println("Enetr the number of Dys of Booking");
			    per.no_days=sc.nextInt();
			    System.out.println("Type of Room:(1.Single Occupancy,2.Double Occupancy,3.Duluxe Room )");
			    per.room_type=sc.nextLine();
			    System.out.println("Select type of Room:");
			    int Room_type=sc.nextInt();
			    Room_choise choise=new Room_choise();
			    if(Room_type==choise.Single_Occupancy)
			    {
			    	System.out.println("Price of Rooom = 1000");
			    }
			    else if(Room_type==choise.Double_Occupancy) {
			    	System.out.println("Price of Room  = 2000");
			    }
			    else if(Room_type==choise.Duluxe_Room) {
			    	System.out.println("Price of Room  = 3500");
			    }
				System.out.println("Customer has been updated"+"\n");
				return;
			}
		}
	}
  
  
   public static void loadcustomerdata()throws IOException{
	File file=new File("/Hotel_Reservation_System/src/hotel/Customer_info.csv");
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	String List="";
	while((List=br.readLine())!=null)
	{
		person p1=new person();
		String[] customerdataArray=List.split(",");
		if(customerdataArray.length>6)
		{
		p1.name=customerdataArray[0];
		p1.age=customerdataArray[1];
			p1.gender=customerdataArray[2];
			p1.phone=customerdataArray[3];
			p1.ID_no=customerdataArray[4];
			p1.room_type=customerdataArray[5];
		//	p1.no_days=customerdataArray[6];
			customer.add(p1);
		}
	}
	
	
}
   
 


}
