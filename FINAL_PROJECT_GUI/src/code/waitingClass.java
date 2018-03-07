package code;
import java.util.ArrayList;

public class waitingClass {

	public static ArrayList<Ticket> waitList;

	public waitingClass() {
		waitList = new ArrayList<Ticket>(4);
	}

	public void add(Ticket tick) {
		waitList.add(tick);
		tick.isWaiting = true;
	}

	public void remove(int index) {
		waitList.remove(index);
	}

	public void print() {
		//System.out.println(waitList + "\n" + "Currently on waiting list");
		//System.out.println(waitList);
		
		System.out.println("Waiting List: " + "\n");
		for(int i = 0; i < waitList.size(); i++) {
			System.out.println(waitList.get(i) + "\n");
		}
	}

	public Ticket giveSeat() {
		if (waitList.size() <= 0) {
			return null;
		}
		Ticket temp = waitList.get(0);
		waitList.remove(0);
		return temp;
	}
}
