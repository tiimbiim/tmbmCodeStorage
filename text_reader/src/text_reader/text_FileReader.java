package text_reader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class text_FileReader {
	
	
	public static String readAsString (String filename) throws Exception {
		
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(filename)));
		return data;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\TV\\Desktop\\tmbm\\laptop_test27.csv"));
        StringBuilder sb = new StringBuilder();
		
		String filename = "C:\\Users\\TV\\Desktop\\tmbm\\Tim\\check";
		
		File fr;
		String data;
		ArrayList<FileReader> fr1 = new ArrayList<FileReader>();
		String currentData = "";
		int numOnline = 0;
		int searchIndex = 0;
		int i=0;
		int convert = 168;
		
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		
		System.out.println("A");
		
		sb.append("Date");
        sb.append(',');
        sb.append("People Online");
        sb.append(',');
        sb.append("File No.");
        sb.append('\n');
		
		for (int t = 1; t < 90; t++) 
			fr1.add(new FileReader(filename + 73 + ".txt"));
		
	    for(int loopNum = 101; loopNum<=convert;loopNum++)
	    {
	    	
	    	try {
	    		while ((i=fr1.get(loopNum-100).read()) != -1)
	    		{
	    			
	    			currentData = currentData + (char)i;
	    		}
	    		  
	    		
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        
	    	  while(currentData.indexOf("true",searchIndex) > 0)
	          {
	          	numOnline++;
	          	searchIndex = currentData.indexOf("true",searchIndex)+6;
	          }
	          System.out.println(loopNum+"Online: " +numOnline);
	        //System.out.println(currentData);
		
	          sb.append(numOnline + "\n");
		        sb.append(',');
		        sb.append(numOnline);
		        sb.append(',');
		        sb.append(loopNum);
		        sb.append('\n');
	          
	          numOnline = 0;
	          searchIndex = 0;
	          currentData = "";
	          i=0;
	    }  
		
		for(int g = 1; g < 90; g++) {
			fr = new File(filename + 73 + ".txt");
		//	System.out.println(sdf.format(fr1.get(0).lastModified()));

		        sb.append(sdf.format(fr.lastModified()));
		 /*       sb.append(',');
		        sb.append(numOnline);
		        sb.append(',');
		        sb.append(g);
		        sb.append('\n');
		        */
		}
		
			pw.write(sb.toString());
	        pw.close();
	        System.out.println("done!");
		
	}

}
