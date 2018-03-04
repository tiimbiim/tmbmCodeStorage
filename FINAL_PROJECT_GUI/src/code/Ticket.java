package code;

public class Ticket {
	
	double discount;
	//String seat;
	String CL;
	String phone;
	String NAME;
	String id;
	double COST;
	String flightNum;
	String request;
	boolean isWaiting;
	
	public Ticket(String name, String ID, String carriage, String pn, double disco, double price, String flightN, String disability)
	{
		NAME = name;
		id = ID;
		//seat = seatNum;
		CL = carriage;
		phone = pn;
		discount = disco;
		COST = price;
		flightNum = flightN;
		request = disability;
		isWaiting = false;
	}
	
	public double getPrice()
	{
		double result;
		result = COST - discount;
		
		return result;
	}
	
	public String toPassenger(Passenger pass)
	{
/*	String result =	"Name: " + NAME + "\n" +
				 "ID: "   + id   + "\n" +
				 "Gender: " + Passenger.GENDER + "\n" +
				 "Age: " + Passenger.AGE + "\n" +
				 "Reason of Travel: " + Passenger.TYPE; */
		String result = pass.toString();
		
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
				 "Total Price: $" + (COST - discount) + "\n" +
				 "Discount: $" + discount +"\n" +
				 "Disabilites/Requests: " + request;;
		} else{
		result = "Name: " + NAME + "\n" +
				 "ID: "   + id   + "\n" +
				 "Class: " + CL + "\n" +
				 "Flight ID: " + flightNum + "\n" +
				 "Phone Number: " + phone + "\n" +
				 "Total Price: $" + (COST - discount) + "\n" +
				 "Discount: $" + discount +"\n" +
				 "Disabilites/Requests: " + request;;
		}
		
		
		return result;
		
	}
	
}
