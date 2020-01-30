package text_reader;
import java.nio.file.*;

public class text_Java {
	
	public static String readAsString (String filename) throws Exception {
		
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(filename)));
		return data;
	}
	
	public static void main (String[] args) throws Exception {
		
		String data = readAsString("C:\\Users\\shingo\\Desktop\\tmbm\\text\\test.txt");
		System.out.println(data);
	}

}
