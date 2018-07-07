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


public class fileReader_kyle_based {

	 public static void main(String[] args) throws FileNotFoundException
	    {	
		//FileReader fr = new FileReader("check30.txt");
		ArrayList<FileReader> fr = new ArrayList<FileReader>();
		String currentData = "";
		String filename = "C:\\Users\\shingo\\Desktop\\tmbm\\Junk\\Tim\\check";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE h:mm a");
		File f;
		int numOnline = 0;
		int searchIndex = 0;
		int i=0;
		int convert = 168;
		PrintWriter out = new PrintWriter("C:\\Users\\shingo\\Desktop\\tmbm\\kyleBaseTest2.csv");
		StringBuilder sb = new StringBuilder();
		fr.add(null); 
		
		System.out.println("A");
		
		sb.append("Date");
        sb.append(',');
        sb.append("People Online");
        sb.append(',');
        sb.append("File No.");
        sb.append('\n');
		
		for(int loopNum = 1; loopNum<90;loopNum++)
		{
			fr.add(new FileReader("C:\\Users\\shingo\\Desktop\\tmbm\\Junk\\Tim\\check" + loopNum + ".txt"));
			f = new File(filename + loopNum
					+ ".txt");
        	sb.append(sdf.format(f.lastModified()));
        	sb.append(',');
        	sb.append('\n');
		}
		System.out.println("A");
	    for(int loopNum = 101; loopNum<=convert;loopNum++)
	    {
	    	
	    	try {
	    		while ((i=fr.get(loopNum-100).read()) != -1)
	    		{
	    			currentData = currentData + (char)i;
	    		}
	    		  
	    		
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        
	        //System.out.println(currentData);
	        while(currentData.indexOf("true",searchIndex) > 0)
	        {
	        	numOnline++;
	        	searchIndex = currentData.indexOf("true",searchIndex)+6;
	        }
	        System.out.println(loopNum+"Online: " +numOnline); 

	        sb.append(',');
	        sb.append(numOnline);
	        sb.append('\n');
	        
	        numOnline = 0;
	        searchIndex = 0;
	        currentData = "";
	        i=0;
		    
	    }
	    
      /*  for(int g = 1; g < 90; g++) {
        	f = new File(filename + 73 + ".txt");
        	sb.append(sdf.format(f.lastModified()));
	        sb.append(',');
	       // sb.append(numOnline);
	      //sb.append(',');
	      //sb.append(loopNum);
	        sb.append('\n');
        } */
        
        numOnline = 0;
        searchIndex = 0;
        currentData = "";
        i=0;
	    
		/*for(int g = 1; g < 90; g++) {
			f = new File(filename + 73 + ".txt");
		//	System.out.println(sdf.format(fr1.get(0).lastModified()));

		        sb.append(sdf.format(f.lastModified()));
		       sb.append(',');
		        sb.append(numOnline);
		        sb.append(',');
		        sb.append(g);
		        sb.append('\n');
		        
		}*/
	    out.write(sb.toString());
	    out.close();
	    System.out.println("Done!");

	}
}
