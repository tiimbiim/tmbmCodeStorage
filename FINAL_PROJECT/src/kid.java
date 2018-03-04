
public class kid extends Passenger {

	public String guardian;

	public kid(String name, String ID, char gender, int age, String type, String parent) {
		super(name, ID, gender, age, type);
		guardian = parent;
	}

	public String toString() {
		String result;
		result = super.toString();
		result += "Traveling w/ Parent: " + guardian + "\n *************************";
		return result;

	}

}
