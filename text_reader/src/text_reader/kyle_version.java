package text_reader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class kyle_version {
	
    public static void main(String[] args) throws FileNotFoundException
    {	
	//FileReader fr = new FileReader("check30.txt");
	ArrayList<FileReader> fr = new ArrayList<FileReader>();
	String currentData = "";
	int numOnline = 0;
	int searchIndex = 0;
	int i=0;
	int convert = 168;
	PrintWriter out = new PrintWriter("C:\\Users\\TV\\Desktop\\tmbm\\Who online1-70.csv");
	fr.add(null); 
	
	System.out.println("A");
	for(int loopNum = 1; loopNum<90;loopNum++)
	{
		fr.add(new FileReader("C:\\Users\\TV\\Desktop\\tmbm\\Tim\\check" + loopNum + ".txt"));
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
        
        out.println(numOnline+",");
        
        numOnline = 0;
        searchIndex = 0;
        currentData = "";
        i=0;
        
        
    }
    out.close();

}
}
