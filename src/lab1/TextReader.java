
package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mgrinker
 */
public class TextReader {
    public static void main(String[] args) throws IOException {
        boolean append = true;
        
        File data = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "people.txt");
        
        // Add new record to file
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(data,append)));
        
        out.print("\nAndrews|Tippy|555 Happy Hippo Ln.|Waukesha|" 
                + "WI|53076|tAndrews@gmail.com|262-798-2145");
	out.close();
        
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
           int lineNum = 0;
	   while(line != null){
               lineNum++;
               
               //Print all lines
//               System.out.println(line);
               
               //Print all records
               System.out.println("Record:\t\t" + lineNum);
               String[] parts = line.split("\\|");
               System.out.println("Name: \t\t" + parts[1] + " " + parts[0]);
               System.out.println("Address: \t" + parts[2]);
               System.out.println("\t\t" + parts[3] + ", "+parts[4] + 
                       " " + parts[5]);   
               System.out.println("Email: \t\t" + parts[7]);
               System.out.println("Phone: \t\t" + parts[6]+"\n");              
               
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
