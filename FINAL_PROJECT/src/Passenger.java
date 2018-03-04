
public abstract class Passenger {

	public static int AGE;
	public static String NAME, id, TYPE;
	public static char GENDER;

	public Passenger(String name, String ID, char gender, int age, String type) {
		NAME = name;
		id = ID;
		GENDER = gender;
		AGE = age;
		TYPE = type;
	}

	public String toString() {
		String result = "";

		result = "Name: " + NAME + "\n" + 
				"ID: " + id + "\n" + 
				"Gender: " +  GENDER + "\n" + 
				 "Age: " + AGE + "\n" + 
				"Reason for travel: " + TYPE + "\n";

		return result;

	}

}
