package code;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

import gui.MainWindow;




public class testDriver extends MainWindow {

	public static Airplane liberator;
	public static adult a = new adult("tim bim", "2254-3135", 'M', 37, "Vacation", "Money Maker");
	public static senior_citizen b = new senior_citizen("matt k", "5531-6425", 'M', 74, "Business", "Kidney Problems");
	public static kid c = new kid("gia", "4224-7554", 'F', 12, "Lost", "Without Parents");
	public static waitingClass waitList = new waitingClass();
	public static Ticket d = new Ticket("tim bim", "2254-3135", "Vacation", "310-8747", 53.51, "7848D4Y7", 1231, "Needs to be in aisle");
	public static	Ticket e = new Ticket("derek", "5412-9784", "Vacation", "644-5426", 0.0, "6412D432D", 123123, "N/A");
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
		
		Airplane.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, "5792D4T7", 500.8, "Needs to be in aisle");
		Airplane.addTicket("derek", "3876-5325", "First", "471-5526", 75, "5112P4T8", 476.17, "N/A");
		
		waitList.add(d);
		waitList.add(e);
		
		
		System.out.print("Enter your username: ");
		username = scan.nextLine();
		System.out.print("Enter your password: ");
		input = scan.nextLine();
		
		if(input != "")
			loop = true;
		
		System.out.println("\n\t\tWelcome user");	
		
		
		System.out.println("What would you like to do? Enter \"Ticket Info\" to view ticket info, \"Passenger Info\" to view passenger info, \"Wait List Info\" to view the waiting list, "
				+ "\n\"Purchase a Ticket\" to purchase a ticket, or \"Check a seat\" to check a seat's availability");
		
		input = scan.nextLine();
		
		while (input != "" && loop == true) {
		
		if (input.equalsIgnoreCase("ticket info")) 
			System.out.println(liberator.toString());
		
		else if(input.equalsIgnoreCase("passenger info"))
			System.out.print(toAdult(a));

		else if(input.equalsIgnoreCase("wait list info"))
			waitList.print();
		
		else if(input.equalsIgnoreCase("purchase a ticket")) {
			
			Ticket.purchaseTicket();
			
			System.out.println("Would you like to purchase another ticket (y/n)?");
			input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
				Ticket.purchaseTicket();
				
			else	 
				System.exit(0);
			
		}
		
		if(input.equalsIgnoreCase("check a seat")) {
			System.out.println("Please enter a seat row and column");
			seatRow = scan.nextInt();
			seatCol = scan.nextInt();
			
			System.out.println(Airplane.checkSeat(seatRow, seatCol));
			
		}
		
		else 
			System.exit(0);
}	
		// oooooof rip gia
		

		
		//waitList.print();
		
		//System.out.println(Airplane.checkSeat(0,1));
		//System.out.println(Airplane.checkSeat(2, 0));
		

		
		
	}
	
	public static String printTicket() {
		String result;
		Airplane liberator = new Airplane();
		waitingClass waitList = new waitingClass();
		liberator.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, "5792D4T7", 500, "Needs to be in aisle");
		liberator.addTicket("derek", "2241-5115", "First Class", "421-5456", 75, "5792D4T7", 500, "N/A");
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
