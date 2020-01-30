package code;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

import gui.MainWindow;




public class Driver extends MainWindow {

	public static Airplane liberator;
	public static Airplane zero;
//	public static adult a = new adult("tim bim", "2254-3135", 'M', 37, "Vacation", "Money Maker");
//	public static senior_citizen b = new senior_citizen("matt k", "5531-6425", 'M', 74, "Business", "Kidney Problems");
	public static kid c = new kid("gia", "4224-7554", 'F', 12, "Lost", "Without Parents");
	public static waitingClass waitList = new waitingClass();
//	public static Ticket d = new Ticket("tim bim", "2254-3135", "Vacation", "310-8747", 53.51, "7848D4Y7", 1231, "Needs to be in aisle");
//	public static	Ticket e = new Ticket("derek", "5412-9784", "Vacation", "644-5426", 0.0, "6412D432D", 123123, "N/A");
	
	public static void main(String[] args)
	{	
	/*	try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		String name, id, clss, pn, fNum, dis, flight;
		int seatRow, seatCol;
		int disc, tPrice, dist;
		boolean loop = false;
		
		Scanner scan = new Scanner(System.in);
		
		liberator = new Airplane();
		zero = new Airplane();
		
		String input;
		String username, password;
		Airplane.addTicketB52("timbim", "2241-5115", "Economy", "421-5456", 75, "5792D4T7", 500, "Needs to be in aisle");
		Airplane.addTicketB52("derek", "3876-5325", "First", "471-5526", 75, "5112P4T8", 476, "N/A");
		
		Airplane.addTicketA6M1("tim man", "2313123", "First", "424-4241", 100, "32131231231", 333, "IQ is so high");
		
		
		/*
		waitList.add(d);
		waitList.add(e);
		*/
		
		System.out.print("Enter your username: ");
		username = scan.nextLine();
		System.out.print("Enter your password: ");
		input = scan.nextLine();
		
	//if(input != "")
		//	loop = true;
		
		System.out.println("\n\tWelcome, " + username);	
		
		while (input != "exit") {
		
			System.out.println("What would you like to do? Enter \n\"1\" to view ticket info\n\"2\" to move a passenger off the waiting list\n\"3\" to view the waiting list, "
				+ "\n\"4\" to purchase a ticket\n\"5\" to check a seat's availability\n\"Exit\" to exit the system");
		
				input = scan.nextLine();
		
	
		
			System.out.println("\n\n");
			
		if (input.equalsIgnoreCase("1")) {
			System.out.println(liberator.toStringB52());
			System.out.println(zero.toStringA6M1());
		}
		
		if(input.equalsIgnoreCase("2"))
		

		if(input.equalsIgnoreCase("3"))
			waitList.print();
		
		if(input.equalsIgnoreCase("4")) {
			
			Ticket.purchaseTicket();
			
			System.out.println("Would you like to purchase another ticket (y/n)?");
			input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
				Ticket.purchaseTicket();
				
			else	 
				break;
			
		}
		if(input.equalsIgnoreCase("5")) {
			
			Airplane.seatCheck();
			
			System.out.println("Would you like to purchase check another seat (y/n)?");
			input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
				Airplane.seatCheck();
				
			else	 
				break;

		}
		
		if(input.equalsIgnoreCase("exit")) 
			System.exit(0);
}	
		// oooooof rip gia
		

		
		//waitList.print();
		
		//System.out.println(Airplane.checkSeat(0,1));
		//System.out.println(Airplane.checkSeat(2, 0));
		

		
		
	}
	
	public static String printTicketB52() {
		String result;
		Airplane liberator = new Airplane();
		waitingClass waitList = new waitingClass();
		Airplane.addTicketB52("timbim", "2241-5115", "Economy", "421-5456", 75, "5792D4T7", 500, "Needs to be in aisle");
		Airplane.addTicketB52("derek", "2241-5115", "First Class", "421-5456", 75, "5792D4T7", 500, "N/A");
	    result = liberator.toString();

	     return result;
	}
	
	public static String printTicketA6M1() {
		String result;
		Airplane liberator = new Airplane();
		waitingClass waitList = new waitingClass();
		Airplane.addTicketA6M1("timbim", "2241-5115", "Economy", "421-5456", 75, "5792D4T7", 500, "Needs to be in aisle");
		Airplane.addTicketA6M1("derek", "2241-5115", "First Class", "421-5456", 75, "5792D4T7", 500, "N/A");
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
