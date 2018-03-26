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
	public static void addTicket(String NAME, String id, String CL, String phone, double discount, String flightN, double distance, String request ) {
		
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
		if(B52[seatRow][seatCol]==null)
			System.out.println("THIS SEAT IS NULL");
		 //System.out.println(B52[seatRow][seatCol]);
		 
		 if(B52[seatRow][seatCol] == null)
			 result = "This seat is empty";
		 else
			 result = "Seat " + seatRow + ", " + seatCol + " is taken";
		 
		 return result;
		
	}
	
	public static void removeFromFlight(int seatRow, int seatCol)
	{
		String message = "";
		 System.out.println("Removing " + B52[seatRow][seatCol]);
		 
		 if(B52[seatRow][seatCol] == null)
			 message = "Nothing to remove.";
		 else {
			 B52[seatRow][seatCol] = null;
			 message = "Removed selected customer.";
		 
		 }
		
	}
	
	public static void removePassenger() {
		
		Scanner scan = new Scanner(System.in);
		int seatColInp, seatRowInp;
		
		System.out.println("Please enter the seat row and column" );
		
		System.out.print("SeatRow: ");
		seatRowInp = scan.nextInt();
		
		System.out.print("\nSeatCol: ");
		seatColInp = scan.nextInt();
		
		Airplane.removeFromFlight(seatRowInp, seatColInp);	
	
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
	
	public static String generateFlightNumber()
	{
		Random rand = new Random();
		
		int fourDigits = 1 + rand.nextInt(9999);
		char firstChar = (char) (65 + rand.nextInt(26));
		int secondDigit = 1 + rand.nextInt(9);
		char secondChar = (char) (65 + rand.nextInt(26));
		
		return String.format("%04d%s%d%s", fourDigits, firstChar, secondDigit, secondChar);
	}
}
