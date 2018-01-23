package challenge;

/* I've chosen a very large array of boolean values.  I consider this a more elegant solution than another solution I was considering (creating an object called "restriction" which is compared with other instances of "restriction" by size and starting point), because creating restriction objects would require a lot of iterative IF statements.  Using an array is simpler.  Just place a flag in the appropriate slot as to whether that slot is a valid zip code or not (after placing each iteration over the appropriate slots).  Plus, it's a bonus that all values default to false for boolean arrays.

Let's assume for now that the input comes in on the command line as a string.  Put them into pairs, with a starting point and an ending point.
*/

// all values default to false.  If true, that zip is restricted.

public class zipRestrictions
{
  public static void main(String[] args) {
    boolean[] array = new boolean[100001];
  } 
}
