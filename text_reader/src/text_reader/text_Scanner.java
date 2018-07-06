package text_reader;
import java.io.File;
import java.util.Scanner;


public class text_Scanner {

	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\shingo\\Desktop\\tmbm\\text\\test.txt");
		
		Scanner bim = new Scanner(file);
		
		while (bim.hasNextLine());
		System.out.println(bim.nextLine());
		
		
	}
	
}
