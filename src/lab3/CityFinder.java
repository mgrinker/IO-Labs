package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Michael
 */
public class CityFinder {
    
    public static void main(String[] args) throws IOException {
        boolean append = true;
        int recordWanted = 2;
        
        File data = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "people.txt");
        
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
           int lineNum = 0;
	   while(line != null){
               lineNum++;
                           
               // Find city of second record
               if(lineNum == recordWanted) {
                   String[] parts = line.split("\\|");
                   System.out.println("The city of record number " + lineNum 
                           + " is " + parts[3]);
               }
         
               // Read new line
               line = in.readLine();  // strips out any carriage return chars
	   }
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {     
            }
        }
    }
}
