package code;
import java.util.ArrayList;

public class waitingClass {

	public static ArrayList<Ticket> waitList;

	public waitingClass() {  //creates an arrayList when instantiated
		waitList = new ArrayList<Ticket>(4);
	}

	public void add(Ticket tick) {  //allows user to add person to the waiting list
		waitList.add(tick);
		tick.isWaiting = true;
	}

	public void remove(int index) {  //also allows user to remove from waiting list
		waitList.remove(index);
	}

	public void print() {  //prints the waiting list
		String result = "";
		
		System.out.println("Waiting List: " + "\n");
		for(int i = 0; i < waitList.size(); i++) {
			System.out.println(waitList.get(i) + "\n");
		}
	
	}
	
	

	public Ticket giveSeat() {  //removes passenger from the waiting list
		if (waitList.size() <= 0) {
			return null;
		}
		Ticket temp = waitList.get(0);
		waitList.remove(0);
		return temp;
	}
}
