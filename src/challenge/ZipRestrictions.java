package challenge;

import java.util.*;
import challenge.Range;

/* This is ZipRestrictions, by Steve Stilson, for Williams-Sonoma.
 * Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower
 * bounds), provide an algorithm that produces the minimum number of ranges required to represent
 * the same restrictions as the input.
 * 
 *  I've chosen a very large array of boolean values.  I consider this a more elegant solution
 *  than another solution I was considering (creating an object called "restriction" which is 
 *  compared with other instances of "restriction" by size and starting point), because
 *  creating restriction objects would require a lot of iterative IF statements.  Using an array
 *  is simpler.  Just place a flag in the appropriate slot as to whether that slot is a valid 
 *  zip code or not (after placing each inputted range into its appropriate slots).  Plus, it's
 *  a bonus that all values default to false for boolean arrays.  If true, that zip is restricted.
 *  
 *  Let's assume for now that the input comes in on the command line as a string. Append them 
 *  into range objects, with a starting point and an ending point. I'm also going to assume that 
 *  no zip codes will have dashes in them (such as nine-digit zip codes).
*/

public class ZipRestrictions
{
    
  public static void main(String[] args) {
  
    	Scanner scanner = new Scanner( System.in );
    	System.out.print("\nType some data (Hit enter to stop.): ");
		String dataIn = scanner.nextLine().trim();
		do { 
    		System.out.println(processInput(dataIn));
        	System.out.print("\nType some data (Hit enter to stop.): ");
    		dataIn = scanner.nextLine().trim();
    	} while (dataIn.length() > 0);
    	
        System.out.println("Done");	    	
    	scanner.close();
  }
  
   public static String processInput(String input) {
 
	  boolean[] zips = new boolean[100000];  // Use a fresh array each time.
	   // 	I will assume that there's at least one space between pairs.
	   //   And I'll also assume that there will be no space inside brackets.
   	  String[] items = input.split(" ");

	  List<Range> pairs = new ArrayList<Range>();
  	  for (String item : items) {
  		try {
  			Range p = new Range(item);
      		pairs.add(p);  // only add it if it's valid
  		}
  		catch (NumberFormatException e) {
  			System.out.println("Incorrect format for " + item);
  			// Go on to the next one.
  		}
  	  }
  	  // I'm handing no input, one input and infinite number of input of Ranges.
  	
  	  // Now "flatten" each range values onto the one big boolean array.
  	  int zipToMark;
  	  for (Range myPair : pairs) {
  		for (zipToMark = myPair.start; zipToMark <= myPair.end; zipToMark++ )
  		// This inner for handles gracefully any pairs where the end is less than start.
  		{
  			zips[zipToMark] = true;
  		}
  	  } 
  	
  	  // Now make a new output from the zips array.
  	  // Iterate.  When you come to the first true, append a [ and the value and a comma.
  	  // When you come to the first false after that, append that value and a ].
  	  // Repeat until done.
  	  // If you reach the end and the last char was a comma, append 99999].
  	  // If you reach the end and there's no output, print "no restrictions".

  	  StringBuilder sb = new StringBuilder("");
  	  boolean currentFlag = false;
  	  int k = 0;
  	  for (k = 0; k < 100000; k++)
  	  {
  		// System.out.println(k + " " + zips[k]);
  		if (zips[k] != currentFlag) {
  			if (zips[k] == true) {
  				// currentflag is false, but encountered a true.
  				sb.append("[").append(k).append(",");
  			}
  			else {
  				// currentflag is true, but encountered a false.
  				sb.append(k-1).append("] ");
  			}
  			currentFlag = zips[k];
  		}
  	  } // end iteration
  	  if (sb.length() < 1) { sb.append("No restrictions."); }
  	  String lastchar = String.valueOf(sb.charAt(sb.length()-1));
  	  if ( ",".equals(lastchar)) { sb.append(k-1).append("]"); }
  	
  	  return sb.toString();
  }
}
