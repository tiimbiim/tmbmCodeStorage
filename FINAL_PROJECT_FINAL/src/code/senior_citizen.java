package code;

public class senior_citizen extends Passenger {
	
	String request;

	public senior_citizen(String name, String ID, char gender, int age, String type, String disability) {
		super(name, ID, gender, age, type);
		request = disability;
	}
	
	public String toString()
	{
		String result;
		result = super.toString();
		
		result += "Disability: " + request  + "\n *************************";
		
		return result;
	}
}
