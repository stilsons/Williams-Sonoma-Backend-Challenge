package challenge;

public class Range {
	int start;
	int end;
	
	// no-argument constructor
	Range() {
		start = 0;
		end = 0;
	}
	
	// constructor
	Range(String incoming) {
		// Get rid of the brackets.
		String stripped = incoming.replace("[","").replace("]", "");
		String[] values = new String[2];
		values = stripped.split(",");
		start = Integer.parseInt(values[0]);
		if (start > 999999) { start = 0; }	// handles numbers that are too big.
		end = Integer.parseInt(values[1]);
		if (end > 999999) { end = 0; }
		// if there's an error with parseInt, the parent class will handle it.
	}
	
}
