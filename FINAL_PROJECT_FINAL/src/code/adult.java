package code;

public class adult extends Passenger {

	public String occupation;

	public adult(String name, String ID, char gender, int age, String type, String job) {
		super(name, ID, gender, age, type);
		occupation = job;
	}

	public String toString() {
		String result;
		result = super.toString();
		
		result += "Job: " + occupation + "\n *************************";

		return result;

	}

}
