package code;

import java.util.Random;
import java.util.Scanner;

public class Airplane {

	static boolean hasAdded = false;
	
	public static Ticket[][] temp;
	public static Ticket[][] B52;
	public static Ticket[][] A6M1;
	int count = 0;

	public Airplane() {  //creates two arrays when instantiated
		B52 = new Ticket[4][2];
		A6M1 = new Ticket[4][2];
		count = 0;
	}

	public static void addTicketB52(String NAME, String id, String CL, String phone, int discount, String flightN, int distance, String request ) {  //adds a ticket to the b52 flight
		
		// checks for the next empty seat and if the customer has been placed in a seat
		hasAdded = false;
		for (int row = 0; row < B52.length; row++) {
			for (int col = 0; col < B52[row].length; col++) {
				if(B52[row][col] == null)
				{
					B52[row][col] = new Ticket(NAME, id, CL, phone, discount, flightN, distance, request);
					hasAdded = true;
					break;
				}
			}
			if(hasAdded) {
				break;
			}

		}
	}
	
public static void addTicketA6M1(String NAME, String id, String CL, String phone, int discount, String flightN, int distance, String request ) {  //adds ticket to the a6m1 flight
		
		// checks for the next empty seat and if the customer has been placed in a seat
		hasAdded = false;
		for (int row = 0; row < A6M1.length; row++) {
			for (int col = 0; col < A6M1[row].length; col++) {
				if(A6M1[row][col] == null)
				{
					A6M1[row][col] = new Ticket(NAME, id, CL, phone, discount, flightN, distance, request);
					hasAdded = true;
					break;
				}
			}
			if(hasAdded) {
				break;
			}

		}
	}
	
	public static String checkSeat(int seatRow, int seatCol, String flight)  //tells the user if a seat is taken or not
	{
		String result = "";
		
		if(flight.equalsIgnoreCase("liberator")) {
		 //System.out.println(B52[seatRow][seatCol]);
		 
		 if(B52[seatRow][seatCol] == null)
			 result = "This seat is empty";
		 else
			 result = "Seat " + seatRow + ", " + seatCol + " is taken";		
		}
		
	if(flight.equalsIgnoreCase("zero")) {
		//System.out.println(A6M1[seatRow][seatCol]);
		 
		 if(A6M1[seatRow][seatCol] == null)
			 result = "This seat is empty";
		 else
			 result = "Seat " + seatRow + ", " + seatCol + " is taken";	
		
	}
		
		 return result;
		
	}
	
	public static void seatCheck() {  //Allows the user to check a seat
		
		Scanner scan = new Scanner(System.in);
		
		int seatRow, seatCol;
		String flight;
		
		System.out.println("Please enter a flight (liberator, zero), row, and column");
		System.out.print("Flight: ");
		flight = scan.nextLine();
		System.out.print("Seat Row: ");
		seatRow = scan.nextInt();
		System.out.print("Seat Col: ");
		seatCol = scan.nextInt();
		
		System.out.println(Airplane.checkSeat(seatRow, seatCol, flight));
		
		
	}
	
	public static void reserveSeat() {
		
Scanner scan = new Scanner(System.in);
		
		int seatRow, seatCol;
		String flight;
		
		System.out.println("Please enter a flight (liberator, zero), row, and column");
		System.out.print("Flight: ");
		flight = scan.nextLine();
		System.out.print("Seat Row: ");
		seatRow = scan.nextInt();
		System.out.print("Seat Col: ");
		seatCol = scan.nextInt();
		
		

		if(flight.equalsIgnoreCase("liberator")) {
		 //System.out.println(B52[seatRow][seatCol]);
		 
		 if(B52[seatRow][seatCol] == null) {
			 B52[seatRow][seatCol] = new Ticket("Reserved", "Reserved", "Reserved", "Reserved", 0, "Reserved", 0, "Reserved");
		 	Airplane.printB52();
		 	System.out.println("\n\n");
		 	
		 }
		 
		 else
			 System.out.println("Seat " + seatRow + ", " + seatCol + " is already reserved or taken");
		 System.out.println("\n\n");
		 
		 
		}
		
	if(flight.equalsIgnoreCase("zero")) {
		//System.out.println(A6M1[seatRow][seatCol]);
		 
		 if(A6M1[seatRow][seatCol] == null) {
			 A6M1[seatRow][seatCol] = new Ticket("Reserved", "Reserved", "Reserved", "Reserved", 0, "Reserved", 0, "Reserved");
		 
			 Airplane.printA6M1();
			 
			 System.out.println("\n\n");
		 }
		 else 
			 System.out.println("Seat " + seatRow + ", " + seatCol + " is already reserved or taken");
		 System.out.println("\n\n");
		
		
	}
}

