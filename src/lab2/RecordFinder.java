
package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Michael
 */
public class RecordFinder {
    public static void main(String[] args) throws IOException {
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
        
        // Print selected record
       if(lineNum == recordWanted) {
           String[] parts = line.split("\\|");
           System.out.println("Record:\t\t" + lineNum);
           System.out.println("Name: \t\t" + parts[1] + " " + parts[0]);
           System.out.println("Address: \t" + parts[2]);
           System.out.println("\t\t" + parts[3] + ", "+parts[4] + 
                   " " + parts[5]);   
           System.out.println("Email: \t\t" + parts[7]);
           System.out.println("Phone: \t\t" + parts[6]+"\n");                  
       }   
        //Read new line
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
