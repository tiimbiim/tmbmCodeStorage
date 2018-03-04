public class Airplane {

	Ticket[][] B52;
	int count = 0;

	public Airplane() {
		B52 = new Ticket[4][2];
		count = 0;
	}

	public void addTicket(String NAME, String id, String CL, String phone, int discount, int COST, String flightN, String request) {
		
		// checks for the next empty seat and if the customer has been placed in a seat
		boolean hasAdded = false;
		for (int row = 0; row < B52.length; row++) {
			for (int col = 0; col < B52[row].length; col++) {
				if(B52[row][col] == null)
				{
					B52[row][col] = new Ticket(NAME, id, CL, phone, discount, COST, flightN, request);
					hasAdded = true;
					break;
				}
			}
			if(hasAdded) {
				break;
			}

		}
	}

	public void populate(waitingClass queue) {
		for (int a = 0; a < B52.length; a++) {
			for (int b = 0; b < B52[a].length; b++) {
				B52[a][b] = queue.giveSeat();
			}
		}
	}

	public void print() {
		for (int a = 0; a < B52.length; a++) {
			for (int b = 0; b < B52[a].length; b++) {
				System.out.println(B52[a][b]);
			}
		}
	}

	public String toString() {

		String result = "Seating Status:\n----------------------------------------------\n";
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
