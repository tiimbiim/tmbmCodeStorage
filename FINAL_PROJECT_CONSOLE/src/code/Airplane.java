package code;

import java.util.Random;
import java.util.Scanner;

public class Airplane {

	static boolean hasAdded = false;
	
	public static Ticket[][] temp;
	public static Ticket[][] B52;
	int count = 0;

	public Airplane() {
		B52 = new Ticket[4][2];
		count = 0;
	}

	
	public void addTicket(Ticket t) {
		
	}
	public static void addTicket(String NAME, String id, String CL, String phone, double discount, int flightN, double distance, String request ) {
		
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
	
	public static String checkSeat(int seatRow, int seatCol)
	{
		String result = "";
		 System.out.println(B52[seatRow][seatCol]);
		 
		 if(B52[seatRow][seatCol] == null)
			 result = "This seat is empty";
		 else
			 result = "Seat " + seatRow + ", " + seatCol + " is taken";
		 
		 return result;
		
	}
	
	public static void checkAvailability() {
		
		Scanner scan = new Scanner(System.in);
		
		int seatRowInp, seatColInp;
		
		System.out.println("Please enter the seat row and column for the desired seat");
		
		System.out.print("Seat row: ");
		seatRowInp = scan.nextInt();
		
		System.out.print("Seat column: ");
		seatColInp = scan.nextInt();
		
		System.out.println("\n");
		
	}
	
	public static void removeFromFlight(int seatRow, int seatCol) {
		
		System.out.println(B52[seatRow][seatCol]);
		
		if(B52[seatRow][seatCol] != null)
			System.out.println("This seat is empty, nothing can be removed.");
		
		else if (B52[seatRow][seatCol] == null)
		System.out.println("Passenger in seat " + seatRow + ", " + seatCol + " has been removed.");
		
		
	}
	
	public static void removePassenger() {
		
		Scanner scan = new Scanner (System.in);
		
		int seatRowInp, seatColInp;
		
		System.out.println("Please enter the seat number of the desired passenger.");
	
		System.out.println("\nSeat Number: ");
		seatRowInp = scan.nextInt();
		
		System.out.print("\nSeat Column: ");
		seatColInp = scan.nextInt();
		
		removeFromFlight(seatRowInp, seatColInp);
		
		Airplane.print();
		
	}
	/*
	public static void removeFromFlight(int t, int v)
	{
		temp = new Ticket[10][10];
		
		for (int a = 0; a < B52.length; a++)
			for (int b = 0; b < B52[a].length; b++)
			{
				B52[t][v] = temp[a][b];
			}
		
		
	}
	*/
	
	public static int generateRandomFNum() {
		Random ran = new Random();
		int fourDigit, singleDigit;
		char singleChar;
		
		
		fourDigit = ran.nextInt(9999) + 1000;
		singleChar =  (char) ((char) ran.nextInt(25) + 65);
		singleDigit = ran.nextInt(10);
		
		return fourDigit + singleChar + singleDigit + singleChar + singleDigit;
		
	}

	public void placeInPlane(waitingClass queue) {
		for (int a = 0; a < B52.length; a++) {
			for (int b = 0; b < B52[a].length; b++) {
				B52[a][b] = queue.giveSeat();
				System.out.println("Passenger has been removed from waiting list");
			}
		}
	}

	public static void print() {
		for (int a = 0; a < B52.length; a++) {
			for (int b = 0; b < B52[a].length; b++) {
				System.out.println(B52[a][b] + "\n");
			}
		}
	}

	public String toString() {

		String result = "";
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
