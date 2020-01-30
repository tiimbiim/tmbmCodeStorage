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
	
	public static waitingClass waitList = new waitingClass();

	
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
		Ticket bob = new Ticket("Bob Sedofic", "3217-8762", "Business", "332-8921", 50, "3123L5O6", 300, "n/a");
		Airplane.addTicketB52("timbim", "2241-5115", "Economy", "421-5456", 75, "5792D4T7", 500, "Needs to be in aisle");  //adds a passenger to flight b52
		Airplane.addTicketB52("derek", "3876-5325", "First", "471-5526", 75, "5112P4T8", 476, "N/A");  //adds another passenger to flight b52
		
		Airplane.addTicketA6M1("tim man", "2313123", "First", "424-4241", 100, "32131231231", 333, "IQ is so high");  //adds passenger to flight a6m1
		
		waitList.add(bob);
		
		System.out.print("Enter your username: ");
		username = scan.nextLine();                               //both of these are just cosmetic details
		System.out.print("Enter your password: ");    
		input = scan.nextLine();
		
		
		System.out.println("\n\tWelcome, " + username);	
		
		while (input != "exit") {
		
			System.out.println("What would you like to do? Enter \n\"1\" to view ticket info\n\"2\" to view the waiting list, "
							 + "\n\"3\" to purchase a ticket\n\"4\" to check a seat's availability\n\"5\" to reserve a seat"
							 + "\n\"Exit\" to exit the system");
		
				input = scan.nextLine();
		
	
		
			System.out.println("\n\n");
			
		if (input.equalsIgnoreCase("1")) {
			System.out.println(liberator.toStringB52());
			System.out.println(zero.toStringA6M1());
		}
		
		if(input.equalsIgnoreCase("2"))
			waitList.print();
		
		if(input.equalsIgnoreCase("3")) {
			
			Ticket.purchaseTicket();
			
			System.out.println("Would you like to purchase another ticket (y/n)?");
			input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
				Ticket.purchaseTicket();
				
			else	 
				break;
			
		}
		if(input.equalsIgnoreCase("4")) {
			
			Airplane.seatCheck();
			
			System.out.println("Would you like to check another seat (y/n)?");
			input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
				Airplane.seatCheck();
				
			else	 
				break;

		}
		
		if(input.equalsIgnoreCase("5")) {
			
			Airplane.reserveSeat();
			
		}
		
		if(input.equalsIgnoreCase("exit")) 
			System.exit(0);
}		
	}
}
