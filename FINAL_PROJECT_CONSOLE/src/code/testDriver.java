package code;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

import gui.MainWindow2;




public class testDriver extends MainWindow2 {

	public static Airplane liberator;
	public static adult a = new adult("tim bim", "2254-3135", 'M', 37, "Vacation", "Money Maker");
	public static senior_citizen b = new senior_citizen("matt k", "5531-6425", 'M', 74, "Business", "Kidney Problems");
	public static kid c = new kid("gia", "4224-7554", 'F', 12, "Lost", "Without Parents");
	public static waitingClass waitList = new waitingClass();
	public static Ticket d = new Ticket("tim bim", "2254-3135", "Vacation", "310-8747", 53.51, Airplane.generateRandomFNum(), 1231, "Needs to be in aisle");
	public static	Ticket e = new Ticket("derek", "5412-9784", "Vacation", "644-5426", 0.0, Airplane.generateRandomFNum(), 123123, "N/A");
	public static Passenger[][] passArray = new Passenger[10][10];
	
	public static void main(String[] args)
	{	
	/*	try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		String name, id, clss, pn, fNum, dis;
		int seatRow, seatCol;
		int disc, tPrice, dist;
		boolean loop = false;
		
		Scanner scan = new Scanner(System.in);
		
		liberator = new Airplane();
		
		String input;
		String username, password;
		
		Airplane.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, Airplane.generateRandomFNum(), 500.8, "Needs to be in aisle");
		Airplane.addTicket("derek", "3876-5325", "First", "471-5526", 75, Airplane.generateRandomFNum(), 476.17, "N/A");
		
		waitList.add(d);
		waitList.add(e);
		
		
		System.out.print("Enter your username: ");
		username = scan.nextLine();
		System.out.print("Enter your password: ");
		input = scan.nextLine();

		
		System.out.println("\n\tWelcome user " + username);	
		
		while ( !input.equalsIgnoreCase("exit")) {
			
			System.out.println("What would you like to do? Enter "
					+ "\n\"1\" - view ticket info "
					+ "\n\"2\" - view passenger info "
					+ "\n\"3\" - view the waiting list "
					+ "\n\"4\" - purchase a ticket "
					+ "\n\"5\" - check a seat's availability "
					+ "\n\"6\" - remove a passenger " 
					+ "\n\"exit\" to exit the program");
			
			input = scan.nextLine();
			System.out.println("\n\n");
			
			
		if (input.equalsIgnoreCase("1")) 
			System.out.println(liberator.toString() + "\n");
		
		else if(input.equalsIgnoreCase("2"))
			System.out.print(toAdult(a) + "\n");

		else if(input.equalsIgnoreCase("3"))
			waitList.print();
		
		else if(input.equalsIgnoreCase("4")) {
			
			Ticket.purchaseTicket();
			
			System.out.println("Would you like to purchase another ticket (y/n)?");
			input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
				Ticket.purchaseTicket();
				
			else	 
				System.exit(0);
			
		}
		
		if(input.equalsIgnoreCase("5")) {
			
			int seatRowInp, seatColInp;
			
			System.out.println("Please enter the seat row and column for the desired seat");
			
			System.out.print("Seat row: ");
			seatRowInp = scan.nextInt();
			
			System.out.print("Seat column: ");
			seatColInp = scan.nextInt();
			
			System.out.println("\n");
			
			Airplane.checkSeat(seatRowInp, seatColInp);
			
			System.out.println("\n");
			
		}
		
		if(input.equalsIgnoreCase("6")) {
			Airplane.removePassenger();
			
			System.out.println("Would you like to remove another passenger?");
			if(input.equalsIgnoreCase("y"))
				Ticket.purchaseTicket();
			else
				System.exit(0);
			
		}
			
		
		else {
		}
			

}	
		// oooooof rip gia
		

		
		//waitList.print();
		
		//System.out.println(Airplane.checkSeat(0,1));
		//System.out.println(Airplane.checkSeat(2, 0));
		
System.out.println("GoodBye, " + username);
		
		
	}
	
	public static String printTicket() {
		String result;
		Airplane liberator = new Airplane();
		waitingClass waitList = new waitingClass();
		liberator.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, Airplane.generateRandomFNum(), 500, "Needs to be in aisle");
		liberator.addTicket("derek", "2241-5115", "First Class", "421-5456", 75, Airplane.generateRandomFNum(), 500, "N/A");
	    result = liberator.toString();

	     return result;
	}
	
	static public String toAdult(adult ad)
	{
		
		String result = ad.toString();
		
		return result;
	}
	
	static public String toKid(kid k)
	{
		
		String result = k.toString();
		
		return result;
	}
	
	static public String toSenior(senior_citizen sc)
	{
		
		String result = sc.toString();
		
		return result;
	}
}
