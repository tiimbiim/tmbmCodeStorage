
public class testDriver {

	public static void main(String[] args) {
		
		adult a = new adult("tim bim", "2254-3135", 'M', 37, "Vacationer", "Money Maker");
		senior_citizen b = new senior_citizen("matt k", "5531-6425", 'M', 74, "Business", "Kidney Problems");
		kid c = new kid("gia", "4224-7554", 'F', 12, "Lost", "Without Parents");
		
		Ticket d = new Ticket("tim bim", "2254-3135", "Vacation", "310-8747", 53.51, 3921, "7848D4Y7", "Needs to be in aisle");
	//	Ticket e = new Ticket("derek", "5412-9784", "Vacation", "644-5426", 0.0, 31293, "6412D432D", "N/A");
		
	// oooooof rip gia
		
		waitingClass waitList = new waitingClass();
		
		Airplane liberator = new Airplane();
		
		liberator.addTicket("timbim", "2241-5115", "Economy", "421-5456", 75, 943, "5792D4T7", "Needs to be in aisle");
		liberator.addTicket("derek", "2241-5115", "First Class", "421-5456", 75, 943, "5792D4T7", "N/A");
	//	waitList.add(a);
		//waitList.add(b);
		
		System.out.println(d.toPassenger(a));
		
		
		System.out.println(liberator.toString());
		waitList.print();
		
	}

}
