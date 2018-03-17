package code;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.MainWindow;


public class testDriver extends MainWindow {

	public static Airplane liberator;
	public static adult a = new adult("tim bim", "2254-3135", 'M', 37, "Vacation", "Money Maker");
	public static senior_citizen b = new senior_citizen("matt k", "5531-6425", 'M', 74, "Business", "Kidney Problems");
	public static kid c = new kid("gia", "4224-7554", 'F', 12, "Lost", "Without Parents");
	public static waitingClass waitList = new waitingClass();
	public static Passenger[][] passArray = new Passenger[10][10];
	
	public static void main(String[] args)
	{	
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Ticket d = new Ticket("tim bim", "2254-3135", "Vacation", "310-8747", 53.51, 3921, "7848D4Y7", 1231, "Needs to be in aisle");
		Ticket e = new Ticket("derek", "5412-9784", "Vacation", "644-5426", 0.0, 31293, "6412D432D", 123123, "N/A");
		
	//	Passenger man = new Passenger("boon","531-332", 16 , 'M', "Business");
		
	// oooooof rip gia
		
		//waitingClass waitList = new waitingClass();
		
		liberator = new Airplane();
		
		liberator.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, 943, "5792D4T7", 500, "Needs to be in aisle");
		liberator.addTicket("derek", "2241-5115", "First", "421-5456", 75, Ticket.totalPrice, "5792D4T7", 500, "N/A");
		waitList.add(d);
		waitList.add(e);
		
		//System.out.println(d.toPassenger(a));
		
		
	//	System.out.println(liberator.toString());
		waitList.print();
		
		System.out.println(Airplane.checkSeat(0,1));
		System.out.println(Airplane.checkSeat(2, 0));
		
		
		
		
		
		
	}
	
	public static String printTicket() {
		String result;
		Airplane liberator = new Airplane();
		waitingClass waitList = new waitingClass();
		liberator.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, 943, "5792D4T7", 500, "Needs to be in aisle");
		liberator.addTicket("derek", "2241-5115", "First Class", "421-5456", 75, 943, "5792D4T7", 500, "N/A");
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