	public static void placeInPlane(waitingClass queue, String flight) {  //removes a passenger from the wait list and onto a plane
		
	if(flight.equalsIgnoreCase("liberator"))	{
		for (int a = 0; a < B52.length; a++) {
			for (int b = 0; b < B52[a].length; b++) {
				B52[a][b] = queue.giveSeat();
				System.out.println("Passenger has been removed from waiting list");
			}			
			}
		}
	
	if(flight.equalsIgnoreCase("zero")) {
		
		for (int a = 0; a < A6M1.length; a++) {
			for (int b = 0; b < A6M1[a].length; b++) {
				A6M1[a][b] = queue.giveSeat();
				System.out.println("Passenger has been removed from waiting list");
			}			
		}
	}
	
	}
	public static void printB52() {  //prints out the b52 flight but returns it as a void
		generateRandomFlightHeader();
		
		for (int a = 0; a < B52.length; a++) {
			for (int b = 0; b < B52[a].length; b++) {
				System.out.println(B52[a][b] + "\n");
			}
		}
	}
	
	public static void printA6M1() {  //prints out the a6m1 flight but returns it as a void
		generateRandomFlightHeader();
		
		for (int a = 0; a < A6M1.length; a++) {
			for (int b = 0; b < A6M1[a].length; b++) {
				System.out.println(A6M1[a][b] + "\n");
			}
		}
	}

	public static void generateRandomNum() {  //generates a random number for the flight ID
		Random ran = new Random();
		int fourDigit, singleDigit;
		char singleChar;
		
		fourDigit = ran.nextInt(9999) + 1000;
		singleChar = (char) (ran.nextInt(26) + 65);
		singleDigit = ran.nextInt(10);
	
		System.out.print(singleDigit);
		
	}
	
	public static void generateRandomLetter() {  //Generates a random letter for the flight ID
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alpha = alphabet.toCharArray();

        int pos = (int)(Math.random()* 26);

        System.out.print(alpha[pos]);
		
	}
	
	public static void generateDestination() {  //generates a random destination which is printed in front after the flight number
		
		Random ran = new Random();
		int selector;
		String result = " to ";
		
		selector = ran.nextInt(15);
		
		if(selector == 0)
			result += "Adelaide, Australia\n";
		
		if(selector == 1)
			result += "Kure, Japan\n";
		
		if(selector == 2)
			result += "Saigon, Vietnam\n";
		
		if(selector == 3)
			result += "Stalingrad, Russia\n";
		
		if(selector == 4)
			result += "Berlin, Germany\n";
		
		if(selector == 5)
			result += "London, UK\n";
		
		if(selector == 6)
			result += "The Shokaku (Carrier Landing)\n";
		
		if(selector == 7)
			result += "USS Midway (Carrier Landing)\n";
		
		if(selector == 8)
			result += "The Kaga (Carrier Landing)\n";
		
		if(selector == 9)
			result += "The USS Nimitz (Carrier Landing)\n";
		
		if(selector == 10)
			result += "The Akagi (Carrier Landing)\n";
		
		if(selector == 11)
			result += "Yokota Air Base\n";
		
		if(selector == 12)
			result += "Landsberg-Lech Air Base\n";
		
		if(selector == 12)
			result += "McGuire Air Force Base\n";
		
		if(selector == 13)
			result += "Busan, Korea";
		
		if(selector == 14)
			result += "Warsaw, Poland\n";
		
		
		System.out.print(result);
		
		
	}
	
	public static void generateRandomFNum() {  //Generates the whole flight number
		System.out.print("Flight ");
		generateRandomNum();
		generateRandomNum();
		generateRandomNum();
		generateRandomNum();
		generateRandomLetter();
		generateRandomNum();
		generateRandomLetter();
		generateRandomNum();
		
	}
	
	public static void generateRandomFlightHeader() {  //generates the whole flight number + the destination
		System.out.print("\tFlight ");
		
		generateRandomNum();
		generateRandomNum();
		generateRandomNum();
		generateRandomNum();
		generateRandomLetter();
		generateRandomNum();
		generateRandomLetter();
		generateRandomNum();
		
		generateDestination();
		
}

	//The following two methods print out both flights

public String toStringA6M1() {

	String result = "";
	generateRandomFlightHeader();
			result += "\n";
	for (int row = 0; row < A6M1.length; row++) {
		for (int col = 0; col < A6M1[row].length; col++) {
			result += "Passenger info:  " + A6M1[row][col];
			result += "\n" + "Seat number: " + "row " + row + ", seat " + col
					+ "\n--------------------------------------------------\n";
		}
	}

	return result;
}
public String toStringB52() {

	String result = "";
	generateRandomFlightHeader();
			result += "\n";
	for (int row = 0; row < B52.length; row++) {
		for (int col = 0; col < B52[row].length; col++) {
			result += "Passenger info: " + B52[row][col];
			result += "\n" + "Seat number: " + "row " + row + ", seat " + col
					+ "\n--------------------------------------------------\n";
		}
	}

	return result;
}
}
