
package code;

import java.util.Random;
import java.util.Scanner;

public class Ticket {
	
	
	double discount;
	//String seat;
	String CL;
	String phone;
	String NAME;
	String id;
	//double COST;
	String flightNum;
	String request;
	boolean isWaiting;
public	static double firstMod = 2;
public	static double businessMod = 1.5;
	public static	double econMod = 1;
	public static double distance;
public static	double totalPrice;
	
	public Ticket(String name, String ID, String carriage, String pn, int disco, String flightN, int dist, String disability)
	{
		NAME = name;
		id = ID;
		CL = carriage;
		
		if(CL.equalsIgnoreCase("First")) 
			totalPrice = distance*firstMod;
		
		else if(CL.equalsIgnoreCase("Business"))
			totalPrice = distance*businessMod;
		
		else
			totalPrice = distance*econMod;
			
		phone = pn;
		discount = disco;
		//totalPrice = price;
	//	price = totalPrice;
		flightNum = flightN;
		request = disability;
		isWaiting = false;
		distance = dist;
	}
	
	/*public double getPrice()
	{
		double result;
		result = COST - discount;
		
		return result; 
	}*/
	
	public static void purchaseTicket() {
		
		String name, id, clss, pn, dis, flight;
		String fNum;
		int seatRow, seatCol;
		int disc, tPrice, dist;
		
		fNum = "0";
		
		Scanner scan = new Scanner(System.in);
		Scanner scanName = new Scanner(System.in);
		Scanner scanID = new Scanner(System.in);
		Scanner scanCL = new Scanner(System.in);
		Scanner scanPN = new Scanner(System.in);
		Scanner scanDisc = new Scanner(System.in);
		Scanner scantPrice = new Scanner(System.in);
		Scanner scanfNum = new Scanner(System.in);
		Scanner scanDist = new Scanner(System.in);
		Scanner scanDis = new Scanner(System.in);
		Scanner scanFlight = new Scanner(System.in);
		
		System.out.print("Please enter the following information: \nFlight (Liberator/Zero): " );
		flight = scanFlight.nextLine();
		System.out.print("Name: ");
		name = scanName.nextLine();
		System.out.print("ID: ");
		id = scanID.nextLine();
		System.out.print("Class: ");
		clss = scanCL.nextLine();
		System.out.print("Phone Number: ");
		pn = scanPN.nextLine();
		System.out.print("Discount: ");
		disc = scanDisc.nextInt();
		System.out.print("Distance: ");
		dist = scanDist.nextInt();
		System.out.print("Disability/Request: ");
		dis = scanDis.nextLine();
		
		if(flight.equalsIgnoreCase("liberator")) {
		Airplane.addTicketB52(name, id, clss, pn, disc, fNum, dist, dis);
		System.out.println("\nUpdating passenger list \n-------------------------------------------------------------\n-------------------------------------------------------------");
		
		Airplane.printB52();
		}
		
		
		if(flight.equalsIgnoreCase("zero")) {
		Airplane.addTicketA6M1(name, id, clss, pn, disc, fNum, dist, dis);	
		System.out.println("\nUpdating passenger list \n-------------------------------------------------------------\n-------------------------------------------------------------");
		
		Airplane.printA6M1();
		}
		
		
	}
	
	static public String toAdult(adult a)
	{
/*	String result =	"Name: " + NAME + "\n" +
				 "ID: "   + id   + "\n" +
				 "Gender: " + Passenger.GENDER + "\n" +
				 "Age: " + Passenger.AGE + "\n" +
				 "Reason of Travel: " + Passenger.TYPE; */
		
		String result = a.toString();
		
	return result;
	}
	
	static public String toSeniorCitizen(senior_citizen s) {
		
		String result = s.toString();
		
		return result;
	}
	
	static public String toKid(kid k) {
		
		String result = k.toString();
		
		return result;
		
	}

	
	public String toString()
	{
		
		String result;
		
		if(this.isWaiting) {
		result = "Name: " + NAME + "\n" +
				 "ID: "   + id   + "\n" +
				 "Class: " + CL + " - In Waiting List" +"\n" +
				 "Flight ID: " + flightNum + "\n" +
				 "Phone Number: " + phone + "\n" +
				 "Total Price: $" + (totalPrice - discount) + "\n" +
				 "Discount: $" + discount +"\n" +
				 "Disabilites/Requests: " + request;;
		} else{
		result = "Name: " + NAME + "\n" +
				 "ID: "   + id   + "\n" +
				 "Class: " + CL + "\n" +
				 "Flight ID: " + flightNum + "\n" +
				 "Phone Number: " + phone + "\n" +
				 "Total Price: $" + (totalPrice - discount) + "\n" +
				 "Distance: " + distance + "mi\n" +
				 "Discount: $" + discount +"\n" +
				 "Disabilites/Requests: " + request;;
		}
		
		
		return result;
		
	}
	
}