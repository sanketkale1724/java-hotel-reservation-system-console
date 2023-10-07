package Login_page;

import java.io.IOException;
import java.util.Scanner;

import User_management.Customer_management;
import hotel.Reserving_hotel;

public class login_page {
public static void main(String[] args) throws IOException{
	Scanner sc=new Scanner(System.in);
	boolean loginavailable=true;
	System.out.println(".......Login page.......");
	System.out.println("User ID : ");
	String id=sc.nextLine();
	System.out.println("Password : ");
	String pass=sc.nextLine();
	if(!Customer_management.validdatauserandpassword(id, pass)) {
		System.out.println("login failed..");
		return;
	}
	while(loginavailable) {
		System.out.println("\n1.User Management.");
		System.out.println("2.Hotel Booking.");
		System.out.println("3.Quit");
		System.out.println("\nEnter Your choise : ");
		int choise=sc.nextInt();
		if(choise==1) {
			Customer_management.customerinfo();
		}
		else if(choise==2) {
			Reserving_hotel.Hotel_Booking();
			
		}
		else if(choise==3) {
			loginavailable=false;
			System.out.println("Program Closed!!!");
		}
		
		
	}
	
}
}
