package code;

import java.util.Random;

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
	
	public Ticket(String name, String ID, String carriage, String pn, double disco, double price, String flightN, double dist, String disability)
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
		price = totalPrice;
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
				 "Discount: $" + discount +"\n" +
				 "Disabilites/Requests: " + request;;
		}
		
		
		return result;
		
	}
	
}
